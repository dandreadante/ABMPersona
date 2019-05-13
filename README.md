## API REST
    
###### Agrega una persona a la DB
  * PUT v1/persona
    
    {
     "perApellido": "Gomez Bolaños",
     "perFechaNacimiento": "1934-05-15",
     "perNumeroDocumento": "22333444",
     "perTipoDocumento": "PASAPORTE"
    }

###### una persona por su identificador
  * DELETE /v1/persona/{idpersona}


###### Modificar los datos de una persona

    POST v1/persona
    
    {
     "perId": "10",
     "perApellido": "Marianella",
     "perFechaNacimiento": "2019-05-15",
     "perNumeroDocumento": "87654321",
     "perTipoDocumento": "DNI"
    }

###### Consultas

* Consulta que retorna la persona que coincida con el Tipo y Numero de documento.
    GET /v1/personas/doctypeNum/{TipoDocumento}/{NumeroDocumento} 
* Lista las personas que contengan ese tipo de documento.
    GET /v1/personas/doctype/{TipoDocumento} 
* Lista de personas que coincida con el apellido.
    GET /v1/personas/apell/{apellido} 
* Lista de todas las personas. Se puede usar paginado (?page=1&size=5)
    GET v1/personas 
    
