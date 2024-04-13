package DesignPatten.Prototype.VD1;

public class Computer implements Cloneable {
    private String os;
    private String office;
    private String antivirus;
    private String browser;
    private String others;
    private Integer kk;
    private Employee employee;

    public Computer(String os, String office, String antivirus, String browser, String others) {
        this.os = os;
        this.office = office;
        this.antivirus = antivirus;
        this.browser = browser;
        this.others = others;
    }

    public Computer(String os, String office, String antivirus, String browser, String others, Integer kk, Employee employee) {
        this(os, office, antivirus, browser, others);
        this.kk = kk;
        this.employee = employee;
    }

    @Override
    protected Computer clone() throws CloneNotSupportedException {
        Computer computer = (Computer) super.clone();
        computer.employee = this.employee.clone();
        return computer;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "os='" + os + '\'' +
                ", office='" + office + '\'' +
                ", antivirus='" + antivirus + '\'' +
                ", browser='" + browser + '\'' +
                ", others='" + others + '\'' +
                ", kk=" + kk +
                ", employee=" + employee +
                '}';
    }

    public void setOthers(String others) {
        this.others = others;
    }

    public void setKk(Integer kk) {
        this.kk = kk;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getOs() {
        return os;
    }

    public String getOffice() {
        return office;
    }

    public String getAntivirus() {
        return antivirus;
    }

    public String getBrowser() {
        return browser;
    }

    public String getOthers() {
        return others;
    }

    public Integer getKk() {
        return kk;
    }

    public Employee getEmployee() {
        return employee;
    }
}
