package pl.io_proj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.io_proj.model.DBUser;
import pl.io_proj.repository.DBUserRepository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class CalculatorService {
    private DBUserRepository userRepository;
    private AuthenticatedUserFacade authenticatedUserFacade;
    private final double AVERAGE_PAL = 1.55; // indywidualny wskaźnik aktywności fizycznej
    private final int CALORIES_PER_KG = 7700;


    @Autowired
    public void setRepository(DBUserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Autowired
    public void setAuthorizedUserFacade (AuthenticatedUserFacade authenticatedUserFacade) {
        this.authenticatedUserFacade = authenticatedUserFacade;
    }

    public Integer getDailyCalorieIntake(double goalWeight, LocalDate deadline) {
        if (deadline.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Chosen date cannot be from the past");
        }
        DBUser currentUser = authenticatedUserFacade.getCurrentUser(); // zalogowany user
        double currentWeight = currentUser.getWeight();
        double currentHeight = currentUser.getWeight();

        long days  = ChronoUnit.DAYS.between(LocalDate.now(), deadline);
        double bmr = calculateBMR(currentWeight, currentHeight);     // bmr - basic metabolic rate
        double tdee = bmr * AVERAGE_PAL;                             // tdee - całkowite dzienne zapotrzebowanie kaloryczne
                                                                     // obliczamy deficyt zgodnie z inputem usera
        double weightDeficit = currentWeight - goalWeight;
        double calorieDeficit = weightDeficit * CALORIES_PER_KG;
        double calorieIntake = tdee - (calorieDeficit / days);

        return calorieIntake < bmr ? (int)Math.round(bmr) : (int)Math.round(calorieIntake); // zwracana wartość nie powinna być mniejsza od bmr
    }

    private double calculateBMR(double weight, double height) {
        double bmr = (10 * weight) + (6.25 * height) - (5 * 30) + 5;
        return bmr;
    }
}
