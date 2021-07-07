package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;


public class Geldbetrag
{
    private int _euroanteil;
    private int _centanteil;
    private static Map<String, Geldbetrag> _werteMenge = new HashMap<String, Geldbetrag>();

    /**
     * @require istGueltigerEuroanteil(centbetrag / 100))
     */
    private Geldbetrag(long centbetrag)
    {
        assert (istGueltigerEuroanteil(centbetrag
                / 100)) : "Vrobedingung verletzt istGueltigerEuroanteil(centbetrag / 100))";
        _euroanteil = Math.abs((int) centbetrag / 100);
        _centanteil = Math.abs((int) centbetrag % 100);
    }

    /**
     * @require istGueltigerEuroanteil(euroanteil)
     * 
     * @require istGueltigerCentanteil(centanteil)
     */
    private Geldbetrag(long euroanteil, int centanteil)
    {
        assert istGueltigerEuroanteil(
                euroanteil) : "Vrobedingung verletzt istGueltigerEuroanteil(euroanteil)";
        assert istGueltigerCentanteil(
                centanteil) : "Vrobedingung verletzt istGueltigerCentanteil(centanteil)";
        _euroanteil = Math.abs((int) euroanteil);
        _centanteil = Math.abs(centanteil);
    }

    /**
     * Gibt den Geldbetrag zum Euro anteil und Cent anteil zurück 
     * 
     * @param euroAnteil 
     * @param centAnteil
     * @return Gibt den geforderten Geldbetrag zurück
     */
    public static Geldbetrag select(int euroAnteil, int centAnteil)
    {
        String key = euroAnteil + "," + centAnteil;
        if (!_werteMenge.containsKey(key))
        {
            _werteMenge.put(key, new Geldbetrag(euroAnteil, centAnteil));
        }
        return _werteMenge.get(key);
    }

    /**
     * Gibt den Geldbetrag zu einem Eurocent Betrag zurück 
     * 
     * @param centbetrag Der centbetrag der umgewandelt werden soll in ein Geldbetrag
     * @return Gibt den geforderten Geldbetrag zurück
     */
    public static Geldbetrag select(int centbetrag)
    {
        String key = centbetrag / 100 + "," + centbetrag % 100;
        if (!_werteMenge.containsKey(key))
        {
            _werteMenge.put(key, new Geldbetrag(centbetrag));
        }
        return _werteMenge.get(key);
    }
    
    /**
     * Pruefe, ob der uebergebene Euroanteil gueltig ist
     * 
     * @param euroanteil der Euroanteil, der ueberprueft werden soll
     * @return ob er Euroanteil gueltig ist oder nicht
     */
    public static boolean istGueltigerEuroanteil(long euroanteil)
    {
        if (euroanteil <= Integer.MAX_VALUE && euroanteil >= 0)
        {
            return true;
        }

        return false;
    }

    /**
     * Pruefe, ob der uebergebene Centanteil gueltig ist
     * 
     * @param centanteil der Centanteil, der ueberprueft werden soll
     * @return ob der Centanteil gueltig ist oder nicht
     */
    private boolean istGueltigerCentanteil(int centanteil)
    {
        if (centanteil > 99 || centanteil < 0)
        {
            return false;
        }
        return true;
    }

    /**
     * zwei Geldbetraege addieren
     * 
     * @param summand1 erster Summand
     * @param summand2 zweiter Summand
     * @return die Summe
     */
    public static Geldbetrag addiere(Geldbetrag summand1, Geldbetrag summand2)
    {
        int summe = summand1.getCentbetrag() + summand2.getCentbetrag();
        return Geldbetrag.select(summe);
    }

    /**
     * Ueberpuefe, ob addieren möglich ist
     * 
     * @param betrag1 erster Summand
     * @param betrag2 zweiter Summand
     * @return ob ein gueltiger Geldbetrag rauskommt
     */
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
        // return euroBetrag <= Integer.MAX_VALUE;
        return istGueltigerEuroanteil(euroBetrag);
    }

    /**
     * Geldbetrag mit einem Faktor multiplizieren
     * 
     * @param betrag Betrag den Geldbetrag, den man multiplizieren möchte
     * @param faktor den Faktor, mit dem man den Geldbetrag multiplizieren möchte
     * @return das Ergebnis der Multiplikation
     */
    public static Geldbetrag multipliziere(Geldbetrag betrag, int faktor)
    {
        return Geldbetrag.select(betrag.getCentbetrag() * faktor);
    }

    /**
    * Ueberpruefe, ob Multiplizieren möglich ist
    * 
    * @param betrag der Geldbetrag, den man multiplizieren möchte
    * @param faktor der Faktor, mit dem man den Geldbetrag multiplizieren möchte
    * @return ob ein gueltiger Euroanteil rauskommt
    */
    public static boolean istMultiplizierenMoeglich(Geldbetrag betrag,
            int faktor)
    {
        long euroBetrag = (long) betrag.getEuroanteil() * faktor;
        // long centBetrag = (long) betrag.getCentanteil() * faktor / 100;
        // return euroBetrag + centBetrag <= Integer.MAX_VALUE;
        long centBetrag;
        for (centBetrag = (long) betrag.getCentanteil()
                * faktor; centBetrag > 99; centBetrag -= 100)
        {
            euroBetrag++;
        }
        return istGueltigerEuroanteil(euroBetrag);

    }

    /**
     * gibt den Euroanteil zurück
     * 
     * @return der Euroanteil
     */
    public int getEuroanteil()
    {
        return _euroanteil;
    }

    /**
     * gibt den Centanteil zurück
     * 
     * @return der Centanteil
     */
    public int getCentanteil()
    {
        return _centanteil;
    }

    /**
     * gibt den Centbetrag zurück
     * 
     * @return der Centbetrag
     */
    public int getCentbetrag()
    {
        int centbetrag = _euroanteil * 100 + _centanteil;
        return centbetrag;
    }

    /**
     * Geldbetrag in String umwandeln
     * 
     * @return der in einen String umgewandelte Geldbetrag
     */
    public String konvertiereString()
    {
        String str = String.format("%d,%02d€", _euroanteil, _centanteil);
        // return String.valueOf(_euroanteil) + "," + String.valueOf(_centanteil)
        // + "€";
        return str;
    }


    /**
     * Subtrahieren von zwei centbetraegen
     * 
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
    
    public static Geldbetrag eingabestringZuGeldbetrag(String eingabestring) {
		long betrag = Long.parseLong(eingabestring);
		
		if(betrag <= Integer.MAX_VALUE) 
		{
			return Geldbetrag.select(Integer.parseInt(eingabestring));
		}else 
    	{
    		JOptionPane.showMessageDialog(null, "Ungültiger Betrag", "Eingabe Error" ,JOptionPane.ERROR_MESSAGE);
    		return Geldbetrag.select(0);
    	}
	}

}
