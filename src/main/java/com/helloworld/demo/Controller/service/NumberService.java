package com.helloworld.demo.Controller.service;

import java.util.List;
import com.helloworld.demo.Controller.model.Number;
public interface NumberService {
    List<Number> getAll();
    void save(Number number);
    Number getById(int id);
    void update(Number number);
    void delete(int id);

}
