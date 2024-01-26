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
    public MemberVO login(LoginForm loginForm) {
//MemberVO 생성자를 만들어 아이디, grade, 등의 정보만을 반환하도록 함.
        Optional<MemberVO> member = memberRepository.findMember(loginForm.getLogin_id());
        if(!member.isPresent()){
            throw new UserException("존재하지 않는 아이디.");
        }
        MemberVO finedMember = member.get();
        log.info("userImpl finedMember={}",finedMember);

        if(!encoder.matches(loginForm.getPassword(),finedMember.getPassword())){
            throw new UserException("비밀번호 불일치");
        }

        //여기서 필요한 정보만 골라내서 반환.
//        id,login_id,update_info_password,nickname,access_time,access_ip,browse
        MemberVO returnInfo = new MemberVO(finedMember.getId(), finedMember.getLogin_id(),finedMember.getUpdate_info_password(),
                finedMember.getNickname(),finedMember.getAccess_time(),finedMember.getAccess_ip(),finedMember.getBrowser(), finedMember.getGrade());



        return returnInfo;
    }
    @Override
    public HttpStatus join(JoinForm joinForm) {
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

    @Override
    public void updateAccessTime(MemberVO vo) {
        memberRepository.updateAccessTime(vo);
    }


}
