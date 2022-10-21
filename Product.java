public class Product {
    private String Prodname;
    private String Prodtype;

    public Product(String name, String type) {
        Prodname = name;
        Prodtype = type;
    }

    public String getType() {
        return Prodtype;
    }

    public String getName() {
        return Prodname;
    }

    public void setType(String type) {
        Prodtype = type;
    }

    public void setName(String name) {
        Prodname = name;
    }

 

    public void accept(ReminderVisitor reminderVisitor) {
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + Prodname + '\'' +
                ", type='" + Prodtype + '\'' +
                '}';
    }
}
