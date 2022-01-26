package com.example.mapcalibration.dao;

import com.example.mapcalibration.constant.Profiles;
import com.example.mapcalibration.model.QualityEvent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles(Profiles.MONGO)
class MongoQualityEventRepoTest {

    @Autowired
    MongoQualityEventRepo repo;

    @Test
    void testRepo(){
//        repo.save(QualityEvent.builder().roadId(1).localDate(LocalDate.now()).eventRate(0.5).build());
//        repo.save(QualityEvent.builder().roadId(2).localDate(LocalDate.now().minusDays(3)).eventRate(0.5).build());
//        repo.save(QualityEvent.builder().roadId(3).localDate(LocalDate.now().minusDays(4)).eventRate(0.5).build());
//        repo.save(QualityEvent.builder().roadId(4).localDate(LocalDate.now().minusDays(10)).eventRate(0.5).build());
//
//        repo.saveAll(List.of(QualityEvent.builder().roadId(12).localDate(LocalDate.now()).eventRate(0.5).eventRate(0.9).build(),QualityEvent.builder().roadId(13).localDate(LocalDate.now()).eventRate(0.5).build()));

        repo.findAll();

        System.out.println("");
    }

}