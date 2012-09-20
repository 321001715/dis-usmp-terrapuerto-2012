-- phpMyAdmin SQL Dump
-- version 3.5.2
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 20-09-2012 a las 09:54:10
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
  `numDoc` int(8) NOT NULL,
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
  `numDoc` int(11) NOT NULL,
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
-- Estructura de tabla para la tabla `t_persona`
--

CREATE TABLE IF NOT EXISTS `t_persona` (
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=98917039 ;

--
-- Volcado de datos para la tabla `t_persona`
--

INSERT INTO `t_persona` (`id_persona`, `nombres`, `apePat`, `apeMat`, `numDoc`, `tipDoc`, `direccion`, `sexo`, `tel`, `estado`) VALUES
(10236985, 'Rosa Mercedes', 'Narvaez', 'Espino', 10427459, 'dni', 'PROLONG. PACASMAYO MZ. B LT.12 P.J. SAN JOSE', 'F', '99666652465', 'Habilitado'),
(12345678, 'Patricia', 'Del Solar', 'Bisso', 15735617, 'dni', 'Calle Las Rosas 162 Urb. El Remanso', 'F', '98563214720', 'Habilitado'),
(12365487, 'Angela Johana', 'Mestanza', 'Cavero', 40592642, 'dni', 'JR. CAMILO CARRILLO 248 2PISO', 'F', '99142587598', 'Habilitado'),
(15069874, 'Teresa Leonor', 'Rivera', 'Yogui', 43443569, 'dni', 'Jr.Teniente Carlos Jimenez chavez 362', 'F', '93018876656', 'Habilitado'),
(15963214, 'Jose  Wilder', 'Perez', 'Alarcon', 42953520, 'dni', 'Calle Huiracocha 2257', 'M', '99111123685', 'Habilitado'),
(18528900, 'Giancarlo', 'Ames', 'Osorio', 21289301, 'dni', 'AV. EDGARDO REBAGLIATTI 424', 'M', '99272781252', 'Habilitado'),
(18796348, 'Yvette', 'Medina', 'Rojas', 10125036, 'dni', 'Jr.cuzco 679', 'F', '93335387728', 'Habilitado'),
(22355678, 'Armando Johnny', 'Barrientos', 'Rios', 40327403, 'dni', 'Av. Michael Faraday 111 Urb. Ind. Santa Rosa', 'M', '85214796396', 'Habilitado'),
(32145698, 'Carlos', 'Felix', 'Ramos', 10666784, 'dni', 'Av. República de Panamá 3518 Urb. Limatambo', 'M', '96321478974', 'Habilitado'),
(32147896, 'Jose Fredy', 'Jimenez', 'Ramirez', 80426346, 'dni', 'Mza. 06 Lote 06 A.H. Bello Horizonte', 'M', '99863547162', 'Habilitado'),
(36251478, 'Rogelio', 'Requejo', 'Ruiz', 8291373, 'dni', 'Av. Arenales 395 Dpto 210-lima', 'M', '98399564880', 'Habilitado'),
(36925814, 'Said', 'Garboza', 'Mori', 42413416, 'dni', 'Av. La Arboleda 485 - 489 Urb. Ind. Sta. Raqu', 'F', '99852145440', 'Habilitado'),
(36984756, 'Javier', 'Quintana', 'Juarez', 42789551, 'dni', 'Jr.Yurua 265', 'M', '91436321296', 'Habilitado'),
(36985203, 'Jhon Alxis', 'Paez', 'Cordero', 41246352, 'dni', 'JR. ULISES DEL BOY 854 TDA. 1 URB. ORBEA', 'M', '99784596374', 'Habilitado'),
(36985214, 'Franco Nory', 'Costilla', 'Herrera', 40934610, 'dni', 'AV. ABANCAY 594 LIMA', 'M', '32145879622', 'Habilitado'),
(36987412, 'Jose', 'Juarez', 'Quispe', 10516084, 'dni', 'Calle Los Orfebres 368 int. 2 La Victoria', 'M', '99656525863', 'Habilitado'),
(50267489, 'Roxana Milagros', 'Ramirez', 'Morales', 42884922, 'dni', 'Jr.miroquesada 770', 'F', '90170277008', 'Deshabilitado'),
(56014789, 'Segundo', 'Quispe', 'Tarrillo', 40277989, 'dni', 'CALLE BOLIVAR 431 PISO 4', 'M', '91119810224', 'Habilitado'),
(56478932, 'David Joel', 'Pineda', 'Preciado', 16754269, 'dni', 'Bilbao #265', 'M', '91752832368', 'Habilitado'),
(57643337, 'Guisella Yolanda', 'Sanchez', 'Sanchez', 41076902, 'dni', 'Parcela 10 Mz  WW2.Lt. 8 Urb.PRO LOS- OLIVOS', 'F', '98083053808', 'Habilitado'),
(58746314, 'Julio Cesar', 'Ñahui', 'Silva', 41675210, 'dni', 'Av. Aviacion Cdra2 Mercado mayorista', 'M', '92385854512', 'Habilitado'),
(58746931, 'Andres', 'Quispe', 'Pastor', 10497813, 'dni', 'AV. SEPRADORA INDUSTRIAL MZ H LT 28 V.E.S', 'M', '98716075952', 'Habilitado'),
(58746932, 'Patricia Alejandrina', 'Loya', 'Palomino', 42121389, 'dni', 'AV. ARENALES 1890 LINCE', 'F', '93651898800', 'Habilitado'),
(61082812, 'Carlos Orlando', 'Trinidad', 'Condor', 41007549, 'dni', 'AV EDGARDO REBAGLIATI 447', 'M', '97766542736', 'Habilitado'),
(64522287, 'Guido', 'Vasquez', 'Moscoso', 25327128, 'dni', 'Mza.A7Lote8Asoc.viviendaD.Carrion', 'M', '97450031664', 'Deshabilitado'),
(67961762, 'Alexander Jesus', 'Veliz', 'Loayza', 40111893, 'dni', 'Las Violetas #622', 'M', '97133520592', 'Deshabilitado'),
(71401237, 'Rafael Teodolfo', 'Sunquillpa', 'Sunquillpa', 9563504, 'dni', 'JR. CIZCO 471 LIMA', 'M', '96817009520', 'Deshabilitado'),
(74125896, 'Mitzi Yassmine', 'Saavedra', 'Facho', 42359377, 'dni', 'JR. AZANGARO 970 TDA. 142', 'F', '99236587460', 'Habilitado'),
(74185236, 'Angelo Giancarlo', 'Chumbes', 'Villalobos', 41389208, 'pas', 'Fundo El Cerro 200 Cas. Yanquiza', 'M', '78965412398', 'Habilitado'),
(74521896, 'Milagros', 'Mosselli', 'Lopez', 42859678, 'dni', 'Sec-3 Gr. 20 Mz D Lt.6', 'F', '92702365584', 'Deshabilitado'),
(74840712, 'Robert Edwin', 'Aliaga', 'Garcia', 40045898, 'dni', 'JR. ALICANTE Nª277', 'M', '96500498448', 'Deshabilitado'),
(75321478, 'Jesus', 'Huilca', 'Rafaele', 10517677, 'dni', 'Av. Separadora Industrial 211 Urb. Ind. Vulca', 'M', '99148726361', 'Habilitado'),
(78280187, 'Ricardina Apolonia', 'Alvaron', 'Nolasco', 6886405, 'dni', 'Calle Amazona mza.94 A Lote31 AAHH Huascar', 'F', '96183987376', 'Habilitado'),
(81719662, 'Jessica Julissa', 'Cortavarria', 'Aylas', 40887226, 'dni', 'Las begonias Ate', 'F', '95867476304', 'Habilitado'),
(85159137, 'Hugo Wilder', 'Cotrina', 'Huaccho', 41007577, 'dni', 'AV.LOS INCAS 212 NAZCA', 'M', '95550965232', 'Habilitado'),
(85216974, 'Eduardo', 'Ponciano', 'Romero', 41928226, 'dni', 'JR. LINO CORNEJO 220 INT. 110', 'M', '99151574230', 'Habilitado'),
(85236974, 'Dina Carol', 'Llican', 'Pardo', 80238995, 'dni', 'AV. TACNA 205', 'F', '99454574165', 'Habilitado'),
(85236987, 'Alonso', 'Lopez', 'Zamora', 42476561, 'dni', 'JR. NARCISO DE LA COLONIA 738 - SURQUILLO', 'M', '93968409872', 'Habilitado'),
(88598612, 'Hector', 'Davila', 'Fernandez', 41982643, 'dni', 'ARGENTINA n°456', 'M', '95234454160', 'Habilitado'),
(90147854, 'Benigno', 'Quispe', 'Sulca', 71618634, 'dni', 'Av.Paz Soldan #225 Int. A4', 'M', '90803299152', 'Habilitado'),
(90148756, 'Norma', 'Rafaele', 'Ucharico', 40947563, 'dni', 'Calle Berlin #779 Urb Berlin', 'F', '90486788080', 'Habilitado'),
(92038088, 'Raul Eduardo', 'Espinoza', 'Lecca', 41352511, 'dni', 'Av.El Cano 3518/38', 'M', '94917943088', 'Habilitado'),
(95123647, 'Carmen', 'Cordova', 'Chambillo', 42800025, 'dni', 'Av. Santa Ana Mz. "A" 31 Lt. 33 Santa Anita', 'F', '25896314745', 'Habilitado'),
(95147823, 'Miguel Angel', 'Orrillo', 'Chuez', 40638268, 'dni', 'Av.Nicolas Arriola Cdra.24', 'M', '92069343440', 'Habilitado'),
(95477563, 'Jacinto', 'Espinoza', 'Tacuche', 22750645, 'dni', 'Avellaneda 1779 B alta cordova', 'M', '94601432016', 'Habilitado'),
(96985219, 'Carlos Antonio', 'Marquez', 'Aricari', 80612927, 'dni', 'AV. MEXICO 1998 - B', 'M', '99232387440', 'Habilitado'),
(98653214, 'Artemio', 'Raymundo', 'Robles', 40212292, 'dni', 'Jr.Ucayali  510 INT.131', 'M', '89853765936', 'Habilitado'),
(98745632, 'Liubov Irina', 'Gozar', 'Granados', 10287168, 'dni', 'JUAN VELASCO ALVARADO 147 BARRIO PUQUIO CANO', 'F', '99652314750', 'Habilitado'),
(98917038, 'Flor Maria', 'Lopez', 'Castillo', 3377446, 'dni', 'MCDO MAYORISTA DE FRUTAS', 'F', '94284920944', 'Habilitado');

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
  `ruc` int(11) NOT NULL,
  `razSocial` varchar(45) COLLATE armscii8_bin NOT NULL,
  `razCom` varchar(45) COLLATE armscii8_bin NOT NULL,
  `direccion` varchar(45) COLLATE armscii8_bin NOT NULL,
  `tel` int(11) NOT NULL,
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
  `numDoc` int(11) NOT NULL,
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






