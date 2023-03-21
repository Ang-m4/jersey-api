# Jersey trips API 🛩️

## Inicialización 🏁

Es obigatoria la instalacion de maven para el manejo de dependencias asociadas a los proyectos presentados. En general se presentan 2 proyectos: Un cliente y un servidor probando la comunicacion generada a atraves de Jersey.

### Server 💾
Para iniciar el servidor que expondra la api se ejecuta el siguiente comando

```
cd server 
mvn clean
mvn package
mvn exec:java -Dexec:mainClass="javeriana.ms.rest.ServerMain" 
```

Una vez escritos y ejecutados los comandos, el servidor web escuchara en el puerto 8080 las peticiones generadas desde cualquier cliente

### Cliente 💻

Con el fin de probar la funcionalidad del servidor se implemento un cliente a traves de codigo, este puede ser ejecutado de la siguiente manera:

```
cd client
mvn clean
mvn package
mvn exec:java -Dexec:mainClass="javeriana.ms.rest.ClientMain" 
```

El cliente impirmira las respuestas obtenidas por cada uno de los endpoints implementados en el lado del servidor.
