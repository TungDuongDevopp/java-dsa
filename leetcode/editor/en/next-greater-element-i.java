
import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Stack dùng để duy trì dãy giảm dần từ đáy lên đỉnh
        Stack<Integer> stack = new Stack<>();
        // HashMap lưu cặp [phần tử : phần tử lớn hơn tiếp theo của nó]
        HashMap<Integer, Integer> map = new HashMap<>();

        // Bước 1: Duyệt qua nums2 để tìm Next Greater Element cho từng số
        for (int num : nums2) {
            // Kiểm tra: Nếu số hiện tại lớn hơn số ở đỉnh stack
            while (!stack.isEmpty() && stack.peek() < num) {
                // Số hiện tại chính là phần tử lớn hơn tiếp theo của số ở đỉnh stack
                map.put(stack.pop(), num);
            }
            // Đẩy số hiện tại vào stack để chờ tìm số lớn hơn nó
            stack.push(num);
        }

        // Bước 2: Tạo mảng kết quả cho nums1 bằng cách tra cứu trong HashMap
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            // Nếu tìm thấy trong map thì lấy giá trị đó, ngược lại mặc định là -1
            result[i] = map.getOrDefault(nums1[i], -1);
        }

        return result;


    }
}

