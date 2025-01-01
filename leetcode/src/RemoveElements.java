/**
 * leetcode27 remove element
 */
public class RemoveElements {
    public static int removeElement1(int[] nums, int val) {
        // 左右向中间走 把需要移除的往最右边放 交换位置
        int left = 0;
        int right = nums.length - 1;

        /*
         * 这里循环终止条件要用<=而不是!=
         * left != right 意味着两个指针重合的时候 循环会停止
         * 这种情况下指针重合的位置可能还没有被检查 尤其是最后一个元素
         * 例如 [3,3] 3 替换之后的left还没检查就退出了
         *
         * 根据逻辑选择精确的终止条件
         * == 当循环要在某个明确状态结束时（如指针重合）。
         * <= 或 >= 当需要确保包括边界条件在内的所有状态被检查。
         * != 只需要判断“未达到目标状态”时。
         * */
        while (left <= right) {
            if (nums[left] == val) {
                // 如果当前值是需要移除的值 把最右边的值放到这里
                nums[left] = nums[right];
                // 判断放到这里的值是否也需要移除
                // 这里好的处理方法是 缩短数组范围(最右边的位置已经用过了)
                // 不移动left 对交换后的值进行再次检查
                right--;
            } else {
                left++;
            }
        }
        return right + 1;
    }

    public static int removeElement2(int[] nums, int val) {
        /*
         * 双指针 快慢指针
         * fast用于遍历整个数组 slow用于指向下一个非目标值应存储的位置
         * 和左右指针不同的是 这里不是移除或者移动到后面
         *
         * 把数组中所有 不等于目标值的元素 按顺序保留下来 放在数组的前部 并记录新数组的长度（慢指针的位置）
         * 用快指针遍历数组 找到所有非目标值
         * 用慢指针将这些非目标值写入数组的前部
         * */
        int fast = 0;
        for (int slow = 0; slow < nums.length; slow++) {
            if (nums[slow] != val) {
                nums[fast] = nums[slow];
                fast++;
            }
        }
        return fast;
    }

    public static void main(String[] args) {
        int[] num1 = {3, 2, 2, 3};
        removeElement1(num1, 3);
    }
}
