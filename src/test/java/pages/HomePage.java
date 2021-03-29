package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.inject.spi.Element;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "form-tab")
    WebElement formbtn;
    
    @FindBy(id = "titulo")
    WebElement titulotxt;
    
    @FindBy(id = "contenido")
    WebElement contenidotxt;
    
    @FindBy(id = "categoria")
    WebElement catrb;
    
    @FindBy(xpath = "//*[@id='PostForm']/div[6]/div/input")
    WebElement submitbtn;
    
    
    
    public void NewPostClick() {
        this.click(formbtn);
    }
    
    public void CompleteForm() {
    	this.completeText(titulotxt, "Titulo Automatico");
    	this.completeText(contenidotxt, "Contenido Automatico a modo de Prueba!!!!!");
    	this.click(catrb);
    	this.click(submitbtn);

    }
}
