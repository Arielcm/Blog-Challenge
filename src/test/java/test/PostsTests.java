package test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PostsTests extends TestBase{

	
	@Given("El usuario se encuentra en la pagina principal y clickea en Nuevo Post")
	public void el_usuario_se_encuentra_en_la_pagina_principal_y_clickea_en_nuevo_post() {
	   homepage.NewPostClick();

	}

	@When("Completa el formulario y click en Crear Post")
	public void completa_el_formulario_y_click_en_crear_post(){
	    homepage.CompleteForm();
	}

	@Then("En la Pagina Principal se visualiza el nuevo Post")
	public void en_la_pagina_principal_se_visualiza_el_nuevo_post() {
	    throw new io.cucumber.java.PendingException();
	}
}
