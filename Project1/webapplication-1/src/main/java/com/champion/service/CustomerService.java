package com.champion.service;


import com.champion.bean.TAdmin;
import com.champion.bean.TCustomer;
import com.github.pagehelper.PageHelper;
import com.champion.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service


@Transactional

public class CustomerService {
    @Autowired
    private CustomerMapper customerMapper;



    public List<TCustomer> findCustomerList(int currentPage, int pageSize, String customer_name) {
        // 启动分页
        PageHelper.startPage(currentPage, pageSize);
        // 返回所有查询到的信息

        Example example = new Example(TCustomer.class);

        if (customer_name.length()>0) {
            example.createCriteria().andCondition("customer_name like " + "'" + '%' + customer_name + '%' + "'");
        }
        else {
            example.createCriteria();

        }
        List<TCustomer> customerList = customerMapper.selectByExample(example);
        return customerList;
    }

    public TCustomer findCustomerById(Integer customer_id) {
        Example example = new Example(TCustomer.class);
        example.createCriteria()
                .andEqualTo("customer_id", customer_id);

        TCustomer customerrecord = customerMapper.selectByExample(example).get(0);
        return customerrecord;
    }


    public int updateCustomer(TCustomer customer)
    {
       // return customerDao.updateCustomer(customer);

        Example example = new Example(TCustomer.class);
        example.createCriteria();
        if(customerMapper.updateByPrimaryKey(customer)==1)
        {
            return 1;
        }


     else {
         return 0;
        }
    }

    public int saveCustomer(TCustomer customer)
    {
        Example example = new Example(TCustomer.class);
        example.createCriteria();

        if(customerMapper.insert(customer)==1)
        {
            return 1;
        }


        else {
            return 0;
        }

    }


    public TCustomer checkCustomer(String customer_username)
    {

        Example example = new Example(TCustomer.class);
        example.createCriteria().andEqualTo("customer_name", customer_username);
if(!customerMapper.selectByExample(example).isEmpty()==true)
        {return customerMapper.selectByExample(example).get(0);}
        else {

            return null;
    }

    }


}
