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
    public void removeTest() {
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
    public void containsTest() {
        MultiSet<Character> multiSet = new MultiSet<Character>();
        multiSet.add('J');
        multiSet.add('A');
        multiSet.add('V');
        multiSet.add('A');
        Assert.assertEquals(multiSet.contains('A'), 2);
        Assert.assertEquals(multiSet.contains('X'), 0);
    }

    @Test
    public void sizeTest() {
        MultiSet<Character> multiSet = new MultiSet<Character>();
        Assert.assertEquals(multiSet.size(), 0);
        multiSet.add('Y');
        Assert.assertEquals(multiSet.size(), 1);
    }

    @Test
    public void unionTest() {
        MultiSet<Integer> multiSet1 = new MultiSet<Integer>();
        multiSet1.add(-1);
        multiSet1.add(-2);
        multiSet1.add(-2);

        MultiSet<Integer> multiSet2 = new MultiSet<Integer>();
        multiSet2.add(-1);
        multiSet2.add(-1);
        multiSet2.add(-3);

        MultiSet<Integer> unionSet = multiSet1.union(multiSet2);
        Assert.assertTrue(unionSet.hashMap.size() == 3);
    }

    @Test
    public void intersectTest() {
        MultiSet<String> multiSet1 = new MultiSet<String>();
        multiSet1.add("Test1");
        multiSet1.add("Test2");
        multiSet1.add("Test3");

        MultiSet<String> multiSet2 = new MultiSet<String>();
        multiSet2.add("Test3");
        multiSet2.add("Test4");
        multiSet2.add("Test5");

        MultiSet<String> intersectSet = multiSet1.intersect(multiSet2);

        Assert.assertTrue(intersectSet.hashMap.size() == 1);
        Assert.assertEquals(intersectSet.hashMap.get("Test5"), null);
        Assert.assertTrue(intersectSet.hashMap.get("Test3") == 2);
    }

    @Test
    public void uniquSetTest() {
        MultiSet<Character> multiSet = new MultiSet<Character>();
        multiSet.add('J');
        multiSet.add('A');
        multiSet.add('V');
        multiSet.add('A');

        MultiSet<Character> multiSetUniqu = multiSet.uniquSet();
        Assert.assertEquals(multiSetUniqu.hashMap.size(), 3);
        Assert.assertTrue(multiSetUniqu.hashMap.get('A') == 1);
    }
}
