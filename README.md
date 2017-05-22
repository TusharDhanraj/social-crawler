# social-crawler
#Crawling user posts

Prerequisites:
MongoDb

Change main/resources/application.properties :
 # MONGODB (MongoProperties)
    spring.data.mongodb.host=localhost
    spring.data.mongodb.port=27017
    spring.data.mongodb.database=crawler
    spring.data.mongodb.repositories.enabled=true # if spring data repository support is enabled

    
#Chrome Driver path changes
chrome.driver.path=C:/Users/tbhendar/Downloads/chromedriver_win32/chromedriver.exe


#How to run this project:
spring-boot:run -Dmaven.test.skip=true



