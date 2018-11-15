class Solution {
    public int functSum(int[] arr) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += i * arr[i];
        }
        return sum;
    }
    public int maxRotateFunction(int[] A) {
        if(A.length <= 1)
            return 0;
        int n = A.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, functSum(A));
            int temp = A[n - 1];
            for(int j = n - 1; j > 0; j--) {
                A[j] = A[j - 1];
            }
            A[0] = temp;
        }
        return max;
    }
}
