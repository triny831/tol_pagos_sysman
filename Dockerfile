FROM tomcat:9.0-jdk17

# Limpia aplicaciones por defecto de Tomcat
RUN rm -rf /usr/local/tomcat/webapps/*

# Copia el WAR generado por Maven
COPY target/tol_pagos.war /usr/local/tomcat/webapps/ROOT.war

# Exponer puerto
EXPOSE 8080

# Ejecutar Tomcat
CMD ["catalina.sh", "run"]