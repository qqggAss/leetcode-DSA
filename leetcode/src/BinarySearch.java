/**
 * leetcode704 二分查找
 * 这里的注意点在于 length-1 不要忘记了
 * 然后就是
 * while的循环条件有两种
 * 1.while (left <= right)：
 * 表示搜索区间是 [left, right] 即包含左右边界
 * 适用于精确查找某个目标值（包括数组的边界情况）
 * 更新逻辑
 * left = mid + 1; 向右继续搜索
 * right = mid - 1; 向左继续搜索
 * left <= right 是因为 当区间只剩一个元素时（left == right）仍需要检查该元素 因此用 <=
 * 2.while (left < right)
 * 表示搜索区间是 [left, right)即包含左边界 但不包含右边界
 * 常用于寻找某种边界（如上界或下界）或者优化性能的特殊情况
 * 更新逻辑
 * left = mid + 1; 向右继续搜索
 * right = mid; 向左继续搜索，但保留 mid
 * 右开的好处是避免对最后一个元素的特殊处理 对于某些特定的查找问题（如寻找第一个大于等于某值的元素）这种定义更自然。
 * 注意区别 不要混用 比如用2的条件和1的更新 [5] target=5 会出错
 */
public class BinarySearch {
    public static int search(int[] arr, int tar) {
        int left = 0;
        int right = arr.length - 1; // 记着 -1
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] == tar) {
                return mid;
            } else if (arr[mid] < tar) {
                left = mid + 1; // left位置已经排除了 这样更新可以避免target不存在的时候能结束循环
            } else {
                right = mid - 1; // right位置已经排除了
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 2;
        System.out.println(search(nums, target));
    }
}
