package com.rhm.mapmerge.service;

import com.rhm.mapmerge.domain.entity.DataResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MergeServiceTest {

    @Test
    public void should_merge_lists() {

        List<DataResult> firstResults = new ArrayList<>();
        firstResults.add( new DataResult(1, true, ""));
        firstResults.add( new DataResult(2, true, ""));
        firstResults.add( new DataResult(3, false, "id 3, firstResult wrong"));
        firstResults.add( new DataResult(4, false, "id 4, firstResult wrong"));
        List<DataResult> secondResults = new ArrayList<>();
        secondResults.add( new DataResult(1, true, ""));
        secondResults.add( new DataResult(2, false, "id 2, secondResult wrong"));
        secondResults.add( new DataResult(3, true, ""));
        secondResults.add( new DataResult(4, false, "id 4, secondResult wrong"));

        List<DataResult> expectedResults = new ArrayList<>();
        expectedResults.add( new DataResult(1, true, ""));
        expectedResults.add( new DataResult(2, false, "id 2, secondResult wrong"));
        expectedResults.add( new DataResult(3, false, "id 3, firstResult wrong"));
        expectedResults.add( new DataResult(4, false, "id 4, firstResult wrong; id 4, secondResult wrong"));

        MergeService mergeService = new MergeService();
        List<DataResult> results = mergeService.doMerge(firstResults, secondResults);

        Assertions.assertEquals(expectedResults, results);

    }
}
