# fibonacci-number
Recursive approach to solve large Fibonacci Number when n is large

This program calculates F(n) = F(n-1) + F(n-2) in reclusive fashion.
A cache is used, which is implemented with a simple HashMap, to prevent
re-visiting finished answer. Another point to highlight is BigInteger type
is used because the answers is over the maximun value of type Long.
Usage (in console): java Fibonacci { a positive integer }