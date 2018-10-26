package com.alona.autotest.facebook;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ArdasSiteTest {
	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", "F:\\Anton\\programs\\chromedriver\\chromedriver.exe");
		Configuration.browser = "chrome";
	}

	@Test
	public void ardasImagesCountShouldBe12() {
		open("https://ardas-it.com/");
		int imagesCount = $$(".work-image").size();
		assertThat("Checking images count", imagesCount, is(12));
	}

	@Test
	public void bringDetailsImagesCountShouldBe4() {
		open("https://ardas-it.com/");
		$(".page-button[href=\"/fail-to-plan-plan-to-fail\"]").click();
		SelenideElement bringDetailsContainer = $$(".section-container").get(2);
		int imgCount = bringDetailsContainer.$$("img").size();
		assertThat("Checking bring details images", imgCount, is(4));
	}

}
