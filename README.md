Repositório dedicado para atividade de engenharia de software 2024/1

# Principios-SOLID
Irão ser tradados sobre os seguintes conceitos aqui:

  S — Single Responsiblity Principle (Princípio da responsabilidade única)
  O — Open-Closed Principle (Princípio Aberto-Fechado)
  L — Liskov Substitution Principle (Princípio da substituição de Liskov)
  Prefira Composição a Herança


## Single Responsiblity Principle (Princípio da responsabilidade única)
Uma classe deve ter apenas uma responsabilidade, isso significa que uma classe deve ter apenas uma tarefa ou função específica e deve ser a única responsável por executá-la. Isso ajuda a garantir que o código seja mais coeso, fácil de entender, manter e reutilizar. Caso contrario a classe tende se torna mais difícil de manter pois a código confuso, propenso a erros e difícil de testar. 
```
class Employee {
  private String name;
  private String email;
  private double salary;

  public Employee(String name, String email, double salary) {
    this.name = name;
    this.email = email;
    this.salary = salary;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public double getSalary() {
    return salary;
  }
}

class TaxCalculator {
  public double calculateTax(Employee employee) {
    // code to calculate tax based on salary
    return employee.getSalary() * 0.1;
  }
}

```

## Open-Closed Principle (Princípio Aberto-Fechado)
Classes, módulos, funções, etc.Devem ser abertas para extensão, mas fechadas para modificação. Isso significa que uma classe deve ser facilmente estendida para adicionar novos comportamentos sem modificar o código existente.

```
import java.util.HashMap;
import java.util.Map;

public interface CoffeeMachine {

    Coffee brewCoffee(CoffeeSelection selection) throws CoffeeException;
}

public class PremiumCoffeeMachine implements CoffeeMachine {

    private Map<CoffeeSelection, Configuration> configMap;
    private Map<CoffeeSelection, CoffeeBean> beans;
    private Grinder grinder;
    private BrewingUnit brewingUnit;

    public PremiumCoffeeMachine(Map<CoffeeSelection, CoffeeBean> beans) {
    this.beans = beans;
    this.grinder = new Grinder();
    this.brewingUnit = new BrewingUnit();

    this.configMap = new HashMap<>();
    this.configMap.put(CoffeeSelection.FILTER_COFFEE, new Configuration(30, 480));
    this.configMap.put(CoffeeSelection.ESPRESSO, new Configuration(8, 28));
    }

    @Override
    public Coffee brewCoffee(CoffeeSelection selection) throws CoffeeException {
    switch(selection) {
    case ESPRESSO:
        return brewEspresso();
    case FILTER_COFFEE:
        return brewFilterCoffee();
    default:
        throw new CoffeeException("CoffeeSelection [" + selection + "] not supported!");
    }
    }

    private Coffee brewEspresso() {
    Configuration config = configMap.get(CoffeeSelection.ESPRESSO);

    // grind the coffee beans
    GroundCoffee groundCoffee = this.grinder.grind(
        this.beans.get(CoffeeSelection.ESPRESSO),
            config.getQuantityCoffee());

    // brew an espresso
    return this.brewingUnit.brew(CoffeeSelection.ESPRESSO, groundCoffee,
        config.getQuantityWater());
    }

    private Coffee brewFilterCoffee() {
    Configuration config = configMap.get(CoffeeSelection.FILTER_COFFEE);

    // grind the coffee beans
    GroundCoffee groundCoffee = this.grinder.grind(
        this.beans.get(CoffeeSelection.FILTER_COFFEE),
            config.getQuantityCoffee());

    // brew a filter coffee
    return this.brewingUnit.brew(CoffeeSelection.FILTER_COFFEE, groundCoffee,
        config.getQuantityWater());
    }

    public void addCoffeeBeans(CoffeeSelection sel, CoffeeBean newBeans) throws CoffeeException {
    CoffeeBean existingBeans = this.beans.get(sel);
    if (existingBeans != null) {
        if (existingBeans.getName().equals(newBeans.getName())) {
            existingBeans.setQuantity(existingBeans.getQuantity() + newBeans.getQuantity());
        } else {
        throw new CoffeeException("Only one kind of coffee supported for each CoffeeSelection.");
        }
    } else {
        this.beans.put(sel, newBeans);
    }
    }
}
```
## Liskov Substitution Principle (Princípio da substituição de Liskov)
Uma classe derivada deve poder ser substituída pelos objetos da classe base sem afetar a correção do programa. Em outras palavras, se S é um subtipo de T, então os objetos do tipo T podem ser substituídos por objetos do tipo S sem alterar a funcionalidade do programa.
Essa substituição é importante porque permite que o código seja mais flexível e modular, facilitando a manutenção e a extensão do sistema. Ao seguir o LSP, os desenvolvedores podem criar hierarquias de classes mais coesas e menos propensas a erros.

```
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
```

```
public class Bird { 
    public void eat() { 
        System.out.println("I can eat."); 
    } 
}
public class FlyingBird extends Bird { 
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
public class Bird { 
    public void eat() { 
        System.out.println("I can eat."); 
    } 
}
public class FlyingBird extends Bird { 
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
public class Penguin extends Bird { 
    @Override 
    void eat() {
        System.out.println("Can I eat taco?");
    }
}
}
```

## Prefira Composição a Herança
Utiliza-se a herança se uma instância de uma classe Filha nunca precisar tornar-se um objeto de outra classe, se a hierarquia de herança representar um relacionamento "É um" e não um relacionamento "Tem um", se deseja-se ou precisa-se realizar alterações globais para as suas classes filhas alterando uma classe Pai, ou então quando a classe filha estender ao invés de substituir total ou parcialmente as responsabilidades da classe Pai. Caso contrario utilize composição. 

```
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
```

```
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
```
