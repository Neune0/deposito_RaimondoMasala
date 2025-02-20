import java.util.ArrayList;
import java.util.Arrays;

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

        // size
        System.out.println("la dimensione dell'array è: "+primoArrayList.size());

        // remove
        primoArrayList.remove(0);

        // clear rimuove tutti gli elementi
        primoArrayList.clear();

        // from array to array list
        String[] arrayStringhe = {"ciao","ciao"};

        ArrayList<String> secondoArrayList = new ArrayList<>(Arrays.asList(arrayStringhe));

        // from arraylist to array
        secondoArrayList.toArray(arrayStringhe);

    }
}
