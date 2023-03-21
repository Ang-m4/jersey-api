# Calculator REST app 🧮

## Inicialización 🏁

Es obigatorio el uso de Docker para inicializar los servicios y comunicarlos. Dentro del código hay un archivo `docker-compose.yaml` donde ya están configurados los puertos de los servicios.

Para iniciar los servicios hay que usar el comando:

```bash
docker compose up -d
```

En dado caso que se desee tener más de una instancia de cada servicio hay que usar el siguiente comando:

```bash
docker compose up -d --scale service=num_instances
```

El ejemplo para el proyecto es:

```bash
docker compose up -d --scale add=2 --scale subtract=2 --scale multiply=2 --scale divide=2
```
