// https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list/submissions/1384886570/?envType=daily-question&envId=2024-09-10
public class InsertGreatestCommonDivisors {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curr = head;
        while (curr.next != null) {
            int gcd = gcd(curr.val, curr.next.val);
            ListNode newNode = new ListNode(gcd);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }
        return head;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a :  gcd(b, a % b);
    }
}
