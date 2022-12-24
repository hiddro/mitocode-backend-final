package com.example.demo.services.impl;

import com.example.demo.repository.GENERICRepositories;
import com.example.demo.services.CRUDService;

import java.util.List;

public abstract class CRUDServiceImpl<T, ID> implements CRUDService<T, ID> {

    protected abstract GENERICRepositories<T, ID> getRepo();

    @Override
    public T save(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public T update(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public List<T> findAll() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public T findById(ID id) throws Exception {
        return getRepo().findById(id).orElse(null);
    }

    @Override
    public void delete(ID id) throws Exception {
        getRepo().deleteById(id);
    }
}
