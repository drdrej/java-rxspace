package com.touchableheroes.rxspace.values;

import java.util.LinkedList;

import com.touchableheroes.rxspace.OnChangeEntry;
import com.touchableheroes.rxspace.Rule;
import com.touchableheroes.rxspace.Scope;
import com.touchableheroes.rxspace.ScopeKey;
import com.touchableheroes.rxspace.TXOperations;

/**
 * Created by asiebert on 26.02.16.
 */
public class ChangeValueListener<T> implements IChangeValueListener<T> {

	private final LinkedList<OnChangeEntry> listeners = new LinkedList<OnChangeEntry>();
	
    public ChangeValueListener() {
        ;
    }
    
    public Rule listen( final OnChangeEntry listener ) {
    	listeners.add(listener);
    	return null;
    }

	public void changed(ScopeKey key, T newValue, T oldValue) {
		for (final OnChangeEntry listener : listeners) {
			listener.onChange(null, newValue, null);
		}
	}

	public void afterChange(TXOperations ops) {
		// TODO Auto-generated method stub
		
	}

	
}
