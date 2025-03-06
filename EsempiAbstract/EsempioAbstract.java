package EsempiAbstract;
public class EsempioAbstract {
    public static void main(String[] args) {
        Cane cane = new Cane("fido");
        cane.verso();
        cane.mangia();

        Gatto gatto = new Gatto("micio");
        gatto.verso();
        gatto.mangia();

        Animal animale = new Cane("fidon");
        animale.verso();
        animale.mangia();

        // Animal animale2 = new Animal(); non puoi instanziare una classe astratta
    }
}


abstract class Animal{
    private String nome;

    public abstract void verso();
    public void mangia(){
        System.out.println("Mangia");
    }
    public Animal(String nome){
        this.nome= nome;
    }

    public String getNome(){
        return nome;
    }
}

class Cane extends Animal{
    public Cane(String nome){
        super(nome);
    }
    @Override
    public void verso() {
        System.out.println("Bau");
    }
}


class Gatto extends Animal{
    public Gatto(String nome){
        super(nome);
    }
    @Override
    public void verso() {
        System.out.println("Miao");
    }
}
