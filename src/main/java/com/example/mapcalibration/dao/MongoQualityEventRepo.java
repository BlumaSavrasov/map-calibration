package com.example.mapcalibration.dao;

import com.example.mapcalibration.model.QualityEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;

import static com.example.mapcalibration.constant.Profiles.MONGO;



@Profile(MONGO)
public interface MongoQualityEventRepo extends QualityEventRepo, MongoRepository<QualityEvent,String> {

}
