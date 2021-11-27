package entity;


public class Order {
    public int id;

    public int getId() {
        return id;
    }


    public Status getStatus() {
        return status;
    }

    public Order() {
    }

    public Order(int id, Status status, Details details, Category category) {
        this.id = id;
        this.status = status;
        this.details = details;
        this.category = category;
    }


    public Details getDetails() {
        return details;
    }


    public Category getCategory() {
        return category;
    }


    public Status status;
    public Details details;
    public Category category;
}
