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
        _geldBetragEins = Geldbetrag.select(3040);
        _geldBetragZwei = Geldbetrag.select(9080);
        _geldBetragDrei = Geldbetrag.select(6040);
        assertEquals(_geldBetragDrei,
                Geldbetrag.subtrahiere(_geldBetragZwei, _geldBetragEins));
    }

    @Test
    public void testeMultipliziere()
    {

        _geldBetragEins = Geldbetrag.select(20, 00);
        _geldBetragZwei = Geldbetrag.select(40, 00);
        _geldBetragDrei = Geldbetrag.select(80, 00);

        assertEquals(_geldBetragZwei,
                Geldbetrag.multipliziere(_geldBetragEins, 2));
        assertEquals(_geldBetragDrei,
                Geldbetrag.multipliziere(_geldBetragEins, 4));
    }

    @Test
    public void testeIstMultiplizierenMeoglich()
    {
        _geldBetragEins = Geldbetrag.select(400, 00);
        assertFalse(Geldbetrag.istMultiplizierenMoeglich(_geldBetragEins,
                2000000000));
        assertTrue(Geldbetrag.istMultiplizierenMoeglich(_geldBetragEins, 200));
    }

    @Test
    public void testeKonvertiereInt() // Brauchen wir die überhaupt? weil wir haben ja auch keine Methode dazu
    {

    }

    @Test
    public void testeKonvertiereString()
    {
        _geldBetragEins = Geldbetrag.select(0, 0);
        _geldBetragZwei = Geldbetrag.select(1, 50);
        System.out.println(_geldBetragZwei.konvertiereString());

        assertEquals(_geldBetragEins.konvertiereString(), "0,00€");
        assertEquals(_geldBetragZwei.konvertiereString(), "1,50€");
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
