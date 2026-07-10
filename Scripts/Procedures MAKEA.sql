USE MAKEA;
GO

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
    IF EXISTS(SELECT 1 FROM CLIENTE AS C WHERE C.DNI = @DNI_ADMIN)
    BEGIN
        RAISERROR('El DNI ya se encuentra registrado como cliente', 16,2)
        RETURN;
    END
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
    IF EXISTS(SELECT 1 FROM ADMINISTRADOR WHERE DNI = @DNI_CLIENTE)
    BEGIN
        RAISERROR('El DNI ya se encuentra registrado como administrador', 16,2)
        RETURN;
    END
    IF EXISTS(SELECT 1 FROM CLIENTE WHERE TELEFONO = @TELEFONO)
    BEGIN
        RAISERROR('Este número telefónico ya se encuentra registrado por otro cliente', 16,2)
        RETURN;
    END
    
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

CREATE OR ALTER PROCEDURE dbo.SP_Agregar_Producto(
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
    
    IF @F_EXP <= CAST(GETDATE() AS DATE)
    BEGIN
        RAISERROR('Error: La fecha de expiración debe ser posterior a la fecha actual.', 16, 1);
        RETURN;
    END

    DECLARE @ID_ADMIN CHAR(4);
    DECLARE @Nuevo_ID CHAR(5);
    DECLARE @SiguienteNumero INT;

    SET @ID_ADMIN = dbo.Fun_Retornador_ID_ADMIN(@DNI_ADMIN_LOGEADO);
   
    IF @ID_ADMIN IS NULL
    BEGIN
        RAISERROR('Error: No se encontró ningún administrador con ese DNI.', 16, 1);
        RETURN;
    END

    IF @CAT = 'Chocotejas' 
    BEGIN
        SET @SiguienteNumero = NEXT VALUE FOR Seq_Chocotejas;
        SET @Nuevo_ID = 'CH' + RIGHT('000' + CAST(@SiguienteNumero AS VARCHAR(3)), 3);
    END
    ELSE IF @CAT = 'Cuchareables' 
    BEGIN
        SET @SiguienteNumero = NEXT VALUE FOR Seq_Cuchareables;
        SET @Nuevo_ID = 'CU' + RIGHT('000' + CAST(@SiguienteNumero AS VARCHAR(3)), 3);
    END
    ELSE
    BEGIN
        RAISERROR('Error: Categoría no válida.', 16, 1);
        RETURN;
    END

    INSERT INTO PRODUCTO (ID_PRODUCTO, NOMBRE, CATEGORIA, DESCRIPCION, STOCK, PRECIO, Fecha_Creacion, Fecha_Expiracion, ID_ADMINISTRADOR) 
    VALUES (@Nuevo_ID, @NOM, @CAT, @DESCR, @STK, @PREC, GETDATE(), @F_EXP, @ID_ADMIN);
    
    PRINT 'Producto agregado exitosamente con el ID: ' + @Nuevo_ID + ' por el administrador: ' + @ID_ADMIN;
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
	@ID_PROD CHAR(5)
)
AS
BEGIN
	SELECT * FROM dbo.PRODUCTO WHERE ID_PRODUCTO = @ID_PROD;
END;
GO

CREATE OR ALTER PROCEDURE SP_Editar_Producto(
    @ID_PROD CHAR(5), 
    @NOM VARCHAR(100),
    @CAT VARCHAR(15),         
    @DESCR VARCHAR(255),
    @STK INT,
    @PREC DECIMAL(10, 2),     
    @F_EXP DATE
)
AS 
BEGIN
    
    DECLARE @Fecha_Creacion_Existente DATE;
    SELECT @Fecha_Creacion_Existente = Fecha_Creacion 
    FROM PRODUCTO 
    WHERE ID_PRODUCTO = @ID_PROD;

    IF @Fecha_Creacion_Existente IS NULL
    BEGIN
        RAISERROR('Error: El producto que intenta editar no existe.', 16, 1);
        RETURN;
    END

    IF @F_EXP <= @Fecha_Creacion_Existente
    BEGIN
        RAISERROR('Error: La fecha de expiración no puede ser menor o igual a la fecha de creación del producto.', 16, 1);
        RETURN;
    END

    IF @F_EXP <= CAST(GETDATE() AS DATE)
    BEGIN
        RAISERROR('Error: La fecha de expiración debe ser una fecha futura válida.', 16, 1);
        RETURN;
    END

    UPDATE PRODUCTO
    SET NOMBRE = @NOM, CATEGORIA = @CAT, DESCRIPCION = @DESCR, STOCK = @STK, 
        PRECIO = @PREC, Fecha_Expiracion = @F_EXP
    WHERE ID_PRODUCTO = @ID_PROD;
    
    PRINT 'Producto actualizado correctamente.';
END;
GO

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

CREATE OR ALTER PROCEDURE dbo.SP_Obtener_ID_Carrito (
    @DNI_Ingresado CHAR(8)
)
AS
BEGIN
    SELECT C.ID_CARRITO FROM CARRITO C INNER JOIN CLIENTE CL
    ON C.ID_CLIENTE = CL.ID_CLIENTE WHERE CL.DNI = @DNI_Ingresado;
END;
GO

CREATE OR ALTER PROCEDURE Sp_Agregar_Producto_a_DetalleCarrito (
    @ID_CARRITO CHAR(6),
    @ID_PRODUCTO CHAR(5),
    @Cantidad INT
)
AS
BEGIN
    SET NOCOUNT ON;

    DECLARE @PrecioUnitario DECIMAL(10,2);

    SELECT @PrecioUnitario = PRECIO
    FROM PRODUCTO
    WHERE ID_PRODUCTO = @ID_PRODUCTO;

    IF EXISTS (
        SELECT 1
        FROM DETALLE_CARRITO
        WHERE ID_CARRITO = @ID_CARRITO
          AND ID_PRODUCTO = @ID_PRODUCTO
    )
    BEGIN
        UPDATE DETALLE_CARRITO
        SET CANTIDAD = CANTIDAD + @Cantidad,
            PRECIO = @PrecioUnitario * (CANTIDAD + @Cantidad)
        WHERE ID_CARRITO = @ID_CARRITO
          AND ID_PRODUCTO = @ID_PRODUCTO;
    END
    ELSE
    BEGIN
        INSERT INTO DETALLE_CARRITO
            (ID_CARRITO, ID_PRODUCTO, CANTIDAD, PRECIO)
        VALUES
            (@ID_CARRITO, @ID_PRODUCTO, @Cantidad, @PrecioUnitario * @Cantidad);
    END

    UPDATE CARRITO
    SET CANTIDAD_PRODUCTOS = (
            SELECT ISNULL(SUM(CANTIDAD), 0)
            FROM DETALLE_CARRITO
            WHERE ID_CARRITO = @ID_CARRITO
        ),
        MONTO_TOTAL = (
            SELECT ISNULL(SUM(PRECIO), 0)
            FROM DETALLE_CARRITO
            WHERE ID_CARRITO = @ID_CARRITO
        )
    WHERE ID_CARRITO = @ID_CARRITO;

END;
GO

CREATE OR ALTER PROCEDURE SP_Mostrar_Producto_a_Detalle(@Id_Carrito_Pro char(6))
AS
BEGIN
    SELECT
        DCAR.ID_DETALLE_CARRITO,
        pro.NOMBRE,
        DCAR.CANTIDAD,
        Pro.PRECIO as 'PRECIO_UNITARIO',
        dcar.PRECIO as 'SUBTOTAL'
    FROM PRODUCTO as pro 
    INNER JOIN DETALLE_CARRITO as DCAR ON pro.ID_PRODUCTO = DCAR.ID_PRODUCTO
    WHERE DCAR.ID_CARRITO = @Id_Carrito_Pro; 
END;
GO

CREATE OR ALTER PROCEDURE SP_Eliminar_Producto_de_DetalleCarrito(
	@ID_DC char(5)
)
AS
BEGIN
	DELETE FROM dbo.DETALLE_CARRITO WHERE ID_DETALLE_CARRITO = @ID_DC;
END;
GO 
CREATE OR ALTER   PROCEDURE SP_Eliminar_Producto(
	@ID_PROD char(5)
)
AS
BEGIN
	DELETE FROM dbo.PRODUCTO WHERE ID_PRODUCTO = @ID_PROD;
END;

CREATE OR ALTER PROCEDURE SP_Mostrar_Detalle_Venta(@ID_VENTA CHAR(4)) 
AS
BEGIN
    SELECT
        V.ID_VENTA AS 'Ticket', V.FECHA_HORA AS 'Fecha', CLIE.DNI AS 'DNI',
        (CLIE.NOMBRES + ' ' + CLIE.APELLIDOS) AS 'Cliente', PRO.NOMBRE AS 'Producto',
        DCAR.CANTIDAD AS 'Cantidad', (DCAR.CANTIDAD * DCAR.PRECIO_UNITARIO) AS 'Subtotal',
        SUM(DCAR.CANTIDAD * DCAR.PRECIO_UNITARIO) OVER() AS 'OpGravada',
        V.IGV AS 'IGV',
        (SUM(DCAR.CANTIDAD * DCAR.PRECIO_UNITARIO) OVER() + V.IGV) AS 'Total'
    FROM CLIENTE AS CLIE 
    INNER JOIN VENTA AS V ON CLIE.ID_CLIENTE = V.ID_CLIENTE 
    INNER JOIN DETALLE_VENTA AS DCAR ON V.ID_VENTA = DCAR.ID_VENTA 
    INNER JOIN PRODUCTO AS PRO ON DCAR.ID_PRODUCTO = PRO.ID_PRODUCTO
    WHERE V.ID_VENTA = @ID_VENTA; 
END;
GO

CREATE OR ALTER PROCEDURE SP_Generar_Venta_Completa (
    @DNI_CLIENTE CHAR(8),     
    @ID_CARRITO CHAR(6)
)
AS
BEGIN
    SET NOCOUNT ON;
    DECLARE @IdVentaGenerada CHAR(4);
    DECLARE @ID_CLIENTE CHAR(4);

    SET @ID_CLIENTE = dbo.FN_Obtener_ID_Cliente_Por_DNI(@DNI_CLIENTE);

    IF @ID_CLIENTE IS NULL BEGIN RETURN; END

    INSERT INTO VENTA (ID_CLIENTE, IGV) VALUES (@ID_CLIENTE, 0.00);

    SELECT TOP 1 @IdVentaGenerada = ID_VENTA FROM VENTA WHERE ID_CLIENTE = @ID_CLIENTE ORDER BY FECHA_HORA DESC;

    INSERT INTO DETALLE_VENTA (ID_VENTA, ID_PRODUCTO, CANTIDAD, PRECIO_UNITARIO, PRECIO)
    SELECT @IdVentaGenerada, DC.ID_PRODUCTO, DC.CANTIDAD, P.PRECIO, DC.PRECIO        
    FROM DETALLE_CARRITO AS DC INNER JOIN PRODUCTO AS P ON DC.ID_PRODUCTO = P.ID_PRODUCTO
    WHERE DC.ID_CARRITO = @ID_CARRITO;

    UPDATE VENTA SET IGV = CAST((SELECT ISNULL(SUM(PRECIO), 0) FROM DETALLE_VENTA WHERE ID_VENTA = @IdVentaGenerada) * 0.18 AS DECIMAL(10,2))
    WHERE ID_VENTA = @IdVentaGenerada;

    UPDATE P SET P.STOCK = P.STOCK - DC.CANTIDAD FROM PRODUCTO AS P INNER JOIN DETALLE_CARRITO AS DC ON P.ID_PRODUCTO = DC.ID_PRODUCTO
    WHERE DC.ID_CARRITO = @ID_CARRITO;

    DELETE FROM DETALLE_CARRITO WHERE ID_CARRITO = @ID_CARRITO;
    UPDATE CARRITO SET MONTO_TOTAL = 0.00, CANTIDAD_PRODUCTOS = 0 WHERE ID_CARRITO = @ID_CARRITO;

    SELECT @IdVentaGenerada AS 'ID_VENTA_GENERADA';
END;
GO



DELETE FROM DETALLE_VENTA;
DELETE FROM DETALLE_CARRITO;
DELETE FROM VENTA;
DELETE FROM CARRITO;
GO

ALTER SEQUENCE Seq_CARRITO_ID RESTART WITH 0;
ALTER SEQUENCE Seq_DETALLE_CARRITO_ID RESTART WITH 0;
ALTER SEQUENCE Seq_VENTA_ID RESTART WITH 0;
ALTER SEQUENCE Seq_DETALLE_VENTA_ID RESTART WITH 0;

-- Reiniciamos las secuencias de productos por si quieres probar de cero
ALTER SEQUENCE Seq_Chocotejas RESTART WITH 1;
ALTER SEQUENCE Seq_Cuchareables RESTART WITH 1;
GO

Exec SP_Agregar_Admin 'A001', 'Alexander Miguel', 'Bejar Centurión', 'alexanderBejar09@gmail.com', '12345678', '77062578', '2002-02-26','930286663';
Exec SP_Agregar_Admin 'A002', 'Angello Fabrizio', 'Camacho Campoverde', 'angellocamacho553@gmail.com','26262626','60995119','2007-02-02', '965193521';
Exec SP_Listar_Admin;
GO

Exec Sp_Agregar_Cliente 'Juan Carlos', 'Perez Ruiz', '45236187', 'contra23', 'juancitoruiz89@gmail.com', '987654321';
Exec Sp_Agregar_Cliente 'Maria Elena', 'Gomez Fernandez', '76543210', 'pass8765', 'mariagomez.1@gmail.com', '912345670';
Exec Sp_Agregar_Cliente 'Luis Alberto', 'Sanchez Torres', '12345678', 'luis1234', 'luissanchez.t@gmail.com', '998877665';
Exec Sp_Agregar_Cliente 'Ana Paula', 'Vargas Castro', '87654321', 'ana_p456', 'anavargas.c@gmail.com', '923456789';
Exec Sp_Agregar_Cliente 'Carlos Eduardo', 'Mendoza Diaz', '45678901', 'carlos99', 'carlosmendoza88@gmail.com', '934567812';
Go

Exec SP_Listar_Clientes;
Go


Exec SP_Agregar_Producto 'Cuchareable de Pudín Chocolate', 'Cuchareables', 'Suave pudín de chocolate oscuro en un formato súper cremoso.', 40, 6.00, '2026-07-31', '77062578';
Exec SP_Agregar_Producto 'Cuchareable de Torta Chocolate', 'Cuchareables', 'Torta húmeda de chocolate con full fudge lista para disfrutar.', 40, 6.00, '2026-07-16', '77062578';
Exec SP_Agregar_Producto 'Cuchareable de Café', 'Cuchareables', 'El intenso y clásico aroma del café en un postre sedoso.', 30, 6.00, '2026-07-16', '77062578';
Exec SP_Agregar_Producto 'Cuchareable de Lúcuma', 'Cuchareables', 'Auténtica crema de lúcuma peruana, dulce y aterciopelada.', 35, 6.50, '2026-07-16', '77062578';
Exec SP_Agregar_Producto 'Cuchareable de Manzana', 'Cuchareables', 'El clásico postre de manzana con toques de canela y crema.', 30, 6.50, '2026-07-16', '77062578';
Exec SP_Agregar_Producto 'Cuchareable de Fresa', 'Cuchareables', 'Capas suaves intercaladas con dulce de fresa natural.', 35, 6.50, '2026-07-16', '77062578';
Exec SP_Agregar_Producto 'Cuchareable de Frutos rojos', 'Cuchareables', 'Un equilibrio perfecto entre lo dulce y el ácido de los frutos rojos.', 30, 6.50, '2026-07-16', '77062578';
Exec SP_Agregar_Producto 'Cuchareable de Maracuyá', 'Cuchareables', 'Frescura cítrica y tropical de puro maracuyá en cada cucharada.', 30, 6.50, '2026-07-16', '77062578';
Exec SP_Agregar_Producto 'Cuchareable de Maracumango', 'Cuchareables', 'La vibrante y deliciosa fusión caribeña de mango dulce y maracuyá.', 25, 6.50, '2026-07-16', '77062578';
Exec SP_Agregar_Producto 'Cuchareable de Tres leches Pistacho', 'Cuchareables', 'Esponjoso tres leches elevado con el sabor premium del pistacho.', 20, 10.00, '2026-07-16', '77062578';
Exec SP_Agregar_Producto 'Cuchareable de Tres leches', 'Cuchareables', 'El clásico bizcocho mojadito en nuestra receta especial de tres leches.', 25, 6.00, '2026-07-16', '77062578';
Exec SP_Agregar_Producto 'Cuchareable de Menta', 'Cuchareables', 'Sabor dulce y muy refrescante a menta para limpiar el paladar.', 20, 6.00, '2026-07-16', '77062578';
Exec SP_Agregar_Producto 'Cuchareable de Oreo', 'Cuchareables', 'Capas de crema suave mezcladas con galleta Oreo troceada y crujiente.', 45, 6.00, '2026-07-16', '77062578';
Exec SP_Agregar_Producto 'Cuchareable de Guanábana', 'Cuchareables', 'El inconfundible sabor exótico y delicado de la guanábana fresca.', 25, 6.50, '2026-07-16', '77062578';
Exec SP_Agregar_Producto 'Cuchareable de Pistacho', 'Cuchareables', 'Suave y cremoso postre con el sabor intenso y elegante del pistacho puro.', 30, 8.00, '2026-07-16', '77062578';

-- Registro de productos - Chocotejas (Autogenerando CH001, CH002, etc.)
Exec SP_Agregar_Producto 'Chocoteja de Pecana', 'Chocotejas', 'La tradicional chocoteja rellena con mitades de pecana crujiente y abundante manjar blanco.', 40, 2.00, '2026-07-16', '60995119';
Exec SP_Agregar_Producto 'Chocoteja de Maní', 'Chocotejas', 'El toque salado y crujiente del maní tostado envuelto en dulce manjar y chocolate.', 35, 2.00, '2026-07-16', '60995119';
Exec SP_Agregar_Producto 'Chocoteja de Pasas', 'Chocotejas', 'Dulces pasas morenas combinadas a la perfección con nuestro suave manjar blanco.', 30, 2.00, '2026-07-16', '60995119';
Exec SP_Agregar_Producto 'Chocoteja de Higo', 'Chocotejas', 'Un exquisito relleno de higo seco que aporta una textura y dulzor únicos al paladar.', 25, 2.00, '2026-07-16', '60995119';
Exec SP_Agregar_Producto 'Chocoteja de Coco', 'Chocotejas', 'Relleno de coco rallado para un sabor suave, delicado y ligeramente tropical.', 30, 2.00, '2026-07-16', '60995119';
Exec SP_Agregar_Producto 'Chocoteja de Oreo', 'Chocotejas', 'Para los más golosos: manjar blanco con trocitos súper crujientes de galleta Oreo.', 45, 2.00, '2026-07-16', '60995119';
Exec SP_Agregar_Producto 'Chocoteja de Ole ole', 'Chocotejas', 'El sabor divertido y nostálgico del dulce Ole Ole bañado en nuestra cobertura.', 30, 2.00, '2026-07-16', '60995119';
Exec SP_Agregar_Producto 'Chocoteja de Chin chin', 'Chocotejas', 'Una explosión de color y sabor con las clásicas grageas Chin Chin de chocolate por dentro.', 35, 2.00, '2026-07-16', '60995119';
Exec SP_Agregar_Producto 'Chocoteja de Gomitas', 'Chocotejas', 'Una sorpresa dulce, frutal y masticable de gomitas en el centro de tu chocoteja.', 25, 2.00, '2026-07-16', '60995119';
Exec SP_Agregar_Producto 'Chocoteja de Marshmello', 'Chocotejas', 'Relleno súper esponjoso y suave de marshmello que se derrite en la boca.', 30, 2.00, '2026-07-16', '60995119';
Exec SP_Agregar_Producto 'Chocoteja de Café', 'Chocotejas', 'Un intenso y aromático relleno de crema de café, ideal para despertar los sentidos.', 35, 2.00, '2026-07-16', '60995119';
Exec SP_Agregar_Producto 'Chocoteja de Maracuyá', 'Chocotejas', 'El toque cítrico perfecto de maracuyá que equilibra deliciosamente el dulzor del chocolate.', 40, 2.00, '2026-07-16', '60995119';
Exec SP_Agregar_Producto 'Chocoteja de Pye de Limón', 'Chocotejas', 'Toda la experiencia de un pye de limón encapsulada en una rica cobertura de chocolate.', 30, 2.00, '2026-07-16', '60995119';
Exec SP_Agregar_Producto 'Chocoteja de Frutos Rojos', 'Chocotejas', 'Una irresistible mezcla dulce y ácida de frutos rojos tipo cheesecake.', 30, 2.00, '2026-07-16', '60995119';
Exec SP_Agregar_Producto 'Chocoteja de Fresa', 'Chocotejas', 'Suave crema de fresa con un perfil de sabor fresco, frutal y veraniego.', 35, 2.00, '2026-07-16', '60995119';
Exec SP_Agregar_Producto 'Chocoteja de Lúcuma', 'Chocotejas', 'El sabor peruano por excelencia en un cremoso relleno de lúcuma fresca.', 40, 2.00, '2026-07-16', '60995119';
Exec SP_Agregar_Producto 'Chocoteja de Piña', 'Chocotejas', 'Un pedacito del trópico con el sabor jugoso, refrescante y dulce de la piña.', 25, 2.00, '2026-07-16', '60995119';
Exec SP_Agregar_Producto 'Chocoteja de Menta', 'Chocotejas', 'La combinación infalible y elegante de chocolate crujiente y relleno fresco de menta.', 30, 2.00, '2026-07-16', '60995119';
Exec SP_Agregar_Producto 'Chocoteja de Pasas borrachas', 'Chocotejas', 'Pasas pacientemente maceradas en licor para un toque intenso, adulto y atrevido.', 30, 2.50, '2026-07-16', '60995119';
Exec SP_Agregar_Producto 'Chocoteja de Pisco Sour', 'Chocotejas', 'Nuestro cóctel bandera transformado en un exquisito relleno cremoso con carácter.', 35, 2.50, '2026-07-16', '60995119';
Exec SP_Agregar_Producto 'Chocoteja de Pisco sour Maracuyá', 'Chocotejas', 'La variante cítrica del pisco sour combinada con el exótico sabor del maracuyá.', 25, 2.50, '2026-07-16', '60995119';

Exec SP_Listar_Productos;

Exec SP_Listar_Admin;
Exec SP_Listar_Clientes;

-- Probando editar (asumiendo que CH001 existe)
EXEC SP_Editar_Producto 'CH001', 'Prueba editada', 'Chocotejas', 'Descripción', 10, 5.50, '2020-12-31';



-- Puedes descomentar estas lineas cuando ya tengas un carrito creado:
-- EXEC SP_Mostrar_Producto_a_Detalle 'CAR000'
-- EXEC SP_Eliminar_Producto_de_DetalleCarrito 'DC002'
-- Select * From detalle_carrito;