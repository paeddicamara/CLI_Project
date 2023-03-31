package com.amigoscode.users;

public class UserDAO {

    private static Users[] users;

    private static int nextIndex = 0;
    private static final int size = 2;

    static {
        users = new Users[size];
    }

    public void saveUser(Users user) {

        users[nextIndex] = user;
        nextIndex++;
    }

    public Users[] getUsers() {
        return users;
    }
}
