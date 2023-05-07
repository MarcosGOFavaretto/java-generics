import java.util.List;

public class NamedPallet<N, B extends List> {

    private N name;
    private B boxes;

    public NamedPallet(N name, B boxes) {
        this.setName(name);
        this.boxes = boxes;
    }

    public N getName() {
        return this.name;
    }

    public void setName(N name) {
        this.name = name;
    }

    public B getBoxes() {
        return this.boxes;
    }

    public void setBoxes(B boxes) {
        this.boxes = boxes;
    }

    public <N, V> boolean isBoxPresentOnPallet(NamedBox<N, V> box) {
        return getBoxes().contains(box);
    }

    @Override
    public String toString() {
        return "The " + getName() + " pallet contains " + getBoxes().size() + " boxes.";
    }

}