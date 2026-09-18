class Solution {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();

        for (char c : s.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Count> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.counter, a.counter));

        for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
            Count curr = new Count(entry.getValue(), entry.getKey());
            maxHeap.offer(curr);
        }

        StringBuilder answer = new StringBuilder();
        Count previous = null;

        while (!maxHeap.isEmpty()) {
            Count current = maxHeap.poll();

            answer.append(current.c);
            current.counter--;

            // The previous character can now be used again because
            // a different character was just appended.
            if (previous != null && previous.counter > 0) {
                maxHeap.offer(previous);
            }

            previous = current;
        }

        // Leftover occurrences mean no valid arrangement was possible.
        if (previous != null && previous.counter > 0) {
            return "";
        }
        
        

        return answer.toString();
    }
}

class Count {
    int counter;
    char c;

    public Count(int counter, char c) {
        this.counter = counter;
        this.c = c;
    }
}