package com.hama.Hama.dao;

import com.hama.Hama.model.Color;

import java.util.List;

public interface ColorDao {
    void insert(Color color);

    void edit(Color color);

    void delete(int id);

    Color get(int id);

    List<Color> getAll();

}
