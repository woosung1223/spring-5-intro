package chap03;

import chap03.dao.MemberDao;
import chap03.service.ChangePasswordService;
import chap03.service.MemberRegisterService;

public class Assembler {

    private MemberDao memberDao;
    private ChangePasswordService changePasswordService;
    private MemberRegisterService memberRegisterService;

    public Assembler() {
        this.memberDao = new MemberDao();
        this.memberRegisterService = new MemberRegisterService(memberDao);
        this.changePasswordService = new ChangePasswordService();

        this.changePasswordService.setMemberDao(memberDao);
    }

    public MemberDao getMemberDao() {
        return memberDao;
    }

    public ChangePasswordService getChangePasswordService() {
        return changePasswordService;
    }

    public MemberRegisterService getMemberRegisterService() {
        return memberRegisterService;
    }
}
