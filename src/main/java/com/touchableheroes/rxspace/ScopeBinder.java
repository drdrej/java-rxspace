package com.touchableheroes.rxspace;

import com.touchableheroes.rxspace.values.ChangeValueListener;

public class ScopeBinder {

	private Scope scope;
	
	public ChangeValueListener<OnChangeEntry> listeners = new ChangeValueListener<OnChangeEntry>();
	
	public ScopeBinder(final Scope scope) {
		this.scope = scope;
	}
	
	public void onChange(
			final ScopeKey key, 
			final OnChangeEntry listener) {
		listeners.listen(listener);		
	}

	public Object change(
			ScopeKey key, 
			Object newValue) {
		
		Class returnType = key.returnType();
		
		// ...		
		Object oldValue = null;
		if( isSameValue(newValue, oldValue ) ){
			
		}
		if( isTypeOk(key, newValue) ) {
		
		}
		
		final Object value;
		if( !scope.has(key) ) {
			value = scope.init(key);
		} else {
			value = scope.get(key);
		}
		
		scope.set(key, newValue);
		listeners.changed(key, null /*newValue*/, null /*oldValue*/);
		
		final TXOperations ops = new TXOperations()
		{
			
			public void reset(ScopeKey key) {
				// TODO Auto-generated method stub
				
			}
			
			public void change(ScopeKey key, Object value) {
				// TODO Auto-generated method stub
				
			}
		};
		
		listeners.afterChange(ops);

		return newValue;
	}

	private boolean hasValue(ScopeKey key) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean isSameValue(Object newValue, Object oldValue) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean isTypeOk(ScopeKey key, Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	public void release() {
		// TODO Auto-generated method stub
		
	}

}
