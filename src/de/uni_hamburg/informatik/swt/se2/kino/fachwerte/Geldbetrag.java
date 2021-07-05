package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

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

    private Geldbetrag(int euroanteil, int centanteil)
    {
        _euroanteil = Math.abs(euroanteil);
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

    public boolean istGueltigerEuroanteil(int euroanteil)
    {
        return true; // TODO
    }

    public boolean istGueltigerCentanteil(int centanteil)
    {
        return true; // TODO
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
        return euroBetrag <= Integer.MAX_VALUE;
    }

    public static Geldbetrag multipliziere(Geldbetrag betrag, int faktor)
    {
        return Geldbetrag.select(betrag.getCentbetrag() * faktor);
    }

    public static boolean istMultiplizierenMoeglich(Geldbetrag betrag,
            int faktor)
    {
        long euroBetrag = (long) betrag.getEuroanteil() * faktor;
        long centBetrag = (long) betrag.getCentanteil() * faktor / 100;
        return euroBetrag + centBetrag <= Integer.MAX_VALUE;
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
        return String.valueOf(_euroanteil) + "," + String.valueOf(_centanteil)
                + "€";
    }

    public static Geldbetrag subtrahiere(Geldbetrag betrag1, Geldbetrag betrag2)
    {
        return Geldbetrag
            .select(betrag1.getCentbetrag() - betrag2.getCentbetrag());
    }

    public static boolean istSubtrahierenMoeglich(Geldbetrag betrag1,
            Geldbetrag betrag2)
    {

        int euroAnteil = betrag1.getEuroanteil() - betrag2.getEuroanteil();
        int centAnteil = betrag1.getCentanteil() - betrag2.getCentanteil();
        if (centAnteil < 0)
        {
            euroAnteil--;
            centAnteil = centAnteil + 100;
        }
        return euroAnteil >= Integer.MIN_VALUE;
    }

}
