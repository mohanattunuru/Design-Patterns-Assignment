//Used Facade pattern to handle the functionality of gui by using the bridge pattern

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Facade {
    private int userType;
    private Product theSelectedProduct;
    private int nProductCategory;
    private ClassProductList theProductList=new ClassProductList();
    private Person thePerson;

    public boolean login() {
        Login login = new Login(this);
        login.setVisible(true);
        boolean loginResult = login.getResult();
        userType = login.getUserType();
        thePerson = login.getPerson();
       
        
        
        
        login.dispose();

        return loginResult;
    }

    public void addTrading()
    {
        JOptionPane.showMessageDialog(null, "Show Menu of Add Trading");
    }

    public void viewTrading(){
        JOptionPane.showMessageDialog(null, "No trading");
    }

    public void viewOffering(){
        JOptionPane.showMessageDialog(null, "No offers to view");
    }

    public void markOffering(){
        JOptionPane.showMessageDialog(null, "No offers to mark");
    }

    public void submitOffering(){
        JOptionPane.showMessageDialog(null, "No offers to submit");
    }

    public void remind(){
        JOptionPane.showMessageDialog(null, "Remind");
    }

    public void createUser(){}

    public void createProductList(){
        try {
            Scanner sc = new Scanner(new File("ProductInfo.txt"));
            while (sc.hasNextLine()){
                String str = sc.nextLine();
                str = str.replace("\n", ":");
                String[] str1= str.split(":");
                Product prd = new Product(str1[1], str1[0]);
                theProductList.add(prd);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "The Product List is created");
    }

    public void attachProductToUser(){
        try {
            Scanner sc = new Scanner(new File("UserProduct.txt"));
            while (sc.hasNextLine()){
                String str = sc.nextLine();
                str = str.replace("\n", ":");
                String[] str1= str.split(":");
                if(str1[0].equals(thePerson.getName())) {
                    Product prd=null;
                    for(Product pro:theProductList){
                        if(pro.getName().equals(str1[1])) {
                            prd = pro;
                            break;
                        }
                    }
                    if(prd != null)
                        thePerson.addProductList(prd);
                }

            }
            JOptionPane.showMessageDialog(null, "The Product List is attached");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void selectProduct(){
        String str = "Select: \n";
        int size = theProductList.size();
        for(int i=0;i<size;i++){
            str += i + theProductList.get(i).toString() +"\n";
        }
        int selectedOpt = Integer.parseInt(JOptionPane.showInputDialog(str));
        // Check whether selected option is within the product list size
        
        if(selectedOpt > 0 && selectedOpt < size)
            theSelectedProduct = theProductList.get(selectedOpt);
    }

    public void productOperation(){
        thePerson.showMenu();
    }

    public void accept(ReminderVisitor reminderVisitor) {
    }

    public Person getThePerson() {
        return thePerson;
    }

    public int getUserType() {
        return userType;
    }
}
