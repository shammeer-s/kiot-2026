interface Employee {
    void checkin();

    void checkout();
}

interface Monitor {
    void developerMonitor();

    void designerMonitor();
}

class Manager implements Employee, Monitor {
    public void checkin() {
        System.out.println("Manager checked in");
    }

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

class Developer implements Employee {
    public void checkin() {
        System.out.println("Developer checked in");
    }

    public void checkout() {
        System.out.println("Developer checked out");
    }

    public void check() {
        System.out.println("Developer working");
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
