package com.exemplo.ios.core;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class DriverFactory {

	private static IOSDriver<?> driver;

	public static IOSDriver<?> getDriver() {
		if (driver == null) {
			conectar();
		}
		return driver;
	}

	@BeforeAll
	private static IOSDriver<?> conectar() {
		File diretorioAplicacao = new File("app");
		File arquivoAplicacao = new File(diretorioAplicacao, "SimpleCalculator.app");

		DesiredCapabilities capacidade = new DesiredCapabilities();

		capacidade.setCapability("deviceName", "iPhone 13");
		capacidade.setCapability("platformVersion", "15.4");
		capacidade.setCapability("platformName", "iOS");
		capacidade.setCapability("app", arquivoAplicacao.getAbsolutePath());
		capacidade.setCapability("automationName", "XCUITest");
		capacidade.setCapability("newCommandTimeout", 5600);

		try {
			driver = new IOSDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capacidade);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;
	}

	@AfterAll
	private static void encerrarDriver() {
		try {
			
			driver.quit();
		} catch (Exception ign) {
		}
	}

}
