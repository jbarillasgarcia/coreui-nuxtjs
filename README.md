# Genesis

Genesis Project comprises the following modules:

* ### Genesis Frontend
	1. CoreUI Pro Vue Admin Template + NuxtJS Application

* ### Genesis Backend
	1. Genesis Core
	2. Genesis Eureka Server
	3. Genesis Zuul Gateway
	4. Genesis JWT Authentication and Authorization
	5. Genesis API Service

## CoreUI Pro Vue Admin Template + NuxtJS Application

The frontend module is built on top of CoreUI Pro Vue Admin Template v2.0.3 and NuxtJS 2.0.0. Includes authentication and authorization features provided by Genesis JWT Authentication and Authorization backend module.

## Genesis Core

A Maven Java project that includes core components. Developers can use this as a dependency in their own projects to access model entities related to security.

## Genesis Eureka Server

A Maven Java project that comprises a service registry. All service APIs should be registered on Eureka Server so any gateway service like Genesis Zuul Gateway can discover available services by service name, not by URL.

## Genesis Zuul Gateway

A Maven Java project that comprises a gateway service to access all APIs related to our project.

## Genesis JWT Authentication and Authorization

A Maven Java project that comprises all services related to authentication and authorization. Authentication is based on Java Web Token -JWT-.

## Genesis API Service

A Maven Java project that comprises sample REST services. Developers can use this module as a starter project for their own projects.