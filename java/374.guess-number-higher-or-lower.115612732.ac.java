/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    
    public int binSearch(int low, int high) {
        if (low > high) return -1;
        
        if (guess(low) == 0) return low;
        if (guess(high) == 0) return high;
        int mid = low + (high - low)/2;
        int k = guess(mid);            
        if (k == 0) return mid;
        else if (k == 1)
            return binSearch(mid+1, high-1);
        else
            return binSearch(low+1, mid-1);
    }
    
    public int guessNumber(int n) {
        return binSearch(1, n);
    }
}
