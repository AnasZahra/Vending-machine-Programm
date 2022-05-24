/**
 * Klasse Wasser gibt eine AlkoholfreiesGetraenk 
 *
 * @author Jandsot , Anas 
 * @version *1213*
 */
public class Wasser extends AlkoholfreiesGetraenk{
    /**
     * Das Attribut ist zum quelle von Wasser.
     */
    public String quelle;

    /**
     *
     * @param quelle - Water source.
     * @param hersteller - Company name.
     */
    public Wasser (String quelle, String hersteller){
        this.quelle  = quelle ;
    }

    /**
     *  get methode gibt das wasserquelle zurueck.
     *  @return gibt die wasser quelle zurueck.
     */
    public String getQuelle(){
        return quelle ;
    }

    /**
     * toString gibt alles in ein zeichen kette zurück.
     * @return - gibt quelle und hersteller aus.
     */
    public String toString(){
        return "Das wasser ist von " + quelle + super.hersteller;
    }
}

