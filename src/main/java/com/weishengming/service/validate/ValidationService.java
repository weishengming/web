package com.weishengming.service.validate;

import com.weishengming.service.exception.ServiceException;


public abstract interface ValidationService {
	public abstract ValidationResult validate(Object paramObject,
			boolean paramBoolean);

	public abstract void validate(Object paramObject) throws ServiceException;
}
