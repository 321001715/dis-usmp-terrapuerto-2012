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
	public static final int MODIFICAR_PROVEEDOR = 3;	
	
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
}
