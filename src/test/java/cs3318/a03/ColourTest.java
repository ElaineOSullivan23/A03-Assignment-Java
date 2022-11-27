package cs3318.a03;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 * Test for Colour class.
 * Tests that valid inputs and outputs for the colour object
 * Test if colour object takes one combined RGB value parameter with 16-23 red component bits, 8-15 green component bits and 0-7 blue component bits
 * Test if colour object constructor takes three parameters within range of 0.0 to 1.0
 * test if colour object constructor parameters are out of range
 * Test if colour object constructor parameters are out of range
 * Test if red component bits are from 16-23
 * Test if green component bits are from 8-15
 * Test if blue component bits are from 0-7
 * Test it is not allowed to create a Colour object without specifying valid red, green and blue component values
 * Test that it is not allowed to create a Colour object without valid red bit component values from 16-23, green bit component values from 8-15 and blue bit component values from 0-7
 * Test if two colours are compared and they contain same values, they will be equal
 * Test if two colours are compared and they contain different values, they will not be equal
 * Test if two colours contains different RGB components they are not equal.
 * test hash code is working.
 *
 * @author Elaine O#Sullivan
 * @version 1.0
 */
class ColourTest {
    Colour ColourTest;
    @Test
    @DisplayName("Tests inputs and outputs of test colour object")
    void testInputsAndOutputs(){
        float RedValue = 0.0f;
        float GreenValue = 0.0f;
        float BlueValue = 0.0f;


        ColourTest = new Colour(RedValue,GreenValue,BlueValue);
        assertEquals(0.0f, ColourTest.getRed());
        assertEquals(0.0f, ColourTest.getGreen());
        assertEquals(0.0f, ColourTest.getBlue());
    }
    @Test
    @DisplayName("Test if colour object takes one combined RGB value parameter with 16-23 red component bits, 8-15 green component bits and 0-7 blue component bits")
    void testColourObjectTakesOneParameter() {
        ColourTest = new Colour(0xFFEEDD);
        assertEquals(0xFF, ColourTest.getRed());
        assertEquals(0xEE, ColourTest.getGreen());
        assertEquals(0xDD, ColourTest.getBlue());

    }
    @Test
    @DisplayName("Test if colour object constructor takes three parameters within range of 0.0 to 1.0")
    void testColourConstructorWithinRangeReturnsColour() {

        ColourTest = new Colour(0.1f, 0.1f, 0.1f);
        assertEquals(0.1f, ColourTest.getRed());
        assertEquals(0.1f, ColourTest.getGreen());
        assertEquals(0.1f, ColourTest.getBlue());

    }
    @Test
    @DisplayName("test if colour object constructor parameters are out of range")
    void testColourConstructorOutOfRange1(){
        assertThrows(IllegalArgumentException.class, () -> new Colour(1.1f, 1.1f, 1.1f));

    }

    @Test
    @DisplayName("Test if colour object constructor parameters are out of range")
    void testColourConstructorOutOfRange2() {
        assertThrows(IllegalArgumentException.class, () -> new Colour(-0.1f, -0.1f, -0.1f));

    }

    @Test
    @DisplayName("Test if red component bits are from 16-23")
    void testRedComponentBits() {
        ColourTest = new Colour(0x112233);
        assertEquals(0x11, ColourTest.getRed());

    }
    @Test
    @DisplayName("Test if green component bits are from 8-15")
    void testGreenComponentBits() {
        ColourTest = new Colour(0x112233);
        assertEquals(0x22, ColourTest.getGreen());

    }

    @Test
    @DisplayName("Test if blue component bits are from 0-7")
    void testBlueComponentBits() {
        ColourTest = new Colour(0x112233);
        assertEquals(0x33, ColourTest.getBlue());

    }

    @Test
    @DisplayName("Test it is not allowed to create a Colour object without specifying valid red, green and blue component values.")
    void testIfFloatColourComponentsAreInvalid() {
        assertThrows(IllegalArgumentException.class, () -> new Colour(-0.1f, -0.2f, -0.3f));
        assertThrows(IllegalArgumentException.class, () -> new Colour(1.1f, 1.1f, 1.1f));

    }

    @Test
    @DisplayName("Test that it is not allowed to create a Colour object without valid red bit component values from 16-23, green bit component values from 8-15 and blue bit component values from 0-7")
    void testIfColourComponentBitValuesAreInvalid() {
        assertThrows(IllegalArgumentException.class, () -> new Colour(16, 8, 0));

    }

    @Test
    @DisplayName("Test if two colours are compared and they contain same values, they will be equal")
    public void testColourContainsSameValuesAreEqual() {
        Colour ColourTestA = new Colour(0.1f, 0.1f, 0.1f);
        Colour ColourTestB = new Colour(0.1f, 0.1f, 0.1f);
        Colour ColourTestC = new Colour(0.1f, 0.1f, 0.1f);
        assertTrue(ColourTestA.equals(ColourTestB));
        assertTrue(ColourTestA.equals(ColourTestC));
        assertTrue(ColourTestB.equals(ColourTestC));

    }


    @Test
    @DisplayName("Test if two colours are compared and they contain different values, they will not be equal")
    public void testColourContainsDifferentValuesAreNotEqual() {
        Colour ColourTestA = new Colour(0.1f, 0.1f, 0.1f);
        Colour ColourTestB = new Colour(0.2f, 0.2f, 0.2f);
        Colour ColourTestC = new Colour(0.3f, 0.3f, 0.3f);
        assertFalse(ColourTestA.equals(ColourTestB));
        assertFalse(ColourTestA.equals(ColourTestC));
        assertFalse(ColourTestB.equals(ColourTestC));

    }

    @Test
    @DisplayName("Test if two colours contains different RGB components they are not equal")
    void testColourContainsDifferentRGBComponentsNotEqual() {
        Colour ColourTestA = new Colour(0x010101);
        Colour ColourTestB = new Colour(0x020202);
        assertFalse(ColourTestA.equals(ColourTestB));
    }

    @Test
    @DisplayName("test hash code is working")
    void testHashCodeIsWorking() {
        ColourTest = new Colour(0.2f, 0.2f, 0.2f);
        assertEquals(ColourTest.hashCode(), Float.floatToIntBits(0.2f) + Float.floatToIntBits(0.2f) + Float.floatToIntBits(0.2f));
    }



}









