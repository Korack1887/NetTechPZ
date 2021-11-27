package entityManual;

public class User {
    public int id;
    public String name;
    public String password;
    public String email;
    public String phone;
    public Role role;
    public User() {
    }
    public User(int id, String name, String email, String phone, Role role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.role = role;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public String getEmail() {
        return email;
    }


    public String getPhone() {
        return phone;
    }


    public Role getRole() {
        return role;
    }

}
