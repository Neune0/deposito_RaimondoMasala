import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioLibro {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Libro libro1 = new Libro("Mario Rossi", 100);
        Libro libro2 = new Libro("Luca Verdi", 200);
        Libro libro3 = new Libro("Mario Rossi", 300);
        biblioteca.addBook(libro1);
        biblioteca.addBook(libro2);
        biblioteca.addBook(libro3);
        biblioteca.printAllBooks();
        biblioteca.searchBookByAutor("Mario Rossi");
        biblioteca.searchBookByPages(200);
    }

    public void printMenu(Biblioteca biblioteca) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        do {
            System.out.println("Menu opzione");
            System.out.println("premi 1 per aggiungere un libro alla libreria");
            System.out.println("premi 2 per cercare un libro per autore");
            System.out.println("premi 3 per cercare un libro per numero di pagine");
            System.out.println("premi 4 per stampare tutti i libri presenti");
            System.out.println("premi 5 per uscire");
            int scelta = scanner.nextInt();
            switch (scelta) {
                case 1:
                    biblioteca.addBook(menuAddBook());
                    break;
                case 2:
                    biblioteca.searchBookByAutor(sceltaAutore());
                    break;
                case 3:
                biblioteca.searchBookByPages(sceltaPagine());
                    break;
                case 4:
                biblioteca.printAllBooks();
                    break;
                case 5:
                    exit = true;
                    break;

                default:
                    break;
            }
        } while (!exit);
    }

    public Libro menuAddBook(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci il nome dell'autore: ");
        String nomeAutore = scanner.nextLine();
        System.out.println("Inserisci il numero di pagine: ");
        int numeroPagine = scanner.nextInt();
        return new Libro(nomeAutore, numeroPagine);
    }

    public String sceltaAutore(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci il nome dell'autore: ");
        return scanner.nextLine();
    }

    public int sceltaPagine(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci il numero di pagine: ");
        return scanner.nextInt();
    }
}

class Libro {
    String nomeAutore;
    int numeroPagine;

    // costruttore
    public Libro(String nomeAutore, int numeroPagine) {
        this.nomeAutore = nomeAutore;
        this.numeroPagine = numeroPagine;
    }
}

class Biblioteca {
    ArrayList<Libro> libri = new ArrayList<Libro>();

    // costruttore
    public Biblioteca(ArrayList<Libro> libri) {
        this.libri = libri;
    }

    public Biblioteca() {
        this.libri = new ArrayList<Libro>();
    }

    // print all books
    public void printAllBooks() {
        for (Libro libro : libri) {
            System.out.println("Autore: " + libro.nomeAutore + " Pagine: " + libro.numeroPagine);
        }
    }

    // add book
    public void addBook(Libro libro) {
        libri.add(libro);
    }

    // search book by autor
    public void searchBookByAutor(String nomeAutore) {
        for (Libro libro : libri) {
            if (libro.nomeAutore.equals(nomeAutore)) {
                System.out.println("Autore: " + libro.nomeAutore + " Pagine: " + libro.numeroPagine);
            }
        }
    }

    // search book by pages
    public void searchBookByPages(int numeroPagine) {
        for (Libro libro : libri) {
            if (libro.numeroPagine == numeroPagine) {
                System.out.println("Autore: " + libro.nomeAutore + " Pagine: " + libro.numeroPagine);
            }
        }
    }
}
