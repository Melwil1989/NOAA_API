## NOAA: monitoreo de boyas en altamar

***NOAA*** es una API realizada como challenge de cursada, que tiene las siguientes funcionalidades:

1. Crear boyas, para lo cual se necesitan las coordenadas (latitud y longitud) de instalación. Cada boya posee una luz que cambia de color según la altura del mar; 
    al crear la boya, esta luz se genera por defecto con color AZUL que es "indefinido".
2. Crear muestras. Cada muestra corresponde a una única boya, y registra la altitud del mar donde se encuentra la boya y las coordenadas donde se registró la muestra,
    y también embarcaciones cercanas.
3. Traer la información de las boyas o de una boya particular (sin la lista de muestras).
4. Conocer las muestras de una boya específica.
5. Cambiar el color de la luz de una boya (conociendo el ID de la boya), y resetear el color de la luz a AZUL a partir de una muestra específica.

#### Tecnologías y herramientas utilizadas

1. Java 11
2. Spring Boot
3. Hibernate
4. MySQL

#### Deploy (con Heroku)

https://ada-noaa-mw.herokuapp.com/

#### Documentación Postman

[Link a Postman](https://web.postman.co/workspace/f489c586-9526-482c-817a-e53fe9983fc9/documentation/16169865-b1e55a1d-8d74-4a25-b869-570f58fbd6bb)

#### Esquema de la base de datos

![EsquemaNOAA](https://user-images.githubusercontent.com/79877606/140363316-ec64b969-6fdc-4ed7-97ef-b01427a41870.png)
