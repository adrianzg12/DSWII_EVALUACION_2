


create database bembos_db;
use bembos_db;

CREATE TABLE IF NOT EXISTS categoria (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT
);

CREATE TABLE IF NOT EXISTS producto (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    stock INT NOT NULL,
    descripcion TEXT,
    id_categoria INT,
    FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria)
);

CREATE TABLE IF NOT EXISTS cliente (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    telefono VARCHAR(20),
    direccion TEXT,
    pais VARCHAR(100) NOT NULL,
    ciudad VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS orden_compra (
    id_orden INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE NOT NULL,
    total DECIMAL(10, 2) NOT NULL,
    id_cliente INT,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
);

CREATE TABLE IF NOT EXISTS orden_compra_detalle (
    id_detalle INT AUTO_INCREMENT PRIMARY KEY,
    id_orden INT,
    id_producto INT,
    cantidad INT NOT NULL,
    precio_unitario DECIMAL(10, 2) NOT NULL,
    subtotal DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (id_orden) REFERENCES orden_compra(id_orden),
    FOREIGN KEY (id_producto) REFERENCES producto(id_producto)
);

select * from orden_compra oc ;


-- Insertar datos en la tabla categoria
INSERT INTO categoria (nombre, descripcion) VALUES 
('Hamburguesas', 'Hamburguesas de carne de res y pollo'),
('Bebidas', 'Bebidas gaseosas y jugos naturales'),
('Postres', 'Helados y otros postres dulces'),
('Ensaladas', 'Ensaladas frescas y saludables'),
('Complementos', 'Complementos para acompañar las comidas');

-- Insertar datos en la tabla producto
INSERT INTO producto (nombre, precio, stock, descripcion, id_categoria) VALUES
('Hamburguesa Clásica', 15.50, 100, 'Hamburguesa de carne de res con lechuga y tomate', 1),
('Hamburguesa Pollo', 14.00, 80, 'Hamburguesa de pollo empanizado con mayonesa', 1),
('Coca-Cola 500ml', 5.00, 200, 'Bebida gaseosa Coca-Cola en botella de 500ml', 2),
('Helado de Vainilla', 7.50, 50, 'Helado de vainilla con topping de chocolate', 3),
('Ensalada César', 12.00, 60, 'Ensalada con pollo, lechuga, y aderezo César', 4);

-- Insertar datos en la tabla cliente
INSERT INTO cliente (nombre, email, telefono, direccion, pais, ciudad) VALUES
('Juan Pérez', 'juan.perez@example.com', '999123456', 'Calle 123, Lima', 'Perú', 'Lima'),
('María Gómez', 'maria.gomez@example.com', '998654321', 'Avenida 456, Lima', 'Perú', 'Lima'),
('Pedro López', 'pedro.lopez@example.com', '997654321', 'Calle 789, Arequipa', 'Perú', 'Arequipa'),
('Ana Torres', 'ana.torres@example.com', '996543210', 'Calle 101, Cusco', 'Perú', 'Cusco'),
('Luis Fernández', 'luis.fernandez@example.com', '995432109', 'Avenida 202, Trujillo', 'Perú', 'Trujillo');

-- Insertar datos en la tabla orden_compra
INSERT INTO orden_compra (fecha, total, id_cliente) VALUES
('2024-10-01', 29.00, 1),
('2024-10-02', 12.50, 2),
('2024-10-03', 30.00, 3),
('2024-10-04', 20.00, 4),
('2024-10-05', 45.00, 5);

select * from orden_compra oc 
-- Insertar datos en la tabla orden_compra_detalle
INSERT INTO orden_compra_detalle (id_orden, id_producto, cantidad, precio_unitario, subtotal) VALUES
(1, 1, 1, 15.50, 15.50),  -- 1x Hamburguesa Clásica
(1, 3, 1, 5.00, 5.00),    -- 1x Coca-Cola 500ml
(2, 4, 1, 7.50, 7.50),    -- 1x Helado de Vainilla
(3, 5, 2, 12.00, 24.00),   -- 2x Ensalada César
(4, 2, 1, 14.00, 14.00);   -- 1x Hamburguesa Pollo

/*****PROCEDURE****/

DELIMITER //

CREATE PROCEDURE GenerateAndInsertCategory(
    IN p_nombre VARCHAR(255),
    IN p_descripcion TEXT
)
BEGIN
    INSERT INTO categoria (nombre, descripcion) 
    VALUES (p_nombre, p_descripcion);
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE GenerateAndInsertProducts(
    IN nombre VARCHAR(255),
    IN precio DECIMAL(10, 2),
    in stock INT ,
     IN descripcion TEXT,
    IN id_categoria INT
)
BEGIN
    -- Inserta un nuevo producto en la tabla productos
    INSERT INTO producto (nombre, descripcion, precio,stock , id_categoria)
    VALUES (nombre, descripcion, precio,stock, id_categoria);
end 

DELIMITER ;

DELIMITER //

CREATE PROCEDURE GenerateAndInsertClient(
    IN nombre VARCHAR(255),
    IN email VARCHAR(255),
    IN telefono VARCHAR(20),
    IN direccion TEXT,
    IN pais VARCHAR(100),
    IN ciudad VARCHAR(100)
)
BEGIN
    INSERT INTO cliente (nombre, email, telefono, direccion, pais, ciudad)
    VALUES (nombre, email, telefono, direccion, pais, ciudad);
END 

DELIMITER ;
select * from producto p 