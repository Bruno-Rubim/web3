package services;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;

public class FormService {
    private String[] languageList = {"eng", "sp", "ptbr"};
    private String[] abilityList = {"java", "js", "html", "css"};
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public String validateText(String text) throws IllegalArgumentException{
        if (text == null || text.length() < 3){
            throw new IllegalArgumentException("texto informado é inválido");
        }
        return text.trim();
    }
    public LocalDate validateBirthdate(String birthdate){
        LocalDate date;
         try {
             date = LocalDate.parse(birthdate);
         } catch (DateTimeParseException e1){
             try {
                 date = LocalDate.parse(birthdate, formatter);
             } catch (DateTimeParseException e2) {
                 throw new IllegalArgumentException(" A data " + birthdate + " não está no formato correto");
             }
         }
        Period p = Period.between(date, LocalDate.now());
        if (p.getYears() < 18) {
            throw new IllegalArgumentException("A data de nascimento não equivale à uma pessoa maior de idade");
        }
        return date;
    }

    public String validateLanguage(String language){
        boolean found = false;
        for (int i = 0; i < languageList.length; i++){
            if (languageList[i].equals(language)){
                found = true;
                break;
            }
        }
        if (!found) {
            throw new IllegalArgumentException("A língua selecionada não está disponível");
        }
        return language;
    }

    public ArrayList<String> validateAbilities(String[] abilities){
        if (abilities == null){
            throw new IllegalArgumentException("Lista de habilidades vazia");
        }
        ArrayList<String> verifiedAbilities = new ArrayList<String>();
        for (String ability : abilities) {
            boolean found = false;
            for (String listItem : abilityList) {
                if (ability.equals(listItem)) {
                    found = true;
                    verifiedAbilities.add(ability);
                    break;
                }
            }
            if (!found) {
                throw new IllegalArgumentException("Abilidade selecionada indisponível");
            }
        }
        return verifiedAbilities;
    }

    public String validateExtraInfo(String info){
        if (info.trim().isEmpty()){
            throw new IllegalArgumentException("Informações adicionais vazia");
        }
        return info;
    }
}
