package com.labseq.service;

import com.labseq.exception.NegativeIndexException;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
class LabSeqServiceImpl implements LabSeqService {

    private final Map<Integer, Integer> memoizationCache;

    public LabSeqServiceImpl() {


        this.memoizationCache = new ConcurrentHashMap<>();
        memoizationCache.put(0, 0);
        memoizationCache.put(1, 1);
        memoizationCache.put(2, 0);
        memoizationCache.put(3, 1);
    }

    @Override
    public Integer calculateLabSeqValue(int n) {
        if (n < 0) {
            throw new NegativeIndexException("Index should be non-negative.");
        }

        for (int i = 4; i <= n; i++) {
            memoizationCache.putIfAbsent(i,
                                         memoizationCache.getOrDefault(i - 4, 0) + memoizationCache.getOrDefault(i - 3, 0));
        }

        return memoizationCache.getOrDefault(n, 0);
    }

}
