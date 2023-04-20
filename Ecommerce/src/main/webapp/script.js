function priceRange() {

	debugger;
	let min = Number(document.getElementById("min").value);
	let max = Number(document.getElementById("max").value);

	if (min < 0 || (min > max && max != 0)) {
		return;
	}

	if (max > 1000000 || (max < min && max != 0)) {
		return;
	}


	min_price = min;
	document.getElementById("min").value = min_price;
	if (max != 0) {
		max_price = max;
		document.getElementById("max").value = max_price;
	}

	if (recently_searched != null)
		searchBar(recently_searched);
	else if (recently_searched_brand_or_catagory != null) {
		search(recently_searched_brand_or_catagory);
	} else {
		home();
	}
}

var min_price = 0;
var max_price = 1000000;
var recently_searched;
var recently_searched_brand_or_catagory;
var sortOrder = 0;

function orderBy() {

	if (document.getElementById("lowtohigh").checked) {
		sortOrder = 1;
	} else if (document.getElementById("hightolow").checked) {
		sortOrder = 2;
	} else {
		sortOrder = 0;
	}

	if (recently_searched != null)
		searchBar(recently_searched);
	else if (recently_searched_brand_or_catagory != null) {
		search(recently_searched_brand_or_catagory);
	} else {
		home();
	}

}

function home() {
	isUserLogedIn().then(function(result) {
		let user = JSON.parse(result);
		if (user) {
			var xhr = new XMLHttpRequest();

			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4) {

					let res = JSON.parse(xhr.responseText);

					if (res[0] != 0)
						document.getElementById("wishCount").innerHTML = res[0];
					if (res[1] != 0)
						document.getElementById("cartCount").innerHTML = res[1];
					if (res[2] != 0)
						document.getElementById("orderCount").innerHTML = res[2];

				}
			}
			xhr.open("GET", "http://localhost:8080/ECommerce/getNotification");
			xhr.send();
		}
	});

	let home = `<div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-indicators">
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="3" aria-label="Slide 4"></button>
        </div>
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img class="ad d-block w-100" src="https://shop.barharborfoods.com/wp-content/uploads/revslider/shop_carousel/c2.jpg">
          </div>
          <div class="carousel-item">
            <img class="ad d-block w-100" src="https://mac24h.vn/images/companies/1/untitled%20folder%201/untitled%20folder/banner-watch-seri4.jpg?1537526795127">
          </div>
          <div class="carousel-item">
            <img class="ad d-block w-100" src="https://m.media-amazon.com/images/W/IMAGERENDERING_521856-T1/images/S/aplus-media/vc/69f4ac56-35d0-4645-8bbd-64be7cb7f8f6.__CR0,0,970,300_PT0_SX970_V1___.jpg">
          </div>
          <div class="carousel-item">
            <img class="ad d-block w-100" src="https://www.bajajmall.in/content/dam/emistoremarketplace/index/11-01-23/24/oneplus-brand-store/slider/OneplusBP_Slider_1_Desk_oneplusmobiles_PLP_B2B.webp">
          </div>
        </div>
        <button class="carousel-control-prev next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
          <span aria-hidden="true" class = "arrow"><i class="fa-solid fa-chevron-left fa-2xl"></i></span>
        </button>
        <button class="carousel-control-next next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
          <span aria-hidden="true" class = "arrow"><i class="fa-solid fa-chevron-right fa-2xl"></i></span>
        </button>
    </div>

    <br>

    <div class="d-flex">
        <div class="cat" onclick = "search('Mobile')">
            <img src="https://images.news18.com/ibnlive/uploads/2021/03/1615106263_iphone_11.jpg?im=Resize,width=360,aspect=fit,type=normal?im=Resize,width=320,aspect=fit,type=normal" class = "type">
            <span >Mobile</span>
        </div>
        <div class="cat" onclick = "search('Mobile Accessories')">
            <img src="https://dzp3g6fzlnblr.cloudfront.net/wp-content/uploads/2022/08/Hesh-ANC_True-Black_S6HHW-N740_Hero_v001.jpg" class = "type">
            <span >Mobile Accessories</span>
        </div>
        <div class="cat" onclick = "search('Laptop')">
            <img src="https://4.imimg.com/data4/SJ/BA/MY-3018414/apple-laptop-500x500.jpg" class = "type">
            <span >Laptops</span>
        </div>
        <div class="cat" onclick = "search('Tablets')">
	        <img src="https://assets.mspimages.in/c/tr:w-260,h-200,cm-pad_resize/16367-264-1.jpg" class="type">
	        <span>Tablets</span>
      	</div>
        
    </div>`;
	document.getElementById("searchResult").innerHTML = "";
	document.getElementById("home").innerHTML = home;
}

function searchBar(value) {

	recently_searched_brand_or_catagory = null;
	var search = document.getElementById("search").value.trim();

	if (value != null) {
		search = value;
	}

	if (search == "") {
		launch_toast("Enter the product name To Search", false);
		return;
	}
	if (search == "_") {
		launch_toast("NO Such Product Exist", false);
		return;
	}

	var searchResult = document.getElementById("searchResult");

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			let res = JSON.parse(xhr.responseText);

			if (res != null) {
				document.getElementById("home").innerHTML = "";
				searchResult.innerHTML = "";

				let accepted = 0;

				for (let i = 0; i < res.length; i++) {

					if (res[i].productQuantity > 0 && res[i].price >= min_price && res[i].price <= max_price) {
						var outer = `<div class="products">
							<img src="${res[i].url}" title = "Tap to View Review" onclick ="viewReview(${res[i].id})">
							<div class="details">
								<h5>${res[i].brandName} ${res[i].model} ${res[i].catogory} Details</h5>
							<ul>
								<li><strong>Category:</strong> ${res[i].catogory}</li>
								<li><strong>Brand:</strong> ${res[i].brandName}</li>
								<li><strong>Model:</strong> ${res[i].model}</li>
								<li><strong>Price:</strong> ${res[i].price} Rs</li>
								<li><strong>Quantity Left:</strong> ${res[i].productQuantity}</li>
							</ul>
								<h5>Description</h5>
								<p>${res[i].description}</p>
							</div>
								<button class = "wishlist" onclick = "wishlist(${res[i].id})"><i class="fa-sharp fa-solid fa-heart fa-beat fa-xs"></i> &nbsp; Wish List</button>
								<button class = "cart" onclick = "cart(${res[i].id} , ${res[i].productQuantity} )"><i class="fa-solid fa-cart-plus fa-beat fa-xs"></i> &nbsp; Cart</button>
								<button class = "decrease" onclick = "decreaseqty(${res[i].id})"><i class="fa-solid fa-minus fa-sm"></i></button>
								<span class = "quantityspan" id="${res[i].id}qty" >1</span>	
								<button class = "increase" onclick = "increaseqty(${res[i].id} , ${res[i].productQuantity})"><i class="fa-solid fa-plus fa-sm"></i></button>
							</div>`;

						searchResult.innerHTML += (outer);

						accepted++;
					}
				}
				if (accepted == 0) {
					home();
					launch_toast("No Product Available in this range", false);
				}
				recently_searched = search;
			} else {
				launch_toast("NO Such Product Exist", false);
			}
		}
	}
	xhr.open("POST", "http://localhost:8080/ECommerce/searchProduct");
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send("product=" + search + "&sort=" + sortOrder);
}

function search(search) {

	recently_searched = null;

	var searchResult = document.getElementById("searchResult");
	document.getElementById("home").innerHTML = "";

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			let res = JSON.parse(xhr.responseText);

			if (res != null) {
				searchResult.innerHTML = "";

				let accepted = 0;

				for (let i = 0; i < res.length; i++) {

					if (res[i].productQuantity > 0 && res[i].price >= min_price && res[i].price <= max_price) {
						var outer = `<div class="products">
							<img src="${res[i].url}" title = "Tap to View Review" onclick ="viewReview(${res[i].id})">
							<div class="details">
								<h5>${res[i].brandName} ${res[i].model} ${res[i].catogory} Details</h5>
							<ul>
								<li><strong>Category:</strong> ${res[i].catogory}</li>
								<li><strong>Brand:</strong> ${res[i].brandName}</li>
								<li><strong>Model:</strong> ${res[i].model}</li>
								<li><strong>Price:</strong> ${res[i].price} Rs</li>
								<li><strong>Quantity Left:</strong> ${res[i].productQuantity}</li>
							</ul>
								<h5>Description</h5>
								<p>${res[i].description}</p>
							</div>
								<button class = "wishlist" onclick = "wishlist(${res[i].id})"><i class="fa-sharp fa-solid fa-heart fa-beat fa-xs"></i> &nbsp; Wish List</button>
								<button class = "cart" onclick = "cart(${res[i].id} , ${res[i].productQuantity} )"><i class="fa-solid fa-cart-plus fa-beat fa-xs"></i> &nbsp; Cart</button>
								<button class = "decrease" onclick = "decreaseqty(${res[i].id})"><i class="fa-solid fa-minus fa-sm"></i></button>
								<span class = "quantityspan" id="${res[i].id}qty" >1</span>	
								<button class = "increase" onclick = "increaseqty(${res[i].id} , ${res[i].productQuantity})"><i class="fa-solid fa-plus fa-sm"></i></button>
							</div>`;

						searchResult.innerHTML += (outer);
						accepted++;
					}
				}
				if (accepted == 0) {
					home();
					launch_toast("No Product Available in this range", false);
				}
				recently_searched_brand_or_catagory = search;
			} else {
				launch_toast("NO Such Product Exist", false);
			}
		}
	}
	xhr.open("POST", "http://localhost:8080/ECommerce/searchProductByBrand");
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send("product=" + search + "&sort=" + sortOrder);
}

function viewReview(id) {
	let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {

			let res = JSON.parse(xhr.responseText);

			let reviews = `<div class="modal" id="view">
			<div class="modal-dialog modal-fullscreen">
			<div class="modal-content">
						
			<div class="modal-header">
			<h4 class="modal-title">Reviews</h4>
			<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
			</div>
						
			<div class="modal-body">`;

			if (res != null) {

				reviews += `<table class="table table-striped" >
						    <tr> <th>Date </th> <th>User Name </th> <th>Reviews</th> </tr>`;
				for (let a = 0; a < res.length; a++) {

					let rows = `<tr> <td>${res[a].date}</td> <td>${res[a].name}</td> <td>${res[a].message}</td> </tr>`;

					reviews += rows;
				}
				reviews += `</table>`;
			} else {
				reviews += `<span id = "noReview">No Review Has Been Updated !</span>`;
			}

			reviews += `</div>
			<div class="modal-footer">
			<button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
			</div> </div> </div> </div>`;

			document.getElementById("buyProductDetails").innerHTML = reviews;

			let modal = new bootstrap.Modal(document.getElementById("view"));
			modal.show();
		}
	}
	xhr.open("POST", "http://localhost:8080/ECommerce/viewReviews");
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send("id=" + id);
}

function decreaseqty(id) {
	let element = document.getElementById(id + "qty");

	let number = Number(element.innerText);

	if (number == 1) {
		return;
	}

	element.innerHTML = number - 1;
}

function increaseqty(id, total) {
	let element = document.getElementById(id + "qty");

	let number = Number(element.innerText);

	if (number == total || number == 10) {
		return;
	}

	element.innerHTML = number + 1;
}

function wishlist(id) {
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			let res = JSON.parse(xhr.responseText);
			if (res == -1) {
				launch_toast("Login to Add product to wishlist", false);
			} else if (!res) {
				launch_toast("Alredy Added in Wishlist", false);
			} else {
				let count = Number(document.getElementById("wishCount").innerText);
				if (count == "")
					document.getElementById("wishCount").innerText = 1;
				else
					document.getElementById("wishCount").innerText = count + 1;

				launch_toast("Added to wishlist Successfully", true);
			}
		}
	}
	xhr.open("POST", "http://localhost:8080/ECommerce/addWishlist");
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send("id=" + id);
}

function cart(id, total) {
	var xhr = new XMLHttpRequest();

	let qty = Number(document.getElementById(id + "qty").innerText);

	if (total == 0) {
		launch_toast("Out Of Stock", false);
		return;
	}
	if (qty > total) {
		launch_toast("Invalid Quantity", false);
		return;
	}

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			let res = JSON.parse(xhr.responseText);
			if (res == -1) {
				launch_toast("Login and Add product to cart", false);
			} else if (res == 1) {
				launch_toast("Product added to cart Successfully", true);
				let count = Number(document.getElementById("cartCount").innerText);
				if (count == "")
					document.getElementById("cartCount").innerText = 1;
				else
					document.getElementById("cartCount").innerText = count + 1;
			} else if (res == 2) {
				launch_toast("Product added to cart Successfully", true);
			} else {
				launch_toast("Invalid Quantity", false);
			}
		}
	}
	xhr.open("POST", "http://localhost:8080/ECommerce/addCart");
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send("id=" + id + "&qty=" + qty);
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
	setTimeout(function() { x.className = x.className.replace("show", ""); }, 6000);
}

function isUserLogedIn() {
	let promise = new Promise(
		function(resolve, reject) {

			var xhr = new XMLHttpRequest();

			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4) {
					resolve(xhr.responseText);
				}
			}
			xhr.open("GET", "http://localhost:8080/ECommerce/checkActiveUser");
			xhr.send();
		}
	);
	return promise;
}

function logout() {
	isUserLogedIn().then(function(result) {
		var res = JSON.parse(result);
		if (res) {
			document.getElementById("search").value = "";

			var xhr = new XMLHttpRequest();

			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4) {
					launch_toast("Log out Successfully", true);
					document.getElementById("wishCount").innerHTML = "";
					document.getElementById("cartCount").innerHTML = "";
					document.getElementById("orderCount").innerHTML = "";
					home();
				}
			}

			xhr.open("GET", "http://localhost:8080/ECommerce/logOut");
			xhr.send();
		} else {
			launch_toast("First Login before logout", false);
		}
	});
}

function userLogin(loginOrNewUser) {
	isUserLogedIn().then(function(result) {
		var res = JSON.parse(result);
		if (res) {
			launch_toast("Log Out and Try again", false);
			return;
		} else {
			var modal = new bootstrap.Modal(document.getElementById(loginOrNewUser));
			modal.show();
		}
	});
}

function checkUserInfo() {

	let mail = document.getElementById("lmail").value.trim();
	let pass = document.getElementById("lpass").value.trim();

	let messageLogin = document.getElementById("messageLogin");
	let loginInvalidMailId = document.getElementById("loginInvalidMailId");
	let loginInvalidPassword = document.getElementById("loginInvalidPassword");

	if (mail == "" || pass == "") {
		loginInvalidMailId.innerHTML = "";
		loginInvalidPassword.innerHTML = "";
		messageLogin.innerHTML = " Enter the Details To Proceed ";
		return;
	}
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			let res = JSON.parse(xhr.responseText);
			if (res == -2) {
				messageLogin.innerHTML = "";
				loginInvalidPassword.innerHTML = "";
				loginInvalidMailId.innerHTML = " Invalid mail id ";
			} else if (res == 500) {
				loginInvalidMailId.innerHTML = "";
				loginInvalidPassword.innerHTML = "";
				messageLogin.innerHTML = " Invalid mail id or passwrod ";
			} else if (res == 405) {
				loginInvalidMailId.innerHTML = "";
				loginInvalidPassword.innerHTML = "";
				messageLogin.innerHTML = " User alredy Loged in ";
			} else if (res == -1) {
				messageLogin.innerHTML = "";
				loginInvalidMailId.innerHTML = "";
				loginInvalidPassword.innerHTML = " Invalid Password ";
			} else {
				launch_toast("Login Successfully", true);
				document.querySelector("#login .btn-close").click();
				document.getElementById("search").value = "";

				document.getElementById("lmail").value = "";
				document.getElementById("lpass").value = "";
				messageLogin.innerHTML = "";
				loginInvalidMailId.innerHTML = "";
				loginInvalidPassword.innerHTML = "";

				home();
			}
		}
	}
	xhr.open("POST", "http://localhost:8080/ECommerce/loginVerification");
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send("mail=" + mail + "&pass=" + pass);
}

function addNewUser() {
	let name = document.getElementById("name").value.trim();
	let mail = document.getElementById("mail").value.trim();
	let password = document.getElementById("pass").value.trim();
	let password1 = document.getElementById("pass1").value.trim();


	let messageNew = document.getElementById("messageNew");
	let newInvalidPass1 = document.getElementById("newInvalidPass1");
	let newInvalidName = document.getElementById("newInvalidName");
	let newInvalidPass = document.getElementById("newInvalidPass");
	let newInvalidMailId = document.getElementById("newInvalidMailId");

	if (name == "" || mail == "" || password == "" || password1 == "") {
		newInvalidPass1.innerHTML = "";
		newInvalidName.innerHTML = "";
		newInvalidPass.innerHTML = "";
		newInvalidMailId.innerHTML = "";
		messageNew.innerHTML = " Fill the inputs to proceed ";
		return;
	}

	if (password !== password1) {
		messageNew.innerHTML = "";
		newInvalidName.innerHTML = "";
		newInvalidPass.innerHTML = "";
		newInvalidMailId.innerHTML = "";
		newInvalidPass1.innerHTML = " Miss match Password ";
		return;
	}

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			let res = JSON.parse(xhr.responseText);

			if (res == true) {
				document.getElementById("search").value = "";
				launch_toast("Account Created Successfully", true);
				document.querySelector("#newUser .btn-close").click();

				messageNew.innerHTML = "";
				newInvalidName.innerHTML = "";
				newInvalidPass.innerHTML = "";
				newInvalidMailId.innerHTML = "";
				newInvalidPass1.innerHTML = "";
				document.getElementById("name").value = "";
				document.getElementById("mail").value = "";
				document.getElementById("pass").value = "";
				document.getElementById("pass1").value = "";

				home();
			} else if (res == false) {
				newInvalidPass1.innerHTML = "";
				newInvalidName.innerHTML = "";
				newInvalidPass.innerHTML = "";
				newInvalidMailId.innerHTML = "";
				messageNew.innerHTML = " Existing User Login ";
			} else if (res == -1) {
				messageNew.innerHTML = "";
				newInvalidPass1.innerHTML = "";
				newInvalidPass.innerHTML = "";
				newInvalidMailId.innerHTML = "";
				newInvalidName.innerHTML = " Enter a valid name ";
			} else if (res == -2) {
				messageNew.innerHTML = "";
				newInvalidPass1.innerHTML = "";
				newInvalidName.innerHTML = "";
				newInvalidMailId.innerHTML = "";
				newInvalidPass.innerHTML = " Enter a valid passwrod ";
			} else if (res == -4) {
				messageNew.innerHTML = "";
				newInvalidPass1.innerHTML = "";
				newInvalidName.innerHTML = "";
				newInvalidMailId.innerHTML = "";
				newInvalidPass.innerHTML = " Space not allowed in password ";
			} else {
				messageNew.innerHTML = "";
				newInvalidPass1.innerHTML = "";
				newInvalidName.innerHTML = "";
				newInvalidPass.innerHTML = "";
				newInvalidMailId.innerHTML = " Enter a valid Email ";
			}
		}
	}
	xhr.open("POST", "http://localhost:8080/ECommerce/newUser");
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send("name=" + name + "&mail=" + mail + "&pass=" + password);
}

function viewWishlist() {

	recently_searched = null;
	recently_searched_brand_or_catagory = null;

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			let res = JSON.parse(xhr.responseText);

			if (res === false) {
				launch_toast("Login to check WishList", false);
				return;
			}

			if (res != null) {

				var searchResult = document.getElementById("searchResult");
				document.getElementById("home").innerHTML = "";

				searchResult.innerHTML = "";

				for (let i = 0; i < res.length; i++) {

					if (res[i].productQuantity == 0) {
						var outer = `<div class="products" id = "${res[i].id}id">
							<img src="${res[i].url}" title = "Tap to View Review" onclick ="viewReview(${res[i].id})">
							<div class="details">
								<h5>${res[i].brandName} ${res[i].model} ${res[i].catogory} Details</h5>
							<ul>
								<li><strong>Category:</strong> ${res[i].catogory}</li>
								<li><strong>Brand:</strong> ${res[i].brandName}</li>
								<li><strong>Model:</strong> ${res[i].model}</li>
								<li><strong>Price:</strong> ${res[i].price} Rs</li>
							</ul>
								<h5>Description</h5>
								<p>${res[i].description}</p>
							</div>
								<button class = "remove" onclick = "removeWishList(${res[i].id})"><i class="fa-solid fa-trash-can fa-beat fa-xs"></i> &nbsp;Remove</button>
								<span class = "qty text-danger" >Out Of Stock &nbsp;<i class="fa-solid fa-exclamation fa-sm"></i></span>
							</div>`;
					} else {
						var outer = `<div class="products" id = "${res[i].id}id">
							<img src="${res[i].url}" title = "Tap to View Review" onclick ="viewReview(${res[i].id})">
							<div class="details">
								<h5>${res[i].brandName} ${res[i].model} ${res[i].catogory} Details</h5>
							<ul>
								<li><strong>Category:</strong> ${res[i].catogory}</li>
								<li><strong>Brand:</strong> ${res[i].brandName}</li>
								<li><strong>Model:</strong> ${res[i].model}</li>
								<li><strong>Price:</strong> ${res[i].price} Rs</li>
								<li><strong>Quantity Left:</strong> ${res[i].productQuantity}</li>
							</ul>
								<h5>Description</h5>
								<p>${res[i].description}</p>
							</div>
								<button class = "wishlist" onclick = "removeWishList(${res[i].id})"><i class="fa-solid fa-trash-can fa-beat fa-xs"></i> &nbsp;Remove</button>
								<button class = "cart" onclick = "cart(${res[i].id} , ${res[i].productQuantity})"><i class="fa-solid fa-cart-plus fa-beat fa-xs"></i> &nbsp; Cart</button>
								<button class = "decrease" onclick = "decreaseqty(${res[i].id})"><i class="fa-solid fa-minus fa-sm"></i></button>
								<span class = "quantityspan" id="${res[i].id}qty" >1</span>	
								<button class = "increase" onclick = "increaseqty(${res[i].id} , ${res[i].productQuantity})"><i class="fa-solid fa-plus fa-sm"></i></button>
							</div>`;
					}
					searchResult.innerHTML += (outer);
				}

			} else {
				document.getElementById("home").innerHTML = "";
				let home = `<h2 id = "empty"><i class="fa-brands fa-dropbox fa-lg"></i></i>&nbsp; No Product has been added</h2>`;
				document.getElementById("searchResult").innerHTML = home;
			}
		}
	}
	xhr.open("GET", "http://localhost:8080/ECommerce/viewWishList");
	xhr.send();
}

function removeWishList(id) {
	document.getElementById(id + "id").remove();
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			launch_toast("Removed Successfully", true);
			let count = document.getElementById("wishCount").innerText;
			if (count == 1) {
				document.getElementById("wishCount").innerText = "";
			} else
				document.getElementById("wishCount").innerText = count - 1;
		}
	}
	xhr.open("POST", "http://localhost:8080/ECommerce/removeWishList");
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send("id=" + id);
}

function viewCart() {

	recently_searched = null;
	recently_searched_brand_or_catagory = null;

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			let res = JSON.parse(xhr.responseText);

			if (res === false) {
				launch_toast("Login to check Cart", false);
				return;
			}

			if (res != null) {

				var searchResult = document.getElementById("searchResult");
				document.getElementById("home").innerHTML = "";

				searchResult.innerHTML = `<button class = "buybutton" onclick = "buy()"><i class="fa-solid fa-cart-plus fa-beat fa-xs"></i> &nbsp; Buy</button>`;

				for (let i = 0; i < res.length; i++) {

					if (res[i].productQuantity == 0) {
						var outer = `<div class="products" id = "${res[i].cart_id}">
							<img src="${res[i].url}" title = "Tap to View Review" onclick ="viewReview(${res[i].id})">
							<div class="details">
								<h5>${res[i].brandName} ${res[i].model} ${res[i].catogory} Details</h5>
							<ul>
								<li><strong>Category:</strong> ${res[i].catogory}</li>
								<li><strong>Brand:</strong> ${res[i].brandName}</li>
								<li><strong>Model:</strong> ${res[i].model}</li>
								<li><strong>Price:</strong> ${res[i].price} Rs</li>
							</ul>
								<h5>Description</h5>
								<p>${res[i].description}</p>
							</div>
								<button class = "remove" onclick = "removeCart('${res[i].cart_id}' , true)"><i class="fa-solid fa-trash-can fa-beat fa-xs"></i> &nbsp;Remove</button>
								<span class = "qty" class="text-danger" ><i class="fa-solid fa-exclamation fa-sm"></i> Out Of Stock</span>	
							</div>`;
					} else {
						var outer = `<div class="products" id = "${res[i].cart_id}">
							<img src="${res[i].url}" title = "Tap to View Review" onclick ="viewReview(${res[i].id})">
							<div class="details">
								<h5>${res[i].brandName} ${res[i].model} ${res[i].catogory} Details</h5>
							<ul>
								<li><strong>Category:</strong> ${res[i].catogory}</li>
								<li><strong>Brand:</strong> ${res[i].brandName}</li>
								<li><strong>Model:</strong> ${res[i].model}</li>
								<li><strong>Price:</strong> ${res[i].price} Rs</li>
								<li><strong>Quantity Left:</strong> ${res[i].productQuantity}</li>
							</ul>
								<h5>Description</h5>
								<p>${res[i].description}</p>
							</div>
								<button class = "remove" onclick = "removeCart('${res[i].cart_id}' , true)"><i class="fa-solid fa-trash-can fa-beat fa-xs"></i> &nbsp;Remove</button>
								<button class = "decrease" onclick = "decrease(${res[i].cart_id})"><i class="fa-solid fa-minus fa-sm"></i></button>
								<span class = "quantityspan" id="${res[i].cart_id}qty" >${res[i].cart_quantity}</span>	
								<button class = "increase" onclick = "increase(${res[i].cart_id} , ${res[i].productQuantity})"><i class="fa-solid fa-plus fa-sm"></i></button>
							</div>`;
					}
					searchResult.innerHTML += (outer);
				}

			} else {
				document.getElementById("home").innerHTML = "";
				let home = `<h2 id = "empty"><i class="fa-brands fa-dropbox fa-lg"></i></i>&nbsp; No Product has been added</h2>`;
				document.getElementById("searchResult").innerHTML = home;
			}
		}
	}
	xhr.open("GET", "http://localhost:8080/ECommerce/viewCart");
	xhr.send();

}

function changeqty(id, no) {
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "http://localhost:8080/ECommerce/changeQtyInCart");
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send("id=" + id + "&no=" + no);
}

function increase(id, total) {
	let element = document.getElementById(id + "qty");

	let number = Number(element.innerText);

	if (number >= total || number >= 10) {
		launch_toast("Invalid quantity ", false);
		return;
	}

	element.innerHTML = number + 1;
	changeqty(id, 1);
}

function decrease(id) {
	let element = document.getElementById(id + "qty");

	let number = Number(element.innerText);

	if (number == 1) {
		launch_toast("Invalid quantity ", false);
		return;
	}

	element.innerHTML = number - 1;
	changeqty(id, -1);
}

function pay(amount) {

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			let res = JSON.parse(xhr.responseText);

			if (res) {
				launch_toast("Ordered Successfully", true);

				let count = Number(document.getElementById("orderCount").innerText);
				if (count == "")
					document.getElementById("orderCount").innerText = 1;
				else
					document.getElementById("orderCount").innerText = count + 1;
				document.getElementById("cartCount").innerHTML = "";
				document.querySelector("#payment .btn-close").click();
				viewOrders();
			} else {
				launch_toast("Invalid Quantity", false);
				document.querySelector("#payment .btn-close").click();
				viewCart();
			}
		}
	}
	xhr.open("POST", "http://localhost:8080/ECommerce/buyProduct");
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send("amount=" + amount);
}

function reject() {
	document.querySelector("#payment .btn-close").click();
	launch_toast("Payment Canceled", false);
}

function buy() {

	let address = `<div class="modal fade" id="address">
    <div class="modal-dialog modal-dialog-centered">
      <div class="modal-content">
  
        <div class="modal-header">
          <h4 class="modal-title">Delivery Details</h4>
          <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
        </div>
        <div class="modal-body">
        	<span id = "deliveryMessage" class= "text-danger"></span>
            <input type="number" class="form-control" id="number" placeholder="Enter Mobile NUmber">
            <span id = "deliveryNumber" class= "text-danger"></span>
            <span>10 digits</span>
        </div>
        <div class="modal-body">
            <textarea id="deliveryaddress" cols="60" rows="5" placeholder="Enter address" style="resize: none;"></textarea>
        </div>
        <div class="modal-body">
            <input type="number" class="form-control" id="pincode" placeholder="Enter Pincode">
             <span id = "deliveryPinCode" class= "text-danger"></span>
            <span>6 digits</span>
        </div>
  
        <div class="modal-footer">
          <button class = "successButton" onclick="checkExistingAddress()">Use Existing Address</button>
          <button class = "successButton" onclick="addAddress()">Submit</button>
        </div>
      </div>
    </div>
  </div>`;
	document.getElementById("buyProductDetails").innerHTML = address;

	let model = new bootstrap.Modal(document.getElementById("address"));
	model.show();
}

function removeCart(id, verify) {
	if (verify)
		document.getElementById(id).remove();

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			if (verify)
				launch_toast("Removed Successfully", true);
			let count = Number(document.getElementById("cartCount").innerText);
			if (count == 1)
				document.getElementById("cartCount").innerText = "";
			else
				document.getElementById("cartCount").innerText = count - 1;
		}
	}
	xhr.open("POST", "http://localhost:8080/ECommerce/removeCart");
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send("id=" + id);
}

function viewOrders() {

	recently_searched = null;
	recently_searched_brand_or_catagory = null;

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			let res = JSON.parse(xhr.responseText);

			if (res === false) {
				launch_toast("Login to check Orders", false);
				return;
			}

			if (res != null) {

				var searchResult = document.getElementById("searchResult");
				document.getElementById("home").innerHTML = "";

				searchResult.innerHTML = "";

				for (let i = 0; i < res.length; i++) {


					var outer = `<div id = "${res[i].orderid}" class="products1">
							<div class="details">
								<h5><strong>Order ID:</strong> ${res[i].orderid}</h5>
							<ul>
								<li><strong>Amount Paid:</strong> ${res[i].payment} Rs</li>
								<li><strong>Ordered Date:</strong> ${res[i].date}</li>
								<li><strong>Delivery Date:</strong> ${res[i].delivery_date}</li>
								<li><strong>Delivery address:</strong> ${res[i].address}</li>
								<li><strong>Pincode :</strong> ${res[i].pincode}</li>
								<li><strong>Contact Number :</strong> ${res[i].mobile_no}</li>
							</ul>
							</div>`;

					if (res[i].cancelation) {
						outer += `<button class = "cancelOrder" onclick = "cancel('${res[i].orderid}')"><i class="fa-solid fa-circle-xmark fa-beat fa-sm"></i> &nbsp;Cancel Order</button>`;
					} else {
						outer += `<button class = "cancelOrder" onclick = "removeOrder('${res[i].orderid}')"><i class="fa-solid fa-trash-can fa-beat fa-xs"></i> &nbsp;Remove</button>`
					}
					let arr = res[i].Products;

					for (let a = 0; a < arr.length; a++) {

						var inner = `<hr><div class="products">
							<img src="${arr[a].url}" title = "Tap to View Review" onclick ="viewReview(${arr[a].id})">
							<div class="details">
								<h5>${arr[a].brandName} ${arr[a].model} ${arr[a].catogory} Details</h5>
							<ul>
								<li><strong>Category:</strong> ${arr[a].catogory}</li>
								<li><strong>Brand:</strong> ${arr[a].brandName}</li>
								<li><strong>Model:</strong> ${arr[a].model}</li>
								<li><strong>Price:</strong> ${arr[a].price} Rs</li>
							</ul>
								<h5>Description</h5>
								<p>${arr[a].description}</p>
							</div>
								<button class = "remove" onclick = "addReview(${arr[a].id})" ><i class="fa-solid fa-star fa-sm"></i> &nbsp;Add Review</button>
							</div>`;

						outer += inner;
					}
					outer += `</div>`;

					searchResult.innerHTML += (outer);
				}

			} else {
				document.getElementById("home").innerHTML = "";
				let home = `<h2 id = "empty"><i class="fa-brands fa-dropbox fa-lg"></i></i>&nbsp; Empty</h2>`;
				document.getElementById("searchResult").innerHTML = home;
			}
		}
	}
	xhr.open("GET", "http://localhost:8080/ECommerce/viewOrders");
	xhr.send();
}

function addReview(id) {
	let review = `<!--Review model start -->
  <div class="modal fade" id="review">
    <div class="modal-dialog modal-dialog-centered">
      <div class="modal-content">
        <div class="modal-header">
          <h4 class="modal-title">Add Review</h4>
          <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
        </div>
        <div class="modal-body">
          <textarea id="${id}review" cols="60" rows="5" placeholder="Enter review about thr product" style="resize: none;"></textarea>
        </div>
        <div class="modal-footer">
          <button class="successButton" onclick="updateReview(${id})">Submit</button>
        </div>
      </div>
    </div>
  </div>`;

	document.getElementById("buyProductDetails").innerHTML = review;
	let modal = new bootstrap.Modal(document.getElementById("review"));
	modal.show();
}

function updateReview(id) {

	debugger;
	let message = document.getElementById(id + "review").value;

	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			launch_toast("Review Added Successfully", true);
			document.querySelector("#review .btn-close").click();
		}
	}
	xhr.open("POST", "http://localhost:8080/ECommerce/addReview");
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send("id=" + id + "&review=" + message);
}

function cancel(id) {
	let cancelation = `<div class="modal fade" id="cancelation">
    <div class="modal-dialog modal-dialog-centered">
      <div class="modal-content">
  
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">Cancelation Confirmation..</h4>
          <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
        </div>
  
        <!-- Modal body -->
        <div class="modal-body">
          You will get only 75% of Paid Amount as Refund.. <br>
          Do you Wish to cancel you order ?
          <br><br><br><br>
        </div>
  
        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" class="btn btn-danger" data-bs-dismiss="modal">No</button>
          <button type="button" class="btn btn-danger" onclick="removeOrder(${id} , true)">Yes</button>
        </div>
  
      </div>
    </div>
  </div>`;

	document.getElementById("buyProductDetails").innerHTML = cancelation;

	let model = new bootstrap.Modal(document.getElementById("cancelation"));
	model.show();

}

function removeOrder(id, value) {

	document.getElementById(id).remove();

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {

			let count = Number(document.getElementById("orderCount").innerText);
			if (count == 1)
				document.getElementById("orderCount").innerText = "";
			else
				document.getElementById("orderCount").innerText = count - 1;

			if (value) {
				document.querySelector("#cancelation .btn-close").click();
				launch_toast("Cancelled Successfully", true);
			} else {
				launch_toast("Removed Successfully", true);
			}
		}
	}
	xhr.open("POST", "http://localhost:8080/ECommerce/removeOrder");
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send("id=" + id);
}

function checkExistingAddress() {

	let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			let res = JSON.parse(xhr.responseText);
			if (res) {
				document.querySelector("#address .btn-close").click();
				getTotalAmount().then(function(result) {
					debugger;
					let total = JSON.parse(result);
					showPaymentGateway(total);
				});
			} else {
				document.getElementById("deliveryMessage").innerHTML = "There is No Existing Address";
			}
		}
	}
	xhr.open("GET", "http://localhost:8080/ECommerce/checkExistingDeliveryDetails");
	xhr.send();
}

function getTotalAmount() {
	let promise = new Promise(
		function(resolve, reject) {
			debugger;
			let xhr = new XMLHttpRequest();

			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4) {
					resolve(xhr.responseText);
				}
			}
			xhr.open("GET", "http://localhost:8080/ECommerce/getGrandTotal");
			xhr.send();
		}
	);
	return promise;
}

function showPaymentGateway(total) {
	let payment = `<div class="modal fade" id="payment">
<div class="modal-dialog modal-dialog-centered">
  <div class="modal-content">
 
	<div class="modal-header">
	  <h4 class="modal-title">Payment</h4>
	  <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
	</div>
	<div class="modal-body">
		<input type="radio" name = "gateway" id="gpay" checked = true> <i class="fa-brands fa-google-pay" ></i> G pay
	</div>
	<div class="modal-body">
		<input type="radio" name = "gateway" id="paypal"> <i class="fa-brands fa-paypal"></i> PayPal
	</div>
	<div class="modal-body">
		<input type="radio" name = "gateway" id="amazonpay"> <i class="fa-brands fa-amazon-pay"></i> Amazon Pay
	</div>
	<div class="modal-body">
		<input type="radio" name = "gateway" id="creditcard"> <i class="fa-regular fa-credit-card"></i> Credit Card
	</div>
	<div class="modal-body">
          Amount To Be Paid<input type="text" class="form-control" disabled value = "${total} .Rs">
    </div>
 
	<div class="modal-footer">
	  <button class = "successButton" onclick="reject()">Decline</button>
	  <button class = "successButton" onclick="pay(${total})">Accept</button>
	</div>
 
  </div>
</div>
</div>`;

	document.getElementById("buyProductDetails").innerHTML = payment;
	let model = new bootstrap.Modal(document.getElementById("payment"));
	model.show();
}

function addAddress() {
	let address = document.getElementById("deliveryaddress").value;
	let number = document.getElementById("number").value;
	let pincode = document.getElementById("pincode").value;

	let deliveryMessage = document.getElementById("deliveryMessage");
	let deliveryNumber = document.getElementById("deliveryNumber");
	let deliveryPinCode = document.getElementById("deliveryPinCode");
	deliveryNumber.innerHTML = "";
	deliveryPinCode.innerHTML = "";
	deliveryMessage.innerHTML = "";

	address = address.trim();

	if (address == "" || number == "" || pincode == "") {
		deliveryNumber.innerHTML = "";
		deliveryPinCode.innerHTML = "";
		deliveryMessage.innerHTML = " Fill The inputs to proceed";
		return;
	}

	if (number <= 0 || (number + "").length != 10 || (number + "").indexOf('e') != -1 || (number + "").indexOf('E') != -1) {
		deliveryPinCode.innerHTML = "";
		deliveryMessage.innerHTML = "";
		deliveryNumber.innerHTML = " Invalid Mobile number";
		return;
	}

	if (pincode <= 0 || (pincode + "").length != 6 || (pincode + "").indexOf('e') != -1 || (pincode + "").indexOf('E') != -1) {
		deliveryNumber.innerHTML = "";
		deliveryMessage.innerHTML = "";
		deliveryPinCode.innerHTML = " Invalid pincode";
		return;
	}

	let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			let res = JSON.parse(xhr.responseText);
			if (res) {
				document.querySelector("#address .btn-close").click();

				document.getElementById("deliveryaddress").value = "";
				document.getElementById("number").value = "";
				document.getElementById("pincode").value = "";
				deliveryNumber.innerHTML = "";
				deliveryPinCode.innerHTML = "";
				deliveryMessage.innerHTML = "";

				getTotalAmount().then(function(result) {
					let total = JSON.parse(result);
					showPaymentGateway(total);
				});
			} else {
				deliveryNumber.innerHTML = "";
				deliveryPinCode.innerHTML = "";
				deliveryMessage.innerHTML = " Invalid Input";
			}
		}
	}
	xhr.open("POST", "http://localhost:8080/ECommerce/addDeliveryDetails");
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send("address=" + address + "&number=" + number + "&pincode=" + pincode);
}
