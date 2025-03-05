import java.util.ArrayList;

public class Familia {
    public static void main(String[] args) {
        Adulto a = new Adulto("pippon");
        System.out.println(a);
        
    }
}


class Adulto{

    ArrayList<Figlio> figli;
    String nome;
    

    public Adulto(String nome){
        this.nome = nome;
        figli = new ArrayList<Figlio>();
        // due figli per ogni adulto
        figli.add(new Figlio("Mario"));
        figli.add(new Figlio("Luigi"));
    }

    class Figlio{
        String nome;
        public Figlio(String nome){
            this.nome = nome;
        }

        @Override
        public String toString() {
            return "Figlio [nome=" + nome + "]";
        }

    }


    @Override
    public String toString() {
        

        return "Adulto "+nome+" [figli=" + figli + "]";
    }
}