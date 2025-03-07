package EsempiStream;

import java.util.List;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class EsempioStream {
    public static void main(String[] args) {
        List<String> lista = List.of("Alice", "Bob", "Charlie", "David");

        List<String> filteredLista = lista.stream()
                .filter(s -> s.startsWith("C"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(filteredLista);

        List<String> frasi = List.of("Ciao mondo", "Hello world", "Caffè Latte", "Hello world","Casa in montagna", "Cioccolato amaro");
        
        // 1. Creiamo uno Stream dalle frasi
        // 2. Filtro: prendo solo le stringhe che iniziano con 'C'
        // 3. Distinct: elimino i duplicati
        // 4. FlatMap: splitta ogni frase in parole
        // 5. Map: converto ogni parola in minuscolo
        // 6. Sorted: ordino alfabeticamente
        // 7. Skip(1): salto la prima parola
        // 8. Limit(4): prendo solo le successive 4 parole
        // 9. Collect: raccolgo il risultato in una lista
        Comparator<String> comp = (s1, s2) -> s1.length() - s2.length();
        List<String> elaborato = frasi.stream()
            .filter(s -> s.startsWith("C"))
            .distinct()
            .flatMap(s -> Arrays.stream(s.split(" ")))
            .map(String::toUpperCase)
            .sorted(comp)
            .skip(1)
            .limit(4)
            .collect(Collectors.toList())
            .stream()
            .collect(Collectors.toList());

            // definisco un nuovo comparatore
            
            // posso concatenare stream e collect perché Collectors.toList() restituisce una List

        System.out.println("=== Risultato dopo le operazioni di elaborazione ===");
        // 10. ForEach (qui lo usiamo semplicemente sulla lista, ma è tipico usarlo sullo stream)
        elaborato.forEach(word -> System.out.println("Elemento: " + word));

        // Esempio di reduce (concatenazione di tutte le parole in una stringa)
        String concatenato = elaborato.stream()
            .reduce("", (acc, word) -> acc.isEmpty() ? word : acc + "-" + word);

        System.out.println("\n=== Risultato finale con reduce ===");
        System.out.println("Stringa concatenata: " + concatenato);

        // metodi finali: forEach, collect, reduce, count, min, max, anyMatch, allMatch, noneMatch, findFirst, findAny
        // metodi intermedi: filter, map, flatMap, distinct, sorted, peek, limit, skip
        // metodi di start: stream, parallelStream


    }
}
