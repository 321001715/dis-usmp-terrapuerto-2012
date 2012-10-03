package pe.plazanorte.sisterra.util;

public class Constantes {
	
	/**
	 * Esta clase almacena todas las constantes que se pudieran usar en la programación para
	 * no confundirnos colocando diferentes cosas cada uno que pudieran ser las mismas, si 
	 * tiene alguna constante que agregar agregenla como las que estan abajo, con mayuscula y public static final
	 */
	
	/*
	 * INTERFACES DESTINO
	 */
	public static final int MENU_PRINCIPAL = 1;
	public static final int ELIMINAR_PROVEEDOR = 2;
	public static final int MANTENER_PROVEEDOR = 3;
	public static final int MODIFICAR_PROVEEDOR = 4;	
	public static final int GESTIONAR_VEHICULO = 5;
	
	
	public static final int MANTENER_CLASIFICACION = 6;
	public static final int MODIFICAR_CLASIFICACION = 6;
	public static final int ELIMINAR_CLASIFICACION = 7;	

	public static final int MODIFICAR_VEHICULO = 14;	

	public static final int ELIMINAR_PERFIL = 8;
	public static final int MANTENER_PERFIL = 9;
	public static final int MODIFICAR_PERFIL = 10;
	
	public static final int ELIMINAR_USUARIO = 11;
	public static final int MANTENER_USUARIO = 12;
	public static final int MODIFICAR_USUARIO = 13;

	public static final int GESTIONAR_RUTA = 100;	
	
	
	
	/*
	 * PERFILES
	 */
	public static final int PERFIL_ADMINISTRADOR = 0;
	public static final int PERFIL_USUARIO = 1;
	public static final int PERFIL_ANFITRIONA = 2;
	public static final int PERFIL_REPRESENTANTE_EMPRESA = 3;
	public static final int PERFIL_COUNTER = 4;
	
	/*
	 * ESTADOS USUARIO - PROVEEDOR
	 */	
	public static final String ESTADO_ACTIVO = "ACTIVO";
	public static final String ESTADO_INHABILITADO = "INHABILITADO";
	
	/*
	 * ACCIONES
	 */
	public static final String ACCION_REGISTRAR_PROVEEDOR = "registrar_proveedor";
	public static final String ACCION_MODIFICAR_PROVEEDOR = "modificar_proveedor";
	public static final String ACCION_FILTRO_PROVEEDOR = "filtro_proveedor";
	public static final String ACCION_LISTAR_PROVEEDOR = "listar_proveedor";
	public static final String ACCION_CONSULTAR_PROVEEDOR = "consultar_proveedor";
	
	public static final String ACCION_REGISTRAR_VEHICULO = "registrar_vehiculo";
	public static final String ACCION_MODIFICAR_VEHICULO = "modificar_vehiculo";
	public static final String ACCION_FILTRO_VEHICULO = "filtro_vehiculo";
	public static final String ACCION_LISTAR_VEHICULO = "listar_vehiculo";
	public static final String ACCION_CONSULTAR_VEHICULO = "consultar_vehiculo";
	
	public static final String ACCION_CONSULTAR_CLASIFICACION = "consultar_clasificacion";
	public static final String ACCION_LISTAR_CLASIFICACION = "listar_clasificacion";
	public static final String ACCION_REGISTRAR_CLASIFICACION  = "registrar_clasificacion";
	public static final String ACCION_MODIFICAR_CLASIFICACION = "modificar_clasificacion";
	public static final String ACCION_FILTRO_CLASIFICACION = "filtro_clasificacion";

	public static final String ACCION_CONSULTAR_PERFIL = "consultar_perfil";
	
	
	public static final String ACCION_CONSULTAR_USUARIO = "consultar_usuario";
	
	
	public static final String ACCION_RESERVAR_BOLETO = "reservar_boleto";
	public static final String ACCION_VENDER_BOLETO = "vender_boleto";
	
	
	public static final String ACCION_CONSULTAR_RUTA = "consultar_ruta";
	public static final String ACCION_LISTAR_RUTA = "listar_ruta";
	public static final String ACCION_REGISTRAR_RUTA  = "registrar_ruta";
	public static final String ACCION_MODIFICAR_RUTA = "modificar_ruta";
	public static final String ACCION_FILTRO_RUTA = "filtro_ruta";
	
	public static final String ACCION_RECUPERAR_CONTRASENA="recuperar_contrasena";
	
	
	
	public static final String VENDER_BOLETO = "vender_boleto";
	
	public static final String ACCION_BUSQUEDA_REALIZADA= "realizado";
	public static final String ACCION_BUSQUEDA_NO_REALIZADA= "norealizado";
	
	
}
