public class Main {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(20);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(30);
        l1.next.next.next.next.next = new ListNode(40);

        System.out.println( reverseKGroup(l1,2) );

    }

    public static ListNode reverseKGroup(ListNode head, int k) {

        //Getting length of LL
        int n = 0;
        for (ListNode i = head; i != null;    n++, i = i.next);

        ListNode dmy = new ListNode(0);
        dmy.next = head;
        for(ListNode prev = dmy, tail = head;      n >= k;     n -= k) {
            for (int i = 1; i < k; i++) {

                //store tail.next.next -> 20
                ListNode next = tail.next.next;
                //replace 20 with 1, now 3 points to 1
                tail.next.next = prev.next;

                // all we have to do now is to pull 3->1 back to prev.next [3 is tail.next]
                prev.next = tail.next;

                //now that we have prev -> 3 -> 1, make tail.next [1.next] point to next[20] that we stored earlier
                tail.next = next;
            }

            //after done; push prev and tail one node ahead, prev always points to previous tail
            prev = tail;
            tail = tail.next;
        }
        return dmy.next;
    }

}
