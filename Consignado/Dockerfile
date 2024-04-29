FROM amazoncorretto:17 as build

COPY . .

CMD ./mvnw packpage

WORKDIR /target

# quando a imagem dar start vai excutar comando
ENTRYPOINT ["java", "-jar", "Consignado-0.0.1-SNAPSHOT.jar"]