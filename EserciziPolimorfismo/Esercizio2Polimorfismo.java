package EserciziPolimorfismo;

public class Esercizio2Polimorfismo {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona();
        Persona pirata = new Pirata();
        persona1.saluta();
        persona2.saluta();
        pirata.saluta();
    }
}


class Persona{
    public void saluta(){
        System.out.println("Ciao!");
    }
}

class Pirata extends Persona{
    public void saluta(){
        System.out.println("Ahoy!");
    }
}