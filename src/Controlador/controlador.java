package Controlador;

import java.awt.*;
import java.awt.event.*;
import Vista.vistaLogo;
import Modelo.modelo;

/**
 *
 * @author Bryan Alexander Riaño Romero, Juan Sebastian Gomez Fajardo, Juan Carlos Rios Fonseca
 * 
 */

public class controlador implements ActionListener {
    
    /**
    * Declaramos los objetos view, logica, y el String salida.
    */
    private final vistaLogo view;
    private final modelo logica;
    private String salida;

     /**
    * En el constructor recibimos como parametros logica, y view.
    * @param logica, para poder desde el controlador usar la logica
    * @param view, para poder desde el controlador usar la vista
    */
    public controlador(vistaLogo view, modelo logica) {
        this.view = view;
        this.logica = logica;
        this.view.avanzar.addActionListener(this);
        this.view.retroceder.addActionListener(this);
        this.view.derecha.addActionListener(this);
        this.view.izquierda.addActionListener(this);
        this.view.bajarPincel.addActionListener(this);
        this.view.subirPincel.addActionListener(this);
        this.view.bajarBorrador.addActionListener(this);
        this.view.variasInstrucciones.addActionListener(this);
        this.view.ejecutarInstrucciones.addActionListener(this);
        this.view.limpiarTablero.addActionListener(this);
        processKeys();
    }
    /**
    *Metodo mediante el cual, llamamos dos metodos de logica, los cuales sirven para saber la ubicación y dirección de la tortuga.
    */
    public void ubicar() {
        logica.ubicacionTortuga(view.Matriz);
        logica.direccionTortuga(view.Matriz);
    }
     /**
    * Metodo mediante el cual se detecta el evento de clic sobre cualquier objeto de vista.
    * @param e, el cual es el evento del clic
    */
    @Override
    public void actionPerformed(ActionEvent e) {
        /**
        * Si se hace clic sobre el boton de avanzar ubicado en la vista, se ejecutaran estas instrucciones
        */
        if (e.getSource() == view.avanzar) {
            if (logica.isVariasInstrucciones() == true) {
                logica.llenarArraylist(1, Integer.parseInt(view.escuchador.getText()));
                view.añadirMovimientos("La tortuga avanzará " + view.escuchador.getText() + " unidades");
                view.escuchador.setText("");
            } else {
                view.notificacion.setText("");
                logica.setUnidades(Integer.parseInt(view.escuchador.getText()));
                view.escuchador.setText("");
                ubicar();
                if (logica.getDireccion() == 1 | logica.getDireccion() == 5) {
                    logica.movimientosenFilas(view.Matriz, view.notificacion);
                }
                if (logica.getDireccion() == 3 || logica.getDireccion() == 7) {
                    logica.movimientosenColumnas(view.Matriz, view.notificacion);
                }
                if (logica.getDireccion() == 2 || logica.getDireccion() == 8) {
                    logica.movimientosdiagonalIZQDER(view.Matriz, view.notificacion);
                }
                if (logica.getDireccion() == 4 || logica.getDireccion() == 6) {
                    logica.movimientosdiagonalDERIZQ(view.Matriz, view.notificacion);
                }
                if (logica.isPincel() == true) {
                    if (logica.getDireccion() == 1 || logica.getDireccion() == 5) {
                        logica.pintarFilas(view.Matriz);
                    }
                    if (logica.getDireccion() == 3 || logica.getDireccion() == 7) {
                        logica.pintarColumnas(view.Matriz);
                    }
                    if (logica.getDireccion() == 2 || logica.getDireccion() == 8) {
                        logica.pintardiagonalIZQDER(view.Matriz);
                    }
                    if (logica.getDireccion() == 6 || logica.getDireccion() == 4) {
                        logica.pintardiagonalDERIZQ(view.Matriz);
                    }
                }
                if (logica.isBorrador() == true) {
                    if (logica.getDireccion() == 1 || logica.getDireccion() == 5) {
                        logica.borrarFilas(view.Matriz);
                    }
                    if (logica.getDireccion() == 3 || logica.getDireccion() == 7) {
                        logica.borrarColumnas(view.Matriz);
                    }
                    if (logica.getDireccion() == 2 || logica.getDireccion() == 8) {
                        logica.borrardiagonalIZQDER(view.Matriz);
                    }
                    if (logica.getDireccion() == 4 || logica.getDireccion() == 6) {
                        logica.borrarDiagonalDERIZQ(view.Matriz);
                    }
                }
            }
            logica.setUnidades(0);
            ubicar();
            view.posicion.setText("i:" + (logica.getPosicioni() + 1) + " j:" + (logica.getPosicionj() + 1));
        }
        /**
        * Si se hace clic sobre el boton de retroceder ubicado en la vista, se ejecutaran estas instrucciones
        */
        if (e.getSource() == view.retroceder) {
            boolean ret = true;
            if (logica.isVariasInstrucciones() == true) {
                logica.llenarArraylist(2, Integer.parseInt(view.escuchador.getText()) * -1);
                view.añadirMovimientos("La tortuga retrocederá " + view.escuchador.getText() + " unidades");
                view.escuchador.setText("");
            } else {
                view.notificacion.setText("");
                logica.setUnidades(Integer.parseInt(view.escuchador.getText()) * -1);
                view.escuchador.setText("");
                logica.ubicacionTortuga(view.Matriz);
                logica.direccionTortuga(view.Matriz);
                if (logica.getDireccion() == 1 | logica.getDireccion() == 5) {
                    logica.movimientosenFilas(view.Matriz, view.notificacion);
                }
                if (logica.getDireccion() == 3 || logica.getDireccion() == 7) {
                    logica.movimientosenColumnas(view.Matriz, view.notificacion);
                }
                if (logica.getDireccion() == 2 || logica.getDireccion() == 8) {
                    logica.movimientosdiagonalIZQDER(view.Matriz, view.notificacion);
                }
                if (logica.getDireccion() == 4 || logica.getDireccion() == 6) {
                    logica.movimientosdiagonalDERIZQ(view.Matriz, view.notificacion);
                }
                if (logica.isPincel() == true) {
                    if (logica.getDireccion() == 1 || logica.getDireccion() == 5) {
                        logica.pintarFilas(view.Matriz, ret);
                    }
                    if (logica.getDireccion() == 3 || logica.getDireccion() == 7) {
                        logica.pintarColumnas(view.Matriz, ret);
                    }
                    if (logica.getDireccion() == 2 || logica.getDireccion() == 8) {
                        logica.pintardiagonalIZQDER(view.Matriz, ret);
                    }
                    if (logica.getDireccion() == 4 || logica.getDireccion() == 6) {
                        logica.pintardiagonalDERIZQ(view.Matriz, ret);
                    }
                }
                if (logica.isBorrador() == true) {
                    if (logica.getDireccion() == 1 || logica.getDireccion() == 5) {
                        logica.borrarFilas(view.Matriz, ret);
                    }
                    if (logica.getDireccion() == 3 || logica.getDireccion() == 7) {
                        logica.borrarColumnas(view.Matriz, ret);
                    }
                    if (logica.getDireccion() == 2 || logica.getDireccion() == 8) {
                        logica.borrardiagonalIZQDER(view.Matriz, ret);
                    }
                    if (logica.getDireccion() == 4 || logica.getDireccion() == 6) {
                        logica.borrarDiagonalDERIZQ(view.Matriz, ret);
                    }
                }
                logica.setUnidades(0);
                ubicar();
                view.posicion.setText("i:" + (logica.getPosicioni() + 1) + " j:" + (logica.getPosicionj() + 1));
            }
        }
        /**
        * Si se hace clic sobre el boton de Girar 45° a la derecha ubicado en la vista, se ejecutaran estas instrucciones
        */
        if (e.getSource() == view.derecha) {
            if (logica.isVariasInstrucciones() == true) {
                logica.llenarArraylist(3);
                view.añadirMovimientos("La tortuga girara 45° a la derecha");
            } else {
                view.notificacion.setText("");
                logica.ubicacionTortuga(view.Matriz);
                logica.cambiarDireccion(1, view.Matriz);
            }
        /**
        * Si se hace clic sobre el boton de 45° a la izquierda ubicado en la vista, se ejecutaran estas instrucciones
        */
        }
        if (e.getSource() == view.izquierda) {
            if (logica.isVariasInstrucciones() == true) {
                logica.llenarArraylist(4);
                view.añadirMovimientos("La tortuga girara 45° a la izquierda");
            } else {
                view.notificacion.setText("");
                logica.ubicacionTortuga(view.Matriz);
                logica.cambiarDireccion(-1, view.Matriz);
            }
        /**
        * Si se hace clic sobre el boton de bajar pincel ubicado en la vista, se ejecutaran estas instrucciones
        */
        }
        if (e.getSource() == view.bajarPincel) {
            if (logica.isVariasInstrucciones() == true) {
                logica.llenarArraylist(5);
                view.añadirMovimientos("La tortuga bajará el pincel");
            } else {
                view.notificacion.setText("");
                logica.setPincel(true);
                logica.setBorrador(false);
            }
        }
        /**
        * Si se hace clic sobre el boton de subir pincel ubicado en la vista, se ejecutaran estas instrucciones
        */
        if (e.getSource() == view.subirPincel) {
            if (logica.isVariasInstrucciones() == true) {
                logica.llenarArraylist(6);
                view.añadirMovimientos("La tortuga subirá el pincel");
            } else {
                view.notificacion.setText("");
                logica.setPincel(false);
            }
        }
        /**
        * Si se hace clic sobre el boton de bajar el borrador ubicado en la vista, se ejecutaran estas instrucciones
        */
        if (e.getSource() == view.bajarBorrador) {
            if (logica.isVariasInstrucciones() == true) {
                logica.llenarArraylist(7);
                view.añadirMovimientos("La tortuga bajará el borrador");
            } else {
                view.notificacion.setText("");
                logica.setBorrador(true);
                logica.setPincel(false);
            }
        }/**
        * Si se hace clic sobre el boton de tomar varias instrucciones ubicado en la vista, se ejecutaran estas instrucciones
        */
        if (e.getSource() == view.variasInstrucciones) {
            logica.crearArraylist();
            logica.setVariasInstrucciones(true);
            view.notificacion.setText("");
            view.añadirMovimientos("La tortuga tomará varias instrucciones");
        }
        /**
        * Si se hace clic sobre el boton de ejecutar varias instrucciones ubicado en la vista, se ejecutaran estas instrucciones
        */
        if (e.getSource() == view.ejecutarInstrucciones) {
            logica.setVariasInstrucciones(false);
            view.notificacion.setText("");
            view.añadirMovimientos("eliminar");
            if (logica.getMovimientos().isEmpty()) {

            } else {
                for (int i = 0; i < logica.getMovimientos().size(); i += 2) {
                    switch (logica.getMovimientos().get(i)) {
                        case 1:
                            logica.setUnidades(logica.getMovimientos().get(i + 1));
                            logica.ubicacionTortuga(view.Matriz);
                            logica.direccionTortuga(view.Matriz);
                            if (logica.getDireccion() == 1 | logica.getDireccion() == 5) {
                                logica.movimientosenFilas(view.Matriz, view.notificacion);
                            }
                            if (logica.getDireccion() == 3 || logica.getDireccion() == 7) {
                                logica.movimientosenColumnas(view.Matriz, view.notificacion);
                            }
                            if (logica.getDireccion() == 2 || logica.getDireccion() == 8) {
                                logica.movimientosdiagonalIZQDER(view.Matriz, view.notificacion);
                            }
                            if (logica.getDireccion() == 4 || logica.getDireccion() == 6) {
                                logica.movimientosdiagonalDERIZQ(view.Matriz, view.notificacion);
                            }
                            if (logica.isPincel() == true) {
                                if (logica.getDireccion() == 1 || logica.getDireccion() == 5) {
                                    logica.pintarFilas(view.Matriz);
                                }
                                if (logica.getDireccion() == 3 || logica.getDireccion() == 7) {
                                    logica.pintarColumnas(view.Matriz);
                                }
                                if (logica.getDireccion() == 2 || logica.getDireccion() == 8) {
                                    logica.pintardiagonalIZQDER(view.Matriz);
                                }
                                if (logica.getDireccion() == 6 || logica.getDireccion() == 4) {
                                    logica.pintardiagonalDERIZQ(view.Matriz);
                                }
                            }
                            if (logica.isBorrador() == true) {
                                if (logica.getDireccion() == 1 || logica.getDireccion() == 5) {
                                    logica.borrarFilas(view.Matriz);
                                }
                                if (logica.getDireccion() == 3 || logica.getDireccion() == 7) {
                                    logica.borrarColumnas(view.Matriz);
                                }
                                if (logica.getDireccion() == 2 || logica.getDireccion() == 8) {
                                    logica.borrardiagonalIZQDER(view.Matriz);
                                }
                                if (logica.getDireccion() == 4 || logica.getDireccion() == 6) {
                                    logica.borrarDiagonalDERIZQ(view.Matriz);
                                }
                            }
                            break;
                        case 2:
                            logica.setUnidades(logica.getMovimientos().get(i + 1));
                            logica.ubicacionTortuga(view.Matriz);
                            logica.direccionTortuga(view.Matriz);
                            if (logica.getDireccion() == 1 | logica.getDireccion() == 5) {
                                logica.movimientosenFilas(view.Matriz, view.notificacion);
                            }
                            if (logica.getDireccion() == 3 || logica.getDireccion() == 7) {
                                logica.movimientosenColumnas(view.Matriz, view.notificacion);
                            }
                            if (logica.getDireccion() == 2 || logica.getDireccion() == 8) {
                                logica.movimientosdiagonalIZQDER(view.Matriz, view.notificacion);
                            }
                            if (logica.getDireccion() == 4 || logica.getDireccion() == 6) {
                                logica.movimientosdiagonalDERIZQ(view.Matriz, view.notificacion);
                            }
                            boolean ret = true;
                            if (logica.isPincel() == true) {
                                if (logica.getDireccion() == 1 || logica.getDireccion() == 5) {
                                    logica.pintarFilas(view.Matriz, ret);
                                }
                                if (logica.getDireccion() == 3 || logica.getDireccion() == 7) {
                                    logica.pintarColumnas(view.Matriz, ret);
                                }
                                if (logica.getDireccion() == 2 || logica.getDireccion() == 8) {
                                    logica.pintardiagonalIZQDER(view.Matriz, ret);
                                }
                                if (logica.getDireccion() == 4 || logica.getDireccion() == 6) {
                                    logica.pintardiagonalDERIZQ(view.Matriz, ret);
                                }
                            }
                            if (logica.isBorrador() == true) {
                                if (logica.getDireccion() == 1 || logica.getDireccion() == 5) {
                                    logica.borrarFilas(view.Matriz, ret);
                                }
                                if (logica.getDireccion() == 3 || logica.getDireccion() == 7) {
                                    logica.borrarColumnas(view.Matriz, ret);
                                }
                                if (logica.getDireccion() == 2 || logica.getDireccion() == 8) {
                                    logica.borrardiagonalIZQDER(view.Matriz, ret);
                                }
                                if (logica.getDireccion() == 4 || logica.getDireccion() == 6) {
                                    logica.borrarDiagonalDERIZQ(view.Matriz, ret);
                                }
                            }
                            break;
                        case 3:
                            logica.ubicacionTortuga(view.Matriz);
                            logica.cambiarDireccion(1, view.Matriz);
                            break;
                        case 4:
                            logica.ubicacionTortuga(view.Matriz);
                            logica.cambiarDireccion(-1, view.Matriz);
                            break;
                        case 5:
                            logica.setPincel(true);
                            logica.setBorrador(false);
                            break;
                        case 6:
                            logica.setPincel(false);
                            break;
                        case 7:
                            logica.setBorrador(true);
                            logica.setPincel(false);
                            break;
                    }
                }

            }
            ubicar();
            view.posicion.setText("i:" + (logica.getPosicioni() + 1) + " j:" + (logica.getPosicionj() + 1));
        }
        /**
        * Si se hace clic sobre el boton de limpiar tablero ubicado en la vista, se ejecutaran estas instrucciones
        */
        if (e.getSource() == view.limpiarTablero) {
            logica.limpiarTablero(view.Matriz);
            ubicar();
            view.posicion.setText("i:" + (logica.getPosicioni() + 1) + " j:" + (logica.getPosicionj() + 1));
        }
    }
    /**
    * Metodo mediante el cual se genera la detección de teclas, al crear un nuevo KeyEventDispatcher(), y a su vez un dispatchKeyEvent
    */
    public void processKeys() {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(
                new KeyEventDispatcher() {
            @Override
            /**
            * Metodo mediante el cual confirmaremos si se presiona una tecla
            * @param e, el cual será el KeyEvent encargado de transmitir qué tecla fue tocada
            * @return false, en caso de no tocarse ninguna tecla
            * @return true, en caso de que cualquier tecla se toque
            */
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getID() == KeyEvent.KEY_PRESSED) {
                    salida = String.valueOf(e.getKeyChar());
                    if (salida.equals("0")) {
                        if (view.escuchador.getText().length() > 1) {

                        } else {
                            view.escuchador.setText(view.escuchador.getText() + "0");
                        }
                    }
                    if (salida.equals("1")) {
                        if (view.escuchador.getText().length() > 1) {

                        } else {
                            view.escuchador.setText(view.escuchador.getText() + "1");
                        }
                    }
                    if (salida.equals("2")) {
                        if (view.escuchador.getText().length() > 1) {

                        } else {
                            view.escuchador.setText(view.escuchador.getText() + "2");
                        }
                    }
                    if (salida.equals("3")) {
                        if (view.escuchador.getText().length() > 1) {

                        } else {
                            view.escuchador.setText(view.escuchador.getText() + "3");
                        }
                    }
                    if (salida.equals("4")) {
                        if (view.escuchador.getText().length() > 1) {

                        } else {
                            view.escuchador.setText(view.escuchador.getText() + "4");
                        }
                    }
                    if (salida.equals("5")) {
                        if (view.escuchador.getText().length() > 1) {

                        } else {
                            view.escuchador.setText(view.escuchador.getText() + "5");
                        }
                    }
                    if (salida.equals("6")) {
                        if (view.escuchador.getText().length() > 1) {

                        } else {
                            view.escuchador.setText(view.escuchador.getText() + "6");
                        }
                    }
                    if (salida.equals("7")) {
                        if (view.escuchador.getText().length() > 1) {

                        } else {
                            view.escuchador.setText(view.escuchador.getText() + "7");
                        }
                    }
                    if (salida.equals("8")) {
                        if (view.escuchador.getText().length() > 1) {

                        } else {
                            view.escuchador.setText(view.escuchador.getText() + "8");
                        }
                    }
                    if (salida.equals("9")) {
                        if (view.escuchador.getText().length() > 1) {

                        } else {
                            view.escuchador.setText(view.escuchador.getText() + "9");
                        }
                    }
                    if (e.getKeyCode() == 8) {
                        try {
                            view.escuchador.setText(view.escuchador.getText().substring(0, view.escuchador.getText().length() - 1));
                        } catch (Exception a) {
                        }
                    }
                    if (salida.equals("a")) {
                        if (logica.getDireccion() == 5) {
                            view.notificacion.setText("");
                            logica.setUnidades(1);
                            logica.movimientosenFilas(view.Matriz, view.notificacion);
                            if (logica.isPincel() == true) {
                                logica.pintarFilas(view.Matriz);
                            }
                            if (logica.isBorrador() == true) {
                                logica.borrarFilas(view.Matriz);
                            }
                            logica.setUnidades(0);
                        } else {
                            logica.setDireccion(5);
                            view.notificacion.setText("");
                        }
                        ubicar();
                        view.posicion.setText("i:" + (logica.getPosicioni() + 1) + " j:" + (logica.getPosicionj() + 1));
                    }
                    if (salida.equals("q")) {
                        if (logica.getDireccion() == 6) {
                            view.notificacion.setText("");
                            logica.setUnidades(1);
                            logica.movimientosdiagonalDERIZQ(view.Matriz, view.notificacion);
                            if (logica.isPincel() == true) {
                                logica.pintardiagonalDERIZQ(view.Matriz);
                            }
                            if (logica.isBorrador() == true) {
                                logica.borrarDiagonalDERIZQ(view.Matriz);
                            }
                        } else {
                            view.notificacion.setText("");
                            logica.setDireccion(6);
                        }
                        ubicar();
                        view.posicion.setText("i:" + (logica.getPosicioni() + 1) + " j:" + (logica.getPosicionj() + 1));
                    }
                    if (salida.equals("w")) {
                        if (logica.getDireccion() == 7) {
                            view.notificacion.setText("");
                            logica.setUnidades(1);
                            logica.movimientosenColumnas(view.Matriz, view.notificacion);
                            if (logica.isPincel() == true) {
                                logica.pintarColumnas(view.Matriz);
                            }
                            if (logica.isBorrador() == true) {
                                logica.borrarColumnas(view.Matriz);
                            }
                        } else {
                            view.notificacion.setText("");
                            logica.setDireccion(7);
                        }
                        ubicar();
                        view.posicion.setText("i:" + (logica.getPosicioni() + 1) + " j:" + (logica.getPosicionj() + 1));

                    }
                    if (salida.equals("e")) {
                        if (logica.getDireccion() == 8) {
                            view.notificacion.setText("");
                            logica.setUnidades(1);
                            logica.movimientosdiagonalIZQDER(view.Matriz, view.notificacion);
                            if (logica.isPincel() == true) {
                                logica.pintardiagonalIZQDER(view.Matriz);
                            }
                            if (logica.isBorrador() == true) {
                                logica.borrardiagonalIZQDER(view.Matriz);
                            }
                        } else {
                            logica.setDireccion(8);
                            view.notificacion.setText("");
                        }
                        ubicar();
                        view.posicion.setText("i:" + (logica.getPosicioni() + 1) + " j:" + (logica.getPosicionj() + 1));
                    }
                    if (salida.equals("d")) {
                        view.notificacion.setText("");
                        if (logica.getDireccion() == 1) {
                            logica.setUnidades(1);
                            logica.movimientosenFilas(view.Matriz, view.notificacion);
                            if (logica.isPincel() == true) {
                                logica.pintarFilas(view.Matriz);
                            }
                            if (logica.isBorrador() == true) {
                                logica.borrarFilas(view.Matriz);
                            }
                        } else {
                            view.notificacion.setText("");
                            logica.setDireccion(1);
                        }
                        ubicar();
                        view.posicion.setText("i:" + (logica.getPosicioni() + 1) + " j:" + (logica.getPosicionj() + 1));
                    }
                    if (salida.equals("x")) {
                        view.notificacion.setText("");
                        if (logica.getDireccion() == 2) {
                            logica.setUnidades(1);
                            logica.movimientosdiagonalIZQDER(view.Matriz, view.notificacion);
                            if (logica.isPincel() == true) {
                                logica.pintardiagonalIZQDER(view.Matriz);
                            }
                            if (logica.isBorrador() == true) {
                                logica.borrardiagonalIZQDER(view.Matriz);
                            }
                        } else {
                            view.notificacion.setText("");
                            logica.setDireccion(2);
                        }
                        ubicar();
                        view.posicion.setText("i:" + (logica.getPosicioni() + 1) + " j:" + (logica.getPosicionj() + 1));
                    }
                    if (salida.equals("s")) {
                        if (logica.getDireccion() == 3) {
                            view.notificacion.setText("");
                            logica.setUnidades(1);
                            logica.movimientosenColumnas(view.Matriz, view.notificacion);
                            if (logica.isPincel() == true) {
                                logica.pintarColumnas(view.Matriz);
                            }
                            if (logica.isBorrador() == true) {
                                logica.borrarColumnas(view.Matriz);
                            }
                        } else {
                            view.notificacion.setText("");
                            logica.setDireccion(3);
                        }
                        ubicar();
                        view.posicion.setText("i:" + (logica.getPosicioni() + 1) + " j:" + (logica.getPosicionj() + 1));
                    }
                    if (salida.equals("z")) {
                        if (logica.getDireccion() == 4) {
                            view.notificacion.setText("");
                            logica.setUnidades(1);
                            logica.movimientosdiagonalDERIZQ(view.Matriz, view.notificacion);
                            if (logica.isPincel() == true) {
                                logica.pintardiagonalDERIZQ(view.Matriz);
                            }
                            if (logica.isBorrador() == true) {
                                logica.borrarDiagonalDERIZQ(view.Matriz);
                            }
                        } else {
                            view.notificacion.setText("");
                            logica.setDireccion(4);
                        }
                        ubicar();
                        view.posicion.setText("i:" + (logica.getPosicioni() + 1) + " j:" + (logica.getPosicionj() + 1));
                    }
                }
                return false;
            }
        });
    }
}
