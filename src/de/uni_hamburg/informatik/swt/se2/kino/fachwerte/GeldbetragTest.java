package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GeldbetragTest
{

	Geldbetrag _geldBetragEins;
	Geldbetrag _geldBetragZwei;
	Geldbetrag _geldBetragDrei;

	public GeldbetragTest() 
	{
	}
	
	@Test
	void testeIstAddierenMoeglich()
	{
		_geldBetragEins.select(300000,0);
		_geldBetragZwei.select(40000, 0);
		assertFalse(Geldbetrag.istAddierenMoeglich(_geldBetragEins, _geldBetragZwei));
		_geldBetragEins.select(0,0);
		assertTrue(Geldbetrag.istAddierenMoeglich(_geldBetragEins, _geldBetragZwei));
		
		
	}
	@Test
	void testeAddiere() 
	{
		_geldBetragEins.select(100, 50);
		_geldBetragZwei.select(70, 80);
		_geldBetragDrei.select(171,30);
		assertEquals(_geldBetragDrei, Geldbetrag.addiere(_geldBetragEins, _geldBetragZwei));
	}
	
	
	@Test
	void testeSubtrahieren()
	{
		_geldBetragEins.select(30, 80);
		_geldBetragZwei.select(90, 40);
		_geldBetragDrei.select(60,40);
		assertEquals(_geldBetragDrei, Geldbetrag.subtrahiere(_geldBetragZwei, _geldBetragEins));
	}
    @Test
    public void testeMultipliziere()
    {
        _geldBetragEins = Geldbetrag.select(20, 25);
        _geldBetragZwei = Geldbetrag.select(20, 00);

        assertTrue(Geldbetrag.select(40, 00), _geldBetragZwei.multipliziere(2));
        assertFalse(Geldbetrag.select(81), _geldBetragEins.multipliziere(4));

    }

    @Test
    public void testeIstMultiplizierenMeoglich()
    {

    }

    @Test
    public void testeKonvertiereString()
    {

    }

    @Test
    public void testeHashCode()
    {

    }

    @Test
    public void testeEquals()
    {

    }
}
