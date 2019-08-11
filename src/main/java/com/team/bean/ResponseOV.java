package com.team.bean;

import java.util.List;

public class ResponseOV<T> {

    private int total;

    private List<T> rows;

    public ResponseOV() {
    }

    public ResponseOV(int total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "ResponseOV{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
