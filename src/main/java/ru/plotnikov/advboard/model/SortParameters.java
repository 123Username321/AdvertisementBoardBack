package ru.plotnikov.advboard.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

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

    public static List<SortParameters> fromString(String jsonString) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<SortParameters> sortParameters = null;

        if (jsonString != null && !jsonString.isEmpty()) {
            try {
                sortParameters = objectMapper.readValue(jsonString, new TypeReference<List<SortParameters>>() {});
            } catch (JsonProcessingException e) {
                throw e;
            }
        }

        return sortParameters;
    }
}
