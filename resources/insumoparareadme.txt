insumo para readme

gradle ca --package=co.com.erikdhv --type=reactive --name=inventory --lombok=true --mutation=true --metrics=true


build.gradle

plugins {
    id "co.com.bancolombia.cleanArchitecture" version "3.17.15"
}

- Rregistrar nueva mercancía
- Editar Mercancia
- Eliminar Mercancia
- Mostrar mercancía
	- los filtros de búsqueda pueden ser por fecha, usuario y/o nombre (se debe buscar mínimo por un filtro).
	- Para eliminar mercancía, solo lo puede hacer el usuario que la registró.
- Registrar usuario
- Consultar usuario