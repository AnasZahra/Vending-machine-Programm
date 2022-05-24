/**
 * Klasse AlkoholischesGetraenk ist eine erweiterung der Klasse Getraenk
 *
 * @author Jandsot , Anas 
 * @version *1213*
 */
public abstract class AlkoholischesGetraenk extends Getraenk{
    public float alkoholgehalt;

    public float GetGehalt(){
        return alkoholgehalt ;
    }

    public float setGehalt(){
        return this.alkoholgehalt ;
    }

    public String toString(){
        return "Das Alkoholgehalt ist :" + alkoholgehalt ;
    }
}
