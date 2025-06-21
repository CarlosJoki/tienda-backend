El propósito principal es del backend es ofrecer una API REST que el frontend puede consumir para gestionar los datos de una tienda: clientes, productos y ventas.

La estructura del backend es la siguiente:

--> controller (Capa de Presentación)

Propósito: Recibe las peticiones HTTP del exterior y las dirige al servicio correspondiente. Define los endpoints de la API.

ARCHIVOS:
ClienteController.java: Gestiona las rutas para Clientes (ej. GET /api/clientes, POST /api/clientes).
ProductoController.java: Gestiona las rutas para Productos.
VentaController.java: Gestiona las rutas para Ventas.

Anotaciones: @RestController indica que la clase manejará peticiones REST. @RequestMapping("/api/...") define la ruta base para los endpoints de la clase. @CrossOrigin permite las peticiones desde tu frontend.

--> service (Capa de Lógica de Negocio)

Propósito: Contiene la lógica de negocio de la aplicación. Actúa como intermediario entre los controladores y los repositorios.

Archivos:
ClienteService.java: Lógica para operaciones de clientes.
ProductoService.java: Lógica para operaciones de productos.
VentaService.java: Lógica para operaciones de ventas.

Anotaciones: @Service indica que es un componente de servicio gestionado por Spring.

--> repository (Capa de Acceso a Datos)

Propósito: Define la interfaz para interactuar con la base de datos.

Archivos:
ClienteRepository.java: Interfaz para acceder a los datos de los clientes en MongoDB.
ProductoRepository.java: Interfaz para los datos de productos.
VentaRepository.java: Interfaz para los datos de ventas.

Tecnología: Extienden de MongoRepository, lo que les da superpoderes para hablar con MongoDB sin escribir consultas explícitas.

--> model (Capa de Modelo de Datos)

Propósito: Define las entidades de datos, es decir, la estructura de los objetos que se guardarán en la base de datos.

Archivos:
Cliente.java: Define la estructura de un cliente.
Producto.java: Define la estructura de un producto.
Venta.java: Define la estructura de una venta.

Anotaciones: @Document indica que esta clase corresponde a una colección en MongoDB. @Id marca el campo que será el identificador único del documento. @Data (de Lombok) genera automáticamente getters, setters, toString().
