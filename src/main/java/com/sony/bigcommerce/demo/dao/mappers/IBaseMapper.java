package com.sony.bigcommerce.demo.dao.mappers;

import java.util.List;

public interface IBaseMapper <T> {
	public List<T> findAll() ;
	public void insert(T entity);
	public void delete(T entity);
}
