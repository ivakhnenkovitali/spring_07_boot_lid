import by.itclass.model.services.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static AppConst.MESSAGE_ATTR;

public abstract class AbstractController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void forward(HttpServletRequest req, HttpServletResponse resp,
                           String url) throws ServletException, IOException {
        req.getRequestDispatcher(url).forward(req, resp);
    }

    protected void forward(HttpServletRequest req, HttpServletResponse resp,
                           String url, String message) throws ServletException, IOException {
        req.setAttribute(MESSAGE_ATTR, message);
        req.getRequestDispatcher(url).forward(req, resp);
    }

    protected void redirect(HttpServletResponse resp, String url) throws IOException {
        resp.sendRedirect(url);
    }
}
