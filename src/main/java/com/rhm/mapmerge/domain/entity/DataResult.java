package com.rhm.mapmerge.domain.entity;

import java.util.Objects;

public class DataResult {
    private final int id;
    private final boolean isOK;
    private final String description;

    @Override
    public int hashCode() {
        return Objects.hash(id, isOK, description);
    }

    public int getId() {
        return id;
    }

    public boolean isOK() {
        return isOK;
    }

    public String getDescription() {
        return description;
    }

    public DataResult(int id, boolean isOK, String description) {
        this.id = id;
        this.isOK = isOK;
        this.description = description;
    }

    public String concatDescription(String description) {
        if (description.isEmpty()) {
            return this.description;
        }

         return this.description.isEmpty()
                ? description
                : this.description + "; " + description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataResult that = (DataResult) o;
        return id == that.id &&
                isOK == that.isOK &&
                Objects.equals(description, that.description);
    }
}
