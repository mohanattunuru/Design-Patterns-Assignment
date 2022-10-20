import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.*;

public class Login extends JFrame{
    private final JRadioButton buyerButton;
    private final JRadioButton sellerButton;
    private volatile int counter;
    private boolean login;
    private HashMap<String, String> buyers;
    private HashMap<String, String> sellers;
    private int userType;
    private Person person;
    private Facade facade;

    public Login(Facade facade) {
        this.facade = facade;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        counter = 0;

        getBuyers();
        getsellers();

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel p2 = new JPanel(new FlowLayout());
        JTextField username = new JTextField();
        username.setPreferredSize(new Dimension(150, 30));
        JLabel label = new JLabel("User name   ");
        p2.add(label);
        p2.add(username);
        contentPane.add(p2);

        JPanel p3 = new JPanel(new FlowLayout());
        JPasswordField password = new JPasswordField();
        password.setPreferredSize(new Dimension(150, 30));
        JLabel label1 = new JLabel("Password    ");
        p3.add(label1);
        p3.add(password);
        contentPane.add(p3);

        buyerButton = new JRadioButton("Buyer    ");
        sellerButton = new JRadioButton("Seller");
        contentPane.add(buyerButton);
        contentPane.add(sellerButton);

        JButton loginButton = new JButton("Login");
        JPanel p1 = new JPanel(new FlowLayout());
        p1.add(loginButton);
        contentPane.add(p1);

        buyerButton.addActionListener(e -> sellerButton.setSelected(false));
        sellerButton.addActionListener(e -> buyerButton.setSelected(false));
       
        loginButton.addActionListener(e->{
            if(buyerButton.isSelected() && buyers.containsKey(username.getText())){
                String val = buyers.get(username.getText());
                if(val.equals(password.getText())){
                    userType = 0;
                    person = new Buyer(username.getText(), password.getText(), facade);
                    login = true;
                    counter = 1;
                }
            }else if(sellerButton.isSelected() && sellers.containsKey(username.getText())){
                String val = sellers.get(username.getText());
                if(val.equals(password.getText())){
                    userType = 1;
                    person = new Seller(username.getText(), password.getText(), facade);
                    login = true;
                    counter = 1;
                }
            }
        });
        setContentPane(contentPane);
        requestFocus();
        setFocusable(true);
        pack();

    }
    private void getBuyers() {
        buyers = new HashMap<>();
        try {
            Scanner sc = new Scanner(new File("BuyerInfo.txt"));
            while(sc.hasNextLine()){
                String str = sc.nextLine();
                str = str.replace("\n", "");
                String[] str1 = str.split(":");
                buyers.put(str1[0], str1[1]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void getsellers() {
        sellers = new HashMap<>();
        try {
            Scanner sc = new Scanner(new File("SellerInfo.txt"));
            while(sc.hasNextLine()){
                String str = sc.nextLine();
                str = str.replace("\n", "");
                String[] str1 = str.split(":");
                sellers.put(str1[0], str1[1]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean getResult() {
        while (counter == 0)
            Thread.onSpinWait();
        return login;
    }

    public int getUserType() {
        return userType;
    }

    public Person getPerson() {
        return person;
    }
}
