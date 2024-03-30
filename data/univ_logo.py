import csv
import mysql.connector

# MySQL 연결 설정
cnx = mysql.connector.connect(user='root', password='1234',
                              host='127.0.0.1',
                              database='univ')

cursor = cnx.cursor()

# Univ 테이블에서 데이터 조회
query = ("SELECT univ_id, univ_name FROM univ")
cursor.execute(query)

# Univ 테이블의 모든 행을 딕셔너리로 저장
univ_dict = {row[1]: row[0] for row in cursor}

# 텍스트 파일 열기
with open('update_statements.txt', 'w') as f:
    # CSV 파일 열기
    with open(r'C:\Users\wjdgn\Desktop\univ_logos-main\university_dept_api\img\univ_logos.csv', 'r', encoding='UTF-8') as csv_file:
        reader = csv.DictReader(csv_file)
        for row in reader:
            # Univ 테이블의 univ_name과 일치하는지 확인
            for univ_name, univ_id in univ_dict.items():
                if univ_name.startswith(row['name']):
                    # 일치하면, UPDATE 문을 텍스트 파일에 기록
                    update_statement = f"UPDATE univ SET univ_logo_url = '{row['path']}' WHERE univ_id = {univ_id};\n"
                    f.write(update_statement)

# 연결 종료
cursor.close()
cnx.close()
