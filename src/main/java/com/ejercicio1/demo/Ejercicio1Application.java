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
			DetallePedido detallePedido1 = DetallePedido.builder()
					.cantidad(1)
					.producto(producto1)
					.subtotal(500.0)
					.build();

			Pedido pedido1 = Pedido.builder()
					.estado(Pedido.Estado.entregado)
					.fecha("08/08/2023")
					.tipoEnvio(Pedido.TipoEnvio.retira)
					.total(.0)
					.factura(factura1)
					.build();
			cliente1.agregarPedido(pedido1);
			pedido1.agregarDetallePedido(detallePedido1);


			Rubro rubro1 = Rubro.builder()
					.denominacion("carne")
					.build();
			rubro1.agregarProducto(producto1);

				// Guardar en los repositorios
				clienterepository.save(cliente1);
				pedidorepository.save(pedido1); // Llamar al método save en una instancia válida de Pedidorepository
				rubrorepository.save(rubro1);
				detallePedidorepository.save(detallePedido1);
				domiciliorepository.save(domicilio1);
			domiciliorepository.save(domicilio2);
			facturarepository.save(factura1);
			productorepository.save(producto1);

		};
	}
}