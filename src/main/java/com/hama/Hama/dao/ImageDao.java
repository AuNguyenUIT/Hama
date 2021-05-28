package com.hama.Hama.dao;

import com.hama.Hama.model.Image;

import java.util.List;

public interface ImageDao {
    void insert(Image image);

    void edit(Image image);

    void delete(int id);

    Image get(int id);

    List<Image> getAll();
}
