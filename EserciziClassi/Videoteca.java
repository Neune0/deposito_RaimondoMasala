import java.util.ArrayList;
import java.util.Scanner;

public class Videoteca {
    ArrayList<Utente> utenti = new ArrayList<Utente>();
    ArrayList<Film> film = new ArrayList<Film>();
    ArrayList<Film> filmNoleggiati = new ArrayList<Film>();

    public static void main(String[] args) {
        Videoteca v = new Videoteca();
        Scanner myIntScanner = new Scanner(System.in);
        Scanner myStringScanner = new Scanner(System.in);
        int scelta = 0;
        do {
            scelta = printMenuIniziale(myIntScanner);
            switch (scelta) {
                case 1:
                    // aggiungi utente ok
                    v.addUtente(getInfoUtente(myStringScanner));
                    break;
                case 2:
                    // aggiungi film ok
                    v.addFilm(getInfoFilm(myIntScanner, myStringScanner));
                    break;
                case 3:
                    // rimuovi film ok
                    v.deleteFilm(v.selectFilm(myIntScanner));
                    break;
                case 4:
                    // noleggia film
                    // devo fargli scegliere il film e l'utente
                    // seleziona utente
                    Utente u = v.scegliUtente(myIntScanner);
                    if(u==null){
                        break;
                    }
                    // seleziona film
                    Film f = v.selectFilm(myIntScanner);
                    if(f==null){
                        break;
                    }
                    u.noleggiaFilm(f);
                    v.deleteFilm(f);
                    v.addFilmInNoleggiati(f);
                    // forse qui devo sovrascrivere in lista utenti di videoteca l'utente che ha noleggiato il film
                    // non è necessario test fatto

                    break;
                case 5:
                    // stampa film noleggiati da utente
                    v.stampaFilmNoleggiatiDaUtente(v.scegliUtente(myIntScanner));
                    break;
                case 6:
                    // stampa utenti
                    v.stampaUtenti();
                    break;
                case 7:
                    // stampa lista film
                    v.stampaFilm();
                    break;
                case 8:
                    // ricerca film per titolo
                    Film filmPerTitolo = v.getFilmByTitolo(myStringScanner);
                    if (filmPerTitolo != null) {
                        System.out.println(filmPerTitolo);
                    }
                    break;
                case 9:
                    // ricerca film per anno di uscita
                    ArrayList<Film> filmTrovati = v.getFilmsByAnno(myIntScanner);
                    if (filmTrovati.size() == 0) {
                        System.out.println("Nessun film trovato");
                    } else {
                        for (Film film : filmTrovati) {
                            System.out.println(film);
                        }
                    }
                    break;
                case 10:
                    // esci
                    System.out.println("Arrivederci");
                    break;

                default:
                    System.out.println("Scelta non valida");
                    break;
            }
        } while (scelta != 10);
    }

    // usata per ricerca film
    public ArrayList<Film> getFilmsByAnno(Scanner myIntScanner) {
        int scelta = 0;
        System.out.println("Inserisci anno di uscita: ");
        scelta = myIntScanner.nextInt();
        ArrayList<Film> filmTrovati = new ArrayList<Film>();
        for (Film f : this.film) {
            if (f.getAnnoDiUscita() == scelta) {
                filmTrovati.add(f);
            }
        }
        return filmTrovati;
    }

    public static int printMenuIniziale(Scanner myIntScanner) {
        int scelta = 0;
        System.out.println("-----------------------------------");
        System.out.println("MENU INIZIALE");
        System.out.println("1. Aggiungi utente");
        System.out.println("2. Aggiungi film");
        System.out.println("3. Rimuovi film");
        System.out.println("4. Noleggia film");
        System.out.println("5. Stampa film noleggiati da utente");
        System.out.println("6. Stampa utenti");
        System.out.println("7. Stampa film");
        System.out.println("8. Ricerca film per titolo");
        System.out.println("9. Ricerca film per anno di uscita");
        System.out.println("10. Esci");
        System.out.println("Inserisci scelta: ");
        scelta = myIntScanner.nextInt();
        return scelta;
    }

    public void stampaUtenti() {
        if (this.utenti.size() == 0) {
            System.out.println("Nessun utente presente");
        }
        for (Utente u : this.utenti) {
            System.out.println(u);
        }
    }

    public void stampaFilm() {
        if (this.film.size() == 0) {
            System.out.println("Nessun film presente");
        }
        for (Film f : this.film) {
            System.out.println(f);
        }
    }

    public void stampaFilmNoleggiatiDaUtente(Utente u) {
        u.printNoleggiati();
    }

    public Utente scegliUtente(Scanner myIntScanner) {
        int scelta = 0;
        if(this.utenti.size()==0){
            System.out.println("Nessun utente presente");
            return null;
        }
        System.out.println("Seleziona l'utente: ");
        for (int i = 0; i < utenti.size(); i++) {
            System.out.println(i + ". " + this.utenti.get(i).getNome());
        }
        scelta = myIntScanner.nextInt();
        if(scelta<0 || scelta>=utenti.size()){
            System.out.println("selezione non valida");
            return null;
        }
        return this.utenti.get(scelta);
    }

    public void addUtente(Utente u) {
        this.utenti.add(u);
    }

    public void deleteFilm(Film f) {
        if(f==null){
            return;
        }
        this.film.remove(f);
    }

    public void addFilm(Film f) {
        this.film.add(f);
    }

    public void addFilmInNoleggiati(Film f){
        this.filmNoleggiati.add(f);
    }

    public static Utente getInfoUtente(Scanner myStringScanner) {
        System.out.println("Inserisci id utente: ");
        String idUtente = myStringScanner.nextLine();
        System.out.println("Inserisci nome utente: ");
        String nome = myStringScanner.nextLine();
        return new Utente(idUtente, nome);
    }

    public static Film getInfoFilm(Scanner myIntScanner, Scanner myStringScanner) {
        System.out.println("Inserisci titolo film: ");
        String titolo = myStringScanner.nextLine();
        System.out.println("Inserisci anno di uscita: ");
        int anno = myIntScanner.nextInt();
        return new Film(titolo, anno);
    }

    public Film getFilmByTitolo(Scanner myStringScanner) {
        System.out.println("Inserisci titolo film: ");
        String titolo = myStringScanner.nextLine();
        for (Film f : this.film) {
            if (f.getTitolo().equals(titolo)) {
                return f;
            }
        }
        System.out.println("Film non trovato");
        return null;
    }

    public Film selectFilm(Scanner myIntScanner){
        int scelta = 0;
        System.out.println("Seleziona il film: ");
        for (int i = 0; i < film.size(); i++) {
            System.out.println(i + ". " + this.film.get(i).getTitolo());
        }
        scelta = myIntScanner.nextInt();
        if(scelta<0 || scelta>=film.size()){
            System.out.println("selezione non valida");
            return null;
        }
        return this.film.get(scelta);
    }

    public static String scegliTitoloFilm() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Inserisci titolo film: ");
        String titolo = myScanner.nextLine();
        myScanner.close();
        return titolo;
    }
}

class Utente {
    private String idUtente;
    private String nome;
    private ArrayList<Film> filmNoleggiati;

    public Utente(String idUtente, String nome) {
        this.idUtente = idUtente;
        this.nome = nome;
        this.filmNoleggiati = new ArrayList<Film>();
    }

    public ArrayList<Film> getFilmNoleggiati() {
        return filmNoleggiati;
    }

    public String getIdUtente() {
        return idUtente;
    }

    public String getNome() {
        return nome;
    }

    public void setFilmNoleggiati(ArrayList<Film> filmNoleggiati) {
        this.filmNoleggiati = filmNoleggiati;
    }

    public void setIdUtente(String idUtente) {
        this.idUtente = idUtente;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void noleggiaFilm(Film f) {
        if (filmNoleggiati.size() >= 3) {
            System.out.println("L'utente ha già noleggiato 3 film");
            return;
        }
        filmNoleggiati.add(f);
    }

    public void printNoleggiati() {
        for (Film f : filmNoleggiati) {
            System.out.println(f);
        }
    }

    @Override
    public String toString() {
        return "Utente [idUtente=" + this.idUtente + ", nome=" + this.nome + "]";
    }
}

class Film {
    private String titolo;
    private int annoDiUscita;

    public Film(String titolo, int annoDiUscita) {
        this.titolo = titolo;
        this.annoDiUscita = annoDiUscita;
    }

    @Override
    public String toString() {
        return "Film [titolo=" + this.titolo + ", annoDiUscita=" + this.annoDiUscita + "]";
    }

    public int getAnnoDiUscita() {
        return annoDiUscita;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setAnnoDiUscita(int annoDiUscita) {
        this.annoDiUscita = annoDiUscita;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
}
