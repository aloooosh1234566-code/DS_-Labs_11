import java.util.*;

    // 1. تعريف عقدة القائمة الأحادية والدائرية (Singly & Circular Node)
    class Node {
        int data;
        Node next;
        Node(int d) { data = d; next = null; }
    }

    // 2. تعريف عقدة القائمة المزدوجة (Doubly Node)
    class DNode {
        int data;
        DNode next, prev;
        DNode(int d) { data = d; next = prev = null; }
    }

    public class Ds {

        // --- أسئلة المصفوفات (Arrays) ---
        // نسخ مصفوفة
        public static int[] cloneArray(int[] arr) { return arr.clone(); }

        // حذف عنصر عشوائي
        public static int[] removeRandom(int[] arr) {
            if (arr.length == 0) return arr;
            int index = new Random().nextInt(arr.length);
            int[] newArr = new int[arr.length - 1];
            for (int i = 0, k = 0; i < arr.length; i++) {
                if (i != index) newArr[k++] = arr[i];
            }
            return newArr;
        }

        // عكس مصفوفة
        public static void reverseArray(int[] arr) {
            int start = 0, end = arr.length - 1;
            while (start < end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++; end--;
            }
        }

        // --- أسئلة القائمة الأحادية (Singly Linked List) ---
        // دمج قائمتين
        public static Node concatenate(Node l1, Node l2) {
            if (l1 == null) return l2;
            Node temp = l1;
            while (temp.next != null) temp = temp.next;
            temp.next = l2;
            return l1;
        }

        // البحث عن عنصر وإرجاع موقعه أو -1
        public static int searchSingly(Node head, int key) {
            Node temp = head;
            int pos = 0;
            while (temp != null) {
                if (temp.data == key) return pos;
                temp = temp.next; pos++;
            }
            return -1;
        }

        // --- أسئلة القائمة المزدوجة (Doubly Linked List) ---
        // طباعة القائمة بالعكس
        public static void printReverse(DNode tail) {
            DNode temp = tail;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.prev;
            }
        }

        // حذف التكرار
        public static void removeDuplicates(DNode head) {
            DNode current = head;
            while (current != null) {
                DNode index = current.next;
                while (index != null) {
                    if (current.data == index.data) {
                        if (index.next != null) index.next.prev = index.prev;
                        index.prev.next = index.next;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }


        // --- أسئلة القائمة الدائرية (Circular Linked List) ---
        // تقسيم القائمة لنصفين
        public static void splitCircular(Node head) {
            if (head == null) return;
            Node slow = head, fast = head;
            while (fast.next != head && fast.next.next != head) {
                fast = fast.next.next;
                slow = slow.next;
            }
            Node head2 = slow.next;
            slow.next = head;
            Node temp = head2;
            while (temp.next != head) temp = temp.next;
            temp.next = head2;
        }

        public static void main(String[] args) {
            System.out.println("تمت إضافة جميع حلول الأسئلة بنجاح!");
        }
    }



