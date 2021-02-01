package io.github.algorithm.link;

public class AddBinaryDemo {

  /*
  1/4 二进制求和
  给你两个二进制字符串，返回它们的和（用二进制表示）。
  输入为 非空 字符串且只包含数字 1 和 0。
    1、获取两个字符串的长度
    2、声明进位临时变量，和临时整型数组（临时数组的长度是较长数组加一）
    3、将字符串转为字符串数组，逆序遍历，低位二进制求和进位放到临时变量中
    4、将整型数据转为字符串
    5、默认字符串最长的长度不超过整型
    */
  //  public static String addBinary(String a, String b) {
  //    int aLen = a.length(), bLen = b.length();
  //
  //    int maxLen = aLen >= bLen ? aLen : bLen;
  //    int divLeb = aLen >= bLen ? aLen - bLen : bLen - aLen;
  //
  //    char[] aArr = a.toCharArray();
  //    char[] bArr = b.toCharArray();
  //
  //    int[] aTemp = new int[maxLen];
  //    int[] bTemp = new int[maxLen];
  //
  //    for (int i = 0; i < maxLen; i++) {
  //      if (aLen >= bLen) {
  //        aTemp[i] = aArr[i] - '0';
  //        if (i <= maxLen && i >= divLeb) {
  //          bTemp[i] = bArr[i - divLeb] - '0';
  //        } else {
  //          bTemp[i] = 0;
  //        }
  //      } else {
  //        bTemp[i] = bArr[i] - '0';
  //        if (i <= maxLen && i >= divLeb) {
  //          aTemp[i] = aArr[i - divLeb] - '0';
  //        } else {
  //          aTemp[i] = 0;
  //        }
  //      }
  //    }
  //
  //    int[] arr = new int[maxLen];
  //    int temp = 0;
  //    for (int i = arr.length - 1; i >= 0; i--) {
  //      arr[i] = (aTemp[i] + bTemp[i] + temp) % 2;
  //      temp = (aTemp[i] + bTemp[i] + temp) / 2;
  //    }
  //    StringBuilder result = new StringBuilder(temp == 0 ? "" : "1");
  //    for (int i = 0; i < maxLen; i++) {
  //      result.append(arr[i]);
  //    }
  //    return result.toString();
  //  }

  public static void main(String[] args) {
    String a = "11000000111";
    String b = "10101100111001000100010101111101010010000100101";
    //    String a = "1101";
    //    String b = "1011";
    System.out.println(addBinary2(a, b));
  }

  public static String addBinary2(String a, String b) {

    int alen = a.length(), blen = b.length(), temp = 0;
    StringBuilder builder = new StringBuilder();
    int maxLen = alen >= blen ? alen : blen;

    for (int i = 0; i < maxLen; i++) {
      temp += i < alen ? (a.charAt(alen - 1 - i) - '0') : 0;
      temp += i < blen ? (b.charAt(blen - 1 - i) - '0') : 0;

      builder.append((char) (temp % 2 + '0'));
      temp /= 2;
    }

    return temp > 0 ? builder.append("1").reverse().toString() : builder.reverse().toString();
  }

  //  public static String addBinary1(String a, String b) {
  //    StringBuffer ans = new StringBuffer();
  //    // 二进制相加，末尾对齐，逐位相加，逢二进一
  //    int n = Math.max(a.length(), b.length()), carry = 0; // carry表示上一位置的进位，初始为0
  //    // 从低位开始遍历相加，a、b中短的位置补0
  //    for (int i = 0; i < n; ++i) {
  //      carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
  //      carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
  //      ans.append((char) (carry % 2 + '0'));
  //      carry /= 2;
  //    }
  //    // 进位有值，存入答案字符串中
  //    if (carry > 0) {
  //      ans.append('1');
  //    }
  //    // 最终将答案串反转
  //    ans.reverse();
  //
  //    return ans.toString();
  //  }
}
