import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;

public class EsempioAnnotazioni{
    public static void main(String[] args) {
        try{
            Class<?> c = Class.forName("EsempioAnnotazioni");
            for(Method method : c.getDeclaredMethods()){
                if(method.isAnnotationPresent(InfoAutore.class)){
                    InfoAutore info = method.getAnnotation(InfoAutore.class);
                    System.out.println("Method: " + method.getName());
                    System.out.println("Nome: " + info.nome());
                    System.out.println("Data: " + info.data());
                }
            }
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    @InfoAutore(nome = "Mario Rossi", data = "01/01/2021")
    public void metodo() {
        System.out.println("Sono un metodo");
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface InfoAutore {
    String nome();
    String data();
}

