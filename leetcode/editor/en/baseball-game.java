
import java.util.*;

class Solution {
    public int calPoints(String[] operations) {

        Deque<Integer> record = new ArrayDeque<>();

        for (String op : operations) {

            if (op.equals("C")) {
                record.pop();
            }
            else if (op.equals("D")) {
                record.push(2 * record.peek());
            }
            else if (op.equals("+")) {
                int top = record.pop();
                int newTop = top + record.peek();
                record.push(top);
                record.push(newTop);
            }
            else{
                    record.push(Integer.valueOf(op));
                }
            }

            int totalScore = 0;
            for (int score : record) {
                totalScore += score;
            }
            return totalScore;
        }

}

