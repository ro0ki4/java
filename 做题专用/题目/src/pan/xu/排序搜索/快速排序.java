package pan.xu.排序搜索;

public class 快速排序 {
    public static void main(String[] args) {

        int[] a = {3,3,5,2,6,7,3,9,1,5,3,4};
//        sort(a,0,a.length-1);
        //kuaipai(a,0,a.length-1);
        solu2(a,0,a.length-1);
//        solu(a,0,a.length-1);

        for(int aa :a){
            System.out.print(aa);
        }


    }
    
    static void solu44(int[] nums, int l, int r){
        if(l >= r)
            return;
        int left = l;
        int right = r;
        int flag = nums[l];
        while(left < right){
            while(right > left && nums[right] >= flag){
                right--;
            }
            nums[left] = nums[right];
            while(right > left && nums[left] <= flag){
                left++;
            }
            nums[right] = nums[left];
        }
        nums[right] = flag;
        solu44(nums,l,left-1);
        solu44(nums,right+1,r);
    }

    static void solu(int[] nums,int l,int r){
        if(l>=r)
            return;
        int index= nums[l];
        int low = l;
        int high = r;
        while(low < high){
            while(nums[high] >= index && high >low)
                high--;
            while(nums[low] <= index && high > low)
                low++;
            if(high > low) {
                nums[high] = nums[low] + nums[high];
                nums[low] = nums[high] - nums[low];
                nums[high] = nums[high] - nums[low];
            }
        }
        nums[l] = nums[high];
        nums[high] = index;

        solu(nums,l,high);
        solu(nums,high+1,r);

    }
    
    static void sort(int[] nums, int left, int right){
        if(left >= right){
            return;
        }
        int flag = nums[left];
        int l = left;
        int r = right;
        while(l < r){
            while(l < r && nums[r] >= flag){
                r--;
            }
            nums[l] = nums[r];
            while(l < r && nums[l] <= flag){
                l++;
            }
            nums[r] = nums[l];
        }
        nums[l] = flag;
        sort(nums,left,l-1);
        sort(nums,l+1,right);
    }

    static void solu2(int[] nums, int l, int r){
        if(l >= r)
            return;
        int left = l;
        int right = r;
        int flag = nums[left];
        while(left < right){
            while(left < right && nums[right] >= flag){
                right --;
            }
            nums[left] = nums[right];
            
            while(left < right && nums[left] <= flag){
                left ++;
            }
            nums[right] = nums[left];
        }
        nums[right] = flag;
        
        solu2(nums,l,left-1);
        solu2(nums,right+1,r);
    }


    static void kuaipai(int[] nums, int l , int r){
        if(l >= r){
            return;
        }
        int left = l;
        int right = r;
        int flag = nums[l];
        while(r > l) {
            while (nums[r] >= flag && r > l) {
                r--;
            }
            while (nums[l] <= flag && r > l) {
                l++;
            }
            if(r > l) {
                int tem = nums[r];
                nums[r] = nums[l];
                nums[l] = tem;
            }
        }
        nums[left] = nums[l];
        nums[l] = flag;
        kuaipai(nums,left,l);
        kuaipai(nums,l+1,right);
    }
}
