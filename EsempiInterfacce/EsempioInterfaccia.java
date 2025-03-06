package EsempiInterfacce;

public class EsempioInterfaccia {
    public static void main(String[] args) {
        Dog myDog = new Dog();
        myDog.animalSound();
        myDog.sleep();
    }
    
}

interface Animable{
    public static final int a = 5;
    public void animalSound();
    public void sleep();
}

interface Movable{
    public void run();
    public void walk();
}


class Dog implements Animable, Movable{
    public void run(){
        System.out.println("The dog is running");
    }
    public void walk(){
        System.out.println("The dog is walking");
    }
    public void animalSound(){
        System.out.println("The dog says: bow wow");
    }
    public void sleep(){
        System.out.println("Zzz");
    }
}

