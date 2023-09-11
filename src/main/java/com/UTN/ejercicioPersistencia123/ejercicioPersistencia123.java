package com.UTN.ejercicioPersistencia123;

import com.UTN.ejercicioPersistencia123.entidades.*;
import com.UTN.ejercicioPersistencia123.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ejercicioPersistencia123Application{
	@Autowired
	public RubroRepository rubroRepository;
	@Autowired
	public ProductoRepository productoRepository;
	@Autowired
	public UsuarioRepository usuarioRepository;
	@Autowired
	public DomicilioRepository domicilioRepository;
	@Autowired
	public ClienteRepository clienteRepository;
	@Autowired
	public PedidoRepository pedidoRepository;
	@Autowired
	public DetallePedidoRepository detallePedidoRepository;
	@Autowired
	public FacturaRepository facturaRepository;
	public static void main(String[] args) {
		SpringApplication.run(ejercicioPersistencia123Application.class, args);
	}
	@Bean
	CommandLineRunner init(ConfiguracionGeneralRepository configuracionGeneralRepo,DomicilioRepository domicilioRepo, ClienteRepository clienteRepo,
						   UsuarioRepository usuarioRepo, PedidoRepository pedidoRepo, FacturaRepository facturaRepo, ProductoRepository productoRepo,
						   RubroRepository rubroRepos) {
		return args -> {

			ConfiguracionGeneral configuracionGeneral=ConfiguracionGeneral.builder().cantidadCocineros(5).emailEmpresa("SOMETHING@RANDOM").
					tokenMercadoPago("Currency Token").build();
			configuracionGeneralRepo.save(configuracionGeneral);
			System.out.println("FUNCIONO PAPAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");



			//Relacion de un usuario a muchos pedidos
			Usuario user1 = Usuario.builder().nombre("Stephan").rol("Adm.").password("123abc").build();
			Usuario user2 = Usuario.builder().nombre("Alexia").rol("Supplier").password("456def").build();
			usuarioRepo.save(user1);
			usuarioRepo.save(user2);
			Cliente cliente=Cliente.builder().nombre("Jane").apellido("Carter").build();
			Cliente cliente2=Cliente.builder().nombre("Lisa").apellido("Kraszinski").build();
			clienteRepo.save(cliente);
			clienteRepo.save(cliente2);
			Domicilio domicilio=Domicilio.builder().cliente(cliente).calle("Smith").numero("4357").build();
			Domicilio domicilio2=Domicilio.builder().cliente(cliente).calle("Johnson").numero("8172").build();
			Domicilio domicilio3=Domicilio.builder().cliente(cliente2).calle("Roses").numero("7856").build();
			domicilioRepo.save(domicilio);
			domicilioRepo.save(domicilio2);
			domicilioRepo.save(domicilio3);
			Pedido pedido1= Pedido.builder().fecha("5/11").horaEstimadaEntrega("8pm").estado(Pedido.Estado.INICIADO).tipoEnvio(Pedido.TipoEnvio.DELIVERY).total(500).build();
			Pedido pedido2= Pedido.builder().fecha("6/11").horaEstimadaEntrega("0pm").estado(Pedido.Estado.PREPARACION).tipoEnvio(Pedido.TipoEnvio.DELIVERY).total(900).build();
			Pedido pedido3= Pedido.builder().fecha("7/6").horaEstimadaEntrega("4pm").estado(Pedido.Estado.PREPARACION).tipoEnvio(Pedido.TipoEnvio.RETIRA).total(200).build();

			//Relacion de factura a pedido
			Factura factura= Factura.builder().formaPago(Factura.FormaPago.EFECTIVO).fecha("today").total(22).build();
			pedido1.setFactura(factura);

			//Relacion de producto a muchos detallePedido
			Producto producto= Producto.builder().tipo(Producto.Tipo.INSUMO).precioCompra(20).precioVenta(50).receta("Scoop of grain").tiempoEstimadoCocina(56).stockActual(5).stockMinimo(0).build();
			Producto producto2= Producto.builder().tipo(Producto.Tipo.INSUMO).precioCompra(30).precioVenta(70).receta("Cup of grain").tiempoEstimadoCocina(6).stockActual(7).stockMinimo(2).build();
			Producto producto3= Producto.builder().tipo(Producto.Tipo.INSUMO).precioCompra(3).precioVenta(10).receta("Few of grain").tiempoEstimadoCocina(56).stockActual(53).stockMinimo(1).build();

			//Relacion de muchos productos a un solo rubro
			Rubro rubro= Rubro.builder().denominacion("GrainCake").build();
			Rubro rubro2= Rubro.builder().denominacion("GrainDessert").build();
			rubro.agregarProducto(producto);
			rubro.agregarProducto(producto3);
			rubro2.agregarProducto(producto2);
			rubroRepos.save(rubro);
			rubroRepos.save(rubro2);

			// Relacion creada de un pedido a muchos con detalle del pedido
			DetallePedido detalleP = DetallePedido.builder().cantidad(6).subtotal(400).build();
			detalleP.setProducto(producto);
			DetallePedido detalleP2 = DetallePedido.builder().cantidad(2).subtotal(800).build();
			detalleP2.setProducto(producto);
			pedido1.agregarDetallePedido(detalleP);
			pedido1.agregarDetallePedido(detalleP2);
			pedidoRepo.save(pedido1);
			pedidoRepo.save(pedido2);
			pedidoRepo.save(pedido3);
			user2.agregarPedido(pedido1);
			user2.agregarPedido(pedido2);
			user2.agregarPedido(pedido3);
			domicilio.agregarPedido(pedido1);
			domicilio.agregarPedido(pedido2);
			domicilio3.agregarPedido(pedido3);
			cliente.agregarPedido(pedido1);
			cliente2.agregarPedido(pedido2);
			usuarioRepo.save(user1);
			usuarioRepo.save(user2);
			clienteRepo.save(cliente);
			clienteRepo.save(cliente2);
			domicilioRepo.save(domicilio);
			domicilioRepo.save(domicilio2);
			domicilioRepo.save(domicilio3);
		};

	}
}
