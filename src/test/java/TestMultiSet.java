import edu.hillel.MultiSet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestMultiSet {

@Test
    public void addTest(){
    MultiSet<Integer>multiSet = new MultiSet<Integer>();
    for (int i = 0; i<10; i++){
        multiSet.add(i);
    }
    for (int i = 0; i<10; i++){
        multiSet.add(i);
    }

}

}
