import java.util.*;

class MinStack{
    Stack<Integer> stack;
    public MinStack() {
        stack = new Stack<>();    
    }
    
    public void push(int val) {
        stack.push(val);
    }
    
    public void pop() {
        if(!stack.isEmpty())
            stack.pop();
    }
    
    public int top() {
        if(!stack.isEmpty())
            return stack.peek();
        return 0;
    }
    
    public int getMin() {
        return Collections.min(stack);
    }

    public static void main(String[] args) {
        //  MinStack object will be instantiated and called as such:
         MinStack obj = new MinStack();
         obj.push(10);
         obj.push(-2);
         obj.push(11);
         obj.push(5);
         obj.pop();
        System.out.println(obj.top()); 
         System.out.println(obj.getMin());
    }
}