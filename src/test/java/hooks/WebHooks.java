package hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.aeonbits.owner.ConfigFactory;
import utils.EnterConstants;

/**
 * Класс с настройками драйвера.
 * */
public class WebHooks {
    private EnterConstants props = ConfigFactory.create(EnterConstants.class);

    @Before()
    public void setDriverFromProps() {
        //Подключаем драйвер
        String webDriverLocation = ConfigFactory.create(EnterConstants.class).webdriver();
        //Следуем по условию запуска на selenoid, есть строка в проперти закомменчена то запуск на локальном драйвере
        if (props.remoteUrl() != null)
            Configuration.remote = props.remoteUrl();
        //Указание selenide с каким браузером работать и с каким драйвером, фуллскрин драйвера
        //Нужно это только если не интернета. Selenide сам из интернета
        if(webDriverLocation != null){
            System.setProperty("webdriver.chrome.driver", webDriverLocation);
            System.setProperty("selenide.browser","Chrome");
            Configuration.startMaximized = true;
        }
    }

    @After
    public void driverClose() {
        WebDriverRunner.closeWebDriver();
    }
}
