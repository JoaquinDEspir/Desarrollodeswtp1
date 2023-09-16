package com.ejercicio1.demo;

import com.ejercicio1.demo.entidades.*;
import com.ejercicio1.demo.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ejercicio1Application {

	@Autowired
	Clienterepository clienterepository;
	@Autowired
	Pedidorepository pedidorepository;
	@Autowired
	Rubrorepository rubrorepository;
	@Autowired
	DetallePedidorepository detallePedidorepository;
	@Autowired
	Domiciliorepository domiciliorepository;
	@Autowired
	Facturarepository facturarepository;
	@Autowired
	Productorepository productorepository;


	public static void main(String[] args) {

		SpringApplication.run(Ejercicio1Application.class, args);
		System.out.println("--------estoy andando----------");

	}

	@Bean
	CommandLineRunner init(Clienterepository clienterepository) {
		return args -> {
			System.out.println("--------estoy super andando----------");
			Domicilio domicilio1 = Domicilio.builder()
					.calle("calle 1")
					.numero("123")
					.localidad("Mendoza")
					.build();
			Domicilio domicilio2 = Domicilio.builder()
					.calle("calle 2")
					.numero("234")
					.localidad("Mendoza")
					.build();

			Cliente cliente1 = Cliente.builder()
					.nombre("juan")
					.apellido("Perez")
					.email("Juan@Perez")
					.telefono("1234567")
					.build();
			cliente1.agregarDomicilio(domicilio1);
			cliente1.agregarDomicilio(domicilio2);


			Factura factura1 = Factura.builder()
					.fecha("08/08/2023")
					.descuento(0)
					.total(500)
					.formaPago(Factura.FormaPago.efectivo)
					.numero(01)
					.build();
			factura1 = facturarepository.save(factura1);
			Producto producto1 = Producto.builder()
					.tiempoEstimadoCocina(15)
					.denominacion("carne")
					.precioCompra(400.0)
					.precioVenta(500.0)
					.receta("Cocinar la carne en una cacerola")
					.stockActual(15)
					.stockMinimo(5)
					.unidadMedida("g")
					.build();



			// Supongamos que tienes una ID válida de DetallePedido
			Long detallePedidoId = 1L; // Reemplaza con la ID correcta

			// Cargar la entidad DetallePedido desde la base de datos
			DetallePedido detallePedidoExistente = detallePedidorepository.findById(detallePedidoId).orElse(null);

			// Verificar si se encontró la entidad existente
			if (detallePedidoExistente != null) {
				// Actualizar los campos de la entidad existente si es necesario
				detallePedidoExistente.setCantidad(2);
				detallePedidoExistente.setSubtotal(1000.0);

				// Guardar la entidad actualizada
				detallePedidorepository.save(detallePedidoExistente);
			} else {
				// Si no se encontró la entidad, crear una nueva instancia
				DetallePedido detallePedidoNuevo = DetallePedido.builder()
						.cantidad(2)
						.subtotal(1000.0)
						.build();

				// Guardar la nueva instancia en la base de datos

			}
			Pedido pedido1 = Pedido.builder()
					.estado(Pedido.Estado.entregado)
					.fecha("08/08/2023")
					.tipoEnvio(Pedido.TipoEnvio.retira)
					.total(.0)
					.factura(factura1)
					.build();
			cliente1.agregarPedido(pedido1);




			Rubro rubro1 = Rubro.builder()
						.denominacion("carne")
					.build();
			rubro1.agregarProducto(producto1);

				// Guardar en los repositorios
				clienterepository.save(cliente1);
				 // Llamar al método save en una instancia válida de Pedidorepository
				rubrorepository.save(rubro1);



			facturarepository.save(factura1);


		};
	}
}