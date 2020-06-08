package com.zsc.museum.service;

import com.zsc.museum.domain.Staff;
import com.zsc.museum.mapper.StaffMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffService {
    @Autowired
    public StaffMapper staffMapper;

    public String login(String number, String password) {
        return staffMapper.login(number, password);
    }


    public String status(int path, int id) {
        return staffMapper.status(path, id);
    }

    public String selectstatus(int path) {
        return staffMapper.selectstatus(path);
    }
}
