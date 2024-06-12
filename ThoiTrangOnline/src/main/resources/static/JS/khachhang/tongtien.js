document.addEventListener('DOMContentLoaded', () => {


	const tinhtien = () => {
		let tongtienHtml = document.getElementById('tongtien');
		let giaban = parseInt(document.getElementById('giaban').innerText);
		let soluong = parseInt(document.getElementById('soluong').value);
		let tongtien = giaban * soluong;
		tongtienHtml.innerHTML = 
		`
		<h4>Tổng tiền:</h4>	&nbsp;&nbsp;&nbsp; 
		<h2 class="text-danger"> ${tongtien} Vnd</h2>
		`
		console.log(giaban);
	};
	document.getElementById('soluong').addEventListener('input', tinhtien);

	tinhtien();
});
