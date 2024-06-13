# Ingeniería de Datos II - Trabajo Práctico Obligatorio (Persistencia Poliglota)

## Descripción del Proyecto

Este proyecto tiene como objetivo construir una aplicación para gestionar la creación de pedidos, incluyendo los siguientes aspectos:

1. **Usuarios**: Gestión de los datos de los usuarios que realizan pedidos.
2. **Carritos de Compras**: Manejo de carritos de compras, incluyendo la adición, eliminación y modificación de productos y cantidades.
3. **Pedidos**: Conversión de carritos de compras en pedidos.
4. **Facturación**: Finalización de pedidos y su conversión a facturas.
5. **Pagos**: Registro y gestión de pagos de facturas.
6. **Cuenta Corriente**: Imputación de pagos y facturas a usuarios con cuenta corriente.

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
