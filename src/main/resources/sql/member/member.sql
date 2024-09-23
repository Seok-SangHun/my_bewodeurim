/* 회원 테이블 */
CREATE TABLE TBL_MEMBER (
    ID NUMBER CONSTRAINT PK_MEMBER PRIMARY KEY,  /* 회원 테이블의 기본 키 */
    MEMBER_NAME VARCHAR2(100) NOT NULL,  /* 회원 이름 */
    MEMBER_EMAIL VARCHAR2(100) NOT NULL UNIQUE,  /* 회원 이메일 (고유) */
    MEMBER_ADDRESS_CODE VARCHAR2(255) NOT NULL, /*우편번호*/
    MEMBER_ADDRESS_BASIC VARCHAR2(255) NOT NULL,  /* 기본 주소 */
    MEMBER_ADDRESS_DETAIL VARCHAR2(255) NOT NULL, /*상세 주소*/
    MEMBER_PHONE_NUMBER VARCHAR2(15) NOT NULL,  /* 회원 전화번호 */
    MEMBER_STATUS VARCHAR2(15) NOT NULL,  /* 회원 상태 (예: 활동중, 탈퇴함) */
    MEMBER_PASSWORD VARCHAR2(100) NOT NULL, /* 회원 비밀번호 */
    CREATED_DATE DATE DEFAULT SYSDATE, /* 회원 가입 날짜 */
    UPDATED_DATE DATE DEFAULT SYSDATE
);
CREATE SEQUENCE SEQ_MEMBER;

SELECT * FROM TBL_MEMBER;

INSERT INTO TBL_MEMBER (
    ID,
    MEMBER_NAME,
    MEMBER_EMAIL,
    MEMBER_ADDRESS_CODE,
    MEMBER_ADDRESS_BASIC,
    MEMBER_ADDRESS_DETAIL,
    MEMBER_PHONE_NUMBER,
    MEMBER_STATUS,
    MEMBER_PASSWORD,
    CREATED_DATE,
    UPDATED_DATE
) VALUES (
             SEQ_MEMBER.NEXTVAL,  -- 자동 증가 시퀀스를 사용하는 경우
             'John Doe',  -- 회원 이름
             'john.doe@example.com',  -- 회원 이메일
             '12345',  -- 우편번호
             '123 Main St',  -- 기본 주소
             'Apt 456',  -- 상세 주소
             '010-1234-5678',  -- 전화번호
             '활동중',  -- 회원 상태
             'password123',  -- 비밀번호
             SYSDATE,  -- 가입 날짜
             SYSDATE  -- 업데이트 날짜
         );

