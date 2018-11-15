/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int i = 0;
        char[] myBuf = new char[4];        
        while(i < n) {            
            int k = read4(myBuf);
            if(k == 0)
                break;
            for(int j = 0; j < k && i < n; j++, i++)
                buf[i] = myBuf[j];
        }
        return i;
    }
}
