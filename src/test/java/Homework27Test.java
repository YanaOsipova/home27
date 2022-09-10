import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Homework27Test {
    static final Logger userLogger = LogManager.getLogger(Homework27Test.class);

    private WebDriver driver;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    @Order(1)
    public void testFieldFilling() {
        userLogger.info("Начало теста 1");
        var login = System.getProperty("login");
        var password = System.getProperty("password");
        driver = ConfigWebDriver.getDriver();
        driver.manage().window().maximize();
        var webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(3L));
        driver.get("https://otus.ru");
        driver.findElement(By.cssSelector("button.header2__auth")).click();

        var form = webDriverWait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@action = '/login/']")));
        var element = form.findElement(By.xpath(".//input[@name = 'email']"));
        element.clear();
        element.sendKeys(login);
        element = form.findElement(By.xpath(".//input[@name = 'password']"));
        element.clear();
        element.sendKeys(password);
        form.findElement(By.xpath(".//button[@type = 'submit']")).submit();

        var action = new Actions(driver);
        form = webDriverWait
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.cssSelector("div.header2-menu__item.header2__right__menu__item.header2-menu__item_small.header2-menu__item_dropdown.header2-menu__item_dropdown_no-border")));
        action.moveToElement(form).perform();
        webDriverWait
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.cssSelector("a[title='Личный кабинет']")))
                .click();
        webDriverWait
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.cssSelector("a[title='О себе']"))).click();

        element = driver.findElement(By.id("id_fname"));
        element.clear();
        element.sendKeys("Тест");

        element = driver.findElement(By.id("id_fname_latin"));
        element.clear();
        element.sendKeys("Test");

        element = driver.findElement(By.id("id_lname"));
        element.clear();
        element.sendKeys("Тестов");

        element = driver.findElement(By.id("id_lname_latin"));
        element.clear();
        element.sendKeys("Testov");

        element = driver.findElement(By.id("id_blog_name"));
        element.clear();
        element.sendKeys("TestBlogov");

        element = driver.findElement(By.xpath("//input[@name='date_of_birth']"));
        element.clear();
        element.sendKeys("02.02.2002");

        driver.findElement(By.xpath("//div[@data-slave-selector='.js-lk-cv-dependent-slave-city']"))
                .click();
        webDriverWait
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//button[@title='Украина']")))
                .click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='placeholder']")))
                .click();
        webDriverWait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//button[@title='Мариуполь']")))
                .click();
        driver.findElements(By.xpath("//div[@data-selected-option-class='lk-cv-block__select-option_selected']")).get(2).click();
        driver.findElement(By.xpath("//button[@title='Начальный уровень (Beginner)']")).click();

        driver.findElements(By.xpath("//span[@class='radio__label']"))
                .get(1)
                .click();

        if (!driver.findElement(By.xpath("//input[@title='Полный день' and @checked]")).getAttribute("checked").equalsIgnoreCase("true")) {
            driver.findElement(By.xpath("//span[contains(text(), 'Полный день')]"))
                    .click();
        }
        if (!driver.findElement(By.xpath("//*[@id='id_is_email_preferable']"))
                .getAttribute("checked").equalsIgnoreCase("true")) {
            driver.findElements(By.xpath("//span[contains(text(), 'Предпочтительный способ связи')]"))
                    .get(0)
                    .click();
        }
        var elements = driver.findElements(By.xpath("//button[contains(text(), 'Удалить')]"));
        for (int i = 1; i < elements.size(); i += 2) {
            elements.get(i).click();
        }
        driver.findElement(By.xpath("//button[contains(text(), 'Добавить')]"))
                .click();
        driver.findElement(By.xpath("//span[contains(text(), 'Способ связи')]"))
                .click();
        driver.findElements(By.xpath("//button[contains(text(), 'Skype')]")).get(2).click();
        element = driver.findElement(By.xpath("//*[@id='id_contact-2-value']"));
        element.sendKeys("test@mail.com");

        driver.findElement(By.xpath("//button[contains(text(), 'Добавить')]"))
                .click();
        driver.findElement(By.xpath("//span[contains(text(), 'Способ связи')]"))
                .click();
        driver.findElements(By.xpath("//button[contains(text(), 'VK')]")).get(3).click();
        element = driver.findElement(By.xpath("//*[@id='id_contact-3-value']"));
        element.sendKeys("vk.com/onaosipova");

        driver.findElement(By.xpath("//div[@class='select select_full']"))
                .click();
        driver.findElement(By.xpath("//*[@id='id_gender']/option[@value='f']"))
                .click();

        element = driver.findElement(By.xpath("//*[@id='id_company']"));
        element.clear();
        element.sendKeys("SIS");

        element = driver.findElement(By.xpath("//*[@id='id_work']"));
        element.clear();
        element.sendKeys("qa engineer");

        driver.findElement(By.xpath("//button[@title='Сохранить и продолжить']"))
                .click();
        userLogger.info("Конец теста 1");
    }

    @Test
    @Order(2)
    public void testCheckingFields() {
        userLogger.info("Начало теста 2");
        var login = System.getProperty("login");
        var password = System.getProperty("password");
        driver = ConfigWebDriver.getDriver();
        driver.manage().window().maximize();
        var webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(3L));
        driver.get("https://otus.ru");
        driver.findElement(By.cssSelector("button.header2__auth")).click();

        var form = webDriverWait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@action = '/login/']")));
        var element = form.findElement(By.xpath(".//input[@name = 'email']"));
        element.clear();
        element.sendKeys(login);
        element = form.findElement(By.xpath(".//input[@name = 'password']"));
        element.clear();
        element.sendKeys(password);
        form.findElement(By.xpath(".//button[@type = 'submit']")).submit();

        var action = new Actions(driver);
        form = webDriverWait
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.cssSelector("div.header2-menu__item.header2__right__menu__item.header2-menu__item_small.header2-menu__item_dropdown.header2-menu__item_dropdown_no-border")));
        action.moveToElement(form).perform();
        webDriverWait
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.cssSelector("a[title='Личный кабинет']")))
                .click();
        webDriverWait
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.cssSelector("a[title='О себе']"))).click();

        var text = driver.findElement(By.id("id_fname")).getAttribute("value");
        assertThat(text).as("Name").isEqualTo("Тест");
        text = driver.findElement(By.id("id_fname_latin")).getAttribute("value");
        assertThat(text).as("Name(Latin)").isEqualTo("Test");
        text = driver.findElement(By.id("id_lname")).getAttribute("value");
        assertThat(text).as("Last Name").isEqualTo("Тестов");
        text = driver.findElement(By.id("id_lname_latin")).getAttribute("value");
        assertThat(text).as("Last Name(Latin)").isEqualTo("Testov");
        text = driver.findElement(By.id("id_blog_name")).getAttribute("value");
        assertThat(text).as("Last Name(Latin)").isEqualTo("TestBlogov");
        text = driver.findElement(By.xpath("//input[@name='date_of_birth']"))
                .getAttribute("value");
        assertThat(text).as("Date").isEqualTo("02.02.2002");
        text = driver.findElement(By.xpath("//input[@name='country']"))
                .getAttribute("value");
        assertThat(text).as("Country").isEqualTo("4");
        text = driver.findElement(By.xpath("//input[@data-title='Город']"))
                .getAttribute("value");
        assertThat(text).as("City").isEqualTo("87");
        text = driver.findElement(By.xpath("//input[@data-title='Уровень знания английского языка']"))
                .getAttribute("value");
        assertThat(text).as("City").isEqualTo("1");
        text = driver.findElement(By.xpath("//*[@id='id_ready_to_relocate_1']"))
                .getAttribute("value");
        assertThat(text).as("Checkbox").isEqualTo("True");
        text = driver.findElement(By.xpath("//input[@title='Полный день']"))
                .getAttribute("checked");
        assertThat(text).as("Checkbox").isEqualTo("true");
        text = driver.findElement(By.xpath("//*[@id='id_email']"))
                .getAttribute("value");
        assertThat(text).as("email").isEqualTo("ya.osipova.sis+1@gmail.com");
        text = driver.findElement(By.xpath("//*[@id='id_is_email_preferable']"))
                .getAttribute("checked");
        assertThat(text).as("Checkbox").isEqualTo("true");

        text = driver.findElement(By.xpath("//*[@id='id_contact-0-value']"))
                .getAttribute("value");
        assertThat(text).as("Skype").isEqualTo("test@mail.com");
        text = driver.findElement(By.xpath("//input[@value='skype']"))
                .getAttribute("value");
        assertThat(text).as("Skype").isEqualTo("skype");

        text = driver.findElement(By.xpath("//*[@id='id_contact-1-value']"))
                .getAttribute("value");
        assertThat(text).as("VK").isEqualTo("vk.com/onaosipova");
        text = driver.findElement(By.xpath("//input[@value='vk']"))
                .getAttribute("value");
        assertThat(text).as("VK").isEqualTo("vk");

        text = driver.findElement(By.xpath("//*[@id='id_gender']/option[@value='f']"))
                .getAttribute("selected");
        assertThat(text).as("checkbox").isEqualTo("true");
        text = driver.findElement(By.xpath("//*[@id='id_company']"))
                .getAttribute("value");
        assertThat(text).as("Company").isEqualTo("SIS");
        text = driver.findElement(By.xpath("//*[@id='id_work']"))
                .getAttribute("value");
        assertThat(text).as("Work").isEqualTo("qa engineer");
        userLogger.info("Конец теста 2");
    }

    @AfterEach
    public void close() {
        userLogger.info("Закрытие драйвера");
        if (driver != null) {
            driver.quit();
        }
    }
}
