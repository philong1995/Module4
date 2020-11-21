package service.impl;

import org.springframework.stereotype.Service;
import service.Convert;

@Service
class ConvertImpl implements Convert {
    @Override
    public double convert(double a) {
        return 23000*a;
    }
}
