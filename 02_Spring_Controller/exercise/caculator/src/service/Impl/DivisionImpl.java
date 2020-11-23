package service.Impl;

import org.springframework.stereotype.Controller;
import service.CalculatorService;

@Controller
public class DivisionImpl implements CalculatorService {
    @Override
    public double operator(double num1, double num2) {
        return num1/num2;
    }
}
