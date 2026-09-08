class MyQueue {
    Stack<Integer> stackOne;
    Stack<Integer> stackTwo;

    public MyQueue() {
       // Use two stacks to implement a queue
        this.stackOne = new Stack<>(); // stackOne for pushing
        this.stackTwo = new Stack<>(); // stackTwo for popping
    }
    
    public void push(int x) {
        stackOne.push(x);
    }
    
    public int pop() {
        if (stackTwo.isEmpty()) {
            // Pop everything from stackOne to stackTwo
            while (!stackOne.isEmpty()) {
                stackTwo.push(stackOne.pop());
            }
        }
        return stackTwo.pop();
    }
    
    public int peek() {
        if (stackTwo.isEmpty()) {
            // Pop everything from stackOne to stackTwo
            while (!stackOne.isEmpty()) {
                stackTwo.push(stackOne.pop());
            }
        }
        return stackTwo.peek();
    }
    
    public boolean empty() {
        return stackOne.isEmpty() && stackTwo.isEmpty();
    }
}


/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */