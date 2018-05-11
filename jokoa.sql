-- MySQL dump 10.13  Distrib 5.7.22, for Linux (x86_64)
--
-- Host: localhost    Database: jokoa
-- ------------------------------------------------------
-- Server version	5.7.22-0ubuntu18.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `animalia`
--

DROP TABLE IF EXISTS `animalia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `animalia` (
  `izena` char(10) NOT NULL,
  `zenbakia` int(11) NOT NULL,
  `deskribapena` varchar(40) DEFAULT NULL,
  `puntuazioa` int(11) NOT NULL,
  `orijinala` bit(1) NOT NULL,
  PRIMARY KEY (`zenbakia`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animalia`
--

LOCK TABLES `animalia` WRITE;
/*!40000 ALTER TABLE `animalia` DISABLE KEYS */;
INSERT INTO `animalia` VALUES ('Loro',2,'Tablerotik animalia bat bota',4,'');
/*!40000 ALTER TABLE `animalia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jokalaria`
--

DROP TABLE IF EXISTS `jokalaria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jokalaria` (
  `izena` char(15) NOT NULL,
  `abizena` char(15) NOT NULL,
  `pasahitza` char(10) NOT NULL,
  `jaioUrtea` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `erregistroData` date NOT NULL,
  `mota` char(10) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jokalaria`
--

LOCK TABLES `jokalaria` WRITE;
/*!40000 ALTER TABLE `jokalaria` DISABLE KEYS */;
INSERT INTO `jokalaria` VALUES ('ari','Mendez','admin',0,'','2018-04-02','admin'),('admin','.','admin',1998,'admin','2018-05-02','admin'),('justin','bieber','baby',1992,'jb@believe.com','2018-05-08','admin');
/*!40000 ALTER TABLE `jokalaria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partida`
--

DROP TABLE IF EXISTS `partida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `partida` (
  `kodea` int(11) NOT NULL,
  `kolorea` char(10) NOT NULL,
  `data` date NOT NULL,
  `hOrdua` time NOT NULL,
  `bOrdua` time NOT NULL,
  `jokEmail` varchar(255) NOT NULL,
  `puntuJok` int(11) NOT NULL,
  `puntuOrd` int(11) NOT NULL,
  `egoera` bit(1) DEFAULT NULL,
  PRIMARY KEY (`kodea`),
  KEY `jokEmail` (`jokEmail`),
  CONSTRAINT `partida_ibfk_1` FOREIGN KEY (`jokEmail`) REFERENCES `jokalaria` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partida`
--

LOCK TABLES `partida` WRITE;
/*!40000 ALTER TABLE `partida` DISABLE KEYS */;
INSERT INTO `partida` VALUES (1,'berdea','2018-05-09','18:10:11','18:10:11','admin',1,2,''),(2,'berdea','2018-05-09','18:32:44','18:32:44','admin',3,4,''),(3,'berdea','2018-05-09','19:13:34','19:13:34','admin',3,4,'\0');
/*!40000 ALTER TABLE `partida` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-10 12:33:11
