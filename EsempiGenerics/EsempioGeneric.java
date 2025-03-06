
public class EsempioGeneric {
    public static void main(String[] args) {
        // creo un oggetto di tipo printer che stampa una stringa
        Printer<String> stringPrinter = new Printer<>("Ciao");
        stringPrinter.print();

        // creo un oggetto di tipo printer che stampa un intero
        Printer<Integer> intPrinter = new Printer<>(5);
        intPrinter.print();

        // creo un oggetto di tipo printer che stampa un double
        Printer<Double> doublePrinter = new Printer<>(5.5);
        doublePrinter.print();

        // creo un oggetto di tipo printer che stampa un oggetto di tipo persona
        Printer<Persona> personaPrinter = new Printer<>(new Persona("Mario", 20));
        personaPrinter.print();
    }
}

class Persona{
    private String nome;
    private int eta;

    public Persona(String nome, int eta){
        this.nome = nome;
        this.eta = eta;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nome='" + nome + '\'' +
                ", eta=" + eta +
                '}';
    }
}


// printa qualsiasi cosa abbia un tostring
class Printer<T> {

    T t;

    public Printer(T t) {
        this.t = t;
    }

    public void print() {
        System.out.println(t);
    }
}