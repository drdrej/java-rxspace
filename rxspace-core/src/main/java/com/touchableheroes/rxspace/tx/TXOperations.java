package com.touchableheroes.rxspace.tx;


import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.touchableheroes.rxspace.scopes.Scope;
import com.touchableheroes.rxspace.scopes.meta.ScopeKey;
import com.touchableheroes.rxspace.tx.TXOperations.Commitable;

public interface TXOperations {

	public void change(
			final ScopeKey key, 
			final Object value);

	public void reset(final ScopeKey key);
	
	
	public interface Commitable {
		public void commit( final Scope scope );
		public void rollback();
	}   
	
	
	public class Factory {
		
		public static final TXOperations createTX( 
				final ScopeTX tx ) {
			final HashMapBasedTXOperation rval = new HashMapBasedTXOperation();
			return rval;
		}
		
		public void commit(final TXOperations txops, final Scope scope) {
				if( txops instanceof Commitable ) {
					((Commitable) txops).commit(scope);
				} else {
					throw new UnsupportedOperationException( "needs to be " + Commitable.class.getName() );
				}   	
		}
	}
	
	class HashMapBasedTXOperation 
		implements TXOperations, Commitable {
	
			final Map<ScopeKey, Object> map = new TreeMap<ScopeKey, Object>();
			
			public void change(
					final ScopeKey key, 
					final Object  value) {
				map.put(key, value);
			}
	
			public void reset(
					final ScopeKey key) {
				map.remove(key);
			}

			public void commit( final Scope scope ) {
				final Set<ScopeKey> keySet = map.keySet();
				for (final ScopeKey key : keySet) {
					scope.set(key, map.get(key));
				}
				
				// synchronize
				// notify!
			}

			public void rollback() {
				map.clear();
			}
		};


}
