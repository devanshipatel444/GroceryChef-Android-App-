const express = require("express"); 
const { google } = require("googleapis"); 
const app = express(); 
const path = require('path'); 
const axios = require('axios'); 
const cheerio = require('cheerio'); 
const fs = require('fs'); 



// app.get(/) --> GET request for the route path 
// if we have other pages in our website ---> ex. about page and we want to get data 
//from there --> app.get("/about") ---> we are at the about page just on the back side 
//instead of thr front side where the UI would be ---> SO COOL!!
app.get("/", async(req, res) => {

    const auth = new google.auth.GoogleAuth({
        keyFile: "credentials.json", 
        scopes: "https://www.googleapis.com/auth/spreadsheets"
    }); 

    //Create client instance for auth
    const client = await auth.getClient(); 

    // Create instance of Google Sheets API

    const googleSheets = google.sheets({version: "v4", auth: client }); 

    const spreadsheetId = "18c7lkakvp51psRCgros6PMv57Q2eK96Dab69hWr33c4";

    const breakFastData = await googleSheets.spreadsheets.values.get({
        auth, 
        spreadsheetId, 
        range : "BreakFast"
    })

    const breaky = breakFastData.data.values.flat(); 

    /*    
    const lunchData = await googleSheets.spreadsheets.values.get({
        auth, 
        spreadsheetId, 
        range : "Lunch"
    })

    const lunchy = lunchData.data.values.flat(); */

    const lunchData = await googleSheets.spreadsheets.values.get({
        auth, 
        spreadsheetId, 
        range : "Lunch"
    })

    const lunchy = lunchData.data.values.flat();

    const dinnerData = await googleSheets.spreadsheets.values.get({
        auth, 
        spreadsheetId, 
        range : "Dinner"
    })

    const dinnery = dinnerData.data.values.flat(); 





let ingrediants = []; 
let uniqueIngrediants = []; 
let filteredIngrediants = []; 
let title = ''; 

let commonIngrediants = []; 
let commonIngrediantArray= []; 
let filteredCommonIngrediant = []; 


    async function fetchIngrediants(url) {
        try {
            const response = await axios.get(url); 
            if (response.status === 200) {
                const $ = cheerio.load(response.data); 

                $('li').each((index, liElement) => {
                    const spanElements = $(liElement).find('span'); 

                    spanElements.each((spanIndex, spanElement) => {
                        const elements = $(spanElement).text(); 
                        ingrediants.push(elements); 
                    }); 


                });  
                title = $('h1').text(); 
            }

            uniqueIngrediants = Array.from(new Set(ingrediants)); 
            filteredIngrediants = uniqueIngrediants.filter((ingredient) => !ingredient.includes('optional')); 

            return{ url, title, filteredIngrediants}; 
        
        }
        catch (error) {
            console.error(`Error fetching data from ${url}: ${error.message}`);
            return null;
        } 



    }

    async function fetchCommonIngrediants(url) {
        try {
            const response = await axios.get(url); 
            if (response.status === 200) {
                const $ = cheerio.load(response.data); 

                $('li').each((index, liElement) => {
                    const liElements = $(liElement).text();
                    commonIngrediants.push(liElements);  

                });  
            }

            commonIngrediantArray = Array.from(new Set(commonIngrediants)); 
            //return{ url, }

            return{ commonIngrediantArray}; 
        
        }
        catch (error) {
            console.error(`Error fetching data from ${url}: ${error.message}`);
            return null;
        } 



    }


    async function fetchBreakfastDataFromUrl(breaky) {
        const jsonDataArray = []; 

        for(let i=0; i< breaky.length; i++) {
            const url = breaky[i]; 
            const data = await fetchIngrediants(url); 

            console.log('hi');

            if(data) {
                jsonDataArray.push(data); 
            }
        }



        return jsonDataArray; 
    }

    async function fetchLunchDataFromUrl(lunchy) {
        const jsonLunchArray = []; 

        for(let i = 0; i< lunchy.length; i++){
            const url = lunchy[i]; 
            const data = await fetchIngrediants(url); 
            console.log('hiii'); 

            if(data) {
                jsonLunchArray.push(data); 
            }
        }

        return jsonLunchArray; 
    }

    async function fetchDinnerDataFromUrl(dinnery) {
        const jsonDinnerArray = []; 

        for(let i = 0; i< dinnery.length; i++){
            const url = dinnery[i]; 
            const data = await fetchIngrediants(url); 
            console.log('hiii'); 

            if(data) {
                jsonDinnerArray.push(data); 
            }
        }

        return jsonDinnerArray; 
    }






    //const jsonDataArray = await fetchBreakfastDataFromUrl(breaky);
    
    //const jsonLunchArray = await fetchLunchDataFromUrl(lunchy); 
    //const jsonDinnerArray = await fetchDinnerDataFromUrl(dinnery); 

    const jsonCommonIngredientArray = await fetchCommonIngrediants('https://www.foodnetwork.com/recipes/articles/basic-pantry-101'); 

    //const filePath = path.resolve('practice.json'); 

    //const lunchFilePath = path.resolve('practice.json');
    //const dinnerFilePath = path.resolve('practice.json');  

     const ingrediantPath = path.resolve('commonIngrediants.json')

    //const jsonString = JSON.stringify(jsonDataArray, null, 2); 

    //const jsonLunchString = JSON.stringify(jsonLunchArray, null, 2);
    //const jsonDinnerString = JSON.stringify(jsonDinnerArray, null, 2);  

    const commonInrediantString = JSON.stringify(jsonCommonIngredientArray, null, 2); 


    try {
        //fs.appendFileSync(filePath, jsonString); 
        //console.log('File successfully written');
        
       // fs.appendFileSync(lunchFilePath, jsonLunchString); 

       // fs.appendFileSync(dinnerFilePath,jsonDinnerString); 
       fs.appendFileSync(ingrediantPath,commonInrediantString); 
        console.log('File successfully written');



    } catch (error) {
        console.error('Error writing file:', error); 
    }


   // res.json(jsonDataArray); 



   // res.send(jsonDataArray); 

/*
    


    const responseData = {
        breaky: breaky,
        lunchy: lunchy
    }; */


    



}); 




app.listen(1337, (req, res) => console.log("running on 1337")); 