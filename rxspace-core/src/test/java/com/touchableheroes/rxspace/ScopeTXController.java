package com.touchableheroes.rxspace;

import java.util.Map;
import java.util.TreeMap;

import com.touchableheroes.rxspace.scopes.Scope;
import com.touchableheroes.rxspace.tx.ScopeTX;
import com.touchableheroes.rxspace.tx.TXOperations;
import com.touchableheroes.rxspace.tx.TXOperations.Commitable;

public class ScopeTXController {

	private Scope scope;

	public ScopeTXController( 
			final Scope src ) {
		this.scope = src;
	}
	
	public void exec(
			final ScopeTX scopeTX) {
		final TXOperations txOps = TXOperations.Factory.createTX(scopeTX); 
		
		try {
			scopeTX.commit( txOps );
			commit(txOps);
		} catch (final Throwable e) {
			rollback(txOps);
		}
	}

	private void rollback(final TXOperations txops) {
		
	}

	private void commit(final TXOperations txops) {
//		txops.
//		TXOperations.Factory.
		// scope.set(txops.);
	}

}
