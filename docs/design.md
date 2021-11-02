# ToDoTwo

Our ToDoApp is getting a little long in the tooth now, 
so we are going to start it over as a spring boot application.


# Requirements:
## Backend (API)
 - Persistence
   - JPA/Hibernate configuration
   -Models(POJOs)
     - ToDoItem 
   -Repositories(DAOs)
     - ToDoItem Repo
 - API
   - Controllers(Servlets)
     - ToDoItem Controller that handles get and post
 - Logging
   - We will just implement our file logger for now. (but as a bean!)
 - Service layer
   - Validation
     - We will re-use the same sort of validator class, but this time as a bean.

## Frontend(UI)
 - Angular SPA


# 11/1/21:
Today we will start with just the beans we need. We need a file logger and
a validator which are both going to be singletons that are used throughout the application.