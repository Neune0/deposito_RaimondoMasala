
public class EsempioFunzioni {
    public static void main(String[] args) {
        saluta();
        System.out.println(somma(1,2));
    }

    // 2 parametri interi, ritorno intero somma dei due parametri passati
    public static int somma(int a, int b){
        return a+b;
    }

    // no parametri, ritorno void
    public static void saluta(){
        System.out.println("Ciao");
        return;
    }
    
}
