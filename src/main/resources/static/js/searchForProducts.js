let lastUpdated = Date.now();
let querryTimeout = null;

function searchPromptUpdate(oninput) {
    let querry = oninput.value;

    let current = Date.now();
    if (current - lastUpdated < 1000) {
        clearTimeout(querryTimeout);
        querryTimeout = setTimeout(sendSearchQuerry, 1000, querry);
    } else {
        querryTimeout = setTimeout(sendSearchQuerry, 1000, querry);
    }
    lastUpdated = Date.now();
}

async function sendSearchQuerry(querry) {
    let response = await getFormData("/api/products/find-products", "input=" + querry);
    console.log(response);
    let results_div = document.getElementById("search_results");

    results_div.innerHTML = "";
    for (let name of response) {
        let element = document.createElement("div");
        element.classList = "search-result-element";
        element.innerText = name;
        results_div.appendChild(element);
    }
}

function addToItemList() {
    let selected = document.getElementById("search_results").firstChild;
    let name = selected.innerText;

    let itemList = document.getElementById("item-list")

    let element = document.createElement("div");
    element.classList = "search-result-element";
    element.innerText = name;
    itemList.appendChild(element);
}