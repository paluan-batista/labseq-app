mvn package -DskipTests && docker build -t api.labsaq-app . && docker-compose up -d