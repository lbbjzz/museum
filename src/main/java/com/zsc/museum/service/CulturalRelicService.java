package com.zsc.museum.service;

import com.zsc.museum.mapper.CulturalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CulturalRelicService {
    @Autowired
    public CulturalMapper culturalMapper;

    public String value(String price, String id) {
        return culturalMapper.value(price, id);
    }


    public String imgFileName(String imgFileName, String id) {
        return culturalMapper.imgFileName(imgFileName, id);
    }

//    public String select(String imgId) {
//        return culturalMapper.select(imgId);
//    }
    //public String picture(Blob picture, String id) {
    //    return culturalMapper.picture(picture, id);
    //}
}
