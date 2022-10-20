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
    }

}
