# DSA Practice Repository

A comprehensive collection of Data Structures and Algorithms problems solved in Java. This repository contains solutions to various coding problems from platforms like LeetCode, HackerRank, and other competitive programming sites.

## 📁 Project Structure

```
DSA_practise/
├── problems/                          # Main project directory
│   ├── pom.xml                       # Maven configuration
│   ├── src/
│   │   └── main/
│   │       └── java/
│   │           └── org/
│   │               └── aktic/        # Package containing all solutions
│   │                   ├── addDigits/
│   │                   ├── addStrings/
│   │                   ├── coinChange/
│   │                   ├── longestPalindrome/
│   │                   └── ...       # 200+ problem directories
│   └── .gitignore
├── untitled/                         # Compiled classes
└── README.md
```

## 🚀 Features

- **200+ Problems**: Comprehensive collection of DSA problems
- **Java Solutions**: All solutions implemented in Java
- **Maven Project**: Proper project structure with Maven build system
- **Organized Structure**: Each problem in its own package
- **Ready to Run**: Each solution includes a main method for testing

## 📊 Problem Categories

### Arrays & Strings

- `addDigits/` - Add digits until single digit
- `addStrings/` - Add two strings representing numbers
- `addToArrayForm/` - Add to array form of integer
- `backspaceCompare/` - Compare strings after backspace
- `compress/` - String compression
- `longestPalindrome/` - Longest palindromic substring
- `longestCommonPrefix/` - Longest common prefix
- `validAnagram/` - Check if strings are anagrams

### Linked Lists

- `addTwoNumbers/` - Add two numbers represented by linked lists
- `deleteDuplicates/` - Remove duplicates from sorted list
- `deleteMiddle/` - Delete middle node
- `detectCycle/` - Detect cycle in linked list
- `middleNode/` - Find middle node

### Trees & Graphs

- `convertToBST/` - Convert sorted array to BST
- `goodNodes/` - Count good nodes in binary tree
- `leafSimilar/` - Check if leaf sequences are similar
- `maxDepth/` - Maximum depth of binary tree
- `pathSum2/` - Path sum II
- `searchBST/` - Search in binary search tree

### Dynamic Programming

- `coinChange/` - Coin change problem
- `climbStairs/` - Climbing stairs
- `fib/` - Fibonacci number
- `longestCommonSubsequence/` - LCS problem
- `minCostClimbingStairs/` - Minimum cost climbing stairs
- `minPathSum/` - Minimum path sum

### Two Pointers & Sliding Window

- `containerWithMostWater/` - Container with most water
- `longestOnes/` - Maximum consecutive ones III
- `minimumSizeSubarraySum/` - Minimum size subarray sum
- `minimumWindowSubstring/` - Minimum window substring

### Binary Search

- `binarySearch/` - Binary search implementation
- `firstBadVersion/` - First bad version
- `firstOccurrence/` - First occurrence in sorted array

### Stack & Queue

- `asteroidCollision/` - Asteroid collision
- `decodeString/` - Decode string
- `evalRPN/` - Evaluate reverse polish notation
- `validParentheses/` - Valid parentheses

### Hash Tables

- `containsNearbyDuplicate/` - Contains nearby duplicate
- `majorityElement/` - Majority element
- `singleNumber/` - Single number
- `twoSum/` - Two sum

### Math & Bit Manipulation

- `arraySign/` - Array sign
- `bulbSwitch/` - Bulb switcher
- `countingBits/` - Counting bits
- `divide/` - Divide two integers
- `getSum/` - Sum of two integers

### Matrix & 2D Arrays

- `diagonalSum/` - Diagonal sum
- `floodFill/` - Flood fill
- `islandPerimeter/` - Island perimeter
- `matrixReshape/` - Matrix reshape
- `spiralOrder/` - Spiral order traversal

### Greedy Algorithms

- `canJump/` - Jump game
- `eraseOverlapIntervals/` - Non-overlapping intervals
- `findContentChildren/` - Assign cookies
- `gasStation/` - Gas station

## 🛠️ Setup & Installation

### Prerequisites

- Java 22 (as specified in pom.xml)
- Maven 3.6+
- IDE (IntelliJ IDEA, Eclipse, or VS Code)

### Installation Steps

1. **Clone the repository**

   ```bash
   git clone <repository-url>
   cd DSA_practise
   ```

2. **Navigate to the problems directory**

   ```bash
   cd problems
   ```

3. **Build the project**

   ```bash
   mvn clean compile
   ```

4. **Run a specific solution**
   ```bash
   # Example: Run addDigits solution
   mvn exec:java -Dexec.mainClass="org.aktic.addDigits.Solution"
   ```

## 🎯 How to Use

### Running Individual Solutions

Each solution class contains a `main` method for testing. You can run them directly:

```java
// Example: addDigits/Solution.java
public static void main(String[] args) {
    System.out.println(addDigits(38));  // Output: 2
}
```

### Adding New Solutions

1. Create a new directory under `src/main/java/org/aktic/`
2. Name it after the problem (e.g., `newProblem/`)
3. Create `Solution.java` with the following structure:

```java
package org.aktic.newProblem;

public class Solution {
    public static int solve(int[] nums) {
        // Your solution here
        return 0;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(solve(new int[]{1, 2, 3}));
    }
}
```

## 📈 Problem Difficulty Distribution

- **Easy**: ~40% (Basic implementations, simple logic)
- **Medium**: ~45% (Complex algorithms, optimization required)
- **Hard**: ~15% (Advanced concepts, multiple approaches)

## 🔍 Search & Navigation

### By Problem Type

- **Array Problems**: Look for directories with array-related names
- **String Problems**: Search for string manipulation solutions
- **Tree Problems**: Look for BST, tree traversal solutions
- **DP Problems**: Search for dynamic programming solutions

### By Algorithm

- **Two Pointers**: `containerWithMostWater`, `longestOnes`
- **Sliding Window**: `minimumWindowSubstring`, `longestSubarray`
- **Binary Search**: `binarySearch`, `firstBadVersion`
- **DFS/BFS**: `floodFill`, `numIslands`

## 📝 Contributing

1. Fork the repository
2. Create a feature branch
3. Add your solution following the existing structure
4. Include test cases in the main method
5. Submit a pull request

## 🎓 Learning Resources

- [LeetCode](https://leetcode.com/) - Practice problems
- [HackerRank](https://www.hackerrank.com/) - Competitive programming
- [GeeksforGeeks](https://www.geeksforgeeks.org/) - DSA tutorials
- [Algorithms, 4th Edition](https://algs4.cs.princeton.edu/) - Reference book

## 📊 Statistics

- **Total Problems**: 400+
- **Language**: Java
- **Java Version**: 22
- **Build Tool**: Maven
- **Last Updated**: 2025

## 🤝 Support

If you find any issues or have suggestions for improvements, please:

1. Open an issue on GitHub
2. Provide a clear description of the problem
3. Include the problem name and expected behavior

---

**Happy Coding! 🚀**

_Practice makes perfect. Keep solving problems and improving your DSA skills!_
