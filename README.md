# **Animals**

## This app was developed for my daughter to teach her what kind of animals and what sounds they make.

## [Deploy on the home linux-server](http://93.125.1.133:3588/animals) (Orange Pi 3)

    There is a sql dump, import it with the name of the "animalbase" schema. 
>**/src/main/resources/dumpSql/animalbase.sql**

    The default username and password for the MySQL database is user: root, password: Root09102020. 
    Do not forget to change it to your own in the dispatcher-servlet.xml file along the path 
>**/src/main/webapp/WEB-INF**

    if the error "ERROR 2006 (HY000): MySQL server has gone away" occurs during import. 
    Replace or add the line "max_allowed_packet = 1024M" to the file:
>**GNU/Linux - /etc/mysql/my.cnf**
    
>**Windows - C:\ProgramData\MySQL\MySQL Server 8.0\my.ini**

     Also do not forget to restart mysql by typing: 
>*sudo service mysql restart*

     for the changes to the my.cnf file to take effect

>
    The log is saved to:

>**GNU/Linux - /opt/animals.log**

>**Windows - C:\opt\animals.log**
