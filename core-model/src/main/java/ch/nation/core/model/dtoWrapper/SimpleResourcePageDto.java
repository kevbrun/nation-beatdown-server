package ch.nation.core.model.dtoWrapper;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

public class SimpleResourcePageDto implements Serializable {
    @JsonProperty("size")
    private long size;
    @JsonProperty("totalElements")
    private long totalElements;
    @JsonProperty("totalPages")
    private long totalPages;
    @JsonProperty("number")
    private long number;


    public SimpleResourcePageDto(long size, long totalElements, long totalPages, long number) {
        this.size = size;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.number = number;
    }

    public SimpleResourcePageDto() {
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleResourcePageDto that = (SimpleResourcePageDto) o;
        return size == that.size &&
                totalElements == that.totalElements &&
                totalPages == that.totalPages &&
                number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, totalElements, totalPages, number);
    }

    @Override
    public String toString() {
        return "SimpleResourcePageDto{" +
                "size=" + size +
                ", totalElements=" + totalElements +
                ", totalPages=" + totalPages +
                ", number=" + number +
                '}';
    }
}
