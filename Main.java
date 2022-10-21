import javax.swing.JOptionPane;

public class Main {
    public static Facade facLogin = new Facade();
    public static void main(String[] args) {
        //Check whether user is logged in 
        boolean loginCheck = facLogin.login();
        if(loginCheck==true){
            Person person = facLogin.getThePerson();
            person.createProductMenu();
            person.showMenu();
        }
        else{
            JOptionPane.showMessageDialog( null, "User not logged in", "Error", JOptionPane.ERROR_MESSAGE );
        }
    }
}
