/* 배달기사 테이블 */
CREATE TABLE TBL_DRIVER (
    ID NUMBER CONSTRAINT PK_DRIVER PRIMARY KEY,  /* 배달기사 테이블의 기본 키 */
    MEMBER_ID NUMBER NOT NULL,  /* 회원 ID */
    DRIVER_BANK VARCHAR2(20) NOT NULL,  /* 배달기사 은행 */
    DRIVER_BANK_ACCOUNT VARCHAR2(20) NOT NULL,  /* 배달기사 계좌 번호 */
    CREATED_DATE DATE DEFAULT SYSDATE,  /* 배달기사 등록 날짜 */
    UPDATED_DATE DATE DEFAULT SYSDATE,
    CONSTRAINT FK_DRIVER_MEMBER FOREIGN KEY (MEMBER_ID)
        REFERENCES TBL_MEMBER(ID)  /* 회원 테이블의 ID를 참조 */
);

CREATE SEQUENCE SEQ_DRIVER;