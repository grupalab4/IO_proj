
async function updateHeader() {
    let height_p = document.getElementById("header_height");
    let age_p = document.getElementById("header_age");
    let weight_p = document.getElementById("header_weight");

    let about = await getFormData("/api/users/about");

    height_p.innerText = about.height;
    age_p.innerText = about.age;
    weight_p.innerText = about.weight;
}

updateHeader();