package com.touchableheroes.rxspace;

public class ScopeTXController {

	private Scope scope;

	public ScopeTXController( Scope src ) {
		this.scope = src;
	}
	
	public void exec(ScopeTX scopeTX) {
		TXOperations txops = new TXOperations();
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
