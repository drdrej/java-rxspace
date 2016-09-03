package com.touchableheroes.rxspace;

import java.util.Map;
import java.util.TreeMap;

public class ScopeTXController {

	private Scope scope;

	public ScopeTXController( Scope src ) {
		this.scope = src;
	}
	
	public void exec(ScopeTX scopeTX) {
		TXOperations txops = new TXOperations() {

			Map<ScopeKey, Object> values = new TreeMap<ScopeKey, Object>();
			
			public void change(
					ScopeKey key, 
					Object  value) {
				
				// check if value is accepted
				
				// accept value
				values.put(key, value);
			}

			public void reset(ScopeKey key) {
				values.remove(key);
			}
			
		};
		try {
			scopeTX.commit( txops );
			commit(txops);
		} catch (final Throwable e) {
			rollback(txops);
		}
	}

	private void rollback(TXOperations txops) {
		// TODO Auto-generated method stub
		
	}

	private void commit(TXOperations txops) {
		// TODO Auto-generated method stub
		
	}

}
