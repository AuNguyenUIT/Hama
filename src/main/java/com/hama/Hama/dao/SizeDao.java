package com.hama.Hama.dao;

import com.hama.Hama.entities.SizeEntity;

import java.util.List;

public interface SizeDao {

    void insert(SizeEntity size);

    void edit(SizeEntity size);

    void delete(int id);

    SizeEntity get(int id);

    List<SizeEntity> getAll();

}
