import java.io.IOException;
import java.util.ArrayList; // import the ArrayList class
/**
 * Klasse Getraenkautomat ist ein generics Klasse und enthaelt die Automat methoden
 * @author Jandsot , Anas
 * @version *1213*
 */
public class Getraenkautomat<T>
{
  //Diese ArrayList speichert die Flaschen im Getränkeautomaten.

  /**
   * Die Anzahl der Flaschen, die der Getränkeautomat aufnehmen kann.
   * Die Kapazität soll über den Konstruktor übergeben und gesetzt werden.
   */
  public int kapazitaet;

  ArrayList<Flasche> flaschenlager;

  /**
   * Die ArrayList kann Objekte vom Typ des Typ-Parameters und aller Subklassen
   * speichern.
   */
  public Getraenkautomat(int kapazitaet) throws IllegalArgumentException{
    if (kapazitaet <= 0){
      throw new IllegalArgumentException("");
    }

    this.kapazitaet = kapazitaet ;

    flaschenlager = new ArrayList<Flasche>(kapazitaet);
  }

  /**
   * gibt die size zurueck.
   * @return size is all the size of the automat.
   */
  public int getSize(){
    return flaschenlager.size();
  }

  /**
   * gibt die kapazitaet zurueck.
   * @return kapazitaet z.B 10 flaschen.
   */
  public int getKapazitaet(){
    return kapazitaet ;
  }

  /**
   * Diese Methode nimmt ein Objekt vom Typ Flasche entgegen und
   * speichert es, falls noch Kapazität vorhanden ist, im falschenlager. Der Inhalt der
   * übergebenen Flasche muss vom Typ des Typ-Parameters oder einer Subklasse sein. Es
   * sollen nur volle Flaschen in den Automaten eingelegt werden können. Dies muss daher
   * geprüft werden.
   */
  public void flascheEinlegen(Flasche flasche) throws IOException {
    if (flasche == null){
      throw new IOException("Keine Kapazitaet");
    }
      //Flasche<Integer> f = new Flasche<Integer>();

    flaschenlager.add(flasche);

  }
  
  /**
   * Diese Methode gibt eine Flasche aus dem Flaschenlager zurück. Der
   * Getraenkeautomat soll nach dem "First in, first out"-Prinzip arbeiten (Ja, ein solches Verhalten
   * ist für einen Getränkeautomaten ungewöhnlich, wird aber hier zur Vereinfachung
   * der Aufgabe so implementiert
   */
  public Flasche flascheAusgeben(){
    if (flaschenlager.isEmpty()){
      throw new IllegalArgumentException("");
      }
    return flaschenlager.get(0);
  }
  
  

  /**
   * die toString()-Methode so, dass der gesamte Inhalt des Automaten ausgegeben wird.
   *
   * @return - list sind gesamte Inhalt des Automaten.
   */
  public String toString(){
    String list = "";
    for (int i = 0; i >flaschenlager.size() ; i++){
      list += flaschenlager.get(i).toString() +  "\n";

    }
    return list;
  }
}
