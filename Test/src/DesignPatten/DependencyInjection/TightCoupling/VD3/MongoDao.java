package DesignPatten.DependencyInjection.TightCoupling.VD3;

public class MongoDao implements AbstractDAO {

    @Override
    public void connect() {
        System.out.println("Connect mongo");
    }
}
