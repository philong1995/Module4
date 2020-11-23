package service.Impl;

import model.SandwichCondiments;
import org.springframework.stereotype.Service;
import service.CondimentsService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CondimentsImpl implements CondimentsService {

    static List<SandwichCondiments> listCondiments = new ArrayList<>();

    @Override
    public List<SandwichCondiments> listCondiments() {
        return listCondiments;
    }

    @Override
    public void addNewCondiments(SandwichCondiments condiments) {
        listCondiments.add(condiments);
    }
}
