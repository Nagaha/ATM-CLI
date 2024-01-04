import java.util.ArrayList;
import java.util.HashMap;

public class User {
    public static HashMap<String,User> userList=new HashMap<>();
    private String id;
    private String name;
    private String pwd;
    private double balance;
    public ArrayList<String> transactionHistory=new ArrayList<>();
    public int Sno=0;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public User(String id, String name, String pwd, double balance) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.balance = balance;
    }

    public User() {
    }

    public int getSno() {
        return this.Sno;
    }
}
