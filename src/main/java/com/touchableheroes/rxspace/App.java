package com.touchableheroes.rxspace;


public class App {
	
	
	public static void main(String[] args) {
		MyObj myObj = new MyObj();
	}
	
	
	
	static class MyObj {
		
		public MyObj() {
			
			Scope root = RootScopeFactory.root();

			// .factory()
			// .parent( this ) 
			// oder factory( this ), wobei kind und vater dürfen nie this bilden.
			// was ist mit Zyklen?
			// möglicher Fehler: parent und this dürfen nicht gleiche instanz sein.
			
			ScopeBinder binder = RootScopeFactory
				.factory()
				.binder( this );
				
				binder.onChange( MyKey.KEY1, new OnChangeEntry<Integer>() {

					public void doAfter(TXOperations ops) {
						System.err.println( ">>> after changed" );						
					}

					public Integer on(Enum key, Integer newValue, Integer olbValue) {
						System.err.println( ">>> on change" );
						return newValue;												
					}

				});
				
				// Kurze Transaktion: mit synchronized?
				binder.change( MyKey.KEY1, 10 );
				
				binder.change( MyKey.KEY1, new ScopeTX() {
					 
					public void commit(final TXOperations tx) {
						tx.change( MyKey.KEY1, 1 );
					}
				});
		}
		
		@Override
		protected void finalize() throws Throwable {
			RootScopeFactory
					.factory()
					.binder( this )
					.release();
			
			super.finalize();
			
		}
	}

}
