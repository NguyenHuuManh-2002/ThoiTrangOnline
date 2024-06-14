document.addEventListener('DOMContentLoaded', () => {

	let donhangDtos = [];
	let donhang = document.getElementById('donhang2');
	const renderDonhang2 = () => {
		donhang.innerHTML = ''; // Xóa dữ liệu cũ trong danh sách
		donhangDtos.forEach(donhangDto => {
			let donhangHtml = `
				<div class="col-md-2 mt-2 mb-2">
					<img alt="${donhangDto.ten}" src="/image/mathang/${donhangDto.imgmathang}" class="img-fluid">
				</div>
				<div class="col-md-2 mt-2 mb-3 text-start">
					<h7> ${donhangDto.ten} </h7>
				</div>
				<div class="col-md-1 mt-2 mb-3">
					<h6>Số lượng</h6>
					<h6>${donhangDto.soluong} </h6>
				</div>
				<div class="col-md-1 mt-2 mb-3">
					<h6>Giá</h6>
					<h6>${donhangDto.gia} </h6>
				</div>
				<div class="col-md-1 mt-2 mb-3">
					<h6>Tổng tiền</h6>
					<h6>${donhangDto.tongtien} </h6>
				</div>
				<div class="col-md-1 mt-2 mb-3">
					<h6>Mã KH</h6>
					<h6>${donhangDto.id_khachhang} </h6>
				</div>
				<div class="col-md-2 mt-2 mb-3">
					<h6>Ngày đặt</h6>
					<h6>${donhangDto.ngaydat} </h6>
				</div>
				
				<div class="col-md-2 mt-2 mb-3">
					<h5 class="text-primary"> ${donhangDto.trangthaidh} </h5>
				</div>
				<hr class="text-dark border-1">
			`;
			donhang.insertAdjacentHTML('beforeend', donhangHtml);
		});
	};

	const fetchDonhang2 = () => {
		fetch(`/nhanvien/donhang2`)
			.then(response => response.json())
			.then(data => {
				donhangDtos = data;
				renderDonhang2();
			})
			.catch(error => console.error('Error fetching data:', error));
	};

	document.getElementById('danggiao-tab').addEventListener('click', fetchDonhang2);
	// setInterval(fetchDonhang2, 10000);
	// Initial fetch
	fetchDonhang2();
});
