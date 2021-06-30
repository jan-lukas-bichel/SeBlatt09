package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

import java.util.HashMap;
import java.util.Map;

public class Geldbetrag
{

    private int _euroanteil;
    private int _centanteil;
    private static Map<String, Geldbetrag> _werteMenge = new HashMap<String, Geldbetrag>();

    public Geldbetrag(int centbetrag)
    {
        _euroanteil = centbetrag / 100;
        _centanteil = centbetrag % 100;
    }

    public Geldbetrag(int euroanteil, int centanteil)
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

}
