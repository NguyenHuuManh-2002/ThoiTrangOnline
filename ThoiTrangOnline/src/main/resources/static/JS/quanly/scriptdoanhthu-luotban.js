document.addEventListener('DOMContentLoaded', () => {
	let myPieChartDH;
	let myPieCharPTTT;
	
	let ptttDtos = [];
	
	const updateChart = () => {

		const doanhthuElement = document.getElementById('doanhthu');
		const sodonhangElement = document.getElementById('sodonhang');
		const somathangElement = document.getElementById('somathang');
		const ngayhientaiElement = document.getElementById('ngayhientai');
		const tiledoanhthuElement = document.getElementById('tiledoanhthu');
		const tiledonhangElement = document.getElementById('tiledonhang');
		const tilemathangElement = document.getElementById('tilemathang');

		// Gửi yêu cầu GET đến endpoint '/doanh thu'
		fetch(`/doanhthu`)
			.then(response => response.json()) // Chuyển đổi phản hồi sang JSON
			.then(data => {
				// Gán dữ liệu vào thẻ <p> sử dụng innerText hoặc innerHTML
				doanhthuElement.innerText = `${data.doanhthu} VND`;
				sodonhangElement.innerText = `${data.sodonhang}`;
				somathangElement.innerText = `${data.somathang}`;
				ngayhientaiElement.innerText = `Ngày: ${data.ngayhientai}`
				tiledoanhthuElement.innerText = `${data.tiledoanhthu}%`;
				tiledonhangElement.innerText = `${data.tilesodonhang}%`;
				tilemathangElement.innerText = `${data.tilesomathang}%`;
			})
			.catch(error => console.error('Error fetching data:', error));
	};

	const updateChart2 = () => {

		let url = `/donhang`;

		const month = document.getElementById('month-select-DH').value;
		const year = document.getElementById('year-select-DH').value;

		// Nếu tháng và năm không phải là "Tất cả", thêm vào URL yêu cầu
		if (month !== 'all' && year !== 'all') {
			url = `/donhangmonthyear?month=${month}&year=${year}`;
		} else if (month !== 'all' && year == 'all') {
			url = `/donhangmonth?month=${month}`;
		} else if (month == 'all' && year !== 'all') {
			url = `/donhangyear?year=${year}`;
		}

		fetch(url) // Sử dụng API endpoint mới để lấy dữ liệu từ máy chủ
			.then(response => response.json())
			.then(data => {

				donhangDto = data;
				const luotbanData = [donhangDto.n1, donhangDto.n2, donhangDto.n3, donhangDto.n4, donhangDto.n5, donhangDto.n6];

				if (myPieChartDH) {
					myPieChartDH.data.labels = ['Dưới 100000', 'Từ 100000-300000', 'Từ 300000-500000', 'Từ 500000-1000000', 'Từ 1000000-2000000', 'Trên 2000000'],
					myPieChartDH.data.datasets[0].data = luotbanData;
					myPieChartDH.update();
				} else {
					const ctx = document.getElementById('donhangChart').getContext('2d');
					// Nếu biểu đồ chưa được tạo, tạo mới
					myPieChartDH = new Chart(ctx, {
						type: 'pie',
						data: {
							labels: ['Dưới 100000', 'Từ 100000-300000', 'Từ 300000-500000', 'Từ 500000-1000000', 'Từ 1000000-2000000', 'Trên 2000000'],
							datasets: [
								{
									label: 'Lượt bán',
									data: luotbanData,
									backgroundColor: [
										'rgba(255, 99, 132, 0.5)',
										'rgba(54, 162, 235, 0.5)',
										'rgba(255, 206, 86, 0.5)',
										'rgba(75, 192, 192, 0.5)',
										'rgba(153, 102, 255, 0.5)',
										'rgba(255, 159, 64, 0.5)'
									],
									borderColor: [
										'rgba(255, 99, 132, 1)',
										'rgba(54, 162, 235, 1)',
										'rgba(255, 206, 86, 1)',
										'rgba(75, 192, 192, 1)',
										'rgba(153, 102, 255, 1)',
										'rgba(255, 159, 64, 1)'
									],
									borderWidth: 1
								}]
						}, // <-- Dấu hai chấm thay vì dấu chấm phẩy
						options: {
							responsive: false,
							title: {
								display: true,
								text: 'Biểu đồ tròn luợt bán theo nhóm'
							}
						}
					});
				}
			});
		};
		
		
		const updateChart3 = () => {

		let url = `/pttt`;

		const month = document.getElementById('month-select-PTTT').value;
		const year = document.getElementById('year-select-PTTT').value;

		// Nếu tháng và năm không phải là "Tất cả", thêm vào URL yêu cầu
		if (month !== 'all' && year !== 'all') {
			url = `/ptttmonthyear?month=${month}&year=${year}`;
		} else if (month !== 'all' && year == 'all') {
			url = `/ptttmonth?month=${month}`;
		} else if (month == 'all' && year !== 'all') {
			url = `/ptttyear?year=${year}`;
		}

		fetch(url) // Sử dụng API endpoint mới để lấy dữ liệu từ máy chủ
			.then(response => response.json())
			.then(data => {

				ptttDtos = data;
				const ten = [];
				const luotbanData = [];
				
				ptttDtos.forEach(ptttDto =>{
					ten.push(ptttDto.ten);
					luotbanData.push(ptttDto.soluongdon);
				});

				if (myPieCharPTTT) {
					myPieCharPTTT.data.labels = ten,
					myPieCharPTTT.data.datasets[0].data = luotbanData;
					myPieCharPTTT.update();
				} else {
					const ctx = document.getElementById('ptttChart').getContext('2d');
					// Nếu biểu đồ chưa được tạo, tạo mới
					myPieCharPTTT = new Chart(ctx, {
						type: 'pie',
						data: {
							labels: ten,
							datasets: [
								{
									label: 'Lượt bán',
									data: luotbanData,
									backgroundColor: [
										'rgba(255, 99, 132, 0.5)',
										'rgba(54, 162, 235, 0.5)',
										'rgba(255, 206, 86, 0.5)'
										
									],
									borderColor: [
										'rgba(255, 99, 132, 1)',
										'rgba(54, 162, 235, 1)',
										'rgba(255, 206, 86, 1)'
									
									],
									borderWidth: 1
								}]
						}, // <-- Dấu hai chấm thay vì dấu chấm phẩy
						options: {
							responsive: false,
							title: {
								display: true,
								text: 'Biểu đồ tròn luợt bán theo nhóm'
							}
						}
					});
				}
			});
		};
	updateChart3();	
	updateChart2();
	updateChart();
	setInterval(updateChart3, 10000);
	setInterval(updateChart, 10000);
	setInterval(updateChart2, 10000);
	document.getElementById('filter-button-DH').addEventListener('click', updateChart2);
	document.getElementById('filter-button-PTTT').addEventListener('click', updateChart3);
	document.getElementById('home-tab').addEventListener('click', updateChart);
	document.getElementById('home-tab').addEventListener('click', updateChart2);
	document.getElementById('home-tab').addEventListener('click', updateChart3);
});