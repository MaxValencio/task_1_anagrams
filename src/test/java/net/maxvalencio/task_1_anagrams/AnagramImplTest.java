package net.maxvalencio.task_1_anagrams;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import net.maxvalencio.task_1_anagrams.Anagram;
/**
 * Unit test for AnagramImpl.
 */
public class AnagramImplTest {
	
	private Anagram anagram;
	
	@Before 
	public void setUp() {
		anagram = new AnagramImpl();
	}
	
	@Test
    public void When_AnagramWithoutNonLettersIsEquals_Expect_isTrue() throws Exception{
    	assertEquals("dcba hgfe",anagram.createAnagram("abcd efgh") );
    }
	
	@Test
    public void When_AnagramWithNonLettersIsEquals_Expect_isTrue() throws Exception{
    	assertEquals("d1cba hgf!e", anagram.createAnagram("a1bcd efg!h"));
    }
	
	@Test
    public void When_AnagramIsEquals_Expect_isTrue() throws Exception{
    	assertEquals("!!tnnn3edu==@#uu31utttS467 si a doog remmargorp! tne4&dut(S 4464 =)", 
    				anagram.createAnagram("!!Sttt3uuu==@#ud31ennnt467 "
    									 + "is a good programmer! Stu4&den(t 4464 =)"));
    }
	
	@Test
    public void When_AnagramWithManySpacesIsEquals_Expect_isTrue() throws Exception{
    	assertEquals("1 1", anagram.createAnagram("  1                      1"));
    }	
}
