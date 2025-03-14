import by.itclass.controllers.abstraction.AbstractController;
import by.itclass.controllers.abstraction.UserAbstractController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static AppConst.*;

@WebServlet(REG_CONTROLLER)
public class RegistrationController extends UserAbstractController {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (userService.addUser(req.getParameterMap())) {
            redirect(resp, LOGIN_JSP);
        } else {
            forward(req, resp, REG_JSP, "Registration is not successfully");
        }
    }
}
