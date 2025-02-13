package com.webtourdl.WebTourDuLich.controller;

import com.webtourdl.WebTourDuLich.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    UserService userService;
    @GetMapping("/home")
    public String homeManage() {

        if(!this.userService.checkAdminLogin()) {
            return "redirect:/admin/login";
        }

        return "admin/home";
    }

    @GetMapping("/user")
    public String userManage() {

        if(!this.userService.checkAdminLogin()) {
            return "redirect:/admin/login";
        }

        return "admin/user";
    }

    @GetMapping("/tour")
    public String tourManage() {
        if(!this.userService.checkAdminLogin()) {
            return "redirect:/admin/login";
        }
        return "admin/tour";
    }

    @GetMapping("/blog")
    public String blogManage() {
        if(!this.userService.checkAdminLogin()) {
            return "redirect:/admin/blog";
        }
        return "admin/blog";
    }

    @GetMapping("/tourin")
    public String tourinManage() {
        if(!this.userService.checkAdminLogin()) {
            return "redirect:/admin/login";
        }
        return "admin/tourin";
    }

    @GetMapping("/tourout")
    public String touroutManage() {
        if(!this.userService.checkAdminLogin()) {
            return "redirect:/admin/login";
        }
        return "admin/tourout";
    }

    @GetMapping("/booking")
    public String bookingManager() {
        if(!this.userService.checkAdminLogin()) {
            return "redirect:/admin/login";
        }
        return "admin/booking";
    }

    @GetMapping("/statistical")
    public String statisticalManager() {
        if(!this.userService.checkAdminLogin()) {
            return "redirect:/admin/login";
        }
        return "admin/statistical";
    }

    @GetMapping("/login")
    public String adminLogin() {
        return "admin/login";
    }

    @GetMapping("/tourStart/{id}")
    public String tourStart(@PathVariable("id")Long id) {
        if(!this.userService.checkAdminLogin()) {
            return "redirect:/admin/login";
        }
        return "admin/tourstart";
    }
    @GetMapping("/tourImage/{id}")
    public String tourImage(@PathVariable("id") Long id) {
        if(!this.userService.checkAdminLogin()) {
            return "redirect:/admin/login";
        }
        return "admin/tourImage";
    }

    @GetMapping("/logout")
    public String adminLogout() {
        this.userService.adminLogout();
        return "redirect:/admin/login";
    }
}
