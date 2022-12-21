package pl.io_proj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.io_proj.repository.RecipeRepository;

@Service
public class RecipeService {
    private RecipeRepository repository;

    @Autowired
    public void setRepository(RecipeRepository repository) {
        this.repository = repository;
    }
}
