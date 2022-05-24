import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Dialog Klasse
 *
 * @author Jandsot , Anas 
 * @version *1213*
 */

public class Dialog{
    private static final int FLASCHE_ANLEGEN = 1;
    //private:
    private Scanner input;
    private int funktion;
    private Getraenkautomat automat;

    //HauptMenue:
    private static final int AUTOMAT_ERSTELLEN = 1;

    private static final int ALKOHOLISCHE_GETRAENK = 2;
    private static final int ALKOHOLFREIE_GETRAENK = 3;
    private static final int ALLE_GETRAENKE = 4;
    private static final int BIER = 5;
    private static final int WEIN = 6;
    private static final int ROT_WEIN = 7;
    private static final int WEISS_WEIN = 8;
    private static final int WASSER = 9;
    private static final int SOFT_DRINK = 10;

    //Flasche-Dialog:
    private static final int FLASCHE_EINLEGEN = 1;
    private static final int ALLE_INHALTE_AUSGEBEN = 2;
    private static final int ERSTE_FLASCHE_AUSGEBEN = 3;
    private static final int AUTOMAT_LOESCHEN = 4;

    //Ende:
    private static final int BEENDEDEN = 99;

    private enum GetraenkTyp {
        ALKOHOLISCHE_TYP, ALKOHOLFREIE_TYP, WASSER_TYP, BIER_TYP, WEIN_TYP, SOFTDRINK_TYP
    }

    public Dialog() {
        input = new Scanner(System.in);
        funktion = 0;
    }

    /**
     * Main-Methode
     */
    public static void main(String[] args) {
        new Dialog().start();
        System.exit(0);
    }

    /**
     * Hauptschleife des Dialogprogramms
     */
    public void start() {
        while (funktion != BEENDEDEN) {
            hauptMenueInput();
        }
    }

    private void hauptMenueInput() {
        try {
            hauptMenue();
            hauptAusfuehrenFunktion();
        } catch ( IllegalArgumentException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace(); - Debug
            input.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Hier muessen Sie Zahlen eingeben!!");
            //e.printStackTrace(); - Debug
            input.nextLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace(System.out);
        }
    }

    /**
     * Ausfuehren der ausgewaehlten Funktion
     */
    private void hauptAusfuehrenFunktion() throws IOException {
        funktion = einlesenFunktion();
        switch (funktion) {
            case AUTOMAT_ERSTELLEN:
                automatMenueDialog();
                break;
            case BEENDEDEN:
                programmBeenden();
            default:
                System.out.println("Falsche Eingabe!!!");
                return;
        }
    }

    /**
     * Liest eine Funktion ein.
     *
     * @return eingelesene Funktion als ganzzahliger Wert
     */
    private int einlesenFunktion() {
        int funktion = input.nextInt();
        input.nextLine();
        return funktion;
    }

    /**
     * Gibt das Hauptmenue auf dem Bildschirm aus.
     */
    private void hauptMenue() {
        System.out.print("\n"
            + "Automat anlegen --> " + AUTOMAT_ERSTELLEN + "\n"
            + "beenden --> " + BEENDEDEN + "\n"
            + "--> "
        );
    }

    /**
     * einlese funktion und  automat Menue Dialog
     * @throws IOException
     */
    private void automatMenueDialog() throws IOException {
        System.out.print("\n"
            + "Alkoholische Getraenke Automat --> " + ALKOHOLISCHE_GETRAENK + "\n"
            + "Alkoholfreie Getraenke Automat -->" + ALKOHOLFREIE_GETRAENK + "\n"
            + "Wasser Automat --> " + WASSER + "\n"
            + "Soft drink Automat --> " + SOFT_DRINK + "\n"
            + "Bier Automat --> " + BIER + "\n"
            + "Wein Automat --> " + WEIN + "\n"
            + "beenden --> " + BEENDEDEN + "\n"
            + "--> "
        );

        automatAusfuehrenFunktion();
    }
    
    /**
     * automatAusfuehren methode
     * @throws IOException
     */
    private void automatAusfuehrenFunktion() throws IOException {
        funktion = einlesenFunktion();
        switch (funktion) {
            case ALKOHOLISCHE_GETRAENK:
                automatAnlegen(GetraenkTyp.ALKOHOLISCHE_TYP);
                break;
            case ALKOHOLFREIE_GETRAENK:
                automatAnlegen(GetraenkTyp.ALKOHOLFREIE_TYP);
                break;
            case WASSER:
                automatAnlegen(GetraenkTyp.WASSER_TYP);
                break;
            case WEIN:
                automatAnlegen(GetraenkTyp.WEIN_TYP);
                break;
            case BIER:
                automatAnlegen(GetraenkTyp.BIER_TYP);
                break;
            case SOFT_DRINK:
                automatAnlegen(GetraenkTyp.SOFTDRINK_TYP);
                break;
            case BEENDEDEN:
                programmBeenden();
            default:
                System.out.println("Falsche Eingabe!!");
                break;

        }
    }

    /**
     * automat im arraylist speichern
     * @param getraenkTyp
     * @throws IOException
     */
    private void automatAnlegen(GetraenkTyp getraenkTyp) throws IOException {
        System.out.print("Kapazitaet: ");
        int kapazitaet = input.nextInt();
        input.nextLine();

        switch (getraenkTyp) {
            case ALKOHOLFREIE_TYP:
                automat = new Getraenkautomat<AlkoholfreiesGetraenk>(kapazitaet);
                break;
            case ALKOHOLISCHE_TYP:
                automat = new Getraenkautomat<AlkoholischesGetraenk>(kapazitaet);
                break;
            case WASSER_TYP:
                automat = new Getraenkautomat<Wasser>(kapazitaet);
                break;
            case BIER_TYP:
                automat = new Getraenkautomat<Bier>(kapazitaet);
                break;
            case WEIN_TYP:
                automat = new Getraenkautomat<Wein>(kapazitaet);
                break;
            case SOFTDRINK_TYP:
                automat = new Getraenkautomat<SoftDrink>(kapazitaet);
                break;
            default:
                throw new IllegalArgumentException("Falsche Eingabe!!");
        }

        automatDialog(getraenkTyp);
    }

    /**
     * einlese funktion und Liste dialog
     * @param getraenkTyp
     * @throws IOException
     */
    private void automatDialog(GetraenkTyp getraenkTyp) throws IOException {
        System.out.print("\n"
            + "Flasche hinzufuegen --> " + FLASCHE_ANLEGEN + "\n"
            + "Alle Inhalte ausgeben --> " + ALLE_INHALTE_AUSGEBEN + "\n"
            + "Erste Flasche ausgeben --> " + ERSTE_FLASCHE_AUSGEBEN + "\n"
            + "Automat loeschen-->" + AUTOMAT_LOESCHEN + "\n"
            + "Ende-->" + BEENDEDEN + "\n"
            + " --> "
        );

        //einlese funktion
        funktion = einlesenFunktion();
        switch (funktion) {
            case FLASCHE_ANLEGEN:
                flaschenAnlegen(getraenkTyp);
                break;
            case ALLE_INHALTE_AUSGEBEN:
                alleFlaschenAusgeben(getraenkTyp);
                break;
            case ERSTE_FLASCHE_AUSGEBEN:
                ersteFlascheAusgeben(getraenkTyp);
                break;
            case AUTOMAT_LOESCHEN:
                automatLoeschen();
                break;
            case BEENDEDEN:
                System.out.println("Programm wird beendet....");
                break;
            default:
                System.out.println("Falsche Eingabe!!");
                break;
        }

    }

    /**
     * flasche im arraylist speichern
     * @param getraenkTyp
     * @throws IOException
     */
    private void flaschenAnlegen(GetraenkTyp getraenkTyp) throws IOException {
        Flasche<? extends Getraenk> flasche = null;
        switch (getraenkTyp) {
            case ALKOHOLFREIE_TYP:
                flasche = flaschenTypBestimmen(ALKOHOLFREIE_GETRAENK);
                break;
            case ALKOHOLISCHE_TYP:
                flasche = flaschenTypBestimmen(ALKOHOLISCHE_GETRAENK);
                break;
            case WASSER_TYP:
                flasche = flaschenTypBestimmen(WASSER);
                break;
            case WEIN_TYP:
                flasche = flaschenTypBestimmen(WEIN);
                break;
            case BIER_TYP:
                flasche = flaschenTypBestimmen(BIER);
                break;
            case SOFTDRINK_TYP:
                flasche = flaschenTypBestimmen(SOFT_DRINK);
                break;
            default:
                System.out.println("Falsche Eingabe!!");
                break;
        }
        if (flasche != null ) {
            if (automat.getSize() != automat.getKapazitaet()){
                automat.flascheEinlegen(flasche);
            }else{
                System.out.println("Es gibt kein Platz mehr im Automat!!");
            }

        }

        automatDialog(getraenkTyp);
    }

    private void alleFlaschenAusgeben(GetraenkTyp getraenkTyp) throws IOException {
        System.out.println(automat.toString());
        automatDialog(getraenkTyp);
    }

    private void ersteFlascheAusgeben(GetraenkTyp getraenkTyp) throws IOException {

        if (automat.getSize() > 0) {
            System.out.println(automat.flascheAusgeben().toString());
        } else {
            System.out.println("Keine Flasche im Automat!!");
        }
        automatDialog(getraenkTyp);
    }

    private void automatLoeschen() {
        automat = null;
        hauptMenueInput();
    }

    /**
     * diese ()Methode bestimmt der art des Weines
     * @param funktion
     * @return - flasche art
     */
    private Flasche<? extends Getraenk> flaschenTypBestimmen(int funktion) {
        Flasche<? extends Getraenk> flasche = null;

        switch (funktion) {
            case WASSER:
                flasche = new Flasche<Wasser>(wasserDialog());
                break;
            case WEIN:
                System.out.print("RotWein --> " + ROT_WEIN + "\n");
                System.out.print("WeissWein --> " + WEISS_WEIN + "\n");
                System.out.print("Ende --> " + BEENDEDEN + "\n" + "-->");
                funktion = einlesenFunktion();
                Wein weinTyp = weinTypBestimmen(funktion);
                if (weinTyp != null)
                    flasche = new Flasche<Wein>(weinTyp);
                break;
            case SOFT_DRINK:
                flasche = new Flasche<SoftDrink>(softDrinkDialog());
                break;
            case BIER:
                flasche = new Flasche<Bier>(bierDialog());
                break;
            case ALKOHOLFREIE_GETRAENK:
                AlkoholfreiesGetraenk typ = alkoholfreiesGetraenkDialog();
                if (typ != null)
                    flasche = new Flasche<AlkoholfreiesGetraenk>(typ);
                break;
            case ALKOHOLISCHE_GETRAENK:
                AlkoholischesGetraenk alkoholTyp = alkoholischesGetraenkDialog();
                if (alkoholTyp != null)
                    flasche = new Flasche<AlkoholischesGetraenk>(alkoholTyp);
                break;
            case BEENDEDEN:
                programmBeenden();
            default:
                System.out.println("Falsche Eingabe!!");
                break;
        }

        return flasche;
    }

    /**
     * diese ()Methode bestimmt der art des Weines
     * @param funktion
     * @return - wein art
     */
    private Wein weinTypBestimmen(int funktion) {
        Wein wein = null;
        switch (funktion) {
            case ROT_WEIN:
                wein = rotWeinDialog();
                break;
            case WEISS_WEIN:
                wein = weissweinDialog();
                break;
            case BEENDEDEN:
                programmBeenden();
            default:
                System.out.println("Falsche Eingabe!!");
                break;
        }

        return wein;
    }

    /**
     * diese ()Methode erstelt ein alkoholischesGetraenk klasse mit dem parameter die eingefugt wird.
     * @return - alkoholischesGetraenk
     */
    private AlkoholischesGetraenk alkoholischesGetraenkDialog() {
        AlkoholischesGetraenk alkoholischesGetraenk = null;
        System.out.print("\n"
            + "Rotwein: " + ROT_WEIN + "\n"
            + "WeissWein: " + WEISS_WEIN + "\n"
            + "Bier: " + BIER + "\n"
            + "Ende--> " + BEENDEDEN + "\n"
            + "-->"
        );

        funktion = einlesenFunktion();
        switch (funktion) {
            case ROT_WEIN:
                alkoholischesGetraenk = weinTypBestimmen(ROT_WEIN);
                break;
            case WEISS_WEIN:
                alkoholischesGetraenk = weinTypBestimmen(WEISS_WEIN);
                break;
            case BIER:
                alkoholischesGetraenk = bierDialog();
                break;
            case BEENDEDEN:
                programmBeenden();
            default:
                System.out.println("Flasche Eingabe!!");
        }

        return alkoholischesGetraenk;
    }

    /**
     * diese ()Methode erstelt ein AlkoholfreiesGetraenk klasse mit dem parameter die eingefugt wird.
     * @return - alkoholfreiesGetraenk
     */
    private AlkoholfreiesGetraenk alkoholfreiesGetraenkDialog() {
        AlkoholfreiesGetraenk alkoholfreiesGetraenk = null;

        System.out.print("\n"
            + "Wasser: " + WASSER + "\n"
            + "SoftDrink: " + SOFT_DRINK + "\n"
            + "Ende-->" + BEENDEDEN + "\n"
            + " --> ");
        funktion = einlesenFunktion();
        switch (funktion) {
            case WASSER:
                alkoholfreiesGetraenk = wasserDialog();
                break;
            case SOFT_DRINK:
                alkoholfreiesGetraenk = softDrinkDialog();
                break;
            case BEENDEDEN:
                programmBeenden();
            default:
                System.out.println("Flasche Eingabe!!");
                break;
        }

        return alkoholfreiesGetraenk;
    }

    /**
     * diese ()Methode drueckt  das "Programm wird beendet" aus.
     */
    private void programmBeenden() {
        System.out.println("Programm wird beendet...");
        System.exit(0);
    }

    /**
     * diese ()Methode erstelt ein SoftDrink klasse mit dem parameter die eingefugt wird.
     * @return - neue SoftDrink objekt (mit ein zuckergehalt , und das hersteler).
     */
    private SoftDrink softDrinkDialog(){
        System.out.print("Zuckergehalt: ");
        float zuckergehalt = input.nextFloat();
        input.nextLine();
        System.out.print("Hersteller: ");
        String softDrinkHersteller = input.nextLine();
        return new SoftDrink(zuckergehalt, softDrinkHersteller);
    }

    /**
     * diese ()Methode erstelt ein Bier klasse mit dem parameter die eingefugt wird.
     * @return - neue Bier objekt (mit ein Brauerei , und das Alkoholgehalt).
     */
    private Bier bierDialog(){
        System.out.print("brauerei: ");
        String brauerei = input.nextLine();
        System.out.print("Alkohol_Gehalt= ");
        float alkoholgehalt = input.nextFloat();
        input.nextLine();
        return new Bier(brauerei, alkoholgehalt);
    }

    /**
     * diese ()Methode erstelt ein Weisswein klasse mit dem parameter die eingefugt wird.
     * @return - neue Weisswein objekt (mit ein Weingut , und das Alkoholgehalt).
     */
    private Weisswein weissweinDialog(){
        System.out.print("Weingut: ");
        String weingut = input.nextLine();
        System.out.print("gehalt: ");
        float alkoholgehalt = input.nextFloat();
        input.nextLine();
        return new Weisswein(weingut, alkoholgehalt);
    }

    /**
     * diese ()Methode erstelt ein Rotwein klasse mit dem parameter die eingefugt wird.
     * @return - neue Rotwein objekt (mit ein Weingut , und das Alkoholgehalt).
     */
    private Rotwein rotWeinDialog(){
        System.out.print("Weingut: ");
        String weingut = input.nextLine();
        System.out.print("gehalt: ");
        float alkoholgehalt = input.nextFloat();
        input.nextLine();
        return new Rotwein(weingut, alkoholgehalt);
    }

    /**
     * diese ()Methode erstelt ein Wasser klasse mit dem parameter die eingefugt wird.
     * @return - neue Wasser objekt (mit ein quelle , und Hersteller).
     */
    private Wasser wasserDialog(){
        System.out.print("Quelle: ");
        String quelle = input.nextLine();
        System.out.print("Hersteller: ");
        String hersteller = input.nextLine();
        return new Wasser(quelle, hersteller);
    }

}

