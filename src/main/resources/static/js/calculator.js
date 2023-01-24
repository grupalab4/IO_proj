async function calculate() {
    let weight = document.getElementById("weight").value;
    let date = document.getElementById("date").value;
    weight = "goalWeight=" + weight;
    date = "deadline=" + date;
    
    let kcal = await getFormData("/api/calculator", "?" + weight + "&" + date);
    
    document.getElementById("result").innerText = kcal;
}