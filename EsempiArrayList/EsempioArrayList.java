import java.util.ArrayList;

public class EsempioArrayList {
    public static void main(String[] args) {
        // creazione di arraylist di stringhe
        ArrayList<String> primoArrayList = new ArrayList<>();
        // aggiungo un elemento alla lista
        primoArrayList.add("ciao");
        // modifico il primo elemento dell'array
        primoArrayList.set(0, "ciao modificato");
        // stampo il primo elemento dell'array
        System.out.println("il primo elemento dell'array"+primoArrayList.get(0));
    }
}
