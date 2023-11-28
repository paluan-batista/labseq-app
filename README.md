# Labseq App


LabSeq Service is a RESTful API developed using Spring Boot that calculates values from the 'labseq' sequence. The 'labseq' sequence follows specific rules and generates values based on a given index.
## Functionality

The sequence labseq – l(n) - is defined as follows:
- n=0 => l(0) = 0
- n=1 => l(1) = 1
- n=2 => l(2) = 0
- n=3 => l(3) = 1
- n>3 => l(n) = l(n-4) + l(n-3)

### How to Use

#### Swagger Documentation
- The API endpoints and usage are documented using Swagger.
- To access the Swagger UI, run the application and navigate to `http://localhost:8080/swagger-ui/index.html` in your web browser.
- Swagger provides detailed information on available endpoints, request parameters, and response formats.

### Running with Docker

- First, clone the project:
   ```bash
   $git clone https://github.com/paluan-batista/labseq-app.git
  ```

- Access the project package:
  ```bash
   $cd labseq-app/
  ```

You can run the LabSeq API using Docker. Follow these steps:

1. **Grant permission to the docker-run.sh file:**
    ```bash
    chmod +x docker-run.sh
    ```

2. **Run the Docker Container:**
    ```bash
    ./docker-run.sh
    ```

3. **Access the Service Documentation:**
   - Swagger UI: `http://localhost:8080/swagger-ui/index.html`

### Development

- **Java**: Use Java 17 to build and run the application.
- **Spring Boot**: Utilizes Spring Boot framework to create the RESTful API.

### Contributions
Contributions and feature requests are welcome! Please fork the repository and submit a pull request.

### License
This project is licensed under the [MIT License](LICENSE).
