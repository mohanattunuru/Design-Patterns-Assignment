
// Reminder pattern is used in that class to send the reminder to user

public abstract class NodeVisitor {
    public abstract void visitProduct(Product product);
    public abstract void visitTrading(Trading trading);
    public abstract void visitFacade(Facade facade);
}
