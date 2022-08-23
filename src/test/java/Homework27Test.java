import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class Homework27Test {
    static final Logger userLogger = LogManager.getLogger(Homework27Test.class);

    private WebDriver driver;

    @Test
    public void test_1() {
        userLogger.info("Начало теста 1");
        var login = System.getProperty("login");
        var password = System.getProperty("password");
        driver = ConfigWebDriver.getDriver();
        driver.manage().window().maximize();
        driver.get("https://otus.ru");
        driver.findElement(By.cssSelector("button.header2__auth")).click();
        Util.waitSecond(1);

        var element = driver.findElement(By.xpath("//form[@action = '/login/']//input[@name = 'email']"));
        element.clear();
        element.sendKeys(login);

        element = driver.findElement(By.xpath("//form[@action = '/login/']//input[@name = 'password']"));
        element.clear();
        element.sendKeys(password);

        driver.findElement(By.xpath("//form[@action = '/login/']//button[@type = 'submit']")).submit();

        Util.waitSecond(1);
        driver.get("https://otus.ru/lk/biography/personal/");
        Util.waitSecond(1);
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

        driver.findElement(By.xpath("//div[@data-slave-selector='.js-lk-cv-dependent-slave-city']")).click();
        driver.findElement(By.xpath("//button[@title='Украина']")).click();

        Util.waitSecond(3);

        driver.findElements(By.xpath("//div[@data-selected-option-class='lk-cv-block__select-option_selected']")).get(1).click();
        driver.findElement(By.xpath("//button[@title='Мариуполь']")).click();

        driver.findElements(By.xpath("//div[@data-selected-option-class='lk-cv-block__select-option_selected']")).get(2).click();
        driver.findElement(By.xpath("//button[@title='Начальный уровень (Beginner)']")).click();

        driver.findElements(By.xpath("//span[@class='radio__label']"))
                .get(1)
                .click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[3]/div[2]/div[2]/div/form/div[1]/div[3]/div[1]/div/div[1]/div[5]/div[2]/div[1]/div[2]/label/span"))
                .click();

        if (!driver.findElement(By.xpath("//*[@id='id_is_email_preferable']"))
                .getAttribute("checked").equalsIgnoreCase("true")) {
            driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[3]/div[2]/div[2]/div/form/div[1]/div[3]/div[2]/div[1]/div[2]/div/div[2]/div[2]/label/span"))
                    .click();
        }

        driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[3]/div[2]/div[2]/div/form/div[1]/div[3]/div[2]/div[2]/div/div/div[1]/div/div/div"))
                .click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[3]/div[2]/div[2]/div/form/div[1]/div[3]/div[2]/div[2]/div/div/div[1]/div/div/div/div/div/button[5]"))
                .click();
        element = driver.findElement(By.xpath("//*[@id='id_contact-0-value']"));
        element.clear();
        element.sendKeys("test@mail.com");

        driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[3]/div[2]/div[2]/div/form/div[1]/div[3]/div[2]/div[2]/button"))
                .click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[3]/div[2]/div[2]/div/form/div[1]/div[3]/div[2]/div[2]/div/div[2]/div[1]/div/div/div/label/div"))
                .click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[3]/div[2]/div[2]/div/form/div[1]/div[3]/div[2]/div[2]/div/div[2]/div[1]/div/div/div/div/div/button[3]"))
                .click();
        element = driver.findElement(By.xpath("//*[@id='id_contact-1-value']"));
        element.clear();
        element.sendKeys("vk.com/test");

        driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[3]/div[2]/div[2]/div/form/div[1]/div[4]/div[1]/div[1]/div"))
                .click();
        driver.findElement(By.xpath("//*[@id='id_gender']/option[3]"))
                .click();

        element = driver.findElement(By.xpath("//*[@id='id_company']"));
        element.clear();
        element.sendKeys("SIS");

        element = driver.findElement(By.xpath("//*[@id='id_work']"));
        element.clear();
        element.sendKeys("qa engineer");

        driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[3]/div[2]/div[2]/div/form/div[2]/div/div/button[1]"))
                .click();
        userLogger.info("Конец теста 1");
    }

    @Test
    public void test_2() {
        userLogger.info("Начало теста 2");
        var login = System.getProperty("login");
        var password = System.getProperty("password");
        driver = ConfigWebDriver.getDriver();
        driver.manage().window().maximize();
        driver.get("https://otus.ru");
        driver.findElement(By.cssSelector("button.header2__auth")).click();
        Util.waitSecond(1);

        var element = driver.findElement(By.xpath("//form[@action = '/login/']//input[@name = 'email']"));
        element.clear();
        element.sendKeys(login);

        element = driver.findElement(By.xpath("//form[@action = '/login/']//input[@name = 'password']"));
        element.clear();
        element.sendKeys(password);

        driver.findElement(By.xpath("//form[@action = '/login/']//button[@type = 'submit']")).submit();

        Util.waitSecond(1);
        driver.get("https://otus.ru/lk/biography/personal/");
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
        text = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[3]/div[2]/div[2]/div/form/div[1]/div[1]/div/div[4]/div/div/input"))
                .getAttribute("value");
        assertThat(text).as("Date").isEqualTo("02.02.2002");
        text = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[3]/div[2]/div[2]/div/form/div[1]/div[3]/div[1]/div/div[1]/div[1]/div[2]/div/label/div"))
                .getText();
        assertThat(text).as("Country").isEqualTo("Украина");
        text = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[3]/div[2]/div[2]/div/form/div[1]/div[3]/div[1]/div/div[1]/div[2]/div[2]/div/label/div"))
                .getText();
        assertThat(text).as("City").isEqualTo("Мариуполь");
        text = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[3]/div[2]/div[2]/div/form/div[1]/div[3]/div[1]/div/div[1]/div[3]/div[2]/div/label/div"))
                .getText();
        assertThat(text).as("City").isEqualTo("Начальный уровень (Beginner)");
        text = driver.findElement(By.xpath("//*[@id='id_ready_to_relocate_1']"))
                .getAttribute("value");
        assertThat(text).as("Checkbox").isEqualTo("True");
        text = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[3]/div[2]/div[2]/div/form/div[1]/div[3]/div[1]/div/div[1]/div[5]/div[2]/div[1]/div[2]/label/input"))
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
        text = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[3]/div[2]/div[2]/div/form/div[1]/div[3]/div[2]/div[2]/div/div[1]/div[1]/div/div/div/label/div"))
                .getText();
        assertThat(text).as("Skype").isEqualTo("Skype");
        text = driver.findElement(By.xpath("//*[@id='id_contact-1-value']"))
                .getAttribute("value");
        assertThat(text).as("VK").isEqualTo("vk.com/test");
        text = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[3]/div[2]/div[2]/div/form/div[1]/div[3]/div[2]/div[2]/div/div[2]/div[1]/div/div/div/label/div"))
                .getText();
        assertThat(text).as("VK").isEqualTo("VK");
        text = driver.findElement(By.xpath("//*[@id=\"id_gender\"]/option[3]"))
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
        driver.quit();
    }
}
