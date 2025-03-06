package EsempiAbstract;
public class EsempioAbstract {
    public static void main(String[] args) {
        Cane cane = new Cane();
        cane.verso();
        cane.mangia();

        Gatto gatto = new Gatto();
        gatto.verso();
        gatto.mangia();

        Animal animale = new Cane();
        animale.verso();
        animale.mangia();

        // Animal animale2 = new Animal(); non puoi instanziare una classe astratta
    }
}


abstract class Animal{
    public abstract void verso();
    public void mangia(){
        System.out.println("Mangia");
    }
}

class Cane extends Animal{
    @Override
    public void verso() {
        System.out.println("Bau");
    }
}


class Gatto extends Animal{
    @Override
    public void verso() {
        System.out.println("Miao");
    }
}
