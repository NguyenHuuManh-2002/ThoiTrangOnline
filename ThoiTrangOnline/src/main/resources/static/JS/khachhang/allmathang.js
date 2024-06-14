document.addEventListener('DOMContentLoaded', () => {

	let mathangDtos = [];
	let currentPage = 1;
	const itemsPerPage = 12; // Hiển thị 12 mặt hàng mỗi trang
	let allmathang = document.getElementById('all-mathang');
	var khachhangId = document.getElementById('khachhangId').textContent;

	const renderAllMathang = () => {
		const start = (currentPage - 1) * itemsPerPage;
		const end = start + itemsPerPage;
		const paginatedItems = mathangDtos.slice(start, end);

		allmathang.innerHTML = ''; // Xóa dữ liệu cũ trong danh sách
		paginatedItems.forEach(mathangDto => {
			let mathangHtml = `
				<div class="col-md-2 col-sm-6 mb-3">
					<a href="/chitietmathang?mathang_id=${mathangDto.id}&khachhang_id=${khachhangId}"> 
						<img alt="${mathangDto.ten}" src="/image/mathang/${mathangDto.imgmathang}" class="img-fluid">
						<h6 class="mathang_ten">${mathangDto.ten}</h6>
						<h7>Giá: ${mathangDto.gia}</h7></br>
						<h7>Lượt bán: ${mathangDto.luotban}</h7>
					</a>
				</div>
			`;
			allmathang.insertAdjacentHTML('beforeend', mathangHtml);
		});

		document.getElementById('page-info').textContent = `Page ${currentPage} of ${Math.ceil(mathangDtos.length / itemsPerPage)}`;
		updatePaginationButtons();
	};

	const updatePaginationButtons = () => {
		const prevButton = document.getElementById('prev-page');
		const nextButton = document.getElementById('next-page');
		prevButton.disabled = currentPage === 1;
		nextButton.disabled = currentPage * itemsPerPage >= mathangDtos.length;
	};

	const changePage = (direction) => {
		window.scrollTo({ top: 400, behavior: 'smooth' });
		if (direction === 'prev' && currentPage > 1) {
			currentPage--;
		} else if (direction === 'next' && currentPage * itemsPerPage < mathangDtos.length) {
			currentPage++;
		}
		renderAllMathang();
	};

	const fetchAllMathang = () => {
		fetch(`/allmathang`)
			.then(response => response.json())
			.then(data => {
				mathangDtos = data;
				renderAllMathang();
			})
			.catch(error => console.error('Error fetching data:', error));
	};

	document.getElementById('prev-page').addEventListener('click', () => changePage('prev'));
	document.getElementById('next-page').addEventListener('click', () => changePage('next'));

	document.getElementById('all-tab').addEventListener('click', fetchAllMathang);

	// Initial fetch
	fetchAllMathang();
});
