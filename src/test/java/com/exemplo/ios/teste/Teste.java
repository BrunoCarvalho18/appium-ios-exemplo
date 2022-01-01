package com.exemplo.ios.teste;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.exemplo.ios.core.DriverFactory;
import static org.junit.jupiter.api.Assertions.assertEquals;
import io.appium.java_client.MobileBy;

@DisplayName("Suite de testes para realizar a soma")
public class Teste {
	
	private String resultado;
	
	@DisplayName("Teste para realizar a soma")
	@Test
	public void somarNumeros() {
		DriverFactory.getDriver().findElement(MobileBy.AccessibilityId("apple_first_input")).sendKeys("1");
		DriverFactory.getDriver().findElement(MobileBy.AccessibilityId("apple_second_input")).sendKeys("2");
		DriverFactory.getDriver().findElement(MobileBy.AccessibilityId("apple-sum-button")).click();
		
		resultado = DriverFactory.getDriver().findElement(MobileBy.AccessibilityId("apple_result_text")).getText();
		assertEquals(resultado, "3");
		

	}
}
