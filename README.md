# spring boot with easy-rules learning

## how to running

### 1. start service

```code

mvn clean spring-boot:run

```

### 2. curl for test

```code
curl --location --request POST 'http://localhost:8080' \
--header 'Content-Type: application/json' \
--data-raw '{
  	"name":"dalonng",
  	"age":27,
  	"userinfo":{
  		"name2":"demo",
  	     "age2":333
  	}
}' | jq .
```

result:

```code
{
  "name": "rongfengliang",
  "age": 27,
  "userinfo": {
    "name2": "rule wwwwwwwwwwwwwwwwww",
    "age2": 333
  }
}
```