public class BasicJava {
    public static void main(String[] args) {
        Children children = new Children();
        children.fun();
    }

}

class Parent {
    public void fun(){
        System.out.println("我是父类fun方法");
        tryFun();
    }
    public void tryFun(){
        System.out.println("我是父类tryFun方法");
    }
}

class Children extends Parent{
    /**
     * 重写父类的方法
     */
    public void tryFun(){

        System.out.println("我是子类tryFun方法");
        super.tryFun();
    }
}
