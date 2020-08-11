package top.lijngyuan.leetcode.栈.easy.q225_用队列实现栈;

//使用队列实现栈的下列操作：
//
//
// push(x) -- 元素 x 入栈
// pop() -- 移除栈顶元素
// top() -- 获取栈顶元素
// empty() -- 返回栈是否为空
//
//
// 注意:
//
//
// 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合
//法的。
// 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
// 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
//
// Related Topics 栈 设计
// 👍 210 👎 0

import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution
 *
 * @author <a href="kangjinghang@gmail.com">kangjinghang</a>
 * @date 2020-08-11
 * @since 1.0.0
 */
public class Solution {

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.top();
        stack.pop();
        stack.empty();
    }

}

class MyStack {

    private Queue<Integer> q;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        q = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        q.add(x);
        int sq = q.size();
        while (sq > 1) {
            q.add(q.remove());
            sq--;
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return q.remove();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return q.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return q.isEmpty();
    }

}
