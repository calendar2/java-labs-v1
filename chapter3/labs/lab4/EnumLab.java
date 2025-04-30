package chapter3.labs.lab4;

import java.util.Scanner;

/**
 * Enum(열거형) 활용하기 실습
 */
public class EnumLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 1. 요일 Enum 활용하기
        System.out.println("===== 요일 Enum 활용하기 =====");
        System.out.println("요일을 입력하세요 (월, 화, 수, 목, 금, 토, 일): ");
        String input = scanner.nextLine();
        
        // TODO: 입력받은 요일에 해당하는 DayOfWeek Enum 상수를 찾아 switch 문에서 활용하세요.
        // 평일(월~금)인 경우 "평일입니다."를, 주말(토, 일)인 경우 "주말입니다."를 출력하세요.
        DayOfWeek today = DayOfWeek.MONDAY;
        for (DayOfWeek day : DayOfWeek.values()) {
            if (input.charAt(0) == day.description) {
                today = day;
            }
        }

        switch (today) {
            case MONDAY: case TUESDAY: case WEDNESDAY: case THURSDAY:  case FRIDAY:
                System.out.println("평일입니다.");
                break;
            case SATURDAY:  case SUNDAY:
                System.out.println("주말입니다.");
                break;
        }
        
        // 2. 계절 Enum 활용하기
        System.out.println("\n===== 계절 Enum 활용하기 =====");
        System.out.println("월을 입력하세요 (1-12): ");
        int month = scanner.nextInt();
        
        // TODO: 입력받은 월에 해당하는 Season Enum 상수를 찾아 해당 계절의 특징을 출력하세요.
        // Season Enum에 평균 기온과 특징을 필드로 추가하고, 이를 활용하세요.
        switch (month) {
            case 1: case 2: case 12:
                System.out.println("겨울: " + Season.WINTER.description);
                break;
            case 3: case 4: case 5:
                System.out.println("봄: " + Season.SPRING.description);
                break;
            case 6:  case 7: case 8:
                System.out.println("여름: " + Season.SUMMER.description);
                break;
            case 9: case 10: case 11:
                System.out.println("가을: " + Season.FALL.description);
                break;
        }
        
        // 3. 상태 전이 Enum 활용하기
        System.out.println("\n===== 상태 전이 Enum 활용하기 =====");
        
        // TODO: TaskStatus Enum을 구현하고, 상태 전이 로직을 활용하여 작업 상태를 변경하세요.
        // TaskStatus는 PENDING, IN_PROGRESS, COMPLETED, ARCHIVED 상태를 가지며,
        // nextStatus() 메소드를 통해 다음 상태로 전이할 수 있어야 합니다.
        // 사용자가 "next"를 입력할 때마다 상태를 다음 단계로 변경하고, 현재 상태를 출력하세요.
        // 사용자가 "exit"를 입력하면 종료합니다.
        TaskStatus current_status = TaskStatus.PENDING;
        while (true) {
            System.out.println("현재 상태: " + current_status);
            System.out.println("'next' 또는 'exit'을 입력해주세요.");
            String oper = scanner.next();
            if (oper.equals("next")) {
                current_status = current_status.nextStatus();
            } else {
                break;
            }
        }
        
        // 4. 연산자 Enum 활용하기
        System.out.println("\n===== 연산자 Enum 활용하기 =====");
        scanner.nextLine(); // 버퍼 비우기
        
        // TODO: Operator Enum을 구현하고, 두 수에 대한 사칙연산을 수행하세요.
        // Operator는 ADD(+), SUBTRACT(-), MULTIPLY(*), DIVIDE(/) 연산을 가지며,
        // calculate() 메소드를 통해 두 수에 대한 연산을 수행할 수 있어야 합니다.
        // 사용자로부터 두 수와 연산자를 입력받아 계산 결과를 출력하세요.
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        System.out.println(num1 + " " + Operation.ADD.symbol + " " + num2 + " = " + Operation.ADD.calculate(num1, num2));
        System.out.println(num1 + " " + Operation.SUBTRACT.symbol + " " + num2 + " = " + Operation.SUBTRACT.calculate(num1, num2));
        System.out.println(num1 + " " + Operation.MULTIPLY.symbol + " " + num2 + " = " + Operation.MULTIPLY.calculate(num1, num2));
        System.out.println(num1 + " " + Operation.DIVIDE.symbol + " " + num2 + " = " + Operation.DIVIDE.calculate(num1, num2));
        
        scanner.close();
    }

    enum DayOfWeek {
        MONDAY('월'),
        TUESDAY('화'),
        WEDNESDAY('수'),
        THURSDAY('목'),
        FRIDAY('금'),
        SATURDAY('토'),
        SUNDAY('일');

        private final char description;

        DayOfWeek(char description) {
            this.description = description;
        }

        public char getDescription() {
            return description;
        }
    }

    enum Season {
        SPRING("꽃이 피는 계절", 15),
        SUMMER("더운 계절", 28),
        FALL("낙엽이 떨어지는 계절", 18),
        WINTER("추운 계절", 5);

        private final String description;
        private final int averageTemperature;

        // 생성자 (private이 기본값)
        Season(String description, int averageTemperature) {
            this.description = description;
            this.averageTemperature = averageTemperature;
        }

        // Getter 메소드
        public String getDescription() {
            return description;
        }

        public int getAverageTemperature() {
            return averageTemperature;
        }
    }

    enum TaskStatus {
        PENDING {
            @Override
            public TaskStatus nextStatus() {
                return TaskStatus.IN_PROGRESS;
            }
        },
        IN_PROGRESS {
            @Override
            public TaskStatus nextStatus() {
                return COMPLETED;
            }
        },
        COMPLETED {
            @Override
            public TaskStatus nextStatus() {
                return ARCHIVED;
            }
        },
        ARCHIVED {
            @Override
            public TaskStatus nextStatus() {
                return PENDING; // 다시 처음으로
            }
        };

        // 상태 전이를 위한 추상 메소드
        public abstract TaskStatus nextStatus();
    }

    enum Operation {
        ADD("+") {
            @Override
            public int calculate(int x, int y) {
                return x + y;
            }
        },
        SUBTRACT("-") {
            @Override
            public int calculate(int x, int y) {
                return x - y;
            }
        },
        MULTIPLY("*") {
            @Override
            public int calculate(int x, int y) {
                return x * y;
            }
        },
        DIVIDE("/") {
            @Override
            public int calculate(int x, int y) {
                return x / y;
            }
        };

        private final String symbol;

        Operation(String symbol) {
            this.symbol = symbol;
        }

        @Override
        public String toString() {
            return symbol;
        }

        // 추상 메소드 (각 상수에서 구현해야 함)
        public abstract int calculate(int x, int y);
    }
}