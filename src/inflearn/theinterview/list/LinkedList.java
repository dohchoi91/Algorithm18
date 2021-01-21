package inflearn.theinterview.list;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 1. 단일 연결 리스트를 뒤집는 함수를 구현
 * 2. 끝에서 n번째 노드 찾기
 * 3. 정렬된 연결 리스트에서 중복 노드 제거
 */
public class LinkedList {

    private class LinkedNode {
        int number;
        LinkedNode next;

        public LinkedNode(int number) {
            this.number = number;
        }
    }

    private LinkedNode head;
    private LinkedNode tail;

    private void add(LinkedNode node) {
        if (head == null) {
            head = node;
            tail = node;
        } else if (tail != null) {
            tail.next = node;
            tail = tail.next;
        }
    }

    private String printStr() {
        StringBuilder stb = new StringBuilder();
        LinkedNode nodeToPrint = this.head;
        while(nodeToPrint != null) {
            stb.append(nodeToPrint.number).append(" ");
            nodeToPrint = nodeToPrint.next;
        }
        return stb.toString().trim();
    }

    private String reversePrintStr1() {
        return recursionString(this.head).trim();
    }
    private String reversePrintStr2() {
        return tailRecursionString(this.head, "").trim();
    }

    // 일반 재귀
    private String recursionString(LinkedNode node) {
        if (node.next == null) {
            return String.valueOf(node.number);
        }
        return recursionString(node.next) + " " + node.number;
    }

    // 꼬리 재귀
    private String tailRecursionString(LinkedNode node, String result) {
        if (node.next == null) {
            return node.number + " " + result;
        }
        return tailRecursionString(node.next, node.number + " " + result);
    }

    /**
     *  단일 연결 리스트를 뒤집는 함수를 구현하라.
     *  예) 1 -> 2 -> 3   =>   3 -> 2 -> 1
     */
    // 순환 방식
    private void reverse1() {
        LinkedNode current = this.head;
        LinkedNode prev = null;
        LinkedNode next = null;

        // 1 -> 2 -> 3
        // first. null <- 1 (X) 2(current) -> 3
        // second. null <- 1 <- 2 (X) 3(current)
        // third. null <- 1 <- 2 <- 3 (X) null(current)
        while(current != null) {
            next = current.next; // 현재 next
            current.next = prev;
            prev = current;
            current = next;
        }

        this.tail = this.head;
        this.head = prev;
    }

    // 재귀 함수
    private void reverse2() {
        this.tail = this.head;
        this.head = reverseRecursive(this.head);
    }
    private LinkedNode reverseRecursive(LinkedNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        LinkedNode newHead = reverseRecursive(node.next);
        node.next.next = node;
        node.next = null; // 무한루프 귾어주기

        return newHead;
    }


    /**
     *  단일 연결 리스트의 끝에서 n번째에 위치한 노드를 찾는 함수를 구현하라.
     *  예) findFromLast(1 -> 4 -> 2 -> 3, 2), 끝에서 2번째에 위치한 2를 리턴한다.
     */
    // Map을 이용하여 구하기
    // 시간 복잡도 : O(n)
    // 공간 복잡도 : O(n)
    private LinkedNode findFromLastUsingMap(int n) {
        LinkedNode node = this.head;
        Map<Integer, LinkedNode> map = new HashMap<>();

        int index = 1;
        while(node != null) {
            map.put(index++, node);
            node = node.next;
        }
        return map.get(index - n);
    }

    // 좌우 포인터 노드를 이용하여 찾기
    // 시간 복잡도 : O(n)
    // 공간 복잡도 : O(1)
    private LinkedNode findFromLast(int n) {
        LinkedNode left = this.head, right = this.head;

        int gap = 0;

        while(right.next != null) {
            if (gap == n - 1) {
                left = left.next;
                right = right.next;
            } else if (gap < n) {
                gap++;
                right = right.next;
            }
        }
        return left;
    }

    // 중간 노드 찾기
    // size, left, right, gap
    //  1  ,  1  ,   1  ,  0
    //  2  ,  1  ,   2  ,  1
    //  3  ,  2  ,   3  ,  1
    //  4  ,  2  ,   4  ,  2
    //  5  ,  3  ,   5  ,  2
    //  6  ,  3  ,   6  ,  3
    //  7  ,  4  ,   7  ,  3
    //  8  ,  4  ,   8  ,  4
    //  9  ,  5  ,   9  ,  4
    // 10  ,  5  ,  10  ,  5
    private LinkedNode findMiddle() {
        LinkedNode left = this.head, right = this.head;
        int gap = 0;
        int nextGap = 1;

//        while(right.next != null) {
//            if (gap == nextGap) {
//                left = left.next;
//                nextGap++;
//            } else {
//                gap++;
//            }
//            right = right.next;
//        }

        boolean isNext = false;
        while(right.next != null) {
            if (isNext) {
                left = left.next;
                isNext = false;
            } else {
                isNext = true;
            }
            right = right.next;
        }
        return left;
    }


    /**
     *  정렬된 연결 리스트에서 중복된 노드를 제거하는 함수를 구현하라.
     *  예) 1 -> 1 -> 1 -> 2 -> 3-> 3 => 1 -> 2-> 3
     */
    private void removeDuplicates() {
        LinkedNode current = this.head;
        while(current != null) {
            LinkedNode temp = current;
            while (temp != null && temp.number == current.number) {
                temp = temp.next;
            }
            current.next = temp;
            current = current.next;
        }
    }
    
    // 재귀 호출 방식
    private void removeDuplicates2() {
        removeDuplicatesRecursive(this.head);
    }

    private LinkedNode removeDuplicatesRecursive(LinkedNode node) {
        if (node == null) {
            return null;
        }
        if (node.next != null && node.number == node.next.number) {
            node.next = node.next.next;
            removeDuplicatesRecursive(node);
        } else {
            removeDuplicatesRecursive(node.next);
        }
        return node;
    }

    
    /**
     *  정렬되지 않은 연결 리스트에서 중복된 노드를 제거하는 함수를 구현하라.
     *  예) 1 -> 3 -> 2 -> 1 -> 2 -> 3 => 1 -> 3-> 2
     */
    private void removeDuplicatesInUnorderedList() {
       Set<Integer> numSet = new HashSet<>();
       LinkedNode current = this.head;
       LinkedNode prev = null;

//       while(current != null) {
//           numSet.add(current.number);
//           LinkedNode temp = current.next;
//           while(temp != null && numSet.contains(temp.number)) {
//               temp = temp.next;
//           }
//           current.next = temp;
//           current = current.next;
//       }

        while(current != null) {
            if (numSet.contains(current.number)) {
                prev.next = current.next;
            } else {
                numSet.add(current.number);
                prev = current;
            }
            current = current.next;
        }
    }

    /**
     * 정렬된 연결 리스트에서 중복되는 모든 노드 제거하기.
     * 예) 1 -> 2 -> 2 -> 3 => 1 -> 3
     */
    private void removeAllDuplicates() {
        LinkedNode current = this.head;
        LinkedNode prev = null; // 이전 값으로 세팅
        boolean skip = false;

        while (current != null) {
            LinkedNode temp = current.next;
            while (temp != null && current.number == temp.number) {
                temp = temp.next;
                skip = true; // 중복 발생.
            }

            if (skip && prev != null) { // 중복값이 발생한 경우 다음 값을 null로 설정
                prev.next = null;
            } else if (!skip){ // 중복값이 발생 하지 않은 경우
                if (prev == null) {
                    prev = current; // 중복이 되지 않는 경우이고, 아직 설정된 값이 없을 경우 prev 설정.
                } else {
                    prev.next = current; // 중복이 발생되지 않는 경우 다음 값 설정
                }
            }

            skip = false;
            current.next = temp;
            current = current.next;
        }
        this.head = prev;
    }

    // 시간 복잡도: O(N)
    // 공간 복잡도: O(N)
    private boolean hasCircleUsingSet() {
        LinkedNode current = this.head;
        Set<LinkedNode> nodeSet = new HashSet<>();

        while(current != null) {
            if (nodeSet.contains(current)) {
                return true;
            } else {
                nodeSet.add(current);
            }
            current = current.next;
        }
        return false;
    }

    // 시간 복잡도: O(N)
    // 공간 복잡도: O(1)
    private boolean hasCircle() {
        LinkedNode slow = this.head, fast = this.head;

        while(fast != null) {
            if (fast.next == null || fast.next.next == null) {
                return false;
            }
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
        }
        return false;
    }


    public LinkedList getLinkedList() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(new LinkedNode(1));
        linkedList.add(new LinkedNode(2));
        linkedList.add(new LinkedNode(3));
        linkedList.add(new LinkedNode(4));

        return linkedList;
    }

    public LinkedList getLinkedDupList() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(new LinkedNode(1));
        linkedList.add(new LinkedNode(1));
        linkedList.add(new LinkedNode(1));
        linkedList.add(new LinkedNode(2));
        linkedList.add(new LinkedNode(3));
        linkedList.add(new LinkedNode(3));

        return linkedList;
    }

    public LinkedList getCircleLinkedList() {
        LinkedList list = new LinkedList();
        list.add(new LinkedNode(1));
        list.add(new LinkedNode(2));
        LinkedNode node3 = new LinkedNode(3);
        list.add(node3);
        list.add(new LinkedNode(4));
        list.add(new LinkedNode(5));
        list.add(node3);
        return list;
    }

    // 노드 가져오기
    private LinkedNode get(int num) {
        LinkedNode slow = this.head, fast = this.head;

        while(fast != null) {
            if (fast.number == num || slow.number == num) {
                return (fast.number == num) ? fast : slow;
            }

            if (fast.next == null || fast.next.next == null) {
                break;
            }
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
            slow = slow.next;
        }
        return null;
    }

    @Test
    @DisplayName("단일 연결 리스트를 뒤집는 함수를 구현하라.")
    public void reverseNodeTest() {
        LinkedList linkedList = getLinkedList();
        linkedList.reverse1(); // 순환 방식
        assertEquals("4 3 2 1", linkedList.printStr());

        linkedList.reverse2(); // 재귀함수 호출 방식
        assertEquals("1 2 3 4", linkedList.printStr());
    }

    @Test
    @DisplayName("과제 : 역순 출력")
    public void reversePrintTest() {
        LinkedList linkedList = getLinkedList();
        assertEquals("4 3 2 1", linkedList.reversePrintStr1());
        assertEquals("4 3 2 1", linkedList.reversePrintStr2());
    }


    @Test
    @DisplayName("단일 연결 리스트의 끝에서 n번째에 위치한 노드를 찾는 함수를 구현하라.")
    public void findFromLastTest() {
        LinkedList linkedList = getLinkedList();
        assertEquals(3, linkedList.findFromLastUsingMap(2).number);
        assertEquals(3, linkedList.findFromLast(2).number);
    }

    @Test
    @DisplayName("과제 : 연결리스트의 중간노드 찾기")
    public void findMiddleNodeTest() {
        LinkedList linkedList = getLinkedList();
        assertEquals(2, linkedList.findMiddle().number);

        for (int i = 5; i <= 99; i++) {
            linkedList.add(new LinkedNode(i));
        }
        assertEquals(50, linkedList.findMiddle().number);
    }

    @Test
    @DisplayName("정렬된 연결 리스트에서 중복된 노드를 제거하는 함수를 구현하라.")
    public void removeDuplicatesTest() {
        LinkedList linkedList = getLinkedDupList();

       // linkedList.removeDuplicates();
        linkedList.removeDuplicates2();

        assertEquals("1 2 3", linkedList.printStr());
    }

    @Test
    @DisplayName("정렬되지 않은 연결 리스트에서 중복된 노드를 제거하는 함수를 구현하라.")
    public void removeDuplicatesInUnorderedListTest() {
        LinkedList linkedList = getLinkedDupList();

        linkedList.removeDuplicatesInUnorderedList();
        assertEquals("1 2 3", linkedList.printStr());
    }

    @Test
    @DisplayName("문제 : 정렬된 연결 리스트에서 중복되는 모든 노드 제거하는 코드를 작성하라.")
    public void removeAllDuplicatesTest() {
        LinkedList linkedList = getLinkedDupList();
        linkedList.removeAllDuplicates();
        assertEquals("2", linkedList.printStr());
    }

    @Test
    @DisplayName("주어진 연결 리스트가 원형 연결 리스트인지 단일 연결 리스트인지 확인하는 함수를 구현하라. (HashSet 이용)")
    public void hasCircleTest1() {
        LinkedList linkedList = getLinkedList();
        LinkedList linkedCircleList = getCircleLinkedList();

        assertFalse(linkedList.hasCircleUsingSet());
        assertTrue(linkedCircleList.hasCircleUsingSet());
    }

    @Test
    @DisplayName("주어진 연결 리스트가 원형 연결 리스트인지 단일 연결 리스트인지 확인하는 함수를 구현하라.(속도 다른 포인터 이용)")
    public void hasCircleTest2() {
        LinkedList linkedList = getLinkedList();
        LinkedList linkedCircleList = getCircleLinkedList();

        assertFalse(linkedList.hasCircle());
        assertTrue(linkedCircleList.hasCircle());
    }

    @Test
    @DisplayName("문제 : 원형 연결 리스트 시작 지점을 찾아라.")
    public void findCircleNodeTest() {
        LinkedList linkedList = getLinkedList();
        LinkedList linkedCircleList = getCircleLinkedList();

        LinkedNode findNode = linkedCircleList.get(3);

        assertEquals(findNode, linkedCircleList.findCircleNode());
        assertEquals(null, linkedList.findCircleNode());
    }

    // 코딩 인터뷰 완전분석 p320 참조
    private LinkedNode findCircleNode() {
        LinkedNode slow = this.head;
        LinkedNode fast = this.head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) { // 충돌지점
                break;
            }
        }

        if (fast == null || fast.next == null) { // 순환 X
            return null;
        }

        slow = this.head; // 시점으로 돌아가기

        // 시점, 충돌지점에서 각각 출발한 노드가 만나기까지 반복
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
