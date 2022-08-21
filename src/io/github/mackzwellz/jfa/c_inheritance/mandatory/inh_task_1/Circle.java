package io.github.mackzwellz.jfa.c_inheritance.mandatory.inh_task_1;


public class Circle {

  static protected double DEFAULT_RADIUS = 1;
  static protected String DEFAULT_COLOR = "white";
  private double radius;
  private String color;

  public Circle() {
    this(DEFAULT_RADIUS, DEFAULT_COLOR);
  }

  public Circle(double radius) {
    this(radius, DEFAULT_COLOR);
  }

  public Circle(double radius, String color) {
    this.radius = radius;
    this.color = color;
  }

  public double getArea() {
    return Math.pow(this.radius, 2) * Math.PI; // πr^2
  }

  @Override
  public String toString() {
    return "Circle{" + "radius=" + this.radius + ", color='" + this.color + "'}";
  }

  public double getRadius() {
    return this.radius;
  }

  public void setRadius(int radius) {
    this.radius = radius;
  }

  public String getColor() {
    return this.color;
  }

  public void setColor(String color) {
    this.color = color;
  }
}
