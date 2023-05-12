import static org.junit.Assert.*;
import org.junit.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class IsMoon implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("moon");
  }
}

class lazy implements StringChecker {
  public boolean checkString(String s) {
    if((s.toLowerCase()).contains("tatis"))
      return true;
    else
      return false;
  }
}

public class TestListExamples {
  @Test(timeout = 500)
  public void testMergeRightEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }
  @Test
  public void testFilter() {
      lazy LAZY = new lazy();
      List<String> list = new ArrayList<>();
      List<String> output = new ArrayList<>();
      list.add("tatis1");
      list.add("tatis2");
      list.add( "tatis3");
      output = ListExamples.filter(list, LAZY);
      assertEquals(output.get(0), "tatis1");
  }
  @Test
  public void testMerge() {
      List<String> list1 = new ArrayList<>();
      List<String> list2 = new ArrayList<>();

      list1.add("a");
      list1.add("c");
      list1.add("d");

      list2.add("b");
      list2.add("c");
      list2.add("e");
      List<String> output = ListExamples.merge(list1, list2);
      assertArrayEquals(new String[]{"a", "b", "c", "c", "d", "e"}, output.toArray());
  }
}
