# Programming Fundamentals – Exam Question

In the starter code that is available for this exam (see *Main_Starter.java*), two 2-dimensional arrays are created. Both arrays have 3 rows and 3 columns. The elements in both arrays are initialised with random integer values in the range 1–50.  
The first array has the variable name `arr1`, while the second array has the variable name `arr2`.

You are required to provide solutions for the following three tasks:

---

## Task One

Write and run a **Runnable** that accepts `arr1` as an argument. The Runnable should calculate a **frequency distribution** of each unique integer in `arr1`, and indicate how many times each integer appears.

The output should list each unique integer alongside the number of times it appears in `arr1`. For example:

```

arr1:
8 7 5
7 1 6
3 7 8

1 appears 1 time in the matrix.
3 appears 1 time in the matrix.
5 appears 1 time in the matrix.
6 appears 1 time in the matrix.
7 appears 3 times in the matrix.
8 appears 2 times in the matrix.

```

> Note: Only numbers present in `arr1` should be included. Numbers not in the array should be excluded from the frequency distribution.

---

## Task Two

Write and run a **Callable** that accepts two arguments:
- the array `arr1`
- an integer `x`

The Callable should calculate and return the **percentage of elements in `arr1` that are less than or equal to `x`**.

The returned value should be a `Double`, representing the percentage.  
The percentage should be printed to the console (in `Main`), formatted to **1 decimal place**.

Example (if `x = 5`):

```

arr1:
8 7 5
7 1 6
3 7 8

Percentage of elements <= 5: 33.3%

```

---

## Task Three

Compose and execute a **Callable** that takes two parameters, `arr1` and `arr2`.  
The Callable’s objective is to perform **matrix multiplication** on these two arrays (if they are compatible) and return a 2D integer array representing the result.

The resultant array should then be printed in `Main`.

### Example

If `arr1` and `arr2` contain the following values:

```

arr1:
8 7 5
4 7 1
6 3 7

arr2:
6 6 1
5 8 1
5 7 5

```

The resulting matrix (arr1 × arr2) would be:

```

113 139 40
65  87  16
93 109  44

```

---

### Matrix Multiplication Rules

- Matrix multiplication is possible if the number of **columns in arr1** equals the number of **rows in arr2**.
- To multiply two matrices, take the dot product of the rows of the first matrix with the columns of the second.
- The resultant matrix will also be 3×3 since both `arr1` and `arr2` are 3×3.

If the arrays are incompatible, the Callable should throw an `IllegalArgumentException`.

---

## Additional Notes

1. Do **not hard-code** array indices (e.g., `arr1[0][0]`).  
   Use loops to iterate through rows and columns.
2. Your code should be flexible to handle **matrices of any size**, not just 3×3.
3. All three tasks should be submitted to a **suitable ExecutorService** and run concurrently.

---

## Marks Allocation

- **Task 1:** 25 Marks
- **Task 2:** 30 Marks
- **Task 3:** 45 Marks
```

---

Do you want me to also reformat the **step-by-step worked-out multiplication example** (with the dot products written out), or do you just need the exam question cleaned up for Markdown?
