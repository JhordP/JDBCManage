package domain;

public class Login {

    //Columns
    private int id;
    private String username;
    private String passw;

    public Login() {}
    public Login(int id) {
        this.id = id;
    }
    public Login(String username, String passw) {
        this.username = username;
        this.passw = passw;
    }
    public Login(int id, String username, String passw){
        this.id = id;
        this.username = username;
        this.passw = passw;
    }
    
    //Getters & Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassw() {
        return passw;
    }
    public void setPassw(String passw) {
        this.passw = passw;
    }

    //toString
    @Override
    public String toString() {
        return "Login [id=" + id + ", username=" + username +", passw=" + passw + "]";
    }
    
}
