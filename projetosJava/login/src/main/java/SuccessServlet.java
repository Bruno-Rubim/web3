import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "successServlet", value = "/success")
public class SuccessServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        verifyLogin(request, response);
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        verifyLogin(request, response);
    }

    public void verifyLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        Map<String, String> errors = new HashMap<String, String>();
        ServletContext context = getServletContext();

        boolean logged = false;
        if ((Boolean) context.getAttribute("logged") == null){
            logged = false;
        } else {
            logged = (Boolean) context.getAttribute("logged");
        }
        if (logged){
            System.out.println("You're logged in :D");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/success.jsp");
            dispatcher.forward(request, response);
        } else {
            System.out.println("You're not logged in >:C");
            System.out.println("Sending you to shadow realm");
            errors.put("login_error", "Usuário não logado");
            request.setAttribute("errors_map", errors);
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
    }
}