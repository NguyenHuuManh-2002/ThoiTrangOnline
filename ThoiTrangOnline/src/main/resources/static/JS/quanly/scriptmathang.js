document.addEventListener('DOMContentLoaded', () => {

	let myChartMH; // Biến để lưu trữ biểu đồ hiện tại
	let currentPage = 1;
	const itemsPerPage = 10;
	let mathangDtos = [];

	const renderTable = () => {
		const tableBodyMH = document.querySelector('#product-table tbody');
		const start = (currentPage - 1) * itemsPerPage;
		const end = start + itemsPerPage;
		const paginatedItems = mathangDtos.slice(start, end);

		tableBodyMH.innerHTML = ''; // Xóa dữ liệu cũ trong bảng
		let i = start + 1;
		paginatedItems.forEach(mathangDto => {
			const row = document.createElement('tr');
			row.innerHTML = `
            	<td class="align-middle">${i}</td>
                <td class="align-middle">${mathangDto.id}</td>
                <td class="text-start align-middle">${mathangDto.ten}</td>
                <td class="align-middle">${mathangDto.soluongtb}</td>
                <td class="align-middle">${mathangDto.tongsoluong}</td>
                <td class="align-middle">${mathangDto.tongdoanhthu}</td>                
            `;
			tableBodyMH.appendChild(row);
			i++;
		})

		document.getElementById('page-info').textContent = `Page ${currentPage} of ${Math.ceil(mathangDtos.length / itemsPerPage)}`;
	};

	const updateChart = () => {
		const sortSelect = document.getElementById('sort-select-MH');
		const sortBy = sortSelect.value;
		let url = `/mathang`;

		const month = document.getElementById('month-select-MH').value;
		const year = document.getElementById('year-select-MH').value;

		// Nếu tháng và năm không phải là "Tất cả", thêm vào URL yêu cầu
		if (month !== 'all' && year !== 'all') {
			url = `/mathangmonthyear?month=${month}&year=${year}`;
		} else if (month !== 'all' && year == 'all') {
			url = `/mathangmonth?month=${month}`;
		} else if (month == 'all' && year !== 'all') {
			url = `/mathangyear?year=${year}`;
		}

		fetch(url)
			.then(response => response.json())
			.then(data => {
				mathangDtos = data;

				if (sortBy === "id") {
					mathangDtos.sort((a, b) => a[sortBy] - b[sortBy]);
				} else {
					mathangDtos.sort((a, b) => b[sortBy] - a[sortBy]);
				}

				renderTable();
				updateChartData();
			})
			.catch(error => console.error('Error fetching data:', error));
	};

	const updateChartData = () => {
		const ten = [];
		const luotbanData = [];
		const doanhthuData = [];
		const soluongtbData = [];

		mathangDtos.forEach(mathangDto => {
			ten.push(mathangDto.ten);
			luotbanData.push(mathangDto.tongsoluong);
			doanhthuData.push(mathangDto.tongdoanhthu);
			soluongtbData.push(mathangDto.soluongtb);
		});

		if (myChartMH) {
			// Nếu biểu đồ đã tồn tại, cập nhật dữ liệu
			myChartMH.data.labels = ten;
			myChartMH.data.datasets[0].data = soluongtbData;
			myChartMH.data.datasets[1].data = luotbanData;
			myChartMH.data.datasets[2].data = doanhthuData;

			myChartMH.update();
		} else {
			const ctx = document.getElementById('salesChart').getContext('2d');
			// Nếu biểu đồ chưa được tạo, tạo mới
			myChartMH = new Chart(ctx, {
				type: 'bar',
				data: {
					labels: ten,
					datasets: [
						{
							label: 'Mặt hàng/đơn',
							data: soluongtbData,
							backgroundColor: 'yellow',
							borderColor: 'red',
							borderWidth: 1,
							yAxisID: 'y-axis-soluongtb'

						},
						{
							label: 'Lượt bán',
							data: luotbanData,
							backgroundColor: 'green',
							borderColor: 'red',
							borderWidth: 1,
							yAxisID: 'y-axis-luotban'
						},
						{
							label: 'Doanh thu',
							data: doanhthuData,
							backgroundColor: 'blue',
							borderColor: 'red',
							borderWidth: 1,
							yAxisID: 'y-axis-doanhthu'
						}
					]
				},
				options: {
					scales: {
						x: {
							display: false // Ẩn trục x
						},
						y: {
							beginAtZero: true
						}
					}
				}

			});
		}
	};

	const changePage = (direction) => {
		if (direction === 'prev' && currentPage > 1) {
			currentPage--;
		} else if (direction === 'next' && currentPage * itemsPerPage < mathangDtos.length) {
			currentPage++;
		}
		renderTable();
	};

	document.getElementById('prev-page').addEventListener('click', () => changePage('prev'));
	document.getElementById('next-page').addEventListener('click', () => changePage('next'));

	document.getElementById('mathang-tab').addEventListener('click', updateChart);
	setInterval(updateChart, 10000);
	document.getElementById('sort-select-MH').addEventListener('change', updateChart);
	document.getElementById('filter-button-MH').addEventListener('click', updateChart);
	updateChart();
});
