
import java.util.*;

class Solution {
    public boolean backspaceCompare(String s, String t) {

        //Đặt 2 con trỏ ở cuối s và t
        int i = s.length()-1;
        int j = t.length()-1;

        // Đặt biến đếm Số lượng Skip S và T
        int skipS = 0;
        int skipT = 0;

        while(j>=0||i>=0){
            // Chạy cuỗi S
            while (i >= 0) {
                // Nếu ký tự là # thì tăng biến skip và lùi 1 chữ
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                }
                //Nếu skip > 0 thì giảm skip và bỏ qua 1 chữ
                else if (skipS > 0) {
                    skipS--;
                    i--;
                }
                // Nếu k có ký tự thoát thì thoát khỏi vòng lặp
                else {
                    break;
                }
            }
            // Làm tương tự vs chuỗi T
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            //Sau khi  loại bỏ ký tự thì bắt đầu so sánh ký tự
            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j)) return false;
            } else {
                // If one string is empty and the other is not
                if (i >= 0 || j >= 0) return false;
            }
            // Lùi cà chưỡi s vs t 1 ký tự

            i--;
            j--;
        }
        return true;


    }
}
