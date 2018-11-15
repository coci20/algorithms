class Solution {
    public String simplifyPath(String path) {
        if(path.length() <= 1)
            return path;
        if(path.charAt(path.length() - 1) == '/')
           path = path.substring(0, path.length() - 1);
        path = path.replaceAll("\\","/");
        path = path.replaceAll("\\..","");
        int index = -1;
        for(int i = path.length() - 1; i >= 0; i--) {
            if(path.charAt(i) == '/')
                index = i;
        }
        return path.substring(index);           
    }
}
