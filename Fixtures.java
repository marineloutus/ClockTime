

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class Fixtures.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class Fixtures
{
    private ClockTime clockTim1;
    private ClockTime clockTim2;

    /**
     * Default constructor for test class Fixtures
     */
    public Fixtures()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        
        clockTim1 = new ClockTime();
        clockTim2 = new ClockTime();
        
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    @Test
    public void testFixtures()
    {
        ClockTime clockTim1 = new ClockTime();
        ClockTime clockTim2 = new ClockTime();
        assertEquals(true, clockTim1.equals(clockTim2));
    }

    @Test
    public void checkTime()
    {
        clockTim1.setHour(11);
        assertEquals(11, clockTim1.getHour());
    }
}


