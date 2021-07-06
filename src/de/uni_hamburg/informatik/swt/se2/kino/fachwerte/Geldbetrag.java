package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

import static org.junit.Assert.assertArrayEquals;

import java.util.HashMap;
import java.util.Map;

public class Geldbetrag
{
    private int _euroanteil;
    private int _centanteil;
    private static Map<String, Geldbetrag> _werteMenge = new HashMap<String, Geldbetrag>();

    private Geldbetrag(int centbetrag)
    {
        _euroanteil = Math.abs(centbetrag / 100);
        _centanteil = Math.abs(centbetrag % 100);
    }

    private Geldbetrag(long euroanteil, int centanteil)
    {
    	assert istGueltigerEuroanteil(euroanteil) : "Vrobedingung verletzt istGueltigerEuroanteil(euroanteil)";
    	assert istGueltigerCentanteil(centanteil) : "Vrobedingung verletzt istGueltigerCentanteil(centanteil)";
        _euroanteil = Math.abs((int)euroanteil);
        _centanteil = Math.abs(centanteil);
    }

    public static Geldbetrag select(int euroAnteil, int centAnteil)
    {
        String key = euroAnteil + "," + centAnteil;
        if (!_werteMenge.containsKey(key))
        {
            _werteMenge.put(key, new Geldbetrag(euroAnteil, centAnteil));
        }
        return _werteMenge.get(key);
    }

    public static Geldbetrag select(int centbetrag)
    {
        String key = centbetrag / 100 + "," + centbetrag % 100;
        if (!_werteMenge.containsKey(key))
        {
            _werteMenge.put(key, new Geldbetrag(centbetrag));
        }
        return _werteMenge.get(key);
    }

    private static boolean istGueltigerEuroanteil(long euroanteil)
    {
    	if(euroanteil <= Integer.MAX_VALUE && euroanteil >= 0)
    	{
    		return true;
    	}
    	
    	return false;
    }

    private boolean istGueltigerCentanteil(int centanteil)
    {
        if (centanteil > 99 || centanteil < 0)
        {
            return false;
        }
        return true;
    }

    public static Geldbetrag addiere(Geldbetrag summand1, Geldbetrag summand2)
    {
        int summe = summand1.getCentbetrag() + summand2.getCentbetrag();
        return Geldbetrag.select(summe);
    }

    public static boolean istAddierenMoeglich(Geldbetrag betrag1,
            Geldbetrag betrag2)
    {
        long euroBetrag = (long) betrag1.getEuroanteil()
                + (long) betrag2.getEuroanteil();
        long centBetrag = (long) betrag1.getCentanteil()
                + (long) betrag2.getCentanteil();
        if (centBetrag >= 100)
        {
            euroBetrag++;

        }
        //return euroBetrag <= Integer.MAX_VALUE;
        return istGueltigerEuroanteil(euroBetrag);
    }

    public static Geldbetrag multipliziere(Geldbetrag betrag, int faktor)
    {
        return Geldbetrag.select(betrag.getCentbetrag() * faktor);
    }

    public static boolean istMultiplizierenMoeglich(Geldbetrag betrag,
            int faktor)
    {
        long euroBetrag = (long) betrag.getEuroanteil() * faktor;
        //        long centBetrag = (long) betrag.getCentanteil() * faktor / 100;
        //          return euroBetrag + centBetrag <= Integer.MAX_VALUE;
        long centBetrag;
        for (centBetrag = (long) betrag.getCentanteil()
                * faktor; centBetrag > 99; centBetrag -= 100)
        {
            euroBetrag++;
        }
        return istGueltigerEuroanteil(euroBetrag);

    }

    public int getEuroanteil()
    {
        return _euroanteil;
    }

    public int getCentanteil()
    {
        return _centanteil;
    }

    public int getCentbetrag()
    {
        int centbetrag = _euroanteil * 100 + _centanteil;
        return centbetrag;
    }

    public String konvertiereString()
    {
        String str = String.format("%d,%02d€", _euroanteil, _centanteil);
        //        return String.valueOf(_euroanteil) + "," + String.valueOf(_centanteil)
        //                + "€";
        return str;
    }

    /**
     * Subtrahieren von zwei centbetraegen 
     * @param betrag1 Centbetrag 1
     * @param betrag2 Centbetrag 2
     * @return Geldbetrag nach subtraktion 
     */
    public static Geldbetrag subtrahiere(Geldbetrag betrag1, Geldbetrag betrag2)
    {
        if (betrag1.getCentbetrag() >= betrag2.getCentbetrag())
        {
            int centBetrag = betrag1.getCentbetrag() - betrag2.getCentbetrag();
            return Geldbetrag.select(centBetrag);
        }
        return subtrahiere(betrag2, betrag1);
    }

}
