# Order Service

Este é um serviço de pedidos construído com Spring Boot, responsável por gerenciar a criação de pedidos.

## Pré-requisitos

- Java 17 ou superior
- Gradle
- PostgreSQL
- Kafka

## Configuração

1. Copie o arquivo `.env.example` para `.env`:

   ```
   cp .env.example .env
   ```

2. Edite o arquivo `.env` com suas configurações:

   ```
   DB_HOST=localhost
   DB_PORT=5432
   DB_NAME=orders_db
   DB_USER=your_user
   DB_PASSWORD=your_password

   KAFKA_BOOTSTRAP_SERVERS=localhost:9092
   ```

   Certifique-se de que o PostgreSQL e o Kafka estejam rodando com essas configurações.

## Execução

Para executar o projeto, use o Gradle Wrapper:

```
./gradlew bootRun
```

O serviço estará disponível em `http://localhost:8081`.

## API

### Criar Pedido

**Endpoint:** `POST /orders`

**Corpo da Requisição:**

```json
{
  "customerId": "550e8400-e29b-41d4-a716-446655440000",
  "total": 150.75
}
```

**Exemplo de curl:**

```bash
curl -X POST http://localhost:8081/orders \
  -H "Content-Type: application/json" \
  -d '{
    "customerId": "550e8400-e29b-41d4-a716-446655440000",
    "total": 150.75
  }'
```

**Resposta de Sucesso:**

```json
{
  "id": "123e4567-e89b-12d3-a456-426614174000",
  "customerId": "550e8400-e29b-41d4-a716-446655440000",
  "total": 150.75,
  "createdAt": "2023-10-01T12:00:00Z"
}
```

(O texto inclui conteúdo gerado por inteligência artificial)
