package Principal;

import Controlador.controlador;
import Modelo.modelo;
import Vista.vistaLogo;

/**
 *
 * @author Bryan Alexander Riaño Romero, Juan Sebastian Gomez Fajardo, Juan Carlos Rios Fonseca
 */
public class principal {

    /**
    * Creamos objetos de todas las demas clases y los pasamos como parametros al objeto de tipo controlador.
    */
    public static void main(String[] args) {
        vistaLogo vis = new vistaLogo();
        modelo mod = new modelo();        
        controlador cont = new controlador(vis, mod);
    }

}
