## How To Secure Distributed Systems Using Oauth2 OIDC JWT
### Keycloak :
  - install from : [keycloak](https://www.keycloak.org/downloads)
  - Launch Keycloak server: **keycloak/bin >** `kc.[bat/sh] start-dev`
  - Because keycloak is based on JPA, it needs a database (by default it uses H2, but we can use MySQL, Postgres, Oracle, etc.)
  - To configure a specific database :
      - Before launching server : **keycloak/bin >** `kc.[bat/sh] build  --db {db}` (db = h2, mysql, postgres, oracle, etc.)
      - launch server : **keycloak/bin >** `kc.[bat/sh] start-dev --db={db} --db-url={dbUrl} --db-username={dbUsername} --db-password={dbPassword}`
  - Access keycloak admin console : `http://localhost:8080`
  - Create an admin account :
![keycloak admin console](img/keycloak.png)
![](img/keycloak2.png)
  
  - Create a Realm : 
      - Realm is is a concept in Keycloak that refers to an object managing a set of users along with their credentials, roles and groups. A user in Keycloak belongs to only one realm and the user who logs in to Keycloak will log into that user’s realm. We can have multiple realms in a Keycloak server, these realms will be independent of each other and they only manage their users.
      - **Master** (default realm) : the realm with the highest power in the realm of the Keycloak server, the admin user in the master realm will have the right to view and manage the other realm.
![](img/keycloak3.png)

  - Create Clients :
![](img/keycloak4.png) 
![](img/keycloak6.png)
![](img/keycloak7.png)
  - Create Users : 
![](img/keycloak8.png)
![](img/keycloak9.png)
![](img/keycloak10.png)
![](img/keycloak11.png)
  - Create Roles :
![](img/keycloak12.png)
![](img/keycloak13.png)
![](img/keycloak14.png)
  - Assign Roles to Users :
![](img/keycloak15.png)
![](img/keycloak16.png)
- Test With Postman :
![](img/keycloak17.png)
![](img/keycloak18.png)
  - Authentication with password :
![](img/keycloak19.png)
![](img/keycloak20.png)
  - JWT Access Token content :
![](img/keycloak21.png)
![](img/keycloak22.png)
  - Authentication with refresh token :
![](img/keycloak23.png)
  - Authentication with ClientID and ClientSecret :
![](img/keycloak24.png)
![](img/keycloak25.png)
![](img/keycloak26.png)
  - Change Tokens parameters :
![](img/keycloak27.png)
 

### Secure microservices architecture with Keycloak
- In this part, We will secure the last project I worked on with keycloak, you can find it here: [microservices-architecture](https://github.com/m0hamedAit/microservice_architecture/tree/main/Architecture_microService_SpringCloud_ConsulDiscovery_ConsulConfig_Vault)

#### How to secure a REST API with Keycloak


