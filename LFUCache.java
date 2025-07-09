class LFUCache {
    class Node {
        int key, val;
        int count;
        Node prev, next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            count = 1;
        }
    }
    
    class DList {
        Node head;
        Node tail;
        int size;

        public DList() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void addToHead(Node node) {
            node.next = head.next;
            node.prev = head;
            node.next.prev = node;
            head.next = node;
            size++;
        }

        public void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        public Node removeLast() {
            Node last = tail.prev;
            removeNode(last);
            return last;
        }
    }

    int capacity;
    int size;
    int min;
    HashMap<Integer, Node> map;
    HashMap<Integer, DList> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        freqMap = new HashMap<>();
        this.size = 0;
        this.min = 0;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        Node node = map.get(key);
        updateFreq(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0)
            return;
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            updateFreq(node);
        } else {
            if (size == capacity) {
                DList minList = freqMap.get(min);
                Node toRemove = minList.removeLast();
                map.remove(toRemove.key);
                size--;
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            freqMap.putIfAbsent(1, new DList());
            freqMap.get(1).addToHead(newNode);
            min = 1;
            size++;

        }
    }

    public void updateFreq(Node node) {
        int oldFre = node.count;
        DList list = freqMap.get(oldFre);
        list.removeNode(node);

        if (oldFre == min && list.size == 0) {
            min++;
        }

        node.count++;
        freqMap.putIfAbsent(node.count, new DList());
        freqMap.get(node.count).addToHead(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
