# Ingeniería de Datos II - Trabajo Práctico Obligatorio (Persistencia Poliglota)

## Equipo

1. Franco Massi
2. Ivan Stoljenberg
3. Alex Fiel
4. Martin Bejarano

## Fecha de Entrega

Fecha: 13-06-2024

## Descripción del Proyecto

Este proyecto tiene como objetivo construir una aplicación para gestionar pedidos y el inventario de productos de un supermercado usando motores de bases de datos no relacionales, incluyendo los siguientes aspectos:

1. **Usuarios**: Gestión de los datos de los usuarios que realizan pedidos.
2. **Carritos de Compras**: Manejo de carritos de compras, incluyendo la adición, eliminación y modificación de productos y cantidades.
3. **Pedidos**: Conversión de carritos de compras en pedidos.
4. **Facturación**: Finalización de pedidos y su conversión a facturas.
5. **Pagos**: Registro y gestión de pagos de facturas.
6. **Cuenta Corriente**: Imputación de pagos y facturas a usuarios con cuenta corriente.

## Justificación de Elección de Tecnologías

### Implementación en la Nube
Decidimos implementar nuestros servidores en la nube para asegurar que todos los miembros del equipo tuvieran acceso constante y uniforme a los mismos datos, minimizando las inconsistencias y facilitando la colaboración. Esta decisión también mejora la disponibilidad y escalabilidad de la aplicación, aprovechando la infraestructura robusta de la nube.

### Java
![](Imagenes/Unknown)
- Java es un lenguaje orientado a objetos, lo que permite modelar el dominio del problema de manera intuitiva y modular. La capacidad de crear clases reutilizables y componentes intercambiables facilita el desarrollo y el mantenimiento del sistema, asegurando una estructura de código clara y organizada.

- Java tiene un ecosistema muy maduro con una amplia gama de bibliotecas y herramientas que facilitan el desarrollo de aplicaciones empresariales. Herramientas como Spring Framework simplifican la gestión de dependencias, la configuración y la integración con diversas tecnologías, incluyendo bases de datos como MongoDB y Redis.

- Java es una elección ideal para aplicaciones que requieren alta escalabilidad y rendimiento. Su máquina virtual (JVM) está optimizada para ejecutar código de manera eficiente y puede manejar cargas de trabajo significativas sin comprometer el rendimiento. Esto es especialmente importante para aplicaciones de comercio electrónico que pueden experimentar picos de tráfico.
El lema "write once, run anywhere" de Java se alinea perfectamente con la necesidad de ejecutar la aplicación en diferentes entornos sin modificaciones. La portabilidad de Java asegura que nuestra aplicación pueda desplegarse en cualquier sistema operativo que soporte la JVM, proporcionando flexibilidad en la implementación y el desarrollo continuo.

- Java cuenta con una comunidad activa y un vasto recurso de documentación y soporte. Esto es beneficioso para el equipo de desarrollo, ya que cualquier problema o duda que surja durante el desarrollo puede ser resuelto rápidamente con la ayuda de la comunidad o mediante la extensa documentación disponible.

![](Imagenes/Unknown-2)
### MongoDB
Elegimos MongoDB como nuestra base de datos principal debido a su naturaleza documental, lo cual se adapta perfectamente a las necesidades de nuestro proyecto que involucra estructuras de datos flexibles y jerárquicas. MongoDB permite manejar documentos con datos anidados, lo cual es ideal para modelar nuestros usuarios, carritos de compras, pedidos, facturas y productos. Además, su escalabilidad y rendimiento son beneficios claves para una aplicación de comercio electrónico.

![](Imagenes/Unknown-3)
### Redis
Optamos por Redis como base de datos clave-valor para gestionar el historial de cambios debido a su alta velocidad y eficiencia en operaciones de lectura y escritura. Redis es excelente para almacenar logs y sesiones, y su soporte para operaciones atómicas lo hace ideal para el registro detallado y ordenado de cambios y actividades. Su naturaleza en memoria asegura un rendimiento superior, esencial para registrar cambios en tiempo real.

## Requerimientos de la Aplicación

### Modelos de Base de Datos

- **Usuarios**: Información de nombre, dirección y documento de identidad.
- **Sesión de Usuario**: Registro de la actividad del usuario y su categorización (TOP, MEDIUM, LOW).
- **Carritos de Compras**: Gestión de productos seleccionados y sus cantidades.
- **Pedidos**: Detalles del pedido, incluyendo productos, datos del cliente, importes, descuentos e impuestos.
- **Facturas**: Registro de facturación y pagos.
- **Pagos**: Control de operaciones de facturación y pagos, incluyendo medio de pago, operador, fecha, hora y monto.
- **Catálogo de Productos**: Descripción, fotos, comentarios, videos y otra información relevante.
- **Lista de Precios**: Registro actualizado de precios de productos.
- **Historial de Cambios**: Registro de todas las actividades realizadas sobre el contenido del catálogo de productos.

### Funcionalidades de la Aplicación

1. **Sesión de Usuario**: Guardar y recuperar la sesión del usuario conectado junto con su actividad.
2. **Actividad de Usuario**: Registrar la actividad de los usuarios para determinar su categorización.
3. **Carrito de Compras**: Gestionar los productos seleccionados junto con sus cantidades.
4. **Historial de Carrito**: Guardar y recuperar acciones realizadas sobre un carrito de compras activo.
5. **Pedidos**: Convertir el contenido del carrito de compras en un pedido, incluyendo detalles del cliente y montos.
6. **Facturación**: Facturar el pedido y registrar el pago.
7. **Control de Operaciones**: Llevar control de todas las operaciones de facturación y pagos realizadas por los usuarios.
8. **Pagos**: Realizar operaciones de pago que cubran facturas completas.
9. **Catálogo de Productos**: Mantener un catálogo de productos atractivo y actualizado.
10. **Lista de Precios**: Mantener una lista de precios actualizada.
11. **Historial de Cambios**: Registrar todas las actividades sobre el contenido del catálogo de productos.
