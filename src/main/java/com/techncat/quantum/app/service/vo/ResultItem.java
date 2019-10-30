package com.techncat.quantum.app.service.vo;

import java.util.List;

public class ResultItem {
    private String titleIndex;
    private List columns;

    public ResultItem(String titleIndex, List columns) {
        this.titleIndex = titleIndex;
        this.columns = columns;
    }

    public String getTitleIndex() {
        return titleIndex;
    }

    public void setTitleIndex(String titleIndex) {
        this.titleIndex = titleIndex;
    }

    public List getColumns() {
        return columns;
    }

    public void setColumns(List columns) {
        this.columns = columns;
    }
}
