public class Ereditarieta{
    public static void main(String[] args) {
        
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

    public String getSpecie() {
        return specie;
    }
}