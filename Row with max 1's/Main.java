
class Main {

    public static int count1s(int[] subArr) {
        int l = 0;
        int r = subArr.length - 1;

        while (l <= r) {
            int mid = (r + l) / 2;
            if ((mid == 0 || subArr[mid - 1] == 0) && subArr[mid] == 1) {
                return subArr.length - mid;
            } else if (subArr[mid] == 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static int maxOneRow(int nums[][]) {
        int ind = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = count1s(nums[i]);
            if (count != -1 && count > max) {
                max = count;
                ind = i;
            }
        }
        System.out.println("max: " + max);
        return ind;

    }

    public static void main(String[] args) {

        int[][] nums = new int[][] {
                { 0, 1, 1, 1 },
                { 0, 0, 1, 1 },
                { 1, 1, 1, 1 },
                { 0, 0, 0, 0 }
        };

        System.out.println(maxOneRow(nums));

    }
}