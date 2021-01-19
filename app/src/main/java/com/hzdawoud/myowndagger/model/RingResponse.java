package com.hzdawoud.myowndagger.model;

import java.util.ArrayList;

public class RingResponse {
    private ArrayList<Ring> docs;
    private int total, limit, offset, page, pages;

    public RingResponse(ArrayList<Ring> docs, int total, int limit, int offset, int page, int pages) {
        this.docs = docs;
        this.total = total;
        this.limit = limit;
        this.offset = offset;
        this.page = page;
        this.pages = pages;
    }

    public ArrayList<Ring> getDocs() {
        return docs;
    }

    public void setDocs(ArrayList<Ring> docs) {
        this.docs = docs;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
