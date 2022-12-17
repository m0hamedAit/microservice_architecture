## How To Secure Distributed Systems Using Oauth2 OIDC JWT
- **Keycloak**
- **Quarkos**
- difference entre Quarkos et spring boot:

### Keycloak :
  - install from : [keycloak](https://www.keycloak.org/downloads)
  - Launch Keycloak server: **keycloak/bin >** `kc.[bat/sh] start-dev`
  - Because keycloak is based on JPA, it needs a database (by default it uses H2, but we can use MySQL, Postgres, Oracle, etc.)
  - To configure a specific database :
      - Before launching server : **keycloak/bin >** `kc.[bat/sh] build  --db {db}` (db = h2, mysql, postgres, oracle, etc.)
      - launch server : **keycloak/bin >** `kc.[bat/sh] start-dev --db={db} --db-url={dbUrl} --db-username={dbUsername} --db-password={dbPassword}`
  - Access keycloak admin console : `http://localhost:8080`
  
  
  - Create a Realm : 
      - Realm is is a concept in Keycloak that refers to an object managing a set of users along with their credentials, roles and groups. A user in Keycloak belongs to only one realm and the user who logs in to Keycloak will log into that user’s realm. We can have multiple realms in a Keycloak server, these realms will be independent of each other and they only manage their users.
      - **Master** (default realm) : the realm with the highest power in the realm of the Keycloak server, the admin user in the master realm will have the right to view and manage the other realm.
      - Create a realm : 