package com.labseq.controller;

import com.labseq.domain.model.entity.LabSeqResponse;
import com.labseq.exception.NegativeIndexException;
import com.labseq.service.LabSeqService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor(access = AccessLevel.PACKAGE)
class LabSeqController {

    private final LabSeqService labSeqService;

    @GetMapping("/labseq/{n}")
    @ResponseBody
    public ResponseEntity<Object> getLabSeqValue(@PathVariable int n) {
        try {
            return ResponseEntity.ok().body(new LabSeqResponse(n, labSeqService.calculateLabSeqValue(n)));
        } catch (NegativeIndexException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}