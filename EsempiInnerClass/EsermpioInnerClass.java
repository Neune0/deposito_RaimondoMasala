public class EsermpioInnerClass{
    public static void main(String[] args){
        ClasseFuori cf = new ClasseFuori();
        ClasseFuori.ClasseDentro cd = cf.new ClasseDentro();
        System.out.println("x: "+cf.x);
        System.out.println("y: "+cd.y);

        /*----------------------------------------*/

        OuterClass.InnerClass myInner = new OuterClass.InnerClass();
        System.out.println(myInner.y);
    }
}

class ClasseFuori{
    int x= 10;
    class ClasseDentro{
        int y = 20;
    }
}

class OuterClass{
    int x = 10;
    static class InnerClass{
        int y = 20;
    }
}