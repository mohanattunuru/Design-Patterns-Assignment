import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ProductMenuFrame extends JFrame {

    public ProductMenuFrame(Facade facade) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Product Menu");

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel p1 = new JPanel(new FlowLayout());
        JButton trading = new JButton("Add trading");
        p1.add(trading);

        JPanel p2 = new JPanel(new FlowLayout());
        JButton view = new JButton("View trading");
        p2.add(view);

        JPanel p3 = new JPanel(new FlowLayout());
        JButton markOffering = new JButton("Mark Offering");
        p3.add(markOffering);

        JPanel p4 = new JPanel(new FlowLayout());
        JButton submitOffering = new JButton("Submit Offering");
        p4.add(submitOffering);

        JPanel p5 = new JPanel(new FlowLayout());
        JButton remind = new JButton("Remind");
        p5.add(remind);

        JPanel p6 = new JPanel(new FlowLayout());
        JButton product_list = new JButton("Create Product List");
        p6.add(product_list);

        JPanel p7 = new JPanel(new FlowLayout());
        JButton attach = new JButton("Attach Product to user");
        p7.add(attach);

        JPanel p8 = new JPanel(new FlowLayout());
        JButton select = new JButton("Select Product");
        p8.add(select);

        contentPane.add(p1);
        contentPane.add(p2);
        contentPane.add(p3);
        contentPane.add(p4);
        contentPane.add(p5);
        contentPane.add(p6);
        contentPane.add(p7);
        contentPane.add(p8);

        if(facade.getUserType() == 1) {
            p4.setVisible(false);
            p5.setVisible(false);
        }

        setContentPane(contentPane);
        pack();

        trading.addActionListener(e->facade.addTrading());
        view.addActionListener(e->facade.viewTrading());
        markOffering.addActionListener(e->facade.markOffering());
        submitOffering.addActionListener(e->facade.submitOffering());
        product_list.addActionListener(e->facade.createProductList());
        remind.addActionListener(e->facade.remind());
        attach.addActionListener(e->facade.attachProductToUser());
        select.addActionListener(e->facade.selectProduct());
    }
}
