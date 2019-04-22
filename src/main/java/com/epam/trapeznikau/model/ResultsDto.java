package com.epam.trapeznikau.model;

import java.util.List;

public class ResultsDto<T> {

    private List<T> listResults;

    public List<T> getListResults() {
        return listResults;
    }

    public void setListResults(List<T> listResults) {
        this.listResults = listResults;
    }
}
