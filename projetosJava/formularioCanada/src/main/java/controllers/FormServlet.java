package controllers;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.Curriculo;
import services.FormService;

@WebServlet(name = "FormServlet", value = "/form-validation")
public class FormServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Curriculo curriculo = new Curriculo();
        FormService service = new FormService();
        Map<String, String> errors= new HashMap<String, String>();

        try {
            String name = service.validateText(request.getParameter("name"));
            curriculo.setName(name);
        } catch (IllegalArgumentException e){
            errors.put("name_error", e.getMessage());
        }

        try {
            LocalDate birthDate = service.validateBirthdate(request.getParameter("birthdate"));
            curriculo.setBirthdate(birthDate);
        } catch (IllegalArgumentException e){
            errors.put("birthdate_error", e.getMessage());
        }

        try {
            String language = service.validateLanguage(request.getParameter("language"));
            curriculo.setLanguage(language);
        } catch (IllegalArgumentException e){
            errors.put("language_error", e.getMessage());
        }

        try {
            ArrayList<String> abilities = service.validateAbilities(request.getParameterValues("abilities"));
            for (String abilty : abilities){
                curriculo.setAbility(abilty);
            }
        } catch (IllegalArgumentException e){
            errors.put("abilities_error", e.getMessage());
        }

        try {
            String extraInfo = service.validateExtraInfo(request.getParameter("extraInfo"));
            curriculo.setExtraInfo(extraInfo);
        } catch (IllegalArgumentException e){
            errors.put("extraInfo_error", e.getMessage());
        }

        if (!errors.isEmpty()){
            request.setAttribute("errors_map", errors);
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("curriculo", curriculo);
            RequestDispatcher dispatcher = request.getRequestDispatcher("verification-complete.jsp");
            dispatcher.forward(request, response);
        }
    }
}
