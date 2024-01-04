import java.util.Objects;
import java.util.Scanner;

public class ATMServices {


    public static void checkBalance(User userObj) {
        double bal= userObj.getBalance();
        System.out.println("Your current balance is: "+bal);
    }

    public static void withdraw(User userObj) {
        Scanner sc=new Scanner(System.in);
        checkBalance(userObj);
        System.out.println("Enter the amount to withdraw: ");
        double withdraw_amount=sc.nextDouble();
        if(withdraw_amount>userObj.getBalance()){
            System.out.println("Withdraw limit exceeded");
        }
        else{
            double newbalance= userObj.getBalance()-withdraw_amount;
            userObj.setBalance(newbalance);
            System.out.println("Amount withdrawn successful");
            System.out.println("The withdrawn amount is: "+withdraw_amount);
            checkBalance(userObj);
            userObj.Sno++;
            String th=userObj.getSno()+" Withdrawal amount: "+ withdraw_amount+ " current balance: "+newbalance;
            userObj.transactionHistory.add(th);
        }

    }

    public static void deposit(User userObj) {
        Scanner sc=new Scanner(System.in);
        checkBalance(userObj);
        System.out.println("Enter amount to be deposited: ");
        double deposit=sc.nextDouble();
        if(deposit>0) {
            double newdeposit = deposit + userObj.getBalance();
            userObj.setBalance(newdeposit);
            System.out.println("Deposit successful");
            checkBalance(userObj);
            userObj.Sno++;
            String th=userObj.getSno()+" Deposited amount: "+ deposit+ " current balance: "+newdeposit;
            userObj.transactionHistory.add(th);

        }
        else{
            System.out.println("Enter a valid amount");
        }
    }
    public static User checkUser(String id, String pwd) {
                User obj= User.userList.get(id);
                if(Objects.equals(pwd, obj.getPwd())){
                    System.out.println("Log in Successful");
                    return obj;
                }
        System.out.println("Wrong user id or password");
        return null;
    }
    public static User checkUser(String id) {
                User obj = User.userList.get(id);
                if(obj!=null){
                    System.out.println("User found");
                    return obj;
                }
                else{
                    System.out.println("No peer found");
                    return null;
                }
    }


    public static void transfer(User userObj) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the id of peer: ");
        String id=sc.next();
        User user1=userObj;
        User user2=checkUser(id);
        System.out.println("Enter the amount to be transfered: ");
        double transfer_amount=sc.nextDouble();
        if(transfer_amount<user1.getBalance()) {
            double newbal1 = user1.getBalance() - transfer_amount;
            user1.setBalance(newbal1);
            double newbal2=user2.getBalance()+transfer_amount;
            user2.setBalance(newbal2);
            checkBalance(user1);
            System.out.println("Transaction successful");
            user2.Sno++;
            user1.Sno++;
            String th="|"+user1.getSno()+" Transaction from "+ user1.getName()+ " to: "+ user2.getName()+" Transferred amount: "+transfer_amount;
            String th2=user2.getSno()+" Transferred from "+ user1.getName()+ " Transferred amount: "+transfer_amount;
            user1.transactionHistory.add(th);
            user2.transactionHistory.add(th2);
        }
    }

    public static void showHistory(User userObj) {
        System.out.println(userObj.transactionHistory.toString());
    }
}
