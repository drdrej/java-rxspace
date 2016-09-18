package com.touchableheroes.rxspace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class ScopeTXTest {

	private static final int UNTIL = 3000000;

	@Ignore
	@Test
	public void timesOfMaps() {
		final List<Map> all = new ArrayList<Map>(2);
		
		final long start = System.currentTimeMillis();
		for (int i = 0; i < UNTIL; i++) {
			Map newMap = createTreeHash(i);
			all.add( newMap  );
			
			System.out.println( "Count: " + i );
		}
		
		final long end = System.currentTimeMillis();
		
		System.out.println( "Create HashMap: " + (end - start) + "ms" );
	}
	
	private Map createHash(int i) {

		HashMap hashMap = new HashMap();
		hashMap.put(i, i);
		
		return hashMap;
	}
	
	private Map createTreeHash(int i) {

		Map hashMap = new TreeMap();
		hashMap.put(i, i);
		
		return hashMap;
	}

	@Test
	public void testCommit() {
		ScopeTX scopeTX = new ScopeTX() {
			
			public void commit(TXOperations tx) {
				tx.change( MyKey.KEY1, 12 ); // NULL-Werte nicht erlaubt?
				tx.reset( MyKey.KEY2 ); // löscht individuellen Schlüssel
			}
		};
		
		final Scope scope = new Scope();
				// mock(Scope.class);
//		doNothing().when(scope).set(any(type), newValue);
		// Mockito.when(scope.set(any(MyKey.class), anyInt())).thenReturn();
		//Mockito.spy(object)
		//doThrow f. void methoden.
		
		final ScopeTXController txe = new ScopeTXController(scope);
		
		txe.exec( scopeTX );
		
		
		
		final int result = (Integer) scope.get( MyKey.KEY1 );
		assertEquals(12, result);
		
		// verify(scope);                       
	}
}
