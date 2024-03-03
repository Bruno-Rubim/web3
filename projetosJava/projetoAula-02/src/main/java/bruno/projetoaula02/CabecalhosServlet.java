package bruno.projetoaula02;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/cabecalhos")
public class CabecalhosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();

        String host = req.getHeader("host");
        String cliente = req.getHeader("user-agent");
        String codificacao = req.getHeader("accept-encoding");
        String idioma = req.getHeader("accept-language");
        String token = req.getHeader("token");

        Enumeration<String> headerNames = req.getHeaderNames();

        while (headerNames.hasMoreElements()){
            System.out.println(headerNames.nextElement().toString());


            System.out.println(req.getHeader(headerNames.nextElement().toString()));


        }

        writer.println("<html>");

        writer.println("<p>" + host + "<p>");
        writer.println("<p>" + cliente + "<p>");
        writer.println("<p>" + codificacao + "<p>");
        writer.println("<p>" + idioma + "<p>");
        writer.println("<p>" + token + "<p>");

        writer.println("/<html>");


    }
}