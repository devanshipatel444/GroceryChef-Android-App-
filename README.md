# GroceryChef-Android-App-
I live with my parents so they do the bulk of the grocery shopping. Trying to make different meals of breakfast lunch and sometimes even dinner is a tedious task as it requires scrolling through multiple websites just to find out I am missing few of the ingrediants. Inorder to ease this task, I am currently developing a user-friendly android app that provides recipes for breakfast, lunch and dinner with ingredients/groceries you already have and schedules it accordingly. 

The app consists of three pages. The first page is where the user can input their grocery item and the quantity. For example: milk and how many bags. The second page is where the recipes for breakfast, lunch or dinner (depending on what the user chooses) will be generated. I have integrated Google Sheets API to fetch and scrape recipe data from websites stored in google sheets from node.js and am currently in the process of implementing efficient filtering algorithms to match user-entered grocery items with recipe ingredients, providing personalized recipe suggestions. The recipe data  had conditions to remove unecssary informationa dn was then stored into their respective JSON files. This page would involve sending the data from JSON files from node.js to the frontend (android studio). The third page will be a "calender" / scheduler that has 7 days in a week with each day having breakfast, lunch and dinner slots. Here is where the chosen recipes are placed and the user will be able to drag and drop into the open slots according to them. This schedule along with the grocery list will be stored in a database (SQL). 

Though this is work in progress, I have deepened my understanding of object-oriented programming and learned how to use Node.js for backend developement. I am currently learning how to manage data (send and receive) stored in JSON files while also beginning to understand how to connect the frontend and backend components. 
