package onlineShop.storage;

import onlineShop.model.User;
import onlineShop.model.types.UserType;

import java.util.Arrays;

public class UserStorage {
    private User[] users;
    private int size;

    public UserStorage() {
        users = new User[10];
        size = -1;
    }

    public User register(User user) throws NullPointerException {
        if (user == null) {
            throw new NullPointerException();
        }
        if (size == users.length) {
            extend();
        }
        users[++size] = user;
        return login(user.getEmail(), user.getPassword());
    }

    public User login(String usernameAndPassword) throws NullPointerException {
        if (usernameAndPassword == null) {
            throw new NullPointerException();
        }
        String username = usernameAndPassword.substring(0, usernameAndPassword.indexOf('-'));
        String password = usernameAndPassword.substring(usernameAndPassword.indexOf('-') + 1);
        for (User user : users) {
            if (user.getEmail().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public User login(String username, String password) throws NullPointerException {
        if (username == null || password == null) {
            throw new NullPointerException();
        }
        for (User user : users) {
            if (user.getEmail().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public void print() {
        for (int i = 0; i <= size; i++) {
            if (users[i].getUserType() == UserType.USER) {
                System.out.println(users[i]);
            }
        }
    }

    private void extend() {
        users = Arrays.copyOf(users, users.length + 5);
    }
}