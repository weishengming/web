package com.weishengming.service.validate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.stereotype.Service;

import com.weishengming.service.exception.ServiceException;

public class ValidationServiceImpl implements ValidationService {

	@Resource
	private Validator validator;

	public ValidationResult validate(Object param, boolean fastMode) {
		ValidationResult result = new ValidationResult();

		Set violations = this.validator.validate(param, new Class[0]);
		boolean isEmpty = violations.isEmpty();

		result.setPassed(isEmpty);
		if (!(isEmpty)) {
			List failedReasonList = new ArrayList(violations.size());
			for (Iterator i$ = violations.iterator(); i$.hasNext();) {
				ConstraintViolation violation = (ConstraintViolation) i$.next();
				StringBuilder sb = new StringBuilder(violation.getPropertyPath().toString());
				sb.append(violation.getConstraintDescriptor().getAnnotation().annotationType().getSimpleName());
				String reason = sb.toString();
				failedReasonList.add(reason);
				if (fastMode)
					break;
			}
			result.setFailedReasonList(failedReasonList);
		}
		return result;
	}

	public void validate(Object param) throws ServiceException {
		if (param == null) {
			throw createServiceException("参数为空");
		}

		ValidationResult vr = validate(param, true);
		if (!(vr.isPassed()))
			throw createServiceException("输入参数不正确", vr.getFirstFailedReason());
	}

	private ServiceException createServiceException(String invalidParam,
			String firstFailedReason) {
		return new ServiceException(invalidParam, firstFailedReason);
	}

	private ServiceException createServiceException(String nullParam) {
		return new ServiceException(nullParam);
	}
}
