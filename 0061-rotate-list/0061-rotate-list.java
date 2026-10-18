class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // Base case: empty list, single node, or no rotation needed
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        
        // 1. Compute the length of the list and find the tail node
        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        
        // 2. Adjust k in case k is larger than the length of the list
        k = k % length;
        if (k == 0) {
            return head; // No rotation needed
        }
        
        // 3. Connect the tail to the head to make it circular
        tail.next = head;
        
        // 4. Find the new tail, which is at position (length - k)
        int stepsToNewTail = length - k;
        ListNode newTail = head;
        for (int i = 1; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }
        
        // 5. The new head is the node right after the new tail
        ListNode newHead = newTail.next;
        
        // 6. Break the circular link
        newTail.next = null;
        
        return newHead;
    }
}
