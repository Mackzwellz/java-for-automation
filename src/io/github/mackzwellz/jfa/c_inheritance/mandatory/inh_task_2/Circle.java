package io.github.mackzwellz.jfa.c_inheritance.mandatory.inh_task_2;

public class Circle extends Shape {

  protected static double DEFAULT_RADIUS = 1;
  private double radius;

  public Circle() {
    this(DEFAULT_RADIUS, DEFAULT_COLOR, DEFAULT_FILLED);
  }

  public Circle(double radius) {
    this(radius, DEFAULT_COLOR, DEFAULT_FILLED);
  }

  public Circle(double radius, String color, boolean filled) {
    super(color, filled);
    this.radius = radius;
  }

  public double getArea() {
    return Math.pow(this.radius, 2) * Math.PI; // πr^2
  }

  @Override
  public String toString() {
    return "Circle{" + "radius=" + this.radius + "} based on " + super.toString();
  }

  public double getRadius() {
    return this.radius;
  }

  public void setRadius(int radius) {
    this.radius = radius;
  }

}
