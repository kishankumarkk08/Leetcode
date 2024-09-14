class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) > 64 && s.charAt(i) < 123 || s.charAt(i) > 47 && s.charAt(i) < 58) {
                if (s.charAt(i) > 90 && s.charAt(i) < 97) {
                    continue;
                } else if (s.charAt(i) > 64 && s.charAt(i) < 91) {
                    sb.append((char) (s.charAt(i) + 32));
                } else {
                    sb.append(s.charAt(i));
                }
            }
        }

        int i = 0;
        int j = sb.length() - 1;
        while (i < j) {
            if (sb.charAt(i) == sb.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}