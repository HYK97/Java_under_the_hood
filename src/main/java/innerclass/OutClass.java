package innerclass;

public class OutClass<K, V> {


    private final Node<K, V> headNode = new Node<>(null, null, null);
    private Node<K, V> prevNode;

    public void setData(K key, V value) {
        Node<K, V> newNode;
        newNode = new Node<>(value, key, null);
        if (headNode.nextNode == null) {
            headNode.nextNode = newNode;
        } else {
            prevNode.nextNode = newNode;
        }
        prevNode = newNode;
    }

    public void getDatas() {
        Node<K, V> targetNode = headNode.nextNode;
        while (targetNode != null) {
            System.out.println("key = " + targetNode.key);
            System.out.println("value = " + targetNode.value);
            targetNode = targetNode.nextNode;
        }
    }

    public V getKey(K key) {
        Node<K, V> targetNode = headNode.nextNode;
        while (targetNode != null) {
            if (targetNode.key == key || targetNode.equals(key)) {
                return targetNode.value;
            }
            targetNode = targetNode.nextNode;
        }
        throw new IllegalArgumentException("없는인덱스");
    }


    private static class Node<K, V> {
        V value;
        K key;
        Node<K, V> nextNode;


        public Node(V value, K key, Node<K, V> nextNode) {
            this.value = value;
            this.key = key;
            this.nextNode = nextNode;
        }


    }


}
