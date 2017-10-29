package service_class;

public class UserService
{

    public UserService(){

    }

    public User login(String username, String password)
    {
        User user = new User(username, password);
        if (user.getUsername().equals("adam") && user.getPassword().equals("password"))
        {
            User u = new User(user.getUsername(), null);
            return u;
        } else if (user.getUsername().equals("betty") && user.getPassword().equals("password"))
        {
            User u = new User(user.getUsername(), null);
            return u;
        }
        return null;
    }

}
