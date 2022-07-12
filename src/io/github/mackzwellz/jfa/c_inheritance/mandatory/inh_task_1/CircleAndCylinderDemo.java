package io.github.mackzwellz.jfa.c_inheritance.mandatory.inh_task_1;

public class CircleAndCylinderDemo {

  public static void main(String[] args) {
    Circle a = new Circle();
    System.out.println(a);
    System.out.println("Circle area:" + a.getArea());

    Cylinder b = new Cylinder();
    System.out.println(b);
    System.out.println("Cylinder area:" + b.getArea());
    System.out.println("Cylinder volume:" + b.getVolume());


    Circle a1 = new Circle(3, "red");
    System.out.println(a1);
    System.out.println("Circle area:" + a1.getArea());

    Cylinder b1 = new Cylinder(4,"green", 2);
    System.out.println(b1);
    System.out.println("Cylinder area:" + b1.getArea());
    System.out.println("Cylinder volume:" + b1.getVolume());
  }

}
