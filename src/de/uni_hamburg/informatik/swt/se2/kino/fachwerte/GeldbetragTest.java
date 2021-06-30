package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GeldbetragTest {

	Geldbetrag _geldBetragEins;
	Geldbetrag _geldBetragZwei;
	Geldbetrag _geldBetragDrei;

	void testeAddiere() {

	}

	@Test
	public void testeKonvertiereString() {
		_geldBetragEins = Geldbetrag.select(0, 0);
		_geldBetragZwei = Geldbetrag.select(1, 50);

		assertEquals(_geldBetragEins.konvertiereString(), "0,00€");
		assertEquals(_geldBetragEins.konvertiereString(), "1,50€");
	}

	@Test
	public void testeSelectGeldbetrag() {
		_geldBetragEins = Geldbetrag.select(0, 0);
		_geldBetragZwei = Geldbetrag.select(0, 0);
		_geldBetragDrei = Geldbetrag.select(1, 0);

		assertTrue(_geldBetragEins == _geldBetragZwei);
		assertTrue(_geldBetragEins != _geldBetragDrei);
	}

	@Test
	public void testeEquals() {
		_geldBetragEins = Geldbetrag.select(0, 0);
		_geldBetragZwei = Geldbetrag.select(0, 0);
		_geldBetragDrei = Geldbetrag.select(1, 0);

		assertTrue(_geldBetragEins.equals(_geldBetragZwei));
		assertTrue(!_geldBetragEins.equals(_geldBetragDrei));
	}
}
