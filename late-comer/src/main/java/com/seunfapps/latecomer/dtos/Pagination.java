package com.seunfapps.latecomer.dtos;

import java.util.List;

public class Pagination<T> {
    private Integer count;
    private List<T> content;

    public Pagination(Integer count, List<T> content) {
        this.count = count;
        this.content = content;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }
}
