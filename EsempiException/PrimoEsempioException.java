
public class PrimoEsempioException {
    public static void main(String[] args) throws Exception {
        try{
            int[] numeri = new int[5];
            numeri[10] = 10;
        } catch (ArrayIndexOutOfBoundsException e) {    
            System.out.println("Indice fuori dai limiti");
            throw new Exception(e);
        }finally{
            System.out.println("il try catch è finito");
        }
            
    }
}
