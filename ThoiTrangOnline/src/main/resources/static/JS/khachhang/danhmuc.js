document.addEventListener('DOMContentLoaded', () => {

	let danhmucDtos = [];
	let danhmuc = document.getElementById('alldanhmuc');
	var khachhangId = document.getElementById('khachhangId').textContent;
	const renderDanhMuc = () => {
		danhmuc.innerHTML = ''; // Xóa dữ liệu cũ trong danh sách
		danhmucDtos.forEach(danhmucDto => {
			let danhmucHtml = `
				<div class="col-md-2 col-sm-4 col-6 mb-3">
					<a href="/allmathangdanhmuc?khachhang_id=${khachhangId}&danhmuc_id=${danhmucDto.id}"> 
						<img alt="${danhmucDto.ten}" src="/image/danhmuc/${danhmucDto.imgdanhmuc}" class="img-fluid">
						<h6 class="danhmuc_ten d-flex justify-content-center">${danhmucDto.ten}</h6>
					</a>
				</div>
			`;
			danhmuc.insertAdjacentHTML('beforeend', danhmucHtml);
		});
	};

	const fetchDanhmuc = () => {
		fetch(`/danhmuc`)
			.then(response => response.json())
			.then(data => {
				danhmucDtos = data;
				renderDanhMuc();
			})
			.catch(error => console.error('Error fetching data:', error));
	};

	document.getElementById('danhmuc-tab').addEventListener('click', fetchDanhmuc);

	// Initial fetch
	fetchDanhmuc();
});
