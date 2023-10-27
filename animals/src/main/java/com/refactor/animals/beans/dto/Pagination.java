package com.refactor.animals.beans.dto;

import lombok.Data;
import lombok.Getter;

@Data
public class Pagination {

    private int totalRecordCount;   //전체 데이터 수
    private int totalPageCount;     //전체 페이지 수
    private int startPage;          //첫 페이지 번호
    private int endPage;            //끝 페이지 번호
    private int limitStart;         //limit 시작위치
    private boolean existPrevPage;  //이전 페이지 존재 여부
    private boolean existNextPage;  //다음 페이지 존재여부

    public Pagination(int totalRecordCount, SearchDto params) {
        if(totalRecordCount > 0){

            this.totalRecordCount = totalRecordCount;
            calculation(params);
        }

    }


    private void calculation(SearchDto params){
        //전체 페이지 수 계산

        totalPageCount = ((totalRecordCount - 1) / params.getRecordSize()) +1;

        startPage = ((params.getPage() - 1) / params.getPageSize()) * params.getPageSize()+1;

        endPage = startPage + params.getPageSize() - 1;

        //끝 페이지가 전체 페이지 수 보다 큰 경우, 끝 페이지 전체 페이지 수에 저장
        if(endPage > totalPageCount){
            endPage = totalPageCount;
        }

        //limit 시작 위치 계산
        limitStart  = (params.getPage() - 1) * params.getRecordSize();

        //이전 페이지 존재 여부 확인
        existPrevPage = startPage != 1;

        //다음 페이지 존재 여부 확인
        existNextPage = (endPage * params.getRecordSize()) < totalRecordCount;
    }

}
