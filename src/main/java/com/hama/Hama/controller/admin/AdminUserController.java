
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hama.Hama.controller.admin;


import com.hama.Hama.controller.UserRole;
import com.hama.Hama.entities.UserEntity;
import com.hama.Hama.service.UserService;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/quan-tri/nguoi-dung")
public class AdminUserController {
    @Autowired
    UserService userService;

    @RequestMapping("/danh-sach")
    public String getListUser(Model model) {
        List<UserEntity> userEntityList = userService.getUsers();
        model.addAttribute("userList", userEntityList);
        return "admin/user";
    }

    @RequestMapping(value = "/them", method = RequestMethod.GET)
    public String showUserAddForm(Model model) {
        return "admin/user-add-form";
    }

    @RequestMapping(value = "/them", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String addUser(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam("thumb") MultipartFile multipartFile) throws ParseException, InterruptedException, NoSuchAlgorithmException {
        String firstname = request.getParameter("user-firstname");
        String lastname = request.getParameter("user-lastname");
        String gender = request.getParameter("user-gender");
        String dob = request.getParameter("user-date");
        String address = request.getParameter("user-address");
        String mail = request.getParameter("user-mail");
        String phone = request.getParameter("user-phone");
        String role = request.getParameter("user-role");
        String username = request.getParameter("user-userName");
        String password = request.getParameter("user-password");

        UserEntity user = new UserEntity();
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = formatter1.parse(dob);
        Date date = new Date();
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setGender(gender);
        user.setDate(date1);
        user.setAddress(address);
        user.setMail(mail);
        user.setPhoneNumber(phone);
        if (role.equals("admin")) user.setRole(UserRole.ADMIN);
        else user.setRole(UserRole.USER);
        user.setUserName(username);
        String passwordHash = this.hashPassword(password);
        user.setPassword(passwordHash);
        user.setStatus(true);
        user.setCreated(date);
        user.setModified(date);

        userService.saveUser(user);


        return "redirect:danh-sach";
    }

    @RequestMapping(value = "/chinh-sua", method = RequestMethod.GET)
    public String editUser(HttpServletRequest request, Model model) throws ParseException {
        String id = request.getParameter("id");
        UserEntity userEntity = userService.getUser(Integer.parseInt(id));
        Date d = userEntity.getDate();
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
        String date1 = formatter1.format(d);
        model.addAttribute("date", date1);
        model.addAttribute("user", userEntity);
        return "admin/user-edit-form";
    }

    @RequestMapping(value = "/chinh-sua", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String updateUser(Model model, HttpServletRequest request) throws ParseException, NoSuchAlgorithmException {
        String id = request.getParameter("user-id");
        String firstname = request.getParameter("user-firstname");
        String lastname = request.getParameter("user-lastname");
        String gender = request.getParameter("user-gender");
        String dob = request.getParameter("user-date");
        String address = request.getParameter("user-address");
        String mail = request.getParameter("user-mail");
        String role = request.getParameter("user-role");
        String status = request.getParameter("user-status");
        UserEntity user = new UserEntity();
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = formatter1.parse(dob);
        Date date = new Date();

        user.setId(Integer.parseInt(id));
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setGender(gender);
        user.setDate(date1);
        user.setAddress(address);
        user.setMail(mail);
        user.setRole(role);
        user.setModified(date);
        user.setStatus(status != null);
        userService.saveUser(user);
        return "redirect:danh-sach";
    }

    @RequestMapping(value = "/xoa", method = RequestMethod.GET)
    public String deleteUser(HttpServletRequest request, Model model) {
        String id = request.getParameter("id");
        userService.deleteUser(Integer.parseInt(id));
        return "redirect:danh-sach";


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