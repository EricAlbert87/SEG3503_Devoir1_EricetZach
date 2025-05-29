/**
 * 
 */
package validator;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 */
public class ISBNValidateTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1() {
		String ISBN = "1/111-11-1111";
		String expected = "1-111-11111-1";
		Assert.assertEquals(expected, ISBNValidate.tidyISBN10or13InsertingDashes(ISBN));
	}
	
	// maybe just put Null instead for illegal format
	@Test(expected = IllegalArgumentException.class)
	public void test2() {
		String ISBN = "11@1111111";
		ISBNValidate.tidyISBN10or13InsertingDashes(ISBN);
	}
	/*Cas 3 a 5*/
	@Test()
	public void test3() {
		String ISBN = "0596520689";
		String expected = "0-596-52068-9";
		Assert.assertEquals(expected, ISBNValidate.tidyISBN10or13InsertingDashes(ISBN));
	}
	@Test()
	public void test4() {
		String ISBN = "9780596520687";
		String expected = "978-0-596-52068-7";
		Assert.assertEquals(expected, ISBNValidate.tidyISBN10or13InsertingDashes(ISBN));
	}
	// 13 digit ISBN must start with 978 or 979
	@Test(expected = IllegalArgumentException.class)
	public void test41() {
		String ISBN = "1111111111111";
		ISBNValidate.tidyISBN10or13InsertingDashes(ISBN);
	}
	@Test(expected = IllegalArgumentException.class)
	public void test5() {
		String ISBN = "11";
		ISBNValidate.tidyISBN10or13InsertingDashes(ISBN);
	}
	
	@Test()
	public void test6() {
		String ISBN = "";
	}
	@Test(expected = IllegalArgumentException.class)
	public void test7() {
		String ISBN = "9781111111111";
		ISBNValidate.tidyISBN10or13InsertingDashes(ISBN);
	}
	
	@Test()
	public void test8() {
		String ISBN = "abcd1111111111efg";
		String expected = "1-111-11111-1";
		Assert.assertEquals(expected, ISBNValidate.tidyISBN10or13InsertingDashes(ISBN));
	}
	
	@Test()
	public void test9() {
		String ISBN = "1@1111$111&11";
		String expected = "1-111-11111-1";
		Assert.assertEquals(expected, ISBNValidate.tidyISBN10or13InsertingDashes(ISBN));
	}
}
