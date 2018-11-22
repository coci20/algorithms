/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    
    public void firstBadVersionHelper(int low, int high, int[] min) {
        if(low > high) return;
        int mid = low + (high - low)/2;
        if(isBadVersion(mid)) {
            if (min[0] > mid)
                min[0] = mid;
            firstBadVersionHelper(low,mid-1,min);
        }
        else            
            firstBadVersionHelper(mid+1,high,min);
    }
    
    public int firstBadVersion(int n) {
        int[] min = new int[1];
        min[0] = n;
        firstBadVersionHelper(1, n, min);
        return min[0];
    }
}
