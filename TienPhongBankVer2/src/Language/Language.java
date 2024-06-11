/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Language;

import java.util.ResourceBundle;

/**
 *
 * @author ADMIN
 */
public class Language {
    public String account;
    public String accountInvalid;
    public String password;
    public String passInvalid;
    public String captcha;
    public String captchaInvalid;
    public String login;
    public String loginFail;
    public String emptyString;

    {
        ResourceBundle rs = ResourceBundle.getBundle("ulities/Language");
        account = rs.getString("enterAccount");
        accountInvalid = rs.getString("errorAccount");
        password = rs.getString("enterPassword");
        passInvalid = rs.getString("errorPassword");
        captcha = rs.getString("enterCaptcha");
        captchaInvalid = rs.getString("errorCaptcha");
        login = rs.getString("loginSuccess");
        loginFail = rs.getString("loginFail");
        emptyString = rs.getString("emptyString");
    }

}
