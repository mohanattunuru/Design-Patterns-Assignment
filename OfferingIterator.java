// Using iterator pattern to iterate between offering list
public class OfferingIterator implements ListIterator{

    private final OfferingList Offeredlist;
    int Offerindex;

    public OfferingIterator(OfferingList Offeredlist) {
        this.Offeredlist = Offeredlist;
        Offerindex = 0;
    }

    @Override
    public boolean hasNext() {
        boolean checkNext;
        checkNext = Offerindex < Offeredlist.size();
        return checkNext;
    }

    @Override
    public Object next() {
        return Offeredlist.get(Offerindex);
    }

    @Override
    public void moveToHead() {
        Offerindex = 0;
    }

    @Override
    public void remove() {
        Offeredlist.remove(Offerindex);
    }
}
