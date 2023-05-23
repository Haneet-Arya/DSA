class Solution {
    public int reversePairs(int[] nums) {
        // int count = 0;
        // for(int i = 0; i< nums.length-1;i++){
        //     for(int j = i+1; j<nums.length;j++){
        //         long temp = 2*(long)nums[j];
        //         if((long)nums[i]>temp && temp <= (long)Integer.MAX_VALUE){
        //             count++;
        //         }
        //     }
        // }
        // return count;
        int val = reversePair(nums,0,nums.length-1);
        return val;
    }
    public int reversePair(int[] arr, int start, int end){
        if(start>=end) return 0;
        int count = 0;
        int mid = start + (end-start)/2;
        count += reversePair(arr,start,mid);
        count += reversePair(arr,mid+1, end);
        int[] temp = new int[end-start+1];
        int i = start;
        int j = mid+1;
        while(i<=mid && j <=end){
            long tempNumber = 2*(long)arr[j];
                if((long)arr[i]>tempNumber && tempNumber <= (long)Integer.MAX_VALUE){
                    count+= mid+1-i;
                    j++;
                }else{
                    i++;
                }
        }
        i = start;
        j=mid+1;
        for(int k = 0; k < temp.length;k++){
            if(i<=mid && j <= end){
                if(arr[i]<=arr[j]){
                    temp[k] = arr[i];
                    i++;
                }else{
                    temp[k]=arr[j];
                    j++;
                }
            }else if(i<=mid){
                temp[k] = arr[i];
                i++;
            }else if(j<=end){
                temp[k]=arr[j];
                j++;
            }
        }
        for(int k = start; k <= end;k++){
            arr[k] = temp[k-start];
        }
        return count;
    }
}