package com.refactor.animals.config;

import com.refactor.animals.repository.AnimalBoardRepository;
import com.refactor.animals.repository.MybatisAnimalBoardRepository;
import com.refactor.animals.repository.mybatis.AnimalBoardMapper;
import com.refactor.animals.service.AnimalBoardService;
import com.refactor.animals.service.serviceImpl.AnimalBoardServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class MyBatisConfig {

    private final AnimalBoardMapper animalBoardMapper;
    @Bean
    public AnimalBoardService AnimalBoardService(){
        return new AnimalBoardServiceImpl(animalBoardRepository());
    } //말그대로 animalservice->repository 순으로 빈을 주입받고자 하는것
    @Bean
    public AnimalBoardRepository animalBoardRepository(){
        return new MybatisAnimalBoardRepository(animalBoardMapper);
    }


}
