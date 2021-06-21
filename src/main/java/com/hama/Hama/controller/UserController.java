package com.hama.Hama.controller;

import com.hama.Hama.entities.UserEntity;
import com.hama.Hama.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
    public String showFormLogin(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            if (session.getAttribute("username") != null) {
                return "redirect:/";
            }
        }
        return "client/login";
    }

    @RequestMapping(value = "/dang-nhap", method = RequestMethod.POST)
    public String login(Model model, HttpServletRequest request) throws NoSuchAlgorithmException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String passwordHash = this.hashPassword(password);

        UserEntity user = userService.getUserByUserNameAndPassword(username, passwordHash);

        if (user.getUserName() != null) {
            if (user.getStatus()) {
                HttpSession session = request.getSession();
                session.setAttribute("username", user.getUserName());
                session.setAttribute("lastname", user.getLastName());
                session.setAttribute("uid", user.getId());
                session.setAttribute("role", user.getRole());
                return "redirect:/";
            } else {
                model.addAttribute("username", username);
                model.addAttribute("password", password);
                return "client/login";
            }

        } else {
            model.addAttribute("username", username);
            model.addAttribute("password", password);
            return "client/login";
        }
    }

    @RequestMapping("/dang-xuat")
    public String logout(Model model, HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("username"); //remove session
            session.removeAttribute("lastname"); //remove session
            session.removeAttribute("uid"); //remove session
            session.removeAttribute("role"); //remove session
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
    public String showFormRegister(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            if (session.getAttribute("username") != null) {
                return "redirect:/";
            }
        }
        return "client/register";
    }

    @RequestMapping(value = "/dang-ky", method = RequestMethod.POST)
    public String registerUser(Model model, HttpServletRequest request) throws NoSuchAlgorithmException, ParseException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String gender = request.getParameter("gender");
        String birthday = request.getParameter("birthday");
        String address = request.getParameter("address");
        UserEntity user = new UserEntity();

        user.setRole(UserRole.USER);
        user.setUserName(username);

        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
        String passwordHash = this.hashPassword(password);
        user.setPassword(passwordHash);
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setGender(gender);
        user.setDate(date);
        user.setAddress(address);
        user.setMail(email);
        user.setPhoneNumber(phone);
        user.setCreated(new Date());
        user.setModified(new Date());
        user.setStatus(true);
        Integer uid = userService.saveUser(user);
        if (uid != 0) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("lastname", user.getLastName());
            session.setAttribute("uid", uid);
            session.setAttribute("role", user.getRole());
            return "redirect:/";
        } else {
            model.addAttribute("user", user);
            return "client/register";
        }
    }


    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(password.getBytes());
        byte[] digest = messageDigest.digest();
        StringBuilder stringBuffer = new StringBuilder();
        for (byte b : digest) {
            stringBuffer.append(Integer.toHexString(b & 0xff));
        }
        return stringBuffer.toString();
    }
}
