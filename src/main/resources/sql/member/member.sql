/* 회원 테이블 */
DROP TABLE TBL_MEMBER;

CREATE TABLE TBL_MEMBER (
    ID NUMBER CONSTRAINT PK_MEMBER PRIMARY KEY,  /* 회원 테이블의 기본 키 */
    MEMBER_NAME VARCHAR2(100) NOT NULL,  /* 회원 이름 */
    MEMBER_EMAIL VARCHAR2(100) NOT NULL ,  /* 회원 이메일 (고유) */
    MEMBER_ADDRESS_CODE VARCHAR2(255) NOT NULL, /*우편번호*/
    MEMBER_ADDRESS_BASIC VARCHAR2(255) NOT NULL,  /* 기본 주소 */
    MEMBER_ADDRESS_DETAIL VARCHAR2(255) NOT NULL, /*상세 주소*/
    MEMBER_PHONE_NUMBER VARCHAR2(255) NOT NULL,  /* 회원 전화번호 */
    MEMBER_STATUS VARCHAR2(15) DEFAULT '활동중',  /* 회원 상태 (예: 활동중, 탈퇴함) */
    MEMBER_PASSWORD VARCHAR2(100) NOT NULL, /* 회원 비밀번호 */
    MEMBER_TYPE VARCHAR2(255) DEFAULT '일반회원',/* 회원 분류(예: 일반회원,기사회원) */
    CREATED_DATE DATE DEFAULT SYSDATE, /* 회원 가입 날짜 */
    UPDATED_DATE DATE DEFAULT SYSDATE
);

CREATE SEQUENCE SEQ_MEMBER;

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
    MEMBER_TYPE,
    CREATED_DATE,
    UPDATED_DATE
)
VALUES (
           SEQ_MEMBER.NEXTVAL,  -- 시퀀스를 사용하여 ID 생성
           '테스트 회원',       -- 회원 이름
           'testuser@example.com', -- 회원 이메일
           '12345',            -- 우편번호
           '서울시 강남구',     -- 기본 주소
           '테헤란로 123',      -- 상세 주소
           '010-1234-5678',    -- 전화번호
           '활동중',            -- 회원 상태
           'password123',      -- 비밀번호 (해시된 값 사용 권장)
           '일반',             -- 회원 타입
           SYSDATE,            -- 가입 날짜
           SYSDATE             -- 수정된 날짜
       );

SELECT * FROM TBL_MEMBER;

-- 삽입된 회원 ID 확인
SELECT ID
FROM TBL_MEMBER
WHERE MEMBER_EMAIL = 'testuser@example.com';

ALTER TABLE TBL_MEMBER MODIFY MEMBER_PHONE_NUMBER VARCHAR2(255) NOT NULL ;

