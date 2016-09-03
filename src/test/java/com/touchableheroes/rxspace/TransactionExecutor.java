package com.touchableheroes.rxspace;

public class TransactionExecutor {

	private Scope scope;

	public TransactionExecutor( Scope src ) {
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
