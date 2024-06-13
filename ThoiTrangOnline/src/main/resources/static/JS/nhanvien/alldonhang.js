document.addEventListener('DOMContentLoaded', () => {

	let donhangDtos = [];
	let donhang = document.getElementById('showalldonhang');

	const renderAllDonhang = () => {
		donhang.innerHTML = ''; // Xóa dữ liệu cũ trong danh sách
		donhangDtos.forEach(donhangDto => {
			let trangThaiClass = "";

			// Kiểm tra giá trị của trạng thái và đặt lớp CSS tương ứng
			if (donhangDto.trangthaidh_id === 1) {
				trangThaiClass = "text-warning"; // Màu đỏ
			}else if (donhangDto.trangthaidh_id === 2) {
				trangThaiClass = "text-primary"; // Màu xanh
			}else if (donhangDto.trangthaidh_id === 3) {
				trangThaiClass = "text-success";
			}else if (donhangDto.trangthaidh_id === 4) {
				trangThaiClass = "text-danger";
			}
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
					<h5 class="${trangThaiClass}"> ${donhangDto.trangthaidh} </h5>
				</div>
				<hr class="text-dark border-1">
			`;
			donhang.insertAdjacentHTML('beforeend', donhangHtml);
		});
	};

	const fetchAllDonhang = () => {
		fetch(`nhanvien/alldonhang`)
			.then(response => response.json())
			.then(data => {
				donhangDtos = data;
				renderAllDonhang();
			})
			.catch(error => console.error('Error fetching data:', error));
	};

	document.getElementById('alldonhang-tab').addEventListener('click', fetchAllDonhang);
	//setInterval(fetchAllDonhang, 10000);
	// Initial fetch
	fetchAllDonhang();
});
