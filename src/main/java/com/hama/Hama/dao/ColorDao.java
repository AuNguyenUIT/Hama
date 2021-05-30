package com.hama.Hama.dao;

import com.hama.Hama.entities.ColorEntity;

import java.util.List;

public interface ColorDao {
    void insert(ColorEntity color);

    void edit(ColorEntity color);

    void delete(int id);

    ColorEntity get(int id);

    List<ColorEntity> getAll();

}
