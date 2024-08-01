class Solution {
  public int countSeniors(String[] details) {
    var res = 0;

    for (var d : details)
      if (Integer.parseInt(d.substring(11, 13)) > 60)
        res++;

    return res;
  }
}