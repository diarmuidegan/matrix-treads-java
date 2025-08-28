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
6 7 5

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

## Matrix Multiplication Rules

Matrix multiplication is possible if the number of columns in `arr1` equals the number of rows in `arr2`.  
To multiply two matrices using the dot product method, the multiplication involves taking the dot product of the rows of the first matrix (`arr1`) with the columns of the second matrix (`arr2`).

The resultant matrix, call it `result`, will also be a 3×3 matrix because both `arr1` and `arr2` are 3×3 matrices.

---

## Step by Step Guide to Multiplying the Matrices (Arrays)

### 1. Calculate `result[0][0]`
- Take the first row of `arr1`: [8, 7, 5]
- Take the first column of `arr2`: [6, 5, 6]
- Perform the dot product:

```
result\[0]\[0] = (8×6) + (7×5) + (5×6)
result\[0]\[0] = 48 + 35 + 30 = 113
```

### 2. Calculate `result[0][1]`
- Take the first row of `arr1`: [8, 7, 5]
- Take the second column of `arr2`: [6, 8, 7]
- Perform the dot product:
```

result\[0]\[1] = (8×6) + (7×8) + (5×7)
result\[0]\[1] = 48 + 56 + 35 = 139

```

### 3. Calculate `result[0][2]`
- Take the first row of `arr1`: [8, 7, 5]
- Take the third column of `arr2`: [1, 1, 5]
- Perform the dot product:
```

result\[0]\[2] = (8×1) + (7×1) + (5×5)
result\[0]\[2] = 8 + 7 + 25 = 40

```

### 4. Calculate `result[1][0]`
- Take the second row of `arr1`: [4, 7, 1]
- Take the first column of `arr2`: [6, 5, 6]
- Perform the dot product:
```

result\[1]\[0] = (4×6) + (7×5) + (1×6)
result\[1]\[0] = 24 + 35 + 6 = 65

```

### 5. Calculate `result[1][1]`
- Take the second row of `arr1`: [4, 7, 1]
- Take the second column of `arr2`: [6, 8, 7]
- Perform the dot product:
```

result\[1]\[1] = (4×6) + (7×8) + (1×7)
result\[1]\[1] = 24 + 56 + 7 = 87

```

### 6. Calculate `result[1][2]`
- Take the second row of `arr1`: [4, 7, 1]
- Take the third column of `arr2`: [1, 1, 5]
- Perform the dot product:
```

result\[1]\[2] = (4×1) + (7×1) + (1×5)
result\[1]\[2] = 4 + 7 + 5 = 16

```

### 7. Calculate `result[2][0]`
- Take the third row of `arr1`: [6, 3, 7]
- Take the first column of `arr2`: [6, 5, 6]
- Perform the dot product:
```

result\[2]\[0] = (6×6) + (3×5) + (7×6)
result\[2]\[0] = 36 + 15 + 42 = 93

```

### 8. Calculate `result[2][1]`
- Take the third row of `arr1`: [6, 3, 7]
- Take the second column of `arr2`: [6, 8, 7]
- Perform the dot product:
```

result\[2]\[1] = (6×6) + (3×8) + (7×7)
result\[2]\[1] = 36 + 24 + 49 = 109

```

### 9. Calculate `result[2][2]`
- Take the third row of `arr1`: [6, 3, 7]
- Take the third column of `arr2`: [1, 1, 5]
- Perform the dot product:
```

result\[2]\[2] = (6×1) + (3×1) + (7×5)
result\[2]\[2] = 6 + 3 + 35 = 44

```

---

## Final Resultant Matrix

```

113  139   40
65   87   16
93  109   44

```

---

The **dot product** is a fundamental operation in linear algebra that serves several purposes in mathematics, physics, engineering, computer science, and other fields.

If the arrays (matrices) are of incompatible sizes for multiplication, the `Callable` should throw an `IllegalArgumentException`.

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

---
