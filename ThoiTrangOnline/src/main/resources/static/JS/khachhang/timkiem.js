document.addEventListener('DOMContentLoaded', () => {
	let mathangDtos = [];
	let ketQua = document.getElementById('ketQua');
	var khachhangId = document.getElementById('khachhangId').textContent;
	ketQua.innerHTML = '';
	
	const renderKetQua = () => {
		ketQua.innerHTML = '';
		const ten = document.getElementById('key').value; // Cập nhật giá trị của ten ở đây
		let ketQuaTimKiem = '';
		mathangDtos.forEach(mathangDto => {
			let ketQuaHtml =
				`
	            <div class="col-md-2 col-sm-6 mb-3">
	                <a href="/chitietmathang?mathang_id=${mathangDto.id}&khachhang_id=${khachhangId}"> 
	                    <img alt="${mathangDto.ten}" src="/image/mathang/${mathangDto.imgmathang}" class="img-fluid">
	                    <h6 class="mathang_ten">${mathangDto.ten}</h6>
	                    <h7>Giá: ${mathangDto.gia}</h7></br>
	                    <h7>Lượt bán: ${mathangDto.luotban}</h7>
	                </a>
	            </div>
	        `;
			ketQuaTimKiem += ketQuaHtml; // Thêm HTML của mỗi mặt hàng vào biến ketQuaTimKiem
		});
		

		// Sau khi vòng lặp kết thúc, chèn nội dung của ketQuaTimKiem vào ketQua
		let ketquaTitle =
			`
        <div class="title boder-bottom">
            <strong class="text-white bg-primary py-1 px-1">
                Kết quả tìm kiếm theo từ khóa "${ten}" </strong>
            <div class="remove-button" style="margin-left: 10px;  display: inline;">
        		<button class="btn btn-danger" onclick="XoaKetQua()">Xóa kết quả tìm kiếm</button>
    		</div>  
        </div>
        <div class="timkiem-list py-3">
            <div id="timkiem" class="row">
                ${ketQuaTimKiem}
            </div>
        </div> 
        <hr class="text-danger border-2">   
    `;
		ketQua.insertAdjacentHTML('beforeend', ketquaTitle);
	};
	const timKiemMatHang = () => {
		const ten = document.getElementById('key').value; // Cập nhật giá trị của ten ở đây
		if (ten !== "") {
			const url = "/timkiem?key=" + ten;
			fetch(url)
				.then(response => response.json())
				.then(data => {
					mathangDtos = data;
					renderKetQua();
				})
				.catch(error => console.error('Error fetching data:', error));
		}
	};
	
	document.getElementById('timKiemBtn').addEventListener('click', timKiemMatHang);
});
	const XoaKetQua =() => {
		ketQua.innerHTML = '';
	};