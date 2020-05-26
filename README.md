# DB-Project-2020
An implementation of a fragment of the Northwind database, covering products and their categories, suppliers,
customers and orders. Done entirely with Spring, using Hibernate and a MySql database.

Structure
-----------
The code consists of a data model, Rest controller class, a data service, a database access class and an interface for it.

All of these are found in src/main/com/example/northwind:
* the data model is found in /model and contains all the entity classes, as well as some helper classes needed along the way
* the controller sits in /api
* the data service is in /service
* the database access class and its interface are both in /dao.

**The model**  
Nothing fancy, just a limited implementation of Northwind's structure. Of the interesting stuff, there's an OrderWrapper class
which enables us to send an entire order in a single request, which helps avoid errors. Also, the ID of OrderDetails is a custom
compound ID.

**The API**  
The layer of user access. This receives requests, which are mapped to certain functions.

**The Service**  
The data service acts as an intermediary between the API and the DAO, its sole purpose being to allow us to easily switch between
data access object implementations, in case we want to change the DB we're using. Here it's mostly useless since there's one DAO
implementation, but its good to have to keep the code easily expandible.

**The DAO**  
The interface defines a set of methods needed to operate on the database, These methods are then implemented in an implementable
class. This class is where the real magic happens, this is where we actually work upon the database.
