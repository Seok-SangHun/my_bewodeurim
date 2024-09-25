/* 구독료 결제 테이블 */
CREATE TABLE TBL_PAYMENT (
    ID NUMBER CONSTRAINT PK_PAYMENT PRIMARY KEY,  /* 구독료 결제 테이블의 기본 키 */
    MEMBER_ID NUMBER NOT NULL,  /* 회원 ID */
    PLAN_ID NUMBER NOT NULL,  /* 요금제 ID */
    PAYMENT_PRICE NUMBER NOT NULL,  /* 결제 금액 */
    PAYMENT_STATUS VARCHAR2(20) NOT NULL,  /* 결제 상태 (성공, 실패, 대기 등) */
    CREATED_DATE DATE DEFAULT SYSDATE, /* 결제 날짜 */
    UPDATED_DATE DATE DEFAULT SYSDATE,
    CONSTRAINT FK_PAYMENT_MEMBER FOREIGN KEY (MEMBER_ID)
        REFERENCES TBL_MEMBER(ID),  /* 회원 테이블의 ID를 참조 */
    CONSTRAINT FK_PAYMENT_PLAN FOREIGN KEY (PLAN_ID)
        REFERENCES TBL_PLAN(ID)  /* 요금제 테이블의 ID를 참조 */
);

CREATE SEQUENCE SEQ_PAYMENT;
select * from TBL_PAYMENT;
INSERT INTO TBL_PAYMENT (
    ID,
    MEMBER_ID,
    PLAN_ID,
    PAYMENT_PRICE,
    PAYMENT_STATUS,
    CREATED_DATE,
    UPDATED_DATE
) VALUES (
             SEQ_PAYMENT.NEXTVAL,  -- 시퀀스 값 사용
             2,  -- 회원 ID (예시: 1번 회원)
             2,  -- 요금제 ID (예시: 101번 요금제)
             5000,  -- 결제 금액 (예시: 15,000원)
             '성공',  -- 결제 상태 (성공, 실패, 대기 등)
             SYSDATE,  -- 결제 날짜
             SYSDATE   -- 수정 날짜
         );
