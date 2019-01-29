package net.maxvalencio.task_1_anagrams;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Unit test for AnagramByCollections.
 */
public class AnagramByCollectionsTest {
	
	@Test
    public void When_AnagramWithoutNonLettersIsEquals_Expect_isTrue() throws Exception{
    	AnagramByCollections anagramByCollections = new AnagramByCollections();
		String s = anagramByCollections.convertToAnagram("abcd efgh");
    	assertEquals("dcba hgfe", s);
    }
	
	@Test
    public void When_AnagramWithNonLettersIsEquals_Expect_isTrue() throws Exception{
		AnagramByCollections anagramByCollections = new AnagramByCollections();
		String s = anagramByCollections.convertToAnagram("a1bcd efg!h");
    	assertEquals("d1cba hgf!e", s);
    }
	
	@Test
    public void When_AnagramIsEquals_Expect_isTrue() throws Exception{
		AnagramByCollections anagramByCollections = new AnagramByCollections();
		String s = anagramByCollections.convertToAnagram("!!Sttt3uuu==@#ud31ennnt467 is a good programmer! Stu4&den(t 4464 =)");
    	assertEquals("!!tnnn3edu==@#uu31utttS467 si a doog remmargorp! tne4&dut(S 4464 =)", s);
    }
	
	@Test
    public void When_AnagramWithManySpacesIsEquals_Expect_isTrue() throws Exception{
		AnagramByCollections anagramByCollections = new AnagramByCollections();
		String s = anagramByCollections.convertToAnagram("  1                      1");
    	assertEquals("1 1", s);
    }
	
}
