import java.util.ArrayList;
import java.util.List;

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

        PrinterNumber<Integer> intPrinterNumber = new PrinterNumber<>(5);
        intPrinterNumber.print();

        // test classe lowerboundExemple
        List<Number> list = new ArrayList<>();
        LowerBoundExemple.addIntegers(list);
        System.out.println(list);

        // lista di object
        List<Object> listObject = new ArrayList<>();
        LowerBoundExemple.addIntegers(listObject);
        System.out.println(listObject);

        // lista di integer
        List<Integer> listInteger = new ArrayList<>();
        LowerBoundExemple.addIntegers(listInteger);
        System.out.println(listInteger);

        // test di upperboundexemple
        List<Integer> listInteger2 = new ArrayList<>();
        listInteger2.add(10);
        listInteger2.add(20);
        listInteger2.add(30);
        UpperBoundExemple.printIntegers(listInteger2);

        // test con double
        List<Double> listDouble = new ArrayList<>();
        listDouble.add(10.5);
        listDouble.add(20.5);
        listDouble.add(30.5);
        UpperBoundExemple.printIntegers(listDouble);
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

class PrinterNumber<T extends Number>{
    T t;

    public PrinterNumber(T t) {
        try{
            this.t = t;
        }catch(Exception e){
            System.out.println("Tipo non valido");
        }
    }

    public void print() {
        System.out.println(t);
    }
}

class LowerBoundExemple{
    public static void addIntegers(List<? super Integer> list){
        list.add(50);
    }


}


class UpperBoundExemple{
    public static void addIntegers(List<? extends Number> list){
        // list.add(50); // non posso aggiungere elementi
    }
    public static void printIntegers(List<? extends Number> list){
        for(Number n : list){
            System.out.println(n);
        }
    }

}