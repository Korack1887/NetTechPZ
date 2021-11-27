package entityManual;

import java.util.List;

public class Category {
    public int id;
    public String name;
    public  List<Animator> animators;
    public List<Costume> costumes;
    public float price;
    public Category() {
    }
    public Category(int id, String name, List<Animator> animators, List<Costume> costumes) {
        this.id = id;
        this.name = name;
        this.animators = animators;
        this.costumes = costumes;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public List<Animator> getAnimators() {
        return animators;
    }


    public List<Costume> getCostumes() {
        return costumes;
    }

}
