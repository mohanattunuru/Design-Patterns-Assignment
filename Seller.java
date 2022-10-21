import javax.swing.*;

public class Seller extends Person{
    public Seller(String name, String password, Facade facade) {
        super(name, password, facade);
    }

    @Override
    public ProductMenu createProductMenu()
    {
        // use factory pattern to decide which menu to display
        String selection = JOptionPane.showInputDialog("Press A for MeatProductMenu\n\nPress B ProduceProductMenu\n\n");
        if(selection.equalsIgnoreCase("A" )){
            System.out.println(super.productMenu);
            super.productMenu = new MeatProductMenu(this);
        }else if(selection.equalsIgnoreCase("B" )){
            super.productMenu = new ProduceProductMenu(this);
        }
        else{
            JOptionPane.showMessageDialog( null, "Enter either A or B", "Error", JOptionPane.ERROR_MESSAGE );
        }
        return super.productMenu;
    }
    @Override
    public void showMenu() {
        super.productMenu.showMenu();
    }
}
