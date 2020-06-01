package com.rhm.mapmerge.service;

import com.rhm.mapmerge.domain.entity.DataResult;

import java.util.List;
import java.util.stream.Collectors;

public class MergeService {
    public List<DataResult> doMerge(List<DataResult> firstResults, List<DataResult> secondResults) {
        return firstResults.stream()
                .map(first -> mergeSecond(first, secondResults))
                .collect(Collectors.toList());

    }

    private DataResult mergeSecond(DataResult first, List<DataResult> secondResults) {
        return secondResults.stream()
                .filter(i -> i.getId() == first.getId())
                .map(i -> new DataResult(
                        first.getId(),
                        first.isOK() && i.isOK(),
                        first.concatDescription(i.getDescription())))
                .findFirst()
                .orElse(first);
    }
}
