package com.champion.service;


import com.champion.bean.TAdmin;
import com.champion.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service

public class AdminService {
    @Autowired
    private AdminMapper adminMapper;

    public boolean login(String adminUsername, String adminPassword){
        Example example = new Example(TAdmin.class);
        example.createCriteria()
                .andEqualTo("adminUsername", adminUsername)
                .andEqualTo("adminPassword", adminPassword);

        List<TAdmin> userList = adminMapper.selectByExample(example);
        if (userList != null && !userList.isEmpty()) {
            return true;
        }
        else {

            return false;
        }


    }

}
