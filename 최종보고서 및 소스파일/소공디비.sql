--------------------------------------------------------
--  파일이 생성됨 - 월요일-11월-29-2021   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence A
--------------------------------------------------------

   CREATE SEQUENCE  "BOARD"."A"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 84 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Table FOOD
--------------------------------------------------------

  CREATE TABLE "BOARD"."FOOD" 
   (	"FOODNAME" VARCHAR2(20 BYTE), 
	"MAINCATEGORY" VARCHAR2(20 BYTE), 
	"MIDDLECATEGORY" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table MEMBER
--------------------------------------------------------

  CREATE TABLE "BOARD"."MEMBER" 
   (	"ID" VARCHAR2(20 BYTE), 
	"PW" VARCHAR2(20 BYTE), 
	"NAME" VARCHAR2(20 BYTE), 
	"PHONENUM" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table POST
--------------------------------------------------------

  CREATE TABLE "BOARD"."POST" 
   (	"게시물번호" VARCHAR2(20 BYTE), 
	"제목" VARCHAR2(50 BYTE), 
	"내용" VARCHAR2(1000 BYTE), 
	"작성자" VARCHAR2(20 BYTE), 
	"작성일시" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into BOARD.FOOD
SET DEFINE OFF;
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('된장찌개','한식','국물');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('김치찌개','한식','국물');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('부대찌개','한식','국물');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('청국장','한식','국물');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('배추국','한식','국물');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('소고기무국','한식','국물');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('미역국','한식','국물');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('콩나물국','한식','국물');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('시금치된장국','한식','국물');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('낙지덮밥','한식','밥');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('김치볶음밥','한식','밥');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('참치마요덮밥','한식','밥');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('스팸덮밥','한식','밥');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('비빔밥','한식','밥');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('냉면','한식','면');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('라면','한식','면');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('콩국수','한식','면');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('밀면','한식','면');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('막국수','한식','면');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('삼겹살','한식','고기');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('소고기','한식','고기');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('삼계탕','한식','고기');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('치킨','한식','고기');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('알리오올리오','양식','면');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('까르보나라','양식','면');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('해물파스타','양식','면');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('토마토파스타','양식','면');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('해물리조또','양식','밥');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('목살필라프','양식','밥');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('김치필라프','양식','밥');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('해물빠에야','양식','밥');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('목살스테이크','양식','고기');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('안심스테이크','양식','고기');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('폭립','양식','고기');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('티본스테이크','양식','고기');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('엘본스테이크','양식','고기');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('플랫아이언','양식','고기');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('페페로니피자','양식','피자');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('고구마피자','양식','피자');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('포테이토피자','양식','피자');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('해물피자','양식','피자');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('스시','일식','밥');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('규동','일식','밥');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('가츠동','일식','밥');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('오니기리','일식','밥');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('덴푸라','일식','튀김');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('돈가스','일식','튀김');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('가라아게','일식','튀김');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('스시야마','일식','국물');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('라멘','일식','국물');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('소바','일식','국물');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('우동','일식','국물');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('찬고나배','일식','국물');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('소바','일식','국물');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('샤브샤브','일식','국물');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('야키토리','일식','고기');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('야키니쿠','일식','고기');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('짜장면','중식','면');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('짬뽕','중식','면');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('볶음짬뽕','중식','면');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('중식우동','중식','면');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('기스면','중식','면');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('삼선짜장면','중식','면');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('탕수육','중식','요리');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('마파두부','중식','요리');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('류산슬','중식','요리');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('깐풍기','중식','요리');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('팔보채','중식','요리');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('야채볶음밥','중식','밥');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('삼선볶음밥','중식','밥');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('새우볶음밥','중식','밥');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('베이컨볶음밥','중식','밥');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('짬뽕밥','중식','밥');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('고추잡채밥','중식','밥');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('군만두','중식','만두');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('찐만두','중식','만두');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('물만두','중식','만두');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('꽃빵','중식','만두');
REM INSERTING into BOARD.MEMBER
SET DEFINE OFF;
Insert into BOARD.MEMBER (ID,PW,NAME,PHONENUM) values ('moon','1234','조영문','010-9089');
Insert into BOARD.MEMBER (ID,PW,NAME,PHONENUM) values ('yuha','1212','유하영','010-1234');
Insert into BOARD.MEMBER (ID,PW,NAME,PHONENUM) values ('gangu','123123','유한규','010-4241');
Insert into BOARD.MEMBER (ID,PW,NAME,PHONENUM) values ('sangmi','2323','이상미','010-5383');
Insert into BOARD.MEMBER (ID,PW,NAME,PHONENUM) values ('yujin','0099','조유진','010-1542');
Insert into BOARD.MEMBER (ID,PW,NAME,PHONENUM) values ('sujin','1441','김수진','010-1415');
Insert into BOARD.MEMBER (ID,PW,NAME,PHONENUM) values ('minsuk','12312','진민석','010-1344');
Insert into BOARD.MEMBER (ID,PW,NAME,PHONENUM) values ('sangmok','49281','이상목','010-4151');
REM INSERTING into BOARD.POST
SET DEFINE OFF;
Insert into BOARD.POST ("게시물번호","제목","내용","작성자","작성일시") values ('4','제목4','내용4','작성자1','20211128131345');
Insert into BOARD.POST ("게시물번호","제목","내용","작성자","작성일시") values ('5','제목5','내용5','작성자1','20211128132159');
Insert into BOARD.POST ("게시물번호","제목","내용","작성자","작성일시") values ('6','제목제목','내용내용내용','작성자1','20211128133244');
Insert into BOARD.POST ("게시물번호","제목","내용","작성자","작성일시") values ('1','제목1','내용1','작성자1','20211128102730');
Insert into BOARD.POST ("게시물번호","제목","내용","작성자","작성일시") values ('2','제목2','내용2','작성자2','20211128102830');
Insert into BOARD.POST ("게시물번호","제목","내용","작성자","작성일시") values ('3','제목3','내용3','작성자3','20211128102930');
Insert into BOARD.POST ("게시물번호","제목","내용","작성자","작성일시") values ('66','게시물 작성 테스트','게시물 내용 테스트 입니다. 잘 작성되는듯 합니다.','member1','20211129130141');
Insert into BOARD.POST ("게시물번호","제목","내용","작성자","작성일시") values ('68','글작성테스트하기','내용 작성 테스트 하기 ','member1','20211129150118');
Insert into BOARD.POST ("게시물번호","제목","내용","작성자","작성일시") values ('70','글 작성 테스트 하기','테스트','member1','20211129150726');
Insert into BOARD.POST ("게시물번호","제목","내용","작성자","작성일시") values ('44','글작성테스트22','글작성테스트글작성테스트글작성테스트글작성테스트글작성테스트글작성테스트글작성테스트글작성테스트글작성테스트글작성테스트글작성테스트글작성테스트글작성테스트
글작성테스트글작성테스트글작성테스트글작성테스트글작성테스트글작성테스트
글작성테스트
글작성테스트
글작성테스트글작성테스트글작성테스트글작성테스트
글작성테스트글작성테스트글작성테스트
글작성테스트
글작성테스트
글작성테스트
글작성테스트글작성테스트글작성테스트
글작성테스트글작성테스트
글작성테스트','member1','20211128134716');
Insert into BOARD.POST ("게시물번호","제목","내용","작성자","작성일시") values ('67','게시물 작성 테스트 2','게시물 작성 테스트 2게시물 작성 테스트 2게시물 작성 테스트 2게시물 작성 테스트 2','member1','20211129130207');
Insert into BOARD.POST ("게시물번호","제목","내용","작성자","작성일시") values ('25','글작성테스트','글작성테스트','member1','20211128134521');
Insert into BOARD.POST ("게시물번호","제목","내용","작성자","작성일시") values ('69','글작성테스트하기','내용 작성 테스트 하기 ','member1','20211129150146');
--------------------------------------------------------
--  DDL for Index MEMBER_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "BOARD"."MEMBER_PK" ON "BOARD"."MEMBER" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index POST_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "BOARD"."POST_PK" ON "BOARD"."POST" ("게시물번호") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index MEMBER_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "BOARD"."MEMBER_PK" ON "BOARD"."MEMBER" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index POST_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "BOARD"."POST_PK" ON "BOARD"."POST" ("게시물번호") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table MEMBER
--------------------------------------------------------

  ALTER TABLE "BOARD"."MEMBER" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "BOARD"."MEMBER" ADD CONSTRAINT "MEMBER_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table POST
--------------------------------------------------------

  ALTER TABLE "BOARD"."POST" MODIFY ("게시물번호" NOT NULL ENABLE);
  ALTER TABLE "BOARD"."POST" MODIFY ("제목" NOT NULL ENABLE);
  ALTER TABLE "BOARD"."POST" MODIFY ("내용" NOT NULL ENABLE);
  ALTER TABLE "BOARD"."POST" MODIFY ("작성자" NOT NULL ENABLE);
  ALTER TABLE "BOARD"."POST" MODIFY ("작성일시" NOT NULL ENABLE);
  ALTER TABLE "BOARD"."POST" ADD CONSTRAINT "POST_PK" PRIMARY KEY ("게시물번호")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
