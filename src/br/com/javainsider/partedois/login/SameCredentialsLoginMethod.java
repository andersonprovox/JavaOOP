package br.com.javainsider.partedois.login;

public class SameCredentialsLoginMethod implements LoginMethod {


    @Override
    public boolean login(String userName, String password) {
        return userName.equals(password) ;
    }
}
