package Day12;
public class Key {
    private final int x;
    private final int y;

    public Key(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Key)) {
            return false;
        }

        Key c = (Key) o;

        return c.x == this.x && c.y == this.y;
    }

    @Override
    public int hashCode() {
        return (x << 16) + y;
    }

    @Override
    public String toString() {
        return String.format("x:%s,y:%s", this.x, this.y); 
    }
}
