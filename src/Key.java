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

    public static boolean isConnected(Key head, Key tail) {
        int headx = head.x;
        int heady = head.y;

        int tailx = tail.x;
        int taily = tail.y;

        if (Math.abs(headx - tailx) > 1 || Math.abs(heady - taily) > 1) {
            return false;
        } 
        return true;
    }

    public Key moveHead(String direction) {
        if (direction.equals("R")) {
            return new Key(this.x + 1, this.y);
        } else if (direction.equals("L")) {
            return new Key(this.x - 1, this.y);
        } else if (direction.equals("U")) {
            return new Key(this.x, this.y + 1);
        } else if (direction.equals("D")) {
            return new Key(this.x, this.y - 1);
        }
        return null;
    }

    public Key moveTail(String direction) {
        if (direction.equals("R")) {
            return new Key(this.x - 1, this.y);
        } else if (direction.equals("L")) {
            return new Key(this.x + 1, this.y);
        } else if (direction.equals("U")) {
            return new Key(this.x, this.y - 1);
        } else if (direction.equals("D")) {
            return new Key(this.x, this.y + 1);
        }
        return null;
    }

    public Key moveTail2(String direction) {
        if (direction.equals("R")) {
            return new Key(this.x + 1, this.y);
        } else if (direction.equals("L")) {
            return new Key(this.x - 1, this.y);
        } else if (direction.equals("U")) {
            return new Key(this.x, this.y + 1);
        } else if (direction.equals("D")) {
            return new Key(this.x, this.y - 1);
        } else if (direction.equals("RD")) {
            return new Key(this.x + 1, this.y - 1);
        } else if (direction.equals("LD")) {
            return new Key(this.x - 1, this.y - 1);
        } else if (direction.equals("RU")) {
            return new Key(this.x + 1, this.y + 1);
        } else if (direction.equals("LU")) {
            return new Key(this.x - 1, this.y + 1);
        }
        System.out.println("move tail2");
        return null;
    }

    public String giveDirections(Key head, Key tail) {
        int headx = head.x;
        int heady = head.y;

        int tailx = tail.x;
        int taily = tail.y;

        //check whether same level x-axis
        if (headx == tailx) {
            //only up or down
            if (heady > taily) {
                return "U";
            } else {
                return "D";
            }
        } else if (heady == taily) {
            //only left or right
            if (headx > tailx) {
                return "R";
            } else {
                return "L";
            }
        } else {
            if (heady > taily && headx > tailx) {
                return "RU";
            } else if(heady > taily && headx < tailx) {
                return "LU";
            } else if(heady < taily && headx < tailx) {
                return "LD";
            } else if(heady < taily && headx > tailx) {
                return "RD";
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return String.format("x:%s,y:%s", this.x, this.y); 
    }
}
