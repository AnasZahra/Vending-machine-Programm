/**
 * Klasse Flasse enthaelt methoden fuellen und leeren und wird im automat benutzt
 *
 * @author Jandsot , Anas
 * @version *1213*
 */
public class Flasche<T extends Getraenk> {

    //private inhalt ist eine private Variable mit generischem Typ besitzen.
    private T inhalt;
    private boolean gefuellt = true ;

    public Flasche(T inhalt){
        this.inhalt = inhalt ;
    }
    
    /**
     * Die Methode fuellen nimmt ein passendes Getraenk-Objekt.
     * entgegen und setze es als inhalt.
     */
    public void fuellen(T getraenk){

        if (!gefuellt) {
            throw new IllegalArgumentException("Die Flasche ist Gefuellt");
        }

        inhalt = getraenk ;

    }

    /**
     * Die Methode leeren leert die Flasche.
     */
    public void leeren(){
        inhalt = null;
        gefuellt= false;
    }

    /**
     * toString gibt alles in ein zeichen kette zurück.
     * @return - gibt das inhalt aus.
     */
    public String toString(){
        return "Die Flasche ist" + inhalt  ;
    }
    //toString-Methode so, dass der Flascheninhalt als String ausgegeben wird.


}
