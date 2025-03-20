class Shape {
    public Shape() {
        draw();
    }

    public void sleep() {
        System.out.println("Draw");
    }
}

class Point extends Shape {
    protected int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void sleep() {
        System.out.println("Point");
    }
}

class Test {
    public static void main(String[] args) {
        Point p = new Point(1,1);
        p.sleep();
    }
}