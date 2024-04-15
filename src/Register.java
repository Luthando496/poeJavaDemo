import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register {
//    public static void main(String[] args) {
//        private String username;
        private String firstName = "Luthando";
        public String lastName = "Didiza";
        public String password;
        private boolean isValidUser;
        public boolean isValidPassword;
        public boolean isLoginIn;

//         ENTER USERNAME

//
//        // ENTER PASSWORD
//        do{
//            password = JOptionPane.showInputDialog("Enter Password");
//            isValidPassword = checkPasswordComplexity(password);
//            if(!isValidPassword){
//                String message = "Password is not correctly formatted, please ensure that your password contains  at least 8 " +
//                        " characters, a capital letter, a number and a special character";
//                JOptionPane.showMessageDialog(null,message);
//            }
//
//        }while(!isValidPassword);
//
//        registerUser(username,password);
//
////        do{
////            password = JOptionPane.showInputDialog("Enter Password");
////            isValidPassword = checkPasswordComplexity(password);
////            if(!isValidPassword){
////                String message = "Password is not correctly formatted, please ensure that your password contains  at least 8 " +
////                        " characters, a capital letter, a number and a special character";
////                JOptionPane.showMessageDialog(null,message);
////            }
////
////        }while(!isValidPassword);
////
//        isLoginIn =  loginUser("Kyl_1","Luthando@123",username,password);
//
//        returnLoginStatus(isLoginIn,firstName,lastName);



//    }

    public boolean checkUserName(String username) {

        return username.length() <= 5 && username.contains("_");
    };

    public int addSum(int num1,int num2){
        return num1 + num2;
    }

    public boolean checkPasswordComplexity(String password) {
        boolean isValidPassword = false;


//        String passwordValid = "Password is not correctly formatted, please ensure that your password contains  at least 8 " +
//                " characters, a capital letter, a number and a special character";

        if(password.length() > 8 && password.matches(".*[A-Z].*") && password.matches(".*\\d.*")){
            Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
            Matcher hasSpecial = special.matcher(password);
            if(hasSpecial.find()){
                isValidPassword = true;
            }else{
                isValidPassword = false;
            }
        }else{
            isValidPassword = false;
        }

        return isValidPassword;
    };

    public String registerUser(String username,String password){
        String message = "";

        if(password.length() > 8 && password.matches(".*[A-Z].*") && password.matches(".*\\d.*")){
            Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
            Matcher hasSpecial = special.matcher(password);
            if(hasSpecial.find()){
                message = "Password successfully captured! ";
            }else{
                message = "Password is not correctly formatted, please ensure that your password contains  at least 8 " +
                        " characters, a capital letter, a number and a special character";
            }
        }else{
            message = "Password is not correctly formatted, please ensure that your password contains  at least 8 " +
                    " characters, a capital letter, a number and a special character";
        }

        if (username.length() > 5 && !username.contains("_")) {
            message = "Username is not correctly formatted, please ensure that your username contains an underscore an is more than 5 characters in length";
        } else {
            message = "Username successfully captured! ";
        }

        return message;
    };

    public boolean loginUser(String username,String password,String storedUser,String storedPass){
        boolean login = username.equals(storedUser) && password.equals(storedPass);

        System.out.println(login);

        return login;
    };


    public String returnLoginStatus(boolean isLoggedIn,String firstName,String lastName){

//        System.out.println(isLoggedIn ? "Welcome " + firstName + " " + lastName + " it is great to see you again" : "Username or password incorrect, please try again");
        return isLoggedIn ? "Welcome " + firstName + " " + lastName + " it is great to see you again" : "Username or password incorrect, please try again";
    };

}
