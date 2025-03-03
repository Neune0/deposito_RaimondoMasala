public class EsempioMath{
    public static void main(String[] args) {

        /* Returns the smaller of two int values. 
        That is, the result the argument closer to the value of Integer.MIN_VALUE. 
        If the arguments have the same value, the result is that same value. */
        Math.min(5,5);

        /* Returns the greater of two int values. 
        That is, the result is the argument closer to the value of Integer.MAX_VALUE. 
        If the arguments have the same value, the result is that same value. */
        Math.max(0, 0);

        /* Returns the correctly rounded positive square root of a double value. Special cases:

        If the argument is NaN or less than zero, then the result is NaN.
        If the argument is positive infinity, then the result is positive infinity.
        If the argument is positive zero or negative zero, then the result is the same as the argument.
        Otherwise, the result is the double value closest to the true mathematical square root of the argument value */
        Math.sqrt(1.0);

        /* Returns the absolute value of an int value. 
        If the argument is not negative, the argument is returned. 
        If the argument is negative, the negation of the argument is returned.

        Note that if the argument is equal to the value of Integer.MIN_VALUE, 
        the most negative representable int value, the result is that same value, which is negative. 
        In contrast, the Math.absExact(int) method throws an ArithmeticException for this value. */
        Math.abs(0);

        /* Returns a double value with a positive sign, greater than or equal to 0.0 and less than 1.0. 
        Returned values are chosen pseudorandomly with (approximately) uniform distribution from that range.
        When this method is first called, it creates a single new pseudorandom-number generator, 
        exactly as if by the expression new java.util.Random()
        This new pseudorandom-number generator is used thereafter for all calls to this method and is used nowhere else.
        This method is properly synchronized to allow correct use by more than one thread. 
        However, if many threads need to generate pseudorandom numbers at a great rate, it may reduce contention for each thread 
        to have its own pseudorandom-number generator. */
        Math.random();
    }
}