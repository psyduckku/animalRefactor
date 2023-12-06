package com.refactor.animals.beans.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class AnimalBoardVO {

//    @Column(name="aseq")
    private int ASEQ;
//    @Column(name="sigunCd")
    private String SIGUN_CD; //시군코드
//    @Column(name="sigunNm")
    private String SIGUN_NM; //시군명
//    @Column(name="abdmIdntfyNo")
    private String ABDM_IDNTFY_NO; //유기고유번호
//    @Column(name="receptDe")
    private String RECEPT_DE; // 접수일자
//    @Column(name="discvryPlcInfo")
    private String DISCVRY_PLC_INFO; // 발견장소
//    @Column(name="stateNm")
    private String STATE_NM; // 상태
//    @Column(name="pblancIdntfyNo")
    private String PBLANC_IDNTFY_NO; // 공고고유번호

//    @Column(name="pblancBeginDe")
    private String PBLANC_BEGIN_DE; // 공고시작일자
//    @Column(name="pblancEndDe")
    private String PBLANC_END_DE; // 공고종료일자
//    @Column(name="speciesNm")
    private String SPECIES_NM; // 품종
//    @Column(name="colorNm")
    private String COLOR_NM; // 색상
//    @Column(name="ageInfo")
    private String AGE_INFO; // 나이
//    @Column(name="bdwghInfo")
    private String BDWGH_INFO; // 체중

    @Column(name="sexNm")
    private String SEX_NM; // 성별
    @Column(name="neutYn")
    private String NEUT_YN; // 중성화여부

    @Column(name="sfetrInfo")
    private String SFETR_INFO; // 특징

    @Column(name="shterNm")
    private String SHTER_NM; // 보호소명
    @Column(name="shterTelno")
    private String SHTER_TELNO; // 보호소전화번호
    @Column(name="protectPlc")
    private String PROTECT_PLC; // 보호장소
    @Column(name="refineRoadnmAddr")
    private String REFINE_ROADNM_ADDR; // 보호소도로명주소
    @Column(name="refineLotnoAddr")
    private String REFINE_LOTNO_ADDR; // 보호소지번주소
    @Column(name="refineZipCd")
    private String REFINE_ZIP_CD; // 보호소우편번호
    @Column(name="jurisdInstNm")
    private String JURISD_INST_NM; // 관할기관
    @Column(name="imageCours")
    private String IMAGE_COURS; // 이미지경로
    private String sortRegion;
    private String sortAnimal;




}