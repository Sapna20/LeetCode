
class Pair {
    int a;
    int b;

    Pair (int a, int b) {
        this.a = a;
        this.b = b;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Queue<Pair> pq = new PriorityQueue<Pair>((obj1, obj2) -> obj2.b - obj1.b);
        Map<Integer, Integer> map = new HashMap<>();

        for(int z : nums) {
            map.put(z, map.getOrDefault(z,0) + 1);
        }

        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            Pair x = new Pair(e.getKey(), e.getValue());
            pq.add(x);
        }

        int[] ans = new int[k];
        for(int i=0; i<k; i++) {
            Pair x = pq.peek();
            ans[i] = x.a;
            pq.poll();
        }

        return ans;

    }
}