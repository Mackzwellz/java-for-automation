package io.github.mackzwellz.jfa.c_inheritance.mandatory.inh_task_2;

public class Square extends Rectangle {

  protected static double DEFAULT_SIDE = 1;

  public Square() {
    this(DEFAULT_SIDE, DEFAULT_COLOR, DEFAULT_FILLED);
  }

  public Square(double side) {
    this(side, DEFAULT_COLOR, DEFAULT_FILLED);
  }

  public Square(double side, String color, boolean filled) {
    super(side, side, color, filled);
  }

  @Override
  public void setWidth(double width) {
    super.setWidth(width);
    super.setLength(width);
  }

  @Override
  public void setLength(double length) {
    super.setWidth(length);
    super.setLength(length);
  }

  @Override
  public String toString() {
    return "Square{} based on " + super.toString();
  }

}
