/*
You are given a date-time string dt in the format YYYY-MM-DDTHH:MM:SS (24-hour format). 
Your task is to convert this date-time string into the following format:

Input Format:
-------------
Line-1: A single date-time string in the format YYYY-MM-DDTHH:MM:SS (24-hour format).

Output Format:
--------------
Line-1: The formatted date-time string in the format :
DaySuffix MonthName, Year Hour:Minute:SecondAM/PM.

Sample Input-1:
---------------
2019-07-18T16:34:21

Sample Output-1:
----------------
18th July, 2019 04:34:21PM


Sample Input-2:
---------------
2022-03-01T23:59:59

Sample Output-2:
----------------
1st March, 2022 11:59:59PM

NOTE:
The output should include:
	Day with an ordinal suffix (e.g., 18th)
	Month as a word (e.g., July)
	12-hour time format with AM/PM

*/


const readline = require('readline');

// Set up readline interface for reading input
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

// Function to convert date string
const convertDateString = (dateStr) => {
    let months = {
        "01" : "January",
        "02" : "Febraury",
        "03" : "March",
        "04" : "April",
        "05" : "May",
        "06" : "June",
        "07" : "July",
        "08" : "August",
        "09" : "September",
        "10" : "October",
        "11" : "November",
        "12" : "December"
    }
 //Write your code here and return formattedString
 let ans = "";
 let [date, time] = dateStr.split("T");
 let [year, month, day] = date.split("-");
 day = parseInt(day);
 if(day==1 || day==21 || day==31){
     ans += day+"st ";
 }else if(day==2 || day==22){
     ans += "2nd ";
 }else if(day==3 || day==23){
     ans += "3rd ";
 }else{
     ans += day+"th ";
 }
 ans += months[month]+", "+year+" ";
 
 let [hour, min, sec] = time.split(":");
 hour= parseInt(hour);
 
 let boolean = 0;
 if(hour == 12){
     boolean = 1;
 }
 else if(hour == 24){
     hour = 0;
 }
 else if(hour >= 13){
     hour = hour-12;
     boolean = 1;
 }
 if(hour<10){
         ans += "0";
    }

 ans += hour+":"+min+":"+sec;
 if (boolean===0){
     ans += "AM";
 }
 else{
     ans += "PM";
 }
 
 
 return ans;

};

// Function to read input and process the date string
const processDateInput = () => {
  rl.question("", (input) => {
    const formattedDate = convertDateString(input);
    console.log(formattedDate);
    rl.close();
  });
};

// Start the process
processDateInput();