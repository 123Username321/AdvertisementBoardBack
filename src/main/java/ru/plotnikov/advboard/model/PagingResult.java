package ru.plotnikov.advboard.model;

import java.util.List;

public class PagingResult<T> {
    private int totalQuantity;
    private int itemsByPage;
    private int currentPage;
    private List<T> items;

    public PagingResult(int totalQuantity, int itemsByPage, int currentPage, List<T> items) {
        this.totalQuantity = totalQuantity;
        this.itemsByPage = itemsByPage;
        this.currentPage = currentPage;
        this.items = items;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public int getItemsByPage() {
        return itemsByPage;
    }

    public void setItemsByPage(int itemsByPage) {
        this.itemsByPage = itemsByPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
