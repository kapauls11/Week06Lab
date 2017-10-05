package service_class;

import service_class.User;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class UserService
{

    public UserService()
    {

    }

    public User login(String username, String password)
    {
        User user = new User(username, password);
        if (user.getUsername().equals("adam") && user.getPassword().equals("password"))
        {
            User userWithNullPass = new User(user.getUsername(), null);
            return userWithNullPass;
        } else if (user.getUsername().equals("betty") && user.getPassword().equals("password"))
        {
            User userWithNullPass = new User(user.getUsername(), null);
            return userWithNullPass;
        }
        return null;
    }

}
