package com.boot.Disruptor;

import com.lmax.disruptor.EventHandler;

public class Handler2 implements EventHandler<Trade>{

	@Override
	public void onEvent(Trade event, long sequence, boolean endOfBatch) throws Exception {
		 long threadId = Thread.currentThread().getId();     // 获取当前线程id
	        String id = event.getId();                          // 获取订单号
	        System.out.println(String.format("%s：Thread Id %s 订单信息 %s 发送到 karaf 系统中 ....",
	                this.getClass().getSimpleName(), threadId, id));
		
	}
}
