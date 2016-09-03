package com.touchableheroes.rxspace;

public class App {
	
	App() {
//		Scope s = RootScopeFactory.scope(); // erstellt ein Singleton, wenn nicht vorhanden.
								//factory().create();
	}
	
	
	class MyObj {
		
		public MyObj() {
			
			Scope root = RootScopeFactory.root();
			
			// Fehler: parent und this dürfen nicht gleiche instanz sein.
			ScopeBinder binder = RootScopeFactory
				.factory()
				.parent( this ) 
				// oder factory( this ), wobei kind und vater dürfen nie this bilden.
				// was ist mit Zyklen?
				.bind( this );
				
				binder.onChange( MyKey.KEY1, new OnChangeEntry() {
					
				});

				// Kurze Transaktion: mit synchronized?
				binder.change( MyKey.KEY1, Integer.class );
				
				binder.change( MyKey.KEY1, new ScopeTX() {
					 
					public void commit(final TXOperations tx) {
						tx.change( MyKey.KEY1, Integer.class );
					}
				});
				
				// an ende wird der Scope nach der TX angepasst.
				
				
			
//			RootScopeFactory.scope(MyObj.class).get(MyKey.KEY1);
//			
//			ScopeBinder b = RootScopeFactory.bind(MyObj.class)
//					b.onChange( MyKey.KEY1, ... );
		}
		
		@Override
		protected void finalize() throws Throwable {
			// b.commitAndRelease();
			
			super.finalize();
			
		}
	}

}
