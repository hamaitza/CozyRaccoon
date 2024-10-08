const buttonbuy = document.querySelector(".btn-buy");
const payment = document.querySelector(".payment");
const close = document.querySelector(".close");

let cart = document.querySelector(".cart");

let temp = localStorage.getItem("data");
cart.innerHTML = temp;
let cartIcon = document.querySelector("#cart-icon");
let closeCart = document.querySelector("#close-cart");
const close2 = document.querySelector(".close");

close2.onclick = () => {
    payment.classList.remove("active");

}

cartIcon.onclick = () => {
    cart.classList.add("active");
}

closeCart.onclick = () => {
    cart.classList.remove("active");
}

let temp2 = localStorage.getItem("product-img");
let temp3 = localStorage.getItem("product-title");
let temp4 = localStorage.getItem("product-price");
let temp5 = localStorage.getItem("product-price-offer");


document.getElementsByClassName("product-title")[0].innerText = temp3;
document.getElementsByClassName("sale-price")[0].innerText = temp4;
document.getElementsByClassName("product-image-main")[0].src = temp2;
if(temp5 != 0){
    document.getElementsByClassName("sale-price")[0].classList.add("active");
}
else{
        document.getElementsByClassName("sale-price")[0].classList.remove("active");
}
document.getElementsByClassName("offer-price")[0].innerText = temp5;




if(document.readyState == 'loading'){
    document.addEventListener('DOMContentLoaded', ready);
}else{
    ready();
}

function ready(){
    
    var removeCartButtons = document.getElementsByClassName("cart-remove");
    for(var i = 0; i < removeCartButtons.length; i++){
        var button = removeCartButtons[i];
        button.addEventListener('click', removeCartItem);
    }
    
    var quantityInputs = document.getElementsByClassName("cart-quantity");
    for(var i = 0; i < quantityInputs.length; i++){
        var input = quantityInputs[i];
        input.addEventListener("change", quantityChange);
    }

    var addCart = document.getElementsByClassName("add-cart");
    for(var i = 0; i < addCart.length; i++){
        var add = addCart[i];
        add.addEventListener("click", addCartClicked);
    }
}

function removeCartItem(event){

    var buttonClicked = event.target;
    buttonClicked.parentElement.remove();
    updateTotal();
    localStorage.setItem("data", cart.innerHTML);
}

function quantityChange(event){
    var input = event.target;
    if(isNaN(input.value) || input.value <=0){
        input.value = 1;
    }
    updateTotal();
    localStorage.setItem("data", cart.innerHTML);
}

function addCartClicked(event){
    var button = event.target;
    var offer = parseFloat(document.getElementsByClassName("offer-price")[0].innerText.replace("$", ""));
    var title = document.getElementsByClassName("product-title")[0].innerText;
    var price = parseFloat(document.getElementsByClassName("sale-price")[0].innerText.replace("$", ""));
    if(!isNaN(offer) && offer < price)
        price = offer;
    var productImg = document.getElementsByClassName("product-image-main")[0].src;
    var quantitytemp = document.getElementsByClassName("cart-q-2")[0];
    addProductToCart(title, price, productImg, quantitytemp.value);
    updateTotal();
}

function addProductToCart(title, price, productImg, quantitytemp){
    var cartShopBox = document.createElement("div");
    cartShopBox.classList.add("cart-box");
    var cartItems = document.getElementsByClassName("cart-content")[0];
    var cartItemsNames = cartItems.getElementsByClassName("cart-product-title");
    for(var i = 0; i < cartItemsNames.length; i++){
        if(cartItemsNames[i].innerText == title){
            alert("This item is already in the cart !");
            return;
        }
        
    }

    var cartBoxContent = `
    <img src="${productImg}" alt="" class="cart-img">
                        <div class="detail-box">
                            <div class="cart-product-title" style="color: black"> ${title} </div>
                            <div class="cart-price" style="color: black;">$${price}</div>
                            <input type="number" value="${quantitytemp}" class="cart-quantity">
                        </div>
                        <i class="bx bxs-trash-alt cart-remove"></i>
   `;

   cartShopBox.innerHTML = cartBoxContent;
   cartItems.append(cartShopBox);
   cartShopBox.getElementsByClassName("cart-remove")[0].addEventListener('click', removeCartItem);
   cartShopBox.getElementsByClassName("cart-quantity")[0].addEventListener('change', quantityChange);
   updateTotal();
   localStorage.setItem("data", cart.innerHTML);
}

function updateTotal(){
    
    var cartContent = document.getElementsByClassName("cart-content")[0];
    var cartBoxes = cartContent.getElementsByClassName("cart-box");
    var total = 0;

    for(var i = 0; i < cartBoxes.length; i++){
        var cartBox = cartBoxes[i];
        var priceElement = cartBox.getElementsByClassName("cart-price")[0];
        var quantityElement = cartBox.getElementsByClassName("cart-quantity")[0];
        var price = parseFloat(priceElement.innerText.replace("$", ""));
        var quantity = quantityElement.value;
        total = total + (price * quantity);
    }
    document.getElementsByClassName("total-price")[0].innerText = "$" + total;
    console.log(cart);
}


let orderbtn2 = document.getElementsByClassName("payButton")[0];

orderbtn2.onclick = () => {
    getGreeting();
    payment.classList.remove("active");
    cart.classList.remove("active");
}

function getGreeting() {
    
    // nr prod, prod [pr1: {nume, pret},  ...], nume/prenume, telefon, adresa mail, adresa
    let cartItems2 = document.getElementsByClassName("cart-content")[0];
    let cartBoxes2= cartItems2.getElementsByClassName("cart-box");

    var object = new Object();
    object.nrprod = cartBoxes2.length;
    for(var i = 0; i < cartBoxes2.length; i++){
        var cartBox2 = cartBoxes2[i];
        var price2 = cartBox2.getElementsByClassName("cart-price")[0];
        var prod = cartBox2.getElementsByClassName("cart-product-title")[0];
        object["prod" + i] = prod.innerText;
        object["pret" + i] = parseFloat(price2.innerText.replace("$","")).toFixed(2);
    }
    let namesur = document.getElementsByClassName("payinputName")[0];
    let nrtlf = document.getElementsByClassName("payinputNmbr")[0];
    let email = document.getElementsByClassName("payinputmail")[0];
    let adrs = document.getElementsByClassName("payinputadrs")[0];
    object.name = namesur.value;
    object.nrtlf = nrtlf.value;
    object.email = email.value;
    object.adrs = adrs.value;

    fetch("http://192.168.1.243:8080/generateBill", {
        method: "POST",
        headers: {'Content-Type': 'application/json'}, 
        body: JSON.stringify(object)
      }).then(res => {
        console.log("Request complete! response:", res);
      });

   
}

let products = document.querySelectorAll(".product-img");
products.forEach((item, index) => {
    item.addEventListener("click", () => {
        console.log("sdadas");
        let temp = item.parentElement;
        localStorage.setItem("product-img", item.src);
        localStorage.setItem("product-title", temp.getElementsByClassName("product-title")[0].innerText);
        localStorage.setItem("product-price", temp.getElementsByClassName("price")[0].innerText);
        localStorage.setItem("product-price-offer", temp.getElementsByClassName("offer-price")[0].innerText);
        window.location.replace("product.html");   
    });
  });


  let orderbtn = document.querySelector(".btn-buy");

  orderbtn.onclick = () => {
      
      payment.classList.add("active");
      
  }