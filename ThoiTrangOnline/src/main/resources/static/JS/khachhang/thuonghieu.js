document.addEventListener('DOMContentLoaded', () => {

	let thuonghieuDtos = [];
	let thuonghieu = document.getElementById('allthuonghieu');
	var khachhangId = document.getElementById('khachhangId').textContent;
	const renderThuongHieu = () => {
		thuonghieu.innerHTML = ''; // Xóa dữ liệu cũ trong danh sách
		thuonghieuDtos.forEach(thuonghieuDto => {
			let thuonghieuHtml = `
				<div class="col-md-2 col-sm-4 col-6 mb-3 thuonghieu-card">
					<a href="/allmathangthuonghieu?khachhang_id=${khachhangId}&thuonghieu_id=${thuonghieuDto.id}"> 
						<img alt="${thuonghieuDto.ten}" src="/image/thuonghieu/${thuonghieuDto.imgthuonghieu}" class="img-fluid">
						<h6 class="thuonghieu_ten d-flex justify-content-center">${thuonghieuDto.ten}</h6>
					</a>
				</div>
			`;
			thuonghieu.insertAdjacentHTML('beforeend', thuonghieuHtml);
		});
	};

	const fetchThuongHieu = () => {
		fetch(`/thuonghieu`)
			.then(response => response.json())
			.then(data => {
				thuonghieuDtos = data;
				renderThuongHieu();
			})
			.catch(error => console.error('Error fetching data:', error));
	};

	document.getElementById('thuonghieu-tab').addEventListener('click', fetchThuongHieu);

	// Initial fetch
	fetchThuongHieu();
});
