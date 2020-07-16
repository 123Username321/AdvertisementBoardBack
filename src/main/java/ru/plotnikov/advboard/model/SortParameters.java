package ru.plotnikov.advboard.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SortParameters {
    @JsonProperty("columnName")
    private String columnName;
    @JsonProperty("isDesc")
    private boolean isDesc;

    public SortParameters() {}

    public SortParameters(String columnName, boolean isDesc) {
        this.columnName = columnName;
        this.isDesc = isDesc;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public boolean isDesc() {
        return isDesc;
    }

    public void setDesc(boolean desc) {
        isDesc = desc;
    }

    public String toString() {
        return "{ columnName: " + columnName + ", isDesc: " + isDesc + " }";
    }
}
