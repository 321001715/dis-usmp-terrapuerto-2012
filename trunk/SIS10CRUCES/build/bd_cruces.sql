CREATE DATABASE  IF NOT EXISTS `bd_cruces` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bd_cruces`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: bd_cruces
-- ------------------------------------------------------
-- Server version	5.5.24

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
-- Table structure for table `t_ubigeo`
--

DROP TABLE IF EXISTS `t_ubigeo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_ubigeo` (
  `UBGCODUBI` char(6) DEFAULT NULL,
  `UBGDEDPTO` char(2) DEFAULT NULL,
  `UBGDEPROV` char(2) DEFAULT NULL,
  `UBGDEDSTO` char(2) DEFAULT NULL,
  `UBGDESUBI` varchar(150) DEFAULT NULL,
  `UBGCODPOS` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_agencia`
--

DROP TABLE IF EXISTS `t_agencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_agencia` (
  `idAgencia` int(10) NOT NULL AUTO_INCREMENT,
  `ciudad` int(11) NOT NULL,
  `direccion` varchar(45) COLLATE armscii8_bin NOT NULL,
  `idProveedor` int(4) NOT NULL,
  PRIMARY KEY (`idAgencia`),
  KEY `fk_t_agencia_t_proveedor1_idx` (`idProveedor`),
  CONSTRAINT `fk_t_agencia_t_proveedor1` FOREIGN KEY (`idProveedor`) REFERENCES `t_proveedor` (`idProveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_chofer`
--

DROP TABLE IF EXISTS `t_chofer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_chofer` (
  `idChofer` int(6) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(45) COLLATE armscii8_bin NOT NULL,
  `apePat` varchar(45) COLLATE armscii8_bin NOT NULL,
  `apeMat` varchar(45) COLLATE armscii8_bin NOT NULL,
  `numDoc` int(8) NOT NULL,
  `tipDoc` varchar(20) COLLATE armscii8_bin NOT NULL,
  `numLicencia` int(11) NOT NULL,
  `idProveedor` int(11) NOT NULL,
  PRIMARY KEY (`idChofer`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_perfil`
--

DROP TABLE IF EXISTS `t_perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_perfil` (
  `idPerfil` int(6) NOT NULL AUTO_INCREMENT,
  `perfil` varchar(20) COLLATE armscii8_bin NOT NULL,
  `descripcion` varchar(45) COLLATE armscii8_bin DEFAULT NULL,
  `usuarioInsert` varchar(45) COLLATE armscii8_bin DEFAULT NULL,
  `fechaInsert` date DEFAULT NULL,
  `usuarioUpdate` varchar(45) COLLATE armscii8_bin DEFAULT NULL,
  `fechaUpdate` date DEFAULT NULL,
  `estado` varchar(45) COLLATE armscii8_bin DEFAULT NULL,
  PRIMARY KEY (`idPerfil`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_ruta`
--

DROP TABLE IF EXISTS `t_ruta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_ruta` (
  `idRuta` int(8) NOT NULL AUTO_INCREMENT,
  `nomRuta` varchar(45) COLLATE armscii8_bin NOT NULL,
  `origen` int(11) NOT NULL,
  `destino` int(11) NOT NULL,
  `km` int(11) NOT NULL,
  `duracion` int(11) NOT NULL,
  `estado` varchar(15) COLLATE armscii8_bin NOT NULL,
  `idProveedor` int(4) NOT NULL,
  `idUbigeo` int(5) NOT NULL,
  `userInsert` int(6) DEFAULT NULL,
  `fechaInsert` datetime DEFAULT NULL,
  `userUpdate` int(6) DEFAULT NULL,
  `fechaUpdate` datetime DEFAULT NULL,
  PRIMARY KEY (`idRuta`),
  KEY `fk_t_ruta_t_proveedor1_idx` (`idProveedor`),
  KEY `fk_t_ruta_t_ciudad1_idx` (`idUbigeo`),
  CONSTRAINT `fk_t_ruta_t_proveedor1` FOREIGN KEY (`idProveedor`) REFERENCES `t_proveedor` (`idProveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_reserva`
--

DROP TABLE IF EXISTS `t_reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_reserva` (
  `idReserva` int(7) NOT NULL AUTO_INCREMENT,
  `idUsuario1` int(6) NOT NULL,
  `fecha` date NOT NULL,
  `estado` varchar(15) COLLATE armscii8_bin NOT NULL,
  `userInsert` int(6) DEFAULT NULL,
  `fechaInsert` datetime DEFAULT NULL,
  `userUpdate` int(6) DEFAULT NULL,
  `fechaUpdate` datetime DEFAULT NULL,
  PRIMARY KEY (`idReserva`),
  KEY `fk_t_reserva_t_usuario_idx` (`idUsuario1`),
  CONSTRAINT `fk_t_reserva_t_usuario` FOREIGN KEY (`idUsuario1`) REFERENCES `t_usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_usuario`
--

DROP TABLE IF EXISTS `t_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_usuario` (
  `idUsuario` int(6) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(20) COLLATE armscii8_bin NOT NULL,
  `clave` varchar(8) COLLATE armscii8_bin NOT NULL,
  `estado` varchar(45) COLLATE armscii8_bin NOT NULL,
  `tipDoc` varchar(20) COLLATE armscii8_bin NOT NULL,
  `numDoc` varchar(20) COLLATE armscii8_bin NOT NULL,
  `nombres` varchar(45) COLLATE armscii8_bin NOT NULL,
  `apePat` varchar(45) COLLATE armscii8_bin NOT NULL,
  `apeMat` varchar(45) COLLATE armscii8_bin NOT NULL,
  `idUbigeo` int(11) DEFAULT NULL,
  `direccion` varchar(200) COLLATE armscii8_bin DEFAULT NULL,
  `sexo` varchar(45) COLLATE armscii8_bin DEFAULT NULL,
  `tel` varchar(11) COLLATE armscii8_bin DEFAULT NULL,
  `idPerfil` int(6) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  KEY `fk_t_usuario_t_tipousuario1_idx` (`idPerfil`),
  CONSTRAINT `fk_t_usuario_t_tipousuario1` FOREIGN KEY (`idPerfil`) REFERENCES `t_perfil` (`idPerfil`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_persona`
--

DROP TABLE IF EXISTS `t_persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_persona` (
  `id_persona` int(8) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(45) NOT NULL,
  `apePat` varchar(45) NOT NULL,
  `apeMat` varchar(45) NOT NULL,
  `numDoc` int(8) NOT NULL,
  `tipDoc` varchar(20) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `sexo` varchar(1) NOT NULL,
  `tel` varchar(11) NOT NULL,
  `estado` varchar(15) NOT NULL,
  PRIMARY KEY (`id_persona`),
  UNIQUE KEY `id_persona_UNIQUE` (`id_persona`)
) ENGINE=InnoDB AUTO_INCREMENT=98917039 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_vehiculo`
--

DROP TABLE IF EXISTS `t_vehiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_vehiculo` (
  `idVehiculo` int(6) NOT NULL AUTO_INCREMENT,
  `codVehiculo` varchar(45) COLLATE armscii8_bin DEFAULT NULL,
  `placa` varchar(45) COLLATE armscii8_bin NOT NULL,
  `numPiso` int(11) NOT NULL,
  `numAsientos` int(11) NOT NULL,
  `marca` varchar(45) COLLATE armscii8_bin NOT NULL,
  `modelo` varchar(45) COLLATE armscii8_bin NOT NULL,
  `obs` varchar(100) COLLATE armscii8_bin NOT NULL,
  `estado` varchar(15) COLLATE armscii8_bin NOT NULL,
  `idProveedor` int(4) NOT NULL,
  PRIMARY KEY (`idVehiculo`),
  KEY `fk_t_vehiculo_t_proveedor1_idx` (`idProveedor`),
  CONSTRAINT `fk_t_vehiculo_t_proveedor1` FOREIGN KEY (`idProveedor`) REFERENCES `t_proveedor` (`idProveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_viaje`
--

DROP TABLE IF EXISTS `t_viaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_viaje` (
  `idViaje` int(8) NOT NULL AUTO_INCREMENT,
  `codViaje` varchar(45) COLLATE armscii8_bin NOT NULL,
  `nomViaje` varchar(45) COLLATE armscii8_bin NOT NULL,
  `fecSalida` date NOT NULL,
  `fecLlegada` date NOT NULL,
  `horSalida` date NOT NULL,
  `horLlegada` date NOT NULL,
  `precio` int(11) NOT NULL,
  `estado` varchar(15) COLLATE armscii8_bin NOT NULL,
  `idRuta` int(8) NOT NULL,
  `servicio` varchar(45) COLLATE armscii8_bin NOT NULL,
  `idChofer` int(6) NOT NULL,
  `idVehiculo` int(6) NOT NULL,
  `idClasificacion` int(5) NOT NULL,
  `userInsert` int(6) DEFAULT NULL,
  `FechaInsert` datetime DEFAULT NULL,
  `userUpdate` int(6) DEFAULT NULL,
  `fechaUpdate` datetime DEFAULT NULL,
  PRIMARY KEY (`idViaje`),
  KEY `fk_t_viaje_t_ruta1_idx` (`idRuta`),
  KEY `fk_t_viaje_t_chofer1_idx` (`idChofer`),
  KEY `fk_t_viaje_t_vehiculo1_idx` (`idVehiculo`),
  KEY `fk_t_viaje_t_clasificacion1` (`idClasificacion`),
  CONSTRAINT `fk_t_viaje_t_chofer1` FOREIGN KEY (`idChofer`) REFERENCES `t_chofer` (`idChofer`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_viaje_t_clasificacion1` FOREIGN KEY (`idClasificacion`) REFERENCES `t_clasificacion` (`idClasificacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_viaje_t_ruta1` FOREIGN KEY (`idRuta`) REFERENCES `t_ruta` (`idRuta`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_viaje_t_vehiculo1` FOREIGN KEY (`idVehiculo`) REFERENCES `t_vehiculo` (`idVehiculo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_boleto`
--

DROP TABLE IF EXISTS `t_boleto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_boleto` (
  `idBoleto` int(7) NOT NULL AUTO_INCREMENT,
  `idPasajero` int(7) NOT NULL,
  `idViaje` int(8) NOT NULL,
  `idReserva` int(7) NOT NULL,
  `asiento` varchar(45) COLLATE armscii8_bin NOT NULL,
  `estado` varchar(15) COLLATE armscii8_bin NOT NULL,
  `userInsert` int(6) DEFAULT NULL,
  `fechaInsert` datetime DEFAULT NULL,
  `userUpdate` int(6) DEFAULT NULL,
  `fechaUpdate` datetime DEFAULT NULL,
  PRIMARY KEY (`idBoleto`),
  KEY `fk_t_boleto_t_pasajero1_idx` (`idPasajero`),
  KEY `fk_t_boleto_t_viaje1_idx` (`idViaje`),
  KEY `fk_t_boleto_t_reserva1_idx` (`idReserva`),
  CONSTRAINT `fk_t_boleto_t_pasajero1` FOREIGN KEY (`idPasajero`) REFERENCES `t_pasajero` (`idPasajero`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_boleto_t_reserva1` FOREIGN KEY (`idReserva`) REFERENCES `t_reserva` (`idReserva`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_boleto_t_viaje1` FOREIGN KEY (`idViaje`) REFERENCES `t_viaje` (`idViaje`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_pasajero`
--

DROP TABLE IF EXISTS `t_pasajero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_pasajero` (
  `idPasajero` int(7) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(45) COLLATE armscii8_bin NOT NULL,
  `apePat` varchar(45) COLLATE armscii8_bin NOT NULL,
  `apeMat` varchar(45) COLLATE armscii8_bin NOT NULL,
  `numDoc` int(11) NOT NULL,
  `tipDoc` varchar(20) COLLATE armscii8_bin NOT NULL,
  `estado` varchar(15) COLLATE armscii8_bin DEFAULT NULL,
  PRIMARY KEY (`idPasajero`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_proveedor`
--

DROP TABLE IF EXISTS `t_proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_proveedor` (
  `idProveedor` int(4) NOT NULL AUTO_INCREMENT,
  `ruc` int(11) NOT NULL,
  `razSocial` varchar(45) COLLATE armscii8_bin NOT NULL,
  `razCom` varchar(45) COLLATE armscii8_bin NOT NULL,
  `direccion` varchar(45) COLLATE armscii8_bin NOT NULL,
  `tel` int(11) NOT NULL,
  `estado` varchar(15) COLLATE armscii8_bin NOT NULL,
  PRIMARY KEY (`idProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_clasificacion`
--

DROP TABLE IF EXISTS `t_clasificacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_clasificacion` (
  `idClasificacion` int(5) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE armscii8_bin NOT NULL,
  `descripcion` varchar(30) COLLATE armscii8_bin NOT NULL,
  `usuarioInsert` varchar(45) COLLATE armscii8_bin DEFAULT NULL,
  `fechaInsert` date DEFAULT NULL,
  `usuarioUpdate` varchar(45) COLLATE armscii8_bin DEFAULT NULL,
  `fechaUpdate` date DEFAULT NULL,
  `estado` varchar(45) COLLATE armscii8_bin DEFAULT NULL,
  PRIMARY KEY (`idClasificacion`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_equipaje`
--

DROP TABLE IF EXISTS `t_equipaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_equipaje` (
  `idEquipaje` int(7) NOT NULL AUTO_INCREMENT,
  `idPasajero` int(7) NOT NULL,
  `peso` varchar(45) COLLATE armscii8_bin DEFAULT NULL,
  PRIMARY KEY (`idEquipaje`),
  KEY `fk_t_equipaje_t_pasajero1_idx` (`idPasajero`),
  CONSTRAINT `fk_t_equipaje_t_pasajero1` FOREIGN KEY (`idPasajero`) REFERENCES `t_pasajero` (`idPasajero`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-09-21 17:11:09
