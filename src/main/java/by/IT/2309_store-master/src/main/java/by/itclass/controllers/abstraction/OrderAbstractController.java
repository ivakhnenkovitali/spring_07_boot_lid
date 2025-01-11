import OrderService;
import ServiceFactory;
import ServiceType;
import jakarta.servlet.ServletException;

public abstract class OrderAbstractController extends AbstractController {
    protected OrderService orderService;

    @Override
    public void init() throws ServletException {
        orderService = (OrderService) ServiceFactory.getInstance(ServiceType.ORDER_SERVICE);
    }
}
