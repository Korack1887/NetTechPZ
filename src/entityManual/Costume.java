package entityManual;

public class Costume {
    public int id;
    public String name;
    public String description;
    public Costume() {
    }
    public Costume(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public String getDescription() {
        return description;
    }

}
