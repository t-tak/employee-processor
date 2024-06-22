package com.ttak.app.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Employee {
    private String firstName;

    private String lastName;

    private Date birthday;

    private List<Color> favoriteColors = new ArrayList<>();

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
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
