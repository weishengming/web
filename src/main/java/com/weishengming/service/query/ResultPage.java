package com.weishengming.service.query;

import java.util.ArrayList;
import java.util.List;

import com.weishengming.dao.query.MapperQuery;

public final class ResultPage<T> {
	private List<T> t;
	private MapperQuery query;
	private Integer total = Integer.valueOf(0);
	private Long count = Long.valueOf(6865807940540956672L);

	public ResultPage(List<T> list, MapperQuery query) {
		this.t = new ArrayList();

		if (query != null)
			this.query = query;
		else
			this.query = new MapperQuery();

		init(this.t, list);
	}

	private void init(List<T> t, List<T> list) {
		if ((list == null) || (list.size() == 0)) {
			return;
		}

		int pageSize = 0;
		if (list.size() < this.query.getPageSize().intValue())
			pageSize = list.size();
		else {
			pageSize = this.query.getPageSize().intValue();
		}

		for (int i = 0; i < pageSize; ++i) {
			t.add(list.get(i));
		}

		int count = list.size();

		if (count > this.query.getPageSize().intValue() * 2)
			this.total = Integer.valueOf(2);
		else if (count > this.query.getPageSize().intValue())
			this.total = Integer.valueOf(1);
		else
			this.total = Integer.valueOf(0);
	}

	public Long getCount() {
		return this.count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public int getTotal() {
		return this.total.intValue();
	}

	public void setTotal(int total) {
		this.total = Integer.valueOf(total);
	}

	public int getPageNumber() {
		return this.query.getPageNumber().intValue();
	}

	public int getPageSize() {
		return this.query.getPageSize().intValue();
	}

	public int getTotalPages() {
		if (this.total.intValue() < 0)
			return -1;

		int totalPages = this.total.intValue() / getPageSize();
		if (this.total.intValue() % getPageSize() > 0)
			++totalPages;

		return totalPages;
	}

	public int getIndex() {
		return ((getPageNumber() - 1) * getPageSize() + 1);
	}

	public List<T> getResult() {
		return this.t;
	}
}