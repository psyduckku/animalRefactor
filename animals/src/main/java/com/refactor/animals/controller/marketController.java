package com.refactor.animals.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequestMapping("/market")
public class marketController {

    public String index(){

        return "marketHome";
    }
}
