# ADDBBlab5
Repositori de la App que gestiona una TSDB i una RDB SQL per l'assignatura de Bases de Dades Avançades.

# Utilització

## Docker

Per utilitzar l'aplicació primer s'ha de descarregar l'aplicació [Docker Desktop](https://www.docker.com/products/docker-desktop), disponible tant per Windows, Mac o Linux, que permet executar contenidors docker.

Un cop descarregada i executant-se, s'ha de clonar aquest repositori i dins d'ell, a la carpeta arrel, executar per terminal la següent comanda: 

### `docker consumer up -d`

Amb això, s'executarà la base de dades MySQL, l'aplicació exporter encarregada d'expossar dades estadístiques de la base de dades MySQL (es pot visualitzar a [http://localhost:9104/metrics](http://localhost:9104/metrics)) i Prometheus, que es pot accedir a la GUI a [http://localhost:9090](http://localhost:9090).

## Aplicació Java
un cop executant-se els tres dockers, s'ha d'executar el codi Java (main.java) que es troba a la carpeta arrel del repositori. Es recomana utilitzar el JDK versió 11, es pot trobar [aquí](https://www.oracle.com/es/java/technologies/javase/jdk11-archive-downloads.html).

El codi Java consta d'un menú on es podrà realitzar 3 accions: 
SELECT, INSERT o DELETE
Aquestes accions permeten escriure queries SQL per realitzar un SELECT (Lectura de dades), un INSERT (insserció de dades) o un DELETE (eliminació de dades).

A continuació afegim algunes queries d'exemple que es poden utilitzar per provar l'APP:

SELECT: `SELECT id, coresCPU, usedMemoryRAM, availableDiskSpace FROM statistics;`

INSERT: `INSERT INTO statistics (coresCPU, usedMemoryRAM, availableDiskSpace) VALUES (4, 2.4, 165.98);`

DELETE: `DELETE FROM statistics WHERE coresCPU=4;`

## Com visualitzar les afectacions a la TSDB

A Prometheus es pot consultar les estadístiques de la base de dades per veure com es modifiquen les dades en la TSDB de Prometheus quan realitzem una de les 3 accions a la base de dades SQL.

Recomenem aquesta Query per Prometheus ja que mostra les insercions realitzades, les eliminacions, les lectures de dades i les escritures:

### `mysql_global_status_innodb_row_ops_total`