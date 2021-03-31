DROP TABLE IF EXISTS `appointment`;

CREATE TABLE `appointment` (
                               `AppointmentID` bigint(20) NOT NULL AUTO_INCREMENT,
                               `AppointmentNumber` varchar(255) NOT NULL,
                               `AppointmentDate` date NOT NULL,
                               `AppointmentStartTime` datetime  NOT NULL,
                               `AppointmentEndTime` datetime  NOT NULL,
                               `CustomerID` bigint(20) NOT NULL,
                               `CustomerName` varchar(255) NOT NULL,
                               `Status` tinyint(5) NOT NULL,
                               `VeterID` bigint(20) NOT NULL,
                               `VetID` bigint(20) NOT NULL,
                               `TreatmentID` bigint(20) NOT NULL,
                               `CreatedBy` bigint(20) NOT NULL,
                               `CreatedDate` datetime NOT NULL,
                               `UpdatedBy` bigint(20) DEFAULT NULL,
                               `UpdatedDate` datetime DEFAULT NULL,
                               `IsDeleted` tinyint(1) DEFAULT NULL,
                               PRIMARY KEY (`AppointmentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `dental`;
DROP TABLE IF EXISTS `vet`;
CREATE TABLE `vet` (
                       `VetID` bigint(20) NOT NULL AUTO_INCREMENT,
                       `VetName` varchar(255) NOT NULL,
                       `VetDescription` varchar(3000) DEFAULT NULL,
                       `VetAddress` varchar(255) DEFAULT NULL,
                       `OperatingHourStart` datetime NOT NULL,
                       `OperatingHourEnd` datetime NOT NULL,
                       `Postal_code` varchar(10) DEFAULT NULL,
                       `Coordinate` varchar(20) DEFAULT NULL,
                       `LocationID` int(10) NOT NULL,
                       `Tel_office_1` varchar(10) DEFAULT NULL,
                       `Tel_office_2`varchar(10) DEFAULT NULL,
                       `CreatedBy` bigint(20) NOT NULL,
                       `CreatedDate` datetime NOT NULL,
                       `UpdatedBy` bigint(20) DEFAULT NULL,
                       `UpdatedDate` datetime DEFAULT NULL,
                       `IsDeleted` tinyint(1) DEFAULT NULL,
                       PRIMARY KEY (`VetID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `dental_treatment`;
DROP TABLE IF EXISTS `vet_treatment`;
CREATE TABLE `vet_treatment` (
                                 `Vet_TreatmentID` bigint(20) NOT NULL AUTO_INCREMENT,
                                 `VetID` bigint(20) NOT NULL,
                                 `TreatmentID` bigint(20) NOT NULL,
                                 `PerSessionDuration` float NOT NULL,
                                 `CreatedBy` bigint(20) NOT NULL,
                                 `CreatedDate` datetime NOT NULL,
                                 `UpdatedBy` bigint(20) DEFAULT NULL,
                                 `UpdatedDate` datetime DEFAULT NULL,
                                 `IsDeleted` tinyint(1) DEFAULT NULL,
                                 PRIMARY KEY (`Vet_TreatmentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `dentist`;
DROP TABLE IF EXISTS `veter`;
CREATE TABLE `veter` (
                         `VeterID` bigint(20) NOT NULL AUTO_INCREMENT,
                         `VeterName` varchar(255) NOT NULL,
                         `VetID` bigint(20) NOT NULL,
                         `VeterDescription` varchar(3000) DEFAULT NULL,
                         `Gender` tinyint(1) NOT NULL,
                         `IsOnLeave` tinyint(4) DEFAULT NULL,
                         `LeaveStartDate` date DEFAULT NULL,
                         `LeaveEndDate` date DEFAULT NULL,
                         `CreatedBy` bigint(20) NOT NULL,
                         `CreatedDate` datetime NOT NULL,
                         `UpdatedBy` bigint(20) DEFAULT NULL,
                         `UpdatedDate` datetime DEFAULT NULL,
                         `IsDeleted` tinyint(1) DEFAULT NULL,
                         PRIMARY KEY (`VeterID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `dentist_working_schedule`;
DROP TABLE IF EXISTS `veter_working_schedule`;
CREATE TABLE `veter_working_schedule` (
                                          `VeterWorkingScheduleID` bigint(20) NOT NULL AUTO_INCREMENT,
                                          `VeterID` bigint(20) NOT NULL,
                                          `DayOfWeek` int(1) NOT NULL,
                                          `StartTime` datetime NOT NULL,
                                          `EndTime` datetime  NOT NULL,
                                          `CreatedBy` bigint(20) NOT NULL,
                                          `CreatedDate` datetime NOT NULL,
                                          `UpdatedBy` bigint(20) DEFAULT NULL,
                                          `UpdatedDate` datetime DEFAULT NULL,
                                          `IsDeleted` tinyint(1) DEFAULT NULL,
                                          PRIMARY KEY (`VeterWorkingScheduleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `treatment`;
CREATE TABLE `treatment` (
                             `TreatmentID` bigint(20) NOT NULL AUTO_INCREMENT,
                             `TreatmentName` varchar(255) NOT NULL,
                             `CreatedBy` bigint(20) NOT NULL,
                             `CreatedDate` datetime NOT NULL,
                             `UpdatedBy` bigint(20) DEFAULT NULL,
                             `UpdatedDate` datetime DEFAULT NULL,
                             `IsDeleted` tinyint(1) DEFAULT NULL,
                             PRIMARY KEY (`TreatmentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
                        `UserID` bigint(20) NOT NULL AUTO_INCREMENT,
                        `UserName` varchar(255) NOT NULL,
                        `DisplayName` varchar(255) DEFAULT NULL,
                        `Password` varchar(255) NOT NULL,
                        `BirthDate` datetime NOT NULL,
                        `EmailAddress` varchar(255) NOT NULL,
                        `ContactNumber` varchar(20) NOT NULL,
                        `Gender` tinyint(1) DEFAULT NULL,
                        `ICNumber` varchar(15) NOT NULL,
                        `UserType` tinyint(5) DEFAULT NULL,
                        `VetID` bigint(20) DEFAULT NULL,
                        `CreatedBy` bigint(20) NOT NULL,
                        `CreatedDate` datetime NOT NULL,
                        `UpdatedBy` bigint(20) DEFAULT NULL,
                        `UpdatedDate` datetime DEFAULT NULL,
                        `IsDeleted` tinyint(1) DEFAULT NULL,
                        PRIMARY KEY (`UserID`),
                        UNIQUE KEY `UserName_UNIQUE` (`UserName`),
                        UNIQUE KEY `EmailAddress_UNIQUE` (`EmailAddress`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
