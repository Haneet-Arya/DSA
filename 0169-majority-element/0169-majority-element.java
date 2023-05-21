class Solution {
    public int majorityElement(int[] nums) {
       Map<Integer,Integer> map = new HashMap<>();
       for(int i = 0; i < nums.length; i++) {
           if(map.containsKey(nums[i])){
               map.put(nums[i],map.get(nums[i])+1);
           }else{
               map.put(nums[i],1);
           }
       }
       int majority = Integer.MIN_VALUE;
       int majorityValue = nums[0];
       for(Map.Entry<Integer,Integer> entry: map.entrySet()){
           if(entry.getValue() > majority){
               majority = entry.getValue();
               majorityValue = entry.getKey();
           }
       }
       return majorityValue;
    }
}