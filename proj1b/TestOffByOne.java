import org.junit.Test;

import static org.junit.Assert.*;

public class TestOffByOne {

    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testEqualChars() {
        char c = 's';
        char d = ' ';
        assertFalse(offByOne.equalChars(c, d));


        char we = 'A';
        char sd = 'B';
        assertTrue(offByOne.equalChars(we, sd));


        char we2 = 'A';
        char sd2 = 'b';
        assertFalse(offByOne.equalChars(we2, sd2));

        char we3 = ' ';
        char sd3 = '2';
        assertFalse(offByOne.equalChars(we3, sd3));
    }


}
