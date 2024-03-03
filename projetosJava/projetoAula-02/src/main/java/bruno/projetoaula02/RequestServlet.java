package bruno.projetoaula02;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/requisicao")
public class RequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String protocol = request.getProtocol();
        String addr= request.getRemoteAddr();

        writer.println("<html>");
            writer.println("<p>" + method + "</p>");
            writer.println("<p>" + uri + "</p>");
            writer.println("<p>" + protocol + "</p>");
            writer.println("<p>" + addr + "</p>");
        writer.println("</html>");
    }
}
