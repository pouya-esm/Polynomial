# Usage Guide

Run the program and follow the prompts:

```bash
java -cp bin Polynomial.mainClass
```

The program first asks for a polynomial, then repeatedly shows a menu of operations. For every operation except **Evaluation** and **Exit**, it also asks for a second polynomial to operate with.

## Menu

```
1) Addition
2) Subtraction
3) Multiply
4) Division
5) Evaluation
6) Exit
```

## Examples

### Addition

```
Enter equation: 3x^2+2x-5
Enter your choice: 1
Enter another equation: x^2-2x+1
The result is: +4x^2-4
```

### Subtraction

```
Enter equation: x^3+2x+1
Enter your choice: 2
Enter another equation: x^3+1
The result is: +2x^1
```

### Multiplication

```
Enter equation: x+1
Enter your choice: 3
Enter another equation: x-1
The result is: +1x^2-1
```

### Division

Performs polynomial long division. The quotient is printed, and the method returns the remainder polynomial.

```
Enter equation: x^2-1
Enter your choice: 4
Enter another equation: x-1
Quotient is: [+1x^1, +1]
The remainder is: 0
```

### Evaluation

Computes the value of the polynomial for a given `x`.

```
Enter equation: 2.5x^2+1.5x
Enter your choice: 5
Enter amount of x: 2
The result is: 13.0
```

### Exit

```
Enter your choice: 6
```

Ends the program.
