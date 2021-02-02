package io.github.algorithm.link;

public class GetSumDemo {

  /**
   * 不使用运算符 + 和 - ，计算两整数 a 、b 之和。
   *
   * <p>输入输出的取值范围为[-2^31,2^31-1] 如果计算结果溢出，我们将你的计算结果以二进制补码表示，并只取低32位作为输出
   *
   * @param a
   * @param b
   * @return
   */
  public static int getSum(int a, int b) {
    // 无进位加法使用异或运算计算得出,进位结果使用与运算和移位运算计算得出;
    if (b != 0) {
      int xor = a ^ b;
      int and = (a & b) << 1;
      return getSum(xor, and);
    } else {
      return a;
    }
  }

  public static void main(String[] args) {
    // |
    int a = 5, b = 0, c = 1;
    // System.out.println(5 | 0);
    System.out.println(5 | 1);
    // ==============
    System.out.println(5 & 0);
    // System.out.println(5 & 1);

    // ===========

    System.out.println(10 ^ 0);
  }
}
