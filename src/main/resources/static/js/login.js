// document.getElementById("login_form").onsubmit = (event) => {
//     let formData = new FormData(event.target);
//     let login = formData.get("login");
//     let password = formData.get("password");
//     
//     let payload = {
//         login: login,
//         password: password,
//     };
//     
//     // console.log(JSON.stringify(payload));
// 
//     // ten link się raczej na pewno zmieni
//     let result = postData("/ajax/login", payload);
//     result.finally(console.log);
// }