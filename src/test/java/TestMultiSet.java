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

}
