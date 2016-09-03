package com.touchableheroes.rxspace;

import org.junit.Test;

public class ScopeTXTest {

	@Test
	public void testCommit() {
		ScopeTX scopeTX = new ScopeTX() {
			
			public void commit(TXOperations tx) {
				tx.change( MyKey.KEY1, null ); // NULL-Werte nicht erlaubt?
				tx.reset( MyKey.KEY1 ); // löscht individuellen Schlüssel
			}
		};
		
		ScopeTXController txe = new ScopeTXController();
		
		txe.exec( scopeTX );
	}
}
