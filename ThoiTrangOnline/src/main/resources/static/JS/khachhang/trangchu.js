document.addEventListener('DOMContentLoaded', () => {

	let mathangDtos = [];
	let mathangbanchay = document.getElementById('topbanchay');
	let mathangmoi = document.getElementById('mathangmoi');
	let mathanggoiy = document.getElementById('goiy');
	var khachhangId = document.getElementById('khachhangId').textContent;
	
	const renderMatHangBanChay = () => {
		mathangbanchay.innerHTML = ''; // Xóa dữ liệu cũ trong danh sách
		mathangDtos.forEach(mathangDto => {
			let mathangbanchayHtml = `
				<div class="col-md-2 col-sm-6 mb-3">
					<a href="/chitietmathang?mathang_id=${mathangDto.id}&khachhang_id=${khachhangId}">  
						<img alt="${mathangDto.ten}" src="/image/mathang/${mathangDto.imgmathang}" class="img-fluid">
						<h6 class="mathang_ten">${mathangDto.ten}</h6>
						<h7>Giá: ${mathangDto.gia}</h7></br>
						<h7>Lượt bán: ${mathangDto.luotban}</h7>
					</a>
				</div>
			`;
			mathangbanchay.insertAdjacentHTML('beforeend', mathangbanchayHtml);
		});
	};

	const fetchMatHangBanChay = () => {
		fetch(`/mathangbanchay`)
			.then(response => response.json())
			.then(data => {
				mathangDtos = data;
				renderMatHangBanChay();
			})
			.catch(error => console.error('Error fetching data:', error));
	};
	
	
	const renderMatHangMoi = () => {
		mathangmoi.innerHTML = ''; // Xóa dữ liệu cũ trong danh sách
		mathangDtos.forEach(mathangDto => {
			let mathangmoiHtml = `
				<div class="col-md-2 col-sm-6 mb-3">
					<a href="/chitietmathang?mathang_id=${mathangDto.id}&khachhang_id=${khachhangId}"> 
						<img alt="${mathangDto.ten}" src="/image/mathang/${mathangDto.imgmathang}" class="img-fluid">
						<h6 class="mathang_ten">${mathangDto.ten}</h6>
						<h7>Giá: ${mathangDto.gia}</h7></br>
						<h7>Lượt bán: ${mathangDto.luotban}</h7>
					</a>
				</div>
			`;
			mathangmoi.insertAdjacentHTML('beforeend', mathangmoiHtml);
		});
	};

	const fetchMatHangMoi = () => {
		fetch(`/mathangmoi`)
			.then(response => response.json())
			.then(data => {
				mathangDtos = data;
				renderMatHangMoi();
			})
			.catch(error => console.error('Error fetching data:', error));
	};
	
	
	const renderMatHangGoiY = () => {
		mathanggoiy.innerHTML = ''; // Xóa dữ liệu cũ trong danh sách
		mathangDtos.forEach(mathangDto => {
			let mathanggoiyHtml = `
				<div class="col-md-2 col-sm-6 mb-3">
					<a href="/chitietmathang?mathang_id=${mathangDto.id}&khachhang_id=${khachhangId}"> 
						<img alt="${mathangDto.ten}" src="/image/mathang/${mathangDto.imgmathang}" class="img-fluid">
						<h6 class="mathang_ten">${mathangDto.ten}</h6>
						<h7>Giá: ${mathangDto.gia}</h7></br>
						<h7>Lượt bán: ${mathangDto.luotban}</h7>
					</a>
				</div>
			`;
			mathanggoiy.insertAdjacentHTML('beforeend', mathanggoiyHtml);
		});
	};

	const fetchMatHangGoiY = () => {
		fetch(`/mathanggoiy`)
			.then(response => response.json())
			.then(data => {
				mathangDtos = data;
				renderMatHangGoiY();
			})
			.catch(error => console.error('Error fetching data:', error));
	};

	document.getElementById('home-tab').addEventListener('click', fetchMatHangBanChay);
	document.getElementById('home-tab').addEventListener('click', fetchMatHangMoi);
	document.getElementById('home-tab').addEventListener('click', fetchMatHangGoiY);
	
	fetchMatHangBanChay();
	fetchMatHangMoi();
	fetchMatHangGoiY();
});
