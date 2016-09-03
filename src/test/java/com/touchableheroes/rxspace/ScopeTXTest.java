package com.touchableheroes.rxspace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

public class ScopeTXTest {

	private static final int UNTIL = 3000000;

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
//		ScopeTX scopeTX = new ScopeTX() {
//			
//			public void commit(TXOperations tx) {
//				tx.change( MyKey.KEY1, null ); // NULL-Werte nicht erlaubt?
//				tx.reset( MyKey.KEY1 ); // löscht individuellen Schlüssel
//			}
//		};
//		
//		ScopeTXController txe = new ScopeTXController();
//		
//		txe.exec( scopeTX );
	}
}
