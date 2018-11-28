package mx.edu.uacm.test.domain;



import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.edu.uacm.Application;
import mx.edu.uacm.domain.Accesorio;
import mx.edu.uacm.domain.Vehiculo;
import mx.edu.uacm.repository.VehiculoRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Application.class)
public class VehiculoTest {
	
	public static final Logger log = 
			LogManager.getLogger(VehiculoTest.class);
	
	@Autowired//Inyeccion de dependencias
	VehiculoRepository vehiculoRepository;
	
	@Test
	public void testGuardarVehiculo() {
		log.debug("Entrando a testGuardarVehiculo");
		//Se crea el vehiculo
		Vehiculo v=new Vehiculo();
		//El id es auto generado por la bd
		//Agregando el modelo
		v.setModelo("2018");
		
		//Se aguarda el objeto vehiculo en BD
		vehiculoRepository.save(v);
		Assert.assertNotNull(v.getId());
		Assert.assertThat(v.getId(),is(notNullValue()));
	}
	
	@Test
	public void testGuardarVehiculoConAcessorios(){
		Accesorio accesorio=new Accesorio("Aleron");
		Accesorio accesorioDos=new Accesorio("Rosario");
		//Crea la colección
		List<Accesorio> accesorios= new ArrayList<Accesorio>();
		accesorios.add(accesorio);
		accesorios.add(accesorioDos);
		Vehiculo vehiculo= new Vehiculo();
		vehiculo.setModelo("2019");
		vehiculo.setAccesorios(accesorios);
		vehiculo=vehiculoRepository.save(vehiculo);/*
		Optional<Vehiculo> op=vehiculoRepository.findById(vehiculo.getId());
		Vehiculo vehiculoActual=op.get();*/
		Vehiculo vehiculoActual = vehiculoRepository.findById(vehiculo.getId()).orElse(null);
		
		Assert.assertTrue(vehiculoActual.getAccesorios().size()>1);
		
	}

}
