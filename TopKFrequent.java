import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@SuppressWarnings("unused")
class TopKFrequent {
    // count the frequency of every num
    //
    // use buckets of nums to find the top k frequencies
    // the min frequency is zero (never appears in nums)
    // the max frequency is nums.length (only distinct num in nums)
    // this means the indexes are in the range [0, nums.length], so we need nums.length + 1 buckets
    // the buckets provide a mapping from frequency to num
    //
    // work backwards from the bucket at the highest index until we find k elements
    public int[] topKFrequent(int[] nums, int k) {
        final Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) counter.put(num, counter.getOrDefault(num, 0) + 1);

        final List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < nums.length + 1; i++) buckets.add(new ArrayList<>());
        for (Entry<Integer, Integer> entry : counter.entrySet()) buckets.get(entry.getValue()).add(entry.getKey());

        int h;
        final int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            while (buckets.get(h = buckets.size() - 1).isEmpty()) buckets.remove(h);
            result[i] = buckets.get(h).remove(0);
        }
        return result;
    }
}