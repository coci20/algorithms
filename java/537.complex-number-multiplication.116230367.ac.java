class Solution {
    public String complexNumberMultiply(String a, String b) {
        String[] in1 = a.split("\\+");
        String[] in2 = b.split("\\+");
        
        int a1 = Integer.parseInt(in1[0]);
        int a2 = Integer.parseInt(in2[0]);
        
        int b1 = Integer.parseInt(in1[1].substring(0,in1[1].length()-1));
        int b2 = Integer.parseInt(in2[1].substring(0,in2[1].length()-1));
        
        int real = a1*a2 - b1*b2;
        int complex = a1*b2 + a2*b1;
        String res = String.valueOf(real) + "+" + String.valueOf(complex) + "i";
        return res;
    }
}
