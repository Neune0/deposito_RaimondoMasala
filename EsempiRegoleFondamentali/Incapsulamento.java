public class Incapsulamento{
    private int x;
    private int y;
    public Incapsulamento(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void stampa(){
        System.out.println("x: " + x + " y: " + y);
    }
    public static void main(String[] args){
        Incapsulamento i = new Incapsulamento(10, 20);
        i.stampa();
        i.setX(30);
        i.setY(40);
        i.stampa(); // metodo non statico, fa riferimento all'oggetto i
        Incapsulamento.metodoStatico();
        i.metodoEsempio();

    }

    public static void metodoStatico(){
        System.out.println("metodo statico");
    }

    public void metodoEsempio(){
        if(verifica()){
            System.out.println("ho usato il metodo privato verifica ed x è maggiore di 0");
        }
        else{
            System.out.println("ho usato il metodo privato verifica ed x è minore o uguale a 0");
        }
    }

    private boolean verifica(){
        return getX() > 0;
    }

}
