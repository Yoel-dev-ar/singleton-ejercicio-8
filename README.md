Ejercicio 8: Refactorización hacia Inyección de Dependencias

Contexto del problema: Una aplicación heredada utiliza llamadas estáticas directas a un Singleton de pasarela de pago dispersas por todo el código fuente. Esto hace que el código sea complejo de probar de forma aislada mediante pruebas unitarias con dobles de prueba o simulaciones.

Objetivo de aprendizaje: Refactorizar un diseño rígido basado en Singleton acoplado hacia un patrón donde la única instancia sea gestionada y provista mediante principios de inversión de dependencias.

Requisitos funcionales:

Mantener la restricción de que exista una única instancia de la pasarela de pago en todo el ciclo de vida del proceso.

Permitir que los componentes que consumen el servicio reciban la instancia a través de constructores en lugar de invocar llamadas estáticas rígidas dentro de su lógica interna.

Restricciones técnicas:

La clase de la pasarela de pago debe conservar su control interno de instancia única, pero debe diseñarse para interoperar correctamente con esquemas de diseño limpios.

Ninguna clase consumidora debe instanciar directamente la pasarela ni depender de llamadas globales acopladas en su interior.

# Ejercicio 8: Directorio Interno del Banco (Patrón Singleton)

## Temática

Banca Digital y Tradicional — Consulta centralizada del estado operativo de las áreas internas.

## Consigna

El banco cuenta con distintas áreas operativas (como Cuentas o Préstamos) que pueden estar activas o en mantenimiento en cualquier momento. Si Sistemas y Atención al Cliente consultaran mapas separados o estados desactualizados, el banco podría ofrecer un servicio caído o desconocer su disponibilidad real.

El objetivo es aplicar el patrón Singleton para centralizar el directorio de servicios internos en una única referencia compartida, permitiendo registrar áreas, actualizar su estado y verificar si están disponibles desde cualquier sector.

## Explicación lógica

1. Atributos: En la clase DirectorioInternoBanco se declara serviciosBanco (private Map<String, String>) para almacenar el nombre de cada área junto con su estado actual, y instancia (private static DirectorioInternoBanco), que va a conservar la única referencia en memoria para que todos los sectores registren y consulten sobre el mismo directorio.
2. Instancia única: El constructor se define como private para impedir que se creen directorios paralelos usando new, y además inicializa el HashMap vacío cuando se crea por primera vez. El método getInstancia() controla el acceso: revisa si instancia es null (es decir, si todavía no se creó), la instancia una sola vez y en las siguientes llamadas devuelve siempre ese mismo objeto ya existente.
3. Asignación y Acceso: En Main, se obtiene la instancia desde dos sectores (dirSistemas y dirAtencion) y se cargan áreas con registrarServicio(...), guardando el estado de cada una e informando el registro por consola. Luego, al consultar estaDisponible(...), se busca el estado de la clave (o "NO EXISTE" si no figura) y se devuelve true solo si está en "ACTIVO", mientras que la comparación dirSistemas == dirAtencion confirma que ambas variables apuntan exactamente al mismo objeto en memoria.



## Estructura del ejercicio

* DirectorioInternoBanco.java: Implementa el Singleton con el mapa encapsulado de servicios y los métodos registrarServicio(...) y estaDisponible(...)
* Main.java: Registra áreas desde Sistemas, consulta disponibilidad desde Atención al Cliente y verifica que comparten la misma instancia



