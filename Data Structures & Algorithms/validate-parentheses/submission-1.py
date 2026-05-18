class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for char in s:
            if char == ']':
                if len(stack) > 0 and stack[len(stack) - 1] == '[':
                    stack.pop()
                else:
                    return False
            elif char == '}':
                if len(stack) > 0 and stack[len(stack) - 1] == '{':
                    stack.pop()
                else:
                    return False
            elif char == ')':
                if len(stack) > 0 and stack[len(stack) - 1] == '(':
                    stack.pop()
                else:
                    return False
            else:
                stack.append(char)
        
        if len(stack) == 0:
            return True
        return False