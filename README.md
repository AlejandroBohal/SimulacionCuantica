## SimulacionCuantica

## Introducción

Simulación de lo clásico a lo cuántico, en este repositorio encontraremos las simulaciones del capitulo 3 de Quantum Computing for Computer Science, para este utilizaremos nuestra librería de complejos que se encuentra en http://github.com/AlejandroBohal/CNYT-2020

## Adecuando la librería para sistemas clásicos y cuánticos

Para esto creamos un nuevo constructor cuya entrada sean únicamente números reales o en su defecto enteros
Y además una nueva clase SimuladorCuantico que se construye con un vector de estado inicial y una matriz de Estados.

![](https://raw.githubusercontent.com/AlejandroBohal/SimulacionCuantica/master/GraficasSimulaciones/ConstructorSimulador.png)

Se realizaron test para probar el respectivo funcionamiento de la simulación de lo clásico a lo cuántico
![](https://raw.githubusercontent.com/AlejandroBohal/SimulacionCuantica/master/GraficasSimulaciones/pruebas.png))
## Operaciones soportadas

  - Hacer clicks en el sistema.
  - Obtener estado actual del sistema.
  - Obtener matriz de Estados del sistema
  - Generar gráficas de probabilidad del sistema (Las gráficas generadas irán directamente al directorio GraficasSimulaciones de la raíz de este repositorio).

## Simulación de canicas
Se realizó la simulación del sistema de canicas que se propuso en el texto guia, además se generaron las gráficas correspondientes del vector de probabilidadades.

### Tests
Test 1
![](https://raw.githubusercontent.com/AlejandroBohal/SimulacionCuantica/master/GraficasSimulaciones/canicas.png)
Test 2
![](https://raw.githubusercontent.com/AlejandroBohal/SimulacionCuantica/master/GraficasSimulaciones/canicas2.png)
 
### Gráficas
Gráfica 1
![](https://raw.githubusercontent.com/AlejandroBohal/SimulacionCuantica/master/GraficasSimulaciones/Canicas%20clasico.jpg)

Gráfica 2
![](https://raw.githubusercontent.com/AlejandroBohal/SimulacionCuantica/master/GraficasSimulaciones/Canicas%20clasico2.jpg)

## Simulación múltiple rendija probabilística

Además de simular el experimento de la doble rendija, también se realizó la simulación de la múltiple rendija probabilística, en la cual no se observa el fenómeno cuántico de la interferencia.

### Test
![](https://github.com/AlejandroBohal/SimulacionCuantica/blob/master/GraficasSimulaciones/rendijasclasico.png)

### Gráfica

![](https://github.com/AlejandroBohal/SimulacionCuantica/blob/master/GraficasSimulaciones/MrClasico.jpg)

## Simulación múltiple rendija cuántica

En la simulación de las multiples rendijas cuántico se puede evidenciar claramente el patrón de interferencia en la posición del vector de probabilidades x7 ya que se cancela el componente por la historia del sistema en otros universos. 

### Test
![](https://github.com/AlejandroBohal/SimulacionCuantica/blob/master/GraficasSimulaciones/rendijascuantico.png)

### Gráfica

![](https://github.com/AlejandroBohal/SimulacionCuantica/blob/master/GraficasSimulaciones/MrCuantico.jpg)

## Simulación doble rendija probabilística y cuantica
Una parte importante de la base de este simulador cuántico surge del problema de la doble rendija, cuya explicación y experimento se realizó en clase, observamos el patron generado por la doble rendija y además se realizón una simulación con la librería mencionada al principio y una descripción a profundidad.

![](https://raw.githubusercontent.com/andresro30/ExperimentoDobleRendija-CNYT/master/imagenes/1.png)
Para más información acerca de este experimento dirigirse a
https://github.com/AlejandroBohal/ExperimentoDobleRendija-CNYT



