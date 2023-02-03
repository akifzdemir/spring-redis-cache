
# Spring boot Redis Cache

Crud App using Redis Cache, Spring boot and PostgreSQL



## Contents

 - [API Reference](#ap-reference)
 - [Screenshots](#screenshots)


## API Reference

#### Get all products

```http
  GET /api/product/getall
```

#### Get product

```http
  GET /api/product/${id}
```

#### Add product

```http
  POST /api/product/add
```

#### Update product

```http
  PUT /api/product/update/${id}
```

#### Delete product

```http
  DELETE /api/product/delete/${id}
```

## Screenshots
### First request (with 2 seconds delay)

![App Screenshot](/img/1.png)

### Cached request

![App Screenshot](/img/2.png)


