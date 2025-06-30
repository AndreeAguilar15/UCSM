package hash;

public class Registerc {
    private int key;

    public Registerc(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    @Override
    public String toString() {
        return "("+key+")";
    }
}
