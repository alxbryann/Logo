package Modelo;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author Bryan Alexander Riaño Romero,Juan Sebastian Gomez Fajardo, Juan Carlos Rios Fonseca
 */
public class modelo {

    private ArrayList<Integer> movimientos;
    private int direccion;
    private int unidades;
    private int posicion;
    private int posicioni;
    private int posicionj;
    private boolean variasInstrucciones;
    private boolean pincel;
    private boolean borrador;

    /**
    *Constructor de la clase modelo, mediante el cual, inicializaremos las variables, con un valor conveniente. 
    */
    public modelo() {
        direccion = 1;
        unidades = 0;
        posicioni = 0;
        posicionj = 0;
        pincel = false;
        borrador = false;
        variasInstrucciones = false;
    }
    /**
    * Metodo mediante el cual obtendremos el valor asignado a la variable dirección
    * @return direccion
    */
    public int getDireccion() {
        return direccion;
    }
    /**
    * Metodo mediante el cual cambiaremos el valor asignado a la variable dirección
    * @param direccion, la cual será la nueva dirección 
    */
    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }
    /**
    * Metodo mediante el cual obtendremos el valor asignado a la variable unidades
    * @return unidades
    */
    public int getUnidades() {
        return unidades;
    }
    /**
    * Metodo mediante el cual cambiaremos el valor asignado a la variable unidades
    * @param unidades, las cuales seran las unidades que seran usadas
    */
    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }
    /**
    * Metodo mediante el cual obtendremos el valor asignado a la variable posicion
    * @return posicion
    */
    public int getPosicion() {
        return posicion;
    }
    /**
    * Metodo mediante el cual cambiaremos el valor asignado a la variable posicion
    * @param posicion, la cual sera la posicion en la que se encontrara la tortuga
    */
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    /**
    * Metodo mediante el cual obtendremos el valor asignado a la variable posicioni
    * @return posicioni
    */
    public int getPosicioni() {
        return posicioni;
    }
    /**
    * Metodo mediante el cual cambiaremos el valor asignado a la variable posicioni
    * @param posicioni, la cual nos dirá en que posicioni ha quedado la tortuga
    */
    public void setPosicioni(int posicioni) {
        this.posicioni = posicioni;
    }
    /**
    * Metodo mediante el cual obtendremos el valor asignado a la variable posicionj
    * @return posicionj
    */
    public int getPosicionj() {
        return posicionj;
    }
    /**
    * Metodo mediante el cual cambiaremos el valor asignado a la variable posicionj
    * @param posicionj, la cual nos dirá en que posicionj ha quedado la tortuga
    */
    public void setPosicionj(int posicionj) {
        this.posicionj = posicionj;
    }
    /**
    * Metodo mediante el cual obtendremos el valor asignado a la variable pincel
    * @return pincel
    */
    public boolean isPincel() {
        return pincel;
    }
    /**
    * Metodo mediante el cual cambiaremos el valor asignado a la variable pincel
    * @param pincel, el cual nos dira si se deberia estar pintando o no
    */
    public void setPincel(boolean pincel) {
        this.pincel = pincel;
    }
    /**
    * Metodo mediante el cual obtendremos el valor asignado a la variable borrador
    * @return borrador
    */
    public boolean isBorrador() {
        return borrador;
    }
    /**
    * Metodo mediante el cual cambiaremos el valor asignado a la variable borrador
    * @param borrador, el cual nos dirá si deberia estar borrando o no
    */
    public void setBorrador(boolean borrador) {
        this.borrador = borrador;
    }
    /**
    * Metodo mediante el cual obtendremos el valor asignado a la variable variasInstrucciones;
    * @return variasInstrucciones
    */
    public boolean isVariasInstrucciones() {
        return variasInstrucciones;
    }
    /**
    * Metodo mediante el cual sabremos si el usuario quiere ejecutar mas de solo una instruccion
    * @param variasInstrucciones, la cual nos dirá si se deben guardar o no las acciones 
    */
    public void setVariasInstrucciones(boolean variasInstrucciones) {
        this.variasInstrucciones = variasInstrucciones;
    }
    /**
    * Metodo mediante el cual obtendremos el arreglo movimientos
    * @return movimientos
    */
    public ArrayList<Integer> getMovimientos() {
        return movimientos;
    }
    /**
    * Metodo mediante el cual guardaremos los movimientos que quiera ejecutar el usuario
    * @param movimientos, nos dará un ArrayList lleno con los movimientos que desea ejecutar el usuario
    */
    public void setMovimientos(ArrayList<Integer> movimientos) {
        this.movimientos = movimientos;
    }
    /**
    * Metodo mediante el cual sabremos cual es la ubicacion en i y j de la tortuga
    * @param Matriz, esta será la matriz de labels, y con esta buscaremos la tortuga
    */
    public void ubicacionTortuga(JLabel[][] Matriz) {
        for (int i = 0; i < Matriz.length; i++) {
            for (int j = 0; j < Matriz[i].length; j++) {
                if (Matriz[i][j].getText().equals("🡺") || Matriz[i][j].getText().equals("🡾") || Matriz[i][j].getText().equals("🡻") || Matriz[i][j].getText().equals("🡿")
                        || Matriz[i][j].getText().equals("🡸") || Matriz[i][j].getText().equals("🡼") || Matriz[i][j].getText().equals("🡹") || Matriz[i][j].getText().equals("🡽")) {
                    posicioni = i;
                    posicionj = j;
                }
            }
        }
    }
    /**
    * Metodo mediante el cual cambiaremos la dirección que tiene la tortuga
    * @param Matriz, esta será la matriz de labels sobre la cual le cambiaremos la direccion a la tortuga
    * @param numero, este será el numero que nos indicara la nueva direccion de la tortuga
    */
    public void cambiarDireccion(int numero, JLabel[][] Matriz) {
        direccion += numero;
        if (direccion > 8) {
            direccion = 1;
        }
        if (direccion < 1) {
            direccion = 8;
        }
        direccionTortuga(Matriz);
    }
    /**
    * Metodo mediante el cual asignaremos en la Matriz[posicioni][posicionj], la flecha indicando la dirección de la tortuga
    * @param Matriz, esta será la matriz de labels, y con esta pondremos la flecha 
    */
    public void direccionTortuga(JLabel[][] Matriz) {
        switch (direccion) {
            case 1:
                Matriz[posicioni][posicionj].setText("🡺");
                break;
            case 2:
                Matriz[posicioni][posicionj].setText("🡾");
                break;
            case 3:
                Matriz[posicioni][posicionj].setText("🡻");
                break;
            case 4:
                Matriz[posicioni][posicionj].setText("🡿");
                break;
            case 5:
                Matriz[posicioni][posicionj].setText("🡸");
                break;
            case 6:
                Matriz[posicioni][posicionj].setText("🡼");
                break;
            case 7:
                Matriz[posicioni][posicionj].setText("🡹");
                break;
            case 8:
                Matriz[posicioni][posicionj].setText("🡽");
                break;
        }
    }
    /**
    * Metodo mediante el cual la tortuga se movera en las filas
    * @param Matriz, esta será la matriz de labels, y sobre esta la tortuga se moverá en las filas
    * @param a, este será el label mediante el cual pondremos alertas
    */
    public void movimientosenFilas(JLabel[][] Matriz, JLabel a) {
        Matriz[posicioni][posicionj].setText("");
        switch (direccion) {
            case 1:                
                try {
                Matriz[posicioni][posicionj + unidades].setText("🡺");
            } catch (Exception e) {
                a.setText("Este movimiento excede la matriz");
            }
            break;
            case 5:
                try {
                Matriz[posicioni][posicionj - unidades].setText("🡸");
            } catch (Exception e) {
                a.setText("Este movimiento excede la matriz");
            }
            break;
        }
    }
    /**
    * Metodo mediante el cual la tortuga pintara en las filas
    * @param Matriz, esta será la matriz de labels, y sobre esta la tortuga pintará en las filas
    */
    public void pintarFilas(JLabel[][] Matriz) {
        switch (direccion) {
            case 1:
                for (int j = posicionj; j < posicionj + unidades; j++) {
                    Matriz[posicioni][j].setBackground(Color.red);
                }
                Matriz[posicioni][posicionj + 1].setBackground(Color.red);
                break;
            case 5:
                for (int j = posicionj; j > posicionj - unidades; j--) {
                    Matriz[posicioni][j].setBackground(Color.red);
                }
                Matriz[posicioni][posicionj - 1].setBackground(Color.red);
                break;
        }
    }
    /**
    * Metodo mediante el cual la tortuga pintara en las filas
    * @param Matriz, esta será la matriz de labels, y sobre esta la tortuga pintará en las filas mientras retrocede
    * @param ret, este parametro será el que nos indicara que no esta avanzando, sino retrocediendo
    */
    public void pintarFilas(JLabel[][] Matriz, boolean ret) {
        switch (direccion) {
            case 1:
                for (int j = posicionj - unidades; j > posicionj; j--) {
                    Matriz[posicioni][j + unidades].setBackground(Color.red);
                }
                break;
            case 5:
                for (int j = posicionj + unidades; j < posicionj; j++) {
                    Matriz[posicioni][j - unidades].setBackground(Color.red);
                }
        }
    }
    /**
    * Metodo mediante el cual la tortuga se movera en las columnas
    * @param Matriz, esta será la matriz de labels, y sobre esta la tortuga se moverá en las columnas
    * @param a, este será el label mediante el cual pondremos alertas
    */
    public void movimientosenColumnas(JLabel[][] Matriz, JLabel a) {
        Matriz[posicioni][posicionj].setText("");
        switch (direccion) {
            case 3:
                try {
                Matriz[posicioni + unidades][posicionj].setText("🡻");
            } catch (Exception e) {
                a.setText("Este movimiento excede la matriz");
            }
            break;
            case 7:
                try {
                Matriz[posicioni - unidades][posicionj].setText("🡹");
            } catch (Exception e) {
                a.setText("Este movimiento excede la matriz");
            }
            break;
        }
    }
    /**
    * Metodo mediante el cual la tortuga pintara en las columnas
    * @param Matriz, esta será la matriz de labels, y sobre esta la tortuga pintará en las columnas
    */
    public void pintarColumnas(JLabel[][] Matriz) {
        switch (direccion) {
            case 3:
                for (int i = posicioni; i < posicioni + unidades; i++) {
                    Matriz[i][posicionj].setBackground(Color.red);
                }
                Matriz[posicioni + 1][posicionj].setBackground(Color.red);
                break;
            case 7:
                for (int i = posicioni; i > posicioni - unidades; i--) {
                    Matriz[i][posicionj].setBackground(Color.red);
                }
                Matriz[posicioni - 1][posicionj].setBackground(Color.red);
        }
    }
    /**
    * Metodo mediante el cual la tortuga pintara en las columnas
    * @param Matriz, esta será la matriz de labels, y sobre esta la tortuga pintará en las columnas mientras retrocede
    * @param ret, este parametro será el que nos indicara que no esta avanzando, sino retrocediendo
    */
    public void pintarColumnas(JLabel[][] Matriz, boolean ret) {
        switch (direccion) {
            case 3:
                for (int i = posicioni - unidades; i > posicioni; i--) {
                    Matriz[i + unidades][posicionj].setBackground(Color.red);
                }
                break;
            case 7:
                for (int i = posicioni + unidades; i < posicioni; i++) {
                    Matriz[i - unidades][posicionj].setBackground(Color.red);
                }
        }
    }
    /**
    * Metodo mediante el cual la tortuga se movera en las diagonales de izquierda a derecha
    * @param Matriz, esta será la matriz de labels, y sobre esta la tortuga se moverá en las diagonales de izquierda a derecha
    * @param a, este será el label mediante el cual pondremos alertas
    */
    public void movimientosdiagonalIZQDER(JLabel[][] Matriz, JLabel a) {
        Matriz[posicioni][posicionj].setText("");
        switch (direccion) {
            case 2:       
                try {
                Matriz[posicioni + unidades][posicionj + unidades].setText("🡾");
            } catch (Exception e) {
                a.setText("Este movimiento excede la matriz");
            }
            break;
            case 8:
                try {
                Matriz[posicioni - unidades][posicionj + unidades].setText("🡽");
            } catch (Exception e) {
                a.setText("Este movimiento excede la matriz");
            }
            break;
        }
    }
    /**
    * Metodo mediante el cual la tortuga pintara en las filas
    * @param Matriz, esta será la matriz de labels, y sobre esta la tortuga pintará en las diagonales de izquierda a derecha
    */
    public void pintardiagonalIZQDER(JLabel[][] Matriz) {
        switch (direccion) {
            case 2:
                for (int i = 0; i < unidades; i++) {
                    Matriz[posicioni++][posicionj++].setBackground(Color.red);
                }
                Matriz[posicioni++][posicionj++].setBackground(Color.red);
                break;
            case 8:
                for (int i = 0; i < unidades; i++) {
                    Matriz[posicioni--][posicionj++].setBackground(Color.red);
                }
                Matriz[posicioni--][posicionj++].setBackground(Color.red);
        }
    }
    /**
    * Metodo mediante el cual la tortuga pintara en las diagonales de izquierda a derecha
    * @param Matriz, esta será la matriz de labels, y sobre esta la tortuga pintará en las diagonales de izquierda a derecha mientras retrocede
    * @param ret, este parametro será el que nos indicara que no esta avanzando, sino retrocediendo
    */
    public void pintardiagonalIZQDER(JLabel[][] Matriz, boolean ret) {
        switch (direccion) {
            case 2:
                for (int i = 0; i > unidades; i--) {
                    Matriz[posicioni--][posicionj--].setBackground(Color.red);
                }
                break;
            case 8:
                for (int i = 0; i > unidades; i--) {
                    Matriz[posicioni++][posicionj--].setBackground(Color.red);
                }
        }
    }
    /**
    * Metodo mediante el cual la tortuga se movera en las diagonales de derecha a izquierda
    * @param Matriz, esta será la matriz de labels, y sobre esta la tortuga se moverá en las diagonales de derecha a izquierda
    * @param a, este será el label mediante el cual pondremos alertas
    */
    public void movimientosdiagonalDERIZQ(JLabel[][] Matriz, JLabel a) {
        Matriz[posicioni][posicionj].setText("");
        switch (direccion) {
            case 4:
                try {
                Matriz[posicioni + unidades][posicionj - unidades].setText("🡿");
            } catch (Exception e) {
                a.setText("Este movimiento excede la matriz");
            }
            break;
            case 6:
                try {
                Matriz[posicioni - unidades][posicionj - unidades].setText("🡼");
            } catch (Exception e) {
                a.setText("Este movimiento excede la matriz");
            }
            break;
        }
    }
    /**
    * Metodo mediante el cual la tortuga pintara en las diagonales de derecha a izquierda
    * @param Matriz, esta será la matriz de labels, y sobre esta la tortuga pintará en las diagonales de derecha a izquierda
    */
    public void pintardiagonalDERIZQ(JLabel[][] Matriz) {
        switch (direccion) {
            case 6:
                for (int i = 0; i < unidades; i++) {
                    Matriz[posicioni--][posicionj--].setBackground(Color.red);
                }
                Matriz[posicioni--][posicionj--].setBackground(Color.red);
                break;
            case 4:
                for (int i = 0; i < unidades; i++) {
                    Matriz[posicioni++][posicionj--].setBackground(Color.red);
                }
                Matriz[posicioni++][posicionj--].setBackground(Color.red);
        }
    }
    /**
    * Metodo mediante el cual la tortuga pintara en las diagonales de derecha a izquierda
    * @param Matriz, esta será la matriz de labels, y sobre esta la tortuga pintará en las diagonales de derecha a izquierda mientras retrocede
    * @param ret, este parametro será el que nos indicara que no esta avanzando, sino retrocediendo
    */
    public void pintardiagonalDERIZQ(JLabel[][] Matriz, boolean ret) {
        switch (direccion) {
            case 6:
                for (int i = 0; i > unidades; i--) {
                    Matriz[posicioni++][posicionj++].setBackground(Color.red);
                }
                break;
            case 4:
                for (int i = 0; i > unidades; i--) {
                    Matriz[posicioni--][posicionj++].setBackground(Color.red);
                }
        }
    }
    /**
    * Metodo mediante el cual la tortuga borrará en las filas
    * @param Matriz, esta será la matriz de labels, y sobre esta la tortuga borrará en las filas
    */
    public void borrarFilas(JLabel[][] Matriz) {
        switch (direccion) {
            case 1:
                for (int j = posicionj; j < posicionj + unidades; j++) {
                    Matriz[posicioni][j].setBackground(Color.white);
                }
                Matriz[posicioni][posicionj + 1].setBackground(Color.white);
                break;
            case 5:
                for (int j = posicionj; j > posicionj - unidades; j--) {
                    Matriz[posicioni][j].setBackground(Color.white);
                }
                Matriz[posicioni][posicionj - 1].setBackground(Color.white);
        }
    }
    /**
    * Metodo mediante el cual la tortuga borrará en las filas
    * @param Matriz, esta será la matriz de labels, y sobre esta la tortuga borrará en las filas mientras retrocede
    * @param ret, este parametro será el que nos indicara que no esta avanzando, sino retrocediendo
    */
    public void borrarFilas(JLabel[][] Matriz, boolean ret) {
        switch (direccion) {
            case 1:
                for (int j = posicionj - unidades; j > posicionj; j--) {
                    Matriz[posicioni][j + unidades].setBackground(Color.white);
                }
                break;
            case 5:
                for (int j = posicionj + unidades; j < posicionj; j++) {
                    Matriz[posicioni][j - unidades].setBackground(Color.white);
                }
        }
    }
    /**
    * Metodo mediante el cual la tortuga borrará en las columnas
    * @param Matriz, esta será la matriz de labels, y sobre esta la tortuga borrará en las columnas
    */
    public void borrarColumnas(JLabel[][] Matriz) {
        switch (direccion) {
            case 3:
                for (int i = posicioni; i < posicioni + unidades; i++) {
                    Matriz[i][posicionj].setBackground(Color.white);
                }
                Matriz[posicioni + 1][posicionj].setBackground(Color.white);
                break;
            case 7:
                for (int i = posicioni; i > posicioni - unidades; i--) {
                    Matriz[i][posicionj].setBackground(Color.white);
                }
                Matriz[posicioni - 1][posicionj].setBackground(Color.white);
        }
    }
    /**
    * Metodo mediante el cual la tortuga borrará en las columnas
    * @param Matriz, esta será la matriz de labels, y sobre esta la tortuga borrará en las columnas mientras retrocede
    * @param ret, este parametro será el que nos indicara que no esta avanzando, sino retrocediendo
    */
    public void borrarColumnas(JLabel[][] Matriz, boolean ret) {
        switch (direccion) {
            case 3:
                for (int i = posicioni - unidades; i > posicioni; i--) {
                    Matriz[i + unidades][posicionj].setBackground(Color.white);
                }
                break;
            case 7:
                for (int i = posicioni + unidades; i < posicioni; i++) {
                    Matriz[i - unidades][posicionj].setBackground(Color.white);
                }
        }
    }
    /**
    * Metodo mediante el cual la tortuga borrará en las diagonales de izquierda a derecha
    * @param Matriz, esta será la matriz de labels, y sobre esta la tortuga borrará en las diagonales de izquierda a derecha
    */
    public void borrardiagonalIZQDER(JLabel[][] Matriz) {
        switch (direccion) {
            case 2:
                for (int i = 0; i < unidades; i++) {
                    Matriz[posicioni++][posicionj++].setBackground(Color.white);
                }
                Matriz[posicioni++][posicionj++].setBackground(Color.white);
                break;
            case 8:
                for (int i = 0; i < unidades; i++) {
                    Matriz[posicioni--][posicionj++].setBackground(Color.white);
                }
                Matriz[posicioni--][posicionj++].setBackground(Color.white);
        }
    }
    /**
    * Metodo mediante el cual la tortuga borrará en las diagonales de izquierda a derecha
    * @param Matriz, esta será la matriz de labels, y sobre esta la tortuga borrará en las diagonales de izquierda a derecha mientras retrocede
    * @param ret, este parametro será el que nos indicara que no esta avanzando, sino retrocediendo
    */
    public void borrardiagonalIZQDER(JLabel[][] Matriz, boolean ret) {
        switch (direccion) {
            case 2:
                for (int i = 0; i > unidades; i--) {
                    Matriz[posicioni--][posicionj--].setBackground(Color.white);
                }
                break;
            case 8:
                for (int i = 0; i > unidades; i--) {
                    Matriz[posicioni++][posicionj--].setBackground(Color.white);
                }
        }
    }
    /**
    * Metodo mediante el cual la tortuga borrará en las diagonales de derecha a izquierda
    * @param Matriz, esta será la matriz de labels, y sobre esta la tortuga borrará en las diagonales de derecha a izquierda
    */
    public void borrarDiagonalDERIZQ(JLabel[][] Matriz) {
        switch (direccion) {
            case 6:
                for (int i = 0; i < unidades; i++) {
                    Matriz[posicioni--][posicionj--].setBackground(Color.white);
                }
                Matriz[posicioni--][posicionj--].setBackground(Color.white);
                break;
            case 4:
                for (int i = 0; i < unidades; i++) {
                    Matriz[posicioni++][posicionj--].setBackground(Color.white);
                }
                Matriz[posicioni++][posicionj--].setBackground(Color.white);
        }
    }
    /**
    * Metodo mediante el cual la tortuga borrará en las diagonales de derecha a izquierda
    * @param Matriz, esta será la matriz de labels, y sobre esta la tortuga borrará en las diagonales de derecha a izquierda mientras retrocede
    * @param ret, este parametro será el que nos indicara que no esta avanzando, sino retrocediendo
    */
    public void borrarDiagonalDERIZQ(JLabel[][] Matriz, boolean ret) {
        switch (direccion) {
            case 6:
                for (int i = 0; i > unidades; i--) {
                    Matriz[posicioni++][posicionj++].setBackground(Color.white);
                }
                break;
            case 4:
                for (int i = 0; i > unidades; i--) {
                    Matriz[posicioni--][posicionj++].setBackground(Color.white);
                }
        }
    }
    /**
    * Metodo mediante el cual se limpiara el tablero
    * @param Matriz, esta será la matriz de labels, y sobre esta se pondrá todo a su modo inicial
    */
    public void limpiarTablero(JLabel[][] Matriz) {
        posicioni = 0;
        posicionj = 0;
        pincel = false;
        borrador = false;
        for (int i = 0; i < Matriz.length; i++) {
            for (int j = 0; j < Matriz[0].length; j++) {
                Matriz[i][j].setText("");
                Matriz[i][j].setBackground(Color.white);
            }
        }
        Matriz[0][0].setText("🡺");
    }
    /**
    * Metodo mediante el cual crearemos el ArrayList de movimientos
    */
    public void crearArraylist() {
        movimientos = new ArrayList<>();
    }
    /**
    * Metodo mediante el cual llenaremos el ArrayList de movimientos, con los movimientos que desee el usuario
    * @param num, este parametro nos indicará el movimiento que desee hacer, por ejemplo el 1 significa avanzar
    * @param num1, este parametro nos indicará el numero de unidades, que se desea avanzar por ejemplo
    */
    public void llenarArraylist(int num, int num1) {
        movimientos.add(num);
        movimientos.add(num1);
    }
    /**
    * Metodo mediante el cual llenaremos el ArrayList de movimientos que no necesitan unidades
    * @param num, este parametro nos indicara el movimiento que desea hacer el usuario, por ejemplo 3, girar a la derecha
    */
    public void llenarArraylist(int num) {
        movimientos.add(num);
        movimientos.add(0);
    }
}
