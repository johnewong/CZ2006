-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: dentalappiont
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `appointment`
--

DROP TABLE IF EXISTS `appointment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appointment` (
  `AppointmentID` bigint(20) NOT NULL,
  `AppointmentNumber` varchar(255) NOT NULL,
  `AppointmentDate` date NOT NULL,
  `AppointmentStartTime` time NOT NULL,
  `AppointmentEndTime` time NOT NULL,
  `PatientID` varchar(255) NOT NULL,
  `PatientName` varchar(255) NOT NULL,
  `Status` varchar(10) NOT NULL,
  `DentistID` bigint(20) NOT NULL,
  `DentalID` bigint(20) NOT NULL,
  `TreatmentID` bigint(20) NOT NULL,
  `CreatedBy` varchar(255) NOT NULL,
  `CreatedDate` datetime NOT NULL,
  `UpdatedBy` varchar(255) DEFAULT NULL,
  `UpdatedDate` datetime DEFAULT NULL,
  `IsDeleted` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`AppointmentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointment`
--

LOCK TABLES `appointment` WRITE;
/*!40000 ALTER TABLE `appointment` DISABLE KEYS */;
/*!40000 ALTER TABLE `appointment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dental`
--

DROP TABLE IF EXISTS `dental`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dental` (
  `DentalID` bigint(20) NOT NULL,
  `DentalName` varchar(255) NOT NULL,
  `DentalDescription` varchar(3000) DEFAULT NULL,
  `DentalAddress` varchar(255) DEFAULT NULL,
  `OperatingHourStart` time NOT NULL,
  `OperatingHourEnd` time NOT NULL,
  `CreatedBy` varchar(255) NOT NULL,
  `CreatedDate` datetime NOT NULL,
  `UpdatedBy` varchar(255) DEFAULT NULL,
  `UpdatedDate` datetime DEFAULT NULL,
  `IsDeleted` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`DentalID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dental`
--

LOCK TABLES `dental` WRITE;
/*!40000 ALTER TABLE `dental` DISABLE KEYS */;
/*!40000 ALTER TABLE `dental` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dental_treatment`
--

DROP TABLE IF EXISTS `dental_treatment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dental_treatment` (
  `Dental_TreatementID` bigint(20) NOT NULL,
  `DentalID` bigint(20) NOT NULL,
  `TreatmentID` bigint(20) NOT NULL,
  `PerSessionDuration` float NOT NULL,
  `CreatedBy` varchar(255) NOT NULL,
  `CreatedDate` datetime NOT NULL,
  `UpdatedBy` varchar(255) DEFAULT NULL,
  `UpdatedDate` datetime DEFAULT NULL,
  `IsDeleted` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`Dental_TreatementID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dental_treatment`
--

LOCK TABLES `dental_treatment` WRITE;
/*!40000 ALTER TABLE `dental_treatment` DISABLE KEYS */;
/*!40000 ALTER TABLE `dental_treatment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dentist`
--

DROP TABLE IF EXISTS `dentist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dentist` (
  `DentistID` bigint(20) NOT NULL,
  `DentistName` varchar(255) NOT NULL,
  `DentalID` bigint(20) NOT NULL,
  `DentistDescription` varchar(3000) DEFAULT NULL,
  `Gender` varchar(10) NOT NULL,
  `IsOnLeave` tinyint(4) DEFAULT NULL,
  `LeaveStartDate` date DEFAULT NULL,
  `LeaveEndDate` date DEFAULT NULL,
  `CreatedBy` varchar(255) NOT NULL,
  `CreatedDate` datetime NOT NULL,
  `UpdatedBy` varchar(255) DEFAULT NULL,
  `UpdatedDate` datetime DEFAULT NULL,
  `IsDeleted` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`DentistID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dentist`
--

LOCK TABLES `dentist` WRITE;
/*!40000 ALTER TABLE `dentist` DISABLE KEYS */;
/*!40000 ALTER TABLE `dentist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dentistworkingschedule`
--

DROP TABLE IF EXISTS `dentistworkingschedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dentistworkingschedule` (
  `DentistWorkingScheduleID` bigint(20) NOT NULL,
  `DentistID` bigint(20) NOT NULL,
  `DayOfWeek` int(1) NOT NULL,
  `StartTime` time NOT NULL,
  `EndTime` time NOT NULL,
  `BreakStartTime` time NOT NULL,
  `BreakEndTime` time NOT NULL,
  `CreatedBy` varchar(255) NOT NULL,
  `CreatedDate` datetime NOT NULL,
  `UpdatedBy` varchar(255) DEFAULT NULL,
  `UpdatedDate` datetime DEFAULT NULL,
  `IsDeleted` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`DentistWorkingScheduleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dentistworkingschedule`
--

LOCK TABLES `dentistworkingschedule` WRITE;
/*!40000 ALTER TABLE `dentistworkingschedule` DISABLE KEYS */;
/*!40000 ALTER TABLE `dentistworkingschedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `treatment`
--

DROP TABLE IF EXISTS `treatment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `treatment` (
  `TreatmentID` bigint(20) NOT NULL,
  `TreatmentName` varchar(255) NOT NULL,
  `CreatedBy` varchar(255) NOT NULL,
  `CreatedDate` datetime NOT NULL,
  `UpdatedBy` varchar(255) DEFAULT NULL,
  `UpdatedDate` datetime DEFAULT NULL,
  `IsDeleted` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`TreatmentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `treatment`
--

LOCK TABLES `treatment` WRITE;
/*!40000 ALTER TABLE `treatment` DISABLE KEYS */;
/*!40000 ALTER TABLE `treatment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `UserID` varchar(255) NOT NULL,
  `UserName` varchar(255) DEFAULT NULL,
  `Password` varchar(255) DEFAULT NULL,
  `BirthDate` datetime NOT NULL,
  `EmailAddress` varchar(255) NOT NULL,
  `ContactNumber` varchar(20) NOT NULL,
  `Gender` varchar(10) DEFAULT NULL,
  `ICNumber` varchar(15) NOT NULL,
  `UserType` varchar(10) DEFAULT NULL,
  `CreatedBy` varchar(255) NOT NULL,
  `CreatedDate` datetime NOT NULL,
  `UpdatedBy` varchar(255) DEFAULT NULL,
  `UpdatedDate` datetime DEFAULT NULL,
  `IsDeleted` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`UserID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'dentalappiont'
--

--
-- Dumping routines for database 'dentalappiont'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-25 14:18:20
