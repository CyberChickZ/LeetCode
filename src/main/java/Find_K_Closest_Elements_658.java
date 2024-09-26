import java.util.ArrayList;
import java.util.List;

public class Find_K_Closest_Elements_658 {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3));
//        System.out.println(solution.findClosestElements(new int[]{0, 2, 2, 3, 4, 6, 7, 8, 9, 9}, 4, 5));
//        System.out.println(solution.findClosestElements(new int[]{1, 3}, 1, 2));
//        System.out.println(solution.findClosestElements(new int[]{0, 0, 0, 1, 3, 5, 6, 7, 8, 8}, 2, 2));
//        System.out.println(solution.findClosestElements(new int[]{1, 10, 15, 25, 35, 45, 50, 59}, 1, 30));

//        Path path = Paths.get("src/main/resources/Find_K_Closest_Elements_658_1.txt");
//        List<String> lines = Files.readAllLines(path);
//        System.out.println(solution.findClosestElements(lines.stream().mapToInt(Integer::parseInt).toArray(), 9444, 4921));

//        System.out.println(solution.findClosestElements(new int[]{1, 5, 10}, 1, 4));
        System.out.println(solution.findClosestElements_Optimize(new int[]{0, 0, 0, 1, 3, 5, 6, 7, 8, 8}, 2, 2));

    }
}

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int i = findIndex(arr, x);
        System.out.printf("findIndex i = %d\n", i);
        int left = i - 1;
        int right = i + 1;
        List<Integer> res = new ArrayList<>();

        res.add(arr[i]);
        k = k - 1;

        while (k > 0) {
            int leftDiff = left >= 0 ? Math.abs(arr[left] - x) : Integer.MAX_VALUE;
            int rightDiff = right < arr.length ? Math.abs(arr[right] - x) : Integer.MAX_VALUE;

            if (leftDiff <= rightDiff) {
                res.add(arr[left--]);
            } else {
                res.add(arr[right++]);
            }
            k--;
        }
        return res.stream().sorted().toList();
    }

    public int findIndex(int[] arr, int x) {
        int len = arr.length;
        int left = 0;
        int right = len - 1;

        if (arr[left] >= x) {
            return left;
        }

        if (arr[right] <= x) {
            return right;
        }

        while (right - left > 1) {
            int pivot = (left + right) / 2;
            if (arr[pivot] == x) {
                return pivot;
            } else if (arr[pivot] < x) {
                left = pivot;
            } else {
                right = pivot;
            }
        }
        return Math.abs(arr[left] - x) <= Math.abs(arr[right] - x) ? left : right;
    }

    public List<Integer> findClosestElements_Optimize(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        if (arr.length == 0 || k == 0) {
            return res;
        }
        int left = 0;
        int right = arr.length - k;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (x - arr[mid] <= arr[mid + k] - x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        for (int i = left; i < left + k; i++) {
            res.add(arr[i]);
        }

        return res;
    }
}
