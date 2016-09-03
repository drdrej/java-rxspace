package com.touchableheroes.rxspace;

public interface ScopeFactory {


	/**
	 * Method f. direct access to scope.
	 * in most cases binder should be used.
	 */
	public Scope scope(Object boundTo);
	
	/**
	 * Access to ScopeBinder.
	 * 
	 * @return
	 */
	public ScopeBinder bind(Object boundTo);
}
