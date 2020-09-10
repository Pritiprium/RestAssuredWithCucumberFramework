Feature: checking Response with mocking the Server
Scenario: checking Car Response
Given Mocking Server Using WireMock Server SetUp
When Stubing Schema 
And Getting Responce of all Cars
And Getting Status Code
Then Print the blue Tesla car 
Then Print Note also of blur Car
Then Return All Car with lowest per day rental cost price only
Then Return All Car with lowest per day rental cost after discount
And Find the Highest Revenue generating Car
And Stop the Server