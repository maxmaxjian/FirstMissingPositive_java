import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution1 implements Solution {
    @Override
    public int firstMissingPositive(int[] nums) {

        Predicate<Integer> nonNeg = (i) -> i > 0;
        Predicate<Integer> lessThan = (i) -> i < nums.length;
        Predicate<Integer> validIdx = nonNeg.and(lessThan);

        for (int i = 0; i < nums.length; i++) {
            System.out.print("Before: ");
            print(nums);
            while (nums[i] != i+1) {
                if (validIdx.test(nums[i]) && nums[i] != nums[nums[i]-1]) {
                    swap(nums, i, nums[i] - 1);
                } else {
                    break;
                }
            }
            System.out.print("After: ");
            print(nums);
        }

        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1) {
                break;
            } else {
                i++;
            }
        }

        return i+1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void print(int[] nums) {
        System.out.println(IntStream.of(nums).boxed().collect(Collectors.toList()));
    }
}
