package Person;

public class Person {
   private int Id;
   private String FIO;

    public String getFIO() {
        return FIO;
    }

    public int getId() {
        return Id;
    }

    private void setId(int id) {
        Id = id;
    }

    public Person(String FIO) {
        setId(PersonService.setIdForPerson());
        this.FIO = FIO;
        PersonService.personList.add(this);
    }
}
