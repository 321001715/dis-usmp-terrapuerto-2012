-- phpMyAdmin SQL Dump
-- version 3.5.2
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 06-09-2012 a las 12:21:59
-- Versión del servidor: 5.5.25a
-- Versión de PHP: 5.4.4

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `bd_cruces`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_agencia`
--

CREATE TABLE IF NOT EXISTS `t_agencia` (
  `idAgencia` int(11) NOT NULL AUTO_INCREMENT,
  `ciudad` int(11) NOT NULL,
  `direccion` varchar(45) COLLATE armscii8_bin NOT NULL,
  `idProveedor` int(11) NOT NULL,
  PRIMARY KEY (`idAgencia`),
  KEY `fk_t_agencia_t_proveedor1_idx` (`idProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_boleto`
--

CREATE TABLE IF NOT EXISTS `t_boleto` (
  `idBoleto` int(11) NOT NULL AUTO_INCREMENT,
  `idPasajero` int(11) NOT NULL,
  `idViaje` int(11) NOT NULL,
  `idReserva` int(11) NOT NULL,
  `asiento` varchar(45) COLLATE armscii8_bin NOT NULL,
  `estado` varchar(1) COLLATE armscii8_bin NOT NULL,
  `userInsert` varchar(45) COLLATE armscii8_bin DEFAULT NULL,
  `fechaInsert` datetime DEFAULT NULL,
  `userUpdate` varchar(45) COLLATE armscii8_bin DEFAULT NULL,
  `fechaUpdate` datetime DEFAULT NULL,
  PRIMARY KEY (`idBoleto`),
  KEY `fk_t_boleto_t_pasajero1_idx` (`idPasajero`),
  KEY `fk_t_boleto_t_viaje1_idx` (`idViaje`),
  KEY `fk_t_boleto_t_reserva1_idx` (`idReserva`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_chofer`
--

CREATE TABLE IF NOT EXISTS `t_chofer` (
  `idChofer` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(45) COLLATE armscii8_bin NOT NULL,
  `apePat` varchar(45) COLLATE armscii8_bin NOT NULL,
  `apeMat` varchar(45) COLLATE armscii8_bin NOT NULL,
  `dni` int(11) NOT NULL,
  `numLicencia` int(11) NOT NULL,
  `idProveedor` int(11) NOT NULL,
  PRIMARY KEY (`idChofer`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_ciudad`
--

CREATE TABLE IF NOT EXISTS `t_ciudad` (
  `idCiudad` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` text COLLATE armscii8_bin NOT NULL,
  `idProvincia` int(11) NOT NULL,
  PRIMARY KEY (`idCiudad`),
  KEY `fk_t_ciudad_t_provincia1_idx` (`idProvincia`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_clasificasion`
--

CREATE TABLE IF NOT EXISTS `t_clasificasion` (
  `idClasificasion` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE armscii8_bin NOT NULL,
  `descripcion` varchar(30) COLLATE armscii8_bin NOT NULL,
  `usuarioInsert` varchar(45) COLLATE armscii8_bin DEFAULT NULL,
  `fechaInsert` datetime DEFAULT NULL,
  `usuarioUpdate` varchar(45) COLLATE armscii8_bin DEFAULT NULL,
  `fechaUpdate` datetime DEFAULT NULL,
  PRIMARY KEY (`idClasificasion`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_departamento`
--

CREATE TABLE IF NOT EXISTS `t_departamento` (
  `idDepartamento` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` text COLLATE armscii8_bin NOT NULL,
  PRIMARY KEY (`idDepartamento`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_equipaje`
--

CREATE TABLE IF NOT EXISTS `t_equipaje` (
  `idEquipaje` int(11) NOT NULL AUTO_INCREMENT,
  `idPasajero` int(11) NOT NULL,
  PRIMARY KEY (`idEquipaje`,`idPasajero`),
  KEY `fk_t_equipaje_t_pasajero1_idx` (`idPasajero`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_pasajero`
--

CREATE TABLE IF NOT EXISTS `t_pasajero` (
  `idPasajero` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` text COLLATE armscii8_bin NOT NULL,
  `apePat` text COLLATE armscii8_bin NOT NULL,
  `apeMat` text COLLATE armscii8_bin NOT NULL,
  `dni` int(11) NOT NULL,
  PRIMARY KEY (`idPasajero`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_perfil`
--

CREATE TABLE IF NOT EXISTS `t_perfil` (
  `idTipoUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `perfil` text COLLATE armscii8_bin NOT NULL,
  `descripcion` varchar(45) COLLATE armscii8_bin NOT NULL,
  `usuarioInsert` varchar(45) COLLATE armscii8_bin DEFAULT NULL,
  `fechaInsert` datetime DEFAULT NULL,
  `usuarioUpdate` varchar(45) COLLATE armscii8_bin DEFAULT NULL,
  `fechaUpdate` datetime DEFAULT NULL,
  PRIMARY KEY (`idTipoUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_persona`
--

CREATE TABLE IF NOT EXISTS `t_persona` (
  `id_persona` int(11) NOT NULL AUTO_INCREMENT,
  `dni` int(8) NOT NULL,
  `nombres` varchar(45) NOT NULL,
  `apePat` varchar(45) NOT NULL,
  `apeMat` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `sexo` varchar(1) NOT NULL,
  `tel` int(11) NOT NULL,
  `estado` varchar(1) NOT NULL,
  PRIMARY KEY (`id_persona`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_proveedor`
--

CREATE TABLE IF NOT EXISTS `t_proveedor` (
  `idProveedor` int(11) NOT NULL AUTO_INCREMENT,
  `codEmpre` int(11),
  `ruc` varchar(11) NOT NULL,
  `razSocial` varchar(45) COLLATE armscii8_bin NOT NULL,
  `razCom` varchar(45) COLLATE armscii8_bin NOT NULL,
  `direccion` varchar(45) COLLATE armscii8_bin NOT NULL,
  `tel` int(11) NOT NULL,
  `usuario` varchar(45) COLLATE armscii8_bin NOT NULL,
  `clave` varchar(45) COLLATE armscii8_bin NOT NULL,
  `estado` varchar(1) COLLATE armscii8_bin NOT NULL,
  PRIMARY KEY (`idProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_provincia`
--

CREATE TABLE IF NOT EXISTS `t_provincia` (
  `idProvincia` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` text COLLATE armscii8_bin NOT NULL,
  `idDepartamento` int(11) NOT NULL,
  PRIMARY KEY (`idProvincia`),
  KEY `fk_t_provincia_t_departamento1_idx` (`idDepartamento`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_reserva`
--

CREATE TABLE IF NOT EXISTS `t_reserva` (
  `idReserva` int(11) NOT NULL AUTO_INCREMENT,
  `idUsuario1` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `estado` varchar(1) COLLATE armscii8_bin NOT NULL,
  `userInsert` varchar(45) COLLATE armscii8_bin DEFAULT NULL,
  `fechaInsert` datetime DEFAULT NULL,
  `userUpdate` varchar(45) COLLATE armscii8_bin DEFAULT NULL,
  `fechaUpdate` datetime DEFAULT NULL,
  PRIMARY KEY (`idReserva`),
  KEY `fk_t_reserva_t_usuario_idx` (`idUsuario1`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_ruta`
--

CREATE TABLE IF NOT EXISTS `t_ruta` (
  `idRuta` int(11) NOT NULL AUTO_INCREMENT,
  `codRuta` text COLLATE armscii8_bin NOT NULL,
  `nomRuta` text COLLATE armscii8_bin NOT NULL,
  `origen` text COLLATE armscii8_bin NOT NULL,
  `destino` text COLLATE armscii8_bin NOT NULL,
  `km` int(11) NOT NULL,
  `duracion` int(11) NOT NULL,
  `estado` text COLLATE armscii8_bin NOT NULL,
  `idProveedor` int(11) NOT NULL,
  `idCiudad` int(11) NOT NULL,
  PRIMARY KEY (`idRuta`),
  KEY `fk_t_ruta_t_proveedor1_idx` (`idProveedor`),
  KEY `fk_t_ruta_t_ciudad1_idx` (`idCiudad`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_usuario`
--

CREATE TABLE IF NOT EXISTS `t_usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(45) COLLATE armscii8_bin NOT NULL,
  `clave` varchar(45) COLLATE armscii8_bin NOT NULL,
  `estado` varchar(45) COLLATE armscii8_bin NOT NULL,
  `dni` int(11) NOT NULL,
  `nombres` varchar(45) COLLATE armscii8_bin NOT NULL,
  `apePat` varchar(45) COLLATE armscii8_bin NOT NULL,
  `apeMat` varchar(45) COLLATE armscii8_bin NOT NULL,
  `idCiudad` int(11) NOT NULL,
  `direccion` varchar(45) COLLATE armscii8_bin NOT NULL,
  `sexo` varchar(45) COLLATE armscii8_bin NOT NULL,
  `tel` int(11) NOT NULL,
  `idPerfil` int(11) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  KEY `fk_t_usuario_t_tipousuario1_idx` (`idPerfil`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_vehiculo`
--

CREATE TABLE IF NOT EXISTS `t_vehiculo` (
  `idVehiculo` int(11) NOT NULL AUTO_INCREMENT,
  `codVehiculo` varchar(45) COLLATE armscii8_bin,
  `placa` varchar(45) COLLATE armscii8_bin NOT NULL,
  `numPiso` int(11) NOT NULL,
  `numAsientos` int(11) NOT NULL,
  `marca` varchar(45) COLLATE armscii8_bin NOT NULL,
  `modelo` varchar(45) COLLATE armscii8_bin NOT NULL,
  `obs` varchar(100) COLLATE armscii8_bin NOT NULL,
  `estado` varchar(45) COLLATE armscii8_bin NOT NULL,
  `idProveedor` int(11) NOT NULL,
  PRIMARY KEY (`idVehiculo`),
  KEY `fk_t_vehiculo_t_proveedor1_idx` (`idProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_viaje`
--

CREATE TABLE IF NOT EXISTS `t_viaje` (
  `idViaje` int(11) NOT NULL AUTO_INCREMENT,
  `codViaje` text COLLATE armscii8_bin NOT NULL,
  `nomViaje` text COLLATE armscii8_bin NOT NULL,
  `fecSalida` date NOT NULL,
  `fecLlegada` date NOT NULL,
  `horSalida` date NOT NULL,
  `horLlegada` date NOT NULL,
  `precio` int(11) NOT NULL,
  `estado` text COLLATE armscii8_bin NOT NULL,
  `idRuta` int(11) NOT NULL,
  `servicio` varchar(45) COLLATE armscii8_bin NOT NULL,
  `idChofer` int(11) NOT NULL,
  `idVehiculo` int(11) NOT NULL,
  `userInsert` varchar(45) COLLATE armscii8_bin DEFAULT NULL,
  `FechaInsert` datetime DEFAULT NULL,
  `userUpdate` varchar(45) COLLATE armscii8_bin DEFAULT NULL,
  `fechaUpdate` datetime DEFAULT NULL,
  `idClasificasion` int(11) NOT NULL,
  PRIMARY KEY (`idViaje`),
  KEY `fk_t_viaje_t_ruta1_idx` (`idRuta`),
  KEY `fk_t_viaje_t_chofer1_idx` (`idChofer`),
  KEY `fk_t_viaje_t_vehiculo1_idx` (`idVehiculo`),
  KEY `fk_t_viaje_t_clasificasion1` (`idClasificasion`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin AUTO_INCREMENT=1 ;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `t_agencia`
--
ALTER TABLE `t_agencia`
  ADD CONSTRAINT `fk_t_agencia_t_proveedor1` FOREIGN KEY (`idProveedor`) REFERENCES `t_proveedor` (`idProveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `t_boleto`
--
ALTER TABLE `t_boleto`
  ADD CONSTRAINT `fk_t_boleto_t_pasajero1` FOREIGN KEY (`idPasajero`) REFERENCES `t_pasajero` (`idPasajero`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_t_boleto_t_reserva1` FOREIGN KEY (`idReserva`) REFERENCES `t_reserva` (`idReserva`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_t_boleto_t_viaje1` FOREIGN KEY (`idViaje`) REFERENCES `t_viaje` (`idViaje`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `t_ciudad`
--
ALTER TABLE `t_ciudad`
  ADD CONSTRAINT `fk_t_ciudad_t_provincia1` FOREIGN KEY (`idProvincia`) REFERENCES `t_provincia` (`idProvincia`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `t_equipaje`
--
ALTER TABLE `t_equipaje`
  ADD CONSTRAINT `fk_t_equipaje_t_pasajero1` FOREIGN KEY (`idPasajero`) REFERENCES `t_pasajero` (`idPasajero`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `t_provincia`
--
ALTER TABLE `t_provincia`
  ADD CONSTRAINT `fk_t_provincia_t_departamento1` FOREIGN KEY (`idDepartamento`) REFERENCES `t_departamento` (`idDepartamento`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `t_reserva`
--
ALTER TABLE `t_reserva`
  ADD CONSTRAINT `fk_t_reserva_t_usuario` FOREIGN KEY (`idUsuario1`) REFERENCES `t_usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `t_ruta`
--
ALTER TABLE `t_ruta`
  ADD CONSTRAINT `fk_t_ruta_t_ciudad1` FOREIGN KEY (`idCiudad`) REFERENCES `t_ciudad` (`idCiudad`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_t_ruta_t_proveedor1` FOREIGN KEY (`idProveedor`) REFERENCES `t_proveedor` (`idProveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `t_usuario`
--
ALTER TABLE `t_usuario`
  ADD CONSTRAINT `fk_t_usuario_t_tipousuario1` FOREIGN KEY (`idPerfil`) REFERENCES `t_perfil` (`idTipoUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `t_vehiculo`
--
ALTER TABLE `t_vehiculo`
  ADD CONSTRAINT `fk_t_vehiculo_t_proveedor1` FOREIGN KEY (`idProveedor`) REFERENCES `t_proveedor` (`idProveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `t_viaje`
--
ALTER TABLE `t_viaje`
  ADD CONSTRAINT `fk_t_viaje_t_clasificasion1` FOREIGN KEY (`idClasificasion`) REFERENCES `t_clasificasion` (`idClasificasion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_t_viaje_t_chofer1` FOREIGN KEY (`idChofer`) REFERENCES `t_chofer` (`idChofer`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_t_viaje_t_ruta1` FOREIGN KEY (`idRuta`) REFERENCES `t_ruta` (`idRuta`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_t_viaje_t_vehiculo1` FOREIGN KEY (`idVehiculo`) REFERENCES `t_vehiculo` (`idVehiculo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;



