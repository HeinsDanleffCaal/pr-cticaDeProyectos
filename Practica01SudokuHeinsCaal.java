/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.practica01sudokuheinscaal;

import java.util.Scanner; //aca importa la clase Scanner para leer la entrada del usuario

public class Practica01SudokuHeinsCaal {

    public static void main(String[] args) {
        int[][] matriz = new int[9][9]; //aqui declara una matriz de 9x9 para el Sudoku
        Scanner scanner = new Scanner(System.in); //crea un objeto Scanner para leer la entrada del usuario
        //Se crea la matriz de nivel facil con algunos valores predefinidos
        int[][] facil = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 6, 0, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

          //Se crea la matriz de nivel medio con algunos valores predefinidos
        int[][] medio = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 6, 0, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        //Se crea la matriz de nivel dificil con algunos valores predefinidos
        int[][] dificil = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 6, 0, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        //Aqui pues solicita al usuario que ingrese el nivel de dificultad
        System.out.println("Ingrese el nivel de dificultad: ");
        int nivel = scanner.nextInt(); //y despues lee el nivel de dificultad ingresado por el usuario

        /*de ahi despues, asigna la matriz correspondiente segun el nivel de dificultad ingresado*/
        if (nivel == 1) {
            matriz = facil;
        } else if (nivel == 2) {
            matriz = medio;
        } else if (nivel == 3) {
            matriz = dificil;
        } else {
            System.out.println("Nivel no valido");
            return; //termina el programa si el nivel no es valido
        }

        int turnos = 5; // Definir el número de turnos que el usario tiene que jugar
        jugarSudoku(matriz, scanner, turnos); //convoca o llama el metodo para jugar Sudoku

        imprimirMatriz(matriz); //y aqui imprime la matriz final despues de jugar
        
        //revisa si el Sudoku esta resuelto correctamente
        if (validarSudoku(matriz)) {
            System.out.println("¡Sudoku resuelto correctamente!");
        } else {
            System.out.println("El Sudoku no es válido.");
        }
    }

    //Aca es el metodo para imprimir la matriz en un formato visual
    private static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("------+-------+------");//muestra una linea divisoria cada 3 filas
            }
            for (int j = 0; j < matriz[i].length; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("| ");//despues muestra una linea divisoria cada 3 columnas
                }
                System.out.print(matriz[i][j] == 0 ? ". " : matriz[i][j] + " "); //y despues muestra el valor de la casilla
                //o un punto si esta vacia
            }
            System.out.println(); //Salta a la siguiente linea despues de imprimir una fila completa
        }
    }

    //Metodo para jugar Sudoku
    private static void jugarSudoku(int[][] matriz, Scanner scanner, int turnos) {
        //el bucle que se ejecuta miestra haya turnos disponibles
        while (turnos > 0) {
            System.out.println("Ingrese la fila: "); //Pide al usuario que ingrese la fila
            int fila = scanner.nextInt(); // y de ahi lee la fila ingresada por el usuario
            System.out.println("Ingrese la columna: "); // pide al usuario que ingrese la columna
            int columna = scanner.nextInt(); //despues lee la columna ingresada por el usuario
            System.out.println("Ingrese el valor: "); //Pide al usuario que ingrese el valor
            int valor = scanner.nextInt(); // y de ahi despues lee el valor ingresado por el usuario
            
            /*Despues revisa si la casilla esta vacia*/
            if (matriz[fila][columna] == 0) {
                matriz[fila][columna] = valor;//asigna el valor ingresado a la casiila
                turnos--; //decrementa el numero de turnos
                imprimirMatriz(matriz); // Imprimir la matriz después de cada turno
            } else {
                System.out.println("Casilla ocupada"); // va mostrando el mensajesi la casilla esta ocupada
            }
        }
    }

    //Metodo para revisar si el Sudoku esta resuelto correctamente
    private static boolean validarSudoku(int[][] matriz) {
        return validarFilas(matriz) && validarColumnas(matriz) && validarSubCuadriculas(matriz);
    }

    //Metodo para validar las filas del Sudoku
    private static boolean validarFilas(int[][] matriz) {
        for (int i = 0; i < 9; i++) {
            boolean[] numeros = new boolean[9]; //arreglo para revisar la unicidad de los numeros
            for (int j = 0; j < 9; j++) {
                if (matriz[i][j] != 0) {
                    if (numeros[matriz[i][j] - 1]) {
                        return false; //retorna falso si un numero se repite
                    }
                    numeros[matriz[i][j] - 1] = true; //Marca el numero como encontrado.
                }
            }
        }
        return true; //Retorna true o verdadero si todas las filas son validas
    }
    
    //Metodo para validar las columnas del Sudoku
    private static boolean validarColumnas(int[][] matriz) {
        for (int j = 0; j < 9; j++) {
            boolean[] numeros = new boolean[9]; //arreglo para verificar la unicidad de los numeros
            for (int i = 0; i < 9; i++) {
                if (matriz[i][j] != 0) {
                    if (numeros[matriz[i][j] - 1]) {
                        return false; //de ahi va a retornar false si numero se repite
                    }
                    numeros[matriz[i][j] - 1] = true;
                }
            }
        }
        return true;
    }

    //Aca este metodo verifica si todas las subcuadriculas de 3x3 de una matriz son validas, que no 
    //contienen numeros repetidos del 1 al 9
    private static boolean validarSubCuadriculas(int[][] matriz) {
       //Recorre las filas de la matriz en pasos de 3
        for (int fila = 0; fila < 9; fila += 3) {
            //recorre las columnas de la matriz en pasos de 3
            for (int columna = 0; columna < 9; columna += 3) {
                boolean[] numeros = new boolean[9]; //--> crea un array booleano para rastrear los numeros del 1 al 9
                //recorre las filas de la subcuadricula 3x3
                for (int i = 0; i < 3; i++) {
                    //recorre las columnas de la subcuadricula 3x3
                    for (int j = 0; j < 3; j++) {
                        int valor = matriz[fila + i][columna + j];// y aca obtiene el valor de la celda actual
                        //Si el valor no es 0 es celda vacia
                        if (valor != 0) {
                            //y si el numero ya ha sido encontrado en la subcuadricula, retorna false
                            if (numeros[valor - 1]) {
                                return false;
                            }
                            // y aqui marca el numero como encontrado
                            numeros[valor - 1] = true;
                        }
                    }
                }
            }
        }
        // y si todas las subcuadriculas son validas, retorn true
        return true;
    }
}
