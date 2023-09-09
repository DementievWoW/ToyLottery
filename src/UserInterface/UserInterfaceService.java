package UserInterface;

import Lottery.Lottery;
import Person.Person;
import Toy.Toy;
import Util.FileHandler;
import Util.Tuple;

import java.util.Scanner;

public class UserInterfaceService {

    public static  void commandMsg(){
        System.out.println("команда 1 - запустить лотерею");
        System.out.println("команда 2 - показать учкастников");
        System.out.println("команда 3 - показать список разыгрываемых игрушек");
        System.out.println("команда 4 - показать количество игрушек по названию(вводится название)");
        System.out.println("команда 5 - удалить 1 игрушку(название)");
        System.out.println("команда 6 - удалить все игрушки одного типа(название)");
        System.out.println("команда 7 - Выход");
    }
    public static void runLottery(){
        Lottery lottery = new Lottery();
        Tuple<Person, Toy> tuple = lottery.runLottery();
        System.out.println("Участник : " + tuple.getFirst().getFIO() + ", Выигрывает : " + tuple.getSecond().getName());
        FileHandler fileHandler = new FileHandler();
        fileHandler.writeResultLottery(tuple);
        ToyStorage.removeToy(tuple.getSecond().getId());
        System.out.println();
    }
    public static void getParticipant(){
        for (Person person : PersonService.personList) {
            System.out.println("Участник " + person.getFIO() + ", номер в лотерее: " + person.getId());
        }
        System.out.println("Общее количество участников: " + PersonService.personList.size());
        System.out.println();
    }
    public static void getListToys() {
        ToyStorage.getToys();
        System.out.println();
    }
    public static void getToysByName(){

            System.out.println("Введите название");
            Scanner in = new Scanner(System.in);
            String name = in.nextLine();
            System.out.println("Игрушка: "+name+" в количестве: "+ ToyStorage.countToysByName(name));

    }
    public static void deleteOneToyByName(){
        System.out.println("Введите название");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        ToyStorage.removeToy(name);
        System.out.println("Успешно удалено");
        System.out.println();
    }
    public static void deleteAllToyByName(){
        System.out.println("Введите название");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        ToyStorage.removeAllToy(name);
        System.out.println("Успешно удалены");
        System.out.println();
    }

}
