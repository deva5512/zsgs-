/**
 * 
 */
function addProduct() {

	var url = document.getElementById("url");
	var desc = document.getElementById("description");
	var category = document.getElementById("category");
	var brand = document.getElementById("brand");
	var model = document.getElementById("model");
	var qty = document.getElementById("qty");
	var price = document.getElementById("price");

	if (url == "" || desc == "" || category == "" || brand == "" || model == "" || qty == "" || price == "") {
		launch_toast("Please Fill the details", false);
		return;
	}
	if (qty <= 0) {
		launch_toast("Quantity cant be less then 1", false);
		return;
	}
	if (price <= 0) {
		launch_toast("price cant be less then 1 Rs", false);
		return;
	}

	let verify = qty + "";

	if (verify.indexOf('.') != -1) {
		launch_toast("Quantity cant be in decimal", false);
		return;
	}
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			let res = JSON.parse(xhr.responseText);
			if (res) {
				launch_toast("Product Added Successfully", true);
			}
			url.innerText = "";
			desc.innerText = "";
			category.innerText = "";
			brand.innerText = "";
			model.innerText = "";
			qty.innerText = "";
			price.innerText = "";
		}
	}
	xhr.open("POST", "http://localhost:8080/ECommerce/addProduct");
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send("url=" + url.value + "&desc=" + desc.value + "&category=" + category.value + "&brand=" + brand.value + "&model=" + model.value + "&qty=" + qty.value + "&price=" + price.value);
}

function increaseCount() {
	let productid = document.getElementById("product_id").value;
	let count = document.getElementById("count").value;

	if (productid == "" || count == "") {
		launch_toast("Please Fill the input to proceed", false);
		return;
	}
	if (productid <= 0 || count <= 0) {
		launch_toast("Invalid input", false);
		return;
	}
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			let res = JSON.parse(xhr.responseText);
			if (res) {
				launch_toast("Increased Successfully", true);
			} else {
				launch_toast("Invalid Product Id", false);
			}
		}
	}
	xhr.open("POST", "http://localhost:8080/ECommerce/increaseCount");
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send("id=" + productid + "&count=" + count);
}

function launch_toast(message, check) {
	if (check) {
		document.getElementById("img").innerHTML = `<i class="fa-solid fa-check fa-beat"></i>`;
	} else {
		document.getElementById("img").innerHTML = `<i class="fa-solid fa-triangle-exclamation fa-beat"></i>`;
	}

	document.getElementById("desc").innerHTML = message;
	var x = document.getElementById("toast")
	x.className = "show";
	setTimeout(function() { x.className = x.className.replace("show", ""); }, 4000);
}