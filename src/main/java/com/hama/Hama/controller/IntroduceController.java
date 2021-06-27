/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hama.Hama.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IntroduceController {
    @RequestMapping("/gioi-thieu")
    public String hello(Model model) {
        
        return "client/introduce";
    }
    
    @RequestMapping("/huong-dan-dat-hang")
    public String huongDanDatHang(Model model) {
        
        return "client/order";
    }
    
    @RequestMapping("/hinh-thuc-thanh-toan")
    public String hinhThucThanhToan(Model model) {
        
        return "client/payment";
    }
    
    
}
