package bank;

import org.junit.Test;
import homework2.bank.utility.CollectionUtility;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CollectionUtilityTest {

    @Test
    public void nullSafetyListInitializeShouldReturnEmptyListIfInputNull(){
        List<Object> actual = CollectionUtility.nullSafetyListInitialize(null);
        assertTrue( actual.isEmpty());
    }

    @Test
    public void nullSafetyListInitializeShouldReturnListIfInputNotNull(){
        List<Object> actual = CollectionUtility.nullSafetyListInitialize(Arrays.asList(1,2,3));
        assertFalse( actual.isEmpty());
        assertEquals(3, actual.size());

    }
}
