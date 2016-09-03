package com.touchableheroes.rxspace;

public enum MyKey implements ScopeKey<String> {

	KEY1( Integer.class );
	
	// ------------------------------------------------------------
	// Implementation
	// ------------------------------------------------------------
	private Class<String> type;



	MyKey( Class<Integer> type ) {
		this.type = null;
	}

	public Class<String> returnType() {
		// TODO Auto-generated method stub
		return type;
	}
	
}
