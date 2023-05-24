class Solution {
    int max = 0;
    int min = 0;
    public String longestPalindrome(String s) {
        // Brute force
        // if(s.length()==0) return "";
        // if(s.length()==1) return s;
        // int length = 0;
        // String res = "";
        // for(int i = 0;i<s.length()-1;i++){
        //     for(int j = i+1;j<s.length();j++){
        //         StringBuilder temp1 = new StringBuilder(s.substring(i,j+1));
        //         StringBuilder temp2 = new StringBuilder(s.substring(i,j+1));
        //         temp2.reverse();
        //         if(temp1.toString().equals(temp2.toString()) && temp1.length()>length){
        //             res = temp1.toString();
        //             length = temp1.length();
        //         }
        //     }
        // }
        // return (res.equals(""))?s.substring(0,1):res;


        // Code to solve time limit exceeded
        if(s.length()<2) return s;
        for(int i = 0; i < s.length(); i++){
            expand(i,i,s);
            expand(i,i+1,s);
        }
        return s.substring(min,min + max);
        

    }

    public void expand(int i, int j, String s){
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        if(j-i-1 > max){
            max = j-i-1;
            min = i+1;
        }
    }
}