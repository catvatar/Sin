import java.util.Arrays;

public class Reorder {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int[] order = {0,4,1,3,2};
        reorder(order, arr);
    }

    private static void reorder(int[] order, int[] arr) {
        int n = 0;
        for (int i = 0; i<arr.length; i++) {
            int temp = arr[order[i]];
            arr[order[i]] = arr[n];
            arr[n] = temp;
            if (order[i] == n) {
                n++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
