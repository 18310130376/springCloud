package com.boot.Disruptor;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.lmax.disruptor.BusySpinWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.EventHandlerGroup;
import com.lmax.disruptor.dsl.ProducerType;

public class Main {
	public static void main(String[] args) throws InterruptedException {

		long beginTime = System.currentTimeMillis();
		int bufferSize = 1024;
		ExecutorService executor = Executors.newFixedThreadPool(8);

		Disruptor<Trade> disruptor = new Disruptor<>(new EventFactory<Trade>() {
			@Override
			public Trade newInstance() {
				return new Trade();
			}
		}, bufferSize, executor, ProducerType.SINGLE, new BusySpinWaitStrategy());

		//1执行2执行有顺序
		EventHandlerGroup<Trade> handlerGroup = disruptor.handleEventsWith(new Handler1()).handleEventsWith(new Handler2());
		//new Handler1() new Handler2()没有顺序
		//EventHandlerGroup<Trade> handlerGroup = disruptor.handleEventsWith(new Handler1(), new Handler2());
		// 声明在C1,C2完事之后执行JMS消息发送操作 也就是流程走到C3
		handlerGroup.then(new Handler3());
		
		// 多个消费者不重复消费
//		Handler3[] customers = new Handler3[]{new Handler3(), new Handler3()};
//		handlerGroup.thenHandleEventsWithWorkerPool(customers);

		disruptor.start();// 启动
		CountDownLatch latch = new CountDownLatch(1);
		// 生产者准备
		executor.submit(new TradePublisher(latch, disruptor));

		latch.await();// 等待生产者完事.
		disruptor.shutdown();
		executor.shutdown();
		System.out.println("总耗时:" + (System.currentTimeMillis() - beginTime));
	}
}
