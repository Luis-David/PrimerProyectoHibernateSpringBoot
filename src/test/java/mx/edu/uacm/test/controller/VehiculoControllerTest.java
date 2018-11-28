package mx.edu.uacm.test.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import mx.edu.uacm.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Application.class)
@AutoConfigureMockMvc
public class VehiculoControllerTest {
 // private static final Logger log= LogManager.getLogger();
    @Autowired
	MockMvc mvc;
	@Test
    public void testGuardarVehiculo() throws Exception{
	//	log.debug("Entrando a guardar vehiculo");
    	mvc.perform(post("/guardar").param("modelo", "2019"));
    }
	
	
}
