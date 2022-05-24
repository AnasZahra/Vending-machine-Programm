/**
 * Klasse SoftDrink gibt eine AlkoholfreiesGetraenk
 *
 * @author Jandsot , Anas 
 * @version *1213*
 */
public class SoftDrink extends AlkoholfreiesGetraenk
{

    /**
     * Das Attribut ist fuer zuckergehalt.
     */
    public float zuckergehalt;

    /**
     *
     * @param zuckergehalt
     * @param softDrinkHersteller
     */
    public SoftDrink(float zuckergehalt, String softDrinkHersteller){
        this.zuckergehalt = zuckergehalt;
    }

    /**
     * get methode gibt das zuckergehalt zurueck.
     * @return gibt zuckergehalt zurueck.
     */
    public float getZuckergehalt (){
        return zuckergehalt;
    }

    /**
     *  Disen Konstruktor Vererbt von oberen klasse.
     * @return gibt die Zuckergehalt und Hersteller aus.
     */
    public String toString(){
        return "Das Zuckergehalt ist = " + zuckergehalt + super.hersteller;
    }
}
