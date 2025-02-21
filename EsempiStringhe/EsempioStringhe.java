public class EsempioStringhe{
    public static void main(String[] args) {
        String myString="Hello world!";

        // res lunghezza stringa
        myString.length();

        // trasforma la stringa in minuscolo
        myString.toLowerCase();

        // trasfomra la stringa in maiuscolo
        myString.toUpperCase();

        // res il primo indice per il quale fa match
        myString.indexOf("lo");

        // concatenazione
        myString.concat(myString);

        // special character
        myString.concat("\" virgolette \" slash \\ a capo: \n ");
    }
}