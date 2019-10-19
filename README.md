# quarkus
Quarkus playground

### Keycloak

##### start in docker
```
docker run -d -p 8084:8080 -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=1234 --name keycloak jboss/keycloak
```

##### Setup
https://kodnito.com/posts/microprofile-jwt-with-keycloak/

##### create token with postman
```
POST /auth/realms/carve/protocol/openid-connect/token HTTP/1.1
Host: localhost:8084
Cache-Control: no-cache
Content-Type: application/x-www-form-urlencoded

realm=carve&grant_type=password&client_id=quarkus&username=rik&password=1234
```
