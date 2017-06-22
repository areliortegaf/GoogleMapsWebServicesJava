/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asortega.mavenwebservices;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import org.joda.time.DateTime;

/**
 *
 * @author asortega
 */
public class AsignarFecha {

    //Fields
    //ASIGNAR FECHAS
    Month mes;
    int vAno;
    int vDia;
    int vHoras;
    int vMinutos;

    //EL TIPO QUE DEBE REGRESA ES DATETIME DEL PAQUETE JODA
    public DateTime asignarHoraDeSalida(int pAno, String pMes, int pDia, int pHora, int pMinutos) {

        //Empezamos validadndo el mes
        if (pMes.equalsIgnoreCase("enero")) {
            this.mes = Month.JANUARY;
        } else if (pMes.equalsIgnoreCase("febrero")) {
            this.mes = Month.FEBRUARY;
        } else if (pMes.equalsIgnoreCase("marzo")) {
            this.mes = Month.MARCH;
        } else if (pMes.equalsIgnoreCase("abril")) {
            this.mes = Month.APRIL;
        } else if (pMes.equalsIgnoreCase("mayo")) {
            this.mes = Month.MAY;
        } else if (pMes.equalsIgnoreCase("junio")) {
            this.mes = Month.JUNE;
        } else if (pMes.equalsIgnoreCase("julio")) {
            this.mes = Month.JULY;
        } else if (pMes.equalsIgnoreCase("agosto")) {
            this.mes = Month.AUGUST;
        } else if (pMes.equalsIgnoreCase("septiembre")) {
            this.mes = Month.SEPTEMBER;
        } else if (pMes.equalsIgnoreCase("octubre")) {
            this.mes = Month.OCTOBER;
        } else if (pMes.equalsIgnoreCase("noviembre")) {
            this.mes = Month.NOVEMBER;
        } else if (pMes.equalsIgnoreCase("diciembre")) {
            this.mes = Month.DECEMBER;
        } else {
            System.out.println("El mes que ingreso es invalido");
            LocalDate ahora = LocalDate.now();//Obtiene la fecha actual
            mes = ahora.getMonth();//Toma el mes en curso
        }
        //SE VALIDA EL AÑO
        this.vAno = pAno;
        int tamanoAno = String.valueOf(vAno).length();//valida que sea un numero de cuatro digitos
        int primerDigito = Integer.parseInt(Integer.toString(vAno).substring(0, 1));//valida que sea de laño 2000
        if (tamanoAno != 4) {
            System.out.println("El año debe contener 4 digitos");
            LocalDate ahora = LocalDate.now();//Obtiene la fecha actual
            vAno = ahora.getYear();// Asigna a la variable año, el año actual
        }
        if (primerDigito != 2) {
            System.out.println("Ingrese una fecha valida");
            LocalDate ahora = LocalDate.now();//Obtiene la fecha actual
            vAno = ahora.getYear();// Asigna a la variable año, el año actual
        }

        //SE VALIDA EL DIA
        if (mes == Month.JANUARY) {
            if (pDia <= 0 || pDia > 31) {
                System.out.println("Ingrese un dia valido");
                LocalDate ahora = LocalDate.now();
                this.vDia = ahora.getDayOfMonth();
            } else {
                this.vDia = pDia;
            }
        } else if (mes == Month.FEBRUARY) {
            if (pDia <= 0 || pDia > 28) {
                System.out.println("Ingrese un dia valido");
                LocalDate ahora = LocalDate.now();
                this.vDia = ahora.getDayOfMonth();
            } else {
                this.vDia = pDia;
            }
        } else if (mes == Month.MARCH) {
            if (pDia <= 0 || pDia > 31) {
                System.out.println("Ingrese un dia valido");
                LocalDate ahora = LocalDate.now();
                this.vDia = ahora.getDayOfMonth();
            } else {
                this.vDia = pDia;
            }
        } else if (mes == Month.APRIL) {
            if (pDia <= 0 || pDia > 30) {
                System.out.println("Ingrese un dia valido");
                LocalDate ahora = LocalDate.now();
                this.vDia = ahora.getDayOfMonth();
            } else {
                this.vDia = pDia;
            }
        } else if (mes == Month.MAY) {
            if (pDia <= 0 || pDia > 31) {
                System.out.println("Ingrese un dia valido");
                LocalDate ahora = LocalDate.now();
                this.vDia = ahora.getDayOfMonth();
            } else {
                this.vDia = pDia;
            }
        } else if (mes == Month.JUNE) {
            if (pDia <= 0 || pDia > 30) {
                System.out.println("Ingrese un dia valido");
                LocalDate ahora = LocalDate.now();
                this.vDia = ahora.getDayOfMonth();
            } else {
                this.vDia = pDia;
            }
        } else if (mes == Month.JULY) {
            if (pDia <= 0 || pDia > 31) {
                System.out.println("Ingrese un dia valido");
                LocalDate ahora = LocalDate.now();
                this.vDia = ahora.getDayOfMonth();
            } else {
                this.vDia = pDia;
            }
        } else if (mes == Month.AUGUST) {
            if (pDia <= 0 || pDia > 31) {
                System.out.println("Ingrese un dia valido");
                LocalDate ahora = LocalDate.now();
                this.vDia = ahora.getDayOfMonth();
            } else {
                this.vDia = pDia;
            }
        } else if (mes == Month.SEPTEMBER) {
            if (pDia <= 0 || pDia > 30) {
                System.out.println("Ingrese un dia valido");
                LocalDate ahora = LocalDate.now();
                this.vDia = ahora.getDayOfMonth();
            } else {
                this.vDia = pDia;
            }
        } else if (mes == Month.OCTOBER) {
            if (pDia <= 0 || pDia > 31) {
                System.out.println("Ingrese un dia valido");
                LocalDate ahora = LocalDate.now();
                this.vDia = ahora.getDayOfMonth();
            } else {
                this.vDia = pDia;
            }
        } else if (mes == Month.NOVEMBER) {
            if (pDia <= 0 || pDia > 30) {
                System.out.println("Ingrese un dia valido");
                LocalDate ahora = LocalDate.now();
                this.vDia = ahora.getDayOfMonth();
            } else {
                this.vDia = pDia;
            }
        } else if (mes == Month.DECEMBER) {
            if (pDia <= 0 || pDia > 31) {
                System.out.println("Ingrese un dia valido");
                LocalDate ahora = LocalDate.now();
                this.vDia = ahora.getDayOfMonth();
            } else {
                this.vDia = pDia;
            }
        }
        //SE VALIDA LA HORA
        this.vHoras = pHora;
        if (vHoras < 0 || vHoras >= 24) {
            System.out.println("Ingrese una hora valida");
            LocalDateTime ahora = LocalDateTime.now();
            int calcularHora = (ahora.getHour()) + 1;
            this.vHoras = calcularHora;
        } else {
            this.vHoras = pHora;
        }

        //SE VALIDAN LOS MUNUTOS
        this.vMinutos = pMinutos;
        if (vMinutos < 0 || vMinutos > 60) {
            System.out.println("Ingrese los minutos correctamente");
            LocalDateTime ahora = LocalDateTime.now();
            int calcularMinutos = (ahora.getMinute()) + 1;
            this.vMinutos = 00;
        } else {
            this.vMinutos = pMinutos;
        }
        //
        //VALIDAR SI LOS DATOS SON NULOS
        //

        //
        //OBTIENE TODOS LOS DATOS Y ARMA LA FECHA
        //
        //Paso 1 se obtiene la fecha en LocalDateTime
        LocalDateTime tiempoJava8 = LocalDateTime.of(this.vAno, this.mes, this.vDia, this.vHoras, this.vMinutos);
        //paso 2 se obtiene por zona
        java.time.ZonedDateTime tiempoJava8zona = tiempoJava8.atZone(ZoneId.systemDefault());
        // paso 3 se obtiene el instant
        java.time.Instant java8Instant = tiempoJava8zona.toInstant();
        //paso 4 millis
        long millis = java8Instant.toEpochMilli();
        //paso 5 se combierte a joda
        org.joda.time.LocalDateTime jodaLocalDateTime = new org.joda.time.LocalDateTime(millis);
        //se regresa

        DateTime x = jodaLocalDateTime.toDateTime();

        return x;

    }
//los getters

    public int traerAno() {
        return this.vAno;
    }

    public Month traerMes() {
        return this.mes;
    }

    public int traerDia() {
        return this.vDia;
    }

    public int traerHora() {
        return this.vHoras;
    }

    public int traerMinutos() {
        return this.vMinutos;
    }

    public AsignarFecha() {
        //prueba del tiempo
        //DateTime vTiempo = asignarHoraDeSalida(0,"eneda",40,90,120);
        //System.out.println("Fecha: " + vTiempo);
    }

}
