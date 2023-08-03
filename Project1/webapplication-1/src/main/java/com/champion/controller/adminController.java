package com.champion.controller;


import com.champion.service.AdminService;
import com.champion.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/AdminController")

public class adminController {

    @Autowired
    AdminService adminService;

    @GetMapping("/checkLogin")
    public Result checkLogin(@RequestParam String username, @RequestParam String password)
    {
        if (adminService.login(username,password) == true) {
            return Result.success("恭喜登录成功！");
        }
        else{

            return Result.error("登录失败！");

        }

    }





}
