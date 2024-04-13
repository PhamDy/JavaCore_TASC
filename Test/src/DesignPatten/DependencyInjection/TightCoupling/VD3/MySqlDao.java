package DesignPatten.DependencyInjection.TightCoupling.VD3;

public class MySqlDao implements AbstractDAO {

    @Override
    public void connect() {
        System.out.println("My Sql connect");
    }
}
