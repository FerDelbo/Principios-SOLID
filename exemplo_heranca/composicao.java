// Interface for moving behavior
interface Moveable {
    void move();
}

// Concrete implementation of Moveable for vehicles
class VehicleMove implements Moveable {
    public void move() {
        System.out.println("Vehicle is moving");
    }
}

// Vehicle class using composition
class Vehicle {
    private Moveable moveable;

    public Vehicle() {
        this.moveable = new VehicleMove();
    }

    public void move() {
        moveable.move();
    }

    void stop() {
        System.out.println("Vehicle has stopped");
    }
}

// Specialized vehicle classes
class Car extends Vehicle {
    void move() {
        System.out.println("Car is moving");
    }
}

class Bicycle extends Vehicle {
    void move() {
        System.out.println("Bicycle is moving");
    }
}

class Skateboard extends Vehicle {
    void move() {
        System.out.println("Skateboard is moving");
    }
}
