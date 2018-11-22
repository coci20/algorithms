class Solution {
public:
    vector<string> fizzBuzz(int n) {
        vector<string> v;
        for(int i=1;i<=n;i++){
            if(i%15==0){
                v.push_back("FizzBuzz");
            }
            else if(i%5==0){
                v.push_back("Buzz");
            }
            else if(i%3==0){
                v.push_back("Fizz");
            }
            else{
                stringstream ss;
                ss<<i;
                v.push_back(ss.str());
            }
        }
        return v;
    }
};
