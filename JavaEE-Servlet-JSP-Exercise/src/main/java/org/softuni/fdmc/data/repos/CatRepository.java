package org.softuni.fdmc.data.repos;

import org.softuni.fdmc.data.models.Cat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CatRepository {
    private List<Cat> cats;

    public CatRepository() {
        this.cats = new ArrayList<>();
    }

    public Cat getByName(String catName) {
        return this.cats
                .stream()
                .filter(x -> x.getName().equals(catName))
                .findFirst()
                .orElse(null);
    }

    public List<Cat> getAllCats() {
        return Collections.unmodifiableList(this.cats);
    }

    public List<Cat> getAllCatsSortedByViews() {
        this.cats.sort((cat1, cat2) -> cat2.getViews() - cat1.getViews());
        return Collections.unmodifiableList(this.cats);
    }

    public void addCat(Cat cat) {
        this.cats.add(cat);
    }
}
