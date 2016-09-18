package com.touchableheroes.rxspace.example;

import com.touchableheroes.rxspace.OnChangeEntry;
import com.touchableheroes.rxspace.RootScopeFactory;
import com.touchableheroes.rxspace.ScopeBinder;
import com.touchableheroes.rxspace.scopes.HashBasedScope;
import com.touchableheroes.rxspace.scopes.Scope;
import com.touchableheroes.rxspace.tx.ScopeTX;
import com.touchableheroes.rxspace.tx.TXOperations;

public class App {
	
	
	public static void main(String[] args) {
		MyObj myObj = new MyObj();
	}
	
	
	
	static class MyObj {		
		ScopeBinder binder = new ScopeBinder( new HashBasedScope() );
		
		public MyObj() {
			final Scope root = RootScopeFactory.root();

			// was ist mit Zyklen?
			binder = RootScopeFactory
				.factory()
				.binder( this );
				
				binder.onChange( MyKey.KEY1, new OnChangeEntry<Integer>() {
					
					public void doAfter(final TXOperations ops) {
						System.err.println( ">>> after changed" );						
						
						ops.change( MyKey.KEY2, "simple-string-value" );
					}

					public Integer onChange(
							final Enum key, 
							final Integer newValue, 
							final Integer olbValue) {
						System.err.println( ">>> on change: is possible to modify value before set." );
						return newValue;												
					}

				});
				
				// Kurze Transaktion: mit synchronized?
				binder.change( MyKey.KEY1, 10 ); // --> key: Type in sorted Array oder fast hashmap? auch hier intern tx. ist nur eine einfache schreibweise. wobei hier auch direkt synchronized gesetzt werden kann
				
				binder.change( MyKey.KEY1, new ScopeTX() {
					 
					public void commit(final TXOperations tx) {
						tx.change( MyKey.KEY1, 1 );
					}
				});
		}
		
		@Override
		protected void finalize() throws Throwable {
			binder.release();
			
			super.finalize();
			
		}
	}

}
