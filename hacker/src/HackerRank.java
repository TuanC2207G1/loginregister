import java.util.ArrayList;
import java.util.List;

public class HackerRank {
    public static int solve(List<List<Integer>> arr, int m, int n) {
        int number = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j < m - 1) {
                    if (arr.get(j).get(i) == 0 && arr.get(j + 1).get(i) == 1) {
                        number++;
                    }
                } else if (j == m - 1) {
                    if (arr.get(m - 1).get(i) == 0) {
                        number++;
                    }
                }
            }
        }
        return number;
    }
}
