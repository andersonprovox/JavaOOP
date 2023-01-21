package br.com.javainsider.partedois.login;

public class StaticLoginMethod implements LoginMethod {
    private static final String USERNAME = "admin";
    private  static final String PASSWORD = "123";

    private String username;
    private String password;
    public StaticLoginMethod() {
        this(USERNAME, PASSWORD);
    }

    public StaticLoginMethod(String userName, String password) {
        this.username = userName;
        this.password = password;
    }
    @Override
    public boolean login(String userName, String password) {
        return userName.equals(username) && password.equals(password);
    }
}
