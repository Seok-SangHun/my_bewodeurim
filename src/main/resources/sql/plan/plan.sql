/* 요금제 테이블 */
CREATE TABLE TBL_PLAN (
    ID NUMBER CONSTRAINT PK_PLAN PRIMARY KEY,  /* 요금제 테이블의 기본 키 */
    PLAN_GRADE VARCHAR2(100) NOT NULL,  /* 요금제 등급 */
    PLAN_PRICE NUMBER(10, 2) NOT NULL,  /* 요금제 가격 */
    PLAN_BOX_SIZE VARCHAR2(50),  /* 상자 사이즈 (예: 소형, 중형, 대형 등) */
<<<<<<< HEAD
    PLAN_MAX_MEMBERS VARCHAR2(50) NOT NULL  /* 요금제에 포함된 최대 인원수 */
--     PLAN_STATUS VARCHAR2(100) NOT NULL
--     CREATED_DATE DATE DEFAULT SYSDATE,
--     UPDATED_DATE DATE DEFAULT SYSDATE
=======
    PLAN_MAX_MEMBERS NUMBER NOT NULL,  /* 요금제에 포함된 최대 인원수 */
    PLAN_STATUS VARCHAR2(100) NOT NULL,
    PLAN_DELIVERY_FEE NUMBER NOT NULL,
    CREATED_DATE DATE DEFAULT SYSDATE,
    UPDATED_DATE DATE DEFAULT SYSDATE
>>>>>>> c9f6cd4dc9dc8e689856cb7408e4897c18c89c60
);

CREATE SEQUENCE SEQ_PLAN;

ALTER TABLE TBL_PLAN
    MODIFY PLAN_MAX_MEMBERS VARCHAR2(50);

DELETE FROM TBL_PLAN;

SELECT * FROM TBL_PLAN;
SELECT *
FROM TBL_PLAN
ORDER BY ID ASC;

INSERT INTO TBL_PLAN(
                     ID,
                     PLAN_GRADE,
                     PLAN_PRICE,
                     PLAN_BOX_SIZE,
                     PLAN_MAX_MEMBERS
--                      PLAN_STATUS
--                      CREATED_DATE,
--                      UPDATED_DATE
) VALUES(
         SEQ_PLAN.NEXTVAL,
         '라이트',
         8000,
         '1호 상자',
         '1인'
        );

INSERT INTO TBL_PLAN(
    ID,
    PLAN_GRADE,
    PLAN_PRICE,
    PLAN_BOX_SIZE,
    PLAN_MAX_MEMBERS
--                      PLAN_STATUS
--                      CREATED_DATE,
--                      UPDATED_DATE
) VALUES(
            SEQ_PLAN.NEXTVAL,
            '스탠다드',
            10000,
            '2호 상자',
            '2~3인'
        );

INSERT INTO TBL_PLAN(
    ID,
    PLAN_GRADE,
    PLAN_PRICE,
    PLAN_BOX_SIZE,
    PLAN_MAX_MEMBERS
--                      PLAN_STATUS
--                      CREATED_DATE,
--                      UPDATED_DATE
) VALUES(
            SEQ_PLAN.NEXTVAL,
            '프리미엄',
            12000,
            '3호 상자',
            '4인 이상'
        );