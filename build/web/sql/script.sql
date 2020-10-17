-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: universidad
-- ------------------------------------------------------
-- Server version	5.7.24

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
-- Table structure for table `alumno`
--

DROP TABLE IF EXISTS `alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumno` (
  `numero_carne` int(11) NOT NULL,
  `nombre` varchar(75) NOT NULL,
  `apellido` varchar(75) NOT NULL,
  `correo` varchar(45) DEFAULT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `direccion` varchar(105) DEFAULT NULL,
  `genero_idgenero` int(11) NOT NULL,
  PRIMARY KEY (`numero_carne`),
  KEY `fk_Alumno_genero_idx` (`genero_idgenero`),
  CONSTRAINT `fk_Alumno_genero` FOREIGN KEY (`genero_idgenero`) REFERENCES `genero` (`idgenero`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno`
--

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` VALUES (12342,'BILL','GATES','BGATES@MICROSOFT.COM',NULL,NULL,1),(12345,'JUAN PABLO ','ESCOBAR CASTRO','ingejp@outlook.com','78945612','colonia san andres santo tomas de castilla puerto barrios izabal',1),(23456,'EDWIN','BARRERA','ebarrera@gmail.com','2345677654','puerto barrios izabal',1),(45464,'ALLAN','CORREA','correo@correo.com',NULL,NULL,1),(123474,'JORGE ARMANDO','RIVAS A','correo@correo.com',NULL,NULL,1),(564217,'JOSE MANUEL','FELIZ','correo@correo.com',NULL,NULL,1),(4561237,'PERLA RUBY','LOPEZ','perla@gmail.com','78945222','COLONIA LA PRIMAVERA PUERTO BARRIOS IZABAL',2),(4645645,'JUAN LUIS','PEREZ','jperez@gmail.com','789946546','Puerto Barrios Izabal',1),(12345678,'EFRAIN','DE LEON ','efraindeleon@gmail.com','789456123','14 CALLE COLONIA LANDIVAR PUERTO BARRIOS IZABAL',1),(12345688,'GEORGE ','DE LA SELVA','ALGO@CORREO.COM',NULL,NULL,1),(15642452,'CARLOS ','RUIZ','correo@correo.com',NULL,NULL,1),(147141414,'JORGE ','ORELLANA','correo@correo.com',NULL,NULL,1),(564654564,'FERNANDO','ORDOÑEZ','fernando@correo.com',NULL,NULL,1),(987987897,'JENNIFER ','LOPEZ','correo@correo.com',NULL,NULL,1);
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asignacion_curso`
--

DROP TABLE IF EXISTS `asignacion_curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `asignacion_curso` (
  `idasignacion_curso` int(11) NOT NULL AUTO_INCREMENT,
  `inscripcion_idinscripcion` int(11) NOT NULL,
  `curso_codigo_curso` int(11) NOT NULL,
  PRIMARY KEY (`idasignacion_curso`),
  KEY `fk_asignacion_curso_inscripcion1_idx` (`inscripcion_idinscripcion`),
  KEY `fk_asignacion_curso_curso1_idx` (`curso_codigo_curso`),
  CONSTRAINT `fk_asignacion_curso_curso1` FOREIGN KEY (`curso_codigo_curso`) REFERENCES `curso` (`codigo_curso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_asignacion_curso_inscripcion1` FOREIGN KEY (`inscripcion_idinscripcion`) REFERENCES `inscripcion` (`idinscripcion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asignacion_curso`
--

LOCK TABLES `asignacion_curso` WRITE;
/*!40000 ALTER TABLE `asignacion_curso` DISABLE KEYS */;
/*!40000 ALTER TABLE `asignacion_curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `curso` (
  `codigo_curso` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`codigo_curso`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (47,'PROGRA I'),(48,'PROGRA II'),(49,'PROGRA III'),(50,'DESARROLLO WEB'),(51,'INGENIERIA DE SOFTWARE');
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genero`
--

DROP TABLE IF EXISTS `genero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genero` (
  `idgenero` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL COMMENT 'Este es un ejemplo de notas en las tablas',
  PRIMARY KEY (`idgenero`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genero`
--

LOCK TABLES `genero` WRITE;
/*!40000 ALTER TABLE `genero` DISABLE KEYS */;
INSERT INTO `genero` VALUES (1,'MASCULINO'),(2,'FEMENINO');
/*!40000 ALTER TABLE `genero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inscripcion`
--

DROP TABLE IF EXISTS `inscripcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inscripcion` (
  `idinscripcion` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_inscripcion` date NOT NULL,
  `Alumno_numero_carne` int(11) NOT NULL,
  PRIMARY KEY (`idinscripcion`),
  KEY `fk_inscripcion_Alumno1_idx` (`Alumno_numero_carne`),
  CONSTRAINT `fk_inscripcion_Alumno1` FOREIGN KEY (`Alumno_numero_carne`) REFERENCES `alumno` (`numero_carne`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inscripcion`
--

LOCK TABLES `inscripcion` WRITE;
/*!40000 ALTER TABLE `inscripcion` DISABLE KEYS */;
/*!40000 ALTER TABLE `inscripcion` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-17 17:25:18
