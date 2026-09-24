// Time complexity: O(nlog3) = O(n), as there is only a maximum of 3 elements in maxHeap at all times, n = a + b + c
// Space complexity: O(3) = O(1)
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        // Use maxHeap to use highest counter alphabets first to get longest happy string
        // int[] -> (count, char)
        PriorityQueue<Counter> maxHeap = new PriorityQueue<>((x, y) -> {
            int diff = Integer.compare(y.count, x.count);
            if (diff == 0) {
                return Character.compare(x.alphabet, y.alphabet);
            }
            return diff;
        });

        if (a > 0) {
            maxHeap.offer(new Counter(a, 'a'));
        }
        
        if (b > 0) {
            maxHeap.offer(new Counter(b, 'b'));
        }

        if (c > 0) {
            maxHeap.offer(new Counter(c, 'c'));
        }

        StringBuilder sb = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            Counter curr = maxHeap.poll();
            char letter = curr.alphabet;
            int currLen = sb.length();
            if (currLen >= 2 && letter == sb.charAt(currLen - 1) && letter == sb.charAt(currLen - 2)) {
                if (maxHeap.isEmpty()) {
                    break;
                }
                // Else use second option
                Counter second = maxHeap.poll();
                sb.append(second.alphabet);
                second.count--;
                if (second.count > 0) {
                    maxHeap.offer(second);
                }
                maxHeap.offer(curr);
            } else {
                sb.append(letter);
                curr.count--;
                if (curr.count > 0) {
                    maxHeap.offer(curr);
                }
            }
        }

        return sb.toString();
    }
}

class Counter {
    int count;
    char alphabet;

    public Counter(int count, char alphabet) {
        this.count = count;
        this.alphabet = alphabet;
    }
}