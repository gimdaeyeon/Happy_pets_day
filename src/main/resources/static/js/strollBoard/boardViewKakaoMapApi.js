let mapContainer = document.getElementById('map'), // 지도를 표시할 div
    mapOption = {
        center: new kakao.maps.LatLng(boardLat, boardLng), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

let map = new kakao.maps.Map(mapContainer, mapOption);

// 마커가 표시될 위치
let markerPosition = new kakao.maps.LatLng(boardLat, boardLng);

// 마커를 생성
let marker = new kakao.maps.Marker({
    position: markerPosition
});

// 마커가 지도 위에 표시되도록 설정
marker.setMap(map);

// 커스텀 오버레이에 표출될 내용
let content = '<div class="customoverlay">' +
    `  <a href="https://map.kakao.com/link/map/${place},${boardLat}, ${boardLng}" target="_blank">` +
    `    <span class="title">산책 날짜 : ${date}  <br/> 모임장소 : ${place}</span>` +
    '  </a>' +
    '</div>';

// 커스텀 오버레이가 표시될 위치
let position = new kakao.maps.LatLng(boardLat, boardLng);

// 커스텀 오버레이를 생성
let customOverlay = new kakao.maps.CustomOverlay({
    map: map,
    position: position,
    content: content,
    yAnchor: 1
});