package com.weishengming.dao.query;

import java.io.Serializable;

public class MapperQuery implements Serializable {

    private static final long serialVersionUID    = -4045214226807657088L;

    private static int        DEFAULT_PAGE_SIZE   = 15;
    private static int        DEFAULT_PAGE_NUMBER = 1;
    public static String      ORDER_TYPE_ASC      = "ASC";
    public static String      ORDER_TYPE_DESC     = "DESC";
    private static String     ORDER               = "ID";

    private Integer           pageSize            = DEFAULT_PAGE_SIZE;
    private Integer           pageNumber          = DEFAULT_PAGE_NUMBER;

    private String            orderOperator       = ORDER_TYPE_DESC;
    private String            orderParam          = ORDER;

    private Integer           offset;
    private Integer           size;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        if (pageNumber != null && pageNumber.intValue() < 1) {
            pageNumber = DEFAULT_PAGE_NUMBER;
        }
        this.pageNumber = pageNumber;
    }

    public Integer getOffset() {
        offset = this.getPageSize() * (this.getPageNumber() - 1);
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public String getOrderParam() {
        return orderParam;
    }

    public void setOrderParam(String orderParam) {
        this.orderParam = orderParam;
    }

    public String getOrderOperator() {
        return orderOperator;
    }

    public void setOrderOperator(String orderOperator) {
        this.orderOperator = orderOperator;
    }

    public Integer getSize() {
        if (size == null) {
            size = pageSize * 3;
        }
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

}

