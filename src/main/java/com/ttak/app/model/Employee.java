package com.ttak.app.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String firstName;

    private String lastName;

    private LocalDate birthday;

    private List<Color> favoriteColors = new ArrayList<>();

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public List<Color> getFavoriteColors() {
        return favoriteColors;
    }

    public void setFavoriteColors(List<Color> favoriteColors) {
        this.favoriteColors = favoriteColors;
    }
}
