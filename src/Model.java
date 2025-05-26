/*
 * Progammer: Conall Lorentz, Charles Damian
 * Dates: May 26-X
*/

public class Model {
    /** Converts a number in some base to base 10
     * @param number - The number to convert to base 10
     * @param base - The base of the number to convert
     * @return - The number in base 10
    */
    public String toCommonBase(String number, int base) {
        int result = 0;

        // For each digit in the number
        for (int i = 0; i < number.length(); i++) {
            // Add the value of the digit multiplied by the base to the power of the position digit (going right from left)
            // Using the first digit in 1101 
            // 1 * 10^3
            // Using the last digit
            // 1 * 10^0
            result += Character.getNumericValue(number.charAt(i)) * Math.pow(base, number.length() - (i + 1));
        }

        return Integer.toString(result); // Return the number now in base 10
    }

    /** Converts some number in base 10 to a given base
     * @param number - The number in base 10 to convert to the given base
     * @param base - The base to convert the number to
     * @return - The number in the given base
    */
    public String toBase(String number, int base) {
        String result = "";

        int quotient = Integer.parseInt(number); // Initially set the quotient to the given number because we want to divide it first
        do {
            result = Integer.toString(quotient % base) + result; // Set the first character in the result to the remainder
            quotient /= base; // Divide the quotient by the base
        } while (quotient != 0); // Loop until the quotient is 0

        return result; // Return the number in the given base
    }
}