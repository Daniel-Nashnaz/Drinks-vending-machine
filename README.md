# Process operating systems project
In my lab project I will show an example of a system that supports multiple threads (THREAD), 
which represents the connection between a server side and a client side. The program simulates the operations of a coffee machine, 
as soon as the drink is ordered, the server will receive a request from the customer and use the processes of preparing the drink, 
which are in a separate department and are structured in such a way that each drink and its preparation process will be in a separate process, 
a process that is used for the purpose of explaining the mixing action for a coffee drink, use synchronized to lock this action and prevent a situation Deadlock, 
so that as soon as we need a mixing action to prepare another drink, we can only use it if the mixing action is not locked (no longer in use).
The server is always listening and will accept all the orders the client will send, 
and the client will receive all the orders he ordered in the order they were ordered until he asks to finish._
The link to the project book:https://docs.google.com/document/d/13WynA0PRxS8CcFkVPJV6-exrLO9dcJdj/edit?usp=sharing&ouid=106898168725276078639&rtpof=true&sd=true
