package com.touchableheroes.rxspace;

public interface ScopeFactory {
	
	/**
	 * Access to ScopeBinder.
	 * 
	 * @return
	 */
	public ScopeBinder binder(Object boundTo);
}
