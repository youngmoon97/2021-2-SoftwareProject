--------------------------------------------------------
--  ������ ������ - ������-11��-29-2021   
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
   (	"�Խù���ȣ" VARCHAR2(20 BYTE), 
	"����" VARCHAR2(50 BYTE), 
	"����" VARCHAR2(1000 BYTE), 
	"�ۼ���" VARCHAR2(20 BYTE), 
	"�ۼ��Ͻ�" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into BOARD.FOOD
SET DEFINE OFF;
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('�����','�ѽ�','����');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('��ġ�','�ѽ�','����');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('�δ��','�ѽ�','����');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('û����','�ѽ�','����');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('���߱�','�ѽ�','����');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('�Ұ�⹫��','�ѽ�','����');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('�̿���','�ѽ�','����');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('�ᳪ����','�ѽ�','����');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('�ñ�ġ���屹','�ѽ�','����');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('��������','�ѽ�','��');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('��ġ������','�ѽ�','��');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('��ġ���䵤��','�ѽ�','��');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('���Ե���','�ѽ�','��');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('�����','�ѽ�','��');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('�ø�','�ѽ�','��');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('���','�ѽ�','��');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('�ᱹ��','�ѽ�','��');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('�и�','�ѽ�','��');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('������','�ѽ�','��');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('����','�ѽ�','���');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('�Ұ��','�ѽ�','���');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('�����','�ѽ�','���');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('ġŲ','�ѽ�','���');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('�˸����ø���','���','��');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('�������','���','��');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('�ع��Ľ�Ÿ','���','��');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('�丶���Ľ�Ÿ','���','��');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('�ع�������','���','��');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('����ʶ���','���','��');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('��ġ�ʶ���','���','��');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('�ع�������','���','��');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('��콺����ũ','���','���');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('�Ƚɽ�����ũ','���','���');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('����','���','���');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('Ƽ��������ũ','���','���');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('����������ũ','���','���');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('�÷����̾�','���','���');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('����δ�����','���','����');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('��������','���','����');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('������������','���','����');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('�ع�����','���','����');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('����','�Ͻ�','��');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('�Ե�','�Ͻ�','��');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('������','�Ͻ�','��');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('���ϱ⸮','�Ͻ�','��');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('��Ǫ��','�Ͻ�','Ƣ��');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('������','�Ͻ�','Ƣ��');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('����ư�','�Ͻ�','Ƣ��');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('���þ߸�','�Ͻ�','����');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('���','�Ͻ�','����');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('�ҹ�','�Ͻ�','����');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('�쵿','�Ͻ�','����');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('������','�Ͻ�','����');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('�ҹ�','�Ͻ�','����');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('�������','�Ͻ�','����');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('��Ű�丮','�Ͻ�','���');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('��Ű����','�Ͻ�','���');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('¥���','�߽�','��');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('«��','�߽�','��');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('����«��','�߽�','��');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('�߽Ŀ쵿','�߽�','��');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('�⽺��','�߽�','��');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('�Ｑ¥���','�߽�','��');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('������','�߽�','�丮');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('���ĵκ�','�߽�','�丮');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('���꽽','�߽�','�丮');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('��ǳ��','�߽�','�丮');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('�Ⱥ�ä','�߽�','�丮');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('��ä������','�߽�','��');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('�Ｑ������','�߽�','��');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('���캺����','�߽�','��');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('������������','�߽�','��');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('«�͹�','�߽�','��');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('������ä��','�߽�','��');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('������','�߽�','����');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('�𸸵�','�߽�','����');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('������','�߽�','����');
Insert into BOARD.FOOD (FOODNAME,MAINCATEGORY,MIDDLECATEGORY) values ('�ɻ�','�߽�','����');
REM INSERTING into BOARD.MEMBER
SET DEFINE OFF;
Insert into BOARD.MEMBER (ID,PW,NAME,PHONENUM) values ('moon','1234','������','010-9089');
Insert into BOARD.MEMBER (ID,PW,NAME,PHONENUM) values ('yuha','1212','���Ͽ�','010-1234');
Insert into BOARD.MEMBER (ID,PW,NAME,PHONENUM) values ('gangu','123123','���ѱ�','010-4241');
Insert into BOARD.MEMBER (ID,PW,NAME,PHONENUM) values ('sangmi','2323','�̻��','010-5383');
Insert into BOARD.MEMBER (ID,PW,NAME,PHONENUM) values ('yujin','0099','������','010-1542');
Insert into BOARD.MEMBER (ID,PW,NAME,PHONENUM) values ('sujin','1441','�����','010-1415');
Insert into BOARD.MEMBER (ID,PW,NAME,PHONENUM) values ('minsuk','12312','���μ�','010-1344');
Insert into BOARD.MEMBER (ID,PW,NAME,PHONENUM) values ('sangmok','49281','�̻��','010-4151');
REM INSERTING into BOARD.POST
SET DEFINE OFF;
Insert into BOARD.POST ("�Խù���ȣ","����","����","�ۼ���","�ۼ��Ͻ�") values ('4','����4','����4','�ۼ���1','20211128131345');
Insert into BOARD.POST ("�Խù���ȣ","����","����","�ۼ���","�ۼ��Ͻ�") values ('5','����5','����5','�ۼ���1','20211128132159');
Insert into BOARD.POST ("�Խù���ȣ","����","����","�ۼ���","�ۼ��Ͻ�") values ('6','��������','���볻�볻��','�ۼ���1','20211128133244');
Insert into BOARD.POST ("�Խù���ȣ","����","����","�ۼ���","�ۼ��Ͻ�") values ('1','����1','����1','�ۼ���1','20211128102730');
Insert into BOARD.POST ("�Խù���ȣ","����","����","�ۼ���","�ۼ��Ͻ�") values ('2','����2','����2','�ۼ���2','20211128102830');
Insert into BOARD.POST ("�Խù���ȣ","����","����","�ۼ���","�ۼ��Ͻ�") values ('3','����3','����3','�ۼ���3','20211128102930');
Insert into BOARD.POST ("�Խù���ȣ","����","����","�ۼ���","�ۼ��Ͻ�") values ('66','�Խù� �ۼ� �׽�Ʈ','�Խù� ���� �׽�Ʈ �Դϴ�. �� �ۼ��Ǵµ� �մϴ�.','member1','20211129130141');
Insert into BOARD.POST ("�Խù���ȣ","����","����","�ۼ���","�ۼ��Ͻ�") values ('68','���ۼ��׽�Ʈ�ϱ�','���� �ۼ� �׽�Ʈ �ϱ� ','member1','20211129150118');
Insert into BOARD.POST ("�Խù���ȣ","����","����","�ۼ���","�ۼ��Ͻ�") values ('70','�� �ۼ� �׽�Ʈ �ϱ�','�׽�Ʈ','member1','20211129150726');
Insert into BOARD.POST ("�Խù���ȣ","����","����","�ۼ���","�ۼ��Ͻ�") values ('44','���ۼ��׽�Ʈ22','���ۼ��׽�Ʈ���ۼ��׽�Ʈ���ۼ��׽�Ʈ���ۼ��׽�Ʈ���ۼ��׽�Ʈ���ۼ��׽�Ʈ���ۼ��׽�Ʈ���ۼ��׽�Ʈ���ۼ��׽�Ʈ���ۼ��׽�Ʈ���ۼ��׽�Ʈ���ۼ��׽�Ʈ���ۼ��׽�Ʈ
���ۼ��׽�Ʈ���ۼ��׽�Ʈ���ۼ��׽�Ʈ���ۼ��׽�Ʈ���ۼ��׽�Ʈ���ۼ��׽�Ʈ
���ۼ��׽�Ʈ
���ۼ��׽�Ʈ
���ۼ��׽�Ʈ���ۼ��׽�Ʈ���ۼ��׽�Ʈ���ۼ��׽�Ʈ
���ۼ��׽�Ʈ���ۼ��׽�Ʈ���ۼ��׽�Ʈ
���ۼ��׽�Ʈ
���ۼ��׽�Ʈ
���ۼ��׽�Ʈ
���ۼ��׽�Ʈ���ۼ��׽�Ʈ���ۼ��׽�Ʈ
���ۼ��׽�Ʈ���ۼ��׽�Ʈ
���ۼ��׽�Ʈ','member1','20211128134716');
Insert into BOARD.POST ("�Խù���ȣ","����","����","�ۼ���","�ۼ��Ͻ�") values ('67','�Խù� �ۼ� �׽�Ʈ 2','�Խù� �ۼ� �׽�Ʈ 2�Խù� �ۼ� �׽�Ʈ 2�Խù� �ۼ� �׽�Ʈ 2�Խù� �ۼ� �׽�Ʈ 2','member1','20211129130207');
Insert into BOARD.POST ("�Խù���ȣ","����","����","�ۼ���","�ۼ��Ͻ�") values ('25','���ۼ��׽�Ʈ','���ۼ��׽�Ʈ','member1','20211128134521');
Insert into BOARD.POST ("�Խù���ȣ","����","����","�ۼ���","�ۼ��Ͻ�") values ('69','���ۼ��׽�Ʈ�ϱ�','���� �ۼ� �׽�Ʈ �ϱ� ','member1','20211129150146');
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

  CREATE UNIQUE INDEX "BOARD"."POST_PK" ON "BOARD"."POST" ("�Խù���ȣ") 
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

  CREATE UNIQUE INDEX "BOARD"."POST_PK" ON "BOARD"."POST" ("�Խù���ȣ") 
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

  ALTER TABLE "BOARD"."POST" MODIFY ("�Խù���ȣ" NOT NULL ENABLE);
  ALTER TABLE "BOARD"."POST" MODIFY ("����" NOT NULL ENABLE);
  ALTER TABLE "BOARD"."POST" MODIFY ("����" NOT NULL ENABLE);
  ALTER TABLE "BOARD"."POST" MODIFY ("�ۼ���" NOT NULL ENABLE);
  ALTER TABLE "BOARD"."POST" MODIFY ("�ۼ��Ͻ�" NOT NULL ENABLE);
  ALTER TABLE "BOARD"."POST" ADD CONSTRAINT "POST_PK" PRIMARY KEY ("�Խù���ȣ")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
