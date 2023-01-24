package pl.io_proj.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.io_proj.model.DBUser;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class CalculatorService {
    private final DBUserService dbUserService;
    private final double AVERAGE_PAL = 1.6; // indywidualny wskaźnik aktywności fizycznej
    private final int CALORIES_PER_KG = 7000;


    public Map<String, Integer> getDailyCalorieIntake(double goalWeight, LocalDate deadline) throws Exception {
        if (goalWeight < 0 || goalWeight > 999) {
            throw new IllegalArgumentException("Invalid goal weight");
        }
        if (deadline.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Chosen date cannot be from the past");
        }

        DBUser currentUser = dbUserService.getCurrentDBUser(); // zalogowany user
        double currentWeight = currentUser.getWeight();
        double currentHeight = currentUser.getHeight();
        int currentAge = currentUser.getAge();

        long days  = ChronoUnit.DAYS.between(LocalDate.now(), deadline);
        double bmr = calculateBMR(currentWeight, currentHeight, currentAge);     // bmr - basic metabolic rate
        double tdee = bmr * AVERAGE_PAL;                             // tdee - całkowite dzienne zapotrzebowanie kaloryczne
                                                                     // obliczamy deficyt zgodnie z inputem usera
        double weightDeficit = currentWeight - goalWeight;
        double calorieDeficit = weightDeficit * CALORIES_PER_KG;
        double calorieIntake = (tdee - (calorieDeficit / days));

        Map<String, Integer> responseValuesMap = new HashMap<>();
        responseValuesMap.put("tdee", (int)Math.round(tdee));
        responseValuesMap.put("bmr", (int)Math.round(bmr));
        responseValuesMap.put("calorieIntake", (int)Math.round(calorieIntake));
        return responseValuesMap;
    }
    private double calculateBMR(double weight, double height, int age) {
        double bmr = 66.5 + (12.75 * weight) + (5.003 * height) - (6.775 * age);
        return bmr;
    }
}
