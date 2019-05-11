package ar.com.trimix.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.com.trimix.entity.Persona;
import ar.com.trimix.model.MPersona;

@Component("convertidor")
public class Convertidor {

   public List<MPersona> convertirLsita(List<Persona> personas){
	   List <MPersona> mPersonas = new ArrayList<MPersona>(); 
	   
	   for (Persona per : personas) {
		   mPersonas.add(new MPersona(per));
	   }
	   
	   return mPersonas;
   }
}
