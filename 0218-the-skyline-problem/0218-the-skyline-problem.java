class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> events = new ArrayList<>();
        for (int[] b : buildings) {
            events.add(new int[]{b[0], -b[2]});
            events.add(new int[]{b[1], b[2]});
        }
        Collections.sort(events, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });
        
        TreeMap<Integer, Integer> heights = new TreeMap<>();
        heights.put(0, 1);
        List<List<Integer>> result = new ArrayList<>();
        int prevMax = 0;
        
        for (int[] e : events) {
            if (e[1] < 0) {
                heights.put(-e[1], heights.getOrDefault(-e[1], 0) + 1);
            } else {
                int count = heights.get(e[1]);
                if (count == 1) heights.remove(e[1]);
                else heights.put(e[1], count - 1);
            }
            
            int currMax = heights.lastKey();
            if (currMax != prevMax) {
                result.add(Arrays.asList(e[0], currMax));
                prevMax = currMax;
            }
        }
        return result;
    }
}