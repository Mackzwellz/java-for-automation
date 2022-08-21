package io.github.mackzwellz.jfa.d_abstract_interfaces.mandatory.abs_task1;

import java.awt.geom.Point2D;

public class ShapeDemo {

  public static void main(String[] args) {

    Shape[] shapes = new Shape[]{
        new Circle(3, "grey", false),
        new Rectangle(3, 6, "red", false),
        new Square(5, "yellow", false)
    };

    Point2D[] pointsForAllShapes = new Point2D[]{
        new Point2D.Double(0, 0),
        new Point2D.Double(1, 1),
        new Point2D.Double(-1, -1),
        new Point2D.Double(10, 10)
    };

    boolean[] isInsideExpectedResultsForAllShapes = new boolean[]{
        true, true, true, false
    };

    for (Shape s : shapes) {
      outputAndVerifyShapeDetails(s, pointsForAllShapes,
          isInsideExpectedResultsForAllShapes, new boolean[pointsForAllShapes.length]);
    }

    Point2D[] morePoints = new Point2D[]{
        new Point2D.Double(4, 2),
        new Point2D.Double(-2, 4),
        new Point2D.Double(-2, -4),
        new Point2D.Double(1.5, 2.5),
        new Point2D.Double(1, -2.4),
        new Point2D.Double(2.4, -1)
    };

    boolean[] isInsideExpectedResultsForCircle = new boolean[]{
        true, false, false, false, false, true
    };

    outputAndVerifyShapeDetails(shapes[0], morePoints,
        isInsideExpectedResultsForCircle, new boolean[morePoints.length]);

    boolean[] isInsideExpectedResultsForRectangle = new boolean[]{
        false, false, false, false, true, false
    };

    outputAndVerifyShapeDetails(shapes[1], morePoints,
        isInsideExpectedResultsForRectangle, new boolean[morePoints.length]);

    boolean[] isInsideExpectedResultsForSquare = new boolean[]{
        false, false, false, false, true, true
    };

    outputAndVerifyShapeDetails(shapes[2], morePoints,
        isInsideExpectedResultsForSquare, new boolean[morePoints.length]);

  }

  private static void outputAndVerifyShapeDetails(Shape s, Point2D[] points,
      boolean[] isInsideExpectedResults, boolean[] isInsideActualResults) {
    System.out.println(s);
    System.out.println("Perimeter:" + s.getPerimeter());
    System.out.println("Area:" + s.getArea());

    for (int i = 0; i < points.length; i++) {
      isInsideActualResults[i] = s.isInside(points[i].getX(), points[i].getY());
      if (isInsideActualResults[i] != isInsideExpectedResults[i]) {
        throw new AssertionError(
            String.format("isInside check failed for %s and %s: expected %s, but was %s",
                s, points[i], isInsideExpectedResults[i], isInsideActualResults[i]));
      }
      System.out.printf("Is %s inside the shape: %s\n", points[i], isInsideActualResults[i]);
    }
  }

}