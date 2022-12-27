function displayNow() {
    name = document.getElementById('name').value;
    phone = document.getElementById('phone').value;
    address = document.getElementById('address').value;
    document.getElementById('order_name').textContent = name;
    document.getElementById('order_phone').textContent = phone;
    document.getElementById('order_address').textContent = address;
    var quantity =  document.querySelectorAll('fieldset input');
    var item = document.getElementsByClassName('price');
    var max_quantity = document.querySelectorAll('table.details tr:nth-of-type(2) td:nth-of-type(2)');
    console.log(max_quantity[0].textContent);
    var money = 0;
    for (let i = 0; i < item.length; i++) {
        var num = "";
        for (let j = item[i].innerHTML.length; j > 0; j--) {
            if (item[i].innerHTML.charAt(j) != " ") {
                num = item[i].innerHTML.charAt(j) + num;
            }
            else {
                break;
            }
        }
        money = money + parseInt(num)*parseInt(quantity[i].value);
        document.querySelectorAll('fieldset input')[i].setAttribute('max', max_quantity[i].textContent);
    }
    document.getElementById('order_pay').textContent = money;
}
