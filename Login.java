
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
    
}
