package 链表;



/**
 *  快慢指针，翻转前半段
 *  参考题解：
 *  https://leetcode-cn.com/problems/palindrome-linked-list/solution/wo-de-kuai-man-zhi-zhen-du-cong-tou-kai-shi-gan-ju/
 */
public class No_234回文链表 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        ListNode pre = head, dummyHead = null;
        while (fast != null && fast.next != null) {
            // 快慢指针，遍历
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            // 翻转前半段
            pre.next = dummyHead;
            dummyHead = pre;
        }

        // 若链表长度为奇数，跳过中间的单个数字
        if (fast != null) {
            slow = slow.next;
        }

        // 验证翻转后的前半段和后半段是否相等
        while (pre != null && slow != null) {
            if (pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }

        return true;
    }
}

// * 解法：(三步走)
//         *      1. 找到分割点,并分割成两个链表
//         *      2. 后半链表进行倒置(尾插法)
//         *      3. 对两段链表进行比较
//    public boolean isPalindrome(ListNode head) {
//        if (head == null || head.next == null) {
//            return true;
//        }
//        ListNode slow = head, fast = head.next;
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        slow = slow.next;
//        cut(head, slow);
//        return isEqual(head, reverse(slow));
//    }
//
//    private boolean isEqual(ListNode h1, ListNode h2) {
//        while (h1 != null && h2 != null) {
//            if (h1.val != h2.val) {
//                return false;
//            }
//            h1 = h1.next;
//            h2 = h2.next;
//        }
//        return true;
//    }
//
//    private ListNode reverse(ListNode head) {
//        ListNode dummyHead = new ListNode(-1);
//        // 头插法
//        while(head != null) {
//            ListNode next = head.next;
//            head.next = dummyHead.next;
//            dummyHead.next = head;
//            head = next;
//        }
//        return dummyHead.next;
//    }
//
//    private void cut(ListNode head, ListNode cutNode) {
//        while(head.next != cutNode) {
//            head = head.next;
//        }
//        head.next = null;
//    }
