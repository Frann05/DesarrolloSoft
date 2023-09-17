package com.example.Tp1PersistenciaJPAGiuliani;

import com.example.Tp1PersistenciaJPAGiuliani.Entidades.*;
import com.example.Tp1PersistenciaJPAGiuliani.Enums.*;
import com.example.Tp1PersistenciaJPAGiuliani.Repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class Tp1PersistenciaJpaGiulianiApplication {

	@Autowired
	RubroRepository rubroRepository;
	@Autowired
	ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(Tp1PersistenciaJpaGiulianiApplication.class, args);
		System.out.println("Estoy funcionando");
	}

	@Bean
	CommandLineRunner init(RubroRepository rubroRepository, ClienteRepository clienteRepository){
		return args -> {
			System.out.println("----------------ESTOY----FUNCIONANDO---------------------");
			//crear instancia rubro
			Rubro rubro1 = Rubro.builder()
					.denominacion("Hamburguesas")
					.build();
			//crear instancias de productos
			Producto producto1 = Producto.builder()
					.tiempoEstimadoCocina(60)
					.denominacion("Hamburguesa con Cheddar y Bacon")
					.precioVenta(3000)
					.precioCompra(1500)
					.stockActual(5)
					.stockMinimo(3)
					.unidadMedida("unidad1")
					.receta("receta1")
					.tipoProducto(TipoProducto.Insumo)
					.build();
			Producto producto2 = Producto.builder()
					.tiempoEstimadoCocina(60)
					.denominacion("Hamburguesa Completa")
					.precioVenta(3500)
					.precioCompra(1500)
					.stockActual(4)
					.stockMinimo(4)
					.unidadMedida("unidad2")
					.receta("receta2")
					.tipoProducto(TipoProducto.Insumo)
					.build();
			//agregar productos al rubro
			rubro1.agregarProducto(producto1);
			rubro1.agregarProducto(producto2);
			//guardar rubro
			rubroRepository.save(rubro1);
			//Crear instancia Cliente
			Cliente cliente1 = Cliente.builder()
					.nombre("Franco")
					.apellido("Giuliani")
					.email("francogiuliani@gmail.com")
					.telefono("2615547522")
					.build();
			//Crear instancia domicilio
			Domicilio domicilio1 = Domicilio.builder()
					.calle("Las Cañas")
					.numero(1808)
					.localidad("Guaymallén")
					.build();
			Domicilio domicilio2 = Domicilio.builder()
					.calle("Alvarez Thomas")
					.numero(804)
					.localidad("Godoy Cruz")
					.build();
			//agregar domicilios a cliente
			cliente1.agregarDomicilio(domicilio1);
			cliente1.agregarDomicilio(domicilio2);
			//Crear Instancia Detalle Pedido
			DetallePedido detallePedido1 = DetallePedido.builder()
					.cantidad(2)
					.subtotal(6500)
					.build();
			DetallePedido detallePedido2 = DetallePedido.builder()
					.cantidad(1)
					.subtotal(3500)
					.build();
			DetallePedido detallePedido3 = DetallePedido.builder()
					.cantidad(3)
					.subtotal(9000)
					.build();
			//configuracion fecha
			SimpleDateFormat formatoFecha = new SimpleDateFormat ("yyyy-MM-dd");
			String fechaString = "2023-09-16";
			// Parsear la cadena en un objeto Date
			Date fecha = formatoFecha.parse(fechaString);
			//Crear Instancia Pedido
			Pedido pedido1 = Pedido.builder()
					.fecha(fecha)
					.total(6500)
					.estadoPedido(EstadoPedido.Entregado)
					.tipoEnvio(TipoEnvio.Delivery)
					.build();
			Pedido pedido2 = Pedido.builder()
					.fecha(fecha)
					.total(3500)
					.estadoPedido(EstadoPedido.Entregado)
					.tipoEnvio(TipoEnvio.RetiroLocal)
					.build();
			//Crear instancias de factura
			Factura factura1 = Factura.builder()
					.fecha(fecha)
					.total(6500)
					.numero(152)
					.descuento(400)
					.formaPago(FormaPago.Efectivo)
					.build();
			Factura factura2 = Factura.builder()
					.fecha(fecha)
					.total(3500)
					.numero(153)
					.descuento(0)
					.formaPago(FormaPago.Transferencia)
					.build();
			//Agregar detalles al pedido
			pedido1.agregarDetalle(detallePedido1);
			pedido1.agregarDetalle(detallePedido2);
			pedido2.agregarDetalle(detallePedido3);
			//agregar pedidos al cliente
			cliente1.agregarPedido(pedido1);
			cliente1.agregarPedido(pedido2);
			//vincular el detalle pedido con el producto
			detallePedido1.setProducto(producto1);
			detallePedido2.setProducto(producto2);
			detallePedido3.setProducto(producto1);
			//vincular factura con pedido
			pedido1.setFactura(factura1);
			pedido2.setFactura(factura2);
			//guardar cliente
			clienteRepository.save(cliente1);

			//recuperar objeto rubro desde la base de datos
			Rubro rubroRecuperado = rubroRepository.findById(rubro1.getId()).orElse(null);
			if (rubroRecuperado != null){
				System.out.println("Denominacion: " + rubroRecuperado.getDenominacion());
				rubroRecuperado.mostrarProducto();
			}
			//recuperar Cliente desde la base de Datos
			Cliente clienteRecuperado = clienteRepository.findById(cliente1.getId()).orElse(null);
			if (clienteRecuperado != null){
				System.out.println("Nombre: " + clienteRecuperado.getNombre());
				System.out.println("Apellido: " + clienteRecuperado.getApellido());
				System.out.println("Mail: " + clienteRecuperado.getEmail());
				System.out.println("Telefono: " + clienteRecuperado.getTelefono());
				System.out.println("----------------------------------------");
				clienteRecuperado.mostrarDomicilios();
				clienteRecuperado.mostrarPedidos();

			}
		};
	}

}


