package entity;

public class Animator {
    public int id;
    public String name;
    public Animator() {
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public Animator(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
