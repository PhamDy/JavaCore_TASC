package DesignPatten.DependencyInjection.TightCoupling.VD3;

public class Client {

    private AbstractDAO dao;

    public Client() {
        this.dao = Utils.getDAO();
    }

    public void execute(){
        dao.connect();
    }

}
