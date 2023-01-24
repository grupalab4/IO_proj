package pl.io_proj.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.io_proj.model.DBUser;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@RequiredArgsConstructor
@Service
public class CalculatorService {
    private final DBUserService dbUserService;
    private final double AVERAGE_PAL = 1.35; // indywidualny wskaźnik aktywności fizycznej
    private final int CALORIES_PER_KG = 7700;

    public Integer getDailyCalorieIntake(double goalWeight, LocalDate deadline) throws Exception {
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
        double calorieIntake = tdee - (calorieDeficit / days);

        return calorieIntake < bmr ? (int)Math.round(bmr) : (int)Math.round(calorieIntake); // zwracana wartość nie powinna być mniejsza od bmr
    }

    private double calculateBMR(double weight, double height, int age) {
        double bmr = 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
        return bmr;1qqq
    }
}
