class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // if(nums2.length==1 && nums1.length==1) return (nums1[0]+nums2[0])/2.0;
        if(nums2.length<nums1.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int low = 0;
        int high = nums1.length;
        int n1 = nums1.length;
        int n2 = nums2.length;
        while(low<=high){
            int cut1 = low + (high - low)/2;
            int cut2 = (n1+n2+1)/2-cut1;
            int l1 = (cut1 <= 0)?Integer.MIN_VALUE:nums1[cut1-1];
            int l2 = (cut2 <= 0)?Integer.MIN_VALUE:nums2[cut2-1];
            int r1 = (cut1 >=n1)?Integer.MAX_VALUE:nums1[cut1];
            int r2 = (cut2 >=n2)?Integer.MAX_VALUE:nums2[cut2];
            if(l1<=r2){
                if(r1>=l2){
                    if(((n1+n2)&1)==0){
                        return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                    }else{
                        return Math.max(l1,l2);
                    }
                }else{
                    low=cut1+1;
                }
            }else{
                high=cut1-1;
            }
        }
        return 0.0;
    }
}