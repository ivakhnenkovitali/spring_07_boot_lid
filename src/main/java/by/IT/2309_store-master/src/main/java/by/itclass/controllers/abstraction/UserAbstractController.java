import ServiceFactory;
import ServiceType;
import UserService;
import jakarta.servlet.ServletException;

public abstract class UserAbstractController extends AbstractController{
    protected UserService userService;

    @Override
    public void init() throws ServletException {
        userService = (UserService) ServiceFactory.getInstance(ServiceType.USER_SERVICE);
    }
}
