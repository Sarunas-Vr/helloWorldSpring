package com.helloworld.demo.Controller.model;

import com.helloworld.demo.Controller.model.Number;

import java.util.List;

public interface NumberDAO {
    void insertEntity(Number number);
    Number findEntityByID(int id);
    List<Number> findEntities();
    void updateEntity(Number number);
    void removeEntityByID(int id);


}
