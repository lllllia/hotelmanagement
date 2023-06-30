CREATE TABLE `Clean`  (
  `CleanTime` datetime NOT NULL,
  `CleanRoomID` int NOT NULL,
  `CleanEmployeeID` int NOT NULL,
  PRIMARY KEY (`CleanTime`, `CleanRoomID`, `CleanEmployeeID`)
);

CREATE TABLE `Customer`  (
  `CustomerID` char(11) NOT NULL,
  `CustomerName` varchar(255) NULL,
  `CustomerContact` varchar(255) NULL,
  `CustomerPassword` varchar(255) NULL,
  `CustomerUserName` varchar(255) NULL,
  `CustomerCitizenID` char(18) NULL,
  PRIMARY KEY (`CustomerID`)
);

CREATE TABLE `Employee`  (
  `EmployeeID` int NOT NULL,
  `EmployeeCitizenID` char(18) NULL,
  `EmployeeName` varchar(255) NULL,
  `EmployeeState` char(1) NULL,
  `EmployeeContact` char(11) NULL,
  `EmployeePassword` varchar(255) NULL,
  PRIMARY KEY (`EmployeeID`)
);

CREATE TABLE `ManageEmployee`  (
  `ManageEmployeeTime` datetime NOT NULL,
  `ManageEManagerID` int NOT NULL,
  `ManageEmployeeID` int NOT NULL,
  PRIMARY KEY (`ManageEmployeeTime`, `ManageEManagerID`, `ManageEmployeeID`)
);

CREATE TABLE `Manager`  (
  `ManagerID` int NOT NULL,
  `ManagerPassword` varchar(255) NULL,
  `ManagerName` varchar(255) NULL,
  `ManagerContact` char(11) NULL,
  PRIMARY KEY (`ManagerID`)
);

CREATE TABLE `ManageRoom`  (
  `ManageRoomTime` datetime NOT NULL,
  `ManageRoomID` int NOT NULL,
  `ManageRManagerID` int NOT NULL,
  PRIMARY KEY (`ManageRoomTime`, `ManageRoomID`, `ManageRManagerID`)
);

CREATE TABLE `Monthly`  (
  `MonthlyDate` datetime NOT NULL,
  `MonthlyIncome` int NULL,
  `MonthlyRoom` float NULL,
  `MonthlyAttendance` float NULL,
  `MonthlyScore` float NULL,
  PRIMARY KEY (`MonthlyDate`)
);

CREATE TABLE `Require`  (
  `RequireTime` datetime NOT NULL,
  `RequireManagerID` int NOT NULL,
  `RequireMonthlyDate` datetime NOT NULL,
  PRIMARY KEY (`RequireTime`, `RequireManagerID`, `RequireMonthlyDate`)
);

CREATE TABLE `Reserve_In`  (
  `ReserveTime` datetime NOT NULL,
  `CheckinTime` datetime NULL,
  `ReserveScore` float NULL,
  `ReserveCost` int NULL,
  `ReserveCustomerID` int NOT NULL,
  `ReserveRoomID` int NOT NULL,
  PRIMARY KEY (`ReserveTime`, `ReserveCustomerID`, `ReserveRoomID`)
);

CREATE TABLE `Room`  (
  `RoomID` int NOT NULL,
  `RoomType` char(1) NULL,
  `RoomState` char(1) NULL,
  PRIMARY KEY (`RoomID`)
);

