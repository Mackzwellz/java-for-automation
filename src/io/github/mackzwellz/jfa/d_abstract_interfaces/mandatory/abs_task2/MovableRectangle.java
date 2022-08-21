package io.github.mackzwellz.jfa.d_abstract_interfaces.mandatory.abs_task2;

public class MovableRectangle implements Moveable {

  private final MovablePoint topLeft;
  private final MovablePoint bottomRight;

  public MovableRectangle(MovablePoint topLeft, MovablePoint bottomRight) {
    this.topLeft = topLeft;
    this.bottomRight = bottomRight;
  }

  @Override
  public String toString() {
    return "MovableRectangle{" + "topLeft=" + this.topLeft + ", bottomRight=" + this.bottomRight + "}";
  }

  @Override
  public void moveUp() {
    this.topLeft.moveUp();
    this.bottomRight.moveUp();
  }

  @Override
  public void moveDown() {
    this.topLeft.moveDown();
    this.bottomRight.moveDown();
  }

  @Override
  public void moveLeft() {
    this.topLeft.moveLeft();
    this.bottomRight.moveLeft();
  }

  @Override
  public void moveRight() {
    this.topLeft.moveRight();
    this.bottomRight.moveRight();
  }
}
