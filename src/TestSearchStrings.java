import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;

public class TestSearchStrings {
    ArrayList<Character> sToList = new ArrayList<>();

    public void add(){
        sToList.add('A');
        sToList.add('B');
        sToList.add('C');
        sToList.add('D');
    }


    @Test
    public void testType1(){
        SearchStrings s = new SearchStrings();
        assertEquals(2, s.type1("AGCT", "AGCTAGCT"));
    }

    @Test
    public void testDeleteOneCharacter(){


        SearchStrings s = new SearchStrings();
        assertEquals("ABD", s.deleteOneChar(sToList, 2));
    }
    @Test
    public void testType2(){
        SearchStrings s = new SearchStrings();
        assertEquals(3, s.type2("ABCD","ABCDABCDABCD", sToList));
    }


}
