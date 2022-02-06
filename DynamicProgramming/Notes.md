## 1. Longest Common Subsequence

```Problem Statement- Given two sequences, find the length of longest subsequence present in both of them.```

- Intuition
    - Given two strings there are two cases at any point
    - Either two char of string at given point match or dont match.
    - If match -> ```1 + LCS(s1,s2,m-1,n-1);```
    - If dont Match ->``` 1 + max( LCS(s1,s2,m-1,n) or LCS(s1,s2,m,n-1) ) ```

- Example 

    - s1 = "abcde" , s2 = "abex"
    - At F("abcde","abe") we have a match at first point so, our subproblem becomes to solve for F("bcde","bex")
    - At F("cde","ex") we don't match at first point,
    our subproblem becomes to solve for F("cde","x") and
    F("de","ex"). 
    - Out of those subproblem we consider the best one or the maximum one.

- Code

```Java
    //Recursive
    // Time complexity - Worst case - O(2^N) [When no chars in both string match]
    public int LongestCommonSubsequence(String s1,String s2,int m,int n){
        if(m == 0 || n == 0) return 0;

        if(s1.charAt(m - 1) == s2.charAt(n - 1)){
            return 1 + LongestCommonSubsequence(s1,s2,m-1,n-1);
        }

        return Math.max(LongestCommonSubsequence(s1,s2,m-1,n),LongestCommonSubsequence(s1, s2, m, n-1));
    }
    
```

```Java
    //Memoized
    // DP[M][N] 
    //Time complexity - Worst Case - O(m * n)
    //Space complexity - O(m * n) Ignoring stack space
    public int LongestCommonSubsequenceMemo(String s1,String s2,int m,int n,int[][] dp){
        if(m == 0 || n == 0) return 0;

        //If subproblem has already been solved
        if(dp[m][n] != -1){
            return dp[m][n];
        }

        if(s1.charAt(m-1) == s2.charAt(n-1)){
            return dp[m][n] =  1 + LongestCommonSubsequenceMemo(s1, s2, m-1, n-1, dp);
        }

        return dp[m][n] =  Math.max(LongestCommonSubsequenceMemo(s1,s2,m-1,n,dp),
        LongestCommonSubsequenceMemo(s1, s2, m, n-1, dp) );
    }
```

```Java
    //Bottom Up
    //Time complexity - Worst Case - O(m * n)
    //Space complexity - O(m * n)
    public int LongestCommonSubsequenceBottomUp(String s1,String s2){
        int m = s1.length(); int n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 1;i <= m;i++){
            for(int j = 1;j <=n;j++){
                if(s1.charAt(i-1) == s2.charAt(j -1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[m][n];
    }
```

## 2. Matrix Chain Multiplication 

```Problem Statement- Given a sequence of matrices, find the most efficient way to multiply these matrices together. The efficient way is the one that involves the least number of multiplications.```

- Intuition
    - To find minCost of multiplication we have to see out every subproblem of placing brackets at different places.
    - In N matrices we have N - 1/K places to place brackets.
    - We will place brackets at all these K places and solve for every subproblem

- Example
    -  ...|A |B |C |D
    - [10,20,30,40,50] Given matrix dimension where dimension matrix Ai is A[i-1] * A[i].
    - For ex: Matrix A2 or B, the dimension would be 20 x 30;
    - for matrices A,B,C,D with dimension [d0,d1,d2,d3,d4], we could place bracket a 3 places,
    so subproblems would be : 
        - (A)(BCD) 
        - (AB)(CD)
        - (ABC)(D)
    - In Each subproblem we would solve the bracket configurations and eventually multiply the resultant matrices of those configurations. For Ex:-
        - In Subproblem (ABC)(D) , (ABC) would give us a matrix and (D) would give us matrix and eventually we have to multiply these matrix to get our final answer.

    - Generalized Formula

    ``` F(Mat,i,j) = for k in range(i,k) : { MIN[ F(Mat,i,k) + F(Mat,k+1,j) + Mat(i-1) * Mat(k) * Mat(j)] } ```

    ``` i = 1, j = N (Non Exclusive), K = i to j```

    ```java
    //Recursion
    //Time Complexity - worst case - O(2^N) exponential
    int MatrixChainMultiplication(int[] mat,int i,int j){
        if(i == j) return 0;

        int minCostOfMultiplication = Integer.MAX_VALUE;
        for(int k = i;k < j;k++){
            int subAns = mat[i-1] * mat[k] * mat[j] +MatrixChainMultiplication(mat, i, k) + 
            MatrixChainMultiplication(mat, k+1, j);
            
            if(subAns < minCostOfMultiplication){
                minCostOfMultiplication = subAns;
            }
        }

        return minCostOfMultiplication;
    }
    ```

    ```java
    //Memoized
    //Time Complexity - Worst case - O(n*n*k)
    //Space Complexity - O(n*n)
    int MatrixChainMultiplicationMemo(int[] mat,int i,int j,int[][] dp){
        if(i == j) return 0;

        //Overlapping Subproblems
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int minCostOfMultiplication = Integer.MAX_VALUE;
        for(int k = i;k < j;k++){
            int subAns = mat[i-1] * mat[k] * mat[j] + MatrixChainMultiplicationMemo(mat, i, k,dp) + 
            MatrixChainMultiplicationMemo(mat, k+1, j, dp);
            
            if(subAns < minCostOfMultiplication){
                minCostOfMultiplication = subAns;
            }
        }

        return dp[i][j] =  minCostOfMultiplication;
    }
    ```

    ```java
    //Time complexity : O(n*n*k)
    //Space complexity : O(n*n)
    int MatrixChainMultiplicationBottomUp(int[] mat){
        int n = mat.length;
        int[][] dp = new int[n][n];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, Integer.MAX_VALUE));

        for(int g = 1;g < n;g++){
            for(int i = 1,j = g;j < n;i++,j++){
                if(g == 1){
                    dp[i][j] = 0;
                }else{
                    for(int k = i;k < j;k++){
                        int curCost = dp[i][k] + dp[k+1][j] + (mat[i-1] * mat[k] * mat[j]);
                        dp[i][j] = Math.min(dp[i][j],curCost);
                    }
                }
            }
        }


        return dp[1][n-1];
    }
    ```

## 3. Longest Increasing Subsequence

```Problem Statement- Given an integer array, return the length of the longest strictly increasing subsequence.```

- Intuition
    - At every point in array we need to the longest increasing sequence till that point and eventually
    return the maximum one.
    - While going to explore any new number in array just look back where the current number can fit, explore all such possiblities behind the array and add 1 to best of it.

- Example 
    - [10,9,2,5,3,7,101,18]
    -  01,1,1,2,2,3,4,4 -> LIS at each point, so LIS of array is maximum of all possible LIS at
    each point in array i.e. 4 in this case.

```java
    //Tabulation
    //Time Complexity - O(n*n)
    //Space Complexity - O(n)
    static int LongestIncreasingSubsequenceBottomUp(int[] arr){
        int n = arr.length;
        int[] dp = new int[n];
        int lengthOfLongestSubsequence = Integer.MIN_VALUE;

        for(int i = 1;i < n;i++){
            int lengthTillCurrentPoint = 1;
            for(int k = 0;k < i;k++){
                if(arr[k] < arr[i]){
                    lengthTillCurrentPoint = Math.max(lengthTillCurrentPoint, 1 + dp[k]);
                }
            }
            dp[i] = lengthTillCurrentPoint;
            lengthOfLongestSubsequence = Math.max(dp[i],lengthOfLongestSubsequence);    
        }

        return lengthOfLongestSubsequence;
    }
```


```java
    //Tabulation
    static int insertionIndex(int[] arr,int left,int right,int val){
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] == val) return mid;
            else if(arr[mid] > val){ 
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }
    //Time complexity - O(n*log(n))
    //Space complexity - O(N)
    static int LongestIncreasingSubsequenceFaster(int[] arr){
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        int len = 1;

        for(int i = 1;i < n;i++){
            if(arr[i] > dp[len - 1]){
                dp[len++] = arr[i];
            }else{
                int index = insertionIndex(dp,0,len,arr[i]);
                dp[index] = arr[i];
            }
        }

        System.out.println(Arrays.toString(dp));

        return len;
    }
```

## 4. Knapsack 0/1 Bounded

``` Problem Statement : Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. ```

- Intuition
    - To find out the best possiblity to achieve maximum value, we need to try out all combinations of our given weights and value.
    - Every item has two choice, either come in a combination or don't come.
    - Also a item can be part of a choice only if its weight is less than the bag remaining weight.
    - Recursion could help to explore all possibilities.

``` java
    //Recursion
    //Time complexity : O(2^N)
    //Space complexity : O(1) auxiliary space
    static int knapsackBounded(int[] weights,int[] value,int n,int cur,int bagWeight){
        if(cur >= n || bagWeight <= 0){
            return 0;
        }

        if(weights[cur] > bagWeight){
            return knapsackBounded(weights, value, n, cur+1, bagWeight);
        }

        int option1 = knapsackBounded(weights, value, n, cur+1, bagWeight);
        int option2 = value[cur] + knapsackBounded(weights, value, n, cur+1, bagWeight - weights[cur]);
        
        return Math.max(option1, option2);
    }
```

```java
    //Memoized
    //Time complexity : O(n * bagWeight);
    //Space Complexity : O(n * bagWeight);
    static int knapsackBoundedMemo(int[] weights,int[] value,int cur,int bagWeight,int n,int[][] dp){
        if(cur >= n || bagWeight <= 0) return 0;
        
        if(weights[cur] > bagWeight){
            return dp[cur][bagWeight] = knapsackBounded(weights, value, n, cur+1, bagWeight);
        }

        int option1 = knapsackBounded(weights, value, n, cur+1, bagWeight);
        int option2 = value[cur] + knapsackBounded(weights, value, n, cur+1, bagWeight - weights[cur]);
        
        return dp[cur][bagWeight] =  Math.max(option1, option2);
    }
```

```java
    //Tabulation
    //Time complexity : O(n * bagWeight);
    //Space Complexity : O(n * bagWeight);
    static int knapsackBoundedBottomUp(int[] weights,int[] value,int bagWeight){
        int n = value.length;
        int[][] dp = new int[n+1][bagWeight + 1];

        for(int i = 0;i <= n;i++){
            for(int w  = 0;w <= bagWeight;w++){
                if(i == 0 || w == 0){
                    dp[i][w] = 0;
                }else if(weights[i - 1] <= w){
                    int option1 = dp[i-1][w];
                    int option2 = value[i-1] + dp[i-1][w - weights[i-1]];
                    dp[i][w] = Math.max(option1,option2);
                }else{
                    dp[i][w] = dp[i-1][w];
                }

            }
        }

        return dp[n][bagWeight];
    }
```
