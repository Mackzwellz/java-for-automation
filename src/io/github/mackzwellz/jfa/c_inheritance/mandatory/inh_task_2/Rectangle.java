package io.github.mackzwellz.jfa.c_inheritance.mandatory.inh_task_2;

public class Rectangle extends Shape {

  protected static double DEFAULT_WIDTH = 1;
  protected static double DEFAULT_LENGTH = 1;
  private double width;
  private double length;

  public Rectangle() {
    this(DEFAULT_WIDTH, DEFAULT_LENGTH, DEFAULT_COLOR, DEFAULT_FILLED);
  }

  public Rectangle(double width, double length) {
    this(width, length, DEFAULT_COLOR, DEFAULT_FILLED);
  }

  public Rectangle(double width, double length, String color, boolean filled) {
    super(color, filled);
    this.width = width;
    this.length = length;
  }

  public double getWidth() {
    return width;
  }

  public void setWidth(double width) {
    this.width = width;
  }

  public double getLength() {
    return length;
  }

  public void setLength(double length) {
    this.length = length;
  }

  public double getPerimeter() {
    return width * length;
  }

  @Override
  public String toString() {
    return "Rectangle{" +
        "width=" + width +
        ",length=" + length +
        "} based on " + super.toString();
  }


}
