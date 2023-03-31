package com.amigoscode.users;

public class UserService {

    private UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAO();
    }

    public void addUser(Users user) {

        userDAO.saveUser(user);
    }

    public Users[] getUsers() {
       return userDAO.getUsers();
    }
}
