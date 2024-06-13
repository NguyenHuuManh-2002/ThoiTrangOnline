document.addEventListener('DOMContentLoaded', () => {


	let myChartTH; // Biến để lưu trữ biểu đồ hiện tại

	const updateChart = () => {
		const sortSelect = document.getElementById('sort-select-TH');
		const sortBy = sortSelect.value;

		let url = `/thuonghieutk`;

		const month = document.getElementById('month-select-TH').value;
		const year = document.getElementById('year-select-TH').value;

		// Nếu tháng và năm không phải là "Tất cả", thêm vào URL yêu cầu
		if (month !== 'all' && year !== 'all') {
			url = `/thuonghieumonthyear?month=${month}&year=${year}`;
		} else if (month !== 'all' && year == 'all') {
			url = `/thuonghieumonth?month=${month}`;
		} else if (month == 'all' && year !== 'all') {
			url = `/thuonghieuyear?year=${year}`;
		}

		fetch(url)
			.then(response => response.json())
			.then(data => {
				thuonghieuDtos = data;

				if (sortBy === "id") {
					thuonghieuDtos.sort((a, b) => a[sortBy] - b[sortBy]);
				}
				else {
					thuonghieuDtos.sort((a, b) => b[sortBy] - a[sortBy]);
				}

				const tableBodyTH = document.querySelector('#thuonghieu-table tbody');

				const ten = [];
				const luotbanData = [];
				const doanhthuData = [];

				tableBodyTH.innerHTML = ''; // Xóa dữ liệu cũ trong bảng
				let i = 1;

				thuonghieuDtos.forEach(thuonghieuDto => {
					const row = document.createElement('tr');
					row.innerHTML = `
                    	<td>${i}</td>
                        <td>${thuonghieuDto.id}</td>
                        <td>${thuonghieuDto.ten}</td>
                        <td>${thuonghieuDto.tongsoluong}</td>
                        <td>${thuonghieuDto.tongdoanhthu}</td>                        
                    `;
					i++;
					tableBodyTH.appendChild(row);
					ten.push(thuonghieuDto.ten);
					luotbanData.push(thuonghieuDto.tongsoluong);
					doanhthuData.push(thuonghieuDto.tongdoanhthu);
				});


				if (myChartTH) {
					// Nếu biểu đồ đã tồn tại, cập nhật dữ liệu
					myChartTH.data.labels = ten;
					myChartTH.data.datasets[0].data = luotbanData;
					myChartTH.data.datasets[1].data = doanhthuData;
					myChartTH.update();
				} else {
					const ctx = document.getElementById('thuonghieuChart').getContext('2d');
					// Nếu biểu đồ chưa được tạo, tạo mới
					myChartTH = new Chart(ctx, {
						type: 'bar',
						data: {
							labels: ten,
							datasets: [
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
					});
				}

			})
			.catch(error => console.error('Error fetching data:', error));
	};

	// Gọi hàm cập nhật biểu đồ khi trang được tải và khi tab "Mặt hàng" được nhấp
	document.getElementById('thuonghieu-tab').addEventListener('click', updateChart);
	setInterval(updateChart, 10000); // 5000 ms = 5 giây
	document.getElementById('sort-select-TH').addEventListener('change', updateChart);
	document.getElementById('filter-button-TH').addEventListener('click', updateChart);
	updateChart(); // Gọi hàm cập nhật biểu đồ ngay khi trang được tải
});