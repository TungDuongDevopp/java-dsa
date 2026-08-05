
import java.util.*;

class Solution {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*' && sb.length() > 0) {
                // Xóa ký tự cuối cùng (tương đương pop trong stack)
                sb.deleteCharAt(sb.length() - 1);
            } else if (c != '*') {
                // Thêm ký tự vào cuối (tương đương push vào stack)
                sb.append(c);
            }
        }

        return sb.toString();
    }
}

