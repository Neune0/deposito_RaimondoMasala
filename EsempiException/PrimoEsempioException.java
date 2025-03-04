
public class PrimoEsempioException {
    public static void main(String[] args) {
        try{
            int[] numeri = new int[5];
            numeri[10] = 10;
        } catch (ArrayIndexOutOfBoundsException e) {    
            System.out.println("Indice fuori dai limiti");
        }
            
    }
}
