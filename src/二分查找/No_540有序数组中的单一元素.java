package 二分查找;

/**
 方法三：仅对偶数索引进行二分搜索

 事实证明我们只需要对偶数索引进行二分搜索。这种方法与方法二都是不错的方法，但是该方法比方法二更加优雅。
 在该算法中，我们对所有偶数索引进行搜索，直到遇到第一个其后元素不相同的索引。
 我们可以使用二分搜索替代线性搜索。
 在单个元素的后面，则成对的元素变为奇数索引后跟他们的同一元素。说明我们在检索单个元素后面的偶数索引时，其后都没有它的同一元素。因此，我们可以通过偶数索引确定单个元素在左侧还是右侧。

 算法：
 奇数长度的数组首尾元素索引都为偶数，因此我们可以将 lo 和 hi 设置为数组首尾。
 我们需要确保 mid 是偶数，如果为奇数，则将其减 1。
 然后，我们检查 mid 的元素是否与其后面的索引相同。
 如果相同，则我们知道 mid 不是单个元素。且单个元素在 mid 之后。则我们将 lo 设置为 mid + 2。
 如果不是，则我们知道单个元素位于 mid，或者在 mid 之前。我们将 hi 设置为 mid。
 一旦 lo == hi，则当前搜索空间为 1 个元素，那么该元素为单个元素，我们将返回它。

 作者：LeetCode
 链接：https://leetcode-cn.com/problems/single-element-in-a-sorted-array/solution/you-xu-shu-zu-zhong-de-dan-yi-yuan-su-by-leetcode/
 来源：力扣（LeetCode）
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class No_540有序数组中的单一元素 {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int mid = l + (h - l) /2;
            if (mid % 2 != 0) {
                mid--;
            }
            if (nums[mid] == nums[mid + 1]) {
                l =  mid + 2;
            } else {
                h = mid;
            }
        }
        return nums[l];
    }
}
