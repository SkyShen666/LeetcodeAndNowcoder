package 栈和队列;
import java.util.*;

public class 面试题0305栈排序 {
    private Deque<Integer> sortedStack;
    private Deque<Integer> helperStack;

    public 面试题0305栈排序() {
        sortedStack = new LinkedList<>();
        helperStack = new LinkedList<>();
    }

    public void push(int val) {
        if (sortedStack.isEmpty() || val <= sortedStack.peekFirst()) {
            sortedStack.offerFirst(val);
        } else {
            while (!sortedStack.isEmpty() && val > sortedStack.peekFirst()) {
                helperStack.offerFirst(sortedStack.pollFirst());
            }
            sortedStack.offerFirst(val);
            while (!helperStack.isEmpty()) {
                sortedStack.offerFirst(helperStack.pollFirst());
            }
        }
    }

    public void pop() {
        if (!sortedStack.isEmpty()) {
            sortedStack.pollFirst();
        }
    }

    public int peek() {
        return sortedStack.isEmpty() ? -1 : sortedStack.peekFirst();
    }

    public boolean isEmpty() {
        return sortedStack.isEmpty();
    }
}
