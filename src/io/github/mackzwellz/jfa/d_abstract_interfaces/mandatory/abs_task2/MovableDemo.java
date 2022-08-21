package io.github.mackzwellz.jfa.d_abstract_interfaces.mandatory.abs_task2;

public class MovableDemo {

  public static void main(String[] args) {

    MovableRectangle rect = new MovableRectangle(new MovablePoint(0,1,2,1), new MovablePoint( 1,0,1,2));

    System.out.println("Movable rectangle after creation:\n" + rect);

    rect.moveUp();

    System.out.println("Movable rectangle after moving once up:\n" + rect);

    rect.moveRight();

    System.out.println("Movable rectangle after moving once right:\n" + rect);

    rect.moveLeft();
    rect.moveDown();
    rect.moveLeft();
    rect.moveDown();

    System.out.println("Movable rectangle after moving twice down and twice left:\n" + rect);

  }

}
