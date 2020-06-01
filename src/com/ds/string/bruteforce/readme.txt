For each possible position in the text T, we check whether the parttern P matches or not. Since the length of T is n, we have n - m + 1 possible choices for comparisons.
This is becuse we do not need to check the last m - 1 locations of T as the pattern
length is m.

Complexity : O(n * m)