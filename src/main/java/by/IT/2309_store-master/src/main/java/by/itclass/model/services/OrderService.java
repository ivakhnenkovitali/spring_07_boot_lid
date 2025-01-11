import OrderDao;
import Order;
import Receipt;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public class OrderService implements Service {
    private OrderDao dao;

    public OrderService() {
        dao = new OrderDao();
    }

    public boolean saveOrder(HttpSession session, String address) {
        return dao.saveOrder(session, address);
    }

    public List<Order> getOrders(int userId) {
        return dao.selectOrders(userId);
    }

    public Receipt buildReceipt(String orderId) {
        return dao.buildReceipt(orderId);
    }
}
