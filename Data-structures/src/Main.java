class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }
}

class LinkedList {
    private Node head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public int getSize() {
        return size;
    }

    public Integer getHead() {
        return (head != null) ? head.value : null;
    }

    public Integer getTail() {
        if (head == null) return null;
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current.value;
    }

    public Integer at(int index) {
        if (index < 0 || index >= size) return null;
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    public Integer pop() {
        if (head == null) return null;
        if (head.next == null) {
            int value = head.value;
            head = null;
            size--;
            return value;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        int value = current.next.value;
        current.next = null;
        size--;
        return value;
    }

    public boolean contains(int value) {
        Node current = head;
        while (current != null) {
            if (current.value == value) return true;
            current = current.next;
        }
        return false;
    }

    public Integer find(int value) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.value == value) return index;
            current = current.next;
            index++;
        }
        return null;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.append(10);
        ll.append(20);
        ll.prepend(5);
        System.out.println("Size: " + ll.getSize()); // Output: 3
        System.out.println("Head: " + ll.getHead()); // Output: 5
        System.out.println("Tail: " + ll.getTail()); // Output: 20
        System.out.println("At index 1: " + ll.at(1)); // Output: 10
        System.out.println("Pop: " + ll.pop()); // Output: 20
        System.out.println("Contains 10: " + ll.contains(10)); // Output: true
        System.out.println("Find 10: " + ll.find(10)); // Output: 1
    }
}