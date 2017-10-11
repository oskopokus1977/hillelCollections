import edu.hillel.MultiSet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestMultiSet {

    @Test
    public void addTest() {
       MultiSet<Integer> multiSet = new MultiSet<Integer>();
        multiSet.add(1);
        multiSet.add(2);
        multiSet.add(3);
        multiSet.add(3);

        Assert.assertTrue((multiSet.hashMap.get(1) == 1));
        Assert.assertTrue((multiSet.hashMap.get(3) == 2));
    }

    @Test
    public void removeTest(){
        MultiSet<String> multiSet = new MultiSet<String>();
        multiSet.add("Test1");
        multiSet.add("Test2");
        multiSet.add("Test3");
        multiSet.add("Test1");

        Assert.assertTrue((multiSet.hashMap.get("Test1") == 2));
        multiSet.remove("Test1");
        Assert.assertTrue((multiSet.hashMap.get("Test1") == 1));
        multiSet.remove("Test2");
        multiSet.remove("Test2");
    }

    @Test
    public void containsTest(){
        MultiSet<Character> multiSet = new MultiSet<Character>();
        multiSet.add('J');
        multiSet.add('A');
        multiSet.add('V');
        multiSet.add('A');
        Assert.assertEquals(multiSet.contains('A'),2);
        Assert.assertEquals(multiSet.contains('X'),0);
    }
}
