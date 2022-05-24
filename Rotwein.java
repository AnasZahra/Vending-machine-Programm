/**
 * Klasse Rotwein ist von Wein klasse erweitert
 *
 * @author Jandsot , Anas 
 * @version *1213*
 */
public class Rotwein extends Wein {
    /**
     * Disen Konstrutor Vererbt von oberen Klassen.
     * @param weingut ist das herstehler von das wein.
     * @param alkoholgehalt  Disen Konstruktor Vererbt von oberen klasse.
     */
    public Rotwein(String weingut, float alkoholgehalt){
        super(weingut);
    }

    /**
     * toString gibt alles in ein zeichen kette zurück.
     * @return gibt Weingut und das Alkohogehalt aus.
     */
    public String toString(){
        return "Das Wein ist:" + weingut + super.alkoholgehalt + "%" ;
    }

}
