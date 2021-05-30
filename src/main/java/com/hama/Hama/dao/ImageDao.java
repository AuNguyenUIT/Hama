package com.hama.Hama.dao;

import com.hama.Hama.entities.ImageEntity;

import java.util.List;

public interface ImageDao {
    void insert(ImageEntity image);

    void edit(ImageEntity image);

    void delete(int id);

    ImageEntity get(int id);

    List<ImageEntity> getAll();
}
