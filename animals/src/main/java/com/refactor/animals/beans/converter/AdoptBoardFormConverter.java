package com.refactor.animals.beans.converter;

import com.refactor.animals.beans.dto.AdoptBoardForm;
import com.refactor.animals.beans.entity.AdoptBoardVO;

public class AdoptBoardFormConverter {

    public AdoptBoardVO converter(AdoptBoardForm form){
        return new AdoptBoardVO(form.getLogin_id(), form.getTitle(), form.getContent());
    }

}
