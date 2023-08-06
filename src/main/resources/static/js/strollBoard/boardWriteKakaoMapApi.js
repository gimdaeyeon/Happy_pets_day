// 지도를 표시할 div와 초기 환경 설정
const mapContainer = document.getElementById('map');
const mapOption = {
    center: new kakao.maps.LatLng(37.49947087294, 127.0358208842),
    level: 3
};

// 지도 생성
const map = new kakao.maps.Map(mapContainer, mapOption);

// 주소-좌표 변환 객체와 장소 검색 객체 생성
const geocoder = new kakao.maps.services.Geocoder();
const ps = new kakao.maps.services.Places();

// 마커와 인포윈도우 생성
const marker = new kakao.maps.Marker();
const infowindow = new kakao.maps.InfoWindow({zindex: 1});

// 현재 지도 중심좌표로 주소를 검색해서 지도 좌측 상단에 표시
searchAddrFromCoords(map.getCenter(), displayCenterInfo);

// 지도를 클릭했을 때의 이벤트 리스너
kakao.maps.event.addListener(map, 'click', function (mouseEvent) {
    // 클릭한 위치의 좌표로 주소를 검색
    searchDetailAddrFromCoords(mouseEvent.latLng, function (result, status) {
        let address = result[0].address.address_name;
        let addressTokens = address.split(" ");

        // 검색이 성공적으로 수행되지 않으면 이 함수를 빠져나감
        if (status !== kakao.maps.services.Status.OK) return;

        // 마커설정 및 인포윈도우에 주소 표시
        let detailAddr = !!result[0].road_address ? `<div>도로명주소 : ${result[0].road_address.address_name}</div>` : '';
        detailAddr += `<div>지번 주소 : ${result[0].address.address_name}</div>`;

        const content = `<div class="bAddr">
                            <span class="title">법정동 주소정보</span>
                            ${detailAddr}
                        </div>`;

        marker.setPosition(mouseEvent.latLng);
        marker.setMap(map);

        infowindow.setContent(content);
        infowindow.open(map, marker);

        let lat = mouseEvent.latLng.getLat();
        let lng = mouseEvent.latLng.getLng();

        $('.marker-lat').val(lat);
        $('.marker-lng').val(lng);


    });
});

// 지도가 이동하면 새로운 중심 좌표에 대한 주소를 검색
kakao.maps.event.addListener(map, 'idle', function () {
    searchAddrFromCoords(map.getCenter(), displayCenterInfo);
});

// 주어진 좌표로부터 주소를 검색하는 함수
function searchAddrFromCoords(coords, callback) {
    geocoder.coord2RegionCode(coords.getLng(), coords.getLat(), callback);
}

// 주어진 좌표로부터 상세 주소를 검색하는 함수
function searchDetailAddrFromCoords(coords, callback) {
    geocoder.coord2Address(coords.getLng(), coords.getLat(), callback);
}

// 지도 중심의 주소 정보를 화면에 표시하는 함수
function displayCenterInfo(result, status) {
    if (status !== kakao.maps.services.Status.OK) return;  // 조기 반환

    const infoDiv = document.getElementById('centerAddr');

    for (let i = 0; i < result.length; i++) {
        if (result[i].region_type === 'H') {
            let hjjs = result[i].address_name.split(" ", 2);    // 행정주소

            console.log("행정주소 : " + hjjs[0] + " " + hjjs[1]);
            $('.administrative-district').val(hjjs[0] + " " + hjjs[1]);

            break;
        }
    }
}

// 장소 검색 결과를 처리하는 콜백 함수
function placesSearchCB(data, status, pagination) {
    // 검색이 성공적으로 수행되지 않으면 이 함수를 빠져나감
    if (status !== kakao.maps.services.Status.OK) return;

    const place = data[0];
    const latLng = new kakao.maps.LatLng(place.y, place.x);
    marker.setPosition(latLng);
    marker.setMap(map);

    $('.marker-lat').val(latLng.getLat());
    $('.marker-lng').val(latLng.getLng());

    searchDetailAddrFromCoords(latLng, function (result, status) {
        if (status !== kakao.maps.services.Status.OK) return;  // 조기 반환

        let detailAddr = !!result[0].road_address ? `<div class="detail-addr">도로명주소 : ${result[0].road_address.address_name}</div>` : '';
        detailAddr += `<div class="detail-addr">지번 주소 : ${result[0].address.address_name}</div>`;

        const content = `<div class="bAddr">
                            <span class="title">법정동 주소정보</span>
                            ${detailAddr}
                        </div>`;

        infowindow.setContent(content);
        infowindow.open(map, marker);


    });
    map.setCenter(latLng);
}

//엔터키로 글 작성 막기
$('.board-form').on('keyup keypress', function (e) {
    if (e.code == 'Enter') {
        e.preventDefault();
        return false;
    }
})

// 검색버튼 지도 검색
$('.search-btn').on('click', mapSearch);

// input칸 엔터 이벤트
$('.search-input').on('keypress', function (e) {
    if (e.code == 'Enter' && $('.search-input').val().length > 0) {
        mapSearch();
    }
});

// 검색 실행
function mapSearch() {
    let keyword = $('.search-input').val();
    ps.keywordSearch(keyword, placesSearchCB);
}

















