package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GeldbetragTest
{

    Geldbetrag _geldBetragEins;
    Geldbetrag _geldBetragZwei;
    Geldbetrag _geldBetragDrei;

    public void testeAddiere()
    {

    }

    public void testeSubtrahieren()
    {

    }

    public void testeIstSubtrahierenMoeglich()
    {

    }

	Geldbetrag _geldBetragEins;
	Geldbetrag _geldBetragZwei;
	Geldbetrag _geldBetragDrei;
    
    @Test
    public void testeMultipliziere()
    {
        _geldBetragEins = Geldbetrag.get(20, 25);
        _geldBetragZwei = Geldbetrag.get(20, 00);

        assertTrue(Geldbetrag.get(40, 00), _geldBetragZwei.multipliziere(2));
        assertFalse(Geldbetrag.get(81), _geldBetragEins.multipliziere(4));

    }

    @Test
    public void testeIstMultiplizierenMeoglich()
    {

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
