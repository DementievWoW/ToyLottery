package Util;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;

public class FileHandler {
    public void writeResultLottery(Tuple<Person, Toy> tupleResult){
        try(FileWriter writer = new FileWriter("ResultLottery.txt", true))
        {
            String text = "Участник : "+tupleResult.getFirst().getFIO()+", Выигрывает : "+ tupleResult.getSecond().getName();
            writer.write(text);
            writer.append('\n');

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
