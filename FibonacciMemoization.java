public class FibonacciMemoization {

    public static long fibonacciMemoization(int n) {
        return fibonacciMemoization(n, new long[n + 1]);
    }

    public static long fibonacciMemoization(int n, long[] fib) {
        // if n is 0 or 1, return n
        if (n == 0 || n == 1) {
            return n;
        }
        // if the Fibonacci number has already been calculated, return it
        if (fib[n] != 0) {
            return fib[n];
        }

        // the Fibonacci number at index n is the sum of the previous two numbers
        fib[n] = fibonacciMemoization(n - 1, fib) + fibonacciMemoization(n - 2, fib);
        return fib[n];
    }
}
