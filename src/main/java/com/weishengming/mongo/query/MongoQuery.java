package com.weishengming.mongo.query;

import java.io.Serializable;

import org.springframework.data.mongodb.core.query.Query;

public class MongoQuery extends Query implements Serializable {

    private static final long serialVersionUID    = -4045214226807657088L;

    private static int        DEFAULT_PAGE_SIZE   = 10;
    private static int        DEFAULT_PAGE_NUMBER = 1;

    private Integer           pageSize            = DEFAULT_PAGE_SIZE;
    private Integer           pageNumber          = DEFAULT_PAGE_NUMBER;

    private Long           count;//总数
    
    public void putPnIntoPageNumber(Integer pn) {
        if (null == pn) {
            pn = DEFAULT_PAGE_NUMBER;
        }
        this.setPageNumber(pn);
    }
    public void putPnIntoPageSize(Integer ps) {
        if (null == ps) {
        	ps = DEFAULT_PAGE_SIZE;
        }
        this.setPageSize(ps);
    }

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
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	 

  

    

}

