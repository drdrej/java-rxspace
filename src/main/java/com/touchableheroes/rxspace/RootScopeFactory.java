package com.touchableheroes.rxspace;

/**
 * Is a root scope.
 * 
 * Has only a reference to an application-scope.
 * 
 * @author asiebert
 */
public class RootScopeFactory implements ScopeFactory { 

	private static RootScopeFactory SINGLETON = new RootScopeFactory();
	
	private Scope root = new Scope();
	private Scopes all = new Scopes();
	
	public static Scope root() {
		return SINGLETON.root;
	}
	
	public static RootScopeFactory factory() {
		return SINGLETON;
	}
	
	public ScopeFactory parent( 
			final Object component ) {

		// wird als parent benutzt.
		Scope found = all.find(component);
		
        return new ScopeFactory() {
        	
        	// erstellt falls nicht vorhanden bzw gibt einen Unterscope zurück
        	public Scope scope(Object boundTo)  {
        		return null;
        	}

			public ScopeBinder binder(Object boundTo) {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}

	public Scope scope(Object boundTo) {
		return root;
	}

	public ScopeBinder binder(Object boundTo) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	
}
