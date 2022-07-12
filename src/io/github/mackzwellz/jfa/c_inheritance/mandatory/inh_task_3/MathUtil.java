package io.github.mackzwellz.jfa.c_inheritance.mandatory.inh_task_3;

import java.util.Arrays;

public class MathUtil {

  public static int max(int[] numbers) {
    int maxValue = numbers[0];
    for (int i = 1; i < numbers.length; i++) {
      if (numbers[i] > maxValue) {
        maxValue = numbers[i];
      }
    }
    return maxValue;
  }

  public static int min(int[] numbers) {
    int minValue = numbers[0];
    for (int i = 1; i < numbers.length; i++) {
      if (numbers[i] < minValue) {
        minValue = numbers[i];
      }
    }
    return minValue;
  }

  public static double min(double[] arr) {
    Arrays.sort(arr);
    return arr[0];
  }

  public static double max(double[] arr) {
    Arrays.sort(arr);
    return arr[arr.length - 1];
  }

  public static int nextAfter(int[] arr, int number) {
    int closest = Integer.MAX_VALUE;
    for (int i : arr) {
      if (i > number && i < closest) {
        closest = i;
      }
    }
    return closest == Integer.MAX_VALUE ? 0 : closest;
  }

  public static double nextAfter(double[] arr, double number) {
    double closest = Double.MAX_VALUE;
    for (double i : arr) {
      if (i > number && i < closest) {
        closest = i;
      }
    }
    return closest == Double.MAX_VALUE ? 0 : closest;
  }

  public static int pow(int base, int pow) {
    if (pow > 0) {
      return base * MathUtil.pow(base, pow - 1);
    }
    if (pow < 0) {
      return 1 / base * MathUtil.pow(base, pow + 1);
    }
    return 1;
  }

  public static double pow(double base, double pow) {
    if (pow > 0) {
      return base * MathUtil.pow(base, pow - 1);
    }
    if (pow < 0) {
      return 1 / base * MathUtil.pow(base, pow + 1);
    }
    return 1;
  }

}
