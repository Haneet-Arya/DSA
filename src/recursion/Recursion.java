package recursion;

import java.util.TreeSet;

public class Recursion {
    static class Solution {
        public String countAndSay(int n) {
            if(n==1) return "1";
            String num = this.countAndSay(n-1);
            String numb = "";
            int count = 1;
            char s = num.charAt(0);
            int cur = 0;
            for(int i = 0;i<num.length();i++){
                if(s!=num.charAt(i) || i==num.length()-1){
                    if(cur==0){
                        numb =numb+ count + num;
                    }
                    else{
                        numb=numb + count + num.substring(i);
                    }
                    count=1;
                    cur = i + 1;
                    s = num.charAt(i);

                }
                count++;

            }
            return numb;

        }
    }
    public static void main(String[] args) {
//        System.out.println(fastPower(3,13));

//        System.out.println(matrixTravel(4,3));
//        System .out.println(josephusProblem(5,3));
//        powerSet("abc",0,"");
//        powerSet("racecar",0,"");
//        permute("abc",0,"abc".length());
        Solution sol = new Solution();
        System.out.println(sol.countAndSay(4));
    }

    static int fastPower(int a , int b){
        int res = 1;
        while(b > 0){
            if((b&1)!=0){
                res=res*a;
            }

            a = a * a;
            b=b>>1;
        }
        return res;
    }

    // matrix travel only right and bottom
    static int matrixTravel(int n, int m){
        if(n==1 || m==1) return 1;

        return matrixTravel(n - 1, m) + matrixTravel(n,m-1);
    }

    static int josephusProblem(int n, int k){
        if(n==1) return 0;
        return (josephusProblem(n-1,k)+k)%n;
    }

    static Boolean isPalindrome(String str,int l, int r){
        if(l>=r) return true;

        if(str.charAt(l)!=str.charAt(r)) return false;

        return isPalindrome(str, l + 1, r - 1);
    }

//    time complexity O(2^n)
    static void powerSet(String str, int i, String cur){
        if(i==str.length()){
            System.out.println(cur);

            return;
        }
        powerSet(str,i+1,cur+str.charAt(i));
        powerSet(str,i+1,cur);
    }


    // Permutation of string: Time Complexity O(n*n!)
    static void permute(String str,int l, int r) {
        if(l==r){
            System.out.println(str);
            return;
        }
        for(int i = l;i<r;i++){
            str = swap(str, l, i);
            permute(str, l+1, r);
            str = swap(str, l, i);
        }
    }

    static String swap(String str, int l, int r) {
        char f = str.charAt(l);
        char s = str.charAt(r);
        str = str.substring(0, l) + s + str.substring(l + 1);
        str = str.substring(0, r) + f + str.substring(r + 1);
        return str;
    }


}
