package br.com.sistemaReservas.service;

import br.com.sistemaReservas.dao.UserDao;
import br.com.sistemaReservas.model.User;

public class UserService {

    private static UserService userService;

    public User getByEmail(String email) {
        return UserDao.getByEmail(email);
    }

    public User login(String email, String password) {
        return UserDao.login(email, password);
    }

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }
}
