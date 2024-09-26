/* 배달기사 테이블 */
CREATE TABLE TBL_DRIVER (
    ID NUMBER CONSTRAINT PK_DRIVER PRIMARY KEY,  /* 배달기사 테이블의 기본 키 */
    DRIVER_BANK VARCHAR2(20) NOT NULL,  /* 배달기사 은행 */
    DRIVER_BANK_ACCOUNT VARCHAR2(20) NOT NULL,  /* 배달기사 계좌 번호 */
    CREATED_DATE DATE DEFAULT SYSDATE,  /* 배달기사 등록 날짜 */
    UPDATED_DATE DATE DEFAULT SYSDATE,
    CONSTRAINT FK_DRIVER_MEMBER FOREIGN KEY (ID)
    REFERENCES TBL_MEMBER(ID)  /* 회원 테이블의 ID를 pk로 사용 */
);

CREATE SEQUENCE SEQ_DRIVER;
SELECT * FROM TBL_DRIVER;
INSERT INTO TBL_DRIVER (
    ID,
    DRIVER_BANK,
    DRIVER_BANK_ACCOUNT,
    CREATED_DATE,
    UPDATED_DATE
) VALUES (
             SEQ_DRIVER.NEXTVAL,  -- 자동 증가 시퀀스를 사용하여 ID 생성
             1,  -- 실제 존재하는 회원의 ID를 입력 (예: 1번 회원)
             'KB국민은행',  -- 배달기사의 은행
             '123-456-789012',  -- 배달기사의 계좌 번호
             SYSDATE,  -- 배달기사 등록 날짜 (현재 날짜 사용)
             SYSDATE   -- 업데이트 날짜 (현재 날짜 사용)
         );
