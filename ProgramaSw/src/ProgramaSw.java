/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author Diana Pozo
 * @version 1.0 15/12/2018
 */
public class ProgramaSw {

    static PrintStream o;

    public static void main(String[] args) throws FileNotFoundException {
        int a, m, d, opcion, nT, band, band2;
        band = 0;
        band2 = 1;
        Scanner lee = new Scanner(System.in);
        ProgramaSw objeto = new ProgramaSw();
        o = new PrintStream(new File("dianapozoSw.txt"));
        objeto.guardarArchivo("******************** BIENVENIDOS *******************", band);
        objeto.guardarArchivo("A continuación se muestra los ejemplos simples", band);
        objeto.guardarArchivo("1.- Calcular la edad de una persona", band);
        objeto.guardarArchivo("2.- Generar los términos de una serie de números", band);

        objeto.guardarArchivo("Seleccione una opción: ", band);
        opcion = lee.nextInt();
        objeto.guardarArchivo(String.valueOf(opcion), band2);
        switch (opcion) {
            case 1:
                objeto.guardarArchivo("Ingrese el año de nacimiento:", band);
                a = lee.nextInt();
                objeto.guardarArchivo(String.valueOf(a), band2);
                objeto.guardarArchivo("Ingrese el mes de nacimiento:", band);
                m = lee.nextInt();
                objeto.guardarArchivo(String.valueOf(m), band2);
                objeto.guardarArchivo("Ingrese el dia de nacimiento:", band);
                d = lee.nextInt();
                objeto.guardarArchivo(String.valueOf(d), band2);
                objeto.guardarArchivo(" *La edad que tiene es: " + calcularEdad(new GregorianCalendar(a, m, d)) + " años", band);
                break;
            case 2:
                objeto.guardarArchivo("Ingrese el número de términos que desea generar para la serie", band);
                nT = lee.nextInt();
                serieFibonaci(nT);
                objeto.guardarArchivo(String.valueOf(nT), band2);
                break;
            default:
                objeto.guardarArchivo("Opción inválida\n", band);
                break;
        }

    }

    public static int calcularEdad(Calendar fechaNac) {
        int anio, mes, dia;
        Calendar hoy = Calendar.getInstance();
        anio = hoy.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);
        mes = hoy.get(Calendar.MONTH) - fechaNac.get(Calendar.MONTH);
        dia = hoy.get(Calendar.DAY_OF_MONTH) - fechaNac.get(Calendar.DAY_OF_MONTH);

        /**
         * Comprueba si el dia del cumpleaños es posterior a la fecha actual
         */
        if (mes < 0 || (mes == 0 && dia < 0)) {
            anio = anio - 1;
        }
        return anio;
    }

    public static void serieFibonaci(int numTerminos) {
        int n1, n2, contador, termino;
        n1 = -1;
        n2 = 1;
        ProgramaSw obj = new ProgramaSw();
        obj.guardarArchivo("La serie esta formada por: ", 0);
        for (contador = 0; contador < numTerminos; contador++) {
            termino = n1 + n2;
            obj.guardarArchivo(termino + " ", 0);
            n1 = n2;
            n2 = termino;
        }
    }

    public void guardarArchivo(String mensaje, int band) {
        if (band == 0) {
            PrintStream console = System.out;
            System.setOut(o);
            System.out.println(mensaje);
            System.setOut(console);
            System.out.println(mensaje);
        } else if (band == 1) {
            PrintStream console = System.out;
            System.setOut(o);
            System.out.println(mensaje);
            System.setOut(console);
        }
    }
}
