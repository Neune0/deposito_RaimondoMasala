package EsempiInterfacce;

public class EsempioInterfaccia {
    public static void main(String[] args) {
        Dog myDog = new Dog();
        myDog.animalSound();
        myDog.sleep();
    }
    
}

interface Animable{
    public void animalSound();
    public void sleep();
}


class Dog implements Animable{
    public void animalSound(){
        System.out.println("The dog says: bow wow");
    }
    public void sleep(){
        System.out.println("Zzz");
    }
}