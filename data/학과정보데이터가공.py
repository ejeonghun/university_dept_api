import csv

# 지역명과 ID를 매핑합니다.
region_mapping = {"강원": 1, "경기": 2, "경남": 3, "경북": 4, "광주": 5, "대구": 6, "대전": 7, "부산": 8, "서울": 9, "세종": 10, "울산": 11, "인천": 12, "전남": 13, "전북": 14, "충남": 15, "충북": 16}

# 학교와 학과를 저장할 딕셔너리를 생성합니다.
univ_dict = {}

# CSV 파일을 엽니다.
with open('학과정보.csv', 'r', encoding='utf-8') as f:
    reader = csv.reader(f)
    next(reader)  # 헤더를 건너뜁니다.
    for row in reader:
        if row[1] in ["대학", "전문대학"] and row[3] in region_mapping and "폐지" not in row[11]:
            if row[5] not in univ_dict:
                univ_dict[row[5]] = {"region_id": region_mapping[row[3]], "depts": set()}
            univ_dict[row[5]]["depts"].add(row[8])

# .sql 파일을 생성합니다.
with open('insert.sql', 'w', encoding='utf-8') as f:
    for univ_name, univ_info in univ_dict.items():
        f.write(f"INSERT INTO univ (univ_name, region_id) VALUES ('{univ_name}', {univ_info['region_id']});\n")
        for dept_name in univ_info["depts"]:
            f.write(f"INSERT INTO dept (univ_id, dept_name) SELECT univ_id, '{dept_name}' FROM univ WHERE univ_name = '{univ_name}';\n")
