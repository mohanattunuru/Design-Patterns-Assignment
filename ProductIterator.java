// using iterator pattern to iterate between product list
public class ProductIterator implements ListIterator {

    private final ClassProductList Prodlist;
    int Prodindex;

    public ProductIterator(ClassProductList Prodlist) {
        this.Prodlist = Prodlist;
        Prodindex = 0;
    }

    @Override
    public boolean hasNext() {
        boolean checkNext = Prodindex < Prodlist.size();
        return checkNext;
    }

    @Override
    public Object next() {
        return Prodlist.get(Prodindex);
    }

    @Override
    public void moveToHead() {
        Prodindex = 0;
    }

    @Override
    public void remove() {
        Prodlist.remove(Prodindex);
    }
}
