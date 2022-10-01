package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FechaUtil {

	public static String getFechaActualYYYYMMdd() {
		Date fecha = new Date(); //Fecha Actual
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(fecha);
	}
	
	public static String getFechaActualddMMyyyy() {
		Date fecha = new Date(); //Fecha Actual
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		return sdf.format(fecha);
	}
	
	public static String getFechaPrimeroEneroYYYYMMdd() {
		Date fechaActual = new Date();
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fechaActual);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.MONTH, Calendar.JANUARY);
	
		Date fechaModificada = calendar.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(fechaModificada);
	}
	
	public static String getFechaUltimoDiciembreYYYYMMdd() {
		Date fechaActual = new Date();
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fechaActual);
		calendar.set(Calendar.DAY_OF_MONTH, 31);
		calendar.set(Calendar.MONTH, Calendar.DECEMBER);
	
		Date fechaModificada = calendar.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(fechaModificada);
	}
	
	//La fecha dos no es superior a la fecha uno
	public static boolean isNotSuperiorFechaYYYYMMdd(String fecUno, String fecDos) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dateUno = sdf.parse(fecUno);
			Date dateDos = sdf.parse(fecDos);
			return dateDos.before(dateUno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean isNotSuperiorSeisMesesFechaYYYYMMdd(String fecUno, String fecDos) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dateUno = sdf.parse(fecUno);
			Date dateDos = sdf.parse(fecDos);
			
			//Aumentar la fecha 1 en seis meses (180 días)
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dateUno);
			int diasAnio = calendar.get(Calendar.DAY_OF_YEAR);
			calendar.set(Calendar.DAY_OF_YEAR, diasAnio + 180);
			Date  dateAumentado = calendar.getTime();
			
			System.out.println(sdf.format(dateAumentado));
			return dateAumentado.before(dateDos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
