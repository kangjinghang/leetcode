package top.lijngyuan.leetcode.设计.medium.q146_LRU缓存机制;
//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
//
// 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
//写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在
//写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
//
//
//
// 进阶:
//
// 你是否可以在 O(1) 时间复杂度内完成这两种操作？
//
//
//
// 示例:
//
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得关键字 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得关键字 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
//
// Related Topics 设计
// 👍 894 👎 0

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author <a href="kangjinghang@gmail.com">kangjinghang</a>
 * @date 2020-09-17
 * @since 1.0.0
 */
public class Solution {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        // 1
        System.out.println(cache.get(1));
        cache.put(3, 3);
        // -1
        System.out.println(cache.get(2));
        cache.put(4, 4);
        // -1
        System.out.println(cache.get(1));
        // 3
        System.out.println(cache.get(3));
        // 4
        System.out.println(cache.get(4));
    }

}

class LRUCache {

    /**
     * 使用HashMap缓存Node节点
     */
    private HashMap<Integer, Node> cache = new HashMap<>();

    /**
     * 最大容量，超过capacity时继续插入会触发删除最老未被使用的节点
     */
    private int capacity;

    /**
     * 头节点、尾节点（注意这两个节点不存储实际的数据）
     */
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;

        head = new Node();
        tail = new Node();

        head.after = tail;
        head.before = null;
        tail.before = head;
        tail.after = null;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            // should raise exception here.
            return -1;
        }
        // 在使用get方法获取值之后，需要将当前获取的节点移动到队列头部
        moveToHead(node);
        return node.value;
    }

    /**
     * 将节点移动到有效数据头部
     *
     * @param node node
     */
    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    /**
     * 删除队列中的一个节点
     *
     * @param node node
     */
    private void removeNode(Node node) {
        node.before.after = node.after;
        node.after.before = node.before;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            node = new Node();
            node.key = key;
            node.value = value;
            cache.put(key, node);
            addToHead(node);
            if (cache.size() > capacity) {
                // 删除队尾有效数据节点
                Node tail = popTail();
                cache.remove(tail.key);
            }
        } else {
            node.value = value;
            // 如果获取到数据，则将获取到的节点移动到队列头部
            moveToHead(node);
        }
    }

    /**
     * 删除有效数据尾节点
     *
     * @return 尾节点
     */
    private Node popTail() {
        Node node = tail.before;
        removeNode(node);
        return node;
    }

    /**
     * 将节点插入队列头部
     *
     * @param node node
     */
    private void addToHead(Node node) {
        Node after = head.after;

        head.after = node;

        node.before = head;
        node.after = after;

        after.before = node;
    }

}

class LRUCache2 extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache2(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    public boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}

/**
 * Node类用于抽象链表的节点
 * key、value存储键、值，
 * before、after分别指向当前节点的前后Node节点；
 */
class Node {
    int key;
    int value;
    Node before;
    Node after;
}
