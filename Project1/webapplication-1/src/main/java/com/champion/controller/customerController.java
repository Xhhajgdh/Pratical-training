package com.champion.controller;

import com.champion.bean.TCustomer;
import com.champion.service.AdminService;
import com.champion.service.CustomerService;
import com.champion.utils.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/CustomerController")

public class customerController {


    /**
     * 分页查询所有用户
     *
     * @param currentPage   传入当前页数
     * @param pageSize      传入当前页数数据数
     * @param customer_name 传入搜索名
     * @return 分页返回查询用户
     */

    @Autowired
    CustomerService customerService;
    @GetMapping("/findCustomerList")
    public Result findCustomerList(
            @RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
            @RequestParam(value = "pageSize", defaultValue = "6") int pageSize,
            @RequestParam(value = "customer_name", defaultValue = "") String customer_name) {

        List<TCustomer> customerList = customerService.findCustomerList(currentPage, pageSize, customer_name);
        //分页对象
        PageInfo pageInfo = new PageInfo(customerList);

        return Result.success(pageInfo, "查询成功");
    }



    @GetMapping("/findCustomerById")
    public Result findCustomerById(@RequestParam("customer_id") Integer customer_id) {
        TCustomer customer = customerService.findCustomerById(customer_id);
        if (null != customer) {
            return Result.success(customer, "客户查询成功");
        } else {
            return Result.success("客户查询失败");
        }
    }


    @PostMapping("/saveCustomer")
    public Result saveCustomer(@RequestBody TCustomer customer) {
        if (customer.getCustomer_name() == null || customer.getCustomer_tel() ==null || customer.getCustomer_username() == null){
            return Result.error("客户增加失败");
        }else{
            if(customerService.checkCustomer(customer.getCustomer_username())!=null){
                return Result.error("添加失败");
            }else{

                try {
                    int i = customerService.saveCustomer(customer);
                    if (i > 0) {
                        return Result.success("客户增加成功");
                    } else {
                        return Result.error("客户增加失败");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return Result.error("程序异常，客户增加失败");
                }
            }

        }
    }

    /**
     * 修改用户
     *
     * @param customer 传入修改用户后的实体
     * @return 执行结果
     */
    @PutMapping("/updateCustomer")
    public Result updateCustomer(@RequestBody TCustomer  customer) {
        try {
            int i = customerService.updateCustomer(customer);
            if (i > 0) {
                return Result.success("客户修改成功");
            } else {
                return Result.error("客户修改失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("程序异常，客户修改失败");
        }
    }


}
