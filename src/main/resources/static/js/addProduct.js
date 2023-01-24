function addProduct(event) {
    let formdata = new FormData(event.target);
    
    let result = getFormData("/api/products/add_product", formdata).then((response) => {
        alert(response.message);
    });
}


document.getElementById("product-form").onsubmit = addProduct;