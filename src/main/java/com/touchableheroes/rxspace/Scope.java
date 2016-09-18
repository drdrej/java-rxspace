package com.touchableheroes.rxspace;

import java.util.ArrayList;
import java.util.HashMap;

public class Scope {

	private HashMap<ScopeKey, Object> map = new HashMap<ScopeKey, Object>();
	
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

}
