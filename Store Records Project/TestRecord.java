import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Place this file in the same package as your 
 * Record class. DO NOT MODIFY this code. 
 * @author Dr. Boyer 
 *
 */
public class TestRecord
{

	@Test
	public void test45Constructor() {
		FortyFive ep = new FortyFive("Lucy Starnight",
				"Easy Blues",3042);
		assertEquals("Lucy Starnight",ep.getArtist());
		assertEquals("Easy Blues",ep.getTitle());
		assertEquals(3042,ep.getYear());
	}

	@Test
	public void testLPConstructor() {
		LP lp = new LP("Bob Starnight",
				"Up-Tempo Blues",3043);
		assertEquals("Bob Starnight",lp.getArtist());
		assertEquals("Up-Tempo Blues",lp.getTitle());
		assertEquals(3043,lp.getYear());
	}

	@Test
	public void test45Inheritance() {
		Record r = new FortyFive("Lucy Starnight",
				"Easy Blues",3042);
		assertEquals("Lucy Starnight", r.getArtist());
	}

	@Test
	public void testLPInheritance() {
		Record r = new LP("Bob Starnight",
				"Up-Tempo Blues",3043);
		assertEquals(3043,r.getYear());
	}

	@Test
	public void testToString() {
		Record r = new LP("Bob Starnight",
				"Up-Tempo Blues",3043);
		assertEquals("LP: Up-Tempo Blues by Bob Starnight, 3043",
				r.toString());
		Record r2 = new FortyFive("Max Galaxos",
				"Electronic Dance Music 3",2989);
		assertEquals("45: Electronic Dance Music 3 by Max Galaxos, 2989",
				r2.toString());
	}
}

