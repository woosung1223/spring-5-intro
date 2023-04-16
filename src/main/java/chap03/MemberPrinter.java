package chap03;

import chap03.dao.MemberDao;

public class MemberPrinter {

    private MemberDao memberDao;

    public MemberPrinter(final MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public void print() {
        memberDao.selectAll()
                .forEach(member -> {
                    System.out.println("아이디 : " + member.getId() +
                            "이메일 : " + member.getEmail() +
                            "이름 : " + member.getName() +
                            "등록일 : " + member.getRegisterDateTime());
                });
    }
}
