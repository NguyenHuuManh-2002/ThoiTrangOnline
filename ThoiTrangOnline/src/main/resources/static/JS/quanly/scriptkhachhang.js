document.addEventListener('DOMContentLoaded', () => {
	
	let currentPage = 1;
	const itemsPerPage = 10;
	let khachhangDtos = [];
	
	const renderTable = () => {
		const tableBodyKH = document.querySelector('#khachhang-table tbody');
		const start = (currentPage - 1) * itemsPerPage;
		const end = start + itemsPerPage;
		const paginatedItems = khachhangDtos.slice(start, end);

		tableBodyKH.innerHTML = ''; // Xóa dữ liệu cũ trong bảng
		let i = start + 1;
		paginatedItems.forEach(khachhangDto => {
			const row = document.createElement('tr');
			row.innerHTML = `
            	<td>${i}</td>
                <td>${khachhangDto.id}</td>
                <td>${khachhangDto.ten}</td>
                <td>${khachhangDto.tongdonhang}</td>
                <td>${khachhangDto.tongmathang}</td>
                <td>${khachhangDto.somathangtb}</td>
                <td>${khachhangDto.giatridontb}</td>
                <td>${khachhangDto.tongchitieu}</td>                
            `;
			tableBodyKH.appendChild(row);
			i++;
		})

		document.getElementById('page-info-KH').textContent = `Page ${currentPage} of ${Math.ceil(khachhangDtos.length / itemsPerPage)}`;
	};
	
	const updateChart = () => {
		const sortSelect = document.getElementById('sort-select-KH');
		const sortBy = sortSelect.value;
		let url = `/khachhang`;

		const month = document.getElementById('month-select-KH').value;
		const year = document.getElementById('year-select-KH').value;

		// Nếu tháng và năm không phải là "Tất cả", thêm vào URL yêu cầu
		if (month !== 'all' && year !== 'all') {
			url = `/khachhangmonthyear?month=${month}&year=${year}`;
		} else if (month !== 'all' && year == 'all') {
			url = `/khachhangmonth?month=${month}`;
		} else if (month == 'all' && year !== 'all') {
			url = `/khachhangyear?year=${year}`;
		}

		fetch(url)
			.then(response => response.json())
			.then(data => {
				khachhangDtos = data;

				if (sortBy === "id") {
					khachhangDtos.sort((a, b) => a[sortBy] - b[sortBy]);
				} else {
					khachhangDtos.sort((a, b) => b[sortBy] - a[sortBy]);
				}

				renderTable();
			})
			.catch(error => console.error('Error fetching data:', error));
	};
	
	
	
	const changePage = (direction) => {
		if (direction === 'prev' && currentPage > 1) {
			currentPage--;
		} else if (direction === 'next' && currentPage * itemsPerPage < khachhangDtos.length) {
			currentPage++;
		}
		renderTable();
	};
	document.getElementById('prev-page-KH').addEventListener('click', () => changePage('prev'));
	document.getElementById('next-page-KH').addEventListener('click', () => changePage('next'));

	document.getElementById('khachhang-tab').addEventListener('click', updateChart);
	setInterval(updateChart, 10000); 
	document.getElementById('sort-select-KH').addEventListener('change', updateChart);
	document.getElementById('filter-button-KH').addEventListener('click', updateChart);
	updateChart();
});
