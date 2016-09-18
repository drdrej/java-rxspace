package com.touchableheroes.rxspace.scopes;

import com.touchableheroes.rxspace.scopes.meta.ScopeKey;

public interface Scope {

	public Object init(final ScopeKey key);

	public boolean has(final ScopeKey key);

	public <T> T get(final ScopeKey key);
	
	public void set(final ScopeKey key, final Object newValue);

}
