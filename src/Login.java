import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login {
    public static void main(String[] args) {
        String username;
        String firstName = "Luthando";
        String lastName = "Didiza";
        String password;
        boolean isValidUser;
        boolean isValidPassword;
        boolean isLoginIn = false;

        // ENTER USERNAME
        do{
            username = JOptionPane.showInputDialog("Enter Username");
            isValidUser = checkUserName(username);
            if(!isValidUser){
                JOptionPane.showMessageDialog(null,"Invalid Username");
            }

        }while(!isValidUser);

        // ENTER PASSWORD
        do{
            password = JOptionPane.showInputDialog("Enter Password");
            isValidPassword = checkPasswordComplexity(password);
            if(!isValidPassword){
                String message = "Password is not correctly formatted, please ensure that your password contains  at least 8 " +
                        " characters, a capital letter, a number and a special character";
                JOptionPane.showMessageDialog(null,message);
            }

        }while(!isValidPassword);

        registerUser(username,password);

        do{
            String loginUsername = JOptionPane.showInputDialog("Login : USERNAME");
            String loginPassword = JOptionPane.showInputDialog("Login : PASSWORD");
            isLoginIn =  loginUser(loginUsername,loginPassword,username,password);
            if(!isLoginIn){
                String message = "Your login details do not match try again";
                JOptionPane.showMessageDialog(null,message);
            }

        }while(!isLoginIn);
//


        returnLoginStatus(isLoginIn,firstName,lastName);



    }

    public static boolean checkUserName(String username) {
        boolean isValid = false;

        if (username.length() <= 5 && username.contains("_")) {
            isValid = true;
        } else {
            isValid = false;
        }
        return isValid;
    };

    public static boolean checkPasswordComplexity(String password) {
        boolean isValidPassword = false;


//        String passwordValid = "Password is not correctly formatted, please ensure that your password contains  at least 8 " +
//                " characters, a capital letter, a number and a special character";

        if(password.length() > 8 && password.matches(".*[A-Z].*") && password.matches(".*\\d.*")){
            Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
            Matcher hasSpecial = special.matcher(password);
            if(hasSpecial.find()){
                isValidPassword = true;
//                passwordValid = "Password successfully captured! ";
//                JOptionPane.showMessageDialog(null,passwordValid);
            }else{
                isValidPassword = false;
//                JOptionPane.showMessageDialog(null,passwordValid);
            }
        }else{
            isValidPassword = false;
//            JOptionPane.showMessageDialog(null,passwordValid);
        }

        return isValidPassword;
    };

    public static String registerUser(String username,String password){
        String passwordValid = "Password is not correctly formatted, please ensure that your password contains  at least 8 " +
                " characters, a capital letter, a number and a special character";

        if(password.length() > 8 && password.matches(".*[A-Z].*") && password.matches(".*\\d.*")){
            Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
            Matcher hasSpecial = special.matcher(password);
            if(hasSpecial.find()){
                passwordValid = "Password successfully captured! ";
                JOptionPane.showMessageDialog(null,passwordValid);
            }else{
                JOptionPane.showMessageDialog(null,passwordValid);
            }
        }else{
            JOptionPane.showMessageDialog(null,passwordValid);
        }

        if (username.length() > 5 && !username.contains("_")) {
            JOptionPane.showMessageDialog(null, "Username is not correctly formatted, please ensure that your username contains an underscore an is more than 5 characters in length");
        } else {
            JOptionPane.showMessageDialog(null, "Username successfully captured! ");
        }

        return "jaj";
    };

    public static boolean loginUser(String username,String password,String storedUser,String storedPass){
        boolean login = username.equals(storedUser) && password.equals(storedPass);

        System.out.println(login);

        return login;
    };

    public static String returnLoginStatus(boolean isLoggedIn,String firstName,String lastName){

        System.out.println(isLoggedIn ? "Welcome " + firstName + " " + lastName + " it is great to see you again" : "Username or password incorrect, please try again");
        return isLoggedIn ? "Welcome " + firstName + " " + lastName + " it is great to see you again" : "Username or password incorrect, please try again";
    };


}
