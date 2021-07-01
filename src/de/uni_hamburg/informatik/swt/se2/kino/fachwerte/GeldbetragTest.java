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
    public void testeIstAddierenMoeglich()
    {
        _geldBetragEins = Geldbetrag.select(300000000, 0);
        _geldBetragZwei = Geldbetrag.select(4000000, 0);
        assertFalse(Geldbetrag.istAddierenMoeglich(_geldBetragEins,
                _geldBetragZwei));
        _geldBetragEins = Geldbetrag.select(0, 0);
        assertTrue(Geldbetrag.istAddierenMoeglich(_geldBetragEins,
                _geldBetragZwei));

    }

    @Test
    public void testeAddiere()
    {
        _geldBetragEins = Geldbetrag.select(100, 50);
        _geldBetragZwei = Geldbetrag.select(70, 80);
        _geldBetragDrei = Geldbetrag.select(171, 30);
        assertEquals(_geldBetragDrei,
                Geldbetrag.addiere(_geldBetragEins, _geldBetragZwei));
    }

    @Test
    public void testeSubtrahieren()
    {
        _geldBetragEins = Geldbetrag.select(30, 80);
        _geldBetragZwei = Geldbetrag.select(90, 40);
        _geldBetragDrei = Geldbetrag.select(60, 40);
        assertEquals(_geldBetragDrei,
                Geldbetrag.subtrahiere(_geldBetragZwei, _geldBetragEins));
    }

    @Test
    public void testeMultipliziere()
    {
        _geldBetragEins = Geldbetrag.select(20, 25);
        _geldBetragZwei = Geldbetrag.select(20, 00);

        assertEquals(Geldbetrag.select(40, 00),
                Geldbetrag.multipliziere(_geldBetragZwei, 2));
        assertFalse(Geldbetrag.multipliziere(_geldBetragEins, 4) == Geldbetrag
            .select(81, 00));

    }

    @Test
    public void testeIstMultiplizierenMeoglich()
    {

    }

    @Test
    public void testeKonvertiereString()
    {
        _geldBetragEins = Geldbetrag.select(0, 0);
        _geldBetragZwei = Geldbetrag.select(1, 50);

        assertEquals(_geldBetragEins.konvertiereString(), "0,00€");
        assertEquals(_geldBetragEins.konvertiereString(), "1,50€");
    }

    @Test
    public void testeSelectGeldbetrag()
    {
        _geldBetragEins = Geldbetrag.select(0, 0);
        _geldBetragZwei = Geldbetrag.select(0, 0);
        _geldBetragDrei = Geldbetrag.select(1, 0);

        assertTrue(_geldBetragEins == _geldBetragZwei);
        assertTrue(_geldBetragEins != _geldBetragDrei);
    }

    @Test
    public void testeEquals()
    {
        _geldBetragEins = Geldbetrag.select(0, 0);
        _geldBetragZwei = Geldbetrag.select(0, 0);
        _geldBetragDrei = Geldbetrag.select(1, 0);

        assertTrue(_geldBetragEins.equals(_geldBetragZwei));
        assertTrue(!_geldBetragEins.equals(_geldBetragDrei));
    }
}
