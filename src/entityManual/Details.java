package entityManual;


import java.util.Date;

public class Details {
    public String address;
    public User user;
    public Details() {
    }
    public Details(String address, User user, Date date) {
        this.address = address;
        this.user = user;
        this.date = date;
    }

    public String getAddress() {
        return address;
    }


    public User getUser() {
        return user;
    }


    public Date getDate() {
        return date;
    }


    public Date date;
}
