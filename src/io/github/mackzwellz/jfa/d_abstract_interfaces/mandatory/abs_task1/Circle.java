package io.github.mackzwellz.jfa.d_abstract_interfaces.mandatory.abs_task1;

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
  public double getPerimeter() {
    return 2 * Math.PI * this.radius;  // 2πr
  }

  @Override
  public boolean isInside(double x, double y) {
    return Math.pow(y, 2) + Math.pow(y, 2) < Math.pow(this.radius, 2); //  (x - center_x = 0)² + (y - center_y = 0)² < radius²
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
