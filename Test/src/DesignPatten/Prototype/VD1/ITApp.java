package DesignPatten.Prototype.VD1;

public class ITApp {
    public static void main(String[] args) throws CloneNotSupportedException {
        Employee employee1 = new Employee(1, "a");
        Employee employee2 = new Employee(2, "b");

        Computer computer1 = new Computer("Window 10", "Word 2013", "BKAV", "Chrome v69", "Skype", 3, employee1);
        Computer computer2 = computer1.clone();
        computer2.setOthers("Skype, Teamviewer, FileZilla Client");
        computer2.setKk(213);

        employee1.setId(8);

        System.out.println(computer1);

        System.out.println(computer2);

    }
}
