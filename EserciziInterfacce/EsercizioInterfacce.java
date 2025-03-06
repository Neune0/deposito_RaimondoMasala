package EserciziInterfacce;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class EsercizioInterfacce {
    public static void main(String[] args) {
        // qui menu iniziale che mi fa inserire o rimuovere un prodotto o stampare il
        // resoconto dei prodotti o applicare gli sconti automatici o acquistare un prodotto o visualizzare i punti fedelta o uscire
        int scelta = 0;
        int sceltaTipoProdotto = 0;
        int puntiFedelta = 0;
        Scanner intScanner = new Scanner(System.in);
        Scanner stringScanner = new Scanner(System.in);
        GestoreProdotti gestoreProdotti = new GestoreProdotti();
        do {
            System.out.println("1. Aggiungi prodotto");
            System.out.println("2. Rimuovi prodotto");
            System.out.println("3. Stampa resoconto");
            System.out.println("4. Applica sconti");
            System.out.println("5. Aquista un prodotto");
            System.out.println("6. Visualizza i miei punti fedelta");
            System.out.println("7. Esci");
            scelta = intScanner.nextInt();

            switch (scelta) {
                case 1:
                    // aggiungere prodotto
                    System.out.println("1. Prodotto alimentare");
                    System.out.println("2. Prodotto elettronico");
                    System.out.println("3. Prodotto abbigliamento");
                    sceltaTipoProdotto = intScanner.nextInt();
                    switch (sceltaTipoProdotto) {
                        case 1:
                            // prodotto alimentare
                            System.out.println("Inserisci il codice");
                            int codice = intScanner.nextInt();
                            System.out.println("Inserisci il nome");
                            String nome = stringScanner.nextLine();
                            System.out.println("Inserisci il prezzo");
                            double prezzo = intScanner.nextDouble();
                            System.out.println("Inserisci la data di scadenza");
                            String dataScadenza = stringScanner.nextLine();
                            Alimentare alimentare = new Alimentare(codice, nome, prezzo, new Date(dataScadenza));
                            gestoreProdotti.aggiungiProdotto(alimentare);
                            break;
                        case 2:
                            // prodotto elettronico
                            System.out.println("Inserisci il codice");
                            codice = intScanner.nextInt();
                            System.out.println("Inserisci il nome");
                            nome = stringScanner.nextLine();
                            System.out.println("Inserisci il prezzo");
                            prezzo = intScanner.nextDouble();
                            System.out.println("Inserisci la garanzia in numero mesi");
                            int garanzia = intScanner.nextInt();
                            Elettronico elettronico = new Elettronico(codice, nome, prezzo, garanzia);
                            gestoreProdotti.aggiungiProdotto(elettronico);
                            break;
                        case 3:
                            // prodotto abbigliamento
                            System.out.println("Inserisci il codice");
                            codice = intScanner.nextInt();
                            System.out.println("Inserisci il nome");
                            nome = stringScanner.nextLine();
                            System.out.println("Inserisci il prezzo");
                            prezzo = intScanner.nextDouble();
                            System.out.println("Inserisci la taglia");
                            String taglia = stringScanner.nextLine();
                            System.out.println("Inserisci il materiale");
                            String materiale = stringScanner.nextLine();
                            Abbigliamento abbigliamento = new Abbigliamento(codice, nome, prezzo, taglia, materiale);
                            gestoreProdotti.aggiungiProdotto(abbigliamento);
                            break;
                        default:
                            break;
                    }

                    break;
                case 2:
                    // rimuovere prodotto
                    // chiedo solamente il codice del prodotto scorro arraylist in gestore prodotti
                    // e lo elimino
                    // se lo trovo
                    System.out.println("Inserisci il codice del prodotto da rimuovere");
                    int codice = intScanner.nextInt();
                    Prodotto prodottoDaRimuovere = null;
                    for (Prodotto prodotto : gestoreProdotti.prodotti) {
                        if (prodotto.getCodice() == codice) {
                            prodottoDaRimuovere = prodotto;
                            break;
                        }
                    }
                    if (prodottoDaRimuovere != null) {
                        gestoreProdotti.rimuoviProdotto(prodottoDaRimuovere);
                    }
                    break;
                case 3:
                    // stampa la lista dei prodotti, uso dettagli per stampare i dettagli di ogni
                    // prodotto
                    gestoreProdotti.stampaResoconto();
                    break;
                case 4:
                    // applica gli sconti, scorro la lista dei prodotti e applico gli sconti
                    gestoreProdotti.applicaSconti();
                    break;
                case 5:
                // acquista un prodotto
                // stampo la lista dei prodotti con a fianco prima l'indice e faccio scegliare con l'indice
                for(int i= 0; i<gestoreProdotti.prodotti.size(); i++){
                    System.out.println(i + ". " + gestoreProdotti.prodotti.get(i).getDettagli());
                }
                System.out.println("Inserisci l'indice del prodotto da acquistare");
                int indiceProdotto = intScanner.nextInt();
                Prodotto prodottoDaAcquistare = gestoreProdotti.prodotti.get(indiceProdotto);
                System.out.println("Hai acquistato il prodotto: " + prodottoDaAcquistare.getDettagli());
                puntiFedelta += prodottoDaAcquistare.calcolaPuntiFedelta();
                // gli dico quanti punti fedelta ha guadagnato con questo acquisto
                System.out.println("Hai guadagnato " + prodottoDaAcquistare.calcolaPuntiFedelta() + " punti fedelta");
                // rimuovo il prodotto dalla lista
                gestoreProdotti.rimuoviProdotto(prodottoDaAcquistare);
                break;
                case 6:
                // visualizzo i punti fedelta guadagnati
                System.out.println("Hai guadagnato " + puntiFedelta + " punti fedelta");
                break;
                
            }

        } while (scelta != 7);

        intScanner.close();
        stringScanner.close();
    }
}

class Prodotto implements IProdotto, IFidelizzabile {
    private int codice;
    private String nome;
    private double prezzo;

    public Prodotto(int codice, String nome, double prezzo) {
        this.codice = codice;
        this.nome = nome;
        this.prezzo = prezzo;
    }

    public double getPrezzo() {
        return this.prezzo;
    }

    public int calcolaPuntiFedelta() {
        return (int) this.prezzo / 10;
    }

    public String getDettagli() {
        return "Codice: " + this.codice + " Nome: " + this.nome + " Prezzo: " + this.prezzo;
    }

    public int getCodice() {
        return this.codice;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Prodotto) {
            Prodotto prodotto = (Prodotto) obj;
            return this.codice == prodotto.codice;
        }
        return false;
    }

}

class Alimentare extends Prodotto implements IScontabile {
    Date dataScadenza;
    double sconto;

    public Alimentare(int codice, String nome, double prezzo, Date dataScadenza) {
        super(codice, nome, prezzo);
        this.dataScadenza = dataScadenza;
    }

    public double calcolaSconto() {
        Date oggi = new Date();
        long millisecAllaScadenza = this.dataScadenza.getTime() - oggi.getTime();
        long giorniAllaScadenza = millisecAllaScadenza / (1000 * 60 * 60 * 24);
        if (giorniAllaScadenza < 7) {
            return 20.0;
        }
        if (giorniAllaScadenza <= 0) {
            return 99.5;
        }
        return 0;
    }

    @Override
    public String getDettagli() {
        return super.getDettagli() + " Data scadenza: " + this.dataScadenza;
    }

    @Override
    public int calcolaPuntiFedelta() {
        return (int) this.getPrezzo() / 5;
    }

}

class Elettronico extends Prodotto implements IGarantibile {
    int garanzia;

    public Elettronico(int codice, String nome, double prezzo, int garanzia) {
        super(codice, nome, prezzo);
        this.garanzia = garanzia;
    }

    public boolean inGaranzia() {
        return true;
    }

    @Override
    public int calcolaPuntiFedelta() {
        return (int) this.getPrezzo() * 2;
    }

}

class Abbigliamento extends Prodotto implements IRestituibile {
    String taglia;
    String materiale;

    public Abbigliamento(int codice, String nome, double prezzo, String taglia, String materiale) {
        super(codice, nome, prezzo);
        this.taglia = taglia;
        this.materiale = materiale;
    }

    public boolean restituibile() {
        return true;
    }

    @Override
    public int calcolaPuntiFedelta() {
        return (int) this.getPrezzo() / 2;
    }

}

interface IProdotto {
    public double getPrezzo();

    public String getDettagli();
}

class GestoreProdotti {
    ArrayList<Prodotto> prodotti = null;

    public GestoreProdotti() {
        this.prodotti = new ArrayList<Prodotto>();
    }

    public GestoreProdotti(ArrayList<Prodotto> prodotti) {
        this.prodotti = prodotti;
    }

    public void aggiungiProdotto(Prodotto prodotto) {
        this.prodotti.add(prodotto);
    }

    public void rimuoviProdotto(Prodotto prodotto) {
        this.prodotti.remove(prodotto);
    }

    public void stampaResoconto() {
        for (Prodotto prodotto : this.prodotti) {
            System.out.println(prodotto.getDettagli());
        }
    }

    public void applicaSconti() {
        for (Prodotto prodotto : this.prodotti) {
            if (prodotto instanceof Alimentare) {
                Alimentare alimentare = (Alimentare) prodotto;
                if (alimentare.calcolaSconto() != 0) {
                    // calcola sconto mi restituisce la percentuale di sconto da applicare al prezzo
                    alimentare.setPrezzo(
                            alimentare.getPrezzo() - (alimentare.getPrezzo() * alimentare.calcolaSconto() / 100));
                }
            }
        }
    }
}

interface IScontabile {
    public double calcolaSconto();
}

interface IGarantibile {
    public boolean inGaranzia();

}

interface IRestituibile {
    public boolean restituibile();
}

interface IFidelizzabile {
    public int calcolaPuntiFedelta();
}