public class ExceptionExamples {

    /**
     * Tries to read an integer through the standard input
     * If an illegal argument is entered, returns 0
     */
    public static int readInt() {
        In in = new In();
        int ans = 0;
        StdOut.println("Please enter a number.");
        try {
            String s = in.readString();
            ans = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            ans = 0;
        }
        return ans;
    }

    public static int readInt2() {
        int ans = 0;
        boolean legal = false;
        StdOut.println("Please enter a number.");
        In in = new In();
        while (!legal) {
            try {
                String s = in.readString();
                ans = Integer.parseInt(s);
                legal = true;
            } catch (NumberFormatException e) {
                StdOut.println("Invalid argument, try again.");
            }
        }
        return ans;
    }

    /**
     * Tries to read an integer through the standard input
     * If an illegal argument is entered, returns 0
     */
    public static int readInt3() {
        int ans = 0;
        StdOut.println("Please enter a number.");
        In in = new In();
        try {
            String s = in.readString();
            ans = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            ans = 0;
        } finally {
            // will execute always.
            StdOut.println("Exiting readInt3 method.");
        }
        return ans;
    }
}
