package com.zsc.museum;

import com.zsc.museum.domain.Cultural_relic;
import com.zsc.museum.mapper.CulturalMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MuseumApplicationTests {

    @Autowired
    CulturalMapper culturalMapper;
    @Test
    void contextLoads() {
        Cultural_relic relic = culturalMapper.SelectOne(1L);
        System.out.println(relic);
    }

}
