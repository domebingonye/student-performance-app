package com.dominic.studentperformanceapp.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mapping.PropertyPath;

public final class RestControllerUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestControllerUtils.class);

    private RestControllerUtils() {
        // empty
    }

    public static PageRequest createPageRequest(Class clazz, Integer pageNumber, Integer pageSize, String sortBy, Sort.Direction sortDirection) {
        PageRequest pageRequest;
        Sort sort = Sort.unsorted();
        if (clazz != null && sortBy != null && sortDirection != null) {
            try {
                // check whether the property specified is a property of the entity;
                PropertyPath.from(sortBy, clazz);
                sort = Sort.by(sortDirection, sortBy);
            } catch (Exception e) {
                LOGGER.warn("Unable to sort by \"" + sortBy + "\": not a valid property of " + clazz.getSimpleName());
            }
        }

        if (pageNumber != null && pageSize != null) {
            pageRequest = pageSize  == 0 ? PageRequest.of(0, Integer.MAX_VALUE, sort) : PageRequest.of(pageNumber, pageSize, sort);
        } else {
            pageRequest = PageRequest.of(0, Integer.MAX_VALUE, sort);
        }
        return pageRequest;
    }
}
