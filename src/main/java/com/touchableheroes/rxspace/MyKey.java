package com.touchableheroes.rxspace;

public enum MyKey implements ScopeKey {

	KEY1( Integer.class, 0 ), 
	
	KEY2( String.class, "test-string" );
	
	// ------------------------------------------------------------
	// Implementation
	// ------------------------------------------------------------
	private Class type;
	private Object defaultValue;

	<T> MyKey( Class<T> type,
			T defaultValue) {
		this.type = type;
		this.defaultValue = defaultValue;
	}

	public Class returnType() {
		return type;
	}


	@SuppressWarnings("unchecked")
	public <T> T defaultValue() {
		return (T) defaultValue;
	}
	
}
