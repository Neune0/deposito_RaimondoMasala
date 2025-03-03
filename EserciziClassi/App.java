import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        Utente utente = new Utente("Mario", "Rossi");
        Utente utente2 = new Utente("Mario", "Rossi");
        System.out.println(utente);
        System.out.println(utente2);
        System.out.println("utente è uguale a utente2? "+utente.equals(utente2));
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
        if(obj.getClass()!=this.getClass()) return false;
        
        Utente u = (Utente) obj;
        return this.nome.equals(u.nome) && this.cognome.equals(u.cognome);
    }

    @Override
    public int hashCode() {
        return this.nome.hashCode() + this.cognome.hashCode();
    }
}


