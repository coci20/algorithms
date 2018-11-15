class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int count = 0, i = 0, j = 0, k = 0;
        while(true) {
            String str = sentence[k];
            if(str.length() > cols)
                break;
            if(j + str.length() > cols) {
                j = 0;
                if(i < rows) {
                    i++;
                    if(i == rows)   break;
                    continue; 
                }                
            }
            if(j + str.length() == 0) {
                j = 0;
                k++;
                i++;
                if(k == sentence.length) {
                    count++;
                    k = 0;
                }
                if(i == rows)   break;
                continue;
            }            
            j += str.length() + 1;
            k++;
            if(k == sentence.length) {
                count++;
                k = 0;
            }
        }
        return count;
    }
}
