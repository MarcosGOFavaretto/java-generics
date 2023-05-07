public class Box {

    private Object item;

    public Box() {
    }

    public Box(Object item) {
        this.setItem(item);
    }

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return getItem().toString();
    }

}