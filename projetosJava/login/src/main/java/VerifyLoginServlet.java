import java.io.*;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "verifyLoginServlet", value = "/verify-login")
public class VerifyLoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Map errors = new HashMap<String, String>();

        if (request.getParameter("username").isEmpty()){
            errors.put("username_error", "Nome de usuário vazio");
        } else if (!request.getParameter("username").equals("laboratorio")){
            errors.put("username_error", "Nome de usuário inválido");
        }

        if (request.getParameter("password").isEmpty()){
            errors.put("password_error", "Senha vazia");
        } else if (!request.getParameter("password").equals("IFPR")){
            errors.put("password_error", "Senha inválida");
        }

        if (!errors.isEmpty()){
            request.setAttribute("errors_map", errors);
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        } else {
            System.out.println("success");
            getServletContext().setAttribute("logged", true);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/success");
            dispatcher.forward(request, response);
        }

    }
}