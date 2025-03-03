import java.util.Scanner;

public class EsercizioChef{
    public static void main(String[] args) {
        // ingredienti di default
        String[] ingredientiItaliani = {"pomodoro", "mozzarella", "basilico", "olio"};
        String[] ingredientiMessicani = {"tortilla", "fagioli", "mais", "salsa"};
        String[] ingredientiGiapponesi = {"riso", "pesce", "alghe", "soia"};
        String[] ingredientiGreci = {"olive", "feta", "pomodoro", "aglio"};
        String[] ingredientiCinesi = {"riso", "pollo", "verdure", "soia"};

        // scanner per input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci il nome dello chef: ");
        String nome = scanner.nextLine();
        // scelta del tipo di cucina tra italiana messicana giapponese greca cinese
        System.out.println("premi 1 per cucina italiana");
        System.out.println("premi 2 per cucina messicana");
        System.out.println("premi 3 per cucina giapponese");
        System.out.println("premi 4 per cucina greca");
        System.out.println("premi 5 per cucina cinese");
        int scelta = scanner.nextInt();
        String tipo = "";
        String[] ingredienti = {};
        switch (scelta) {
            case 1:
                tipo = "italiana";
                ingredienti = ingredientiItaliani;
                break;
            case 2:
                tipo = "messicana";
                ingredienti = ingredientiMessicani;
                break;
            case 3:
                tipo = "giapponese";
                ingredienti = ingredientiGiapponesi;
                break;
            case 4:
                tipo = "greca";
                ingredienti = ingredientiGreci;
                break;
            case 5:
                tipo = "cinese";
                ingredienti = ingredientiCinesi;
                break;
            default:
                break;
        }
        
        

        Chef chef = new Chef(nome, tipo, ingredienti);

        chef.printChef();


    }
}

class Chef{
    String nome;
    String tipo;
    String[] ingredienti;

    // costruttore
    public Chef(String nome, String tipo, String[] ingredienti){
        this.nome = nome;
        this.tipo = tipo;
        this.ingredienti = ingredienti;
    }

    public void printChef(){
        System.out.println("Nome chef: " + nome);
        System.out.println("Tipo cucina: " + tipo);
        System.out.println("Ingredienti: ");
        for (String ingrediente : ingredienti) {
            System.out.println(ingrediente);
        }
    }
    
}