# Polynomial Calculator

A small Java console application for parsing single-variable polynomials from text input and performing basic algebraic operations on them: **addition, subtraction, multiplication, division, and evaluation at a point**.

This project was built as a university assignment to practice object-oriented design, string parsing, and basic data structures (`ArrayList`) in Java.

## Features

- Parses a polynomial directly from a human-readable string, e.g. `3x^2+2x-5`, `-x^3+1`, `x-4`
- Supports integer and decimal coefficients (e.g. `2.5x^2+1.5x`)
- **Addition** — `poly1 + poly2`
- **Subtraction** — `poly1 - poly2`
- **Multiplication** — `poly1 * poly2`
- **Division** — polynomial long division, prints the quotient and returns the remainder
- **Evaluation** — computes the value of the polynomial at a given `x`
- Simple interactive menu driven by `Scanner` (console input)

## Project structure

```
Polynomial/
├── src/
│   └── Polynomial/
│       ├── mainClass.java     # Entry point / interactive console menu
│       ├── Polynomial.java    # Core polynomial logic (parsing, +, -, *, /, evaluate)
│       └── Mononomial.java    # A single term of a polynomial (coefficient + power)
├── docs/
│   ├── USAGE.md                # Example interactive sessions
│   └── ARCHITECTURE.md         # Class design and how the code works
├── .gitignore
└── README.md
```

## Requirements

- Java Development Kit (JDK) 8 or newer (no external dependencies)

## Build & run

From the project root:

```bash
# Compile
mkdir -p bin
javac -d bin src/Polynomial/*.java

# Run
java -cp bin Polynomial.mainClass
```

You can also simply open the project in Eclipse (or any Java IDE) and run `mainClass.java` directly.

## Quick example

```
Enter equation: x^2+2x+1
Which operation do you desire to choose?
1)Addition  2)Subtraction  3)Multiply  4)Division  5)Evaluation  6)Exit
Enter your choice: 1
Enter another equation: x^2-1
The result is: +2x^2+2x
```

See [docs/USAGE.md](docs/USAGE.md) for more detailed examples of every operation, and [docs/ARCHITECTURE.md](docs/ARCHITECTURE.md) for an overview of how the parsing and math are implemented.

## Equation input format

- No spaces are required, but spaces are tolerated and stripped automatically.
- Terms are separated by `+` or `-`.
- A term may omit the coefficient (`x^2` means `1x^2`) or the exponent (`3x` means `3x^1`).
- A constant term has no `x` at all (e.g. `5`, `-5`).

## Known limitations

- Only a single variable (`x`) is supported.
- No input validation: malformed equations (e.g. unbalanced operators, empty input) will raise a runtime exception rather than a friendly error message.
- Division by the zero polynomial is not handled explicitly.
