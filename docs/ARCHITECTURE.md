# Architecture

The project is intentionally small and consists of three classes.

## `Mononomial`

Represents a single term of a polynomial: a `coeff` (coefficient) and a `power` (exponent), both stored as `double` so the program can support non-integer coefficients and division results. Its `toString()` method renders a term with the correct sign, e.g. `+3x^2`, `-x`, `+5`.

## `Polynomial`

Holds an `ArrayList<Mononomial>` and implements:

- **`StringSeparation(String equation)`** — parses an equation string into terms. It splits on `+`/`-` while preserving the sign of each term, fills in implicit coefficients (`x` → `1x`) and exponents (`3x` → `3x^1`), and builds a `Mononomial` for each term.
- **`addition(Polynomial)` / `subtraction(Polynomial)`** — merge two term lists and combine terms that share the same power. Subtraction is implemented by negating a copy of the other polynomial's coefficients and reusing addition.
- **`additionFunction(ArrayList<Mononomial>)`** — the shared helper that merges terms of equal power and sorts the result by descending power.
- **`multiply(Polynomial)`** — multiplies every term of one polynomial by every term of the other, then merges like powers.
- **`division(Polynomial)`** — implements standard polynomial long division: at each step it divides the leading terms, multiplies the divisor by that quotient term, and subtracts the result from the remainder, until the remainder's degree is lower than the divisor's. Prints the quotient and returns the remainder.
- **`evaluate(double x)`** — substitutes `x` into every term and sums the results.
- **`sortByPower(ArrayList<Mononomial>)`** — a simple selection sort that orders terms by descending power, used so that `toString()` and the division algorithm see terms in a predictable order.

## `mainClass`

The entry point. Reads an initial polynomial, then loops on a text menu, reading a second polynomial (when needed) and dispatching to the matching `Polynomial` method.

## Design notes

- Parsing and data representation are deliberately simple (no abstract syntax tree, no external parsing library) since the only supported variable is `x` and the grammar is a flat sum of terms.
- All arithmetic operations return a new `Polynomial` (except `division`, which mutates and returns `this` as the remainder) so operations can, in principle, be chained.
