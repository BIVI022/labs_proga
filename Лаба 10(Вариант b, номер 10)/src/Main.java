public class Main {

    public static void main(String[] args) {

        Polygon polygon1 = new Polygon(new Point2[]{
                new Point2(2, 2),
                new Point2(4, 5),
                new Point2(8, 4),
                new Point2(8, 2),
        });
        Polygon polygon2 = new Polygon(new Point2[]{
                new Point2(1, 3),
                new Point2(3, 4),
                new Point2(5, 4),
                new Point2(6, 2),
                new Point2(4, 1),
        });
        Polygon polygon3 = new Polygon(new Point2[]{
                new Point2(7, 10),
                new Point2(9, 9),
                new Point2(10, 7),
                new Point2(10, 5),
                new Point2(9, 3),
                new Point2(7, 2),
                new Point2(5, 2),
                new Point2(3, 3),
                new Point2(2, 5),
                new Point2(2, 7),
                new Point2(3, 9),
                new Point2(5, 10),
        });

        float area1 = polygon1.getArea();
        float area2 = polygon2.getArea();
        float area3 = polygon3.getArea();
        System.out.println("Polygon 1 area: " + area1);
        System.out.println("Polygon 2 area: " + area2);
        System.out.println("Polygon 3 area: " + area3);
    }

}
