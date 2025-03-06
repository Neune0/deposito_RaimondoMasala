package EserciziAbstract;
// diversi tipi di veicoli ogni veicolo ha marca,modello,anno di produzione

import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioAbstractClass {
    public static void main(String[] args) {
        Scanner intScanner = new Scanner(System.in);
        Scanner stringScanner = new Scanner(System.in);
        GestoreVeicoli gestoreVeicoli = new GestoreVeicoli();

        // menu per far scegliere all'utente se mostrare i veicoli, aggiungere, trovare il veicolo piu vecchio o uscire
        int scelta = 0;
        int sceltaTipoVeicolo = 0;

        do{
            System.out.println("1. Mostra veicoli");
            System.out.println("2. Aggiungi veicolo");
            System.out.println("3. Veicolo più vecchio");
            System.out.println("4. Esci");
            scelta = intScanner.nextInt();
            
            switch(scelta){
                case 1:
                    // mostra veicoli
                    gestoreVeicoli.mostraVeicoli();
                    break;
                case 2:
                    // menu scelta del tipo di veicolo da inserire oppure torna indietro
                    sceltaTipoVeicolo = 0;
                    do{
                        System.out.println("1. Automobile");
                        System.out.println("2. Moto");
                        System.out.println("3. Camion");
                        System.out.println("4. Torna indietro");
                        sceltaTipoVeicolo = intScanner.nextInt();

                        switch(sceltaTipoVeicolo){
                            case 1:
                                // inserimento automobile
                                System.out.println("Inserisci la marca");
                                String marca = stringScanner.nextLine();
                                System.out.println("Inserisci il modello");
                                String modello = stringScanner.nextLine();
                                System.out.println("Inserisci l'anno di produzione");
                                int annoProduzione = intScanner.nextInt();
                                System.out.println("Inserisci il numero di porte");
                                int numeroPorte = intScanner.nextInt();
                                System.out.println("Inserisci la tipologia di carburante");
                                String tipologiaCarburante = stringScanner.nextLine();
                                Automobile auto = new Automobile(marca, modello, annoProduzione, numeroPorte, tipologiaCarburante);
                                gestoreVeicoli.aggiungiVeicolo(auto);
                                break;
                            case 2:
                                // inserimento moto
                                System.out.println("Inserisci la marca");
                                marca = stringScanner.nextLine();
                                System.out.println("Inserisci il modello");
                                modello = stringScanner.nextLine();
                                System.out.println("Inserisci l'anno di produzione");
                                annoProduzione = intScanner.nextInt();
                                System.out.println("Inserisci il tipo di moto");
                                System.out.println("1. Stradale");
                                System.out.println("2. Cross");
                                System.out.println("3. Scooter");
                                int tipoMoto = intScanner.nextInt();
                                TipoMoto tipoMotoEnum = null;
                                switch(tipoMoto){
                                    case 1:
                                        tipoMotoEnum = TipoMoto.STRADALE;
                                        break;
                                    case 2:
                                        tipoMotoEnum = TipoMoto.CROSS;
                                        break;
                                    case 3:
                                        tipoMotoEnum = TipoMoto.SCOOTER;
                                        break;
                                }
                                System.out.println("Inserisci la cilindrata");
                                int cilindrata = intScanner.nextInt();
                                Moto moto = new Moto(marca, modello, annoProduzione, tipoMotoEnum, cilindrata);
                                gestoreVeicoli.aggiungiVeicolo(moto);
                            break;
                            case 3:
                                // inserimento camion
                                System.out.println("Inserisci la marca");
                                marca = stringScanner.nextLine();
                                System.out.println("Inserisci il modello");
                                modello = stringScanner.nextLine();
                                System.out.println("Inserisci l'anno di produzione");
                                annoProduzione = intScanner.nextInt();
                                System.out.println("Inserisci la capacità di carico");
                                int capacitaCarico = intScanner.nextInt();
                                System.out.println("Inserisci il numero di assi");
                                int numeroAssi = intScanner.nextInt();
                                Camion camion = new Camion(marca, modello, annoProduzione, capacitaCarico, numeroAssi);
                                gestoreVeicoli.aggiungiVeicolo(camion);
                            break;
                            }
                    } while (sceltaTipoVeicolo != 4);
                    
                    break;
                case 3:
                    Veicolo oldest = gestoreVeicoli.getOldestVeicolo();
                    if(oldest != null){
                        System.out.println("Il veicolo più vecchio è: ");
                        oldest.mostraDettagli();
                    }
                    break;
                case 4:
                    System.out.println("Arrivederci");
                    break;
                default:
                    System.out.println("Scelta non valida");
            }

        }while(scelta!=4);

        // chiudere scanner
        intScanner.close();
        stringScanner.close();
        
    }
}

class GestoreVeicoli {
    ArrayList<Veicolo> veicoli = new ArrayList<Veicolo>();

    public void aggiungiVeicolo(Veicolo veicolo) {
        veicoli.add(veicolo);
    }

    public void mostraVeicoli() {
        if (veicoli.size() == 0) {
            System.out.println("Nessun veicolo presente");
        }
        for (Veicolo veicolo : veicoli) {
            veicolo.mostraDettagli();
        }
    }

    public Veicolo getOldestVeicolo() {
        if (veicoli.size() == 0) {
            return null;
        }
        Veicolo oldest = veicoli.get(0);
        for (Veicolo veicolo : veicoli) {
            if (veicolo.getAnnoProduzione() < oldest.getAnnoProduzione()) {
                oldest = veicolo;
            }
        }
        return oldest;
    }
}

abstract class Veicolo {
    private String marca;
    private String modello;
    private int annoProduzione;

    public Veicolo(String marca, String modello, int annoProduzione) {
        this.marca = marca;
        this.modello = modello;
        this.annoProduzione = annoProduzione;
    }

    public String getMarca() {
        return marca;
    }

    public String getModello() {
        return modello;
    }

    public int getAnnoProduzione() {
        return annoProduzione;
    }

    public abstract void mostraDettagli();
}

class Automobile extends Veicolo {
    int numeroPorte;
    String tipologiaCarburante;

    public Automobile(String marca, String modello, int annoProduzione, int numeroPorte,
            String tipologiaCarburante) {
        super(marca, modello, annoProduzione);
        this.numeroPorte = numeroPorte;
        this.tipologiaCarburante = tipologiaCarburante;
    }

    @Override
    public void mostraDettagli() {
        System.out.println(
                "Marca: " + getMarca() + " Modello: " + getModello() + " Anno di produzione: " + getAnnoProduzione()
                        + " Numero porte: " + numeroPorte + " Tipologia carburante: " + tipologiaCarburante);
    }
}

enum TipoMoto {
    STRADALE, CROSS, SCOOTER
}

class Moto extends Veicolo {
    TipoMoto tipoMoto;
    int cilindrata;

    public Moto(String marca, String modello, int annoProduzione, TipoMoto tipoMoto, int cilindrata) {
        super(marca, modello, annoProduzione);
        this.tipoMoto = tipoMoto;
        this.cilindrata = cilindrata;
    }

    @Override
    public void mostraDettagli() {
        System.out.println("Marca: " + getMarca() + " Modello: " + getModello() + " Anno di produzione: "
                + getAnnoProduzione() + " Tipo moto: " + tipoMoto + " Cilindrata: " + cilindrata);
    }
}

class Camion extends Veicolo {
    int capacitaCarico;
    int numeroAssi;

    public Camion(String marca, String modello, int annoProduzione, int capacitaCarico, int numeroAssi) {
        super(marca, modello, annoProduzione);
        this.capacitaCarico = capacitaCarico;
        this.numeroAssi = numeroAssi;
    }

    @Override
    public void mostraDettagli() {
        System.out.println("Marca: " + getMarca() + " Modello: " + getModello() + " Anno di produzione: "
                + getAnnoProduzione() + " Capacità di carico: " + capacitaCarico + " Numero assi: " + numeroAssi);
    }
}