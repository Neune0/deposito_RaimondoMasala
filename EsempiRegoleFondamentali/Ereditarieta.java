public class Ereditarieta{
    public static void main(String[] args) {
        Animale animal = new Mammifero("animale","specie");

        animal.saluta(); // usa il saluta di Mammifero
        // animal.saluta("ciao"); // non posso chiamare il metodo saluta con un parametro in quanto il tipo di riferimento è Animale
    }
}

class Animale{
    private String nome;

    public Animale(String animale){
        this.nome = animale;
    }

    public void saluta(){
        System.out.println("Ciao, sono un " + nome);
    }

    public String getNome() {
        return nome;
    }
}

class Mammifero extends Animale{
    private String specie;

    public Mammifero(String animale, String specie){
        super(animale);
        this.specie = specie;
    }

    @Override
    public void saluta(){
        System.out.println("Ciao, sono un " + getSpecie() + " di nome " + this.getNome());
    }

    // voglio fare un overload di saluta
    public void saluta(String nome){
        System.out.println("Ciao, sono un " + getSpecie() + " di nome " + nome);
    }

    
    public String getSpecie() {
        return specie;
    }
}