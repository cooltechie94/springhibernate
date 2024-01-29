Application to perform CRUD operations on Students

A common design pattern called DATA ACCESS OBJECT(DAO) is being followed 
which is responsible for interfacing the database
DAO Methods
save(), findById(), findAll()


JPA Entity Manager is the main component for saving and retrieving the entities

JPA Entity Manager needs a Data Source and the Data source defines database connection info

JPA Entity Manager & Data Source are automatically created by Spring boot based on the application.properties

We can autowire/inject the JPA Entity Manager into our Student DAO

**Diagram**

**Student DAO <====> Entity Manager <====> Data Source <====> Database**