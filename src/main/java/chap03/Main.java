package chap03;

import chap03.service.ChangePasswordService;
import chap03.service.MemberRegisterService;
import chap03.service.RegisterRequest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static ApplicationContext applicationContext;

    static {
        applicationContext = new AnnotationConfigApplicationContext(
                AppContext1.class, AppContext2.class
        );
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        label:
        while (true) {
            System.out.println("명령어를 입력하세요: ");
            List<String> arguments = Arrays.asList(scanner.nextLine().split(" "));

            switch (arguments.get(0)) {
                case "exit":
                    break label;
                case "new":
                    registerProcess(arguments);
                    break;
                case "change":
                    changeProcess(arguments);
                    break;
            }
            printProcess();
        }
        System.out.println("시스템을 종료합니다.");
    }

    private static void registerProcess(final List<String> arguments) {
        MemberRegisterService memberRegisterService = applicationContext.getBean(
                "memberRegisterService", MemberRegisterService.class);

        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail(arguments.get(1));
        registerRequest.setName(arguments.get(2));
        registerRequest.setPassword(arguments.get(3));
        registerRequest.setConfirmPassword(arguments.get(4));

        memberRegisterService.register(registerRequest);
        System.out.println("회원가입을 완료했습니다.");
    }

    private static void changeProcess(final List<String> arguments) {
        ChangePasswordService changePasswordService = applicationContext.getBean(
                "changePasswordService", ChangePasswordService.class
        );

        changePasswordService.changePassword(
                arguments.get(1),
                arguments.get(2),
                arguments.get(3)
        );
        System.out.println("암호를 변경했습니다.");
    }

    private static void printProcess() {
        MemberPrinter memberPrinter = applicationContext.getBean(
                "memberPrinter", MemberPrinter.class
        );
        memberPrinter.print();
    }
}
