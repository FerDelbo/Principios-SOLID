public class Bird {
    
    public void eat() {
        System.out.println("I can eat.");
    }
    
    public void fly() {
        System.out.println("I can fly.");
    }
}

public class Swan extends Bird {

    @Override
    public void eat() {
	System.out.println("OMG! I can eat pizza!");
    }

    @Override
    public void fly() {
	System.out.println("I believe I can fly!");
    }
}

public class Penguin extends Bird {
    @Override
    public void eat() {
        System.out.println("Can I eat taco?");
    } 
    @Override 
    public void fly() {
        throw new UnsupportedOperationException("Help! I cannot fly!"); 
    } 
}
