package DesignPatten.FactoryMethod.AbstractFactoryPattern.Bank.Factory;

import DesignPatten.FactoryMethod.AbstractFactoryPattern.Bank.Class.Bank;

public class Client {
    public static void main(String[] args) {
        Bank bank = BankFactory.getBank(BankType.TPBank);
        System.out.println(bank.getName());
    }
}
