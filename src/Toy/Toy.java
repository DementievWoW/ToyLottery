package Toy;

public class Toy implements  Comparable<Toy>{
    //я решил чуть откланиться от подсказок на сайте, мне показалось, что сам класс не должен иметь поле отвечающее за
    //оличество дубликатов, это должно быть вынесено в отдельный класс, имитирующий хранилище.
    private int id;
    private String name;
    private double weight;
    private double probability = 0;
    public Toy(String name, double weight, int total) {
        setId(ToyService.setIdForToy());
        this.name = name;
        this.weight = weight;
        if(total>1){
            ToyService.createDuplicateToy(this, total);
        }
        ToyStorage.addToy(this);
    }
    public Toy(String name, double weight) {
        setId(ToyService.setIdForToy());
        this.name = name;
        this.weight = weight;
        ToyStorage.addToy(this);
    }
    public Toy(Toy toy){
        setId(ToyService.setIdForToy());
        this.name = toy.name;
        this.weight = toy.weight;
        ToyStorage.addToy(this);
    }
    @Override
    public int compareTo(Toy o) {
        if(o.probability == this.probability){
            return 0;
        }
        return this.probability < o.probability ? -1 : 1;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }







    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }



}
