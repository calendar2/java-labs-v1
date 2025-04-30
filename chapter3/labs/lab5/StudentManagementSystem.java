package chapter3.labs.lab5;

import java.util.Scanner;

/**
 * 학생 성적 관리 프로그램 (종합 프로젝트)
 */
public class StudentManagementSystem {
    // TODO: 학생 성적 등급을 나타내는 Grade Enum을 정의하세요.
    // A(90-100), B(80-89), C(70-79), D(60-69), F(0-59) 등급이 있어야 합니다.
    
    // 최대 학생 수
    private static final int MAX_STUDENTS = 100;
    
    // 학생 정보 배열
    private static String[] names = new String[MAX_STUDENTS]; // 이름 배열
    private static int[] scores = new int[MAX_STUDENTS]; // 성적 배열
    private static int studentCount = 0; // 현재 저장된 학생 수
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        System.out.println("===== 학생 성적 관리 프로그램 =====");
        
        while (running) {
            printMenu();
            int choice = getMenuChoice(scanner);
            String name;
            int score;
            int index;
            
            switch (choice) {
                case 1:
                    // TODO: 성적 입력 기능을 구현하세요.
                    // 학생 이름과 성적을 입력받아 배열에 저장합니다.
                    System.out.println("학생 이름을 입력해주세요.");
                    name = scanner.next();
                    System.out.println("성적을 입력해주세요.");
                    score = scanner.nextInt();

                    names[studentCount] = name;
                    scores[studentCount] = score;
                    studentCount += 1;
                    break;
                case 2:
                    // TODO: 성적 수정 기능을 구현하세요.
                    // 학생 이름을 입력받아 해당 학생의 성적을 수정합니다.
                    System.out.println("성적을 수정할 학생의 이름을 입력해주세요.");
                    name = scanner.next();
                    System.out.println("수정된 성적을 입력해주세요.");
                    score = scanner.nextInt();

                    index = searchIndex(name);
                    scores[index] = score;
                    
                    break;
                case 3:
                    // TODO: 성적 조회 기능을 구현하세요.
                    // 모든 학생의 이름, 성적, 등급을 출력합니다.
                    // 전체 성적의 합계, 평균, 최고 성적, 최저 성적도 출력합니다.
                    for (int i = 0; i < studentCount; i++) {
                        System.out.print("이름: " + names[i]);
                        System.out.print(", 성적: " + scores[i]);
                        System.out.println(", 등급: " + getGrade(scores[i]));
                    }

                    System.out.println("합계 성적: " + totalScore());
                    System.out.println("평균 성적: " + meanScore());
                    System.out.println("최고 성적: " + findMaximumScore());
                    System.out.println("최저 성적: " + findMinimumScore());
                    
                    break;
                case 4:
                    // TODO: 검색 기능을 구현하세요.
                    // 학생 이름을 입력받아 해당 학생의 성적과 등급을 조회합니다.
                    System.out.println("검색할 학생의 이름을 입력해주세요.");
                    name = scanner.next();
                    index = searchIndex(name);

                    System.out.print("이름: " + names[index]);
                    System.out.print(", 성적: " + scores[index]);
                    System.out.println(", 등급: " + getGrade(scores[index]));
                    
                    break;
                case 5:
                    // TODO: 통계 기능을 구현하세요.
                    // 등급별 학생 수와 비율을 출력합니다.
                    Grade[] grades = Grade.values();
                    int grade_len = grades.length;
                    int[] student_counts = new int[grade_len];

                    for (int i = 0; i < studentCount; i++) {
                        Grade grade = getGrade(scores[i]);
                        int grade_idx = grade.ordinal();
                        student_counts[grade_idx] += 1;
                    }

                    double[] grade_percentages = new double[grade_len];
                    for (int i = 0; i < grade_len; i++) {
                        grade_percentages[i] = Math.round(100.00 * student_counts[i] / studentCount);
                    }

                    System.out.println("=====통계=====");
                    for (int i = 0; i < grade_len; i++) {
                        System.out.println(grades[i] + "등급: " + student_counts[i] + "명, " + grade_percentages[i] + "%");
                    }
                    
                    break;
                case 6:
                    System.out.println("프로그램을 종료합니다.");
                    running = false;
                    break;
                default:
                    System.out.println("잘못된 메뉴 선택입니다. 다시 선택해주세요.");
                    break;
            }
        }
        
        scanner.close();
    }
    
    // 메뉴 출력 메소드
    private static void printMenu() {
        System.out.println("\n===== 메뉴 =====");
        System.out.println("1. 성적 입력");
        System.out.println("2. 성적 수정");
        System.out.println("3. 성적 조회");
        System.out.println("4. 학생 검색");
        System.out.println("5. 통계 보기");
        System.out.println("6. 종료");
        System.out.print("메뉴를 선택하세요: ");
    }
    
    // 메뉴 선택 입력 메소드
    private static int getMenuChoice(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine(); // 버퍼 비우기
            return -1; // 잘못된 입력
        } finally {
            scanner.nextLine(); // 버퍼 비우기
        }
    }
    
    // TODO: 성적으로부터 등급을 계산하는 메소드를 구현하세요.
    // 입력받은 성적에 따라 Grade Enum 상수를 반환합니다.
    private static Grade getGrade(int score) {
        if (score >= Grade.A.getMinScore()) {
            return Grade.A;
        } else if (score >= Grade.B.getMinScore()) {
            return Grade.B;
        } else if (score >= Grade.C.getMinScore()) {
            return Grade.C;
        } else if (score >= Grade.D.getMinScore()) {
            return Grade.D;
        } else {
            return Grade.F;
        }
    }
    
    // TODO: 전체 성적의 합계를 계산하는 메소드를 구현하세요.
    private static int totalScore() {
        int total = 0;
        for (int i = 0; i < studentCount; i++) {
            total += scores[i];
        }

        return total;
    }
    
    // TODO: 전체 성적의 평균을 계산하는 메소드를 구현하세요.
    private static int meanScore() {
        return totalScore() / studentCount;
    }
    
    // TODO: 최고 성적을 찾는 메소드를 구현하세요.
    private static int findMaximumScore() {
        int maximumScore = 0;
        for (int i = 0; i < studentCount; i++) {
            maximumScore = Math.max(maximumScore, scores[i]);
        }

        return maximumScore;
    }
    
    // TODO: 최저 성적을 찾는 메소드를 구현하세요.
    private static int findMinimumScore() {
        int minimum = 100;
        for (int i = 0; i < studentCount; i++) {
            minimum = Math.min(minimum, scores[i]);
        }

        return minimum;
    }
    
    // TODO: 학생 이름으로 배열에서 위치(인덱스)를 찾는 메소드를 구현하세요.
    private static int searchIndex(String name) {
        int index = -1;
        for (int i = 0; i < studentCount; i++) {
            if (names[i].equals(name)) {
                index = i;
                break;
            }
        }

        return index;
    }
    
} 