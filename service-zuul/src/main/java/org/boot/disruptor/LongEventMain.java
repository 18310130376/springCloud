package org.boot.disruptor;

import java.nio.ByteBuffer;
import java.util.concurrent.Executors;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

public class LongEventMain {
	public static void main(String[] args) throws Exception {
        //1. 创建disruptor
        Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>( // (1)
            new LongEventFactory(),             // 创建工厂
            1024 * 1024,                        // RingBuffer 大小，必须是2的N次方
            Executors.defaultThreadFactory(),   // 线程池
            ProducerType.SINGLE,                // 单个生产者，如果有多个生产者必须使用 ProducerType.MULTI
            new YieldingWaitStrategy()          // 生产者和消费者的平衡策略
        );

        //2. 连接消费事件方法
        disruptor.handleEventsWith(new LongEventConsumer());
        //3. 启动
        disruptor.start();

        //4. 发布事件
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

        LongEventProducerWithTranslator producer = new LongEventProducerWithTranslator(ringBuffer);
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        for(long l = 0; l<1000000; l++){
            byteBuffer.putLong(0, l);
            producer.onData(byteBuffer);
        }

        disruptor.shutdown();//关闭 disruptor，方法会堵塞，直至所有的事件都得到处理；
    }
}
