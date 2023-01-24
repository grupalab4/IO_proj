document.getElementById("register_form").onsubmit = (event) => {
    let formdata = new FormData(event.target);
    
    let result = getFormData("/api/users/register", formdata).then((response) => {
        if ("created new user successfully!" == response.message) {
            document.location = "login.html";
        } else {
            alert(response.message);
        }
    });
}