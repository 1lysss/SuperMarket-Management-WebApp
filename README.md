## Folder 'tracking'
  - "notes" fihom des notes 3la projet, ay detail wla chihaja mohima bghiti t39al 3liha ktbha hna
  - "logs" kol mara tkml chihaja ktbha hna, github deja kidir nfs lkhdma mais bach nbsto l omor hitach hadi awel mra ghanzido 7ta had lfichier

## Additional notes
  - Lprojet kaml kayn f src/main lfichiers akhrin kamlin kidiro khdmtom rasom bla matfham chno kayn tma exact (Unless u really want to)
  - lfichier 'application.properties' diri fih hadchi (9bl creer database osmiha 'supermarket_db'):

```
spring.application.name=SuperMarketManager
spring.datasource.url=jdbc:postgresql://localhost:5432/supermarket_db
spring.datasource.username=postgres
spring.datasource.password= hna ktb mot de pass dyalek
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.thymeleaf.check-template-location=false
```

  - kol mara kat executer lcode dkhol n ```http://localhost:8080/``` bach tchof l'execution dcode
