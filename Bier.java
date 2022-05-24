/**
 * Klasse Bier ist von Klasse AlkoholischesGetraenk erweitert
 *
 * @author Jandsot , Anas 
 * @version *1213*
 */
public class Bier extends AlkoholischesGetraenk
{
    /**
     *
     */
    public String brauerei;

    /**
     *
     * @param brauerei
     * @param alkoholgehalt
     */
    public Bier(String brauerei, float alkoholgehalt){
        this.brauerei = brauerei ;
    }

    /**
     * gibt die brauerei zurueck
     * @return brauerei company
     */
    public String getBierArt(){
        return brauerei ;
    }

    /**
     *
     * @return - gibt die brauerei und alkoholgehalt aus
     */
    public String toString(){
        return "Das Brauerei ist : " + brauerei + super.alkoholgehalt + "%" ;
    }
}
