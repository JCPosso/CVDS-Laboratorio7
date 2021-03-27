### Escuela Colombiana de Ingeniería
### Ciclos de Vida del desarrollo de Software – CVDS
#### Tecnologías de persistencia - Frameworks de Persistencia - Introducción a MyBatis


### SECCIÓN I. - INTRODUCCIÓN A JDBC

1. Se crea el archivo JDBCExample.java con la configuracion dada por el profesor y seguido de esto se prueba la conexion con la base de datos dbaver:

![](img/conexiondbeaver.png)

2. Se elaboran las funciones  y se prueba el funcionamiento de cada una :
	1. valorTotalPedido 
	2. nombresProductosPedido
	
	![](img/operaciones.png)
	
	3.registrarNuevoProducto : En este punto se registra el producto en la configuracion previa por mediod el siguiente comando:
	
	![](img/registrarproductop1.png)
	
	revisamos en la DB y efectivamente está creado:
	
	![](img/registrarproductop2.png)
	
### SECCIÓN II. - INTRODUCCIÓN A MY BATIS	
Base de datos:
	host: desarrollo.is.escuelaing.edu.co
	puerto: 3306
	usuario: bdprueba
	pwd: prueba2019
	base de datos: bdprueba

## Parte I 

1. En el archivo mybatis-config.xml se añadieron los siguientes los siguientes 'typeAliases' con el fin de que se puedan  acceder a éstos de manera mas fácil:

![](img/MYBATIS-typeAliases.png)

2. Teniendo esto , se proce a realizar cada uno de los mappers teniendo encuenta las relaciones de cada una de las tablas , y probamos cómo a través del 'mapper' generado por MyBatis, se puede consultar todos los clientes

![](img/consultarclientes.png)

3. De igual forma , probamos con el funcionamiento con el fin de conocer si retorna resultados para un cliente en especifico , y los resultados fueron los siguiente:

![](img/consultarcliente.png)

4. Item rentado:

	![](img/mappertipoitemp1.png)
	
	Para el item rentado primero se procedíió a crear el tipo item 	
	Verificamos que se encuentre en la DB :
	
	![](img/mappertipoitemp2.png)
	
	Insertamos el item y verificamos en la DB:
	
	![](img/insertaritem.png)
	
	Por ultimo  , con el item rentado  verificamos que se haya creado correctamente :
	
	![](img/itemrentado.png)
	
5. Consultar item rentado

![](img/itemrentadou.png)
