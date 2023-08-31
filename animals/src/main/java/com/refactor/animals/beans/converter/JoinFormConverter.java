package com.refactor.animals.beans.converter;

import com.refactor.animals.beans.dto.JoinFormDTO;
import com.refactor.animals.beans.entity.JoinFormEntity;

public class JoinFormConverter {

    private static String getBeanNullCheck(String bean){
        return bean !=null ? bean : "none";
    }
    public static JoinFormDTO joinFormEntityToDTO(JoinFormEntity entity){
        JoinFormDTO dto = new JoinFormDTO();
        dto.setLoginId(entity.getLoginId());
        dto.setPassword(entity.getPassword());
        dto.setName(entity.getName());
        dto.setNickName(entity.getNickName());
        dto.setPhone(entity.getPhone());
        dto.setPostcode(entity.getPostcode());
        dto.setAddress(entity.getAddress());
        dto.setDetailAddress(entity.getDetailAddress());
        dto.setExtraAddress(entity.getExtraAddress());
        return dto;
    }

    public static JoinFormEntity joinFormDtoToEntity(JoinFormDTO dto){
        JoinFormEntity entity = new JoinFormEntity();
        entity.setLoginId(dto.getLoginId());
        entity.setPassword(dto.getPassword());
        entity.setName(dto.getName());
        entity.setNickName(dto.getNickName());
        entity.setPhone(dto.getPhone());
        entity.setPostcode(getBeanNullCheck((dto.getPostcode())));
        entity.setAddress(getBeanNullCheck(dto.getAddress()));
        entity.setDetailAddress(getBeanNullCheck(dto.getDetailAddress()));
        entity.setExtraAddress(getBeanNullCheck(dto.getExtraAddress()));
        return entity;
    }



}
