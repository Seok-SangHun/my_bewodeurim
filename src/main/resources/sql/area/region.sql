/* 지역 테이블: 도시의 구(지역) 정보를 저장 */
CREATE TABLE TBL_REGION (
    ID NUMBER CONSTRAINT PK_REGION PRIMARY KEY,   /* 지역(구)의 고유 ID */
    CITY_ID NUMBER NOT NULL,                /* 도시 테이블의 외래 키 (도시를 참조) */
    REGION_NAME VARCHAR2(100) NOT NULL,  /* 지역 이름 (예: 강남구, 종로구 등) */
    CONSTRAINT FK_REGION_CITY FOREIGN KEY (CITY_ID)  /* 도시 테이블의 ID를 참조 */
    REFERENCES TBL_CITY(ID) ON DELETE CASCADE    /* 도시 삭제 시 관련 지역도 삭제 */
);

CREATE SEQUENCE SEQ_REGION;