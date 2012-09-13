-- phpMyAdmin SQL Dump
-- version 3.5.2
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 13-09-2012 a las 04:47:52
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
  `idAgencia` int(10) NOT NULL AUTO_INCREMENT,
  `ciudad` int(11) NOT NULL,
  `direccion` varchar(45) COLLATE armscii8_bin NOT NULL,
  `idProveedor` int(4) NOT NULL,
  PRIMARY KEY (`idAgencia`),
  KEY `fk_t_agencia_t_proveedor1_idx` (`idProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_boleto`
--

CREATE TABLE IF NOT EXISTS `t_boleto` (
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
  KEY `fk_t_boleto_t_reserva1_idx` (`idReserva`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_chofer`
--

CREATE TABLE IF NOT EXISTS `t_chofer` (
  `idChofer` int(6) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(45) COLLATE armscii8_bin NOT NULL,
  `apePat` varchar(45) COLLATE armscii8_bin NOT NULL,
  `apeMat` varchar(45) COLLATE armscii8_bin NOT NULL,
  `numDoc` varchar(15) COLLATE armscii8_bin NOT NULL,
  `tipDoc` varchar(20) COLLATE armscii8_bin NOT NULL,
  `numLicencia` int(11) NOT NULL,
  `idProveedor` int(11) NOT NULL,
  PRIMARY KEY (`idChofer`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_ciudad`
--

CREATE TABLE IF NOT EXISTS `t_ciudad` (
  `idCiudad` int(5) NOT NULL AUTO_INCREMENT,
  `nombre` text COLLATE armscii8_bin NOT NULL,
  `idProvincia` int(4) NOT NULL,
  PRIMARY KEY (`idCiudad`),
  KEY `fk_t_ciudad_t_provincia1_idx` (`idProvincia`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_clasificasion`
--

CREATE TABLE IF NOT EXISTS `t_clasificasion` (
  `idClasificasion` int(5) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE armscii8_bin NOT NULL,
  `descripcion` varchar(30) COLLATE armscii8_bin NOT NULL,
  `usuarioInsert` int(6) DEFAULT NULL,
  `fechaInsert` datetime DEFAULT NULL,
  `usuarioUpdate` int(6) DEFAULT NULL,
  `fechaUpdate` datetime DEFAULT NULL,
  PRIMARY KEY (`idClasificasion`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_departamento`
--

CREATE TABLE IF NOT EXISTS `t_departamento` (
  `idDepartamento` int(2) NOT NULL AUTO_INCREMENT,
  `nombre` text COLLATE armscii8_bin NOT NULL,
  PRIMARY KEY (`idDepartamento`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_equipaje`
--

CREATE TABLE IF NOT EXISTS `t_equipaje` (
  `idEquipaje` int(7) NOT NULL AUTO_INCREMENT,
  `idPasajero` int(7) NOT NULL,
  `peso` varchar(45) COLLATE armscii8_bin DEFAULT NULL,
  PRIMARY KEY (`idEquipaje`),
  KEY `fk_t_equipaje_t_pasajero1_idx` (`idPasajero`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_pasajero`
--

CREATE TABLE IF NOT EXISTS `t_pasajero` (
  `idPasajero` int(7) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(45) COLLATE armscii8_bin NOT NULL,
  `apePat` varchar(45) COLLATE armscii8_bin NOT NULL,
  `apeMat` varchar(45) COLLATE armscii8_bin NOT NULL,
  `numDoc` varchar(15) COLLATE armscii8_bin NOT NULL,
  `tipDoc` varchar(20) COLLATE armscii8_bin NOT NULL,
  `estado` varchar(15) COLLATE armscii8_bin DEFAULT NULL,
  PRIMARY KEY (`idPasajero`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_perfil`
--

CREATE TABLE IF NOT EXISTS `t_perfil` (
  `idPerfil` int(6) NOT NULL AUTO_INCREMENT,
  `perfil` text COLLATE armscii8_bin NOT NULL,
  `descripcion` varchar(45) COLLATE armscii8_bin DEFAULT NULL,
  `usuarioInsert` int(6) DEFAULT NULL,
  `fechaInsert` datetime DEFAULT NULL,
  `usuarioUpdate` int(6) DEFAULT NULL,
  `fechaUpdate` datetime DEFAULT NULL,
  PRIMARY KEY (`idPerfil`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_permiso`
--

CREATE TABLE IF NOT EXISTS `t_permiso` (
  `idUsuario` int(6) NOT NULL,
  `idPro` int(5) NOT NULL,
  `conProPer` char(1) COLLATE armscii8_bin DEFAULT NULL,
  PRIMARY KEY (`idUsuario`,`idPro`),
  KEY `fk_t_usuario_has_t_programa_t_programa1` (`idPro`),
  KEY `fk_t_usuario_has_t_programa_t_usuario1` (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_persona`
--

CREATE TABLE IF NOT EXISTS `t_persona` (
  `id_persona` int(8) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(45) NOT NULL,
  `apePat` varchar(45) NOT NULL,
  `apeMat` varchar(45) NOT NULL,
  `numDoc` varchar(15) NOT NULL,
  `tipDoc` varchar(20) DEFAULT NULL,
  `direccion` varchar(45) NOT NULL,
  `sexo` varchar(1) NOT NULL,
  `tel` varchar(11) NOT NULL,
  `estado` varchar(15) NOT NULL,
  PRIMARY KEY (`id_persona`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2147483647 ;

--
-- Volcado de datos para la tabla `t_persona`
--

INSERT INTO `t_persona` (`id_persona`, `nombres`, `apePat`, `apeMat`, `numDoc`, `tipDoc`, `direccion`, `sexo`, `tel`, `estado`) VALUES
(185288, 'Giancarlo', 'Ames', 'Osorio', '', NULL, 'AV. EDGARDO REBAGLIATTI 424', 'M', '2147483647', 'A'),
(185289, 'Giancarlo', 'Ames', 'Osorio', '', NULL, 'AV. EDGARDO REBAGLIATTI 424', 'M', '99272781252', 'A'),
(2147483647, 'Giancarlo', 'Ames', 'Osorio', '', NULL, 'AV. EDGARDO REBAGLIATTI 424', 'M', '2147483647', 'A');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_programa`
--

CREATE TABLE IF NOT EXISTS `t_programa` (
  `idPro` int(5) NOT NULL,
  `desPro` varchar(70) COLLATE armscii8_bin NOT NULL,
  `titPro` varchar(50) COLLATE armscii8_bin NOT NULL,
  `codMod` char(3) COLLATE armscii8_bin NOT NULL,
  `codProSup` char(5) COLLATE armscii8_bin DEFAULT NULL,
  `urlPro` varchar(100) COLLATE armscii8_bin DEFAULT NULL,
  `estPro` char(1) COLLATE armscii8_bin NOT NULL,
  PRIMARY KEY (`idPro`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_proveedor`
--

CREATE TABLE IF NOT EXISTS `t_proveedor` (
  `idProveedor` int(4) NOT NULL AUTO_INCREMENT,
  `codEmpre` int(11) NOT NULL,
  `ruc` varchar(11) COLLATE armscii8_bin NOT NULL,
  `razSocial` varchar(45) COLLATE armscii8_bin NOT NULL,
  `razCom` varchar(45) COLLATE armscii8_bin NOT NULL,
  `direccion` varchar(45) COLLATE armscii8_bin NOT NULL,
  `tel` int(11) NOT NULL,
  `usuario` varchar(45) COLLATE armscii8_bin NOT NULL,
  `clave` varchar(45) COLLATE armscii8_bin NOT NULL,
  `estado` varchar(15) COLLATE armscii8_bin NOT NULL,
  PRIMARY KEY (`idProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_provincia`
--

CREATE TABLE IF NOT EXISTS `t_provincia` (
  `idProvincia` int(4) NOT NULL AUTO_INCREMENT,
  `nombre` text COLLATE armscii8_bin NOT NULL,
  `idDepartamento` int(2) NOT NULL,
  PRIMARY KEY (`idProvincia`),
  KEY `fk_t_provincia_t_departamento1_idx` (`idDepartamento`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_reserva`
--

CREATE TABLE IF NOT EXISTS `t_reserva` (
  `idReserva` int(7) NOT NULL AUTO_INCREMENT,
  `idUsuario1` int(6) NOT NULL,
  `fecha` date NOT NULL,
  `estado` varchar(15) COLLATE armscii8_bin NOT NULL,
  `userInsert` int(6) DEFAULT NULL,
  `fechaInsert` datetime DEFAULT NULL,
  `userUpdate` int(6) DEFAULT NULL,
  `fechaUpdate` datetime DEFAULT NULL,
  PRIMARY KEY (`idReserva`),
  KEY `fk_t_reserva_t_usuario_idx` (`idUsuario1`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_ruta`
--

CREATE TABLE IF NOT EXISTS `t_ruta` (
  `idRuta` int(8) NOT NULL AUTO_INCREMENT,
  `codRuta` varchar(45) COLLATE armscii8_bin NOT NULL,
  `nomRuta` varchar(45) COLLATE armscii8_bin NOT NULL,
  `origen` int(11) NOT NULL,
  `destino` int(11) NOT NULL,
  `km` int(11) NOT NULL,
  `duracion` int(11) NOT NULL,
  `estado` varchar(15) COLLATE armscii8_bin NOT NULL,
  `idProveedor` int(4) NOT NULL,
  `idCiudad` int(5) NOT NULL,
  `userInsert` int(6) DEFAULT NULL,
  `fechaInsert` datetime DEFAULT NULL,
  `userUpdate` int(6) DEFAULT NULL,
  `fechaUpdate` datetime DEFAULT NULL,
  PRIMARY KEY (`idRuta`),
  KEY `fk_t_ruta_t_proveedor1_idx` (`idProveedor`),
  KEY `fk_t_ruta_t_ciudad1_idx` (`idCiudad`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_usuario`
--

CREATE TABLE IF NOT EXISTS `t_usuario` (
  `idUsuario` int(6) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(10) COLLATE armscii8_bin NOT NULL,
  `clave` varchar(8) COLLATE armscii8_bin NOT NULL,
  `estado` varchar(45) COLLATE armscii8_bin NOT NULL,
  `tipDoc` varchar(20) COLLATE armscii8_bin NOT NULL,
  `numDoc` varchar(15) COLLATE armscii8_bin NOT NULL,
  `nombres` varchar(45) COLLATE armscii8_bin NOT NULL,
  `apePat` varchar(45) COLLATE armscii8_bin NOT NULL,
  `apeMat` varchar(45) COLLATE armscii8_bin NOT NULL,
  `idCiudad` int(11) NOT NULL,
  `direccion` varchar(45) COLLATE armscii8_bin NOT NULL,
  `sexo` varchar(45) COLLATE armscii8_bin NOT NULL,
  `tel` int(11) NOT NULL,
  `idPerfil` int(6) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  KEY `fk_t_usuario_t_tipousuario1_idx` (`idPerfil`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_vehiculo`
--

CREATE TABLE IF NOT EXISTS `t_vehiculo` (
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
  KEY `fk_t_vehiculo_t_proveedor1_idx` (`idProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_viaje`
--

CREATE TABLE IF NOT EXISTS `t_viaje` (
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
  `idClasificasion` int(5) NOT NULL,
  `userInsert` int(6) DEFAULT NULL,
  `FechaInsert` datetime DEFAULT NULL,
  `userUpdate` int(6) DEFAULT NULL,
  `fechaUpdate` datetime DEFAULT NULL,
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
-- Filtros para la tabla `t_permiso`
--
ALTER TABLE `t_permiso`
  ADD CONSTRAINT `fk_t_usuario_has_t_programa_t_usuario1` FOREIGN KEY (`idUsuario`) REFERENCES `t_usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_t_usuario_has_t_programa_t_programa1` FOREIGN KEY (`idPro`) REFERENCES `t_programa` (`idPro`) ON DELETE NO ACTION ON UPDATE NO ACTION;

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
  ADD CONSTRAINT `fk_t_usuario_t_tipousuario1` FOREIGN KEY (`idPerfil`) REFERENCES `t_perfil` (`idPerfil`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `t_vehiculo`
--
ALTER TABLE `t_vehiculo`
  ADD CONSTRAINT `fk_t_vehiculo_t_proveedor1` FOREIGN KEY (`idProveedor`) REFERENCES `t_proveedor` (`idProveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `t_viaje`
--
ALTER TABLE `t_viaje`
  ADD CONSTRAINT `fk_t_viaje_t_chofer1` FOREIGN KEY (`idChofer`) REFERENCES `t_chofer` (`idChofer`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_t_viaje_t_clasificasion1` FOREIGN KEY (`idClasificasion`) REFERENCES `t_clasificasion` (`idClasificasion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_t_viaje_t_ruta1` FOREIGN KEY (`idRuta`) REFERENCES `t_ruta` (`idRuta`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_t_viaje_t_vehiculo1` FOREIGN KEY (`idVehiculo`) REFERENCES `t_vehiculo` (`idVehiculo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;




