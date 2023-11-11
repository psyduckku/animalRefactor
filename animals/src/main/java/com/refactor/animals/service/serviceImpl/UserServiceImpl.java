package com.refactor.animals.service.serviceImpl;

import com.refactor.animals.beans.converter.JoinFormConverter;
import com.refactor.animals.beans.dto.JoinForm;
import com.refactor.animals.beans.entity.MemberVO;
import com.refactor.animals.beans.dto.LoginForm;
import com.refactor.animals.exception.UserException;
import com.refactor.animals.repository.mybatis.MybatisMemberRepository;
import com.refactor.animals.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    //
//    private final MemoryMemberRepository memberRepository; //여기가 그러면 DAO가 있어야함.
    private final MybatisMemberRepository memberRepository;
    private final BCryptPasswordEncoder encoder; //의존성주입됨
    //optional이 있는 값을 반환하려면 get()이 필요.
    //또한 get()사용하기전에 isPresent()로 값이 있는지 확인이 필요
    @Override
    public LoginForm login(LoginForm loginForm) {

        Optional<MemberVO> member = memberRepository.findMember(loginForm.getLogin_id());
        if(member.isPresent()){
            MemberVO finedMember = member.get();
            log.info("userImpl finedMember={}",finedMember);
            if(!encoder.matches(loginForm.getPassword(),finedMember.getPassword())){
                throw new UserException("비밀번호 불일치");
            }
        }else{
            throw new UserException("존재하지 않는 아이디");
        }
        return loginForm;
    }
    @Override
    public HttpStatus join(JoinForm joinForm) {
        //encoder필요
        log.info("userServiceImpl 진입");
        JoinFormConverter joinFormConverter = new JoinFormConverter();
        MemberVO convertedMember = joinFormConverter.converter(joinForm, encoder);
        memberRepository.save(convertedMember);
        return HttpStatus.OK;
    }

    @Override
    public List<MemberVO> memberList() {
        log.info("memberList접근");
       List<MemberVO> memberList = memberRepository.findAll();
       return memberList;
    }

    @Override
    public boolean isLoginIdDuplicate(String checkId) {
        return memberRepository.findMember(checkId).isPresent();
    }


}
