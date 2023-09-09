package Lottery;

import java.time.Period;
import java.util.*;

public class Lottery {
    public Tuple<Person, Toy> runLottery()
    {
        if(ToyStorage.getToysHashMap().size()!=0){
            return new Tuple<>(rafflingPerson(),raffleingToy());
        }
        else {
            System.out.println("Нету игрушек");
            return null;
        }
    }
    private Person rafflingPerson(){
        return PersonService.getPersonById(new Random().nextInt(0, (PersonService.personList.size())));
    }
    private Toy raffleingToy(){
        ToyStorage.getToysHashMap().forEach((integer, toy) ->toy.setProbability(toy.getWeight()*Math.random()*10));
        double maxChance=0;
        int keyMaxChance=-1;
        for (Toy toy : ToyStorage.getToysHashMap().values()) {
            if(maxChance < toy.getProbability()) {
                maxChance = toy.getProbability();
                keyMaxChance = toy.getId();
            }
        }
        return ToyStorage.getToysHashMap().get(keyMaxChance);
    }
}
