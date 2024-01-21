let sum = 0;

function f1 (){ // moduler to check remainder

    let a =10;
    let b=2;

    let result = a%b;

    console.log('the output:  '+result);

}

function f2(){ // escape sequences

    let theString = "\"I am Sarib Shamim\"";
    console.log('the string:   '+theString);

}

function f3(){ // concatination

    let concatination = 'hello ' + ' paaji';
    console.log(concatination);
}

function f4(){ // finding the length

    let theString = "\"Coding is fun! \""
    let theLength = theString.length
    console.log('the lenght is:  '+theLength)

}

function f5(){ // objects , arrays, JSON, wait, 2D array 

    let mixedArray = [1, 2, 'three', { key: 'value' }, 5, 'six', { anotherKey: 'anotherValue' }];

    // console.log(mixedArray)    

    let myObject = {
        key1: 'value1',
        key2: 42,
        key3: ['arrayElement1', 'arrayElement2'],
        key4: { nestedKey: 'nestedValue' }
      };
      
      let jsonString = JSON.stringify(myObject);
    //   console.log(jsonString);
      
      mixedArray.push(999);

    //   console.log(mixedArray);
      
      mixedArray.pop();

    //   console.log(mixedArray);

      var firstElementFromArray = mixedArray.shift();

    //   console.log(firstElementFromArray);

    
      mixedArray.unshift(321);
      mixedArray.unshift(1);

    //   console.log(mixedArray);

    
    const numbers = [65, 44, 12, 4];
    numbers.forEach(myFunction);

    // console.log('the result: '+sum);  

// for (var i=0;i<numbers.length;i++)
//       console.log('the arr value: '+numbers[i]);
      
// console.log("Start");

// setTimeout(() => {
//   console.log("After 4000 milliseconds");
// }, 4000);

// console.log("End");

var twoDimArray = [[1,2],[3,4,5],[6,7,8]]

for (let i = 0; i < twoDimArray.length;i++)
{
    for (let j = 0 ; j < twoDimArray[0].length;j++){
            console.log('the 2d Array val: '+twoDimArray[i][j]);   
    }
}

}


function myFunction(item) {
  sum += item;
}


function f6(){ // if else

    let a = 1;
    let b = '1';
    let c=1;

    if (a===b && a===c)
    console.log('a b c braber hen !!!!!');
    // else if(a==b)
    // console.log('thore braber hen')
    else
    console.log('nai he yawr !');

}

function f7(){ // loop

    let a=100;

    while (a>=90){
     a--;
     console.log('looop me hun me yawr !' + ((--a) - (--a)) );

    }

}


const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

function f8() { // input and random number
  let karo = 'or';

  function askForInput() {
    console.log(Math.floor(Math.random() * 100));

    rl.question("kya scene: ", function(userInput) {
      
      karo = userInput;

      if (karo === 'or') {
        askForInput(); // Continue the loop recursively
      } else {
        rl.close(); // Close the interface if the condition is not met
      }
    });
  }

  askForInput(); // Start the loop
}

function f9(){  // num > 0 ? 'positive' : num < 0 ? 'negative' : 'num is zero' 
                // optimized if (conditional statement)

  
  let num = -1111;

    console.log(
  num > 0 ? 'positive' :
  num < 0 ? 'negative' :
  'num is zero'
);

}


function f10(){

  // Original array
const numbers = [1, 2, 3, 4, 5, 6];

// Using filter to create a new array with even numbers
let evenNumbers = numbers.filter(function (num) {
  return num % 2 === 0;
});

console.log(evenNumbers); // Outputs: [2, 4, 6]


}


function f11(){

  const numbers = [10, 20, 30, 40, 50];

  const average = numbers.reduce((accumulator, currentValue, index, array) => {
  accumulator += currentValue;

  // For the last iteration, calculate the average
  if (index === array.length - 1) {
    return accumulator / array.length;
  } else {
    return accumulator;
  }
}, 0);

console.log(average); // Outputs: 30


}

function f12(){ // backtick

  const name = 'Sarib Bro.';
const greeting = `Hello, ${name}!`;
console.log(greeting); // Outputs: Hello, Alice!

}


f12();


// ************************ JSON ************************
//JSON is a lightweight data interchange format that is easy for humans to read and write and
// easy for machines to parse and generate. The main difference between the JavaScript object 
//literal notation and JSON is that JSON requires keys to be enclosed in double quotes. 


// ************************ Comparision ************************ 
// == in JavaScript is used for comparing two variables, 
// but it ignores the datatype of variable. 
// === is used for comparing two variables, but this operator also checks datatype and 
// compares two values.


// ************************ var vs let ************************
// In JavaScript, the keywords var and let (and, more recently, const) are used to declare variables.
// Unlike some other programming languages, JavaScript doesn't use explicit type declarations when
// defining variables. Instead, it uses a process called dynamic typing, where the type of a variable
// is determined at runtime.

// While JavaScript allows you to use var, let, or const to declare variables, it's generally
// recommended to use let for variables that may be reassigned and const for variables that shouldn't
// be reassigned. var is an older way of declaring variables and has some quirks, so it's generally
// better to use let or const in modern JavaScript.
// Var is function scoped/Let is block scoped

// ************************ Filter method ************************ 
// When dealing with API responses or data from external sources, you might use filter to transform
// and clean the data. For example, removing irrelevant or unwanted items from an array of objects.

// Implementing search functionality is a common use case for filter. When a user enters a search
// query, you can use filter to dynamically update the displayed results based on the matching 
// criteria.

// When dealing with events or notifications, you might use filter to display only relevant events
// to a user. For instance, showing only unread messages, upcoming events, or completed tasks.


// ************************ Reduce Method ************************
// The reduce method in JavaScript is used with arrays to transform or "reduce" an array into a
// single value. It iterates over each element of the array and applies a callback function to
// accumulate a result. The result can be of any type: a number, a string, an object, or even
// another array.

// const result = array.reduce(callback(accumulator, currentValue[, index[, array]])[, initialValue]);

// callback: The function is called with four arguments:

// accumulator: The accumulated result of the previous iterations.
// currentValue: The current element being processed in the array.
// index (optional): The index of the current element.
// array (optional): The array on which reduce was called.
// initialValue (optional): An initial value for the accumulator. If not provided, the first element
// of the array is used as the initial accumulator value, and the iteration starts from the second 
// element.

