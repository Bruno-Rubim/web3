package models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Curriculo {
    private String name;
    private LocalDate birthdate;
    private String language;
    private String extraInfo;
    private ArrayList<String> abilities = new ArrayList<String>();

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }

    public String getExtraInfo() {
        return extraInfo;
    }
    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    public ArrayList<String> getAbilities() {
        return abilities;
    }
    public void setAbility(String ability) {
        this.abilities.add(ability);
    }
}