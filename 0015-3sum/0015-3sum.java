class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        // List<List<Integer>> res = new ArrayList<List<Integer>>();
        // if(nums.length<3) return res;
        // int n = nums.length;
        // for(int i = 0; i<n-2; i++){
        //     for(int j = i+1;j<n-1; j++){
        //         for(int k = j+1; k < n; k++){
        //             int sum = nums[i] + nums[j] + nums[k];
                    
        //             if(sum==0){
        //                 List<Integer> triplet = new ArrayList<Integer>(Arrays.asList(nums[i],nums[j],nums[k]));
        //                 Collections.sort(triplet);
        //                 res.add(triplet);
        //             }
        //         }
        //     }
        // }
        // res = new ArrayList<List<Integer>>(new HashSet(res));
        // return res;
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for(int i = 0; i<nums.length-1;i++){
            int start = i+1;
            int end = nums.length-1;
            while(start<end){
                int sum = nums[start] + nums[end] + nums[i];
                if(sum==0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[start]);
                    temp.add(nums[end]);
                    temp.add(nums[i]);
                    Collections.sort(temp);
                    set.add(temp);
                    start++;
                    end--;
                }else if(sum<0){
                    start++;
                }else{
                    end--;
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>(set);
        return res;
    }
}