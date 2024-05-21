package br.com.sistemaReservas.service;

import br.com.sistemaReservas.dao.UserDAO;
import br.com.sistemaReservas.model.User;

public class UserService {

    private static UserService userService;

    public User getByEmail(String email) {
        return UserDAO.getByEmail(email);
    }

    public User login(String email, String password) {
        return UserDAO.login(email, password);
    }

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }
    
}
