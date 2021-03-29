Feature: Crear Post
 Se prueba la creacion de un nuevo post desde la pagina principal
 
 Scenario: Crear nuevo Post desde la Pagina Principal
 Given El usuario se encuentra en la pagina principal y clickea en Nuevo Post
 When  Completa el formulario y click en Crear Post
 Then  En la Pagina Principal se visualiza el nuevo Post
