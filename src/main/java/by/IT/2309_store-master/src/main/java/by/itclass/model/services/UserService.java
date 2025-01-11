import UserDao;
import User;

import java.util.Map;

public class UserService implements Service {
    private final UserDao dao;

    public UserService() {
        dao = new UserDao();
    }

    public User getUser(String login, String password) {
        return dao.selectUser(login, password);
    }

    public boolean addUser(Map<String, String[]> params) {
        return dao.insertUser(params);
    }

    public boolean changePassword(int id, String password) {
        return dao.updateUser(id, password);
    }
}
