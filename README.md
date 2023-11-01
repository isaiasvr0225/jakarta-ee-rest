
# Jakarta EE Rest API example

In this project I made a Rest API using Jakarta EE, the dependecies used were: RESTEasy Jax-RS, JPA with EclipseLink implementation, Lombok and MySql driver.

This rest api exposes endpoints to post, get, update, delete Pets from a data base.



## API Reference


```http
  GET /api/pets
```

| Parameter | Return Type     | Description                |
| :-------- | :------- | :------------------------- |
| `none` | `List<Pet>` | Return all pets. |


```http
  GET /api/pets/{id}
```

| Parameter | Return Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `Pet` | Return a pet with the specific **id** 

```http
  POST /api/pets
```

| Parameter | Return Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `none`      | `String` |  Save a new pet and return the url that we'll be able to find it|

```http
  PUT /api/pets/{id}
```

| Parameter | Return Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `Pet` |  Find a pet with the specific **id** and update this one.|

```http
  DELETE /api/pets/{id}
```

| Parameter | Return Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `Pet` |  Find a pet with the specific **id** and delete this one.|