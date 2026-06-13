abstract class Employee {
    public Employee() {
        System.out.println("Employee initiated");
    }

    abstract void checkin();
    abstract void checkout();
}


class Manager extends Employee {
    @Override
    public void checkin() {
        System.out.println("Manager checked in");
    }

    @Override
    public void checkout() {
        System.out.println("Manager checked out");
    }

    public void developerMonitor() {
        System.out.println("Monitoring Developer...");
    }

    public void designerMonitor() {
        System.out.println("Monitoring Designer...");
    }

    public void check() {
        System.out.println("Manager Working");
    }
}

public class Main {
    public static void main(String[] args) {
        Manager m1 = new Manager();
        m1.checkin();
        m1.check();
        m1.developerMonitor();
        m1.designerMonitor();
        m1.checkout();
    }

}
