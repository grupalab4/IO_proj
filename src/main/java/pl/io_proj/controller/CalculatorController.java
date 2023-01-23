package pl.io_proj.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.io_proj.service.CalculatorService;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    @GetMapping
    public ResponseEntity<Integer> getDailyCalorieIntake(@RequestParam double goalWeight,
                                                         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate deadline) throws Exception {
        Integer dailyCalorieIntake = this.calculatorService.getDailyCalorieIntake(goalWeight, deadline);
        return new ResponseEntity<>(dailyCalorieIntake, HttpStatus.OK);
    }
}
