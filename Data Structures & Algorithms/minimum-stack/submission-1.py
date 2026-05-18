# Overall Space Complexity: O(n), both stacks can store up to n elements
class MinStack:
    def __init__(self):      
        self.stack = []
        self.minStack = []  

    # Time Complexity: O(1)
    def push(self, val: int) -> None:
        self.stack.append(val)
        if len(self.minStack) == 0 or self.minStack[len(self.minStack) - 1] >= val:
            self.minStack.append(val)

    # Time Complexity: O(1)
    def pop(self) -> None:
        poppedVal = self.stack.pop()
        if self.minStack[len(self.minStack) - 1] == poppedVal:
            self.minStack.pop()
        
    # Time Complexity: O(1)
    def top(self) -> int:
        return self.stack[len(self.stack) - 1]

    # Time Complexity: O(1)
    def getMin(self) -> int:
        return self.minStack[len(self.minStack) - 1]
