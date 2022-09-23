show tables;

/* Crear tabla EMPLEADOS */

CREATE TABLE EMPLEADOS (
	cod int primary key auto_increment not null,
	nombre varchar(255),
	apellido varchar(255),
	edad int,
	nroDoc varchar(20),
	depart varchar(255),
	puesto varchar(255)
)

/* Insertar */

insert into EMPLEADOS (nombre, apellido, edad, nroDoc, depart, puesto)
values
("Carmen", "Rodriguez", 42, "48042109", "Marketing", "Social Media Manager"),
("Arturo", "Guerrero", 33, "23040902", "Ventas", "Vendedor"),
("Tatiana", "Medina", 29, "43053178", "Ventas", "Vendedora"),
("Olivia", "Juarez", 43, "77067106", "Marketing", "Redactora"),
("Bruno", "Fernandez", 41, "79053377", "Sistemas", "Desarrollador"),
("Ricardo", "Manrique", 38, "46040912","Sistemas", "Alasista de sistemas"),
("Patricia", "Bernales", 38, "45057498", "Marketing", "Community Manager");



/* Actualizar */

update EMPLEADOS set nombre="Angélica" where cod=3;


/* Eliminar */

delete from EMPLEADOS where nroDoc="23040902";

/* Consultar */
select * from EMPLEADOS


/* Procedimiento almacenado */

CREATE PROCEDURE deleteDoc (IN p_nroDoc varchar(255))

		begin
			delete from EMPLEADOS where nroDoc = p_nroDoc;
		end


		CALL deleteDoc ("45057498");