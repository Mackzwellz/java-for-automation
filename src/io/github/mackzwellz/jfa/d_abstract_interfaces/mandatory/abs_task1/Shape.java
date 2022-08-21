package io.github.mackzwellz.jfa.d_abstract_interfaces.mandatory.abs_task1;


public abstract class Shape {

  protected static String DEFAULT_COLOR = "green";
  protected static boolean DEFAULT_FILLED = true;
  private String color;
  private boolean filled;

  public Shape() {
    this(DEFAULT_COLOR, DEFAULT_FILLED);
  }

  public Shape(String color, boolean filled) {
    this.color = color;
    this.filled = filled;
  }

  public String getColor() {
    return this.color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public boolean isFilled() {
    return this.filled;
  }

  public void setFilled(boolean filled) {
    this.filled = filled;
  }

  public abstract double getArea();

  public abstract double getPerimeter();

  public abstract boolean isInside(double x, double y);

  @Override
  public String toString() {
    return "Shape{" + "color='" + this.color + "', filled=" + this.filled + "}";
  }
}
