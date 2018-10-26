package com.alona.autotest.facebook;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;

public class FacebookFriendsTest {
	@BeforeClass
	public static void setup() {
		//Настраиваем запуск тестов в хроме
		System.setProperty("webdriver.chrome.driver", "YOUR_PATH_TO_CHROME_DRIVER/chromedriver.exe");
		Configuration.browser = "chrome";
	}

	@Test
	public void countFacebookFriends() {
		//Логинимся и заходим на страницу с друзьями
		loginAndOpenFriendsTab();

		int friendsCount;
		//Считаем количество друзей на странице
		int friendsCountAfterScroll = $$("[data-testid=friend_list_item]").size();
		//Делаем в цикле пока количество друзей не перестанет увеличиваться
		do {
			//Запоминаем количество друзей до скролла
			friendsCount = friendsCountAfterScroll;
			//Скроллим страницу вниз
			executeJavaScript("window.scrollBy(0,3000)");
			//Ждём пока пропадёт индикатор загрузки
			$(".async_saving").shouldBe(Condition.not(Condition.visible));
			//Считаем количество друзей на странице
			friendsCountAfterScroll = $$("[data-testid=friend_list_item]").size();
		} while (friendsCount != friendsCountAfterScroll);
		System.out.println("Friends count: " + friendsCount);
	}

	private void loginAndOpenFriendsTab() {
		open("https://www.facebook.com");
		$("#login_form #email").setValue("YOUR_LOGIN");
		$("#login_form #pass").setValue("YOUR_PASSWORD");
		$("#loginbutton").click();
		open("https://www.facebook.com/profile.php?id=100008280639481&sk=friends");
	}
}