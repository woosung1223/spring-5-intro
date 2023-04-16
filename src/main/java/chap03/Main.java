package chap03;

import chap03.service.ChangePasswordService;
import chap03.service.MemberRegisterService;
import chap03.service.RegisterRequest;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Assembler assembler = new Assembler();

        label:
        while (true) {
            System.out.println("명령어를 입력하세요: ");
            List<String> arguments = Arrays.asList(scanner.nextLine().split(" "));

            switch (arguments.get(0)) {
                case "exit":
                    break label;
                case "new":
                    registerProcess(arguments, assembler);
                    break;
                case "change":
                    changeProcess(arguments, assembler);
                    break;
            }
        }
        System.out.println("시스템을 종료합니다.");
    }

    private static void registerProcess(final List<String> arguments, final Assembler assembler) {
        MemberRegisterService memberRegisterService = assembler.getMemberRegisterService();

        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail(arguments.get(1));
        registerRequest.setName(arguments.get(2));
        registerRequest.setPassword(arguments.get(3));
        registerRequest.setConfirmPassword(arguments.get(4));

        memberRegisterService.register(registerRequest);
        System.out.println("회원가입을 완료했습니다.");
    }

    private static void changeProcess(final List<String> arguments, final Assembler assembler) {
        ChangePasswordService changePasswordService = assembler.getChangePasswordService();

        changePasswordService.changePassword(
                arguments.get(1),
                arguments.get(2),
                arguments.get(3)
        );
        System.out.println("암호를 변경했습니다.");
    }

}
