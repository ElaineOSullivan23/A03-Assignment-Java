package cs3318.a03;

/**
 * @author Elaine o#Sullivean
 * @version 1.0
 * Colour class to represent the colours red, green and blue in RGB format
 *
 */
public class Colour {
    private final float redValue;
    private final float greenValue;
    private final float blueValue;

    /**
     *
     * @param redValue will throw exception if value less < 0 o  > 1 is entered.
     * @param greenValue will throw exception if value less < 0 o  > 1 is entered.
     * @param blueValue will throw exception if value less < 0 o  > 1 is entered.
     */
    public Colour(float redValue, float greenValue, float blueValue) {
        if (redValue < 0 || redValue > 1 || greenValue < 0 || greenValue > 1 || blueValue < 0 || blueValue > 1) {
            throw new IllegalArgumentException("Colour Component values are invalid");
        }
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    /**
     *
     * @param rgbValue converting bits to hex
     */
    public Colour(int rgbValue) {
        this.redValue = (rgbValue >> 16) & 0xff;
        this.greenValue = (rgbValue >> 8) & 0xff;
        this.blueValue = rgbValue & 0xff;
    }

    /**
     *
     * @return red value in float format
     */
    public float getRed() {
        return redValue;
    }

    /**
     *
     * @return green value in float format
     */
    public float getGreen() {
        return greenValue;
    }

    /**
     *
     * @return blue value in float format
     */
    public float getBlue() {
        return blueValue;
    }

    /**
     *
     * @param  other parameters for true/false declaration
     * @return true if red, green or blue is entered else returns false
     */
    public boolean equals(Colour other) {
        if (this.redValue == other.redValue && this.greenValue == other.greenValue && this.blueValue == other.blueValue) {
            return true;
        }
        return false;

    }

    /**
     *
     * @return values to show that float parameters are converted correctly
     */
    @Override
    public int hashCode() {
        int result = (redValue != 0.0f ? Float.floatToIntBits(redValue) : 0)
                + (greenValue != 0.0f ? Float.floatToIntBits(greenValue) : 0)
                + (blueValue != 0.0f ? Float.floatToIntBits(blueValue) : 0);
        return result;
    }

    /**
     *
     * @return To String method used to return values entered
     */
    @Override
    public String toString() {
        return "Colour{" +
                "redValue=" + redValue +
                ", greenValue=" + greenValue +
                ", blueValue=" + blueValue +
                '}';
    }

}
