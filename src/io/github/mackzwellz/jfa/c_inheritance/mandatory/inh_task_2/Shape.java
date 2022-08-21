package io.github.mackzwellz.jfa.c_inheritance.mandatory.inh_task_2;


public class Shape {

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

  @Override
  public String toString() {
    return "Shape{" + "color='" + this.color + "', filled=" + this.filled + "}";
  }
}
