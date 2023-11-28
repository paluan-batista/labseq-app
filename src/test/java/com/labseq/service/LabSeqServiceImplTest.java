package com.labseq.service;

import com.labseq.exception.NegativeIndexException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LabSeqServiceImplTest {

    private LabSeqService labSeqService;

    @BeforeEach
    void setUp() {
        labSeqService = new LabSeqServiceImpl();
    }

    @Test
    void testCalculateLabSeqValueForFirstFourIndices() {
        assertEquals(0, labSeqService.calculateLabSeqValue(0));
        assertEquals(1, labSeqService.calculateLabSeqValue(1));
        assertEquals(0, labSeqService.calculateLabSeqValue(2));
        assertEquals(1, labSeqService.calculateLabSeqValue(3));
    }

    @Test
    void testCalculateLabSeqValueForFifthIndex() {
        assertEquals(1, labSeqService.calculateLabSeqValue(4));
    }

    @Test
    void testCalculateLabSeqValueForLargeIndex() {
        assertEquals(3, labSeqService.calculateLabSeqValue(10));
    }

    @Test
    void testCalculateLabSeqValueForNegativeIndex() {
        assertThrows(NegativeIndexException.class, () -> labSeqService.calculateLabSeqValue(-1));
    }

    @Test
    void testCalculateLabSeqValuePerformance() {
        long startTime = System.currentTimeMillis();
        labSeqService.calculateLabSeqValue(110);
        long endTime = System.currentTimeMillis();

        long executionTime = endTime - startTime;
        long acceptableTime = 10000;

        assertTrue(executionTime < acceptableTime);
    }

}
