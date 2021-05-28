package com.hama.Hama.dao;

import com.hama.Hama.model.Size;

import java.util.List;

public interface SizeDao {

    void insert(Size size);

    void edit(Size size);

    void delete(int id);

    Size get(int id);

    List<Size> getAll();

}
