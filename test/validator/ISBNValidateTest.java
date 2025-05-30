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

		/* Cadre 1, 3, 6, 8 et 9*/
	@Test
	public void test1() {
		String ISBN = "Aao1/111-1yyb1-11@11Uoou";
		String expected = "1-111-11111-1";
		Assert.assertEquals(expected, ISBNValidate.tidyISBN10or13InsertingDashes(ISBN));
	}
	
	/* Cadre 2 */
	@Test(expected = IllegalArgumentException.class)
	public void test2() {
		ISBNValidate.tidyISBN10or13InsertingDashes(null);
	}
	/* Cadre 4, 6, 8, 9, 10 */
	@Test()
	public void test3() {
		String ISBN = "a-978-059@6520JK687";
		String expected = "978-0-596-52068-7";
		Assert.assertEquals(expected, ISBNValidate.tidyISBN10or13InsertingDashes(ISBN));
	}
	/* Cadre 11 */
	@Test(expected = IllegalArgumentException.class)
	public void test4() {
		String ISBN = "1111111111111";
		ISBNValidate.tidyISBN10or13InsertingDashes(ISBN);
	}
	/*Cadre 5*/
	@Test(expected = IllegalArgumentException.class)
	public void test5() {
		String ISBN = "11";
		ISBNValidate.tidyISBN10or13InsertingDashes(ISBN);
	}
	/* Cadre 7*/
	@Test(expected = IllegalArgumentException.class)
	public void test6() {
		String ISBN = "9781111111111";
		ISBNValidate.tidyISBN10or13InsertingDashes(ISBN);
	}
}