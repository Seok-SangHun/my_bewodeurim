CREATE TABLE TBL_DRIVER_PICKUP(
    ID NUMBER CONSTRAINT PK_DRIVER_PICKUP PRIMARY KEY,
    MEMBER_ID NUMBER NOT NULL,
    DRIVER_ID NUMBER NOT NULL,
    CREATED_DATE DATE DEFAULT SYSDATE,
    UPDATE_DATE DATE DEFAULT SYSDATE
);

SELECT * FROM TBL_DRIVER_PICKUP;