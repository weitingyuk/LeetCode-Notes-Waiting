package Leetcode;

import java.util.regex.Pattern;

public class ValidIPAddress468 {
  /* Method1: Regex , Time: O(1), Space:O(1)**/
  /**
   正则表达式: 共有五种情况：
   块只包含一位数字，范围是 0 到 9。
   块包含两位数字，第一位的范围是 1 到 9，第二位是 0 到 9。
   块包含三位数字，且第一位为 1。第二、三位可以是 0 到 9。
   块包含三位数字，且第一位为 2，第二位为 0 到 4。那么第三位可以是 0 到 9。
   块包含三位数字，且第一位为 2，第二位为 5，那么第三位可以是 0 到 5。
   **/
  String chunkIPv4 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
  Pattern patternIPv4 = Pattern.compile("^(" + chunkIPv4 + "\\.){3}" + chunkIPv4 + "$");

  String chunkIPv6 = "([0-9a-fA-F]{1,4})";
  Pattern patternIPv6 = Pattern.compile("^(" + chunkIPv6 + "\\:){7}" + chunkIPv6 + "$");
  public String validIPAddress(String IP) {
    if(IP.contains(".")){
      return (patternIPv4.matcher(IP).matches()) ? "IPv4" : "Neither";
    } else if(IP.contains(":")) {
      return (patternIPv6.matcher(IP).matches()) ? "IPv6" : "Neither";
    }
    return "Neither";
  }

  /* Method2: split , Time: O(1), Space:O(1)**/
  /**
   对于 IPv4 地址，通过界定符 . 将地址分为四块；对于 IPv6 地址，通过界定符 : 将地址分为八块。
   对于 IPv4 地址的每一块，检查它们是否在 0 - 255 内，且没有前置零。
   对于 IPv6 地址的每一块，检查其长度是否为 1 - 4 位的十六进制数。
   **/
  public String validIPAddress2(String IP) {
    String[] IP4Arr = IP.split("\\.",-1);
    if(IP4Arr.length == 4){
      return isIP4Arr(IP4Arr);
    }

    String[] IP6Arr = IP.split(":",-1);
    if(IP6Arr.length == 8){
      return isIP6Arr(IP6Arr);
    }

    return "Neither";
  }

  public String isIP4Arr(String[] IP4Arr){
    for(String ip : IP4Arr){
      if(ip.length() > 3 || ip.length() <= 0){
        return "Neither";
      }
      for(int i = 0 ;i < ip.length();++i){
        if(!Character.isDigit(ip.charAt(i))){
          return "Neither";
        }
      }
      int num = Integer.parseInt(ip);
      if(num > 255 || String.valueOf(num).length() != ip.length()){
        return "Neither";
      }
    }
    return "IPv4";
  }

  public String isIP6Arr(String[] IP6Arr){
    for(String ip : IP6Arr){
      if(ip.length() > 4 || ip.length() <= 0){
        return "Neither";
      }
      for(int i = 0 ;i < ip.length();++i){
        char c = ip.charAt(i);
        if(!Character.isDigit(c) && !( 'a' <= c && c <= 'f') && !('A' <= c && c <= 'F')){
          return "Neither";
        }
      }
    }
    return "IPv6";
  }

}
