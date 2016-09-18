package com.touchableheroes.rxspace.scopes.meta;

public interface ScopeKey {
	
//	@SuppressWarnings("unchecked")
	public Class returnType();
	
	public <T> T defaultValue();

}
