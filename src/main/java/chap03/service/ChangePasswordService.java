package chap03.service;

import chap03.entity.Member;
import chap03.dao.MemberDao;
import chap03.exception.MemberNotFoundException;

public class ChangePasswordService {

    private MemberDao memberDao;

    public void changePassword(
            final String email,
            final String oldPassword,
            final String newPassword
    ) {
        Member member = memberDao.selectByEmail(email);
        if (member == null) {
            throw new MemberNotFoundException();
        }

        member.changePassword(oldPassword, newPassword);
        memberDao.update(member);
    }

    public void setMemberDao(final MemberDao memberDao) {
        this.memberDao = memberDao;
    }
}
