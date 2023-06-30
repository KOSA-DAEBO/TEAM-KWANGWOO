DROP TABLE "Dept";

CREATE TABLE "Dept" (
	"deptNo"	number(2)		NOT NULL,
	"deptName"	varchar2(20)		NOT NULL
);

DROP TABLE "Usr";

CREATE TABLE "Usr" (
	"usrId"	varchar2(20)		NOT NULL,
	"pwd"	varchar2(20)		NOT NULL,
	"hex"	number		NOT NULL,
	"status"	char(1)	DEFAULT 0	NOT NULL
);

DROP TABLE "Emp";

CREATE TABLE "Emp" (
	"empNo"	number		NOT NULL,
	"usrId"	varchar2(20)		NOT NULL,
	"empName"	varchar2(20)		NULL,
	"empAge"	number		NULL,
	"empEmail"	varchar2(30)		NULL,
	"empTel"	varchar2(30)		NULL,
	"empStatus"	char(1)	DEFAULT 0	NULL,
	"role"	char(1)	DEFAULT 0	NOT NULL,
	"deptNo"	number(2)		NOT NULL,
	"posNo"	number		NOT NULL,
	"empGender"	char(1)		NULL,
	"empAddr"	varchar2(50)		NULL,
	"hireDate"	Date		NOT NULL
);

DROP TABLE "Customer";

CREATE TABLE "Customer" (
	"userNo"	number		NOT NULL,
	"usrId"	varchar2(20)		NOT NULL,
	"userEmail"	varchar2(30)		NULL,
	"userTel"	varchar2(50)		NULL,
	"userGender"	char(1)		NULL,
	"userBirth"	Date		NULL,
	"userAddr"	varchar2(50)		NOT NULL
);

DROP TABLE "Pos";

CREATE TABLE "Pos" (
	"posNo"	number		NOT NULL,
	"posNmae"	varchar2(20)		NOT NULL
);

DROP TABLE "Sal";

CREATE TABLE "Sal" (
	"salNo"	number		NOT NULL,
	"amount"	number		NOT NULL,
	"empNo"	number		NOT NULL,
	"usrId"	varchar2(20)		NOT NULL
);

DROP TABLE "leave";

CREATE TABLE "leave" (
	"leaveNo"	number		NOT NULL,
	"startDay"	Date		NOT NULL,
	"endDay"	Date		NOT NULL,
	"reason"	varchar2(30)		NULL,
	"levStatus"	number	DEFAULT 0	NOT NULL,
	"Key"	number		NOT NULL,
	"usrId"	varchar2(20)		NOT NULL,
	"typeNo"	number		NOT NULL
);

DROP TABLE "Att";

CREATE TABLE "Att" (
	"attNo"	number		NOT NULL,
	"nowDate"	Date		NOT NULL,
	"startTime"	Timestamp		NULL,
	"endTime"	Timestamp		NULL,
	"attStatus"	varchar2(20)		NULL,
	"Key"	number		NOT NULL,
	"usrId"	varchar2(20)		NOT NULL
);

DROP TABLE "Money";

CREATE TABLE "Money" (
	"mNo"	number		NOT NULL,
	"profit"	number		NULL,
	"cost"	number		NULL,
	"tAmount"	number		NULL,
	"cause"	varchar2(20)		NOT NULL
);

DROP TABLE "Product";

CREATE TABLE "Product" (
	"productNo"	number		NOT NULL,
	"productName"	varchar2(20)		NOT NULL,
	"Field"	VARCHAR(255)		NULL,
	"Field2"	VARCHAR(255)		NULL
);

DROP TABLE "leaveType";

CREATE TABLE "leaveType" (
	"typeNo"	number		NOT NULL,
	"typeName"	varchar2(20)		NOT NULL
);

ALTER TABLE "Dept" ADD CONSTRAINT "PK_DEPT" PRIMARY KEY (
	"deptNo"
);

ALTER TABLE "Usr" ADD CONSTRAINT "PK_USR" PRIMARY KEY (
	"usrId"
);

ALTER TABLE "Emp" ADD CONSTRAINT "PK_EMP" PRIMARY KEY (
	"empNo",
	"usrId"
);

ALTER TABLE "Customer" ADD CONSTRAINT "PK_CUSTOMER" PRIMARY KEY (
	"userNo",
	"usrId"
);

ALTER TABLE "Pos" ADD CONSTRAINT "PK_POS" PRIMARY KEY (
	"posNo"
);

ALTER TABLE "Sal" ADD CONSTRAINT "PK_SAL" PRIMARY KEY (
	"salNo"
);

ALTER TABLE "leave" ADD CONSTRAINT "PK_LEAVE" PRIMARY KEY (
	"leaveNo"
);

ALTER TABLE "Att" ADD CONSTRAINT "PK_ATT" PRIMARY KEY (
	"attNo"
);

ALTER TABLE "Money" ADD CONSTRAINT "PK_MONEY" PRIMARY KEY (
	"mNo"
);

ALTER TABLE "Product" ADD CONSTRAINT "PK_PRODUCT" PRIMARY KEY (
	"productNo"
);

ALTER TABLE "leaveType" ADD CONSTRAINT "PK_LEAVETYPE" PRIMARY KEY (
	"typeNo"
);

ALTER TABLE "Emp" ADD CONSTRAINT "FK_Usr_TO_Emp_1" FOREIGN KEY (
	"usrId"
)
REFERENCES "Usr" (
	"usrId"
);

ALTER TABLE "Emp" ADD CONSTRAINT "FK_Dept_TO_Emp_1" FOREIGN KEY (
	"deptNo"
)
REFERENCES "Dept" (
	"deptNo"
);

ALTER TABLE "Emp" ADD CONSTRAINT "FK_Pos_TO_Emp_1" FOREIGN KEY (
	"posNo"
)
REFERENCES "Pos" (
	"posNo"
);

ALTER TABLE "Customer" ADD CONSTRAINT "FK_Usr_TO_Customer_1" FOREIGN KEY (
	"usrId"
)
REFERENCES "Usr" (
	"usrId"
);

ALTER TABLE "Sal" ADD CONSTRAINT "FK_Emp_TO_Sal_1" FOREIGN KEY (
	"empNo"
)
REFERENCES "Emp" (
	"empNo"
);

ALTER TABLE "Sal" ADD CONSTRAINT "FK_Emp_TO_Sal_2" FOREIGN KEY (
	"usrId"
)
REFERENCES "Emp" (
	"usrId"
);

ALTER TABLE "leave" ADD CONSTRAINT "FK_Emp_TO_leave_1" FOREIGN KEY (
	"Key"
)
REFERENCES "Emp" (
	"empNo"
);

ALTER TABLE "leave" ADD CONSTRAINT "FK_Emp_TO_leave_2" FOREIGN KEY (
	"usrId"
)
REFERENCES "Emp" (
	"usrId"
);

ALTER TABLE "leave" ADD CONSTRAINT "FK_leaveType_TO_leave_1" FOREIGN KEY (
	"typeNo"
)
REFERENCES "leaveType" (
	"typeNo"
);

ALTER TABLE "Att" ADD CONSTRAINT "FK_Emp_TO_Att_1" FOREIGN KEY (
	"Key"
)
REFERENCES "Emp" (
	"empNo"
);

ALTER TABLE "Att" ADD CONSTRAINT "FK_Emp_TO_Att_2" FOREIGN KEY (
	"usrId"
)
REFERENCES "Emp" (
	"usrId"
);

