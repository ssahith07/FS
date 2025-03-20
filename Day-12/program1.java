import java.util.*;
public class program1{
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        boolean flag = true;
        while (flag){
            flag = false;
            int[] res = nums.clone();
            for (int i = 1; i < n-1; i++) {
                if(nums[i]>nums[i-1] && nums[i]>nums[i+1]){
                    res[i]=nums[i]-1;
                    flag = true;
                }
                else if(nums[i]<nums[i-1] && nums[i]<nums[i+1]){
                    res[i]=nums[i]+1;
                    flag = true;
                }
            }
            nums = res.clone();
            if(!flag) break;
        }
        System.out.println(Arrays.toString(nums));
    }
}
