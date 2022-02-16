public class OwnLinkedList<T> {
    private long size;
    private Node head;
    private Node tail;

    public OwnLinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }



    public void addNode(T data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
        }

        tail = newNode;
        size++;
    }


    public void add (T data, int index){
        Node newNode = new Node(data);
        newNode.data = data;
        Node oldNode = head;
        if (head == null) {
            System.out.println("Односвязный список пуст");
            return;
        }
        if (index > size) {
            System.out.println("Размер списка больше чем заданный индекс");
            return;
        } else {

            int i = 0;
            if (index == 0){
                newNode.next = head;
                head = newNode;
                size++;
                return;
            }
            while (oldNode != null && i < index - 1) {
                oldNode = oldNode.next;
                i++;
            }
            newNode.next = oldNode.next;
            oldNode.next = newNode;
            size++;
        }
    }

    public void del (int index){
        if(head == null)
            return;
        int i = 0;
        Node oldNode = head;
        if (index > size) {
            System.out.println("Размер списка больше чем заданный индекс");
            return;
        } else {
            if (index == 0) {
                head = head.next;
                i--;
                return;
            }
            while (oldNode != null && i < index - 1) {
                oldNode = oldNode.next;
                i++;
            }
            oldNode.next = oldNode.next.next;
            size--;
        }


    }



    public void display() {
        Node current = head;

        if (head == null) {
            System.out.println("Односвязный список пуст");
            return;
        }

        while (current != null) {
            System.out.println(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }

    public void display(int index) {
        if (index > size) {
            System.out.println("Размер списка больше чем заданный индекс");
            return;
        }

        Node current = head;

        for (int i = 1; i <= index; i++) {
            current = current.next;
        }

        System.out.println(current.data);
    }


    private class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public Node(T data, int j) {
            this.data = data;
            this.next = null;
        }

    }
}

