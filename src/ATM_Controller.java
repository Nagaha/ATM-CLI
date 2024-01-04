
import java.util.Scanner;

public class ATM_Controller {

    public static void main(String[] args) {
        addData();
        boolean login=true;

        while(login) {
            boolean ch=true;
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Welcome to ATM");
                System.out.println("Enter your user id: ");
                String id = sc.next();
                System.out.println("Enter your password: ");
                String pwd = sc.next();
                User user_obj = ATMServices.checkUser(id, pwd);
                if (user_obj != null) {
                    while (ch) {
                        System.out.println("Here are the services available: ");
                        System.out.println("1.Check balance ");
                        System.out.println("2.Withdraw amount ");
                        System.out.println("3.Deposit amount ");
                        System.out.println("4.Transfer amount ");
                        System.out.println("5.Show history of transactions");
                        System.out.println("6.Log Out");
                        System.out.println("Enter your service:");
                        int opt = sc.nextInt();
                        switch (opt) {
                            case 1: {
                                ATMServices.checkBalance(user_obj);
                                break;
                            }
                            case 2: {
                                ATMServices.withdraw(user_obj);
                                break;
                            }
                            case 3: {
                                ATMServices.deposit(user_obj);
                                break;
                            }
                            case 4: {
                                ATMServices.transfer(user_obj);
                                break;
                            }
                            case 5: {
                                ATMServices.showHistory(user_obj);
                                break;
                            }
                            case 6:{
                                ch=false;
                                break;
                            }

                            default:{
                                System.out.println("Invalid input");
                            }
                        }
                        System.out.println("Do you want to continue:[y/n] ");
                        char op=sc.next().charAt(0);
                        if(op=='n'){
                            ch = false;
                            login=false;
                            System.out.println("Thank You");
                        }

                    }

                }
            }
            catch(Exception e){
                System.out.println("Invalid input");
            }
        }

    }
    public static void addData(){
        User user1=new User("Harish123","Harish","1234",5000);
        User user2=new User("Aish123","Aish","456",10000);
        User.userList.put(user1.getId(), user1);
        User.userList.put(user2.getId(), user2);
///Add users here
    }


}
