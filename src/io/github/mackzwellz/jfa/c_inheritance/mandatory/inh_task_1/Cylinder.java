package io.github.mackzwellz.jfa.c_inheritance.mandatory.inh_task_1;

public class Cylinder extends Circle {

  static protected double DEFAULT_HEIGHT = 1;
  private double height;

  public Cylinder() {
    this(DEFAULT_RADIUS, DEFAULT_COLOR, DEFAULT_HEIGHT);
  }

  public Cylinder(double radius) {
    this(radius, DEFAULT_COLOR, DEFAULT_HEIGHT);
  }

  public Cylinder(double radius, double height) {
    this(radius, DEFAULT_COLOR, height);
  }

  public Cylinder(double radius, String color, double height) {
    super(radius, color);
    this.height = height;
  }

  public double getHeight() {
    return this.height;
  }

  public void setHeight(double height) {
    this.height = height;
  }

  @Override
  public String toString() {
    return "Cylinder{" +
        "height=" + this.height +
        "} based on " + super.toString();
  }

  public double getArea() {
    return 2 * Math.PI * this.getRadius() * this.height + 2 * super.getArea(); //2πrh+2πr^2
  }

  public double getVolume() {
    return super.getArea() * this.height; //πr^2h
  }

}
