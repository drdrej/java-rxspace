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
					
					public void doAfter(final TXOperations ops) {
						System.err.println( ">>> after changed" );						
						
						ops.change( MyKey.KEY2, "simple-string-value" );
					}

//					@Override
//					public OnChangeEntry when(Condition condition) {
//						// TODO Auto-generated method stub
//						return null;
//					}

					public Integer onChange(
							final Enum key, 
							final Integer newValue, 
							final Integer olbValue) {
						System.err.println( ">>> on change: is possible to modify value before set." );
						return newValue;												
					}

				}
				
				/*.when(new Condition() {

					public boolean match(Asserts asserts) {
						// TODO Auto-generated method stub
						return false;
					}
					
					// .consistency()
				} )*/
				);
				
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
			RootScopeFactory
					.factory()
					.binder( this )
					.release();
			
			super.finalize();
			
		}
	}

}
