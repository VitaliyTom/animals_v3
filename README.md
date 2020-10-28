# **Animals**

## This app was developed for my daughter to teach her what kind of animals and what sounds they make.

## [Deploy on the home linux-server](http://93.125.1.133:3088/animals) 

    There is a sql dump, import it with the name of the "animalbase" schema. 
>**/src/main/resources/dumpSql/animalbase.sql**

    The default username and password for the MySQL database is user: root, password: root. Do not forget to change it to your own in the dispatcher-servlet.xml file along the path 
>**/src/main/webapp/WEB-INF**

    The log is saved to:

>**linux - /opt/animals.log**

>**windows - C:\opt\animals.log**
