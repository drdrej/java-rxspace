package com.touchableheroes.rxspace;

public interface ScopeKey {
	
//	@SuppressWarnings("unchecked")
	public Class returnType();
	
	public <T> T defaultValue();

}
