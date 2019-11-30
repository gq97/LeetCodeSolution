
/**
 * Definition for singly-linked list.
 */
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}

public class LeetCode234_PalindromeLinkedList {
    private ListNode curNode;
    public boolean isPalindrome(ListNode head, int k) {
        boolean result = true;
        if(k > 0) {
            result = isPalindrome(head.next, k-1);
        }
        result = result && curNode != null && curNode.val == head.val;
        if(result && curNode != null) {
            curNode = curNode.next;
        }
        return result;
    }
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        int len = 0;
        ListNode p = head;
        while(p != null) {
            len++;
            p = p.next;
        }
        curNode = head;
        int mid = len / 2 - 1;
        for(int i = 0; i < (len+1)/2; i++) {
            curNode = curNode.next;
        }
        return isPalindrome(head, mid);
    }
    // another solution may consider reverse the ListNode in the half.
}