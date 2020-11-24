package service.Impl;

import org.springframework.stereotype.Controller;
import service.CalculatorService;

@Controller
public class CalculatorImpl implements CalculatorService {
    @Override
    public double operator(double num1, double num2,String calculate) {
        double result = 0;
        switch (calculate){
            case "+":
                result = add(num1,num2);
                break;
            case "-":
                result = sub(num1,num2);
                break;
            case "*":
                result = mul(num1,num2);
                break;
            case "/":
                result = div(num1,num2);
                break;
        }
        return result;
    }

    private double add(double num1, double num2) {
        return num1 + num2;
    }
    private double sub(double num1, double num2) {
        return num1 - num2;
    }
    private double mul(double num1, double num2) {
        return num1 * num2;
    }
    private double div(double num1, double num2) {
        return num1 / num2;
    }
}
