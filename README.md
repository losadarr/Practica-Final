# Practica-Final
## Introducción
En esta práctica final se aplican todos los conceptos vistos en clase orientados a una página web para Iberdrola, la cual se divide en dos partes principales.
## Parte de clientes
En esta parte se incluyen las páginas pensadas para poder ser accedidas por cualquiera. Partimos de index.html, que muestra información sobre la empresa y hace de punto de partida para el resto de páginas.
### Formulario de contacto
La primera de las páginas secundarias es el formulario de contacto, que recoge la información de contacto de clientes pensada para contactar con ellos. Esta información, al pulsarse el botón de envío, contacta con un el endpoint /contacto con una petición POST, y guarda la información en la base de datos correspondiente. Por ahora no tenemos pensado que estas peticiones de contacto sean visibles así que solo se puede guardar información.
### Páginas informativas
También se incluyen una serie de páginas con información acerca de la empresa, como info.html, que da información general para empresas, y precios.html, que muestra los precios para empresas, conectada a la página del formulario de contacto para que potenciales clientes puedan ponerse en contacto.
## Parte de administradores
La segunda y principal parte de la práctica consiste en la gestión de un parque eólico de Iberdrola. Para todo esto se incluye un paso de autenticación, en el cual los operarios del parque pueden iniciar sesión y acceder a la segunda parte de esta maravillosa práctica.
### Lógica de autenticación
En la página login.html los administradores pueden autenticarse mediante correo y contraseña, contactando mediante peticiones post al endpoint /usuario, que les proporciona acceso al resto de las páginas.
### Gestión de turbinas
La primera que nos concierne es ppal.html, que se encarga principalmente de gestionar las turbinas del parque. Cada turbina tiene una serie de parámetros que se pueden visualizar y modificar en todo momento, mediante peticiones al endpoint /turbinas. Para que los operarios siempre tengan la información necesaria a mano, se incluye la página guia.html, que les permite saber como ajustar los parámetros en función del clima, que también aparece en la pantalla.
### Gestión de generadores

### Clima
No tenemos una forma realista de sacar la información verdadera acerca del clima, ya que todos los APIs que hemos encontrado por Internet son de pago, por lo que hemos creado el nuestro en el endpoint /clima, que mediante peticiones get genera una serie de condiciones climáticas que se muestran en la página ppal.html.
