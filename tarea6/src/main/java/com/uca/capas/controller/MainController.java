package com.uca.capas.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dao.ContribuyenteDAO;
import com.uca.capas.domain.Contribuyente;
import com.uca.capas.domain.Importancia;
import com.uca.capas.service.ContribuyenteService;
import com.uca.capas.service.ImportanciaService;


@Controller
public class MainController {
Logger log = Logger.getLogger(MainController.class.getName());
	
	@Autowired //inyectamos objeto
	private ContribuyenteService contribuyenteService;
	
	@Autowired //inyectamos objeto
	private ImportanciaService importanciaService;
	
	
	@GetMapping("/inicio")	//Pagina inicial
	public ModelAndView initMain() {
		ModelAndView mav = new ModelAndView();
		Contribuyente contribuyente = new Contribuyente();
		List<Importancia> listaImportancias = null;
		listaImportancias = importanciaService.findAll();
		mav.addObject("contribuyente", contribuyente);
		mav.addObject("importancias", listaImportancias);
		mav.setViewName("index");
		return mav;
	}
	
	//********* Guardar estudiante en la base de datos *********
	@PostMapping("/guardar")
	public ModelAndView guardar(@ModelAttribute Contribuyente contribuyente) {
		ModelAndView mav = new ModelAndView();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		LocalDate today = LocalDate.now();
		 
		Date date = Date.from(today.atStartOfDay(defaultZoneId).toInstant());
		contribuyente.setFechaIngreso(date);
		contribuyente.getFechaIngreso();
		
		contribuyenteService.save(contribuyente);
		
		mav.setViewName("redirect:/inicio");
		return mav;
	}
	
	@GetMapping("/listado")
	public ModelAndView listado() {
		ModelAndView mav = new ModelAndView();
		List<Contribuyente> listaContribuyentes = null;
		
		listaContribuyentes = contribuyenteService.findAll();
	
		mav.addObject("contribuyentes", listaContribuyentes);
		mav.setViewName("listado");
		return mav;
	}

	
	//********* Elimina studiante por código*********
	@RequestMapping(value = "/eliminar/{codigoContribuyente}")
	public ModelAndView eliminar(@PathVariable int codigoContribuyente) {
		ModelAndView mav = new ModelAndView();
		Contribuyente c = null;
		try {
			c = contribuyenteService.findOne(codigoContribuyente);
			contribuyenteService.delete(c);
			log.info("Contribuyente eliminado");
		}catch(Exception ex){
			log.info("Error:" + ex.toString());
		}	
		mav.setViewName("redirect:/listado");
		return mav;
	}
}

