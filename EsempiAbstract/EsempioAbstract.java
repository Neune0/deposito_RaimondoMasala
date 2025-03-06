package EsempiAbstract;
public class EsempioAbstract {
    public static void main(String[] args) {
        Cane cane = new Cane();
        cane.verso();
        cane.mangia();
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
