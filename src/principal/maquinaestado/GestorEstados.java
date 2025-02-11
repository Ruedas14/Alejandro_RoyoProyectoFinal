package principal.maquinaestado;

import java.awt.Graphics;

import principal.graficos.SuperficieDibujo;
import principal.maquinaestado.estados.juego.GestorJuego;
import principal.maquinaestado.estados.menujuego.GestorMenu;


public class GestorEstados {
	
	private EstadoJuego[] estados;
	private EstadoJuego estadoActual;
	
	public GestorEstados(final SuperficieDibujo sd) {
		iniciarEstados(sd);
		iniciarEstadoActual();
		
	}

	/**
	 * Creamos nuestro gestor del juego
	 * @param sd
	 */
	private void iniciarEstados(final SuperficieDibujo sd) {
		estados = new EstadoJuego[2];
		estados[0] = new GestorJuego();
		estados[1] = new GestorMenu(sd);
	}
	
	private void iniciarEstadoActual() {
		estadoActual = estados[0];
	}
	
	public void actualizar() {
		estadoActual.actualizar();
	}
	
	public void dibujar(final Graphics g) {
		estadoActual.dibujar(g);
	}
	
	/**
	 * Cambio de los estados
	 * @param nuevoEstado
	 */
	public void cambiarEstadoActual(final int nuevoEstado) {
		estadoActual = estados[nuevoEstado];
	}
	
	public EstadoJuego obtenerEstadoActual() {
		return estadoActual;
	}
}
