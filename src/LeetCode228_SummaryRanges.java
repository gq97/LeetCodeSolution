import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode228_SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new LinkedList<>();
        if(nums.length == 0 || nums == null) return result;
        int pre = nums[0];
        int start = pre;
        String temp = "" + start;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] - pre != 1 || i == nums.length - 1) {
                if(nums[i] - pre == 1) {
                    pre = nums[i];
                }
                if(start != pre) {
                    temp = temp + "->" + pre;
                }
                result.add(new String(temp));
                if(pre != nums[i]) {
                    start = nums[i];
                    temp = "" + start;
                } else {
                    temp = "";
                }
            }
            pre = nums[i];
        }
        if(temp.length() != 0) {
            result.add(new String(temp));
        }
        return result;
    }

    // Solution from the Discussion
    public List<String> summaryRanges2(int[] nums) {
        List<String> list=new ArrayList();
        if(nums.length==1){
            list.add(nums[0]+"");
            return list;
        }
        for(int i=0;i<nums.length;i++){
            int a=nums[i];
            while(i+1<nums.length&&(nums[i+1]-nums[i])==1){
                i++;
            }
            if(a!=nums[i]){
                list.add(a+"->"+nums[i]);
            }else{
                list.add(a+"");
            }
        }
        return list;
    }
}
