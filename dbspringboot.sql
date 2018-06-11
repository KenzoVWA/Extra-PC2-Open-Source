CREATE DATABASE  IF NOT EXISTS `db_springboot` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `db_springboot`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: Localhost    Database: db_springboot
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) NOT NULL,
  `dni` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Van Waerebeek',75131971,'Kenzo'),(2,'Gomez',123,'Francisco'),(3,'Hervas',456,'Mateo'),(4,'Linares',789,'Diego'),(5,'Mendoza',14785,'Henry'),(6,'Renuncio',654123,'PPK');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuenta`
--

DROP TABLE IF EXISTS `cuenta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cuenta` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `banco` varchar(255) NOT NULL,
  `nrocta` int(11) NOT NULL,
  `saldobase` bigint(20) NOT NULL,
  `cliente_id` bigint(20) DEFAULT NULL,
  `clave` int(11) NOT NULL,
  `maxintentos` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4p224uogyy5hmxvn8fwa2jlug` (`cliente_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuenta`
--

LOCK TABLES `cuenta` WRITE;
/*!40000 ALTER TABLE `cuenta` DISABLE KEYS */;
INSERT INTO `cuenta` VALUES (1,'BCP',987,4000,1,987,0),(2,'Interbank',654,4000,1,654,0),(3,'BOA',321,2000,1,321,0),(4,'BCP',987654321,500,2,987654321,0),(5,'Scotiabank',963258,2148,4,0,0),(6,'Americano',109080,9000,6,963,0);
/*!40000 ALTER TABLE `cuenta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimiento`
--

DROP TABLE IF EXISTS `movimiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movimiento` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `monto` int(11) NOT NULL,
  `tipo` varchar(255) NOT NULL,
  `cuenta_id` bigint(20) DEFAULT NULL,
  `create_at` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4ea11fe7p3xa1kwwmdgi9f2fi` (`cuenta_id`)
) ENGINE=MyISAM AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimiento`
--

LOCK TABLES `movimiento` WRITE;
/*!40000 ALTER TABLE `movimiento` DISABLE KEYS */;
INSERT INTO `movimiento` VALUES (23,1000,'deposito',1,'2018-06-08'),(24,2000,'deposito',1,'2018-06-08'),(25,1000,'deposito',1,'2018-06-08'),(27,1000,'retiro',1,'2018-06-08'),(28,1000,'retiro',1,'2018-06-08'),(29,1000,'retiro',1,'2018-06-08'),(30,1000,'retiro',1,'2018-06-08'),(31,4000,'retiro',5,'2018-06-10'),(32,2000,'retiro',6,'2018-06-10'),(33,852,'retiro',5,'2018-06-10'),(34,1000,'deposito',6,'2018-06-10');
/*!40000 ALTER TABLE `movimiento` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-10 19:16:38
