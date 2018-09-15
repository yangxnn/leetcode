package tools.heap;

public class Head {
    public void maxHeapify(int[] nums, int lenth, int i){
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int max = i;
        if (left < lenth && nums[max] < nums[left]){
            max = left;
        }
        if (right < lenth && nums[max] < nums[right]){
            max = right;
        }
        if (max != i){
            swap(nums, max, i);
            maxHeapify(nums, lenth, max);
        }
    }
    private void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
    public void buildMaxHeap(int[] nums){
        int le = nums.length;
        for (int i = (le - 1)/2; i>=0; i--){
            maxHeapify(nums, le, i);
        }
    }
    public void headSort(int[] nums){
        buildMaxHeap(nums);
        int length = nums.length
        for (int i = length -1; i > 0; i--){
            swap(nums, 0, i);
            length--;
            maxHeapify(nums, length, 0);
        }
    }
}
