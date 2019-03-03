package sandbox;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Person {
    private String name;
    private String lastName;
    private int age;
    private List<Purchase> purchases;
    private List<Integer> integers;

    private Person(){

    }

    public Person(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        purchases = new ArrayList<>();
        integers = new ArrayList<>();
    }

    public void addInteger(int i) {
        integers.add(i);
    }

    public void addPurchase(Purchase purchase) {
        purchases.add(purchase);
    }

}