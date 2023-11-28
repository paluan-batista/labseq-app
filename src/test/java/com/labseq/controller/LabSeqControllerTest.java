package com.labseq.controller;

import com.labseq.exception.NegativeIndexException;
import com.labseq.service.LabSeqService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(LabSeqController.class)
class LabSeqControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LabSeqService labSeqService;

    @Test
    void getLabSeqValue_PositiveIndex_ReturnsOk() throws Exception {
        int index = 5;
        int expectedResult = 3;
        when(labSeqService.calculateLabSeqValue(anyInt())).thenReturn(expectedResult);

        mockMvc.perform(get("/api/labseq/{n}", index)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.index").value(index))
                .andExpect(jsonPath("$.value").value(expectedResult));
    }

    @Test
    void getLabSeqValue_NegativeIndex_ReturnsBadRequest() throws Exception {
        int index = -1;
        String errorMessage = "Index cannot be negative";
        when(labSeqService.calculateLabSeqValue(anyInt())).thenThrow(new NegativeIndexException(errorMessage));

        mockMvc.perform(get("/api/labseq/-1", index)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(errorMessage));
    }

}