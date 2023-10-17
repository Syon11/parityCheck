package com.parityCheck;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ParityCheckerTest {

    @Test
    public void testRun(){
        Block block = new Block("test");
        ParityChecker checker = new ParityChecker(block);
        assertFalse(checker.run());
    }
}
