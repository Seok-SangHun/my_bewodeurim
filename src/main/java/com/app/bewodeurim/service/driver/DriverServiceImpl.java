package com.app.bewodeurim.service.driver;

import com.app.bewodeurim.domain.driver.DriverDTO;
import com.app.bewodeurim.domain.member.MemberVO;
import com.app.bewodeurim.repository.driver.DriverDAO;
import com.app.bewodeurim.repository.member.MemberDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Primary
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class DriverServiceImpl implements DriverService {
    private final DriverDAO driverDAO;
    private final MemberDAO memberDAO;


    @Override
    public void registerDriver(DriverDTO driverDTO) {
        MemberVO memberVO = driverDTO.toMemberVO();

        memberDAO.saveMember(memberVO);
        driverDTO.setId(memberVO.getId());
        driverDAO.saveDriver(driverDTO.toDriverVO());
    }
}
