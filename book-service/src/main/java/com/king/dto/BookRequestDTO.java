package com.king.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class BookRequestDTO {
    @Schema(example = "One piece", description = "Tittle of book")
    private String title;

    @Schema(example = "100", description = "PageCount of book")
    private Integer pageCount;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }
}
