package service;
import pojo.User;

import java.util.List;

public interface IUserService {
    int add(User user);

    int del(int id);

    int update(User user);

    List<User> sel();

    User selOne(int id);

    User selOneUser(String name);
}
