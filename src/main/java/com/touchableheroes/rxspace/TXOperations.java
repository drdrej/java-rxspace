package com.touchableheroes.rxspace;

public interface TXOperations {

	public void change(
			ScopeKey key, 
			Object value);

	public void reset(ScopeKey key);

}
