# Implementación del Principio de Responsabilidad Única (SRP) en el paquete "s"

## Introducción

El Principio de Responsabilidad Única (SRP) es el primer principio de SOLID. Establece que una clase debe tener una única razón para cambiar, es decir, debe tener una sola responsabilidad bien definida. Este principio facilita:

- La comprensión del código
- El mantenimiento
- Las modificaciones futuras

## Implementación

En el paquete "s", se ha aplicado el SRP mediante la separación de responsabilidades en dos clases distintas:

### Clase `SingleResponsibility`

Esta clase se encarga exclusivamente de la gestión de empleados. Sus responsabilidades incluyen:
- Almacenar la lista de empleados
- Buscar empleados
- Añadir nuevos empleados
- Modificar información de empleados existentes

### Clase `Reporte`

Esta clase se encarga únicamente de la generación de reportes. Sus responsabilidades incluyen:
- Generar reportes por consola
- Generar reportes en Excel

## Análisis de la Implementación

1. **Clase `SingleResponsibility`**:
   - Cumple con el SRP al enfocarse únicamente en la gestión de empleados.
   - Todas sus operaciones están relacionadas con una sola responsabilidad: manejar la información de los empleados.
   - Si se necesitan cambios en cómo se gestionan los empleados, solo esta clase se verá afectada.

2. **Clase `Reporte`**:
   - También cumple con el SRP al centrarse exclusivamente en la generación de reportes.
   - Separa la lógica de reportes de la gestión de empleados, lo que permite que ambas funcionalidades evolucionen de manera independiente.
   - Si se requieren cambios en la forma de generar reportes, solo esta clase necesitará modificaciones.

## Beneficios de esta Implementación

1. **Cohesión mejorada**: Cada clase tiene una responsabilidad clara y bien definida.
2. **Mantenimiento simplificado**: Los cambios en la gestión de empleados o en la generación de reportes afectarán solo a la clase correspondiente.
3. **Mayor flexibilidad**: Es más fácil extender o modificar cada funcionalidad de forma independiente.
4. **Testabilidad mejorada**: Se pueden escribir pruebas unitarias más específicas y enfocadas para cada clase.

## Conclusión

La implementación actual en el paquete "s" demuestra una aplicación efectiva del Principio de Responsabilidad Única. Al separar la gestión de empleados (`SingleResponsibility`) de la generación de reportes (`Reporte`), se ha logrado un diseño más modular y mantenible. Cada clase tiene una única razón para cambiar, lo que facilita futuras modificaciones y mejora la comprensión general del código.

Esta estructura permite que el sistema sea más flexible y fácil de mantener a largo plazo, cumpliendo así con los objetivos del SRP dentro de los principios SOLID.

# Implementación del Principio Abierto/Cerrado (OCP) en el paquete "o"

## Introducción

El Principio Abierto/Cerrado (OCP) es el segundo principio de SOLID. Establece que las entidades de software (clases, módulos, funciones, etc.) deben estar abiertas para su extensión, pero cerradas para su modificación. Esto significa que debemos poder agregar nuevas funcionalidades sin modificar el código existente.

## Implementación

En el paquete "o", se ha aplicado el OCP mediante el uso de una interfaz y la implementación de diferentes figuras geométricas. Veamos cómo se ha logrado:

### Interfaz `IOperacionesFigura`

Esta interfaz define las operaciones comunes para todas las figuras geométricas.

### Clases de Figuras Geométricas

Cada figura geométrica implementa la interfaz `IOperacionesFigura`:

1. **Círculo**
2. **Cuadrado**
3. **Triángulo**

### Clase `Figura`

Esta clase actúa como un punto de entrada para calcular el área y el diámetro de cualquier figura que implemente `IOperacionesFigura`.

## Análisis de la Implementación

1. **Extensibilidad**: 
   - El sistema está abierto para extensión. Podemos agregar nuevas figuras geométricas (como rectángulos, pentágonos, etc.) simplemente creando nuevas clases que implementen `IOperacionesFigura`.
   - No es necesario modificar la clase `Figura` ni ninguna otra clase existente para agregar nuevas formas.

2. **Cerrado para modificación**:
   - La clase `Figura` no necesita ser modificada cuando se agregan nuevas formas geométricas.
   - Las implementaciones existentes de las figuras (Círculo, Cuadrado, Triángulo) no requieren cambios cuando se añaden nuevas figuras.

3. **Polimorfismo**:
   - El uso de la interfaz `IOperacionesFigura` permite tratar todas las figuras de manera uniforme en la clase `Figura`.

4. **Flexibilidad**:
   - Es fácil añadir nuevos métodos a la interfaz `IOperacionesFigura` si se necesitan nuevas operaciones comunes para todas las figuras.

## Ejemplo de Uso

```java
public class Inicio {
   public static void main(String[] args) {
      var circulo = new Circulo(2);
      var cuadrado = new Cuadrado(5);
      var figura = new Figura();
      System.out.println(figura.area(circulo));
      System.out.println(figura.diametro(circulo));
      System.out.println(figura.area(cuadrado));
   }
}
```

Este ejemplo demuestra cómo se pueden usar diferentes figuras con la misma clase `Figura` sin necesidad de modificarla.

## Conclusión

La implementación actual en el paquete "o" demuestra una aplicación efectiva del Principio Abierto/Cerrado. Al utilizar una interfaz común (`IOperacionesFigura`) y permitir que diferentes figuras la implementen, el sistema está abierto para la extensión (nuevas figuras) pero cerrado para la modificación (no es necesario cambiar el código existente para agregar nuevas figuras).

Esta estructura permite una fácil expansión del sistema para incluir nuevas formas geométricas en el futuro, manteniendo el código existente intacto y cumpliendo así con los objetivos del OCP dentro de los principios SOLID.

# Implementación del Principio de Sustitución de Liskov (LSP) en el paquete "l"

## Introducción

El Principio de Sustitución de Liskov (LSP) es el tercer principio de SOLID. Establece que los objetos de una superclase deben poder ser reemplazados por objetos de sus subclases sin afectar la corrección del programa. En otras palabras, las clases derivadas deben ser sustituibles por sus clases base.

## Implementación

En el paquete "l", se ha aplicado el LSP mediante la creación de una clase abstracta `Report` y sus subclases `Excel` y `Pdf`. Veamos cómo se ha logrado:

### Clase abstracta `Report`

```java
public abstract class Report {
    private final String name;

    protected Report(String pName) {
        this.name = pName;
    }

    public abstract byte[] export();

    public String getName() {
        return name;
    }
}
```

Esta clase abstracta define la estructura básica de un reporte, con un método abstracto `export()` que todas las subclases deben implementar.

### Subclases `Excel` y `Pdf`

1. **Excel**
```java
public class Excel extends Report {
    protected Excel(String pName) {
        super(pName);
    }

    @Override
    public byte[] export() {
        return new byte[0];
    }
}
```

2. **Pdf**
```java
public class Pdf extends Report {
    protected Pdf(String pName) {
        super(pName);
    }

    @Override
    public byte[] export() {
        return new byte[0];
    }
}
```

Ambas subclases extienden `Report` e implementan el método `export()`.

### Clase `SubstitutionLiskov`

```java
public class SubstitutionLiskov {
    public void sendReport(int typeReport, String name) {
        Report report;

        if(typeReport == 1)
            report = new Excel(name);
        else
            report = new Pdf(name);

        System.out.println(Arrays.toString(report.export()));
    }
}
```

Esta clase demuestra cómo se puede usar el principio de sustitución de Liskov.

## Análisis de la Implementación

1. **Sustitución**: 
   - En el método `sendReport`, se puede usar indistintamente un objeto `Excel` o `Pdf` en lugar de `Report`.
   - Esto demuestra que las subclases (`Excel` y `Pdf`) son completamente sustituibles por su clase base (`Report`).

2. **Abstracción**:
   - La clase `Report` es abstracta, definiendo un contrato que todas las subclases deben seguir.
   - El método `export()` es abstracto, asegurando que todas las subclases lo implementen.

3. **Polimorfismo**:
   - El método `sendReport` trabaja con la clase base `Report`, permitiendo que cualquier subclase de `Report` pueda ser utilizada sin cambiar el código.

4. **Extensibilidad**:
   - Se pueden añadir nuevos tipos de reportes (por ejemplo, `Word` o `HTML`) sin modificar la clase `SubstitutionLiskov`.

## Beneficios de esta Implementación

1. **Flexibilidad**: El sistema puede manejar diferentes tipos de reportes de manera uniforme.
2. **Mantenibilidad**: Agregar nuevos tipos de reportes no requiere cambios en la lógica existente.
3. **Robustez**: El código cliente (`SubstitutionLiskov`) no necesita conocer los detalles específicos de cada tipo de reporte.

## Conclusión

La implementación en el paquete "l" demuestra una aplicación efectiva del Principio de Sustitución de Liskov. Al utilizar una clase abstracta base (`Report`) y subclases que la extienden (`Excel` y `Pdf`), se asegura que cualquier instancia de las subclases pueda ser utilizada donde se espera una instancia de la clase base, sin afectar el comportamiento del programa.

Esta estructura permite una fácil extensión del sistema para incluir nuevos tipos de reportes en el futuro, manteniendo la integridad del diseño y cumpliendo con los objetivos del LSP dentro de los principios SOLID.

# Implementación del Principio de Segregación de Interfaces (ISP) en el paquete "i"

## Introducción

El Principio de Segregación de Interfaces (ISP) es el cuarto principio de SOLID. Establece que ninguna clase debe ser forzada a implementar interfaces que no usa, o los clientes no deben ser forzados a depender de métodos que no usan. En otras palabras, es mejor tener muchas interfaces específicas que una interfaz general.

## Implementación

En el paquete "i", se ha aplicado el ISP mediante la creación de interfaces separadas para diferentes grupos de funcionalidades. Veamos cómo se ha logrado:

### Interfaces Segregadas

1. **IMethod**

```java
public interface IMethod {
    String add(int id, String toAdd);
    boolean delete(int id);
    boolean update(int id, String newString);
    String getString(int id);
}
```

Esta interfaz agrupa métodos relacionados con operaciones CRUD básicas.

2. **ISearch**

```java
public interface ISearch {
    List<String> getStringsWithId(int id);
    List<String> findWithNullId();
}
```

Esta interfaz se centra en métodos de búsqueda.

### Clases que implementan las interfaces

1. **ServiceSegregacionInterfaces**

```java
public class ServiceSegregacionInterfaces implements IMethod, ISearch {
    // Implementación de todos los métodos de IMethod e ISearch
}
```

Esta clase implementa ambas interfaces, demostrando que una clase puede implementar múltiples interfaces si necesita todas las funcionalidades.

2. **Clase2**

```java
public class Clase2 implements IMethod {
    // Implementación de solo los métodos de IMethod
}
```

Esta clase implementa solo la interfaz `IMethod`, demostrando que una clase puede elegir implementar solo las interfaces que necesita.

## Análisis de la Implementación

1. **Segregación de Responsabilidades**: 
   - Las interfaces `IMethod` e `ISearch` están separadas, cada una con un conjunto específico de métodos relacionados.
   - Esto permite que las clases implementen solo las interfaces que necesitan.

2. **Flexibilidad**:
   - `ServiceSegregacionInterfaces` implementa ambas interfaces, mostrando que una clase puede combinar múltiples interfaces según sus necesidades.
   - `Clase2` implementa solo `IMethod`, demostrando que no está obligada a implementar métodos que no necesita.

3. **Principio "Interface Segregation"**:
   - La implementación evita que las clases sean forzadas a depender de métodos que no usan.
   - Cada interfaz tiene una responsabilidad clara y específica.

4. **Mantenibilidad**:
   - Los cambios en una interfaz afectarán solo a las clases que realmente dependen de esos métodos.
   - Es más fácil extender o modificar el sistema sin afectar a todas las clases.

## Beneficios de esta Implementación

1. **Código más limpio**: Las clases solo implementan los métodos que realmente necesitan.
2. **Mayor cohesión**: Cada interfaz tiene un propósito claro y específico.
3. **Flexibilidad**: Las clases pueden implementar múltiples interfaces según sus necesidades.
4. **Facilidad de mantenimiento**: Los cambios en una interfaz no afectan a todas las clases del sistema.

## Conclusión

La implementación en el paquete "i" demuestra una aplicación efectiva del Principio de Segregación de Interfaces. Al dividir las funcionalidades en interfaces más pequeñas y específicas (`IMethod` e `ISearch`), se permite que las clases implementen solo los métodos que realmente necesitan.

Esta estructura promueve un diseño más flexible y mantenible, donde las clases no están sobrecargadas con métodos innecesarios y pueden evolucionar de manera más independiente. Cumple así con los objetivos del ISP dentro de los principios SOLID, facilitando la creación de un sistema más modular y fácil de mantener.

# Implementación del Principio de Inversión de Dependencias (DIP) en el paquete "d"

## Introducción

El Principio de Inversión de Dependencias (DIP) es el quinto principio de SOLID. Establece que los módulos de alto nivel no deben depender de módulos de bajo nivel, sino que ambos deben depender de abstracciones. Además, las abstracciones no deben depender de los detalles, sino los detalles de las abstracciones.

## Implementación

En el paquete "d", se ha aplicado el DIP mediante el uso de una interfaz `IInfo` y clases que la implementan. Veamos cómo se ha logrado:

### Interfaz `IInfo`

```java
public interface IInfo {
    List<Post> lecturaJson();
}
```

Esta interfaz define el contrato para la lectura de información.

### Clases que implementan `IInfo`

1. **InfoByFile**

```java
public class InfoByFile implements IInfo {
    // Implementación de lecturaJson() para leer desde un archivo
}
```

2. **InfoByXML**

```java
public class InfoByXML implements IInfo {
    // Implementación de lecturaJson() para leer desde XML
}
```

### Clase de alto nivel `Monitor`

```java
public class Monitor {
    private final String origin;
    private IInfo iInfo;

    public Monitor(String origin, IInfo iInfo) {
        this.origin = origin;
        this.iInfo = iInfo;
    }

    public void show() {
        var posts = iInfo.lecturaJson();
        posts.forEach(post -> System.out.println(post.getTittle()));
    }
}
```

### Clase principal `InversionDependencias`

```java
public class InversionDependencias {
    public static void main(String[] args) {
        var iInfo = new InfoByXML();
        var monitor = new Monitor("./data/info.json", iInfo);
        monitor.show();
    }
}
```

## Análisis de la Implementación

1. **Abstracción**:
   - La interfaz `IInfo` actúa como una abstracción para la lectura de información.
   - Las clases de alto nivel (`Monitor`) dependen de esta abstracción, no de implementaciones concretas.

2. **Inversión de Dependencias**:
   - `Monitor` no crea instancias directamente de `InfoByFile` o `InfoByXML`.
   - En su lugar, recibe una implementación de `IInfo` a través de su constructor.

3. **Flexibilidad**:
   - Se pueden añadir nuevas fuentes de información (por ejemplo, `InfoByDatabase`) sin modificar la clase `Monitor`.

4. **Desacoplamiento**:
   - `Monitor` está desacoplado de las implementaciones específicas de lectura de información.

## Beneficios de esta Implementación

1. **Código más flexible**: Es fácil cambiar la fuente de información sin modificar la clase `Monitor`.
2. **Facilidad de pruebas**: Se pueden crear implementaciones de prueba de `IInfo` para probar `Monitor`.
3. **Mantenibilidad mejorada**: Los cambios en las implementaciones de `IInfo` no afectan a `Monitor`.
4. **Extensibilidad**: Se pueden añadir nuevas fuentes de información fácilmente.

## Conclusión

La implementación en el paquete "d" demuestra una aplicación efectiva del Principio de Inversión de Dependencias. Al hacer que `Monitor` dependa de la abstracción `IInfo` en lugar de implementaciones concretas, se logra un diseño más flexible y desacoplado.

Esta estructura permite que el sistema sea más fácil de mantener y extender, ya que los módulos de alto nivel no dependen directamente de los módulos de bajo nivel. Cumple así con los objetivos del DIP dentro de los principios SOLID, facilitando la creación de un sistema más robusto y adaptable a cambios futuros.