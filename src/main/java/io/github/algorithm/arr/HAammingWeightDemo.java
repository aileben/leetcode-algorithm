package io.github.algorithm.arr;

public class HAammingWeightDemo {
  /**
   * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）
   *
   * <p>示例 1： 输入：00000000000000000000000000001011 输出：3 解释：输入的二进制串 00000000000000000000000000001011
   * 中，共有三位为 '1'。
   */
  public int hammingWeight(int n) {
    int count = 0;
    for (int i = 0; i < 32; i++) {
      if ((n >> (1 * i) & 1) == 1) {
        count++;
      }
    }
    return count;
  }
}
