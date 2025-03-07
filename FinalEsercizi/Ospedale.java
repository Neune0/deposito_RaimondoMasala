/*Obiettivo: Implementare una simulazione testuale di gestione di un ospedale che dimostri chiaramente 
l'applicazione delle tre regole fondamentali della programmazione orientata agli oggetti:
Incapsulamento, Ereditarietà e Polimorfismo.
*/

/* classe persona
Classe Persona (Classe Base)
Campi incapsulati:
nome (String)
cognome (String)
Metodi getter e setter (Incapsulamento).
Classi derivate:
Medico (estende Persona)
Campo specifico: specializzazione (String).
Metodo sovrascritto: stampaRuolo() che stampa il ruolo del medico.
Paziente (estende Persona)
Campo specifico: codicePaziente (int).
Metodo sovrascritto: stampaRuolo() che stampa il ruolo del paziente.
*/
/* classe principale ospedale
Polimorfismo:
Implementare una classe principale Ospedale con metodo:
public static void stampaInfoPersona(Persona p) {
 p.stampaRuolo();
 System.out.println("Nome: " + p.getNome());
 System.out.println("Cognome: " + p.getCognome());
}
Utilizzare polimorfismo per stampare le informazioni di almeno un medico e un paziente attraverso lo stesso metodo.
*/

/*Compito dello studente:

Creare minimo le classi sopra descritte con incapsulamento appropriato.
Implementare l'ereditarietà correttamente fra Persona, Medico e Paziente.
Sfruttare il polimorfismo chiamando lo stesso metodo con istanze diverse.
Fornire un output testuale che mostri chiaramente l'utilizzo di tutte e tre le regole.
Gestire tramite un menu l’inserimento e il controllo dei dati su due utenti di tipo diverso
Gestire tramite try - catch gli inserimenti da utente
*/

/* Esempio output:

Esempio di Output:

Ruolo: Medico

Nome: Luca

Cognome: Bianchi

Specializzazione: Cardiologia

Ruolo: Paziente

Nome: Marco

Cognome: Rossi

Codice Paziente: 12345 */

package FinalEsercizi;

import java.util.ArrayList;
import java.util.Scanner;

// Classe principale Ospedale
/**
 * Classe Ospedale
 * 
 * Questa classe rappresenta un'entità ospedaliera che contiene una lista di
 * persone
 * 
 * @attribute persone lista di persone presenti nell'ospedale
 * @method costruttore di default
 * @method costruttore con parametri accetta una arraylist di persone
 * @method stampaInfoPersona stampa le informazioni di una persona
 * @method stampaPersone stampa le informazioni di tutte le persone presenti
 * @method addPersona aggiunge una persona alla lista
 * @method removePersona rimuove una persona dalla lista
 * @method main metodo principale
 * 
 * @version 1.0
 * @since 1.0
 */
public class Ospedale {

    ArrayList<Persona> persone;

    public Ospedale() {
        this.persone = new ArrayList<>();
    }

    public Ospedale(ArrayList<Persona> persone) {
        this.persone = persone;

    }

    public static void stampaInfoPersona(Persona p) {
        p.stampaRuolo();
        System.out.println("Nome: " + p.getNome());
        System.out.println("Cognome: " + p.getCognome());
        System.out.println();
    }

    public void stampaPersone() {
        // lo faccio con un for esplicito, cosi attacco un indice
        for (int i = 0; i < persone.size(); i++) {
            System.out.println("Persona " + i);
            stampaInfoPersona(persone.get(i));
        }
    }

    public void addPersona(Persona p) {

        if (persone.contains(p)) {
            System.out.println("Persona gia presente, inserimento fallito");
            return;
        }

        persone.add(p);
    }

    public void removePersona(Persona p) {
        if (!persone.contains(p)) {
            System.out.println("Persona non presente, rimozione fallita");
            return;
        }
        persone.remove(p);
    }

    public static void main(String[] args) {
        Medico medico = new Medico("Luca", "Bianchi", "Cardiologia");
        Paziente paziente = new Paziente("Marco", "Rossi", 12345);

        stampaInfoPersona(medico);
        stampaInfoPersona(paziente);

        Ospedale ospedale = new Ospedale();
        InputHelper inputHelper = new InputHelper();
        SelectMenu menu = new SelectMenu(
                new String[] { "Aggiungi Persona", "Rimuovi Persona", "Stampa Persone", "Exit" });
        boolean exit = false;
        int choice = 0;
        do {
            menu.printMenu();
            choice = menu.getChoice();
            SceltaMenu sceltaMenu = SceltaMenu.getScelta(choice);

            switch (sceltaMenu) {
                case ADD_PERSONA:
                    // scelta del ruolo
                    SelectMenu ruoloMenu = new SelectMenu(new String[] { "Medico", "Paziente" });
                    int ruoloChoice = 0;
                    do {
                        ruoloMenu.printMenu();
                        ruoloMenu.processChoice();
                        ruoloChoice = ruoloMenu.getChoice();
                        Ruolo ruolo = Ruolo.getRuolo(ruoloChoice);
                        switch (ruolo) {
                            case MEDICO:
                                System.out.println("Inserisci il nome del medico");
                                String nomeMedico = inputHelper.getString();
                                System.out.println("Inserisci il cognome del medico");
                                String cognomeMedico = inputHelper.getString();
                                System.out.println("Inserisci la specializzazione del medico");
                                String specializzazione = inputHelper.getString();
                                Medico m = new Medico(nomeMedico, cognomeMedico, specializzazione);
                                ospedale.addPersona(m);
                                break;
                            case PAZIENTE:
                                System.out.println("Inserisci il nome del paziente");
                                String nomePaziente = inputHelper.getString();
                                System.out.println("Inserisci il cognome del paziente");
                                String cognomePaziente = inputHelper.getString();
                                System.out.println("Inserisci il codice del paziente");
                                int codicePaziente = inputHelper.getInt();
                                Paziente p = new Paziente(nomePaziente, cognomePaziente, codicePaziente);
                                ospedale.addPersona(p);
                                break;
                            default:
                                break;
                        }
                    } while (ruoloMenu.checkChoice(ruoloChoice));
                    break;
                case REMOVE_PERSONA:
                    System.out.println("Inserisci il nome della persona da rimuovere");
                    String nomePersona = inputHelper.getString();
                    System.out.println("Inserisci il cognome della persona da rimuovere");
                    String cognomePersona = inputHelper.getString();
                    Persona persona = new Persona(nomePersona, cognomePersona);
                    ospedale.removePersona(persona);
                    break;
                case STAMPA_PERSONE:
                    ospedale.stampaPersone();
                    break;
                case EXIT:
                    exit = true;
                    break;

                default:
                    break;
            }

        } while (menu.checkChoice(choice) && !exit);

    }
}

enum Ruolo {
    MEDICO,
    PAZIENTE;

    public static Ruolo getRuolo(int i) {
        return Ruolo.values()[i];
    }
}

// Classe Base Persona
class Persona {
    private String nome;
    private String cognome;

    public Persona(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void stampaRuolo() {
        System.out.println("Ruolo: Persona");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Persona) {
            Persona p = (Persona) obj;
            return nome.equals(p.nome) && cognome.equals(p.cognome);
        }
        return false;
    }
}

// Classe derivata Medico
class Medico extends Persona {
    private String specializzazione;

    public Medico(String nome, String cognome, String specializzazione) {
        super(nome, cognome);
        this.specializzazione = specializzazione;
    }

    @Override
    public void stampaRuolo() {
        System.out.println("Ruolo: Medico");
        System.out.println("Specializzazione: " + specializzazione);
    }
}

// Classe derivata Paziente
class Paziente extends Persona {
    private int codicePaziente;

    public Paziente(String nome, String cognome, int codicePaziente) {
        super(nome, cognome);
        this.codicePaziente = codicePaziente;
    }

    @Override
    public void stampaRuolo() {
        System.out.println("Ruolo: Paziente");
        System.out.println("Codice Paziente: " + codicePaziente);
    }
}

class InputHelper {
    Scanner intScanner = null;
    Scanner stringScanner = null;

    public InputHelper() {
        this.intScanner = new Scanner(System.in);
        this.stringScanner = new Scanner(System.in);
    }

    public void close() {
        this.intScanner.close();
        this.stringScanner.close();
    }

    public int getInt() {
        return this.intScanner.nextInt();
    }

    public String getString() {
        return this.stringScanner.nextLine();
    }
}

class SelectMenu {
    private InputHelper inputHelper;
    private ArrayList<String> options;
    private int choice;

    public SelectMenu(String[] oprions) {
        this.inputHelper = new InputHelper();
        this.options = new ArrayList<>(options);
        this.choice = 0;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public int getChoice() {
        return this.choice;
    }

    public void close() {
        this.inputHelper.close();
    }

    public void printMenu() {
        for (int i = 0; i < options.size(); i++) {
            System.out.println(i + " - " + options.get(i));
        }
    }

    public void processChoice() {
        this.setChoice(inputHelper.getInt());
    }

    public boolean checkChoice(int choice) {
        return choice >= 0 && choice < options.size();
    }

}

enum SceltaMenu {
    ADD_PERSONA,
    REMOVE_PERSONA,
    STAMPA_PERSONE,
    EXIT;

    public static SceltaMenu getScelta(int i) {
        return SceltaMenu.values()[i];
    }
}