package com.touchableheroes.rxspace.values;

import com.touchableheroes.rxspace.ScopeKey;

/**
 * Created by asiebert on 08.12.15.
 */
public interface IChangeValueListener<T> {

    public void changed(final ScopeKey key, final T newValue, final T oldValue);

}
