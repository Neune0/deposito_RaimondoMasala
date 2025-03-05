import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioEreditarieta {
    public static void main(String[] args) {
        Scanner stringScanner = new Scanner(System.in);
        Scanner intScanner = new Scanner(System.in);
        Ristorante ristorante = new Ristorante("i briganti");
        Utente utenteAusiliario;
        Chef chefAusiliario;
        Critico criticoAusiliario;
        ChefCapo chefCapoAusiliario;
        CriticoForte criticoForteAusiliario;
        String risposta = "";

        int scelta = 0;
        do {
            scelta = menuIniziale(intScanner);
            switch (scelta) {
                case 1:
                    // login
                    utenteAusiliario = ristorante.login(stringScanner);
                    // qui mettere menu per diventare chef o critico
                    if (utenteAusiliario != null) {
                        //PROBLEM  qui controllare con instance of e saltare scelta di diventare chef o critico
                        System.out.println("vuoi diventare chef o critico?");
                        System.out.println("1. chef");
                        System.out.println("2. critico");
                        System.out.println("3. esci");
                        int sceltaRuolo = intScanner.nextInt();
                        switch (sceltaRuolo) {
                            case 1:
                                // diventa chef problema di downcasting
                                chefAusiliario = new Chef(utenteAusiliario.getnome(), utenteAusiliario.getEmail(),
                                        utenteAusiliario.getSoldi(), utenteAusiliario.getPassword());
                                chefAusiliario.saluta();
                                // tolgo utente ausiliario da lista utenti in ristorante
                                ristorante.removeUtente(utenteAusiliario);
                                // aggiungo chef alla lista utenti in ristorante
                                ristorante.addUtente(chefAusiliario);
                                // mi riprendo lo chef
                                chefAusiliario = ristorante.getChef(chefAusiliario);

                                // in quanto chef posso creare dei piatti
                                risposta = "";
                                do {
                                    System.out.println("creazione piatto, se non vuoi piu creare piatti scrivi basta");
                                    risposta = stringScanner.nextLine();
                                    if (!risposta.equals("basta")) {
                                        System.out.println("inserisci il nome del piatto");
                                        String nomePiatto = stringScanner.nextLine();
                                        System.out.println("inserisci il costo del piatto");
                                        float costo = stringScanner.nextFloat();
                                        ristorante.piatti.add(new Piatto(nomePiatto, costo));
                                        chefAusiliario.incrementaPiattiCreati();
                                        if (chefAusiliario.getNumeroPiattiCreati() == 3) {
                                            System.out.println("hai creato 3 piatti, sei diventato chef capo");
                                            ristorante.removeUtente(chefAusiliario);
                                            chefCapoAusiliario = new ChefCapo(chefAusiliario.getnome(),
                                                    chefAusiliario.getEmail(), chefAusiliario.getSoldi(),
                                                    chefAusiliario.getPassword());
                                            ristorante.addUtente(chefCapoAusiliario);
                                            chefCapoAusiliario.saluta();
                                        }
                                    }

                                } while (risposta.equals("basta"));

                                break;
                            case 2:
                                // diventa critico
                                criticoAusiliario = new Critico(utenteAusiliario.getnome(), utenteAusiliario.getEmail(),
                                        utenteAusiliario.getSoldi(), utenteAusiliario.getPassword());
                                criticoAusiliario.saluta();
                                // tolgo utente ausiliario da lista utenti in ristorante
                                ristorante.removeUtente(utenteAusiliario);
                                // aggiungo critico alla lista utenti in ristorante
                                ristorante.addUtente(criticoAusiliario);

                                // in quanto critico posso fare una valutazione
                                risposta = "";
                                do {
                                    System.out.println(
                                            "vuoi fare una valutazione? se si scrivi si, altrimenti scrivi basta");
                                    risposta = stringScanner.nextLine();
                                    if (!risposta.equals("basta")) {
                                        ristorante.printPiatti();
                                        System.out.println("inserisci il numero del piatto che vuoi valutare");
                                        int numeroPiatto = intScanner.nextInt();
                                        System.out.println("inserisci il voto");
                                        int voto = intScanner.nextInt();
                                        ristorante.addValutaione(
                                                new Valutazione(voto, ristorante.getPiattoByPos(numeroPiatto)));
                                        criticoAusiliario.incrementaValutazioniFatte();
                                        if (criticoAusiliario.getNumeroValutazioniFatte() == 3) {
                                            System.out.println("hai fatto 3 valutazioni, sei diventato critico forte");
                                            ristorante.removeUtente(criticoAusiliario);
                                            criticoForteAusiliario = new CriticoForte(criticoAusiliario.getnome(),
                                                    criticoAusiliario.getEmail(), criticoAusiliario.getSoldi(),
                                                    criticoAusiliario.getPassword());
                                            ristorante.addUtente(criticoForteAusiliario);
                                            criticoForteAusiliario.saluta();
                                        }
                                    }

                                } while (!risposta.equals("basta"));

                                break;
                            case 3:
                                // esci
                                break;
                        }
                    }
                    break;
                case 2:
                    // registrazione
                    ristorante.addUtente(Utente.createUtente(stringScanner));
                    break;
            }
        } while (scelta != 3);
        stringScanner.close();
        intScanner.close();
    }

    public static int menuIniziale(Scanner intScanner) {
        System.out.println("1. login");
        System.out.println("2. registrati");
        System.out.println("3. esci");
        return intScanner.nextInt();
    }
}

class Utente {
    private String nome;
    private String email;
    private float soldi;
    private String password;

    public Utente(String nome, String email, float soldi, String password) {
        this.nome = nome;
        this.email = email;
        this.soldi = soldi;
        this.password = password;
    }

    public String getnome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public float getSoldi() {
        return soldi;
    }

    public String getPassword() {
        return password;
    }

    public void setSoldi(float soldi) {
        this.soldi = soldi;
    }

    public static Utente createUtente(Scanner stringScanner) {
        System.out.println("inserisci il nome");
        String nome = stringScanner.nextLine();
        System.out.println("inserisci l'email");
        String email = stringScanner.nextLine();
        System.out.println("inserisci la password");
        String password = stringScanner.nextLine();
        // i soldi li genero random
        float soldi = (float) Math.random() * 50;
        return new Utente(nome, email, soldi, password);

    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Utente) {
            Utente utente = (Utente) obj;
            return utente.getEmail().equals(this.email) && utente.getPassword().equals(this.password)
                    && utente.getnome().equals(this.nome);
        }
        return false;
    }

}

class Ristorante {
    private String nomeRistorante;
    public ArrayList<Piatto> piatti;
    public ArrayList<Valutazione> valutazioni;
    public ArrayList<Utente> utenti;

    public Ristorante(String nomeRistorante) {
        this.nomeRistorante = nomeRistorante;
        this.piatti = new ArrayList<Piatto>();
        this.valutazioni = new ArrayList<Valutazione>();
        this.utenti = new ArrayList<Utente>();
    }

    public Piatto getPiattoByPos(int pos) {
        return piatti.get(pos);
    }

    public void addUtente(Utente utente) {
        utenti.add(utente);
    }

    public void addValutaione(Valutazione valutazione) {
        valutazioni.add(valutazione);
    }

    public Utente login(Scanner stringScanner) {
        System.out.println("inserisci l'email");
        String email = stringScanner.nextLine();
        System.out.println("inserisci la password");
        String password = stringScanner.nextLine();
        for (Utente utente : utenti) {
            if (utente.getEmail().equals(email) && utente.getPassword().equals(password)) {
                System.out.println("benvenuto " + utente.getnome());
                utente.setSoldi((float) (Math.random() * 50));
                return utente;
            }
        }
        System.out.println("login fallito");
        return null;
    }

    public void removeUtente(Utente utente) {
        utenti.remove(utente);
    }

    public void printPiatti() {
        // mi serve un indice cosi lo attacco in ogni piatto
        for (int i = 0; i < piatti.size(); i++) {
            System.out.println(i + ". " + piatti.get(i).getNomePiatto() + " " + piatti.get(i).getCosto());
        }
    }

    public Chef getChef(Chef chef) {
        for (Utente utente : utenti) {
            if (utente instanceof Chef) {
                Chef chefAusiliario = (Chef) utente;
                if (chefAusiliario.equals(chef)) {
                    return chefAusiliario;
                }
            }
        }
        return null;
    }

}

class Piatto {
    private String nomePiatto;
    private float costo;

    public Piatto(String nomePiatto, float costo) {
        this.nomePiatto = nomePiatto;
        this.costo = costo;
    }

    public String getNomePiatto() {
        return nomePiatto;
    }

    public float getCosto() {
        return costo;
    }

}

class Valutazione {
    private int voto;
    private Piatto piattoValutato;

    public Valutazione(int voto, Piatto piattoValutato) {
        this.voto = voto;
        this.piattoValutato = piattoValutato;
    }

    public int getVoto() {
        return voto;
    }

}

class Chef extends Utente {
    private int numeroPiattiCreati;

    public Chef(String nome, String email, float soldi, String password) {
        super(nome, email, soldi, password);
        numeroPiattiCreati = 0;
    }

    public void saluta() {
        System.out.println("ciao, sono uno chef adesso e mi chiamo: " + getnome());
    }

    public void incrementaPiattiCreati() {
        numeroPiattiCreati++;
    }

    public int getNumeroPiattiCreati() {
        return numeroPiattiCreati;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Chef) {
            Chef chef = (Chef) obj;
            return chef.getEmail().equals(this.getEmail()) && chef.getPassword().equals(this.getPassword())
                    && chef.getnome().equals(this.getnome());
        }
        return false;
    }

}

class Critico extends Utente {
    private int numeroValutaioniFatte;

    public Critico(String nome, String email, float soldi, String password) {
        super(nome, email, soldi, password);
        numeroValutaioniFatte = 0;
    }

    public void incrementaValutazioniFatte() {
        numeroValutaioniFatte++;
    }

    public void saluta() {
        System.out.println("ciao, sono un critico adesso e mi chiamo: " + getnome());
    }

    public int getNumeroValutazioniFatte() {
        return numeroValutaioniFatte;
    }

}

class ChefCapo extends Chef {
    public ChefCapo(String nome, String email, float soldi, String password) {
        super(nome, email, soldi, password);
    }

    @Override
    public void saluta() {
        System.out.println("cioa, sono uno chef capo adesso e mi chiamo: " + getnome());
    }

}

class CriticoForte extends Critico {
    public CriticoForte(String nome, String email, float soldi, String password) {
        super(nome, email, soldi, password);
    }

    @Override
    public void saluta() {
        System.out.println("ciao, sono un critico forte adesso e mi chiamo: " + getnome());
    }

}