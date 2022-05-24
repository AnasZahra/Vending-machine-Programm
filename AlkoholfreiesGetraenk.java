/**
 * Klasse AlkoholfreiesGetraenk ist eine erweiterung der Klasse Getraenk
 *
 * @author Jandsot , Anas 
 * @version *1213*
 */
public abstract class AlkoholfreiesGetraenk extends Getraenk
{
    /**
     * Das Attribut ist um der hersteller eingeben
     */
    public String hersteller ;


    /**
     *  get methode zeigt der Hersteller
     * @return - Hersteller
     */
    public String getHersteller(){
        return hersteller;
    }

    /**
     * set methode ersetzt
     * @set - Hersteller ersetzen
     */
    public String setHersteller (){
        return this.hersteller;
    }

    /**
     *
     * @return - gibt die hersteller und Hersteller aus
     */
    public String toString(){
        return "Das Hersteller ist :" + hersteller;
    }
}
