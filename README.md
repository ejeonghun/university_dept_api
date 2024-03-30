## 대학교 학과 정보 API
<div align=center>
<img src="https://img.shields.io/badge/springboot 3.2.4-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"> 
<img src="https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=Docker&logoColor=white">
<img src="https://img.shields.io/badge/python-3776AB?style=for-the-badge&logo=python&logoColor=white">
<img src="https://img.shields.io/badge/mysql 8.0.29-4479A1?style=for-the-badge&logo=mysql&logoColor=white"> 
</div>

### API로 원하는 대학의 학과 리스트의 결과를 반환이 가능한 API



univcert API 사용 시 조금 더 추가적인 기능이 필요해서 ([공공데이터 - 한국대학교육협의회_대학알리미 대학별 학과정보_20230614](https://www.data.go.kr/data/15014632/fileData.do))의 데이터를 
Python으로 데이터 가공을 하여 DB에 삽입하였음

다음 업데이트 예정일 : 2024-06-14

## API 기능
### 지역 조회
```
GET https://univapi.lunaweb.dev/api/region/list
```
![image](https://github.com/ejeonghun/university_dept_api/assets/41509711/c7b85003-a86c-4b43-b4f2-ed261bf74bd1)
> regionId : 지역 코드값 , regionName : 지역 이름


### 지역별 대학 리스트
```
GET https://univapi.lunaweb.dev/api/univ/list?region=지역명
```
![image](https://github.com/ejeonghun/university_dept_api/assets/41509711/5a9ac9ff-25b2-4ba5-9009-b7d284a49ea5)
> univId : 학교 코드값 , univName : 학교 이름 , regionId : 지역 코드값 , univLogoUrl : 학교 로고


### 대학 학과 리스트
```
GET https://univapi.lunaweb.dev/api/univ/dept?univ_id=234
```
![image](https://github.com/ejeonghun/university_dept_api/assets/41509711/1156a85c-51c1-4125-acf4-7924b014e1ca)
> univInfo : 학교 정보 , deptId : 학과 코드 , univId : 학교 코드 , deptName : 학과 이름

#### [API 명세서](https://https://univapi.lunaweb.dev/swagger-ui/index.html)


## DB ERD
![image](https://github.com/ejeonghun/university_dept_api/assets/41509711/f254da7f-350b-433f-af61-edba9ecc1d84)
