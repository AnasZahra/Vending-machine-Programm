/**
 * Klasse Wein ist von Klasse AlkoholischesGetraenk erweitert
 *
 * @author Jandsot , Anas 
 * @version *1213*
 */
public class Wein extends AlkoholischesGetraenk {
    /**
     * Das Attribut ist zum einlegen von Weingut
     */
    public String weingut;

    /**
     * Das kontruktor setzt das ein gegebene Weingut.
     * @param weingut
     */
    public Wein (String weingut){
        this.weingut = weingut;
    }

    /**
     * get methode gibt das weingut zurueck
     * @return - weingut.
     */
    public String getWeingut(){
        return weingut;
    }

    /**
     * toString gibt alles in ein zeichen kette zurück.
     * @return - gibt Weingut und Weinart aus.
     */
    public String toString(){
        return "Wein" +" Weingut : "+ weingut + super.alkoholgehalt + "%";
    }
}
