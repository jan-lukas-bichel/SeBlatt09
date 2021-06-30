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
        _euroanteil = centbetrag / 100;
        _centanteil = centbetrag % 100;
    }

    private Geldbetrag(int euroanteil, int centanteil)
    {
        _euroanteil = euroanteil;
        _centanteil = centanteil;
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

    public boolean istGueltigerEuroanteil(int euroanteil)
    {
        return false;
    }

    public boolean istGueltigerCentanteil(int centanteil)
    {
        return false;
    }

    public static Geldbetrag addiere(Geldbetrag summand1, Geldbetrag summand2)
    {

    }

    public static boolean istAddierenMoeglich(Geldbetrag betrag1, Geldbetrag betrag2)
    {

    }

    public Geldbetrag multipliziere(int faktor)
    {

    }

    public boolean istMultiplizierenMoeglich(Geldbetrag betrag, int faktor)
    {

    }

    public int getEuroanteil()
    {
        return _euroanteil;
    }

    public int getCentanteil()
    {
        return _centanteil;
    }

	public static Object subtrahiere(Geldbetrag _geldBetragZwei, Geldbetrag _geldBetragEins) {
		// TODO Auto-generated method stub
		return null;
	}

}
