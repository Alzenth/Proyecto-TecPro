USE MAKEA;
GO

-- ====================================================
-- PROCEDIMIENTOS DE ADMINISTRADOR Y CLIENTE
-- ====================================================
CREATE OR ALTER PROCEDURE SP_Agregar_Admin(
    @ID_ADMIN CHAR(4),
    @NOM VARCHAR(100),
    @APE VARCHAR(100),
    @CORREO VARCHAR(100),
    @PASS VARCHAR(8),
    @DNI_ADMIN CHAR(8),
    @F_NAC DATE,
    @TELF VARCHAR(9)
)
AS  
BEGIN
    INSERT INTO ADMINISTRADOR(ID_ADMINISTRADOR, NOMBRES, APELLIDOS, EMAIL, CONTRASEÑA, DNI, FECHA_NACIMIENTO, TELEFONO) 
    VALUES (@ID_ADMIN, @NOM, @APE, @CORREO, @PASS, @DNI_ADMIN, @F_NAC, @TELF);
END;
GO

CREATE OR ALTER PROCEDURE Sp_Agregar_Cliente(
    @NOMBRES VARCHAR(100),
    @APELLIDOS VARCHAR(100),
    @DNI_CLIENTE CHAR(8),
    @CONTRASEÑA CHAR(8),
    @EMAIL VARCHAR(100),
    @TELEFONO CHAR(9)
)
AS 
BEGIN
    INSERT INTO CLIENTE(NOMBRES, APELLIDOS, DNI, CONTRASEÑA, EMAIL, TELEFONO)
    VALUES(@NOMBRES, @APELLIDOS, @DNI_CLIENTE, @CONTRASEÑA, @EMAIL, @TELEFONO);
END;
GO

CREATE OR ALTER FUNCTION dbo.Fun_Retornador_ID_ADMIN(
    @DNI_Admin CHAR(8) 
)
RETURNS CHAR(4)
AS 
BEGIN 
    DECLARE @Id_admin_obtenida CHAR(4);
    SELECT @Id_admin_obtenida = ID_ADMINISTRADOR FROM ADMINISTRADOR WHERE DNI = @DNI_Admin;
    RETURN @Id_admin_obtenida;
END;
GO

-- ====================================================
-- PROCEDIMIENTOS DE PRODUCTOS
-- ====================================================
CREATE OR ALTER PROCEDURE dbo.SP_Agregar_Producto(
    @ID_PROD CHAR(4),
    @NOM VARCHAR(100),
    @CAT VARCHAR(15),
    @DESCR VARCHAR(255),
    @STK INT,
    @PREC DECIMAL(10,2),
    @F_EXP DATE,
    @DNI_ADMIN_LOGEADO CHAR(8) 
)
AS 
BEGIN
    DECLARE @ID_ADMIN CHAR(4);
    SET @ID_ADMIN = dbo.Fun_Retornador_ID_ADMIN(@DNI_ADMIN_LOGEADO);
   
    IF @ID_ADMIN IS NOT NULL
    BEGIN
        INSERT INTO PRODUCTO (ID_PRODUCTO, NOMBRE, CATEGORIA, DESCRIPCION, STOCK, PRECIO, Fecha_Creacion, Fecha_Expiracion, ID_ADMINISTRADOR) 
        VALUES (@ID_PROD, @NOM, @CAT, @DESCR, @STK, @PREC, GETDATE(), @F_EXP, @ID_ADMIN);
        PRINT 'Producto agregado exitosamente por el administrador: ' + @ID_ADMIN;
    END
    ELSE
    BEGIN
        PRINT 'Error: No se encontró ningún administrador con ese DNI.';
    END
END;
GO

CREATE OR ALTER PROCEDURE SP_BuscaPorCategoria
    @CATEGORIA VARCHAR(50)
AS 
BEGIN
    SELECT * FROM PRODUCTO WHERE CATEGORIA = @CATEGORIA;
END;
GO

CREATE OR ALTER PROCEDURE SP_Consultar_Producto(
	@ID_PROD char(10)
)
AS
BEGIN
	SELECT * FROM dbo.PRODUCTO WHERE ID_PRODUCTO = @ID_PROD;
END;
GO

CREATE OR ALTER PROCEDURE dbo.SP_Editar_Producto(
    @ID_PROD CHAR(4),          
    @NOM VARCHAR(100),
    @CAT VARCHAR(15),         
    @DESCR VARCHAR(255),
    @STK INT,
    @PREC DECIMAL(10, 2),     
    @F_CREA DATE,
    @F_EXP DATE
)
AS 
BEGIN
    UPDATE PRODUCTO
    SET NOMBRE = @NOM, CATEGORIA = @CAT, DESCRIPCION = @DESCR, STOCK = @STK, 
        PRECIO = @PREC, Fecha_Creacion = @F_CREA, Fecha_Expiracion = @F_EXP
    WHERE ID_PRODUCTO = @ID_PROD;
END;
GO

CREATE OR ALTER PROCEDURE SP_Eliminar_Producto(
	@ID_PROD char(10)
)
AS
BEGIN
	DELETE FROM dbo.PRODUCTO WHERE ID_PRODUCTO = @ID_PROD;
END;
GO 

-- ====================================================
-- PROCEDIMIENTOS DE LISTADO Y ELIMINACIÓN
-- ====================================================
CREATE OR ALTER PROCEDURE SP_Eliminar_Admin(
    @ID_Admin char(4) 
)
AS
BEGIN
    DELETE FROM ADMINISTRADOR WHERE ID_ADMINISTRADOR = @ID_Admin;
END;
GO

CREATE OR ALTER PROCEDURE SP_Listar_Admin
AS 
BEGIN
    SELECT * FROM ADMINISTRADOR;
END;
GO

CREATE OR ALTER PROCEDURE SP_Listar_Clientes
AS 
BEGIN
    SELECT * FROM CLIENTE;
END;
GO

CREATE OR ALTER PROCEDURE SP_Listar_Productos
AS 
BEGIN
    SELECT * FROM PRODUCTO;
END;
GO

CREATE OR ALTER PROCEDURE SP_Producto_Catalogo(
    @CATEGORIA varchar(50)
)
AS
BEGIN
    SELECT ID_PRODUCTO, NOMBRE, DESCRIPCION, PRECIO, Fecha_Expiracion 
    FROM dbo.PRODUCTO
    WHERE (@CATEGORIA = 'Seleccione una categoría') OR (CATEGORIA = @CATEGORIA);
END;
GO

-- ====================================================
-- PROCEDIMIENTOS DE CARRITO
-- ====================================================
CREATE OR ALTER FUNCTION dbo.FN_Obtener_ID_Cliente_Por_DNI(
    @DNI CHAR(8)
)
RETURNS CHAR(4)
AS 
BEGIN
    DECLARE @ID_Encontrado CHAR(4);
    SELECT @ID_Encontrado = ID_CLIENTE FROM CLIENTE WHERE DNI = @DNI;
    RETURN @ID_Encontrado;
END;
GO

CREATE OR ALTER PROCEDURE dbo.SP_Agregar_Carrito_Por_Cliente (
    @DNI_Ingresado CHAR(8)
)
AS 
BEGIN
    DECLARE @ID_Cliente CHAR(4);
    SET @ID_Cliente = dbo.FN_Obtener_ID_Cliente_Por_DNI(@DNI_Ingresado);

    IF @ID_Cliente IS NOT NULL
    BEGIN
        IF NOT EXISTS (SELECT 1 FROM Carrito WHERE ID_CLIENTE = @ID_Cliente)
        BEGIN
            INSERT INTO Carrito (ID_CLIENTE, Monto_Total, Cantidad_Productos) VALUES (@ID_Cliente, 0.00, 0);
            PRINT 'Carrito creado exitosamente para el cliente ' + @ID_Cliente;
        END
        ELSE
        BEGIN
            PRINT 'El cliente ' + @ID_Cliente + ' ya tiene un carrito activo.';
        END
    END
    ELSE
    BEGIN
        PRINT 'Error: No se encontró ningún cliente con ese DNI.';
    END
END;
GO

CREATE OR ALTER PROCEDURE Sp_Agregar_Producto_a_DetalleCarrito (
    @ID_CARRITO Char(6),
    @ID_PRODUCTO CHAR(4),
    @Cantidad INT
)
AS
BEGIN
    SET NOCOUNT ON;
    DECLARE @PrecioUnitario DECIMAL(10,2);

    SELECT @PrecioUnitario = Precio FROM Producto WHERE ID_PRODUCTO = @ID_PRODUCTO;

    IF EXISTS (SELECT 1 FROM Detalle_Carrito WHERE ID_CARRITO = @ID_CARRITO AND ID_PRODUCTO = @ID_PRODUCTO)
    BEGIN
        UPDATE Detalle_Carrito
        SET Cantidad = Cantidad + @Cantidad,
            Precio = @PrecioUnitario * (Cantidad + @Cantidad)
        WHERE ID_CARRITO = @ID_CARRITO AND ID_PRODUCTO = @ID_PRODUCTO;
    END
    ELSE
    BEGIN
        INSERT INTO Detalle_Carrito (ID_CARRITO, ID_PRODUCTO, Cantidad, Precio)
        VALUES (@ID_CARRITO, @ID_PRODUCTO, @Cantidad, @PrecioUnitario * @Cantidad);
    END
END;
GO

CREATE OR ALTER PROCEDURE SP_Mostrar_Producto_a_Detalle(@Id_Carrito_Pro char(6))
AS
BEGIN
    SELECT
        pro.NOMBRE as 'Nombre de Producto',
        DCAR.CANTIDAD as 'Cantidad Productos',
        Pro.PRECIO as 'Precio Unitario',
        dcar.PRECIO as 'Monto total'
    FROM PRODUCTO as pro 
    INNER JOIN DETALLE_CARRITO as DCAR ON pro.ID_PRODUCTO = DCAR.ID_PRODUCTO
    WHERE DCAR.ID_CARRITO = @Id_Carrito_Pro; 
END;
GO

-- ====================================================
-- PROCEDIMIENTO DE VENTA FINAL (LA BOLETA)
-- ====================================================
CREATE OR ALTER PROCEDURE SP_Mostrar_Detalle_Venta(@ID_VENTA CHAR(4)) 
AS
BEGIN
    SELECT
        CLIE.DNI AS 'DNI del Cliente',
        PRO.ID_PRODUCTO AS 'ID del Producto',
        PRO.NOMBRE AS 'Nombre del Producto',
        DCAR.CANTIDAD AS 'Cantidad Comprada',
        DCAR.PRECIO_UNITARIO AS 'Precio Base Unitario',
        
        -- Subtotal individual de cada producto
        (DCAR.CANTIDAD * DCAR.PRECIO_UNITARIO) AS 'SubTotal Producto',
       
        -- 1. Suma total base combinada
        SUM(DCAR.CANTIDAD * DCAR.PRECIO_UNITARIO) OVER() AS 'Monto Total Base',
        
        -- 2. IGV Total (18%) calculado
        CAST(SUM(DCAR.CANTIDAD * DCAR.PRECIO_UNITARIO) OVER() * 0.18 AS DECIMAL(10,2)) AS 'IGV Total (18%)',
        
        -- 3. Total General a Pagar
        CAST(SUM(DCAR.CANTIDAD * DCAR.PRECIO_UNITARIO) OVER() * 1.18 AS DECIMAL(10,2)) AS 'Total General a Pagar'

    FROM CLIENTE AS CLIE 
    INNER JOIN VENTA AS V ON CLIE.ID_CLIENTE = V.ID_CLIENTE 
    INNER JOIN DETALLE_VENTA AS DCAR ON V.ID_VENTA = DCAR.ID_VENTA 
    INNER JOIN PRODUCTO AS PRO ON DCAR.ID_PRODUCTO = PRO.ID_PRODUCTO
    
    WHERE V.ID_VENTA = @ID_VENTA; 
END;
GO

-- ====================================
-- Ejecución de prueba:

DELETE FROM DETALLE_VENTA;
DELETE FROM DETALLE_CARRITO;
DELETE FROM VENTA;
DELETE FROM CARRITO;
GO


ALTER SEQUENCE Seq_CARRITO_ID RESTART WITH 0;
ALTER SEQUENCE Seq_DETALLE_CARRITO_ID RESTART WITH 0;
ALTER SEQUENCE Seq_VENTA_ID RESTART WITH 0;
ALTER SEQUENCE Seq_DETALLE_VENTA_ID RESTART WITH 0;
GO



EXEC SP_Agregar_Carrito_Por_Cliente '45236187';
GO


EXEC Sp_Agregar_Producto_a_DetalleCarrito 'CAR000', 'P110', 3;


EXEC Sp_Agregar_Producto_a_DetalleCarrito 'CAR000', 'P220', 4;


UPDATE CARRITO
SET CANTIDAD_PRODUCTOS = (SELECT SUM(CANTIDAD) FROM DETALLE_CARRITO WHERE ID_CARRITO = 'CAR000'),
    MONTO_TOTAL = (SELECT SUM(PRECIO) FROM DETALLE_CARRITO WHERE ID_CARRITO = 'CAR000')
WHERE ID_CARRITO = 'CAR000';
GO


SELECT * FROM CARRITO;
SELECT * FROM DETALLE_CARRITO;
GO

BEGIN
    -- Declaramos las variables necesarias
    DECLARE @IdVentaGenerada CHAR(4);
    -- Obtenemos el ID del cliente Juan Carlos usando tu función
    DECLARE @IdCliente CHAR(4) = dbo.FN_Obtener_ID_Cliente_Por_DNI('45236187'); 
    DECLARE @IdCarrito CHAR(6) = 'CAR000';

    -- 1. Generar la VENTA (Cabecera) con IGV
    INSERT INTO VENTA (ID_CLIENTE, METODO_PAGO, IGV)
    SELECT 
        ID_CLIENTE, 
        'Tarjeta', 
        CAST(MONTO_TOTAL * 0.18 AS DECIMAL(10,2))
    FROM CARRITO WHERE ID_CARRITO = @IdCarrito;

    -- 2. Capturar el ID de la Venta (Será V000)
    SELECT TOP 1 @IdVentaGenerada = ID_VENTA 
    FROM VENTA WHERE ID_CLIENTE = @IdCliente ORDER BY FECHA_HORA DESC;

    -- 3. Migrar los productos a DETALLE_VENTA
    INSERT INTO DETALLE_VENTA (ID_VENTA, ID_PRODUCTO, CANTIDAD, PRECIO_UNITARIO, PRECIO)
    SELECT 
        @IdVentaGenerada, DC.ID_PRODUCTO, DC.CANTIDAD, P.PRECIO, DC.PRECIO        
    FROM DETALLE_CARRITO AS DC
    INNER JOIN PRODUCTO AS P ON DC.ID_PRODUCTO = P.ID_PRODUCTO
    WHERE DC.ID_CARRITO = @IdCarrito;

    -- 4. DESCONTAR EL STOCK (La magia del inventario)
    UPDATE P
    SET P.STOCK = P.STOCK - DC.CANTIDAD
    FROM PRODUCTO AS P
    INNER JOIN DETALLE_CARRITO AS DC ON P.ID_PRODUCTO = DC.ID_PRODUCTO
    WHERE DC.ID_CARRITO = @IdCarrito;

    -- 5. Vaciar el carrito (Juan Carlos ya pagó)
    DELETE FROM DETALLE_CARRITO WHERE ID_CARRITO = @IdCarrito;
    UPDATE CARRITO SET MONTO_TOTAL = 0.00, CANTIDAD_PRODUCTOS = 0 WHERE ID_CARRITO = @IdCarrito;

    -- 6. Imprimir la boleta final
    PRINT '===================== BOLETA DE VENTA GENERADA =====================';
    EXEC SP_Mostrar_Detalle_Venta @ID_VENTA = @IdVentaGenerada;
END;
GO



Exec SP_Agregar_Admin 'A001', 'Alexander Miguel', 'Bejar Centurión', 'alexanderBejar09@gmail.com', '12345678', 77062578, '2002-02-26','930286663'
Exec SP_Agregar_Admin 'A002', 'Angello Fabrizio', 'Camacho Campoverde', 'angellocamacho553@gmail.com','26262626',60995119,'2007-02-02', '965193521'
Exec SP_Listar_Admin;
GO


Exec Sp_Agregar_Cliente 'Juan Carlos', 'Perez Ruiz', '45236187', 'contra23', 'juancitoruiz89@gmail.com', '987654321';
Exec Sp_Agregar_Cliente 'Maria Elena', 'Gomez Fernandez', '76543210', 'pass8765', 'mariagomez.1@gmail.com', '912345670';
Exec Sp_Agregar_Cliente 'Luis Alberto', 'Sanchez Torres', '12345678', 'luis1234', 'luissanchez.t@gmail.com', '998877665';
Exec Sp_Agregar_Cliente 'Ana Paula', 'Vargas Castro', '87654321', 'ana_p456', 'anavargas.c@gmail.com', '923456789';
Exec Sp_Agregar_Cliente 'Carlos Eduardo', 'Mendoza Diaz', '45678901', 'carlos99', 'carlosmendoza88@gmail.com', '934567812';
Exec Sp_Agregar_Cliente 'Rosa', 'Chavez Huaman', '74185296', 'rosa2026', 'rosachavez.h@gmail.com', '945612378';
Exec Sp_Agregar_Cliente 'Jorge', 'Rojas Quispe', '96325874', 'jorge777', 'jorgerojas.q@gmail.com', '956789123';
Exec Sp_Agregar_Cliente 'Carmen', 'Flores Silva', '15975346', 'carmenfs', 'carmenflores.s@gmail.com', '967890234';
Exec Sp_Agregar_Cliente 'Diego', 'Gutierrez Romero', '35715928', 'diego_gr', 'diegogutierrez.r@gmail.com', '978901345';
Exec Sp_Agregar_Cliente 'Lucia', 'Ramos Castillo', '85296374', 'lucia_rc', 'luciaramos.c@gmail.com', '989012456';
Exec Sp_Agregar_Cliente 'Pedro', 'Navarro', '11223344', 'pedro111', 'pedronavarro@gmail.com', '900111222';
Exec Sp_Agregar_Cliente 'Sofia', 'Linares', '55667788', 'sofilin8', 'sofialinares@gmail.com', '900333444';
Exec Sp_Agregar_Cliente 'Miguel', 'Cordova', '99001122', 'miguel99', 'miguelcordova@gmail.com', '900555666';
Exec Sp_Agregar_Cliente 'Valeria', 'Paredes', '33445566', 'valeria3', 'valeriaparedes@gmail.com', '900777888';
Exec Sp_Agregar_Cliente 'Fernando', 'Salas', '77889900', 'fer_2026', 'fernandosalas@gmail.com', '900999000';
Go

Exec SP_Listar_Clientes;
Go


-- Registro de prodcutos - Cuchareables

Exec SP_Agregar_Producto 'P101', 'Cuchareable de Pudín Chocolate', 'Cuchareables', 'Suave pudín de chocolate oscuro en un formato súper cremoso.', 40, 6.00, '2026-07-31', 77062578;
Exec SP_Agregar_Producto 'P102', 'Cuchareable de Torta Chocolate', 'Cuchareables', 'Torta húmeda de chocolate con full fudge lista para disfrutar.', 40, 6.00, '2026-07-16', 77062578;
Exec SP_Agregar_Producto 'P103', 'Cuchareable de Café', 'Cuchareables', 'El intenso y clásico aroma del café en un postre sedoso.', 30, 6.00, '2026-07-16', 77062578;
Exec SP_Agregar_Producto 'P104', 'Cuchareable de Lúcuma', 'Cuchareables', 'Auténtica crema de lúcuma peruana, dulce y aterciopelada.', 35, 6.50, '2026-07-16', 77062578;
Exec SP_Agregar_Producto 'P105', 'Cuchareable de Manzana', 'Cuchareables', 'El clásico postre de manzana con toques de canela y crema.', 30, 6.50, '2026-07-16', 77062578;
Exec SP_Agregar_Producto 'P106', 'Cuchareable de Fresa', 'Cuchareables', 'Capas suaves intercaladas con dulce de fresa natural.', 35, 6.50, '2026-07-16', 77062578;
Exec SP_Agregar_Producto 'P107', 'Cuchareable de Frutos rojos', 'Cuchareables', 'Un equilibrio perfecto entre lo dulce y el ácido de los frutos rojos.', 30, 6.50, '2026-07-16', 77062578;
Exec SP_Agregar_Producto 'P108', 'Cuchareable de Maracuyá', 'Cuchareables', 'Frescura cítrica y tropical de puro maracuyá en cada cucharada.', 30, 6.50, '2026-07-16', 77062578;
Exec SP_Agregar_Producto 'P109', 'Cuchareable de Maracumango', 'Cuchareables', 'La vibrante y deliciosa fusión caribeña de mango dulce y maracuyá.', 25, 6.50, '2026-07-16', 77062578;
Exec SP_Agregar_Producto 'P110', 'Cuchareable de Tres leches Pistacho', 'Cuchareables', 'Esponjoso tres leches elevado con el sabor premium del pistacho.', 20, 10.00, '2026-07-16', 77062578;
Exec SP_Agregar_Producto 'P111', 'Cuchareable de Tres leches', 'Cuchareables', 'El clásico bizcocho mojadito en nuestra receta especial de tres leches.', 25, 6.00, '2026-07-16', 77062578;
Exec SP_Agregar_Producto 'P112', 'Cuchareable de Menta', 'Cuchareables', 'Sabor dulce y muy refrescante a menta para limpiar el paladar.', 20, 6.00, '2026-07-16', 77062578;
Exec SP_Agregar_Producto 'P113', 'Cuchareable de Oreo', 'Cuchareables', 'Capas de crema suave mezcladas con galleta Oreo troceada y crujiente.', 45, 6.00, '2026-07-16', 77062578;
Exec SP_Agregar_Producto 'P114', 'Cuchareable de Guanábana', 'Cuchareables', 'El inconfundible sabor exótico y delicado de la guanábana fresca.', 25, 6.50, '2026-07-16', 77062578;
Exec SP_Agregar_Producto 'P115', 'Cuchareable de Pistacho', 'Cuchareables', 'Suave y cremoso postre con el sabor intenso y elegante del pistacho puro, coronado con trocitos tostados para un toque crujiente.', 30, 8.00, '2026-07-16', 77062578;
Exec SP_Listar_Productos;

 
-- Registro de productos - Chocotejas =================================================================================================================================================================

Exec SP_Agregar_Producto 'P215', 'Chocoteja de Pecana', 'Chocotejas', 'La tradicional chocoteja rellena con mitades de pecana crujiente y abundante manjar blanco.', 40, 2.00, '2026-07-16', 60995119;
Exec SP_Agregar_Producto 'P216', 'Chocoteja de Maní', 'Chocotejas', 'El toque salado y crujiente del maní tostado envuelto en dulce manjar y chocolate.', 35, 2.00, '2026-07-16', 60995119;
Exec SP_Agregar_Producto 'P217', 'Chocoteja de Pasas', 'Chocotejas', 'Dulces pasas morenas combinadas a la perfección con nuestro suave manjar blanco.', 30, 2.00, '2026-07-16', 60995119;
Exec SP_Agregar_Producto 'P218', 'Chocoteja de Higo', 'Chocotejas', 'Un exquisito relleno de higo seco que aporta una textura y dulzor únicos al paladar.', 25, 2.00, '2026-07-16', 60995119;
Exec SP_Agregar_Producto 'P219', 'Chocoteja de Coco', 'Chocotejas', 'Relleno de coco rallado para un sabor suave, delicado y ligeramente tropical.', 30, 2.00, '2026-07-16', 60995119;
Exec SP_Agregar_Producto 'P220', 'Chocoteja de Oreo', 'Chocotejas', 'Para los más golosos: manjar blanco con trocitos súper crujientes de galleta Oreo.', 45, 2.00, '2026-07-16', 60995119;
Exec SP_Agregar_Producto 'P221', 'Chocoteja de Ole ole', 'Chocotejas', 'El sabor divertido y nostálgico del dulce Ole Ole bañado en nuestra cobertura.', 30, 2.00, '2026-07-16', 60995119;
Exec SP_Agregar_Producto 'P222', 'Chocoteja de Chin chin', 'Chocotejas', 'Una explosión de color y sabor con las clásicas grageas Chin Chin de chocolate por dentro.', 35, 2.00, '2026-07-16', 60995119;
Exec SP_Agregar_Producto 'P223', 'Chocoteja de Gomitas', 'Chocotejas', 'Una sorpresa dulce, frutal y masticable de gomitas en el centro de tu chocoteja.', 25, 2.00, '2026-07-16', 60995119;
Exec SP_Agregar_Producto 'P224', 'Chocoteja de Marshmello', 'Chocotejas', 'Relleno súper esponjoso y suave de marshmello que se derrite en la boca.', 30, 2.00, '2026-07-16', 60995119;
Exec SP_Agregar_Producto 'P225', 'Chocoteja de Café', 'Chocotejas', 'Un intenso y aromático relleno de crema de café, ideal para despertar los sentidos.', 35, 2.00, '2026-07-16', 60995119;
Exec SP_Agregar_Producto 'P226', 'Chocoteja de Maracuyá', 'Chocotejas', 'El toque cítrico perfecto de maracuyá que equilibra deliciosamente el dulzor del chocolate.', 40, 2.00, '2026-07-16', 60995119;
Exec SP_Agregar_Producto 'P227', 'Chocoteja de Pye de Limón', 'Chocotejas', 'Toda la experiencia de un pye de limón encapsulada en una rica cobertura de chocolate.', 30, 2.00, '2026-07-16', 60995119;
Exec SP_Agregar_Producto 'P228', 'Chocoteja de Frutos Rojos', 'Chocotejas', 'Una irresistible mezcla dulce y ácida de frutos rojos tipo cheesecake.', 30, 2.00, '2026-07-16', 60995119;
Exec SP_Agregar_Producto 'P229', 'Chocoteja de Fresa', 'Chocotejas', 'Suave crema de fresa con un perfil de sabor fresco, frutal y veraniego.', 35, 2.00, '2026-07-16', 60995119;
Exec SP_Agregar_Producto 'P230', 'Chocoteja de Lúcuma', 'Chocotejas', 'El sabor peruano por excelencia en un cremoso relleno de lúcuma fresca.', 40, 2.00, '2026-07-16', 60995119;
Exec SP_Agregar_Producto 'P231', 'Chocoteja de Piña', 'Chocotejas', 'Un pedacito del trópico con el sabor jugoso, refrescante y dulce de la piña.', 25, 2.00, '2026-07-16', 60995119;
Exec SP_Agregar_Producto 'P232', 'Chocoteja de Menta', 'Chocotejas', 'La combinación infalible y elegante de chocolate crujiente y relleno fresco de menta.', 30, 2.00, '2026-07-16', 60995119;
Exec SP_Agregar_Producto 'P233', 'Chocoteja de Pasas borrachas', 'Chocotejas', 'Pasas pacientemente maceradas en licor para un toque intenso, adulto y atrevido.', 30, 2.50, '2026-07-16', 60995119;
Exec SP_Agregar_Producto 'P234', 'Chocoteja de Pisco Sour', 'Chocotejas', 'Nuestro cóctel bandera transformado en un exquisito relleno cremoso con carácter.', 35, 2.50, '2026-07-16', 60995119;
Exec SP_Agregar_Producto 'P235', 'Chocoteja de Pisco sour Maracuyá', 'Chocotejas', 'La variante cítrica del pisco sour combinada con el exótico sabor del maracuyá.', 25, 2.50, '2026-07-16', 60995119;

Exec SP_Listar_Productos;
-- Produtos de la Empresa

Exec SP_Listar_Clientes;
Exec SP_Listar_Admin;
