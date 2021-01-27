package io.github.algorithm.arr;

public class MyAtoiDemo {

  /**
   * 1/4 整形字符串转换整数 请你来实现一个简易版 atoi 函数，使其能将整形字符串转换成整数。
   *
   * <p>示例 输入: "42" 输出: 42
   *
   * <p>提示： 不考虑负数情况
   */
  public int myAtoi(String str) {
    // 在此处写入代码
    char[] strArr = str.toCharArray();
    int res = 0;
    for (int i = 0, len = strArr.length; i < len; i++) {
      res = res * 10 + (strArr[i] - '0');
    }
    return res;
  }
}
