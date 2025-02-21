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
        myString.concat("\" virgolette \" slash \\ a capo: \n  carriage return \r backspace \b form feed \f tab \t");

        // esempio split
        // Splits this string around matches of the given regular expression.
        myString.split("M");

        // contains
        // Returns true if and only if this string contains the specified sequence of char values.
        myString.contains("l");

        // equals
        // Compares this string to the specified object. 
        // The result is true if and only if the argument is not null and is a 
        // String object that represents the same sequence of characters as this object.
        myString.equals("lo");

        // isEmpty
        // Returns true if, and only if, length() is 0.
        myString.isEmpty();

        // trim
        /* Returns a string whose value is this string, with all leading 
        and trailing space removed, where space is defined as any character 
        whose codepoint is less than or equal to 'U+0020' (the space character).
        If this String object represents an empty character sequence, or the 
        first and last characters of character sequence represented by this 
        String object both have codes that are not space (as defined above), 
        then a reference to this String object is returned.
        Otherwise, if all characters in this string are space (as defined above), 
        then a String object representing an empty string is returned.
        Otherwise, let k be the index of the first character in the string 
        whose code is not a space (as defined above) and let m be the index 
        of the last character in the string whose code is not a space 
        (as defined above). A String object is returned, representing the 
        substring of this string that begins with the character at index k 
        and ends with the character at index m-that is, the result of 
        this.substring(k, m + 1). */
        myString.trim();

    
    }
}