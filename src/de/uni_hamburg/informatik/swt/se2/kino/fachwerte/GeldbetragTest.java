package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

import static org.junit.Assert.assertFalse;
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
