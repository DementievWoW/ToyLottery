package UserInterface;

import java.util.Scanner;

public class UserInterface {
    private static boolean flag =true;
    public static void runUserInterface(){
        while (flag){
            UserInterfaceService.commandMsg();
            Scanner in = new Scanner(System.in);
            switch (in.nextInt()) {
                case 1 -> UserInterfaceService.runLottery();
                case 2 -> UserInterfaceService.getParticipant();
                case 3 -> UserInterfaceService.getListToys();
                case 4 -> UserInterfaceService.getToysByName();
                case 5 -> UserInterfaceService.deleteOneToyByName();
                case 6 -> UserInterfaceService.deleteAllToyByName();
                case 7->{
                    flag=false;
                }
                default -> System.out.println("не верный ввод команды");
            }


        }
        System.out.println("Приходите еще");

    }
}
