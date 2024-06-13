document.addEventListener('DOMContentLoaded', () => {
	let myChartDM; // Biến để lưu trữ biểu đồ hiện tại

	const updateChart = () => {

		const sortSelect = document.getElementById('sort-select-DM');
		const sortBy = sortSelect.value;

		let url = `/danhmuctk`;

		const month = document.getElementById('month-select-DM').value;
		const year = document.getElementById('year-select-DM').value;

		// Nếu tháng và năm không phải là "Tất cả", thêm vào URL yêu cầu
		if (month !== 'all' && year !== 'all') {
			url = `/danhmucmonthyear?month=${month}&year=${year}`;
		} else if (month !== 'all' && year == 'all') {
			url = `/danhmucmonth?month=${month}`;
		} else if (month == 'all' && year !== 'all') {
			url = `/danhmucyear?year=${year}`;
		}


		fetch(url) // Sử dụng API endpoint mới để lấy dữ liệu từ máy chủ
			.then(response => response.json())
			.then(data => {

				danhmucDtos = data;
				if (sortBy === "id") {
					danhmucDtos.sort((a, b) => a[sortBy] - b[sortBy]);
				}
				else {
					danhmucDtos.sort((a, b) => b[sortBy] - a[sortBy]);
				}
				const tableBodyDM = document.querySelector('#category-table tbody');

				const ten = [];
				const luotbanData = [];
				const doanhthuData = [];

				tableBodyDM.innerHTML = ''; // Xóa dữ liệu cũ trong bảng
				let i = 1;
				danhmucDtos.forEach(danhmucDto => {

					const row = document.createElement('tr');
					row.innerHTML = `
                    	<td>${i}</td>
                       	<td>${danhmucDto.id}</td>
                       	<td>${danhmucDto.ten}</td>
                       	<td>${danhmucDto.tongsoluong}</td>
                       	<td>${danhmucDto.tongdoanhthu}</td>  
                    `;
					i++;
					tableBodyDM.appendChild(row);
					ten.push(danhmucDto.ten);
					luotbanData.push(danhmucDto.tongsoluong);
					doanhthuData.push(danhmucDto.tongdoanhthu);
				});


				if (myChartDM) {
					// Nếu biểu đồ đã tồn tại, cập nhật dữ liệu
					myChartDM.data.labels = ten;
					myChartDM.data.datasets[0].data = luotbanData;
					myChartDM.data.datasets[1].data = doanhthuData;
					myChartDM.update();
				} else {
					const ctx = document.getElementById('danhmucChart').getContext('2d');
					// Nếu biểu đồ chưa được tạo, tạo mới
					myChartDM = new Chart(ctx, {
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
									yAxisID: 'y-axis-tongsoluong'
								},
								{
									label: 'Doanh thu',
									data: doanhthuData,
									backgroundColor: 'blue',
									borderColor: 'red',
									borderWidth: 1,
									yAxisID: 'y-axis-tongdoanhthu'
								}
							]
						},						
					});
				}
			})
			.catch(error => console.error('Error fetching data:', error));
	};

	// Gọi hàm cập nhật biểu đồ khi trang được tải và khi tab "Danh mục" được nhấp
	document.getElementById('danhmuc-tab').addEventListener('click', updateChart);
	setInterval(updateChart, 10000); // 5000 ms = 5 giây
	document.getElementById('sort-select-DM').addEventListener('change', updateChart);
	document.getElementById('filter-button-DM').addEventListener('click', updateChart);
	updateChart(); // Gọi hàm cập nhật biểu đồ ngay khi trang được tải
});
