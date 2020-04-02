package edu.sharif.yousefi.first_app.account;

import java.util.HashMap;


class User {
    private String username;
    private String email;
    private String password;
    private String phoneNumber;
    private static HashMap<String, User> users = new HashMap<>();

    public static User make_user(String username, String email, String password,String phoneNumber) throws Exception{
        User user=users.get(username);
        if( user == null) {
            user = new User(username,email,password,phoneNumber);
            users.put(username,user);
            return user;
        }
        else {
            throw new Exception(StrnigEnum.username_exist.getMessage());
        }

    }

    private User(String username, String email, String password,String phoneNumber) {
            this.username = username;
            this.email = email;
            this.password = password;
            this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    static User find_user(String username, String password) throws Exception{
        try{
            User user =  users.get(username);
            if (user == null){
                throw new Exception(StrnigEnum.user_not_found.getMessage());
            }
            if(user.password.equals(password)){
              return user;
            }
            else {
                throw new Exception(StrnigEnum.incorrect_password.getMessage());

            }
        }catch (Exception e){
            throw new Exception(StrnigEnum.undefine_exception.getMessage());
        }
    }
    public String getEmail(){
        return this.email;
    }

}
