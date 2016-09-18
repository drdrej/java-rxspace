package com.touchableheroes.rxspace.scopes;

import java.util.HashMap;

import com.touchableheroes.rxspace.scopes.meta.ScopeKey;

public class HashBasedScope implements Scope {

	private HashMap<ScopeKey, Object> map = new HashMap<ScopeKey, Object>();
	
	private Scope parent;
	
	public HashBasedScope(final Scope parent) {
		this.parent = parent;
	}
	
	public Object init(
			final ScopeKey key) {
		final Object rval = key.defaultValue();
		map.put(key, rval);
		
		return rval;
	}

	public boolean has(
			final ScopeKey key) {
		return map.containsKey(key);
	}

	@SuppressWarnings("unchecked")
	public <T> T get(
			final ScopeKey key) {
		return (T) map.get(key);
	}

	public void set(ScopeKey key, Object newValue) {
		this.map.put(key, newValue);
	}
	
	public Scope parent() {
		return parent;
	}
	
}
