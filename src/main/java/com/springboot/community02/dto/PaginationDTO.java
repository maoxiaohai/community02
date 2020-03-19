package com.springboot.community02.dto;

import lombok.Data;

import java.util.List;

@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;
    private boolean showPre;
    private boolean showFirst;
    private boolean showNext;
    private boolean showEnd;
    private Integer page;
    private List<Integer> pages;


    public void setPagination(Integer totalCount, Integer page, Integer size) {
        Integer totalPage = 0;
        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }

        pages.add(page);
        for (int i = 1; i <= 3; i++) {
            if (page - i > 0) {
                pages.add(page - i, 0);
            }
            if (page + 1 <= totalPage) {
                pages.add(page + 1);
            }

        }

        if (page == 1) {
            showPre = false;
        } else {
            showPre = true;
        }
        if (page == totalPage) {
            showNext = false;
        } else {
            showNext = true;
        }
        if (pages.contains(1)) {
            showFirst = false;
        } else {
            showFirst = true;
        }
        if (pages.contains(totalPage)) {
            showEnd = false;
        } else {
            showEnd = true;
        }

    }
}
