package com.refactor.animals.beans.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class SearchDto {

    private int page;           //현재 페이지번호
    private int recordSize;     //페이지당 출력할 데이터 개수
    private int pageSize;       //화면 하단에 출력할 페이지 사이즈
    private String keyword;     // 검색 키워드
    private String searchType;  // 검색 유형
    private Pagination pagination; //페이지네이션정보

    private String sortRegion;      //지역분류
    private String sortSpecies;     //종분류

    public SearchDto() {            //최초 페이지
        this.page = 1;
        this.recordSize = 10;
        this.pageSize = 10;
    }

    public int getOffset(){         //페이지 시작지잠을 반환함 해당 페이지에서 +10
        return (page - 1) * recordSize;
    }

}
