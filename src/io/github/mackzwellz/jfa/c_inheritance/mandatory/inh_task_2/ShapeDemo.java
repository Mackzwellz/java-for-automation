package io.github.mackzwellz.jfa.c_inheritance.mandatory.inh_task_2;

public class ShapeDemo {

  public static void main(String[] args) {

    Shape[] shapes = new Shape[]{new Circle(), new Rectangle(), new Square(),
        new Circle(3, "grey", false),
        new Rectangle(2, 4, "red", false),
        new Square(5, "yellow", false)};

    for (Shape s : shapes) {
      System.out.println(s);
      if (s instanceof Rectangle) {
        System.out.println("Perimeter:" + ((Rectangle) s).getPerimeter());
      } else {
        System.out.println("Area:" + ((Circle) s).getArea());
      }
    }
  }
}