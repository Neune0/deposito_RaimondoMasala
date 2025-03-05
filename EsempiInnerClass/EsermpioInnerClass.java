public class EsermpioInnerClass{
    public static void main(String[] args){
        ClasseFuori cf = new ClasseFuori();
        ClasseFuori.ClasseDentro cd = cf.new ClasseDentro();
        System.out.println("x: "+cf.x);
        System.out.println("y: "+cd.y);
    }
}

class ClasseFuori{
    int x= 10;
    class ClasseDentro{
        int y = 20;
    }
}