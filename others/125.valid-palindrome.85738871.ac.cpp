class Solution {
public:
    bool isPalindrome(string s) {
        bool result=true;
        if(s=="") return true;
        int i=0,j=s.size()-1;
        while(i<j){
            if(!isalnum(s[i])){
               i++;
               continue;
            }  
            if(!isalnum(s[j])){
                j--;
                continue;
            }  
            if(tolower(s[i])!=tolower(s[j])){
                result=false;
                break;
            }
            else{
                i++;
                j--;
            }
        }
        return result;
    }
};
