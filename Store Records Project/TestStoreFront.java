import static org.junit.Assert.*;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Test;


public class TestStoreFront {
	
	@Test
	public void testRepairQueue(){
		StoreFront lucysStore = new StoreFront();
		lucysStore.addAlbumToRepair(new LP("Lady Gaga", "Bad Romance", 2009));
		lucysStore.addAlbumToRepair(new FortyFive("Taylor Swift", "1989", 2014));
		assertEquals("LP: Bad Romance by Lady Gaga, 2009\n45: 1989 by Taylor Swift, 2014", lucysStore.printRepairQueue());
		lucysStore.repairAlbum();
		assertEquals("45: 1989 by Taylor Swift, 2014", lucysStore.printRepairQueue());
		lucysStore.repairAlbum();
		assertEquals("", lucysStore.printRepairQueue());
	}
	
	@Test
	public void testAlbumSell(){
		StoreFront lucysStore = new StoreFront();
		lucysStore.addAlbumToSell(new LP("Lady Gaga", "Bad Romance", 2009));
		lucysStore.addAlbumToSell(new FortyFive("Taylor Swift", "1989", 2014));
		assertEquals("You have 1 LP and 1 45.", lucysStore.displayInventory());
		lucysStore.sell45();
		assertEquals("You have 1 LP and 0 45s.", lucysStore.displayInventory());
		lucysStore.sellLP();
		assertEquals("You have 0 LPs and 0 45s.", lucysStore.displayInventory());
	}
}

