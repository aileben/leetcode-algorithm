package io.github.algorithm.link;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddToArrayFormDemo {

  /**
   * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
   *
   * <p>给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
   *
   * <p>示例 1： 输入：A = [1,2,0,0], K = 34 输出：[1,2,3,4] 解释：1200 + 34 = 1234 1 <= A.length <= 10000 0 <=
   * A[i] <= 9 0 <= K <= 10000 如果 A.length > 1，那么 A[0] != 0
   */
  //  public static List<Integer> addToArrayForm(int[] A, int K) {
  //    int alen = A.length, klen = String.valueOf(K).length();
  //    int maxLen = alen >= klen ? alen : klen;
  //    int temp = 0;
  //
  //    List<Integer> lists = new ArrayList<>();
  //    for (int i = 0; i < maxLen; i++) {
  //      temp += i < alen ? A[alen - 1 - i] : 0;
  //      if (i < klen) {
  //        temp += K % 10;
  //        K /= 10;
  //      }
  //      lists.add(temp % 10);
  //      temp /= 10;
  //    }
  //
  //    if (temp != 0) {
  //      lists.add(temp);
  //    }
  //    Collections.reverse(lists);
  //    return lists;
  //  }

  // 将整个加数加入数组表示的数的最低位，通过求余数计算留下来的数值，求除数计算进位数值；
  public static List<Integer> addToArrayForm(int[] A, int K) {
    int N = A.length;
    int cur = K;
    List<Integer> ans = new ArrayList<>();

    int i = N;
    while (--i >= 0 || cur > 0) {
      if (i >= 0) cur += A[i];
      ans.add(cur % 10);
      cur /= 10;
    }
    Collections.reverse(ans);
    return ans;
  }

  public static void main(String[] args) {
    int[] A = new int[] {9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
    int k = 1;
    List<Integer> res = addToArrayForm(A, k);
    System.out.println(res.toString());
  }
}
