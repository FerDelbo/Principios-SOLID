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