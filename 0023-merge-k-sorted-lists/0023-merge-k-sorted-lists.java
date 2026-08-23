/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // Handle edge cases for empty inputs
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        // Initialize a Min-Heap based on the node values
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        
        // Add the head node of each non-empty linked list into the heap
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.add(list);
            }
        }
        
        // Create a dummy head node to simplify list building
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        // Process nodes until the heap is completely empty
        while (!minHeap.isEmpty()) {
            // Extract the smallest node from the heap
            ListNode smallestNode = minHeap.poll();
            current.next = smallestNode;
            current = current.next;
            
            // If the extracted node has a next node, push it into the heap
            if (smallestNode.next != null) {
                minHeap.add(smallestNode.next);
            }
        }
        
        // Return the merged head, which sits right after the dummy node
        return dummy.next;
    }
}
