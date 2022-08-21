package io.github.mackzwellz.jfa.d_abstract_interfaces.mandatory.abs_task2;

public class MovablePoint implements Moveable {

  private int x;
  private int y;
  private int xSpeed;
  private int ySpeed;

  public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
    this.x = x;
    this.y = y;
    this.xSpeed = xSpeed;
    this.ySpeed = ySpeed;
  }

  @Override
  public String toString() {
    return "MovablePoint{" + "x=" + this.x + ", y=" + this.y + ", xSpeed=" + this.xSpeed
        + ", ySpeed=" + this.ySpeed + "}";
  }

  @Override
  public void moveUp() {
    this.y = this.y + this.ySpeed;
  }

  @Override
  public void moveDown() {
    this.y = this.y - this.ySpeed;
  }

  @Override
  public void moveLeft() {
    this.x = this.x - this.xSpeed;
  }

  @Override
  public void moveRight() {
    this.x = this.x + this.xSpeed;
  }
}
