package DesignPatten.FactoryMethod.AbstractFactoryPattern.Bank.Factory;

import DesignPatten.FactoryMethod.AbstractFactoryPattern.Bank.Class.Bank;
import DesignPatten.FactoryMethod.AbstractFactoryPattern.Bank.Class.TpBank;
import DesignPatten.FactoryMethod.AbstractFactoryPattern.Bank.Class.VietcomBank;

public class BankFactory {

    private BankFactory() {

    }

    public static final Bank getBank(BankType bankType) {
        switch (bankType) {

            case TPBank:
                return new TpBank();

            case VietcomBank:
                return new VietcomBank();

            default:
                throw new IllegalArgumentException("Error");
        }
    }
}
