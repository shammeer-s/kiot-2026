# Dynamic Programming 1

## 1. Fibonacci Number

**LeetCode:** 509

**Problem:** Compute the nth Fibonacci number, where `F(0) = 0`, `F(1) = 1`, and `F(n) = F(n-1) + F(n-2)` for `n > 1`.

**Test Cases:**
- Input: `n = 2` → Output: `1`
- Input: `n = 4` → Output: `3`

### Recursive

**Time:** O(2^N) **Space:** O(N) recursion stack

```java
public static int fibRecursive(int n) {
    if (n <= 1) {
        return n;
    }
    return fibRecursive(n - 1) + fibRecursive(n - 2);
}
```

### Memoization

**Time:** O(N) **Space:** O(N)

```java
public static int fibMemoization(int n) {
    Integer[] memo = new Integer[n + 1];
    return fibMemoHelper(n, memo);
}

private static int fibMemoHelper(int n, Integer[] memo) {
    if (n <= 1) {
        return n;
    }
    if (memo[n] != null) {
        return memo[n];
    }
    memo[n] = fibMemoHelper(n - 1, memo) + fibMemoHelper(n - 2, memo);
    return memo[n];
}
```

### Tabulation

**Time:** O(N) **Space:** O(N)

```java
public static int fibTabulation(int n) {
    if (n <= 1) {
        return n;
    }
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
}
```

### Space Optimized

**Time:** O(N) **Space:** O(1)

```java
public static int fibOptimized(int n) {
    if (n <= 1) {
        return n;
    }
    int prev2 = 0;
    int prev1 = 1;
    int current = 0;
    for (int i = 2; i <= n; i++) {
        current = prev1 + prev2;
        prev2 = prev1;
        prev1 = current;
    }
    return current;
}
```

---

## 2. Can Sum

**LeetCode:** Not listed (classic combinatorial DP problem)

**Problem:** Given a target sum and an array of positive numbers (each number can be reused unlimited times), determine whether any combination of the numbers adds up exactly to the target.

**Test Cases:**
- Input: `target = 7, nums = [5, 3, 4, 7]` → Output: `true`
- Input: `target = 7, nums = [2, 4]` → Output: `false`

### Recursive

**Time:** O(N^T) where T is target **Space:** O(T)

```java
public static boolean canSumRecursive(int target, int[] nums) {
    if (target == 0) {
        return true;
    }
    if (target < 0) {
        return false;
    }
    for (int num : nums) {
        if (canSumRecursive(target - num, nums)) {
            return true;
        }
    }
    return false;
}
```

### Memoization

**Time:** O(N * T) **Space:** O(T)

```java
public static boolean canSumMemoization(int target, int[] nums) {
    Map<Integer, Boolean> memo = new HashMap<>();
    return canSumMemoHelper(target, nums, memo);
}

private static boolean canSumMemoHelper(int target, int[] nums, Map<Integer, Boolean> memo) {
    if (memo.containsKey(target)) {
        return memo.get(target);
    }
    if (target == 0) {
        return true;
    }
    if (target < 0) {
        return false;
    }
    for (int num : nums) {
        if (canSumMemoHelper(target - num, nums, memo)) {
            memo.put(target, true);
            return true;
        }
    }
    memo.put(target, false);
    return false;
}
```

### Tabulation

**Time:** O(N * T) **Space:** O(T)

```java
public static boolean canSumTabulation(int target, int[] nums) {
    boolean[] dp = new boolean[target + 1];
    dp[0] = true;
    for (int i = 0; i <= target; i++) {
        if (dp[i]) {
            for (int num : nums) {
                if (i + num <= target) {
                    dp[i + num] = true;
                }
            }
        }
    }
    return dp[target];
}
```

---

## 3. How Sum

**LeetCode:** Not listed (classic combinatorial DP problem)

**Problem:** Given a target sum and an array of positive numbers (each reusable unlimited times), return any array of numbers that sum exactly to the target, or `null` if no combination exists.

**Test Cases:**
- Input: `target = 7, nums = [2, 3]` → Output: `[3, 2, 2]`
- Input: `target = 7, nums = [2, 4]` → Output: `null`

### Recursive

**Time:** O(N^T * T) **Space:** O(T)

```java
public static List<Integer> howSumRecursive(int target, int[] nums) {
    if (target == 0) {
        return new ArrayList<>();
    }
    if (target < 0) {
        return null;
    }
    for (int num : nums) {
        List<Integer> remainder = howSumRecursive(target - num, nums);
        if (remainder != null) {
            remainder.add(num);
            return remainder;
        }
    }
    return null;
}
```

### Memoization

**Time:** O(N * T * T) **Space:** O(T * T)

```java
public static List<Integer> howSumMemoization(int target, int[] nums) {
    Map<Integer, List<Integer>> memo = new HashMap<>();
    return howSumMemoHelper(target, nums, memo);
}

private static List<Integer> howSumMemoHelper(int target, int[] nums, Map<Integer, List<Integer>> memo) {
    if (memo.containsKey(target)) {
        return memo.get(target);
    }
    if (target == 0) {
        return new ArrayList<>();
    }
    if (target < 0) {
        return null;
    }
    for (int num : nums) {
        List<Integer> remainder = howSumMemoHelper(target - num, nums, memo);
        if (remainder != null) {
            List<Integer> result = new ArrayList<>(remainder);
            result.add(num);
            memo.put(target, result);
            return result;
        }
    }
    memo.put(target, null);
    return null;
}
```

### Tabulation

**Time:** O(N * T * T) **Space:** O(T * T)

```java
public static List<Integer> howSumTabulation(int target, int[] nums) {
    List<List<Integer>> dp = new ArrayList<>(Collections.nCopies(target + 1, null));
    dp.set(0, new ArrayList<>());
    for (int i = 0; i <= target; i++) {
        if (dp.get(i) != null) {
            for (int num : nums) {
                if (i + num <= target) {
                    List<Integer> combination = new ArrayList<>(dp.get(i));
                    combination.add(num);
                    dp.set(i + num, combination);
                }
            }
        }
    }
    return dp.get(target);
}
```

---

## 4. Best Sum

**LeetCode:** Not listed (classic combinatorial DP problem)

**Problem:** Given a target sum and an array of positive numbers (each reusable unlimited times), return the shortest array of numbers that sum exactly to the target. If multiple shortest combinations exist, return any one.

**Test Cases:**
- Input: `target = 8, nums = [1, 4, 5]` → Output: `[4, 4]`
- Input: `target = 100, nums = [1, 2, 5, 25]` → Output: `[25, 25, 25, 25]`

### Recursive

**Time:** O(N^T * T) **Space:** O(T)

```java
public static List<Integer> bestSumRecursive(int target, int[] nums) {
    if (target == 0) {
        return new ArrayList<>();
    }
    if (target < 0) {
        return null;
    }
    List<Integer> shortest = null;
    for (int num : nums) {
        List<Integer> remainder = bestSumRecursive(target - num, nums);
        if (remainder != null) {
            List<Integer> combination = new ArrayList<>(remainder);
            combination.add(num);
            if (shortest == null || combination.size() < shortest.size()) {
                shortest = combination;
            }
        }
    }
    return shortest;
}
```

### Memoization

**Time:** O(N * T * T) **Space:** O(T * T)

```java
public static List<Integer> bestSumMemoization(int target, int[] nums) {
    Map<Integer, List<Integer>> memo = new HashMap<>();
    return bestSumMemoHelper(target, nums, memo);
}

private static List<Integer> bestSumMemoHelper(int target, int[] nums, Map<Integer, List<Integer>> memo) {
    if (memo.containsKey(target)) {
        return memo.get(target);
    }
    if (target == 0) {
        return new ArrayList<>();
    }
    if (target < 0) {
        return null;
    }
    List<Integer> shortest = null;
    for (int num : nums) {
        List<Integer> remainder = bestSumMemoHelper(target - num, nums, memo);
        if (remainder != null) {
            List<Integer> combination = new ArrayList<>(remainder);
            combination.add(num);
            if (shortest == null || combination.size() < shortest.size()) {
                shortest = combination;
            }
        }
    }
    memo.put(target, shortest);
    return shortest;
}
```

### Tabulation

**Time:** O(N * T * T) **Space:** O(T * T)

```java
public static List<Integer> bestSumTabulation(int target, int[] nums) {
    List<List<Integer>> dp = new ArrayList<>(Collections.nCopies(target + 1, null));
    dp.set(0, new ArrayList<>());
    for (int i = 0; i <= target; i++) {
        if (dp.get(i) != null) {
            for (int num : nums) {
                if (i + num <= target) {
                    List<Integer> combination = new ArrayList<>(dp.get(i));
                    combination.add(num);
                    if (dp.get(i + num) == null || combination.size() < dp.get(i + num).size()) {
                        dp.set(i + num, combination);
                    }
                }
            }
        }
    }
    return dp.get(target);
}
```

---

## 5. Climbing Stairs

**LeetCode:** 70

**Problem:** Given `n` stairs, where each move climbs either 1 or 2 steps, count the number of distinct ways to reach the top.

**Test Cases:**
- Input: `n = 2` → Output: `2`
- Input: `n = 3` → Output: `3`

### Recursive

**Time:** O(2^N) **Space:** O(N)

```java
public static int climbStairsRecursive(int n) {
    if (n <= 2) {
        return n;
    }
    return climbStairsRecursive(n - 1) + climbStairsRecursive(n - 2);
}
```

### Memoization

**Time:** O(N) **Space:** O(N)

```java
public static int climbStairsMemoization(int n) {
    Integer[] memo = new Integer[n + 1];
    return climbStairsMemoHelper(n, memo);
}

private static int climbStairsMemoHelper(int n, Integer[] memo) {
    if (n <= 2) {
        return n;
    }
    if (memo[n] != null) {
        return memo[n];
    }
    memo[n] = climbStairsMemoHelper(n - 1, memo) + climbStairsMemoHelper(n - 2, memo);
    return memo[n];
}
```

### Tabulation

**Time:** O(N) **Space:** O(N)

```java
public static int climbStairsTabulation(int n) {
    if (n <= 2) {
        return n;
    }
    int[] dp = new int[n + 1];
    dp[1] = 1;
    dp[2] = 2;
    for (int i = 3; i <= n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
}
```

### Space Optimized

**Time:** O(N) **Space:** O(1)

```java
public static int climbStairsOptimized(int n) {
    if (n <= 2) {
        return n;
    }
    int prev2 = 1;
    int prev1 = 2;
    int current = 0;
    for (int i = 3; i <= n; i++) {
        current = prev1 + prev2;
        prev2 = prev1;
        prev1 = current;
    }
    return current;
}
```

---

## 6. House Robber

**LeetCode:** 198

**Problem:** Given an array of non-negative integers representing money in each house arranged in a line, find the maximum amount that can be robbed without robbing two adjacent houses.

**Test Cases:**
- Input: `nums = [1, 2, 3, 1]` → Output: `4`
- Input: `nums = [2, 7, 9, 3, 1]` → Output: `12`

### Recursive

**Time:** O(2^N) **Space:** O(N)

```java
public static int robRecursive(int[] nums) {
    return robRecursiveHelper(nums, nums.length - 1);
}

private static int robRecursiveHelper(int[] nums, int i) {
    if (i < 0) {
        return 0;
    }
    int skip = robRecursiveHelper(nums, i - 1);
    int take = robRecursiveHelper(nums, i - 2) + nums[i];
    return Math.max(skip, take);
}
```

### Memoization

**Time:** O(N) **Space:** O(N)

```java
public static int robMemoization(int[] nums) {
    Integer[] memo = new Integer[nums.length];
    return robMemoHelper(nums, nums.length - 1, memo);
}

private static int robMemoHelper(int[] nums, int i, Integer[] memo) {
    if (i < 0) {
        return 0;
    }
    if (memo[i] != null) {
        return memo[i];
    }
    int skip = robMemoHelper(nums, i - 1, memo);
    int take = robMemoHelper(nums, i - 2, memo) + nums[i];
    memo[i] = Math.max(skip, take);
    return memo[i];
}
```

### Tabulation

**Time:** O(N) **Space:** O(N)

```java
public static int robTabulation(int[] nums) {
    if (nums.length == 0) {
        return 0;
    }
    if (nums.length == 1) {
        return nums[0];
    }
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);
    for (int i = 2; i < nums.length; i++) {
        dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
    }
    return dp[nums.length - 1];
}
```

### Space Optimized

**Time:** O(N) **Space:** O(1)

```java
public static int robOptimized(int[] nums) {
    int prev2 = 0;
    int prev1 = 0;
    for (int num : nums) {
        int current = Math.max(prev1, prev2 + num);
        prev2 = prev1;
        prev1 = current;
    }
    return prev1;
}
```

---

## 7. Jump Game

**LeetCode:** 55

**Problem:** Given an array `nums` where `nums[i]` is the maximum jump length from index `i`, determine whether the last index is reachable starting from index 0.

**Test Cases:**
- Input: `nums = [2, 3, 1, 1, 4]` → Output: `true`
- Input: `nums = [3, 2, 1, 0, 4]` → Output: `false`

### Recursive

**Time:** O(2^N) **Space:** O(N)

```java
public static boolean canJumpRecursive(int[] nums) {
    return canJumpRecursiveHelper(nums, 0);
}

private static boolean canJumpRecursiveHelper(int[] nums, int position) {
    if (position >= nums.length - 1) {
        return true;
    }
    int furthest = Math.min(position + nums[position], nums.length - 1);
    for (int next = position + 1; next <= furthest; next++) {
        if (canJumpRecursiveHelper(nums, next)) {
            return true;
        }
    }
    return false;
}
```

### Memoization

**Time:** O(N^2) **Space:** O(N)

```java
public static boolean canJumpMemoization(int[] nums) {
    Boolean[] memo = new Boolean[nums.length];
    memo[nums.length - 1] = true;
    return canJumpMemoHelper(nums, 0, memo);
}

private static boolean canJumpMemoHelper(int[] nums, int position, Boolean[] memo) {
    if (memo[position] != null) {
        return memo[position];
    }
    int furthest = Math.min(position + nums[position], nums.length - 1);
    boolean reachable = false;
    for (int next = position + 1; next <= furthest; next++) {
        if (canJumpMemoHelper(nums, next, memo)) {
            reachable = true;
            break;
        }
    }
    memo[position] = reachable;
    return reachable;
}
```

### Tabulation

**Time:** O(N^2) **Space:** O(N)

```java
public static boolean canJumpTabulation(int[] nums) {
    boolean[] dp = new boolean[nums.length];
    dp[nums.length - 1] = true;
    for (int i = nums.length - 2; i >= 0; i--) {
        int furthest = Math.min(i + nums[i], nums.length - 1);
        for (int next = i + 1; next <= furthest; next++) {
            if (dp[next]) {
                dp[i] = true;
                break;
            }
        }
    }
    return dp[0];
}
```

### Optimal Greedy

**Time:** O(N) **Space:** O(1)

```java
public static boolean canJumpOptimized(int[] nums) {
    int lastReachable = nums.length - 1;
    for (int i = nums.length - 2; i >= 0; i--) {
        if (i + nums[i] >= lastReachable) {
            lastReachable = i;
        }
    }
    return lastReachable == 0;
}
```

---

## 8. Edit Distance

**LeetCode:** 72

**Problem:** Given two strings `word1` and `word2`, return the minimum number of insert, delete, or replace operations required to convert `word1` into `word2`.

**Test Cases:**
- Input: `word1 = "horse", word2 = "ros"` → Output: `3`
- Input: `word1 = "intention", word2 = "execution"` → Output: `5`

### Recursive

**Time:** O(3^(M+N)) **Space:** O(M + N)

```java
public static int editDistanceRecursive(String word1, String word2) {
    return editDistanceRecursiveHelper(word1, word2, word1.length(), word2.length());
}

private static int editDistanceRecursiveHelper(String word1, String word2, int i, int j) {
    if (i == 0) {
        return j;
    }
    if (j == 0) {
        return i;
    }
    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
        return editDistanceRecursiveHelper(word1, word2, i - 1, j - 1);
    }
    int insertOp = editDistanceRecursiveHelper(word1, word2, i, j - 1);
    int deleteOp = editDistanceRecursiveHelper(word1, word2, i - 1, j);
    int replaceOp = editDistanceRecursiveHelper(word1, word2, i - 1, j - 1);
    return 1 + Math.min(insertOp, Math.min(deleteOp, replaceOp));
}
```

### Memoization

**Time:** O(M * N) **Space:** O(M * N)

```java
public static int editDistanceMemoization(String word1, String word2) {
    Integer[][] memo = new Integer[word1.length() + 1][word2.length() + 1];
    return editDistanceMemoHelper(word1, word2, word1.length(), word2.length(), memo);
}

private static int editDistanceMemoHelper(String word1, String word2, int i, int j, Integer[][] memo) {
    if (i == 0) {
        return j;
    }
    if (j == 0) {
        return i;
    }
    if (memo[i][j] != null) {
        return memo[i][j];
    }
    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
        memo[i][j] = editDistanceMemoHelper(word1, word2, i - 1, j - 1, memo);
        return memo[i][j];
    }
    int insertOp = editDistanceMemoHelper(word1, word2, i, j - 1, memo);
    int deleteOp = editDistanceMemoHelper(word1, word2, i - 1, j, memo);
    int replaceOp = editDistanceMemoHelper(word1, word2, i - 1, j - 1, memo);
    memo[i][j] = 1 + Math.min(insertOp, Math.min(deleteOp, replaceOp));
    return memo[i][j];
}
```

### Tabulation

**Time:** O(M * N) **Space:** O(M * N)

```java
public static int editDistanceTabulation(String word1, String word2) {
    int m = word1.length();
    int n = word2.length();
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 0; i <= m; i++) {
        dp[i][0] = i;
    }
    for (int j = 0; j <= n; j++) {
        dp[0][j] = j;
    }
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                dp[i][j] = dp[i - 1][j - 1];
            } else {
                dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
            }
        }
    }
    return dp[m][n];
}
```

### Space Optimized

**Time:** O(M * N) **Space:** O(N)

```java
public static int editDistanceOptimized(String word1, String word2) {
    int m = word1.length();
    int n = word2.length();
    int[] previous = new int[n + 1];
    int[] current = new int[n + 1];
    for (int j = 0; j <= n; j++) {
        previous[j] = j;
    }
    for (int i = 1; i <= m; i++) {
        current[0] = i;
        for (int j = 1; j <= n; j++) {
            if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                current[j] = previous[j - 1];
            } else {
                current[j] = 1 + Math.min(current[j - 1], Math.min(previous[j], previous[j - 1]));
            }
        }
        int[] temp = previous;
        previous = current;
        current = temp;
    }
    return previous[n];
}
```

---

## 9. Longest Increasing Subsequence

**LeetCode:** 300

**Problem:** Given an integer array `nums`, return the length of the longest strictly increasing subsequence.

**Test Cases:**
- Input: `nums = [10, 9, 2, 5, 3, 7, 101, 18]` → Output: `4`
- Input: `nums = [0, 1, 0, 3, 2, 3]` → Output: `4`

### Recursive

**Time:** O(2^N) **Space:** O(N)

```java
public static int lisRecursive(int[] nums) {
    return lisRecursiveHelper(nums, -1, 0);
}

private static int lisRecursiveHelper(int[] nums, int previousIndex, int currentIndex) {
    if (currentIndex == nums.length) {
        return 0;
    }
    int taken = 0;
    if (previousIndex < 0 || nums[currentIndex] > nums[previousIndex]) {
        taken = 1 + lisRecursiveHelper(nums, currentIndex, currentIndex + 1);
    }
    int notTaken = lisRecursiveHelper(nums, previousIndex, currentIndex + 1);
    return Math.max(taken, notTaken);
}
```

### Memoization

**Time:** O(N^2) **Space:** O(N^2)

```java
public static int lisMemoization(int[] nums) {
    Integer[][] memo = new Integer[nums.length][nums.length + 1];
    return lisMemoHelper(nums, -1, 0, memo);
}

private static int lisMemoHelper(int[] nums, int previousIndex, int currentIndex, Integer[][] memo) {
    if (currentIndex == nums.length) {
        return 0;
    }
    if (memo[currentIndex][previousIndex + 1] != null) {
        return memo[currentIndex][previousIndex + 1];
    }
    int taken = 0;
    if (previousIndex < 0 || nums[currentIndex] > nums[previousIndex]) {
        taken = 1 + lisMemoHelper(nums, currentIndex, currentIndex + 1, memo);
    }
    int notTaken = lisMemoHelper(nums, previousIndex, currentIndex + 1, memo);
    memo[currentIndex][previousIndex + 1] = Math.max(taken, notTaken);
    return memo[currentIndex][previousIndex + 1];
}
```

### Tabulation

**Time:** O(N^2) **Space:** O(N)

```java
public static int lisTabulation(int[] nums) {
    int n = nums.length;
    int[] dp = new int[n];
    Arrays.fill(dp, 1);
    int longest = 1;
    for (int i = 1; i < n; i++) {
        for (int j = 0; j < i; j++) {
            if (nums[i] > nums[j]) {
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        longest = Math.max(longest, dp[i]);
    }
    return longest;
}
```

### Optimal — Binary Search

**Time:** O(N log N) **Space:** O(N)

```java
public static int lisOptimized(int[] nums) {
    int[] tails = new int[nums.length];
    int size = 0;
    for (int num : nums) {
        int low = 0;
        int high = size;
        while (low != high) {
            int mid = (low + high) / 2;
            if (tails[mid] < num) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        tails[low] = num;
        if (low == size) {
            size++;
        }
    }
    return size;
}
```

---

## 10. Smart Thief (House Robber II)

**LeetCode:** 213

**Problem:** Houses are arranged in a circle, so the first and last houses are adjacent. Find the maximum amount that can be robbed without robbing two adjacent houses.

**Test Cases:**
- Input: `nums = [2, 3, 2]` → Output: `3`
- Input: `nums = [1, 2, 3, 1]` → Output: `4`

### Recursive

**Time:** O(2^N) **Space:** O(N)

```java
public static int robCircularRecursive(int[] nums) {
    if (nums.length == 1) {
        return nums[0];
    }
    int excludeLast = robRangeRecursive(nums, 0, nums.length - 2);
    int excludeFirst = robRangeRecursive(nums, 1, nums.length - 1);
    return Math.max(excludeLast, excludeFirst);
}

private static int robRangeRecursive(int[] nums, int start, int i) {
    if (i < start) {
        return 0;
    }
    int skip = robRangeRecursive(nums, start, i - 1);
    int take = robRangeRecursive(nums, start, i - 2) + nums[i];
    return Math.max(skip, take);
}
```

### Optimal — Two Linear Passes

**Time:** O(N) **Space:** O(1)

```java
public static int robCircularOptimized(int[] nums) {
    if (nums.length == 1) {
        return nums[0];
    }
    int excludeLast = robRangeOptimized(nums, 0, nums.length - 2);
    int excludeFirst = robRangeOptimized(nums, 1, nums.length - 1);
    return Math.max(excludeLast, excludeFirst);
}

private static int robRangeOptimized(int[] nums, int start, int end) {
    int prev2 = 0;
    int prev1 = 0;
    for (int i = start; i <= end; i++) {
        int current = Math.max(prev1, prev2 + nums[i]);
        prev2 = prev1;
        prev1 = current;
    }
    return prev1;
}
```

---

## 11. Longest Common Subsequence

**LeetCode:** 1143

**Problem:** Given two strings `text1` and `text2`, return the length of their longest common subsequence. A subsequence preserves relative order but need not be contiguous.

**Test Cases:**
- Input: `text1 = "abcde", text2 = "ace"` → Output: `3`
- Input: `text1 = "abc", text2 = "abc"` → Output: `3`

### Recursive

**Time:** O(2^min(M,N)) **Space:** O(M + N)

```java
public static int lcsRecursive(String text1, String text2) {
    return lcsRecursiveHelper(text1, text2, text1.length() - 1, text2.length() - 1);
}

private static int lcsRecursiveHelper(String text1, String text2, int i, int j) {
    if (i < 0 || j < 0) {
        return 0;
    }
    if (text1.charAt(i) == text2.charAt(j)) {
        return 1 + lcsRecursiveHelper(text1, text2, i - 1, j - 1);
    }
    int skipFirst = lcsRecursiveHelper(text1, text2, i - 1, j);
    int skipSecond = lcsRecursiveHelper(text1, text2, i, j - 1);
    return Math.max(skipFirst, skipSecond);
}
```

### Memoization

**Time:** O(M * N) **Space:** O(M * N)

```java
public static int lcsMemoization(String text1, String text2) {
    Integer[][] memo = new Integer[text1.length()][text2.length()];
    return lcsMemoHelper(text1, text2, text1.length() - 1, text2.length() - 1, memo);
}

private static int lcsMemoHelper(String text1, String text2, int i, int j, Integer[][] memo) {
    if (i < 0 || j < 0) {
        return 0;
    }
    if (memo[i][j] != null) {
        return memo[i][j];
    }
    if (text1.charAt(i) == text2.charAt(j)) {
        memo[i][j] = 1 + lcsMemoHelper(text1, text2, i - 1, j - 1, memo);
        return memo[i][j];
    }
    int skipFirst = lcsMemoHelper(text1, text2, i - 1, j, memo);
    int skipSecond = lcsMemoHelper(text1, text2, i, j - 1, memo);
    memo[i][j] = Math.max(skipFirst, skipSecond);
    return memo[i][j];
}
```

### Tabulation

**Time:** O(M * N) **Space:** O(M * N)

```java
public static int lcsTabulation(String text1, String text2) {
    int m = text1.length();
    int n = text2.length();
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                dp[i][j] = dp[i - 1][j - 1] + 1;
            } else {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
    }
    return dp[m][n];
}
```

### Space Optimized

**Time:** O(M * N) **Space:** O(N)

```java
public static int lcsOptimized(String text1, String text2) {
    int m = text1.length();
    int n = text2.length();
    int[] previous = new int[n + 1];
    int[] current = new int[n + 1];
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                current[j] = previous[j - 1] + 1;
            } else {
                current[j] = Math.max(previous[j], current[j - 1]);
            }
        }
        int[] temp = previous;
        previous = current;
        current = temp;
    }
    return previous[n];
}
```
