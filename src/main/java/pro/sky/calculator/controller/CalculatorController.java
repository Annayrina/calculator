package pro.sky.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.calculator.Service.CalculatorSer;

@RestController
@RequestMapping(value = "/calculator")
public class CalculatorController {
    private final CalculatorSer calculatorSer;
    public CalculatorController(CalculatorSer calculatorSer) {
        this.calculatorSer = calculatorSer;
    }
    @GetMapping
    public String showGreetings(){
        return "Добро пожаловать в калькулятор";
    }
    @GetMapping("/plus")
    public String sum(@RequestParam int num1, @RequestParam int num2){
        int result = calculatorSer.sum(num1, num2);
        return createRs(num1, num2, '+', result);
    }
    @GetMapping("/minus")
    public String subtract(@RequestParam int num1, @RequestParam int num2) {
        int result = calculatorSer.subtract(num1, num2);
        return createRs(num1, num2, '-', result);
    }
    @GetMapping("/multiply")
    public String multiply(@RequestParam int num1, @RequestParam int num2) {
        int result = calculatorSer.multiply(num1, num2);
        return createRs(num1, num2, '*', result);
    }
    @GetMapping("/divide")
    public String divide(@RequestParam int num1, @RequestParam int num2) {
        if (num2 == 0) {
            return "Второй фргумент 0. Деление на 0 невозможно.";
        }
        int result = calculatorSer.divide(num1, num2);
        return createRs(num1, num2, '/', result);
    }

       private String createRs(int num1, int num2, char action, int result){
            return String.format("%d %c %d = %d", num1, action, num2, result);
        }
    }
