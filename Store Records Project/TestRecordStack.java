import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This is a JUnit test case class for RecordStack.
 * It's provided for your convenience in testing your stack.
 * DO NOT MODIFY THE EXISTING CODE IN THIS CLASS.
 * You may add test cases if you wish, by adding 
 * methods that are preceded by @Test
 * But do not edit or delete the existing methods. 
 * @author Dr. Boyer
 *
 */
public class TestRecordStack {

	@Test
	public void testInitializeStack() {
		RecordStack rs = new RecordStack();
		//The initial stack should be made 
		//and should be empty
		assertEquals(true,rs.isEmpty());
		assertEquals(0,rs.size());
	}

	@Test
	public void testPush() {
		RecordStack rs = new RecordStack();
		//Try pushing a null Record
		rs.push(null);
		//Now push a non-null Record
		rs.push(new FortyFive("Author1","Test1Title",1978));
		//Now the size of the stack should be 2
		assertEquals(2,rs.size());
		//Pop one off the top and make sure the author is
		//what it should be
		assertEquals("Author1",rs.pop().getArtist());
		//And now the size should have decreased by 1
		assertEquals(1,rs.size());
		//Pop the next thing off the stack and make sure
		//it is null as it should be (since we pushed null)
		assertEquals(null, rs.pop());
		//Now make sure the size is zero
		assertEquals(0,rs.size());
		//Now make sure if we try to pop from the empty
		//stack we get null (and not a runtime error)
		assertEquals(null,rs.pop());
		//Finally be sure this stack is empty
		assertEquals(true,rs.isEmpty());
	}

	@Test
	public void testStackCapacity() {
		RecordStack rs = new RecordStack();
		//Populate the stack with 100 new albums
		for (int i=0; i < 100; i++) {
			rs.push(new LP("Author"+i, "Title"+i, 2000+i));
			assertEquals(i+1,rs.size());
		}
		//Pick out one and be sure it is what we want
		rs.pop();rs.pop();rs.pop();rs.pop();
		Record r = rs.pop();
		//The fifth-to-last album pushed should now be r
		//Let's check
		assertEquals(2095,r.getYear());
		assertEquals("Author95",r.getArtist());
		assertEquals("Title95",r.getTitle());
	}

}
