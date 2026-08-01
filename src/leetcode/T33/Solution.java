package leetcode.T33;

public class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        while(l<r){
            int mid = (l+r)/2;
            int ans = -1;
            if(target == nums[mid]){
                return mid;
            }
            if(mid>l&&nums[l]<=nums[mid-1]){
                if(target<nums[l]||target>nums[mid-1]){
                    l = mid+1;
                    continue;
                }
                ans = binarySearch(nums,l,mid,target);
                if(ans != -1){
                    return ans;
                }
                l = mid+1;
            }else if(mid<r-1){
                if(target<nums[mid+1]||target>nums[r-1]){
                    r = mid;
                    continue;
                }
                ans = binarySearch(nums,mid+1,r,target);
                if(ans != -1){
                    return ans;
                }
                r = mid;
            }else{
                return -1;
            }
        }
        return -1;
    }

    public int binarySearch(int[] nums,int start,int end,int target){
        int ans = -1;
        while(end>start){
            int mid = (end+start)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid]<target){
                start = mid+1;
            }else{
                end = mid;
            }
        }
        return -1;
    }
}
