package br.ce.wcaquino.taskbackend.utils;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;


public class DateUtilsTest {
	
	@Test
	public void deveRetornarTrueParaDatasFuturas() {
		LocalDate date = LocalDate.of(2030, 02, 02);
		Assert.assertTrue(DateUtils.isEqualOrFutureDate(date));
		
	}
	
	@Test
	public void deveRetornarfalseParaDatasPassadas() {
		LocalDate date = LocalDate.of(2010, 02, 02);
		Assert.assertFalse(DateUtils.isEqualOrFutureDate(date));
		
	}
	
	@Test
	public void deveRetornaTrueParaDataAtual() {
		LocalDate date = LocalDate.now();
		Assert.assertTrue(DateUtils.isEqualOrFutureDate(date));
		
	}
 
}
