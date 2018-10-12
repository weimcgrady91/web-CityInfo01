package com.wei.cityinfo.dao;

import java.util.List;

public interface IBaseDao<T> {
    public boolean add(T t);
    public boolean update(T t);
    public boolean delete(T t);
    public T find(int id);
    public List<T> findAll();
}
