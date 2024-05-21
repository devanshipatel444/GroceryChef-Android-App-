# GroceryChef-Android-App-
I live with my parents so they do most of the grocery shopping. Making different meals for breakfast, lunch and sometimes even dinner is tedious because I often have to visit multiple recipe websites only to find out I am missing some ingredients. To make this easier, I am developing a user-friendly android app that provides recipes for breakfast, lunch and dinner with ingredients/groceries you already have and schedules it accordingly. 

The app has three pages. The first page is where the user can input their grocery item and the quantities like milk and how many bags. The second page generates recipes for breakfast, lunch or dinner based on what the user chooses. I have integrated Google Sheets API to fetch and scrape recipe data from websites stored in google sheets using node.js. The recipe data is cleaned to remove unnecessary information and stores in JSON files. I am currently implementing efficient filtering algorithms to match user-entered grocery items with recipe ingredients, providing personalized recipe suggestions. This page will involve sending data from JSON files to the frontend in Android Studio. The third page is a calender/scheduler that shows 7 days of the week, with slots for breakfast, lunch and dinner each day. Users can drag and drop chosen recipes into these slots. This schedule, along with the grocery list, will be stored in a SQL database. 


Though this is work in progress, I have deepened my understanding of object-oriented programming and learned how to use Node.js for backend developement. I am currently learning how to manage data stored in JSON files, including sending and receiving while also beginning to understand how to connect the frontend and backend components. 


