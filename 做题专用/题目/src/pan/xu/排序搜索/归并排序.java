package pan.xu.排序搜索;

public class 归并排序 {
    public static void main(String[] args) {
        int[] a = {3,2,5,2,6,7,3,9,1,5,4};
        hh(a,0,a.length-1);
        for(int i : a){
            System.out.print(i+"  ");
        }

    }

    static void hh(int[] nums,int i,int j){
        if(i>=j)
            return;
        hh(nums,i,(i+j)/2);
        hh(nums,(i+j)/2+1,j);
        //he(nums,i,(i+j)/2,(i+j)/2+1,j);
        merge(nums,i,j);
    }

    static void merge(int[] nums, int i, int j){
        if(i >= j)
            return;
        int mid = (i+j)>>1;
        int[] left = new int[mid-i+1];
        int[] right = new int[j-mid];
        System.arraycopy(nums,i,left,0,mid-i+1);
        System.arraycopy(nums,mid+1,right,0,j-mid);

//        for(int k : left){
//            System.out.print(k + "  ");
//        }
//        System.out.println("--------------------");
//        for(int k : right){
//            System.out.print(k + "  ");
//        }

        int lindex = 0;
        int rindex =0;
        int index = i;

        while(lindex < left.length && rindex < right.length){

            if(left[lindex] < right[rindex]){
                nums[index] = left[lindex];
                lindex++;
            }else{
                nums[index] = right[rindex];
                rindex++;
            }
            index++;
        }

        if(lindex >= left.length){
            while(rindex < right.length){
                nums[index] = right[rindex];
                index++;
                rindex++;
            }
        }else{
            while(lindex < left.length){
                nums[index] = left[lindex];
                index++;
                lindex++;
            }
        }

    }


    static void he(int[] nums,int i, int j, int ii, int jj){
        int[] arr = new int[jj-i+1];
        int s = i;
        int k = 0;
        while(i<=j && ii <= jj){
            arr[k] = nums[i]>nums[ii]?nums[ii++]:nums[i++];
            k++; 
        }
        if(i>j){
            while(ii<=jj){
                arr[k++] = nums[ii++];
            }
            for(int a = 0; a < k; a++){
                nums[a+s] = arr[a];
            }
        }else{
            while(i<=j){
                arr[k++] = nums[i++];
            }
            for(int a = 0; a < k; a++){
                nums[a+s] = arr[a];
            }
        }
        for(int bb:arr){
            System.out.println(bb);
        }
        System.out.println("+++++++++++++++++++++++++++");
    }

}
