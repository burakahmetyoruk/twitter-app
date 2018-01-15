Spring Boot Twitter Application
=========================

Building the Application
---------------------
    $ git clone https://github.com/burakahmetyoruk/twitter-app.git
    $ cd twitter-crawler
    $ mvn clean install

Building the Container
----------------------
If you already have Docker installed:

    $ docker build -t burak/twitter-crawler .

Running the Container
---------------------
To run this container:

    $ docker run -ti burak/twitter-crawler