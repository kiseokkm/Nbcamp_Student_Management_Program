# 🧮 내일배움캠프 수강생 관리 프로그램

* 과목
  * 필수 과목 : Java, 객체지향, Spring, JPA, MySQL
  * 선택 과목 : 디자인 패턴, Spring Security, Redis, MongoDB
 
* 조건
  * 최소 3개 이상의 필수 과목, 2개 이상의 선택 과목을 선택
  * 캠프 기간동안 선택한 과목별로 10회의 시험
  * 캠프 매니저는 수강생을 등록 및 관리
  * 캠프 매니저는 수강생들의 과목과 시험 점수를 등록 및 관리
  * 점수 데이터 타입 : 정수형
  * 등급 산정 기준
    * 필수 과목 : A(95 ~ 100), B(90 ~ 94), C(80 ~ 89), D(70 ~ 79), F(60 ~ 69), N(60점 미만)
    * 선택 과목 : A(90 ~ 100), B(80 ~ 89), C(70 ~ 79), D(60 ~ 69), F(50 ~ 59), N(50점 미만)

* 예시
  * 수강생 : 고유 번호, 이름, 과목 목록
  * 점수 : 과목 고유 번호, 수강생 고유 번호, 회차, 점수, 등급(A, B, C, D, E, F, N)
  * 과목 : 고유 번호, 과목명, 과목타입(필수, 선택)
