import java.util.Scanner;

class weakpasswordException extends Exception{
    public  weakpasswordException(String message)
    {
        super(message);
    }
}   
public class password {

    public static void validatePassword(String password) throws weakpasswordException
    {
        if(password.length() < 8)
        {
            throw new weakpasswordException("password must contain atleast 8 characters");
        }
        if(!password.matches(".*\\d.*"))
        {
            throw new weakpasswordException("password must contain atleast one digit");
        }
        if(!password.matches(".*[A-Z].*")){
            throw new weakpasswordException("password must contain atleast one uppercase letter");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your password");
        String password = sc.next();
        try{
            validatePassword(password);
            System.out.println("password set Successfully");
        }catch(weakpasswordException e){
            e.printStackTrace();
            }finally{
                sc.close();
                System.out.println("Program Terminated!");
            }
    }
}
