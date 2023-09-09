package Person;

import java.util.ArrayList;
import java.util.List;

public class PersonService {
    private static int staticPersonId =-1;

    public static List<Person> personList = new ArrayList<>();
    public static int setIdForPerson() {
        staticPersonId++;
        return staticPersonId;
    }
    public static Person getPersonById(int id){
        for (Person person: personList) {
            if(person.getId() == id){
                return person;
            }


        }
        return null;
    }
}
