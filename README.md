# 팀명 : NPE 단속반

# 프로젝트 이름 : happy-pets-day - Spring Boot Project

## 📚프로젝트 주제 

반려동물에 관련된 서비스들을 이용하고 정보를 얻을 수 있는 사이트   
1. 반려동물 추천
2. **산책 메이트 만들기**
3. 펫 시터 예약 및, 펫 시터 지원
4. 서울시에 있는 유기동물에 대한 정보
5. **챗봇**을 통한 사이트 문의

## 목차
- [팀명 : NPE 단속반](#팀명--npe-단속반)
- [프로젝트 이름 : happy-pets-day - Spring Boot Project](#프로젝트-이름--happy-pets-day---spring-boot-project)
  - [📚프로젝트 주제](#프로젝트-주제)
  - [목차](#목차)
  - [팀 구성](#팀-구성)
  - [ERD구성](#erd구성)
  - [Tools](#tools)
  - [나의 작업](#나의-작업)
    - [산책 게시판 글 작성 및 수정  기능소개 WIKI로 이동](#산책-게시판-글-작성-및-수정--기능소개-wiki로-이동)
    - [산책 게시판 리스트 기능소개 WIKI로 이동](#산책-게시판-리스트-기능소개-wiki로-이동)
    - [산책 게시판 글 보기 기능소개 WIKI로 이동](#산책-게시판-글-보기-기능소개-wiki로-이동)
    - [산책 게시판 댓글 기능소개 WIKI로 이동](#산책-게시판-댓글-기능소개-wiki로-이동)
    - [메인화면 조건에 따른 게시글 노출 기능소개 WIKI로 이동](#메인화면-조건에-따른-게시글-노출-기능소개-wiki로-이동)
    - [챗봇 기능소개 WIKI로 이동](#챗봇-기능소개-wiki로-이동)
    - [AOP 활용 실행속도 측정 어노테이션 기능소개 WIKI로 이동](#aop-활용-실행속도-측정-어노테이션-기능소개-wiki로-이동)
    - [커스텀 에러페이지 기능소개 WIKI로 이동](#커스텀-에러페이지-기능소개-wiki로-이동)
    - [Interceptor활용 회원 세션검사 기능소개 WIKI로 이동](#interceptor활용-회원-세션검사-기능소개-wiki로-이동)

## 팀 구성

|팀장|이건희|           
|:--:|:--:|
|**부팀장**|**김대연**| 
|팀원|박광인| 
|팀원|서지민| 
|팀원|조상수| 
|팀원|이정현|

## ERD구성

<details>
<summary>ERD이미지</summary>

[![NPE단속반 erd구성](./src/main/resources/static/img/Spring_Erd.png)](https://dbdiagram.io/d/647f4f07722eb774947ee12c)

</details>

 ## Tools
- **Java**
- **Spring Boot**
- **Intellij**
- **Mybatis**
- **Oracle**

## 나의 작업

### 산책 게시판 글 작성 및 수정 <a href="https://github.com/gimdaeyeon/happy_pets_day/wiki/%EC%82%B0%EC%B1%85-%EA%B2%8C%EC%8B%9C%ED%8C%90-%EA%B8%80-%EC%9E%91%EC%84%B1-%EB%B0%8F-%EC%88%98%EC%A0%95"> 기능소개 WIKI로 이동</a>
- 같이 산책 나갈 대표 반려동물 선택
- 산책 날짜 선택(DatePicker)
- 모임장소 검색 및 선택(카카오지도Api)

<a href="https://github.com/gimdaeyeon/happy_pets_day/wiki/%EC%82%B0%EC%B1%85-%EA%B2%8C%EC%8B%9C%ED%8C%90-%EA%B8%80-%EC%9E%91%EC%84%B1-%EB%B0%8F-%EC%88%98%EC%A0%95"> 
 <img src="https://postfiles.pstatic.net/MjAyMzA4MDJfMTYx/MDAxNjkwOTQ5MTY5NzE4.frpd021Y49mnOixxx1MYTmdrq6DxUBwiX5Vt2ZqjMEIg.73elE9Iu_Hudk0qQ5yOwTLVgpq5aVMdRs_cbKnV9jvwg.GIF.rlaeodus1306/%EC%9E%91%EC%84%B1.gif?type=w580" width="500">
</a>

### 산책 게시판 리스트<a href="https://github.com/gimdaeyeon/happy_pets_day/wiki/%EC%82%B0%EC%B1%85-%EA%B2%8C%EC%8B%9C%ED%8C%90-%EB%A6%AC%EC%8A%A4%ED%8A%B8"> 기능소개 WIKI로 이동</a>
- 리스트에 보여줄 내용 가져오기
- 페이징 처리 (비동기)
- 게시글 검색 (아이디, 제목, 지역 3가지 조건으로 검색)

<a href="https://github.com/gimdaeyeon/happy_pets_day/wiki/%EC%82%B0%EC%B1%85-%EA%B2%8C%EC%8B%9C%ED%8C%90-%EB%A6%AC%EC%8A%A4%ED%8A%B8"> 
 <img src="https://postfiles.pstatic.net/MjAyMzA4MDJfMjAy/MDAxNjkwOTU2ODI5MjQx.LHCyCmG-zfXfw_p4XKIAjgsc0O5-sGet3jbEclPO0Esg.7tMPJ68E5kIyQutSYMGIP5-N8E-ekY--S7Mf6XDqhmMg.GIF.rlaeodus1306/%EA%B2%8C%EC%8B%9C%EA%B8%80%EB%A6%AC%EC%8A%A4%ED%8A%B81.gif?type=w580" width="500">
</a>

### 산책 게시판 글 보기<a href="https://github.com/gimdaeyeon/happy_pets_day/wiki/%EC%82%B0%EC%B1%85-%EA%B2%8C%EC%8B%9C%ED%8C%90-%EA%B8%80-%EB%B3%B4%EA%B8%B0"> 기능소개 WIKI로 이동</a>
- 카카오지도로 설정한 장소 지도로 띄우기 및 커스텀 마커로 정보 보여주기
- 카카오맵 url연결로 해당 장소 카카오맵으로 바로 길 찾기 가능
- 게시글 수정, 삭제

<a href="https://github.com/gimdaeyeon/happy_pets_day/wiki/%EC%82%B0%EC%B1%85-%EA%B2%8C%EC%8B%9C%ED%8C%90-%EA%B8%80-%EB%B3%B4%EA%B8%B0"> 
 <img src="https://postfiles.pstatic.net/MjAyMzA4MDJfMTY2/MDAxNjkwOTU1NTczMzQ1.hsV1p_eLlEXjpquZmI8klCv46YDsh4Z4wjAWWV0cF2og.KkOmv5kMnsXfIktidSF8uV0YKmiVMbZWBfGVN-OECyMg.GIF.rlaeodus1306/%EA%B2%8C%EC%8B%9C%EA%B8%80%EB%B3%B4%EA%B8%B03.gif?type=w580" width="500">
</a>

### 산책 게시판 댓글<a href="https://github.com/gimdaeyeon/happy_pets_day/wiki/%EC%82%B0%EC%B1%85-%EA%B2%8C%EC%8B%9C%ED%8C%90-%EB%8C%93%EA%B8%80"> 기능소개 WIKI로 이동</a>
- 댓글 리스트 띄우기 및 페이징 처리 (비동기)
- 댓글 날짜(1분 전, 1시간 전, 1일 전 형식으로 띄우기)
- 댓글 수정, 삭제

<a href="https://github.com/gimdaeyeon/happy_pets_day/wiki/%EC%82%B0%EC%B1%85-%EA%B2%8C%EC%8B%9C%ED%8C%90-%EB%8C%93%EA%B8%80"> 
 <img src="https://postfiles.pstatic.net/MjAyMzA4MDJfMTEy/MDAxNjkwOTU3NjMwNDY5.CLFAAMZtE1MwFJKlz85AifEaqPsRQsGuH5OlWN_zGqkg.z-NGtCeoLXaexDAgOBknqy2TcWn22W9Dr1HJDJ53Y7Ug.GIF.rlaeodus1306/%EA%B2%8C%EC%8B%9C%EA%B8%80%EB%8C%93%EA%B8%80.gif?type=w580" width="500">
</a>

### 메인화면 조건에 따른 게시글 노출<a href="https://github.com/gimdaeyeon/happy_pets_day/wiki/%EB%A9%94%EC%9D%B8%ED%99%94%EB%A9%B4%EC%97%90%EC%84%9C-%EC%A1%B0%EA%B1%B4%EC%97%90-%EB%94%B0%EB%A5%B8-%EA%B2%8C%EC%8B%9C%EA%B8%80-%EB%85%B8%EC%B6%9C"> 기능소개 WIKI로 이동</a>
- 로그인 되어있지 않으면 최신 게시글 3개
- 로그인 되어있을 경우 회원의 주소와 모임장소의 행정 구역과 일치하는 게시글 3개 조회(서울시 강남구)
- 만약 조회한 게시글의 수가 3개 이하라면 시 단위로 검색 후 추가 (서울시)
- 그래도 조회한 게시글의 수가 3개 이하라면 최신게시글에서 조회 후 추가

<a href="https://github.com/gimdaeyeon/happy_pets_day/wiki/%EB%A9%94%EC%9D%B8%ED%99%94%EB%A9%B4%EC%97%90%EC%84%9C-%EC%A1%B0%EA%B1%B4%EC%97%90-%EB%94%B0%EB%A5%B8-%EA%B2%8C%EC%8B%9C%EA%B8%80-%EB%85%B8%EC%B6%9C"> 
 <img src="https://postfiles.pstatic.net/MjAyMzA4MTJfMjY2/MDAxNjkxODUyMzI5ODg1.I1y2iQ4CqNQOuRbhhEix4OmOOTvf5ZZ2SFyFE30QQIEg.T6cu57x-OgBHSpCa3Tg5CnVjqKzJAaoVNa6zsHt9mnMg.PNG.rlaeodus1306/%EB%A9%94%EC%9D%B8_%EC%82%B0%EC%B1%85%EB%AA%A8%EC%9E%84%EA%B2%8C%EC%8B%9C%ED%8C%90.png?type=w580" width="500">
</a>

### 챗봇<a href="https://github.com/gimdaeyeon/happy_pets_day/wiki/%EC%B1%97%EB%B4%87"> 기능소개 WIKI로 이동</a>
- **ChatGPT Api 사용**
- 대화내용 세션스토리지에 저장
(로그인 상태동안 대화내용 유지)

<a href="https://github.com/gimdaeyeon/happy_pets_day/wiki/%EC%B1%97%EB%B4%87"> 
 <img src="https://postfiles.pstatic.net/MjAyMzA4MDJfMTE5/MDAxNjkwOTU4ODg4MDA4.XvL7qVfxLklAV9t5TkQ7N_Sz7qfcTUrl5v4YKO4pDt4g.lWw09ROgC7XeMeuHBYwHcMYxyOpmY070-sWiYnTom-kg.GIF.rlaeodus1306/%EC%B1%97%EB%B4%87.gif?type=w580" width="500">
</a>

### AOP 활용 실행속도 측정 어노테이션<a href="https://github.com/gimdaeyeon/happy_pets_day/wiki/AOP%ED%99%9C%EC%9A%A9-%EC%8B%A4%ED%96%89%EC%86%8D%EB%8F%84-%EC%B8%A1%EC%A0%95-%EC%96%B4%EB%85%B8%ED%85%8C%EC%9D%B4%EC%85%98"> 기능소개 WIKI로 이동</a>

<a href="https://github.com/gimdaeyeon/happy_pets_day/wiki/AOP%ED%99%9C%EC%9A%A9-%EC%8B%A4%ED%96%89%EC%86%8D%EB%8F%84-%EC%B8%A1%EC%A0%95-%EC%96%B4%EB%85%B8%ED%85%8C%EC%9D%B4%EC%85%98"> 
 <img src="https://postfiles.pstatic.net/MjAyMzA4MTJfMjQz/MDAxNjkxODUyMzQ3OTA1.RBHF83xRhNoiNDW-4mrCvy7M7DxVrP5UShhnoxedUhsg.alPjBfuggcRipOF8SKZ2fRhvhdyjTxguDGLum7bLwocg.PNG.rlaeodus1306/Untitled_(3).png?type=w580" width="500">
</a>

### 커스텀 에러페이지<a href="https://github.com/gimdaeyeon/happy_pets_day/wiki/%EC%BB%A4%EC%8A%A4%ED%85%80-%EC%97%90%EB%9F%AC%ED%8E%98%EC%9D%B4%EC%A7%80"> 기능소개 WIKI로 이동</a>

<a href="https://github.com/gimdaeyeon/happy_pets_day/wiki/%EC%BB%A4%EC%8A%A4%ED%85%80-%EC%97%90%EB%9F%AC%ED%8E%98%EC%9D%B4%EC%A7%80"> 
 <img src="https://postfiles.pstatic.net/MjAyMzA4MTJfMjk1/MDAxNjkxODUyMzY2OTUz.or9inuAqE4fZeZaXzz44u4I5ZVo-rgLLmEwB6c3WVrUg.uyU3P3reKXM7WeQKg05sorxFLGuThmsXWgH8U_Bn1hYg.PNG.rlaeodus1306/Untitled_(4).png?type=w580" width="500">
</a>



### Interceptor활용 회원 세션검사<a href="https://github.com/gimdaeyeon/happy_pets_day/wiki/Interceptor%ED%99%9C%EC%9A%A9-%ED%9A%8C%EC%9B%90-%EC%84%B8%EC%85%98%EA%B2%80%EC%82%AC"> 기능소개 WIKI로 이동</a>



