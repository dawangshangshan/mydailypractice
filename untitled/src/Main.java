import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int[] nums={-8,3,-5,-3,-5,-2};
        largestSumAfterKNegations(nums,6);
    }
    public static int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int numsLength=nums.length;
        int ret=0;
        for(int i=0;i<numsLength;i++){
            if(nums[i]<0&&k>0){
                nums[i]=-nums[i];
                ret+=nums[i];
                k--;
            }else{
                k=k%2;
                if(k==1){
                    if(i-1>=0) {
                        if (nums[i] > nums[i - 1]) {
                            ret =ret+2* (-nums[i - 1]);
                        }
                    }
                    ret+=nums[i];
                    k--;
                }else{
                    ret+=nums[i];
                }

            }
        }
        return ret;
    }
    public static int jump(int[] nums) {
        int numsLength=nums.length;
        int cover=0;
        int tempMaxIndext=0;
        int count=1;
        for(int i=0;i<=cover;i++){

            if(nums[i]+i>nums[tempMaxIndext]+tempMaxIndext){
                tempMaxIndext=i;
            }
            if(i==cover){
                cover=nums[tempMaxIndext]+tempMaxIndext;
                tempMaxIndext=0;
                if(i!=0){
                    count++;
                }
            }
            if(cover>=numsLength-1&&cover!=0){
                return count;
            }

        }
        return 0;
    }
    public static boolean canJump(int[] nums) {
        int numsLength=nums.length;
        for(int i=0;i<numsLength-1;i++){
            int cover=nums[i]+i;
            if(nums[i]==0) {
                cover--;
            }
            if(cover>=numsLength-1){
                return true;
            }
        }
        return false;
    }
    public static int maxSubArray(int[] nums) {
        int numsLenth = nums.length ;
        if(numsLenth == 1)return nums[0] ;
        int maxsum=nums[0];
        int tempsum=0;
        for(int i=0;i<numsLenth;i++){
            tempsum=tempsum+nums[i];
            if(tempsum>maxsum){
                maxsum=tempsum;
            }
            if(tempsum<=0){
                tempsum=0;
            }
        }
        return maxsum;
    }
}