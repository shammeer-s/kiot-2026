import java.util.*;

public class QueuePrac {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);
        queue.offer(50);

        System.out.println(queue);

        queue = reverse(queue, 3);

        // queue = rotate(queue, 2);
        System.out.println(queue);

    }

    public static Queue<Integer> reverse(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();

        while(!queue.isEmpty()) {
            stack.push(queue.peek());
            queue.poll();
        }

        while(!stack.isEmpty()) {
            queue.offer(stack.pop());
        }
        
        return queue;
    }

    public static Queue<Integer> reverse(Queue<Integer> queue, int k) {
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < k; i++) {
            stack.push(queue.peek());
            queue.poll();
        }
        
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }
        
        int remaining = queue.size() - k;
        for (int i = 0; i < remaining; i++) {
            queue.offer(queue.peek());
            queue.poll();
        }
        return queue;
    }

    public static Queue<Integer> rotate(Queue<Integer> queue, int rotations) {
        for(int i=0; i<rotations; i++) {
            int data = queue.peek();
            queue.poll();
            queue.offer(data);
        }

        return queue;
    }
}
