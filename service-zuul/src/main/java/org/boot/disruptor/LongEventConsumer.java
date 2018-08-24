package org.boot.disruptor;

import com.lmax.disruptor.EventHandler;

public class LongEventConsumer implements EventHandler<LongEvent>{

	@Override
	public void onEvent(LongEvent longEvent, long arg1, boolean arg2) throws Exception {
		 System.out.println(longEvent.getValue()); 
	}

}
