document.addEventListener('DOMContentLoaded', () => {

	let donhangDtos = [];
	let donhang = document.getElementById('donhang4');
	const renderDonhang4 = () => {
		donhang.innerHTML = ''; // Xóa dữ liệu cũ trong danh sách
		donhangDtos.forEach(donhangDto => {
			let donhangHtml = `
				<div class="col-md-2 mt-2 mb-2">
					<img alt="${donhangDto.ten}" src="/image/mathang/${donhangDto.imgmathang}" class="img-fluid">
				</div>
				<div class="col-md-2 mt-2 mb-3">
					<h7> ${donhangDto.ten} </h7>
				</div>
				<div class="col-md-2 mt-2 mb-3">
					<h6>Số lượng: ${donhangDto.soluong} </h6>
				</div>
				<div class="col-md-2 mt-2 mb-3">
					<h6>Giá: ${donhangDto.gia} </h6>
				</div>
				<div class="col-md-2 mt-2 mb-3">
					<h6>Tổng tiền: ${donhangDto.tongtien} </h6>
				</div>
				
				<div class="col-md-2 mt-2 mb-3">
					<h5 class="text-danger"> ${donhangDto.trangthaidh} </h5>
				</div>
				<hr class="text-dark border-1">
			`;
			donhang.insertAdjacentHTML('beforeend', donhangHtml);
		});
	};

	const fetchDonhang4 = () => {
		fetch(`/nhanvien/donhang4`)
			.then(response => response.json())
			.then(data => {
				donhangDtos = data;
				renderDonhang4();
			})
			.catch(error => console.error('Error fetching data:', error));
	};

	document.getElementById('dahuy-tab').addEventListener('click', fetchDonhang4);
	//setInterval(fetchDonhang4, 10000);
	// Initial fetch
	fetchDonhang4();
});
