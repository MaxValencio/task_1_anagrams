package net.maxvalencio.task_1_anagrams;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
/**
 * Unit test for AnagramImpl.
 */
public class AnagramImplTest {
	
	private AnagramImpl anagram = new AnagramImpl();
	
	@Test
    public void createAnagram_onlyLetters_correct() throws Exception{
		String actual = anagram.createAnagram("abcd efgh");
    	String expected = "dcba hgfe";
    	assertEquals(expected, actual);
    }
	
	@Test
    public void createAnagram_onlyNonLeter_correct() throws Exception{
		String actual = anagram.createAnagram("24234231");
		String expected = "24234231";
    	assertEquals(expected, actual);
    }
	
	@Test
    public void createAnagram_lettersAndNonLetters_correct() throws Exception{
		String actual = anagram.createAnagram("!!tnnn3edu==@#uu31utttS467 si a doog remmargorp! tne4&dut(S 4464 =)");
		String expected = "!!Sttt3uuu==@#ud31ennnt467 is a good programmer! Stu4&den(t 4464 =)";
		assertEquals(expected, actual);
    }
	
	@Test
    public void createAnagram_spaces_correct() throws Exception{
		String actual = anagram.createAnagram("  1                      1");
		String expected = "1 1";
    	assertEquals(expected, actual);
    }
	
	@Test
    public void createAnagram_inputNull_correct() throws Exception{
		String actual = anagram.createAnagram(null);
		String expected = "";
    	assertEquals(expected, actual);
    }	
}
