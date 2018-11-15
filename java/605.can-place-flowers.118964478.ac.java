class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed.length == 1) {
            if(flowerbed[0] == 0)
                return true;
            else
                return (n == 0);
        }        
        
        int count = 0;
        int[] pos = new int[2];
        if(flowerbed[0] == 0) {
            pos[1] = 0;
            count++;
        }        
        int i = 1;
        
        while(i < flowerbed.length) {
            if(flowerbed[i] == 0)
                pos[0] = i;
            else if(pos[0] == pos[1]) {
                count--;
                pos[1] = i;
            } else{
                pos[1] = i;
            }
            if(Math.abs(pos[0] - pos[1]) > 1) {
                pos[1] = pos[0];
                count++;
            }
            i++;
        }
        return count >= n ;
    }
}
