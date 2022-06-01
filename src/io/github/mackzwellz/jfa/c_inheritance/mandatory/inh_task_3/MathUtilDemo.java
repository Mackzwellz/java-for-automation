package io.github.mackzwellz.jfa.c_inheritance.mandatory.inh_task_3;

public class MathUtilDemo {

  public static void main(String[] args) {
    int[] testArr = {5, 31, -10, 17, 41};
    double[] testArr2 = {7, 33, -12, 19, 43};

    System.out.println("Max number in int array: " + MathUtil.max(testArr));
    System.out.println("Max number in double array: " + MathUtil.max(testArr2));
    System.out.println("Min number in int array: " + MathUtil.min(testArr));
    System.out.println("Min number in double array: " + MathUtil.min(testArr2));

    System.out.println("Closest greater number to 5 in int array: " + MathUtil.nextAfter(testArr, 5));
    System.out.println("Closest greater number to -11 in int array: " + MathUtil.nextAfter(testArr, -11));
    System.out.println("Closest greater number to 45 in int array: " + MathUtil.nextAfter(testArr, 45));

    System.out.println("Closest greater number to 5 in double array: " + MathUtil.nextAfter(testArr2, 5));
    System.out.println("Closest greater number to -11 in double array: " + MathUtil.nextAfter(testArr2, -11));
    System.out.println("Closest greater number to 45 in double array: " + MathUtil.nextAfter(testArr2, 45));


    System.out.println("Integers: Power of 2 to 0: " + MathUtil.pow(2, 0));
    System.out.println("Integers: Power of 2 to -3: " + MathUtil.pow(2,-3));
    System.out.println("Integers: Power of 3 to 2: " + MathUtil.pow(3,2));

    System.out.println("Doubles: Power of 2 to 0: " + MathUtil.pow(2d, 0d));
    System.out.println("Doubles: Power of 2 to -3: " + MathUtil.pow(2d,-3d));
    System.out.println("Doubles: Power of 3 to 2: " + MathUtil.pow(3d,2d));
  }

}
