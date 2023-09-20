package com.refactor.animals.beans.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@AllArgsConstructor //전체필드 생성자-> null값 처리로 생략
@NoArgsConstructor //기본생성자
@Data
public class AddressForm {
    private String address;
    private String postcode;
    private String detailAddress;
    private String extraAddress;

    public AddressForm(String address, String postcode, String detailAddress, String extraAddress){
        this.address=(address!=null)?address:"미기입";
        this.postcode=(postcode!=null)?postcode:"00000";
        this.detailAddress=(detailAddress!=null)?detailAddress:"미기입";
        this.extraAddress=(extraAddress!=null)?extraAddress:"미기입";
    }

}
