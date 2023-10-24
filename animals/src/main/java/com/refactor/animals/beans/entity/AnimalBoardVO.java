package com.refactor.animals.beans.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class AnimalBoardVO {

    private String SIGUN_CD; //시군코드
    private String SIGUN_NM; //시군명
    private String ABDM_IDNTFY_NO; //유기고유번호
    private String RECEPT_DE; // 접수일자
    private String DISCVRY_PLC_INFO; // 발견장소
    private String STATE_NM; // 상태
    private String PBLANC_IDNTFY_NO; // 공고고유번호
    private String PBLANC_BEGIN_DE; // 공고시작일자
    private String PBLANC_END_DE; // 공고종료일자
    private String SPECIES_NM; // 품종
    private String COLOR_NM; // 색상
    private String AGE_INFO; // 나이
    private String BDWGH_INFO; // 체중
    private String SEX_NM; // 성별
    private String NEUT_YN; // 중성화여부
    private String SFETR_INFO; // 특징
    private String SHTER_NM; // 보호소명
    private String SHTER_TELNO; // 보호소전화번호
    private String PROTECT_PLC; // 보호장소
    private String REFINE_ROADNM_ADDR; // 보호소도로명주소
    private String REFINE_LOTNO_ADDR; // 보호소지번주소
    private String REFINE_ZIP_CD; // 보호소우편번호
    private String JURISD_INST_NM; // 관할기관
    private String IMAGE_COURS; // 이미지경로
    private String sortRegion;
    private String sortAnimal;
    private String ASEQ;



}