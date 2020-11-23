package service;

import model.SandwichCondiments;

import java.util.List;

public interface CondimentsService {
    List<SandwichCondiments> listCondiments();
    void addNewCondiments(SandwichCondiments condiments);
}
