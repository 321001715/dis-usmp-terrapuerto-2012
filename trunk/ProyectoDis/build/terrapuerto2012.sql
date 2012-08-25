SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `terra` ;
CREATE SCHEMA IF NOT EXISTS `terra` DEFAULT CHARACTER SET latin1 ;
USE `terra` ;

-- -----------------------------------------------------
-- Table `terra`.`t_servicio`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `terra`.`t_servicio` (
  `id_serv` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `nom_serv` VARCHAR(25) NULL DEFAULT NULL ,
  `descripcion_serv` VARCHAR(100) NULL DEFAULT NULL ,
  `vigencia_serv` VARCHAR(15) NOT NULL ,
  `usureg_serv` INT NULL ,
  `fechreg_serv` DATETIME NULL ,
  `usumod_serv` INT NULL ,
  `fechmod_serv` DATETIME NULL ,
  PRIMARY KEY (`id_serv`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `terra`.`t_usuario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `terra`.`t_usuario` (
  `id_usu` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `username_usu` VARCHAR(45) NULL ,
  `password_usu` VARCHAR(45) NULL ,
  `nrodoc_usu` VARCHAR(15) NULL ,
  `nombre_usu` VARCHAR(45) NULL ,
  `apepat_usu` VARCHAR(45) NULL ,
  `apemat_usu` VARCHAR(45) NULL ,
  `dir_usu` VARCHAR(45) NULL ,
  `dist_vend` VARCHAR(45) NULL ,
  `tele_vend` VARCHAR(45) NULL ,
  `vigencia_usu` VARCHAR(15) NOT NULL ,
  `usureg_usu` INT NULL ,
  `fechreg_usu` DATETIME NULL ,
  `usumod_usu` INT NULL ,
  `fechamod_usu` DATETIME NULL ,
  PRIMARY KEY (`id_usu`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `terra`.`t_cliente`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `terra`.`t_cliente` (
  `id_usu` INT UNSIGNED NOT NULL ,
  `tipo_clie` VARCHAR(45) NOT NULL COMMENT 'natural\njuridica' ,
  `ruc_empresa_clie` VARCHAR(20) NULL ,
  `razon_social_clie` VARCHAR(50) NULL ,
  `ciudad_clie` VARCHAR(50) NULL ,
  `pregsecret_clie` VARCHAR(60) NULL ,
  `rsptasecret_clie` VARCHAR(60) NULL ,
  PRIMARY KEY (`id_usu`) ,
  CONSTRAINT `fk_t_cliente_t_usuario1`
    FOREIGN KEY (`id_usu` )
    REFERENCES `terra`.`t_usuario` (`id_usu` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `terra`.`t_empresa_transporte`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `terra`.`t_empresa_transporte` (
  `id_emptrans` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `ruc_emptrans` VARCHAR(20) NULL DEFAULT NULL ,
  `razsocial_emptrans` VARCHAR(50) NULL DEFAULT NULL ,
  `calificacion_emptrans` VARCHAR(30) NULL DEFAULT NULL ,
  `dir_emptrans` VARCHAR(80) NULL ,
  `telef_emptrans` VARCHAR(15) NULL ,
  `vigencia_emptrans` VARCHAR(15) NOT NULL ,
  `usureg_emptrans` INT NULL ,
  `fechreg_emptrans` DATETIME NULL ,
  `usumod_emptrans` INT NULL ,
  `fechmod_emptrans` DATETIME NULL ,
  PRIMARY KEY (`id_emptrans`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `terra`.`t_local`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `terra`.`t_local` (
  `id_local` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `nom_local` VARCHAR(45) NULL DEFAULT NULL ,
  `dir_local` VARCHAR(45) NULL DEFAULT NULL ,
  `telef_local` VARCHAR(45) NULL DEFAULT NULL ,
  `dist_local` VARCHAR(45) NULL DEFAULT NULL ,
  `ciudad_local` VARCHAR(45) NULL ,
  `prov_local` VARCHAR(45) NULL DEFAULT NULL ,
  `responsable_local` VARCHAR(80) NOT NULL ,
  `id_emptrans` INT UNSIGNED NOT NULL ,
  `vigencia_local` VARCHAR(15) NOT NULL ,
  `usureg_local` INT NULL ,
  `fechreg_local` DATETIME NULL ,
  `usumod_local` INT NULL ,
  `fechmod_local` DATETIME NULL ,
  PRIMARY KEY (`id_local`) ,
  INDEX `fk_t_local_t_empresa_transporte1` (`id_emptrans` ASC) ,
  CONSTRAINT `fk_t_local_t_empresa_transporte1`
    FOREIGN KEY (`id_emptrans` )
    REFERENCES `terra`.`t_empresa_transporte` (`id_emptrans` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `terra`.`t_ruta`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `terra`.`t_ruta` (
  `id_ruta` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `nombre_ruta` VARCHAR(45) NULL DEFAULT NULL ,
  `ciudad_origen_ruta` VARCHAR(45) NULL ,
  `ciudad_destino1_ruta` VARCHAR(45) NULL ,
  `ciudad_destino2_ruta` VARCHAR(45) NULL ,
  `hora_salida_ruta` TIME NULL ,
  `hora_llegada_ruta` TIME NULL ,
  `duracion_aprox_ruta` VARCHAR(45) NULL ,
  `tarifa_ruta` DOUBLE NULL ,
  `id_local` INT UNSIGNED NOT NULL ,
  `id_serv` INT UNSIGNED NOT NULL ,
  `vigencia_ruta` VARCHAR(15) NOT NULL ,
  `usureg_ruta` INT NULL ,
  `fechreg_ruta` DATETIME NULL ,
  `usumod_ruta` INT NULL ,
  `fechmod_ruta` DATETIME NULL ,
  PRIMARY KEY (`id_ruta`) ,
  INDEX `fk_t_ruta_t_local1` (`id_local` ASC) ,
  INDEX `fk_t_ruta_t_servicio1` (`id_serv` ASC) ,
  CONSTRAINT `fk_t_ruta_t_local1`
    FOREIGN KEY (`id_local` )
    REFERENCES `terra`.`t_local` (`id_local` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_ruta_t_servicio1`
    FOREIGN KEY (`id_serv` )
    REFERENCES `terra`.`t_servicio` (`id_serv` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `terra`.`t_viaje`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `terra`.`t_viaje` (
  `id_viaje` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `tipo_viaje` VARCHAR(15) NULL COMMENT 'comercial\nencomienda' ,
  `fecha_salida_viaje` DATE NULL DEFAULT NULL ,
  `hora_salida_viaje` TIME NULL DEFAULT NULL ,
  `obs_viaje` VARCHAR(100) NULL DEFAULT NULL ,
  `estado_viaje` VARCHAR(25) NOT NULL COMMENT 'disponible\ntrancurso\n\ncancelado' ,
  `id_ruta` INT UNSIGNED NOT NULL ,
  `vigencia_viaje` VARCHAR(15) NOT NULL ,
  `usureg_viaje` INT NULL ,
  `fechreg_viaje` DATETIME NULL ,
  `usumod_viaje` INT NULL ,
  `fechmod_viaje` DATETIME NULL ,
  PRIMARY KEY (`id_viaje`) ,
  INDEX `fk_t_viaje_t_ruta1` (`id_ruta` ASC) ,
  CONSTRAINT `fk_t_viaje_t_ruta1`
    FOREIGN KEY (`id_ruta` )
    REFERENCES `terra`.`t_ruta` (`id_ruta` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `terra`.`t_vehiculo`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `terra`.`t_vehiculo` (
  `id_vehic` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `placa_vehic` VARCHAR(8) NULL DEFAULT NULL ,
  `marca_vehic` VARCHAR(30) NULL DEFAULT NULL ,
  `modelo_vehic` VARCHAR(30) NULL DEFAULT NULL ,
  `fecha_ingrego_vehic` DATE NULL DEFAULT NULL ,
  `descripcion_vehic` VARCHAR(30) NULL DEFAULT NULL ,
  `tipo_servicio_vehic` VARCHAR(15) NULL ,
  `nro_pisos_vehic` INT NULL ,
  `cant_asiento_vehic` INT NULL ,
  `id_emptrans` INT UNSIGNED NOT NULL ,
  `vigencia_vehic` VARCHAR(15) NOT NULL ,
  `usureg_vehic` INT NULL ,
  `fechreg_vehic` DATETIME NULL ,
  `usumod_vehic` INT NULL ,
  `fechmod_vehic` DATETIME NULL ,
  PRIMARY KEY (`id_vehic`) ,
  INDEX `fk_t_vehiculo_t_empresa_transporte1` (`id_emptrans` ASC) ,
  CONSTRAINT `fk_t_vehiculo_t_empresa_transporte1`
    FOREIGN KEY (`id_emptrans` )
    REFERENCES `terra`.`t_empresa_transporte` (`id_emptrans` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `terra`.`t_asiento`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `terra`.`t_asiento` (
  `id_asiento` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `id_vehic` INT UNSIGNED NOT NULL ,
  `num_asiento` INT NULL ,
  `piso_asiento` INT NULL ,
  `vigencia_asiento` VARCHAR(15) NOT NULL ,
  `usureg_asiento` INT NULL ,
  `fechreg_asiento` DATETIME NULL ,
  `usumod_asiento` INT NULL ,
  `fechmod_asiento` DATETIME NULL ,
  PRIMARY KEY (`id_asiento`, `id_vehic`) ,
  INDEX `fk_t_asiento_t_vehiculo1` (`id_vehic` ASC) ,
  CONSTRAINT `fk_t_asiento_t_vehiculo1`
    FOREIGN KEY (`id_vehic` )
    REFERENCES `terra`.`t_vehiculo` (`id_vehic` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `terra`.`t_documento_venta`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `terra`.`t_documento_venta` (
  `id_docventa` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `nro_serie_docventa` VARCHAR(5) NOT NULL ,
  `nro_doc_doventa` VARCHAR(10) NOT NULL ,
  `tipo_docventa` VARCHAR(45) NULL COMMENT 'boleta\nfactura' ,
  `fecha_docventa` DATETIME NULL ,
  `monto_total_docventa` DOUBLE NULL ,
  `tipo_pago_docventa` VARCHAR(45) NULL ,
  `estado_docventa` VARCHAR(15) NOT NULL COMMENT 'aprobada\nanulada' ,
  `generado_docventa` VARCHAR(45) NOT NULL COMMENT 'cliente\nusuario' ,
  `id_usu` INT UNSIGNED NOT NULL ,
  `vigencia_docventa` VARCHAR(15) NOT NULL ,
  `usureg_docventa` INT NULL ,
  `fechreg_docventa` DATETIME NULL ,
  `usumod_docventa` INT NULL ,
  `fechmod_docventa` DATETIME NULL ,
  PRIMARY KEY (`id_docventa`) ,
  INDEX `fk_t_documento_venta_t_usuario1` (`id_usu` ASC) ,
  CONSTRAINT `fk_t_documento_venta_t_usuario1`
    FOREIGN KEY (`id_usu` )
    REFERENCES `terra`.`t_usuario` (`id_usu` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `terra`.`t_pasajero`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `terra`.`t_pasajero` (
  `id_pasaj` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `codbarra_pasaj` VARCHAR(16) NOT NULL ,
  `nrodoc_pasaj` VARCHAR(15) NULL ,
  `nombre_pasaj` VARCHAR(45) NULL ,
  `apepat_pasaj` VARCHAR(45) NULL ,
  `apemat_pasaj` VARCHAR(45) NULL ,
  `dir_pasaj` VARCHAR(45) NULL ,
  `dist_pasaj` VARCHAR(45) NULL ,
  `tele_pasaj` VARCHAR(45) NULL ,
  `estado_pasaj` VARCHAR(15) NOT NULL ,
  `vigencia_pasaj` VARCHAR(15) NOT NULL ,
  `usureg_pasaj` INT NULL ,
  `fechreg_pasaj` DATETIME NULL ,
  `usumod_pasaj` INT NULL ,
  `fechamod_pasaj` DATETIME NULL ,
  PRIMARY KEY (`id_pasaj`) )
ENGINE = InnoDB
COMMENT = 'Esta tabla contine el  boleto o ticket  que se genera para e' /* comment truncated */ ;


-- -----------------------------------------------------
-- Table `terra`.`t_viaje_asiento`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `terra`.`t_viaje_asiento` (
  `id_viaje` INT UNSIGNED NOT NULL ,
  `id_asiento` INT UNSIGNED NOT NULL ,
  `id_vehic` INT UNSIGNED NOT NULL ,
  `estado_asiento` VARCHAR(15) NOT NULL ,
  `id_usu` INT UNSIGNED NOT NULL ,
  PRIMARY KEY (`id_viaje`, `id_asiento`, `id_vehic`) ,
  INDEX `fk_t_viaje_has_t_asiento_t_asiento1` (`id_asiento` ASC, `id_vehic` ASC) ,
  INDEX `fk_t_viaje_has_t_asiento_t_viaje1` (`id_viaje` ASC) ,
  INDEX `fk_t_viaje_asiento_t_pasajero1` (`id_usu` ASC) ,
  CONSTRAINT `fk_t_viaje_has_t_asiento_t_viaje1`
    FOREIGN KEY (`id_viaje` )
    REFERENCES `terra`.`t_viaje` (`id_viaje` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_viaje_has_t_asiento_t_asiento1`
    FOREIGN KEY (`id_asiento` , `id_vehic` )
    REFERENCES `terra`.`t_asiento` (`id_asiento` , `id_vehic` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_viaje_asiento_t_pasajero1`
    FOREIGN KEY (`id_usu` )
    REFERENCES `terra`.`t_pasajero` (`id_pasaj` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `terra`.`t_reserva`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `terra`.`t_reserva` (
  `id_reserva` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `obs_reserva` VARCHAR(45) NULL ,
  `fecha_reserva` DATETIME NULL ,
  `estado_reserva` VARCHAR(45) NOT NULL COMMENT 'pendiente\natendida\nvencida' ,
  `id_viaje` INT UNSIGNED NOT NULL ,
  `id_asiento` INT UNSIGNED NOT NULL ,
  `id_vehic` INT UNSIGNED NOT NULL ,
  `id_usu` INT UNSIGNED NOT NULL ,
  `vigencia_reserva` VARCHAR(15) NOT NULL ,
  `usureg_reserva` INT NULL ,
  `fechreg_reserva` DATETIME NULL ,
  `usumod_reserva` INT NULL ,
  `fechmod_reserva` DATETIME NULL ,
  PRIMARY KEY (`id_reserva`) ,
  INDEX `fk_t_reserva_t_viaje_asiento1` (`id_viaje` ASC, `id_asiento` ASC, `id_vehic` ASC) ,
  INDEX `fk_t_reserva_t_usuario1` (`id_usu` ASC) ,
  CONSTRAINT `fk_t_reserva_t_viaje_asiento1`
    FOREIGN KEY (`id_viaje` , `id_asiento` , `id_vehic` )
    REFERENCES `terra`.`t_viaje_asiento` (`id_viaje` , `id_asiento` , `id_vehic` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_reserva_t_usuario1`
    FOREIGN KEY (`id_usu` )
    REFERENCES `terra`.`t_usuario` (`id_usu` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `terra`.`t_detalle_documento_venta`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `terra`.`t_detalle_documento_venta` (
  `id_docventa` INT UNSIGNED NOT NULL ,
  `id_reserva` INT UNSIGNED NOT NULL ,
  `id_item` INT UNSIGNED NOT NULL ,
  `cantidad_det` DOUBLE NULL ,
  `precio_det` DOUBLE NULL ,
  `importe_det` DOUBLE NULL ,
  `igv_det` DOUBLE NULL ,
  PRIMARY KEY (`id_docventa`, `id_reserva`, `id_item`) ,
  INDEX `fk_t_documento_venta_has_t_reserva_t_reserva1` (`id_reserva` ASC) ,
  INDEX `fk_t_documento_venta_has_t_reserva_t_documento_venta1` (`id_docventa` ASC) ,
  CONSTRAINT `fk_t_documento_venta_has_t_reserva_t_documento_venta1`
    FOREIGN KEY (`id_docventa` )
    REFERENCES `terra`.`t_documento_venta` (`id_docventa` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_documento_venta_has_t_reserva_t_reserva1`
    FOREIGN KEY (`id_reserva` )
    REFERENCES `terra`.`t_reserva` (`id_reserva` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `terra`.`t_trabajador`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `terra`.`t_trabajador` (
  `id_usu` INT UNSIGNED NOT NULL ,
  `tipo_trab` VARCHAR(15) NOT NULL COMMENT 'encomienda\nadministrador\nrecepcionista' ,
  `id_emptrans` INT UNSIGNED NOT NULL ,
  PRIMARY KEY (`id_usu`) ,
  INDEX `fk_t_trabajador_t_empresa_transporte1` (`id_emptrans` ASC) ,
  CONSTRAINT `fk_t_trabajador_t_usuario1`
    FOREIGN KEY (`id_usu` )
    REFERENCES `terra`.`t_usuario` (`id_usu` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_trabajador_t_empresa_transporte1`
    FOREIGN KEY (`id_emptrans` )
    REFERENCES `terra`.`t_empresa_transporte` (`id_emptrans` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
