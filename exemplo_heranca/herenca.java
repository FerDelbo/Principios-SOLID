// Base class
class Vehicle {
    void move() {
        System.out.println("Vehicle is moving");
    }

    void stop() {
        System.out.println("Vehicle has stopped");
    }
}

// Inheriting classes
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
