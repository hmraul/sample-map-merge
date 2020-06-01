package com.rhm.mapmerge.domain.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DataResultTest {

    @Test
    public void should_maintain_description_if_empty() {
        String expected = "first description";

        DataResult first = new DataResult(1, true, expected);

        Assertions.assertEquals(expected, first.concatDescription(null));
    }

    @Test
    public void should_set_description_if_there_is_not_description() {
        String expected = "new description";

        DataResult first = new DataResult(1, true, "");

        Assertions.assertEquals(expected, first.concatDescription(expected));
    }

    @Test
    public void should_concat_description() {
        String firstDescription = "first description";
        String addedDescription = "added description";
        String expected = firstDescription + "; " + addedDescription;

        DataResult first = new DataResult(1, true, firstDescription);

        String result = first.concatDescription(addedDescription);

        Assertions.assertEquals(expected, result);
    }
}
