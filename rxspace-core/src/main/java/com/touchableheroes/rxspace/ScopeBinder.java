package com.touchableheroes.rxspace;

import com.touchableheroes.rxspace.listeners.OnChangeEntry;
import com.touchableheroes.rxspace.listeners.OnChangeEntryListenerManager;
import com.touchableheroes.rxspace.scopes.Scope;
import com.touchableheroes.rxspace.scopes.meta.ScopeKey;
import com.touchableheroes.rxspace.tx.ScopeTX;
import com.touchableheroes.rxspace.tx.TXOperations;
import com.touchableheroes.rxspace.values.ChangeValueListener;

public class ScopeBinder {

	// oder andersherum??
	private ScopeTXController txController;

	private OnChangeEntryListenerManager listenerMgr;

	private Scope scope;

	public ScopeBinder(final Scope scope) {
		this.scope = scope;
		txController = new ScopeTXController(scope);
		listenerMgr = new OnChangeEntryListenerManager();
	}

	public void onChange(final ScopeKey key, final OnChangeEntry listener) {
		listenerMgr.addListener(key /* new ListenerMatcher(key) */, listener);
	}

	public Object change(final ScopeKey key, final Object newValue) {
		synchronized (scope) {
			if (newValue instanceof ScopeTX) {
				txController.exec((ScopeTX) newValue);
			} else {
				txController.exec(new ScopeTX() {
					public void commit(final TXOperations tx) {
						tx.change(key, newValue);
					}
				});
			}			
		}
		
		listenerMgr.onChange(key, newValue);
		
		//
		// Class returnType = key.returnType();
		//
		// // ...
		// Object oldValue = null;
		// if( isSameValue(newValue, oldValue ) ){
		//
		// }
		// if( isTypeOk(key, newValue) ) {
		//
		// }
		//
		// final Object value;
		// if( !scope.has(key) ) {
		// value = scope.init(key);
		// } else {
		// value = scope.get(key);
		// }
		//
		// scope.set(key, newValue);
		// listeners.changed(key, null /*newValue*/, null /*oldValue*/);

		// final TXOperations ops = new TXOperations()
		// {
		//
		// public void reset(ScopeKey key) {
		// // TODO Auto-generated method stub
		//
		// }
		//
		// public void change(ScopeKey key, Object value) {
		// // TODO Auto-generated method stub
		//
		// }
		// };
		//
		// listenerMgr.afterChange(ops);

		return newValue;
	}

	// private boolean hasValue(ScopeKey key) {
	// // TODO Auto-generated method stub
	// return false;
	// }
	//
	// private boolean isSameValue(Object newValue, Object oldValue) {
	// // TODO Auto-generated method stub
	// return false;
	// }
	//
	// private boolean isTypeOk(ScopeKey key, Object value) {
	// // TODO Auto-generated method stub
	// return false;
	// }

	public void release() {
		// TODO Auto-generated method stub

	}

}
