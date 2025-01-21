# Etapa 1: Build da aplicação Java usando Maven
FROM maven:3.8.6-openjdk-17 AS builder

# Defina o diretório de trabalho no container
WORKDIR /app

# Copie os arquivos do projeto para o container
COPY pom.xml .
COPY src ./src

# Execute o Maven para empacotar a aplicação
RUN mvn clean install -DskipTests

# Etapa 2: Construção da imagem final para rodar o JAR
FROM openjdk:17-jdk-slim

# Defina o diretório de trabalho no container
WORKDIR /app

# Copie o arquivo JAR gerado na etapa de build para esta etapa
COPY --from=builder /app/target/*.jar /app/app.jar

# Expor a porta da aplicação
EXPOSE 8080

# Comando para executar a aplicação
CMD ["java", "-jar", "/app/app.jar"]
