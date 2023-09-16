package vn.titv.spring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private Calculator myCalculator;

    @Autowired
    public Controller(@Qualifier("getCalculator")Calculator myCalculator){
        this.myCalculator = myCalculator;
    }

    @GetMapping("/sqrt")
    public String calcuSqrt(@RequestParam("value") double x){
        return String.format("SQRT (%s) = ", x) + myCalculator.sqrt(x);
    }

    @GetMapping("/pow2")
    public String calcuPow2(@RequestParam("value") double x){
        return String.format("Pow2 (%s) = ", x) + myCalculator.pow2(x);
    }
}
