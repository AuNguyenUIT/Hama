/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hama.Hama.controller.admin;


import com.hama.Hama.entities.UserEntity;
import com.hama.Hama.service.UserService;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/quan-tri/user")
public class AdminUserController{
    
     @Autowired
     UserService userService;
     
     @RequestMapping("/danh-sach")
    public String getListUser(Model model) {
        List<UserEntity> userEntityList = userService.getUsers();
        model.addAttribute("userList", userEntityList);
        return "admin/user";
    }
    
    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String showUserAddForm(Model model){
        return "admin/user-add-form";
    }
    @RequestMapping(value="/add", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String addUser(Model model, HttpServletRequest request,HttpServletResponse response, @RequestParam("thumb") MultipartFile multipartFile) throws ParseException, InterruptedException {
        String firstname = request.getParameter("user-firstname");
        String lastname = request.getParameter("user-lastname");
        String gender = request.getParameter("user-gender");
        String dob = request.getParameter("user-date");
        String address = request.getParameter("user-address");
        String mail = request.getParameter("user-mail");
        String phone = request.getParameter("user-phone");
        String username = request.getParameter("user-userName");
        String password = request.getParameter("user-password");
        UserEntity user = new UserEntity();
        SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd"); 
        Date date1=formatter1.parse(dob);
        Date date = new Date();
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setGender(gender);
        user.setDate(date1);
        user.setAddress(address);
        user.setMail(mail);
        user.setPhoneNumber(phone);
        user.setUserName(username);
        user.setPassword(password);
        user.setCreated(date);
        user.setModified(date);
        user.setRole("user");
        String fileName = multipartFile.getOriginalFilename();
        if (fileName != null && !fileName.equals("")) {
            try {
                File folderUpload = new File(request.getServletContext().getRealPath("resources/upload/user"));
                if (!folderUpload.exists()) {
                    folderUpload.mkdirs();
                }
                File file = new File(folderUpload, fileName);
                multipartFile.transferTo(file);
                user.setPicture(fileName);
            } catch (Exception e) {
                user.setPicture(null);

                System.out.println(e.getMessage());
            }
        }
        userService.saveUser(user);
       
      

        return "redirect:danh-sach";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String editUser(HttpServletRequest request, Model model) {
        String id = request.getParameter("id");
        UserEntity userEntity = userService.getUser(Integer.parseInt(id));
        model.addAttribute("user", userEntity);
        return "admin/user-edit-form";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String updateUser(Model model, HttpServletRequest request,  @RequestParam("thumb") MultipartFile multipartFile) throws ParseException{
        String id = request.getParameter("user-id");
        String firstname = request.getParameter("user-firstname");
        String lastname = request.getParameter("user-lastname");
        String gender = request.getParameter("user-gender");
        String dob = request.getParameter("user-date");
        String address = request.getParameter("user-address");
        String mail = request.getParameter("user-mail");
        String phone = request.getParameter("user-phone");
        String username = request.getParameter("user-userName");
        String password = request.getParameter("user-password");
        UserEntity user = new UserEntity();
        SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd"); 
        Date date1=formatter1.parse(dob);
        Date date = new Date();
       
        user.setId(Integer.parseInt(id));
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setGender(gender);
        user.setDate(date1);
        user.setAddress(address);
        user.setMail(mail);
        user.setPhoneNumber(phone);
        user.setUserName(username);
        user.setPassword(password);
        user.setCreated(date);
        user.setModified(date);
        user.setRole("user");
        String fileName = multipartFile.getOriginalFilename();
        if (fileName != null && !fileName.equals("")) {
            try {
                File folderUpload = new File(request.getServletContext().getRealPath("resources/upload/user/"+id));
                if (!folderUpload.exists()) {
                    folderUpload.mkdirs();
                }
                File file = new File(folderUpload, fileName);
                multipartFile.transferTo(file);
                user.setPicture(fileName);
            } catch (Exception e) {
                user.setPicture(null);

                System.out.println(e.getMessage());
            }
        }
        userService.saveUser(user);
        

        return "redirect:danh-sach";
    }
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteUser(HttpServletRequest request, Model model) {
        String id = request.getParameter("id");
        userService.deleteUser(Integer.parseInt(id));

       
       return  "redirect:danh-sach";
     

    }
}