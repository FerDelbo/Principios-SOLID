public class certo { 
    public void eat() { 
        System.out.println("I can eat."); 
    } 
}
public class FlyingBird extends certo { 
    public void fly() { 
        System.out.println("I can fly."); 
    }
}
public class Swan extends FlyingBird { 
    @Override
    public void eat() { 
        System.out.println("OMG! I can eat pizza!"); 
    }
    @Override
    public void fly() { 
        System.out.println("I believe I can fly!");
    } 
}
public class Penguin extends certo { 
    @Override 
    void eat() {
        System.out.println("Can I eat taco?");
    }
}
