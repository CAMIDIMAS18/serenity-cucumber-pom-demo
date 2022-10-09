package com.automation.practice.demo;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.annotations.CastMember;
import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SerenityJUnit5Extension.class)
class WhenBuyingProductTest {

    @Managed()
    WebDriver driver;

    @CastMember(name = "Wendy")
    Actor wendy;

    @Test
    @DisplayName("Test: Comprando un producto en la tienda")
    void buyProductInTheStore() throws InterruptedException {
        driver.get("http://automationpractice.com/index.php");
        WebElement buttonSingIn = driver.findElement(By.cssSelector("a[title='Log in to your customer account']"));
        buttonSingIn.click();

        WebElement inputEmail = driver.findElement(By.cssSelector("#email"));
        inputEmail.sendKeys("dimas18@gmail.com");

        WebElement inputPassword = driver.findElement(By.cssSelector("#passwd"));
        inputPassword.sendKeys("H7BYKP@swG7Md@d");

        WebElement buttonSubmitLogin = driver.findElement(By.cssSelector("#SubmitLogin"));
        buttonSubmitLogin.click();

        WebElement tabTshirts = driver.findElement(By.xpath("(//a[@title='T-shirts'][normalize-space()='T-shirts'])[2]"));
        tabTshirts.click();

        //Action de mover el mouse sobre el elemento
        Actions actions = new Actions(driver);
        WebElement imgProduct = driver.findElement(By.cssSelector("img[title='Faded Short Sleeve T-shirts']"));
        WebElement buttonAddToCard = driver.findElement(By.cssSelector("a[title='Add to cart']"));
        actions.moveToElement(imgProduct).moveToElement(buttonAddToCard).click().build().perform();

        WebElement buttonProceedCheckout = driver.findElement(By.cssSelector("a[title='Proceed to checkout']"));
        buttonProceedCheckout.click();

        WebElement buttonCheckout = driver.findElement(By.cssSelector(".button.btn.btn-default.standard-checkout.button-medium"));
        buttonCheckout.click();

        WebElement buttonProcessAddress = driver.findElement(By.cssSelector("button[name='processAddress']"));
        buttonProcessAddress.click();

        WebElement checkBoxTermsService = driver.findElement(By.cssSelector("#cgv"));
        checkBoxTermsService.click();

        WebElement buttonProcessCarrier = driver.findElement(By.cssSelector("button[name='processCarrier']"));
        buttonProcessCarrier.click();

        WebElement buttonPayByCheck = driver.findElement(By.cssSelector("a[title='Pay by check.']"));
        buttonPayByCheck.click();

        WebElement buttonConfirmOrder = driver.findElement(By.cssSelector("button[class='button btn btn-default button-medium']"));
        buttonConfirmOrder.click();

        WebElement labelOrderComplete = driver.findElement(By.cssSelector(".alert.alert-success"));
        assertTrue(labelOrderComplete.isDisplayed());

        String textConfirm = labelOrderComplete.getText();
        assertEquals("Your order on My Store is complete.", textConfirm);
    }
}
