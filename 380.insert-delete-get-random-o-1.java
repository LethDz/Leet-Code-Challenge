/*
 * @lc app=leetcode id=380 lang=java
 *
 * [380] Insert Delete GetRandom O(1)
 *
 * https://leetcode.com/problems/insert-delete-getrandom-o1/description/
 *
 * algorithms
 * Medium (54.57%)
 * Likes:    9238
 * Dislikes: 626
 * Total Accepted:    963.6K
 * Total Submissions: 1.8M
 * Testcase Example:  '["RandomizedSet","insert","remove","insert","getRandom","remove","insert","getRandom"]\n' +
  '[[],[1],[2],[2],[],[1],[2],[]]'
 *
 * Implement the RandomizedSet class:
 * 
 * 
 * RandomizedSet() Initializes the RandomizedSet object.
 * bool insert(int val) Inserts an item val into the set if not present.
 * Returns true if the item was not present, false otherwise.
 * bool remove(int val) Removes an item val from the set if present. Returns
 * true if the item was present, false otherwise.
 * int getRandom() Returns a random element from the current set of elements
 * (it's guaranteed that at least one element exists when this method is
 * called). Each element must have the same probability of being returned.
 * 
 * 
 * You must implement the functions of the class such that each function works
 * in average O(1) time complexity.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input
 * ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove",
 * "insert", "getRandom"]
 * [[], [1], [2], [2], [], [1], [2], []]
 * Output
 * [null, true, false, true, 2, true, false, 2]
 * 
 * Explanation
 * RandomizedSet randomizedSet = new RandomizedSet();
 * randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was
 * inserted successfully.
 * randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
 * randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now
 * contains [1,2].
 * randomizedSet.getRandom(); // getRandom() should return either 1 or 2
 * randomly.
 * randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now
 * contains [2].
 * randomizedSet.insert(2); // 2 was already in the set, so return false.
 * randomizedSet.getRandom(); // Since 2 is the only number in the set,
 * getRandom() will always return 2.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * -2^31 <= val <= 2^31 - 1
 * At most 2 * 10^5 calls will be made to insert, remove, and getRandom.
 * There will be at least one element in the data structure when getRandom is
 * called.
 * 
 * 
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

class RandomizedSet {
    List<Integer> integerList;
    Map<Integer, Integer> mapIndexByInteger;
    ThreadLocalRandom random;


    public RandomizedSet() {
        integerList = new ArrayList<>();
        mapIndexByInteger = new HashMap<>();
        random = ThreadLocalRandom.current();
    }

    public boolean insert(int val) {
        Integer wrappedVal = Integer.valueOf(val);
        Integer listIndex = mapIndexByInteger.get(wrappedVal);
        if (listIndex != null) {
            return false;
        }

        integerList.add(wrappedVal);
        Integer newIndex = Integer.valueOf(integerList.size() - 1);
        mapIndexByInteger.put(wrappedVal, newIndex);

        return true;
    }

    public boolean remove(int val) {
        Integer wrappedVal = Integer.valueOf(val);
        Integer listIndex = mapIndexByInteger.remove(wrappedVal);
        if (listIndex != null) {
            if (listIndex == integerList.size() - 1) {
                integerList.remove(listIndex.intValue());
            } else {
                // swapping position from the indicated index with the last index.
                Integer value = integerList.get(integerList.size() - 1);
                integerList.set(listIndex, value);
                mapIndexByInteger.put(value, listIndex);
                integerList.remove(integerList.size() - 1);
            }
            return true;
        }

        return false;
    }

    public int getRandom() {
        Integer randomIndex = random.nextInt(integerList.size());
        return integerList.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
// @lc code=end
