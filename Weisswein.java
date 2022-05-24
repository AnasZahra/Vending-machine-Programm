/**
 * Klasse Weisswein ist von Wein klasse erweitert
 *
 * @author Jandsot , Anas 
 * @version *1213*
 */
public class Weisswein extends Wein{
    /**
     * Diese Konstruktor Vererbt von oberen klasse.
     * @param weingut ist das herstehler von das wein.
     * @param alkoholgehalt ist das alkoholgehalt in float Z.B. 3.4% , 5.0%.
     */
    public Weisswein(String weingut, float alkoholgehalt){
                super(weingut);
            }

    /**
     * toString gibt alles in ein zeichenkette zurück.
     * @return gibt Weingut aus.
     */
    public String toString(){
        return "Das Wein ist :" + weingut + super.alkoholgehalt + "%" ;
    }
}
