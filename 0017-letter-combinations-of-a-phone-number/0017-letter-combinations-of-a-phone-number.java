class Solution {
    String[] str = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        // System.out.println(digits);
        if(digits.equals("")) return res;
        helper(digits,"");
        return res;
    }

    public void helper(String digits,String ans){
        if(digits.length()==0){
            res.add(ans);
            return;
        }
        int curDigit = Character.getNumericValue(digits.charAt(0));
        String ab = str[curDigit];
        for(int i = 0; i < ab.length();i++){
            helper(digits.substring(1),ans+ab.charAt(i));
        }

    }
}