# Subset sum equal to K

- Problem : Check if array contains a subset whose sum is equal to K

- Solution : 
    - Try out all combinations of subset. Form a DP[N+1][targetSum+1];
    - Include / Exclude principle.

# Equal Sum partition

- Problem : Check if array can be divided into two subsets of equal sum.

- Solution :
    - Array can be divided of subsets of equal sum if totalArraySum = Even. 
    - If totalArraySum = Odd, straightAway return false.
    - If even, check if Array has a subset whose sum is equal to totalArraySum / 2;

# Minimum subset sum difference

- Problem : Divide the array into two parts such that difference between the two
subsets is minimum

- Solution :
    - We get the minimal subset sum difference if we have a subset whose sum = ```totalArraySum/2```.
    - So we should find the closest sum of subset in given array to ```target = totalArraySum/2```.
    - Then the minDiff would be ``` minDiff = (target - closeSum) - closeSum```.


