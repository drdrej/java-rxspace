package com.touchableheroes.rxspace;

public interface ScopeFactory {
	
	/**
	 * Access to ScopeBinder.
	 * 
	 * @return
	 */
	public Scope binder(Object boundTo);
}
