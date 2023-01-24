async function calculate() {
    let weight = document.getElementById("weight").value;
    let date = document.getElementById("date").value;
    weight = "goalWeight=" + weight;
    date = "deadline=" + date;
    
    let response = await getFormData("/api/calculator", "?" + weight + "&" + date);
    
    let bmr = response.bmr;
    let tdee = response.tdee;
    let calorie = response.calorieIntake;
    
    document.getElementById("intake").innerText = calorie < bmr ? bmr : calorie;
    document.getElementById("bmr").innerText = bmr;
    document.getElementById("tdee").innerText = tdee;
    
    if (calorie < bmr) {
        document.getElementById("message").innerText = "Cel niemożliwy do osiągnięcia, dzienny cel kaloryczny byłby mniejszy niż podstawowa przemiana materii!";
        document.getElementById("message").style.color = "red";
    } else {
        document.getElementById("message").innerText = "Cel możliwy do osiągnięcia. Powodzenia!";
        document.getElementById("message").style.color = "green";
    }
}