import static org.junit.Assert.*;
import java.util.LinkedList;
import java.util.Queue;
import org.junit.Test;

public class TestInventoryPopulator {

	@Test
	public void test() {
		RecordStack rs = InventoryPopulator.getInitialInventory(
				"/Users/abhishek/Desktop/inventoryinitial.csv");
		assertEquals("Artist4",rs.pop().getArtist());
		assertEquals("Title 3", rs.pop().getTitle());
		assertEquals(2,rs.size());
		rs.pop(); 
		assertEquals(2001,rs.pop().getYear());
		assertEquals(true,rs.isEmpty());
	}
	
	@Test
	public void test2() {
		Queue<Record> rq = InventoryPopulator.getInitialRepairQueue(
				"/Users/abhishek/Desktop/repairinitial.csv");
		assertEquals(4,rq.size());
		assertEquals("Artist1",rq.remove().getArtist());
		assertEquals("Title2", rq.remove().getTitle());
		assertEquals(2,rq.size());
		rq.remove(); 
		assertEquals(2004,rq.remove().getYear());
		assertEquals(true,rq.isEmpty());
	}
	
	@Test
	public void testToString() {
		RecordStack rs = InventoryPopulator.getInitialInventory(
				"/Users/abhishek/Desktop/inventoryinitial.csv");
		assertEquals("LP: Title 4 by Artist4, 2004",
				rs.pop().toString());
		assertEquals("45: Title 3 by Artist3, 2003",
				rs.pop().toString());
	}
}
