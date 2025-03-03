
public class App {

    public static void main(String[] args) {
        Utente utente = new Utente("Mario", "Rossi");
        Utente utente2 = new Utente("Mario", "Rossi");
        Utente utente3 = new Utente("Mario", "Bianchi");
        System.out.println(utente);
        System.out.println(utente2);
        System.out.println(utente3);
        System.out.println("utente è uguale a utente2? "+utente.equals(utente2));
        System.out.println("utente è uguale a utente3? "+utente.equals(utente3));
        System.out.println("hascode di utente: "+utente.hashCode());
    }
}



class Utente{
    String nome;
    String cognome;

    public Utente(String nome,String cognome){
        this.nome= nome;
        this.cognome= cognome;
    }

    @Override
    public String toString() {
        return "Utente [cognome=" + cognome + ", nome=" + nome + "]";
    }

    @Override
    public boolean equals(Object obj) {
        
        if(obj==null) return false;

        // obj non è null controllo classe
        if(obj.getClass()!=this.getClass()) return false;
        
        // obj è di tipo Utente faccio il cast e proseguo con confronto attributi
        Utente u = (Utente) obj;
        return this.nome.equals(u.nome) && this.cognome.equals(u.cognome);
    }

    @Override
    public int hashCode() {
        // usa gli hashcode degli attributi per calcolare l'hashcode dell'oggetto
        return this.nome.hashCode() + this.cognome.hashCode();
    }
}


