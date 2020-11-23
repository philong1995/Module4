package service.impl;

import org.springframework.stereotype.Service;
import service.ConvertService;

@Service
class ConvertImpl implements ConvertService {
    @Override
    public double convert(double a) {
        return 23000*a;
    }
}
