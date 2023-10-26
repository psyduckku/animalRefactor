package com.refactor.animals.common.config;

import com.refactor.animals.repository.AnimalBoardRepository;
import com.refactor.animals.repository.mybatis.MybatisAnimalBoardRepository;
import com.refactor.animals.repository.mybatis.AnimalBoardMapper;
import com.refactor.animals.service.AnimalBoardService;
import com.refactor.animals.service.serviceImpl.AnimalBoardServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MyBatisConfig {

    private final AnimalBoardMapper animalBoardMapper;
    @Bean
    public AnimalBoardService AnimalBoardService(){
        return new AnimalBoardServiceImpl(animalBoardRepository());
    } //말그대로 animalservice->repository 순으로 빈을 주입받고자 하는것
    //내가 여기서 bean을 등록했고, ServiceImpl 인스턴스를 생성하기 때문에 Impl의 @Service를 지우니 해결됨
    @Bean
    public AnimalBoardRepository animalBoardRepository(){
        return new MybatisAnimalBoardRepository(animalBoardMapper);
    }
}
