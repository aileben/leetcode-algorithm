package io.github.algorithm.arr;

public class MathArray {

  /*
    1、 现将字符串转为字符数组，获取字符串长度
    2、 处理首位符号问题，如果是"-"认为该字符串=负数，如果为"+"或者其他则认为该字符串为正数
    3、 循环遍历字符串，判断当前字符串是否等于[0-9]中的数字，如果等于则通过，如果遇到e则遍历后边字符是否为整数
          如果为整数则认为该字符串是数字如果不是则判定该字符串不是整数
          验证给定的字符串是否可以解释为十进制数字。

   例如:

    "0" => true
    " 0.1 " => true
    ".1 " => true
    "3." => true
    "abc" => false
    "1 a" => false
    "2e10" => true
    " -90e3 " => true
    " 1e" => false
    "e3" => false
    " 6e-1" => true
    " 99e2.5 " => false
    "53.5e93" => true
    " --6 " => false
  "-+3" => false
  "95a54e53" => false
    */
  public static boolean isNumber(String s) {
    s = s.trim();
    if (s.isEmpty()) {
      return false;
    }
    // 在此处写入代码
    boolean flag = true;

    if (s.contains("e")) {

      String temp = s.substring(s.indexOf("e") + 1);
      String temp1 = s.substring(0, s.indexOf("e"));
      char[] tempArr = temp.toCharArray();
      char[] tempArr1 = temp1.toCharArray();
      int tempLen = tempArr.length;
      int tempLen1 = temp1.length();
      if (tempLen <= 0 || tempLen1 <= 0) {
        flag = false;
        return flag;
      }

      int count = 0;
      for (int i = 0; i < tempLen1; i++) {
        if (i == 0) {
          if (tempArr1[0] == '+'
              || tempArr1[0] == '-'
              || tempArr1[0] == '0'
              || tempArr1[0] == '1'
              || tempArr1[0] == '2'
              || tempArr1[0] == '3'
              || tempArr1[0] == '4'
              || tempArr1[0] == '5'
              || tempArr1[0] == '6'
              || tempArr1[0] == '7'
              || tempArr1[0] == '8'
              || tempArr1[0] == '9') {
            flag = true;
            continue;
          } else {
            flag = false;
            return flag;
          }
        }

        if (tempArr1[i] == '.') {
          count++;
          continue;
        }

        if (count > 1) {
          flag = false;
          return flag;
        }

        if (tempArr1[i] == '0'
            || tempArr1[i] == '1'
            || tempArr1[i] == '2'
            || tempArr1[i] == '3'
            || tempArr1[i] == '4'
            || tempArr1[i] == '5'
            || tempArr1[i] == '6'
            || tempArr1[i] == '7'
            || tempArr1[i] == '8'
            || tempArr1[i] == '9') {
          flag = true;
          continue;
        } else {
          flag = false;
          return flag;
        }
      }
      for (int i = 0; i < tempLen; i++) {
        if (i == 0) {
          if (tempArr[0] == '+'
              || tempArr[0] == '-'
              || tempArr[0] == '0'
              || tempArr[0] == '1'
              || tempArr[0] == '2'
              || tempArr[0] == '3'
              || tempArr[0] == '4'
              || tempArr[0] == '5'
              || tempArr[0] == '6'
              || tempArr[0] == '7'
              || tempArr[0] == '8'
              || tempArr[0] == '9') {
            flag = true;
            continue;
          } else {
            flag = false;
            return flag;
          }
        }
        if (tempArr[i] == '0'
            || tempArr[i] == '1'
            || tempArr[i] == '2'
            || tempArr[i] == '3'
            || tempArr[i] == '4'
            || tempArr[i] == '5'
            || tempArr[i] == '6'
            || tempArr[i] == '7'
            || tempArr[i] == '8'
            || tempArr[i] == '9') {
          flag = true;
          continue;
        } else {
          flag = false;
          return flag;
        }
      }

      return flag;
    }

    char[] arr = s.toCharArray();
    int len = arr.length;

    int count = 0;
    for (int i = 0; i < len; i++) {
      if (i == 0) {
        if (arr[0] == '+'
            || arr[0] == '-'
            || arr[0] == '0'
            || arr[0] == '1'
            || arr[0] == '2'
            || arr[0] == '3'
            || arr[0] == '4'
            || arr[0] == '5'
            || arr[0] == '6'
            || arr[0] == '7'
            || arr[0] == '8'
            || arr[0] == '9'
            || arr[0] == '.') {
          if (arr[0] == '.') {
            count++;
          }

          flag = true;
          continue;
        } else {
          flag = false;
          return flag;
        }
      }
      if (arr[i] == '.') {
        count++;
        continue;
      }

      if (count > 1) {
        flag = false;
        return flag;
      }

      if (arr[i] == '0'
          || arr[i] == '1'
          || arr[i] == '2'
          || arr[i] == '3'
          || arr[i] == '4'
          || arr[i] == '5'
          || arr[i] == '6'
          || arr[i] == '7'
          || arr[i] == '8'
          || arr[i] == '9'
          || arr[i] == '.') {
        flag = true;
        if (arr[0] == '.') {
          count++;
        }
        continue;
      } else {
        flag = false;
        return flag;
      }
    }

    return flag;
  }

  /*
  这题看着很麻烦，实际上也有些麻烦，但只要把注意的点都搞清楚，其实代码结构是很简单的

  先设定numSeen，dotSeen和eSeen三种boolean变量，分别代表是否出现数字、点和E
  然后遍历目标字符串
  1.判断是否属于数字的0~9区间
  2.遇到点的时候，判断前面是否有点或者E，都需要return false
  3.遇到E的时候，判断前面数字是否合理，是否有E，并把numSeen置为false，防止E后无数字
  4.遇到-+的时候，判断是否是第一个，如果不是第一个判断是否在E后面，都不满足则return false
  5.其他情况都为false
  最后返回numSeen的结果即可
  */

  public static boolean isNumber1(String s) {
    if (s == null || s.length() == 0) return false;
    boolean numSeen = false;
    boolean dotSeen = false;
    boolean eSeen = false;

    char arr[] = s.trim().toCharArray();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] >= '0' && arr[i] <= '9') {
        numSeen = true;
      } else if (arr[i] == '.') {
        if (dotSeen || eSeen) {
          return false;
        }
        dotSeen = true;
      } else if (arr[i] == 'E' || arr[i] == 'e') {
        if (eSeen || !numSeen) {
          return false;
        }
        eSeen = true;
        numSeen = false;
      } else if (arr[i] == '+' || arr[i] == '-') {
        if (i != 0 && arr[i - 1] != 'e' && arr[i - 1] != 'E') {
          return false;
        }
      } else {
        return false;
      }
    }
    return numSeen;
  }

  public static void main(String[] args) {
    System.out.println(isNumber1(" 0.1"));
  }
}
