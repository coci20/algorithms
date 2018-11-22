char findTheDifference(char* s, char* t) {
    char sum=0,sum1=0;
    for(int i=0;s[i]!='\0';i++)
        sum+=s[i];
    for(int i=0;t[i]!='\0';i++)
        sum1+=t[i];
    return sum1-sum;    
}
