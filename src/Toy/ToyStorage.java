package Toy;

import java.util.*;

public final class ToyStorage {
    private static final HashMap<Integer,Toy> ToysHashMap = new HashMap<>();
    public static void addToyCollection(Collection<Toy> newToys) {
        for (Toy toy : newToys) {
            addToy(toy);
        }
    }
    public static void addToy(Toy toy){
        ToysHashMap.put(toy.getId(),toy);
    }
    public static HashMap<Integer,Toy> getToysHashMap(){
        return ToysHashMap;
    }
    public static void removeToy(int idNum){
        ToysHashMap.remove(idNum);
    }

    public static void removeToy(String name){
        for (Toy toy:ToysHashMap.values()) {
            if(toy.getName().equals(name)){
                ToysHashMap.remove(toy.getId());
                return;
            }
        }
    }
    public static void removeAllToy(String name){
        for (Toy toy:ToysHashMap.values()) {
            if(toy.getName().equals(name)){
                ToysHashMap.remove(toy.getId());
            }
        }
    }
    public static void getToys(){
        Set<String> uniqueValues = new HashSet<String>();
        ToysHashMap.values().forEach(toy -> uniqueValues.add(toy.getName()));
        uniqueValues.forEach((toyName)-> System.out.println("Игрушка: "+toyName+ " , в количестве: "+ countToysByName(toyName)));
    }
    public static int countToysByName(String toyName){
        return (int) ToysHashMap.values().stream().filter(v -> Objects.equals(v.getName(), toyName)).count();
    }

}
