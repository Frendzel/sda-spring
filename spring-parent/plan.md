## 3-4 workshops plan:

# Configuration - reading files from different directions (15m)
# 🌈 H2 config 
# 🌈 SQL table from SQL and JokesRepository
# Async - (15m)
# Validations - forms (1h)
# Synchronized
# 🌈 Aspect! For method invocation
# 🌈 Log Thread params
# Transactions
# JDBC Template - (15m)
# 🌈 Read Jokes from MongoDB and present them on front using thymeleaf
# 🌈 (@Controller)
# Export data to PDF/EXCEL/CSV (1h)
## implement them on UI on click (30m)
# XML app context: https://www.concretepage.com/spring-boot/spring-boot-xml-configuration-example

# Group Work (polish description)
## Spring Mail
## Napisz rankomat żartów. Dowolny żart zapisany w bazie można ocenić, a następnie ocena zostaje do niego przypisana. 
## Wystaw API umożliwiające podanie rankingu jako filtru.

## (trudne) 1. Napisz aplikację, która raz dziennie będzie rozsyłać na wskazany adres maile z 
## najlepszym żartem o Chucku, który danego dnia pojawił się w bazie.

## (srednie) 2. Napisz aplikację, która przyjmie na API asynchronicznie żart z dowolnym 
## formatem wskazanym w formie nagłówka (PDF,EXCEL,CSV) a następnie zapisze ten żart pod wskazany w kolejnym adresie adres.

# Why do we even need Spring -> https://www.youtube.com/watch?v=ySXlsZDJMgc
## IoC
## Dependency Injections
## Annotations vs Xml
## Configuration
## ApplicationContext
## Beans
## Component etc.
## Autowired
## Polimorphism in Spring
## Mongo DB Atlas - account -> we will need this

# Implementation
## Generate sample Spring Boot App
## Chuck Norris Jokes collector
## Rest API for this
### @Cacheable
### @Async
### Validations
## 3 layers app
### Transactions
## Mapstruct to use mapping between DAO and DTO
## @Scheduler
## Save jokes on MongoDB App using MongoClient
### make json from object
## Turn On H2, use JDBC repository to save data to the sql DB
### using ActiveMQ
## tests, tests, tests!
### unit
### integration
### mockMvc
### cucumber *** -> extra
## @Aspect to calculate invocation time
## Write extra tools to export data to the PDF, CSV, EXCEL formats
## Use testcontainers to avoid SQL database *** -> extra

# Alternatives:
## Picocontainer
## Micronaut
## Dagger2 

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Web Starter](https://docs.spring.io/spring-boot/docs/{bootVersion}/reference/htmlsingle/#boot-features-developing-web-applications)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)