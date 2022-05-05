/*const { format } = require("path/posix")
const form = document.getElementById("form")
const name = document.getElementById("name")
const password = document.getElementById("password")
const email = document.getElementById("email")
const zipcode = document.getElementById("zipcode")
const errorElement = document.getElementById("error")

form.addEventListener('submit', (input) =>{
        let messages = [];
        if(name.value === '' || name.value == null){
            messages.push("Name is Needed")
        }

        if(zipcode.value.length === 5)
        {
            messages.push("Zipcode needs to be five digits long.")
        }

        if (messages.length > 0){
            input.preventDefault()
            errorElement.innerText = messages.join(', ')
        }
})*/
