package com.seunfapps.latecomer.dtos;

public class PagingRequest {
    private Integer number;
    private Integer size;
    private String sortBy;
    private String sortDirection;
    private String searchParam;

    public PagingRequest(Integer number, Integer size, String sortBy, String sortDirection, String searchParam) {
        this.number = (number == null || number < 1) ? 0 : number - 1; //mongo paging is zero based, so page 1 is actually page 0 to mongodb
        this.size = (size == null || size < 1) ? 10 : size;
        this.sortBy = sortBy;
        this.sortDirection = sortDirection == null ? "asc" : sortDirection;
        this.searchParam = searchParam;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(String sortDirection) {
        this.sortDirection = sortDirection;
    }

    public String getSearchParam() {
        return searchParam;
    }

    public void setSearchParam(String searchParam) {
        this.searchParam = searchParam;
    }
}
