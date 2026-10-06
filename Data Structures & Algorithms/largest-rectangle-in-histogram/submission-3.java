class Solution {
    public int largestRectangleArea(int[] heights) {
        /*
        Solution: Keep a monotonic stack that stores index, but everytime u meet a number < 
        stack.peek(), means you found the right wall for that rectangle, the left wall will
        be = stack.peek() index, so we can calculate curr rectangle = (right wall - left wall) * 
        stack.peek() (Height of curr rectangle) -> Then pop()

        At the end of the loop, stack might still contain some elements (Cuz monotonic)
        We then need to pop one by one, where the right boundary = heights.length - 1 (Cuz we did not 
        find a right wall shorter than that specific index height)
        Left wall will just be the stack.peek() value -> Calculate rectangle and then pop()

        Time Complexity: O(2n) = O(n), each index is pushed and pop() at most once
        Space Complexity: O(n), because of stack
        */

        Stack<Integer> stack = new Stack<>();
        int largestRectangle = 0;

        for (int i = 0; i < heights.length; i++) {
            int currHeight = heights[i];

            if (stack.isEmpty() || heights[stack.peek()] < currHeight) {
                stack.push(i);
                continue;
            }
            
            // Else, found right wall for curr rectangle
            while (!stack.isEmpty() && currHeight < heights[stack.peek()]) {
                // Pop first, then the left wall is the new stack top 
                int currInd = stack.pop();
                // Left Wall can be = -1, is stack is empty
                // -1 since we need an imaginary position before index 0, 
                // so we can compute the width correctly
                int leftWall = stack.isEmpty() ? -1 : stack.peek();
                int currArea = (i - leftWall - 1) * heights[currInd];
                largestRectangle = Math.max(largestRectangle, currArea);
            }
            stack.push(i);
        }

        // Pop remaining elements in stack
        while (!stack.isEmpty()) {
            int currInd = stack.pop();
            // Left wall is stack.peek() again or -1
            int leftWall = stack.isEmpty() ? -1 : stack.peek();
            int currArea = (heights.length - leftWall - 1) * heights[currInd];
            largestRectangle = Math.max(largestRectangle, currArea);
        }

        return largestRectangle;
    }
}

/*
Dry run: heights = [2, 1, 5, 6, 2, 3], expected = 10
Key idea: the index directly below a bar in the stack is the nearest
shorter bar to its left, so it serves as the (exclusive) left wall.
Width = rightWall - leftWall - 1 (both walls exclusive).

Main loop:
i=0 h=2 | stack empty -> push 0                          | stack [0]
i=1 h=1 | pop 0 (h=2): left=-1, w=1-(-1)-1=1, area=2     | best=2
        | stack empty -> push 1                          | stack [1]
i=2 h=5 | 1 < 5 -> push 2                                | stack [1,2]
i=3 h=6 | 5 < 6 -> push 3                                | stack [1,2,3]
i=4 h=2 | pop 3 (h=6): left=2, w=4-2-1=1, area=6         | best=6
        | pop 2 (h=5): left=1, w=4-1-1=2, area=10        | best=10
        | 1 < 2 -> stop, push 4                          | stack [1,4]
i=5 h=3 | 2 < 3 -> push 5                                | stack [1,4,5]

Final loop (right wall = heights.length = 6):
pop 5 (h=3): left=4,  w=6-4-1=1,    area=3
pop 4 (h=2): left=1,  w=6-1-1=4,    area=8   (spans idx 2..5)
pop 1 (h=1): left=-1, w=6-(-1)-1=6, area=6   (whole array)

Result: 10

Edge case: heights = [1, 1, 10, 1, 1], expected = 10
Equal heights must be pushed, not skipped. Index 1 is the left wall
for the 10 bar. If it's skipped, left wall becomes 0 -> w=2, area=20 (wrong).
With equal heights pushed:
i=3 pops 2 (h=10): left=1, w=3-1-1=1, area=10
*/
