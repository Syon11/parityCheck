package com.parityCheck;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class DecoderTest {

    @Test
    public void testRun() {
        ArrayList<Block> blocks = new ArrayList<>();
        blocks.add(new Block("test"));
        Decoder decoder = new Decoder(blocks);
        assertEquals("test", decoder.run());
    }


}
